##WORKING WITH FIREBASE.  

1.Setting up Firebase on android:  

  a. Setup gradle dependency  
        -compile 'com.firebase:firebase-client-android:2.2.3+'  
        
  b.Exclude any licences that may give build errors:  
        -packagingOptions{  
            exclude 'META-INF/LICENSE'  
            exclude 'META-INF/LICENSE-FIREBASE.txt'  
            exclude 'META-INF/NOTICE'  
        }   
        
   C.Lastly add internet permission to allow the app to communicate over the net.  
        -In the manifest:  
   <uses-permission adroid:name="android.permission.INTERNET"/>  
   
   
   ...now you're ready to start building firebase apps.....  
   
   To quickly add firebase to your project, got to File- Project Structure - Cloud - Enable FireBase  
   Now all you have to do is add the packagingOptions in the gradle files.
   
   
