package com.example.exercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int pic[] = {R.drawable.ac, R.drawable.ic_clear, R.drawable.ic_mod, R.drawable.ic_divide, R.drawable.ic_seven, R.drawable.ic_eight, R.drawable.ic_nine, R.drawable.ic_multiply, R.drawable.ic_four, R.drawable.ic_five, R.drawable.ic_six,
            R.drawable.ic_minus, R.drawable.ic_one, R.drawable.two,
            R.drawable.ic_three, R.drawable.ic_plush, R.drawable.ic_zero, R.drawable.ic_dot, R.drawable.ic_power, R.drawable.ic_equal};


    GridView gridView;
    TextView textView,prev;
    double x = 0.0;
    double y = 0.0;
    double sum=0.0;
    int c = 0;
    String operator2 = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gradviewid);
        textView = findViewById(R.id.textviewid);
        prev=findViewById(R.id.previd);

        CustomAdapter adapter = new CustomAdapter(this, pic);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String n = new String();
                String m = new String();

                String newdata = new String();
                String olddata = new String();
                String operator = new String();

                try {
                    if (position == 0) {//ac
                        textView.setText("");
                        prev.setText("");
                        x = 0;
                        y = 0;
                        c=0;
                    }
                    if (position == 1) {//cls
                        m = textView.getText().toString();

                        if (m.length() != 0)
                            textView.setText(m.substring(0, m.length() - 1));

                    }
                    if (position == 2) {//%

                        n += "%";
                        m = textView.getText().toString();
                      //  prev.setText(m+"%");
                        textView.setText(m + n);
                        olddata = m;
                        x = Double.parseDouble(olddata);
                        if (c == 0)
                            y = x;
                        if (c > 0)
                            y %= x;
                        operator = "%";
                        operator2 = operator;
                        prev.setText(y+"%");

                    }
                    if (position == 3) {// /

                        n += "/";
                        m = textView.getText().toString();
                       // prev.setText(m+"/");
                        textView.setText(m + n);
                        olddata = m;
                        x = Double.parseDouble(olddata);
                        if (c == 0)
                            y = x;
                        if (c > 0)
                            y /= x;
                        operator = "/";
                        operator2 = operator;
                        prev.setText(y+"/");

                    }
                    if (position == 4) {//7
                        n += "7";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 5) {//8
                        n += "8";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 6) {//9
                        n += "9";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 7) {//x
                        n += "X";
                        m = textView.getText().toString();
                       // prev.setText(m+"x");
                        textView.setText(m + n);
                        olddata = m;
                        x = Double.parseDouble(olddata);
                        if (c == 0)
                            y = x;
                        if (c > 0)
                            y *= x;
                        operator = "X";
                        operator2 = operator;
                        prev.setText(y+"x");

                    }
                    if (position == 8) {//4
                        n += "4";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 9) {//5
                        n += "5";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 10) {//6
                        n += "6";
                        m = textView.getText().toString();
                        textView.setText(m + n);
                    }
                    if (position == 11) {//-
                        n += "-";
                        m = textView.getText().toString();
                     //  prev.setText(m+"-");
                        textView.setText(m + n);
                        olddata = m;
                        x = Double.parseDouble(olddata);
                        if (c == 0)
                        {
                            y = x;
                            sum=x;
                            Toast.makeText(getApplicationContext(),"c=0,"+y,Toast.LENGTH_SHORT).show();
                        }

                        if (c > 0)
                        {  y = sum-x;
                           sum=y;
                            Toast.makeText(getApplicationContext(),"c>0,"+x,Toast.LENGTH_SHORT).show();
                        }

                        operator = "-";
                        operator2 = operator;
                        prev.setText(y+"-");

                    }
                    if (position == 12) {//1
                        n += "1";
                        m = textView.getText().toString();
                        textView.setText(m + n);
                    }
                    if (position == 13) {//2
                        n += "2";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 14) {//3
                        n += "3";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 15) {//+
                        n += "+";
                        m = textView.getText().toString();

                        textView.setText(m + n);
                        olddata = m;
                        x = Double.parseDouble(olddata);
                        if (c == 0)
                            y = x;
                        if (c > 0)
                            y += x;
                        operator = "+";
                        operator2 = operator;
                        prev.setText(y+"+");

                    }
                    if (position == 16) {//0
                        n += "0";
                        m = textView.getText().toString();
                        textView.setText(m + n);
                        x = 0;
                        y = 0;

                    }
                    if (position == 17) {//.
                        n += ".";
                        m = textView.getText().toString();
                        textView.setText(m + n);

                    }
                    if (position == 18) {//x^2
                        n += "^";
                        m = textView.getText().toString();
                        textView.setText(m + n);
                        olddata = m;
                        x = Double.parseDouble(olddata);
                        if (c == 0)
                            y = x;
                        else
                            y = Math.pow(y, x);

                        operator = "^";
                        operator2 = operator;

                    }
                    if (position == 19) {//=
                        try {
                            m = textView.getText().toString();
                            x = Double.parseDouble(m);
                            textView.setText("");
                            prev.setText("");
                            if (operator2.equals("+")) {
                                y += x;

                                textView.setText("" + (y));
                            }
                            if (operator2.equals("-")) {

                                y = sum-x;
                                sum=y;
                                textView.setText("" + (y));
                            }
                            if (operator2.equals("X")) {
                                y *= x;
                                textView.setText("" + (y));
                            }
                            if (operator2.equals("/")) {
                                y /= x;
                                textView.setText("" + (y));
                            }
                            if (operator2.equals("%")) {
                                y %= x;
                                textView.setText("" + (y));
                            }
                            if (operator2.equals("^")) {
                                System.out.println(x + " " + y);
                                y = Math.pow(y, x);
                                textView.setText("" + (y));
                            }

                            c = 0;
                        } catch (Exception e) {
                            textView.setText("Number Error");
                            prev.setText("");
                        }

                    }

                    switch (operator) {
                        case "+": {
                            c++;
                            textView.setText("");
                            break;
                        }
                        case "-": {
                            c++;
                            textView.setText("");
                            break;
                        }
                        case "X": {
                            c++;
                            textView.setText("");
                            break;
                        }
                        case "/": {
                            c++;
                            textView.setText("");
                            break;
                        }
                        case "^": {
                            c++;
                            textView.setText("");
                            break;
                        }
                        case "%": {
                            c++;
                            textView.setText("");
                            break;
                        }

                    }
                } catch (Exception e) {
                    textView.setText("");
                    prev.setText("");
                }


            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alartDialogBuilder;
        alartDialogBuilder = new AlertDialog.Builder(this);
        alartDialogBuilder.setIcon(R.drawable.ic_calculator);
        alartDialogBuilder.setCancelable(false);
        alartDialogBuilder.setTitle("Calculator");
        alartDialogBuilder.setMessage("Do you want to exit?");

        alartDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alartDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alartDialogBuilder.create();
        alertDialog.show();
        //super.onBackPressed();
    }
}
