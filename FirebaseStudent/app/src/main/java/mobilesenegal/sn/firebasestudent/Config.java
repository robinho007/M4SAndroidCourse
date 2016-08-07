package mobilesenegal.sn.firebasestudent;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by DELL on 07/08/2016.
 */
public class Config extends Application {

    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
