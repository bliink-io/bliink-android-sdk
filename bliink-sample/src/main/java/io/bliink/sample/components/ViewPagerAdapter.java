package io.bliink.sample.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import io.bliink.sample.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for the viewPager
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Context context = null;
    private LayoutInflater layoutInflater = null;
    private List<Integer> images = null;


    public ViewPagerAdapter(Context context, List<Integer> images) {
        this.context = context;
        this.images = new ArrayList<>(images);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        this.layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = this.layoutInflater.inflate(R.layout.image_in_slider, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageInSlider);
        imageView.setImageResource(images.get(position));

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
