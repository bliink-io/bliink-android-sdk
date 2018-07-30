package io.bliink.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.bliink.sample.R;
import io.bliink.sample.utils.Constants;


public class MainActivity extends AppCompatActivity {


    private ListView listView = null;

    private static String item0 = Constants.FIRST_ITEM;
    private static String item1 = Constants.SECOND_ITEM;
    private static String item3 = Constants.THIRD_ITEM;
    private static String item4 = Constants.FOURTH_ITEM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.initView();
    }

    private void initView() {
        listView = findViewById(R.id.list_activities);
        String[] choices = new String[]{item0, item1, item3, item4};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, choices);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent activity = null;

                if (position == 0)
                    activity = new Intent(MainActivity.this, InImageBasic.class);
                else if (position == 1)
                    activity = new Intent(MainActivity.this, InImageBasicFull.class);
                else if (position == 2)
                    activity = new Intent(MainActivity.this, InImageBasicSlider.class);
                else if (position == 3)
                    activity = new Intent(MainActivity.this, InImageBasicCollapsing.class);

                if (activity != null)
                    startActivity(activity);
            }
        });
    }
}
