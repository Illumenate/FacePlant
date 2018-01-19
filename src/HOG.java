
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
 
public class HOG
{
   public static void main( String[] args )
   {
      /*System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
      Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
      System.out.println( "mat = " + mat.dump() );*/
      /*
      Mat img = Imgcodecs.imread("bolt.png");
      img.convertTo(img, CvType.CV_32F, 1/255.0);
       
      // Calculate gradients gx, gy
      Mat gx, gy; 
      Imgproc.filter2D(img, gx, CvType.CV_32F, 1, 0, 1);
      Sobel(img, gy, CvType.CV_32F, 0, 1, 1);
      // C++ Calculate gradient magnitude and direction (in degrees)
      Mat mag, angle; 
      cartToPolar(gx, gy, mag, angle, 1); 
      */
      
      /*try {
          int kernelSize = 9;
          System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
          
          Mat source = Imgcodecs.imread("grayscale.jpg",  Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
          Mat destination = new Mat(source.rows(),source.cols(),source.type());
          
          Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
             {
                put(0,0,-1);
                put(0,1,0);
                put(0,2,1);

                put(1,0-2);
                put(1,1,0);
                put(1,2,2);

                put(2,0,-1);
                put(2,1,0);
                put(2,2,1);
             }
          };	      
          
          Imgproc.filter2D(source, destination, -1, kernel);
          Imgcodecs.imwrite("output.jpg", destination);
          
       } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
       }*/
	   //import cv2
	   //import numpy as np
	   //from matplotlib import pyplot as plt

	  
	   //img0 = cv2.imread('SanFrancisco.jpg',)
	   Mat img0 = Imgcodecs.imread("windows.jpg");

	   // converting to gray scale
	   gray = cvtColor(img0, cv2.COLOR_BGR2GRAY);

	   # remove noise
	   img = cv2.GaussianBlur(gray,(3,3),0);

	   # convolute with proper kernels
	   laplacian = cv2.Laplacian(img,cv2.CV_64F)
	   sobelx = cv2.Sobel(img,cv2.CV_64F,1,0,ksize=5)  # x
	   sobely = cv2.Sobel(img,cv2.CV_64F,0,1,ksize=5)  # y

	   plt.subplot(2,2,1),plt.imshow(img,cmap = 'gray')
	   plt.title('Original'), plt.xticks([]), plt.yticks([])
	   plt.subplot(2,2,2),plt.imshow(laplacian,cmap = 'gray')
	   plt.title('Laplacian'), plt.xticks([]), plt.yticks([])
	   plt.subplot(2,2,3),plt.imshow(sobelx,cmap = 'gray')
	   plt.title('Sobel X'), plt.xticks([]), plt.yticks([])
	   plt.subplot(2,2,4),plt.imshow(sobely,cmap = 'gray')
	   plt.title('Sobel Y'), plt.xticks([]), plt.yticks([])

	   plt.show()
   }
}