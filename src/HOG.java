import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
 
public class HOG {
	public static Mat gradient(String filename) {
	        int kernelSize = 9;
	        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	        
	        Mat source = Imgcodecs.imread(filename,  Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	        Mat destination = new Mat(source.rows(),source.cols(),source.type());
	        
	        Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
	           {
	        	   //Initialized for vertical gradients
	              put(0,0,-1);
	              put(0,1,0);
	              put(0,2,1);
	
	              put(1,0,-2);
	              put(1,1,0);
	              put(1,2,2);
	
	              put(2,0,-1);
	              put(2,1,0);
	              put(2,2,1);
	           }
	        };
	        
	        
	        //Unstable load reducing
	       
	        /*System.out.println("divide");
	        path="C:\\java workspace\\ora\\images\\Color_Sad_jpg";
	          for (File file : new File(path).listFiles()) {
	                Mat img=new Mat();
	                Mat m=new Mat(new Size(640,480),CvType.CV_32FC1);
	                Mat con = Imgcodecs.imread(file.getAbsolutePath(),Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

	                con.convertTo(img, CvType.CV_32FC1,1.0/255.0);
	                img.reshape(1, 1);
	                

	              }*/
	        
	        
	        Imgproc.filter2D(source, destination, -1, kernel);
	        Imgcodecs.imwrite(filename.split("\\.")[0]+"_gradients."+filename.split("\\.")[1], destination);
		return destination;
	}
   public static void main( String[] args ) {
	   //Insert filename
	   gradient("");
   }
}