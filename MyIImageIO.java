/**
 * @author wu
 */

import imagereader.IImageIO;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *  a <code>MyIImageIO</code> to read image and
 *  write image
 */

public class MyIImageIO implements IImageIO {
  private static final int XFF = 0xff;
  private static final int BIT_IMAGE_HEAD_LENGTH = 14;
  private static final int BIT_IMAGE_INFO_LENGTH = 40;
  private static final int TRUE_COLOR = 24;

  @Override
  public Image myRead(String filePath) throws IOException {
    // pixels, width, height, bitCount for the read image
    int[] pixels;
    int imageWidth;
    int imageHeight;
    int bitCount;
    FileInputStream fs = null;
    fs = new FileInputStream(filePath);

    //avoid a null file input stream
    if (fs == null) {
      throw new IOException("filePath == null");
    }

    //read bit image head
    byte[] bitImageHead = new byte[BIT_IMAGE_HEAD_LENGTH];
    fs.read(bitImageHead, 0, BIT_IMAGE_HEAD_LENGTH);

    //read bit image information
    byte[] bitImageInfo = new byte[BIT_IMAGE_INFO_LENGTH];
    fs.read(bitImageInfo, 0, BIT_IMAGE_INFO_LENGTH);

    //get width height and bitCount
    imageWidth = ((int)bitImageInfo[4] & XFF) |
            (((int)bitImageInfo[5] & XFF) << 8) |
            (((int)bitImageInfo[6] & XFF) << 16) |
            (((int)bitImageInfo[7] & XFF) << 24);
    imageHeight = ((int)bitImageInfo[8] & XFF) |
             (((int)bitImageInfo[9] & XFF) << 8) |
             (((int)bitImageInfo[10] & XFF) << 16) |
             (((int)bitImageInfo[11] & XFF) << 24);
    bitCount = ((int)bitImageInfo[14] & XFF) |
               (((int)bitImageInfo[15] & XFF) << 8);

    pixels = new int[imageHeight * imageWidth];
    //just for 24bit image
    if (bitCount == TRUE_COLOR) {

      //getPixels
      int widthBytes = (int)Math.floor((imageWidth * bitCount + 31) / 32) * 4;
      int coverBytes = widthBytes - (imageWidth * 3);
      byte rgbStream[] = new byte[(widthBytes * imageHeight)];
      fs.read(rgbStream, 0, (widthBytes * imageHeight));
      int rgbIndex = 0;
      int pixelIndex = 0;
      for (int h = 0; h < imageHeight; h++) {
        for (int w = 0; w < imageWidth; w++) {
          pixelIndex = imageWidth * (imageHeight - h - 1) + w;
          pixels[pixelIndex] = ((255 & 0xff) << 24)
                        | (((int) rgbStream[rgbIndex + 2] & XFF) << 16)
                        | (((int) rgbStream[rgbIndex + 1] & XFF) << 8)
                        | (int) rgbStream[rgbIndex] & XFF;
          rgbIndex = rgbIndex + 3;
        }
        rgbIndex = rgbIndex + coverBytes;
      }
    }

    //close file input stream
    if (fs != null) {
      fs.close();
    }

    return (Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(imageWidth, imageHeight, pixels, 0, imageWidth)));
  }

  public Image myWrite(Image image, String filePath) throws IOException {
    File outFile = new File(filePath);
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
    bufferedImage.getGraphics().drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);

    ImageIO.write(bufferedImage, "BMP", outFile);
    return image;
  }
}
