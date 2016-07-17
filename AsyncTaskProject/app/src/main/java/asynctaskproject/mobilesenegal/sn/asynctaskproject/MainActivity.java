package asynctaskproject.mobilesenegal.sn.asynctaskproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button btn;
    private static Bitmap downloadBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Internet
        if (!internetConnectionCheck(MainActivity.this)) {
            Toast.makeText(getApplicationContext(), "Connect to the Internet first.", Toast.LENGTH_LONG).show();
        }
        btn = (Button) findViewById(R.id.btnOK);
        btn.setOnClickListener(this);
    }

    public void onClick(View view){
        if(internetConnectionCheck(MainActivity.this)) {
            switch (view.getId()) {
                case R.id.btnOK:
                    new LongOperation().execute("");
                    break;
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Connect to the Internet first.", Toast.LENGTH_LONG).show();
        }
    }

    private Bitmap downloadImage(){
        Bitmap bitmap = null;
        try {

            //HTTPS
            URL url = new URL("https://raw.githubusercontent.com/robinho007/M4SAndroidCourse/master/Galerie/thies_pm.png");
            HttpsURLConnection conn =  (HttpsURLConnection) url.openConnection();

            conn.connect();
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = conn.getInputStream();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            //publishProgress(0);
            bitmap = BitmapFactory.decodeStream(is, null, options);
            is.close();
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return bitmap;
    }

    private class LongOperation extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            downloadBitmap = downloadImage();
            return downloadBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bmp) {
            ImageView myImage = (ImageView) findViewById(R.id.imageView);
            myImage.setImageBitmap(bmp);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static boolean internetConnectionCheck(Activity CurrentActivity) {
        Boolean Connected = false;
        ConnectivityManager connectivity = (ConnectivityManager) CurrentActivity.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) for (int i = 0; i < info.length; i++)
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    Log.e("My Network is: ", "Connected ");
                    Connected = true;
                } else {}

        } else {
            Log.e("My Network is: ", "Not Connected");
            Connected = false;

        }
        return Connected;

    }
}
