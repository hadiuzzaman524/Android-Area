package com.nested.routinebuilder;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class firstfrag extends Fragment {

  public   EditText name;
  public   EditText designation;
  public   Button submit;
  public   String nm;
  public   String des;

    private static final String DB_URL="jdbc:mysql://192.168.31.80/baustr";
    private  static final String USER="jaman";
    private static final String PASS="12345";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);

      View view=inflater.inflate(R.layout.first,container,false);
      name=view.findViewById(R.id.teachernameid);
      designation=view.findViewById(R.id.designationid);
      submit=view.findViewById(R.id.insertteacherid);
      submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              nm=name.getText().toString();
              des=designation.getText().toString();


              if (nm.isEmpty())
              {
                  name.setError("Please enter name");
                  name.requestFocus();
                  return;
              }
             else if (des.isEmpty())
              {
                  designation.setError("Please enter designation");
                  designation.requestFocus();
                  return;
              }
             else
              {
                  Send objsend=new Send();
                  objsend.execute("");

              }

          }
      });

      return view;
    }

    public class Send extends AsyncTask<String,String,String> {

        String msg="";

        @Override
        protected void onPreExecute() {

            Toast.makeText(getView().getContext(),"please wait...",Toast.LENGTH_SHORT).show();

        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection= DriverManager.getConnection(DB_URL,USER,PASS);


                if (connection==null)
                {
                    msg="connection goes wrong";
                }
                else
                {
                    String query="INSERT INTO teachers(tname,tdesignation) VALUES('"+nm+"','"+des+"')";
                    Statement statement=connection.createStatement();
                    statement.executeUpdate(query);
                    msg="insert successful";
                }
                connection.close();

            }
            catch (Exception e)
            {
                msg="connection goes wrong...";
                e.printStackTrace();
            }

            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getView().getContext(),""+msg,Toast.LENGTH_SHORT).show();

        }
    }
}
