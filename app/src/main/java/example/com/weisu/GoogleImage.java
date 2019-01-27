package example.com.weisu;

import android.content.Context;
import android.net.Uri;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: Andy Su
 * @Date: 2019-01-26
 */
public class GoogleImage {
    public void run(Context context) {
        Credentials myCredentials=null;
        try{
            Uri url = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.weisuserviceaccount);
            System.out.print(url.toString());
            File file = new File(url.toString());
            myCredentials = ServiceAccountCredentials.fromStream(
                    new FileInputStream(file));
        }catch(Exception e){
            e.printStackTrace();
        }

//        ImageAnnotatorSettings imageAnnotatorSettings = null;
//        try {
//            imageAnnotatorSettings = ImageAnnotatorSettings.newBuilder()
//                    .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
//                    .build();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
//
//            // The path to the image file to annotate
//            String fileName = "https://marthabeck.com/wp-content/uploads/2016/10/spoon.jpg";
//
//            // Reads the image file into memory
//            Path path = Paths.get(fileName);
//            byte[] data = Files.readAllBytes(path);
//            ByteString imgBytes = ByteString.copyFrom(data);
//
//            // Builds the image annotation request
//            List<AnnotateImageRequest> requests = new ArrayList<>();
//            Image img = Image.newBuilder().setContent(imgBytes).build();
//            Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
//            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
//                    .addFeatures(feat)
//                    .setImage(img)
//                    .build();
//            requests.add(request);
//
//            // Performs label detection on the image file
//            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
//            List<AnnotateImageResponse> responses = response.getResponsesList();
//
//            for (AnnotateImageResponse res : responses) {
//                if (res.hasError()) {
//                    System.out.printf("Error: %s\n", res.getError().getMessage());
//                    return;
//                }
//
//                for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
//
//                    for (Descriptors.FieldDescriptor k : annotation.getAllFields().keySet()) {
//                        System.out.printf("%s : %s\n", k, annotation.getAllFields().get(k).toString());
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
