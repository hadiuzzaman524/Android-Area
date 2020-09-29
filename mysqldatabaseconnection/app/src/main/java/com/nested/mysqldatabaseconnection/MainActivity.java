package com.nested.mysqldatabaseconnection;

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
    EditText editText1,editText2;
    private static final String DB_URL="jdbc:mysql://192.168.31.80/baust";
    private  static final String USER="hadi";
    private static final String PASS="12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonid);
        editText1=findViewById(R.id.edittextid);
        editText2=findViewById(R.id.edittext2id);



    }

    public  void click(View v)
    {
        Send obj=new Send();
        obj.execute("");
    }
    private class Send extends AsyncTask<String ,String,String>
    {
        String name=editText1.getText().toString();
        String mobile=editText2.getText().toString();
        String msg="";

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(),"Please wait...",Toast.LENGTH_LONG).show();

        }


        @Override
        protected String doInBackground(String... strings) {

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
                if(conn==null)
                {
                   // Toast.makeText(getApplicationContext(),"Cannot insert data",Toast.LENGTH_LONG).show();

                    msg="connection goes wrong";
                }
                else
                {
                    String query= "INSERT INTO info (name,mobile) VALUES('"+name+"','"+mobile+"')";
                    Statement stmt=conn.createStatement();
                    stmt.executeUpdate(query);
                    msg="Inserting successfull";

                }
                conn.close();
            }
            catch (Exception e)
            {
                msg="connection goes wrong exception";
                e.printStackTrace();
            }

            return msg;
        }

        @Override
        protected void onPostExecute(String msg) {

            Toast.makeText(getApplicationContext(),""+msg,Toast.LENGTH_LONG).show();

        }

    }
}
