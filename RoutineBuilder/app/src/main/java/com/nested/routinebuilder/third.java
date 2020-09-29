package com.nested.routinebuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class third extends Fragment {

    EditText subname,subcode,cradit;
    Button button;
    String sname,scode,scradit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        View view=inflater.inflate(R.layout.third,container,false);

        subcode=view.findViewById(R.id.subcodeid);
        subname=view.findViewById(R.id.subnameid);
        cradit=view.findViewById(R.id.subcraditid);
        button=view.findViewById(R.id.insertsubjectid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sname=subname.getText().toString();
                scode=subcode.getText().toString();
                scradit=cradit.getText().toString();

                if (sname.isEmpty())
                {
                    subname.setError("enter subject name");
                    subname.requestFocus();
                    return;
                }
                else if(scode.isEmpty())
                {
                    subcode.setError("enter course code");
                    subcode.requestFocus();
                    return;
                }
                else if(scradit.isEmpty())
                {
                    cradit.setError("enter credit");
                    cradit.requestFocus();
                    return;
                }
                else {

                }
            }
        });
        return view;
    }
}
