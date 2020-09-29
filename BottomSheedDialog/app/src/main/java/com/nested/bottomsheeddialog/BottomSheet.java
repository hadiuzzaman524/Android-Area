package com.nested.bottomsheeddialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BottomSheet extends BottomSheetDialogFragment {

    Button button1;
    EditText editText;
    private BottomSheetListener bottomSheetListener ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.bottomsheet,container,false);

       button1=v.findViewById(R.id.sheetbuttonid);
       editText=v.findViewById(R.id.editid);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String n=editText.getText().toString();
               bottomSheetListener.onClick(n);
               dismiss();
           }
       });
        return  v;
    }

    public interface BottomSheetListener{
        void onClick(String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        try {

            bottomSheetListener= (BottomSheetListener) context;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
