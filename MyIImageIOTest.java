import java.awt.Image;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.io.IOException;

public class MyIImageIOTest {

  private static final String GOAL_PATH = "/home/12330388/Downloads/ss2014/stage03/ImageReader/bmptest/goal/";
  private static final String MY_PATH = "/home/12330388/Downloads/ss2014/stage03/ImageReader/bmptest/myResult/";
  private MyIImageIO myIImageIO;

  @Before
  public void setUp() throws Exception {
    System.out.print("set up\n");
    myIImageIO = new MyIImageIO();
    System.out.print("start...\n");
  }

  @Test
  public void redChanelForBmp1() throws IOException {
    System.out.print("Red chanel test for bmp1\n");
    String goalPath = GOAL_PATH + "1_red_goal.bmp";
    String myPath = MY_PATH + "1_red.bmp";

    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Red-Bmp-1_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Red-Bmp-1_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Red-Bmp-1_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }

  @Test
  public void greenChanelForBmp1() throws IOException {
    System.out.print("Green chanel test for bmp1\n");
    String goalPath = GOAL_PATH + "1_green_goal.bmp";
    String myPath = MY_PATH + "1_green.bmp";

    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Green-Bmp-1_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Green-Bmp-1_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Green-Bmp-1_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }

  @Test
  public void blueChanelForBmp1() throws IOException {
    System.out.print("Blue chanel test for bmp1\n");
    String goalPath = GOAL_PATH + "1_blue_goal.bmp";
    String myPath = MY_PATH + "1_blue.bmp";

    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Blue-Bmp-1_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Blue-Bmp-1_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Blue-Bmp-1_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }

  @Test
  public void grayChanelForBmp1() throws IOException {
    System.out.print("Gray chanel test for bmp1\n");
    String goalPath = GOAL_PATH + "1_gray_goal.bmp";
    String myPath = MY_PATH + "1_gray.bmp";
    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Gray-Bmp-1_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Gray-Bmp-1_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Gray-Bmp-1_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }


  @Test
  public void redChanelForBmp2() throws IOException {
    System.out.print("Red chanel test for bmp2\n");
    String goalPath = GOAL_PATH + "2_red_goal.bmp";
    String myPath = MY_PATH + "2_red.bmp";

    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Red-Bmp-2_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Red-Bmp-2_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Red-Bmp-2_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }

  @Test
  public void greenChanelForBmp2() throws IOException {
    System.out.print("Green chanel test for bmp2\n");
    String goalPath = GOAL_PATH + "2_green_goal.bmp";
    String myPath = MY_PATH + "2_green.bmp";

    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Green-Bmp-2_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Green-Bmp-2_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Green-Bmp-2_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }

  @Test
  public void blueChanelForBmp2() throws IOException {
    System.out.print("Blue chanel test for bmp2\n");
    String goalPath = GOAL_PATH + "2_blue_goal.bmp";
    String myPath = MY_PATH + "2_blue.bmp";

    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Blue-Bmp-2_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Blue-Bmp-2_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Blue-Bmp-2_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }

  @Test
  public void grayChanelForBmp2() throws IOException {
    System.out.print("Gray chanel test for bmp2\n");
    String goalPath = GOAL_PATH + "2_gray_goal.bmp";
    String myPath = MY_PATH + "2_gray.bmp";

    Image goalImage = myIImageIO.myRead(goalPath);
    Image myImage = myIImageIO.myRead(myPath);

    int goalHeight = goalImage.getHeight(null);
    int goalWidth = goalImage.getWidth(null);
    int myHeight = myImage.getHeight(null);
    int myWidth = myImage.getWidth(null);

    assertEquals("Gray-Bmp-2_false: goalHeight != myHeight", goalHeight, myHeight);
    assertEquals("Gray-Bmp-2_false: goalWidth != myWidth", goalHeight, myHeight);

    int[] goalPixels = new int[goalHeight * goalWidth];
    int[] myPixels = new int[myHeight * myWidth];
    BufferedImage bufferedImage = new BufferedImage(goalWidth, goalHeight, BufferedImage.TYPE_INT_RGB);

    bufferedImage.getGraphics().drawImage(goalImage, 0, 0, goalWidth, goalHeight, null);
    bufferedImage.getRGB(0, 0, goalWidth, goalHeight, goalPixels, 0, goalWidth);

    bufferedImage.getGraphics().drawImage(myImage, 0, 0, myWidth, myHeight, null);
    bufferedImage.getRGB(0, 0, myWidth, myHeight, myPixels, 0, myWidth);

    for (int i = 0; i < myWidth * myHeight; i++) {
      assertEquals("Gray-Bmp-2_false: pixels differ", goalPixels[i], myPixels[i]);
    }
  }
}
