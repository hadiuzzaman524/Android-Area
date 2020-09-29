package com.nested.mysqlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    private static final String DB_URL="jdbc:mysql://192.168.31.80/db";
    private  static final String USER="hadi";
    private static final String PASS="12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonid);
        editText=findViewById(R.id.edittextid);

    }
    public  void click(View v)
    {
     Send objSend=new Send();
     objSend.execute("");
    }
    private class Send extends AsyncTask<String,String,String> {
        String msg="";
        String text=editText.getText().toString();
        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(),"Please wait insert a data",Toast.LENGTH_LONG).show();
        }
        @Override
        protected String doInBackground(String... strings) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
                if(conn==null)
                {
                    msg="Connection goes Wrong";
                }
                else
                {
                    String query= "INSERT INTO student (name) VALUES('"+text+"')";
                    Statement stmt=conn.createStatement();
                    stmt.executeUpdate(query);
                    msg="Inserting successfull";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg="connection goes wrong";
                e.printStackTrace();
            }
            return  msg;
        }

        @Override
        protected void onPostExecute(String msg) {
            Toast.makeText(getApplicationContext(),""+msg,Toast.LENGTH_LONG).show();
        }
    }
}
