package com.zen.android.ske.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.nd.zen.android.skeleton.Skeleton;
import com.nd.zen.android.skeleton.holder.TextItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = (RecyclerView) findViewById(R.id.container);
        Skeleton.create()
                .append(new TextItem(3.2f, 2))
                .append(new TextItem(2.6f, 4))
                .append(new TextItem(0.4f, 1))
                .into(view);
    }



}
