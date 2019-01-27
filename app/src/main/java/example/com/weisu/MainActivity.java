package example.com.weisu;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.api.Service;
import com.google.api.client.util.IOUtils;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.*;
import java.net.URI;
import java.nio.Buffer;

import com.google.auth.oauth2.GoogleCredentials;

//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            InputStream inputStream = this.getResources().openRawResource(R.raw.weisu);

            String fileName = "cred.json";

            FileOutputStream outputStream;
            outputStream = openFileOutput(fileName, this.MODE_PRIVATE);
            IOUtils.copy(inputStream, outputStream);
            outputStream.close();

            String fileLocation = MainActivity.this.getFilesDir().getAbsolutePath();

            String fileAbsoluteLocation = fileLocation + "/" + fileName;

            BufferedReader bf = new BufferedReader(new FileReader(new File(fileAbsoluteLocation)));

            System.out.println(bf.readLine());

            System.out.println(new File(fileAbsoluteLocation));

            Credentials myCredentials = ServiceAccountCredentials.fromStream(
                    new FileInputStream(new File(fileLocation + "/" + fileName)));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
