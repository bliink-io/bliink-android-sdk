package io.bliink.sample.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.bliink.sample.R;
import io.bliink.sample.utils.Constants;
import io.bliink.sdk.components.BLIINKInImageView;
import io.bliink.sdk.services.BLIINKHttpClient;
import io.bliink.sdk.services.models.BLIINKAdContent;
import io.bliink.sdk.utils.BLIINKUtils;

import java.util.HashMap;

public class InImageBasicFull extends AppCompatActivity {

    private static final String TAG = InImageBasicFull.class.getName();

    BLIINKInImageView.AdResponseHandler mBliinkInImageListener;
    BLIINKInImageView mBliinkInImageView;
    HashMap<String, String> options = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        options = new HashMap<String, String>();
        options.put(getString(R.string.page_title), getString(R.string.page_title_value));
        options.put(getString(R.string.page_description), getString(R.string.page_description_value));
        options.put(getString(R.string.image_url), getString(R.string.image_url_value));
        options.put(getString(R.string.page_url), getString(R.string.page_url_value));

        loadInImageContent();
    }

    public void loadInImageContent() {

        mBliinkInImageView = findViewById(R.id.ui_home_ad_view);

        mBliinkInImageListener = new BLIINKInImageView.AdResponseHandler() {
            @Override
            public void adLoadingCompleted(BLIINKAdContent adContent) {
                BLIINKUtils.v(TAG, "adLoadingCompleted");
            }

            @Override
            public void adLoadingFailed(String e) {
                BLIINKUtils.v(TAG, "adLoadingFailed " + e);
            }
        };
        mBliinkInImageView.loadAd(Constants.TAG_ID, options, mBliinkInImageListener);
    }
}
