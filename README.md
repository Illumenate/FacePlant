# FacePlant
The OpenCV 3.1 library used in the code has been modified to make integration with the descriptor vector easier. Check the /bin folder for the files you need to install. If using Eclipse, install as you would with any custom user library for the imported project.

You will need to pass filenames for the images directly into the code. There are single line comment markers to indicate where these are. 

Additionally, you will need to provide the file path for the HOG descriptor XML file in the constructor for the classifier in the SVM.

I have also started working on various improvements and fixes that are not finished yet, but I decided to include them publicly in the case that anyone wanted to look at/modify it. The commented out blocks are not stable, but I encourage tinkering with it to improve runtime or training efficiency.
