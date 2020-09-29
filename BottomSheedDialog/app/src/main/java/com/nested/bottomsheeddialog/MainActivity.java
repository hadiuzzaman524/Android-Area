package com.nested.bottomsheeddialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomSheet.BottomSheetListener {

    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.buttonid);
        textView=findViewById(R.id.textid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {


                BottomSheet bottomSheet=new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"bottomsheet");
            }
        });
    }

    @Override
    public void onClick(String text) {

        textView.setText(text);
    }
}
