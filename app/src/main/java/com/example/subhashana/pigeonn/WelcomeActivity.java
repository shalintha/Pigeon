package com.example.subhashana.pigeonn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        AppCenter.start(getApplication(), "da90eb32-96db-453a-b01c-2a14fe8740ae",
                Analytics.class, Crashes.class);


        Thread thread = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finally {

                    Intent mainIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(mainIntent);

                }
            }
        };

        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
