package com.example.zoomcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

import javax.xml.transform.OutputKeys;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageid);
        zoomControls=findViewById(R.id.zoomid);

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=imageView.getScaleX();
                float y=imageView.getScaleY();

                imageView.setScaleX((float)x+1);
                imageView.setScaleY((float)y+1);
            }
        });

        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x=imageView.getScaleX();
                float y=imageView.getScaleY();
                if(x>1&&y>1)
                {
                    imageView.setScaleY(y-1);
                    imageView.setScaleX(x-1);
                }

            }
        });

    }
}
