package io.bliink.sample.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import io.bliink.sample.R;
import io.bliink.sample.components.ViewPagerAdapter;
import io.bliink.sample.components.ViewPagerListener;
import io.bliink.sample.utils.Constants;
import io.bliink.sdk.components.BLIINKInImageView;
import io.bliink.sdk.services.models.BLIINKAdContent;
import io.bliink.sdk.utils.BLIINKUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Basic slider with images
 */
public class InImageBasicSlider extends AppCompatActivity {

    private static final String TAG = InImageBasicSlider.class.getName();

    BLIINKInImageView.AdResponseHandler mBliinkInImageListener;
    BLIINKInImageView mBliinkInImageView;
    ViewPager viewPager = null;
    ArrayList<HashMap<String, String>> tagList = null;
    private List<Integer> images = Arrays.asList(R.drawable.img11, R.drawable.img8, R.drawable.img9, R.drawable.img1, R.drawable.img4, R.drawable.img10, R.drawable.img3);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_slider);

        this.tagList = new ArrayList<>();

        addTag(getString(R.string.image_url_value));
        addTag(getString(R.string.image_url_value));
        addTag(getString(R.string.image_url_value));

        loadInImageContent();
    }

    public void addTag(String imageUrl) {

        HashMap<String, String> options = new HashMap<String, String>();
        options.put(getString(R.string.page_title), getString(R.string.page_title_value));
        options.put(getString(R.string.page_description), getString(R.string.page_description_value));
        options.put(getString(R.string.image_url), imageUrl);
        options.put(getString(R.string.page_url), getString(R.string.page_url_value));
        options.put(getString(R.string.keywords), getString(R.string.keywords_value));
        // TODO enable test mode
        // options.put("test", "true");

        this.tagList.add(options);
    }

    public void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, images);

        viewPager.addOnPageChangeListener(new ViewPagerListener(Constants.SLIDER_CAP, Constants.TAG_ID, this.tagList, this.mBliinkInImageView, this.mBliinkInImageListener));
        viewPager.setAdapter(viewPagerAdapter);
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

        initViewPager();

        if (!this.tagList.isEmpty())
            mBliinkInImageView.loadAd(Constants.TAG_ID, this.tagList.get(0), mBliinkInImageListener);

    }
}
