package io.bliink.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.bliink.sample.utils.Constants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        try {
            Thread.sleep(Constants.THREAD_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
