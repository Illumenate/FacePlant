import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.ml.SVM;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class mySVM {
	public static void main(String[] args) {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		int absoluteFaceSize=30;
		//Insert name of image to detect
		String filename="";
		Mat grayFrame=Imgcodecs.imread(filename,  Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
		MatOfRect faces=new MatOfRect();
		
		if (absoluteFaceSize == 0){
		    int height = grayFrame.rows();
		    if (Math.round(height * 0.2f) > 0){
		            absoluteFaceSize = Math.round(height * 0.2f);
		    }
		}
		//Insert file path of HOG as argument
		CascadeClassifier faceCascade=new CascadeClassifier();
		faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(absoluteFaceSize, absoluteFaceSize), new Size());
		
		Rect[] facesArray = faces.toArray();
		for (int i = 0; i < facesArray.length; i++) {
		    Imgproc.rectangle(grayFrame, facesArray[i].tl(), facesArray[i].br(), new Scalar(0, 255, 0, 255), 3);
		}
		
		
		//Alternative training stuff still in development
		
	 // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	// String path="yeet";
    /* Mat classes = new Mat();
     Mat trainingData = new Mat();
     Mat trainingImages = new Mat();
     Mat trainingLabels = new Mat();
     SVM clasificador;
     String path="C:\\java workspace\\ora\\images\\Color_Happy_jpg";
     for (File f : new File(path).listFiles()) {
         Mat img=new Mat();   
         Mat con = Imgcodecs.imread(path+"\\"+f.getName(),Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
         con.convertTo(img, CvType.CV_32FC1,1.0/255.0);
             img.reshape(1, 1);
             trainingImages.push_back(img);
            trainingLabels.push_back(Mat.ones(new Size(1, 75), CvType.CV_32FC1));

      }
     System.out.println("divide");
     path="C:\\java workspace\\ora\\images\\Color_Sad_jpg";
       for (File file : new File(path).listFiles()) {
             Mat img=new Mat();
             Mat m=new Mat(new Size(640,480),CvType.CV_32FC1);
             Mat con = Imgcodecs.imread(file.getAbsolutePath(),Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

             con.convertTo(img, CvType.CV_32FC1,1.0/255.0);
             img.reshape(1, 1);
             trainingImages.push_back(img);

             trainingLabels.push_back(Mat.zeros(new Size(1, 75), CvType.CV_32FC1));

           }

         trainingLabels.copyTo(classes);
         CvSVMParams params = new CvSVMParams();
         params.set_kernel_type(CvSVM.LINEAR);
         CvType.typeToString(trainingImages.type());
    



         clasificador = new SVM(trainingImages,classes, new Mat(), new Mat(), params);*/
/*
         clasificador.save("C:\\java workspace\\ora\\images\\svm.xml");
         Mat out=new Mat();

         clasificador.load("C:\\java workspace\\ora\\images\\svm.xml");
         Mat sample=Imgcodecs.imread("C:\\java workspace\\ora\\images\\Color_Sad_jpg\\EMBfemale20-2happy.jpg",Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);

        sample.convertTo(out, CvType.CV_32FC1,1.0/255.0);               
         out.reshape(1, 75);
         System.out.println(clasificador.predict(out));
	//Mat labels= new Mat( pos_count + neg_count, 1, CvType.CV_32F );
	//labels.rowRange( 0, pos_count ) = 1;

	SVM svm;

	params.C = c;
	params.svm_type = CvSVM::C_SVC;
	params.kernel_type = CvSVM::LINEAR;
	params.term_crit = cvTermCriteria( CV_TERMCRIT_ITER, 10000, 1e-6 );

	Mat feat_matrix( pos_count + neg_count, pos_feats[0].cols, pos_feats[0].type() );
	for( int i = 0; i < pos_count; i++ )
	    pos_feats[i].copyTo( feat_matrix.rowRange(i, i+1) );
	for( int i = 0; i < neg_count; i++ )
	    neg_feats[i].copyTo( feat_matrix.rowRange(i + pos_count, i + pos_count + 1) );

	cout << "Start training SVM" << endl;
	svm.train( feat_matrix, labels, Mat(), Mat(), params );
	svm.save( (path + svm_file).c_str() );*/
}
}

