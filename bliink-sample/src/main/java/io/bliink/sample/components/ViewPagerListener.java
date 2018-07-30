package io.bliink.sample.components;

import android.support.v4.view.ViewPager;
import io.bliink.sdk.components.BLIINKAdView;
import io.bliink.sdk.components.BLIINKInImageView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Listener for the viewPager, to listen on every scroll
 */
public class ViewPagerListener extends ViewPager.SimpleOnPageChangeListener {

    private int sliderCap;
    private int timesSlided = 1;
    private int tagIndex = 0;
    private int tagId;
    private ArrayList<HashMap<String, String>> tagList = null;
    private BLIINKInImageView mBliinkInImageView = null;
    private BLIINKAdView.AdResponseHandler mBliinkInImageListener = null;

    public ViewPagerListener(int sliderCap, int tagId, ArrayList<HashMap<String, String>> tagList,
                             BLIINKInImageView bliinkInImageView, BLIINKAdView.AdResponseHandler bliinkInImageListener) {
        this.sliderCap = sliderCap;
        this.tagId = tagId;
        this.tagList = tagList;
        this.mBliinkInImageView = bliinkInImageView;
        this.mBliinkInImageListener = bliinkInImageListener;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    /**
     * At every scroll it compare if the number of scrolls to load has been reached. If yes a new ad is loaded from the adList
     * @param position Position of the current slide
     */
    @Override
    public void onPageSelected(int position) {
        if (sliderCap > 0 && !tagList.isEmpty()) {
            mBliinkInImageView.closeAd();

            if (timesSlided % sliderCap == 0) {
                if (tagIndex < tagList.size() - 1) {
                    tagIndex += 1;
                } else {
                    tagIndex = 0;
                }
                mBliinkInImageView.loadAd(tagId, tagList.get(tagIndex), mBliinkInImageListener);
            }
            timesSlided += 1;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
