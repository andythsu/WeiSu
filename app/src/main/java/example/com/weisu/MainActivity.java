package example.com.weisu;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Credentials myCredentials = null;

        try{
            String path = "android.resource://" + getBaseContext().getPackageName() +  "/" + R.raw.weisuserviceaccount;
//            Uri uri = Uri.parse(path);
//            System.out.println("uri: " + uri.toString());
            File file = new File(path);
            myCredentials = ServiceAccountCredentials.fromStream(
                    new FileInputStream(file));
        } catch(Exception e){
            e.printStackTrace();
        }


    }
}
