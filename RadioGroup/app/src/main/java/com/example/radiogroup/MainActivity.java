package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button showbtn;
private RadioGroup radioGroup;
private RadioButton radioButton;
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
  showbtn=findViewById(R.id.showbuttonid);
  radioGroup=findViewById(R.id.radiogrpupid);
  textView=findViewById(R.id.textid);

  showbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          int s=radioGroup.getCheckedRadioButtonId();
          radioButton=findViewById(s);
          String value=radioButton.getText().toString();
          textView.setText(value);
      }
  });
    }
}
