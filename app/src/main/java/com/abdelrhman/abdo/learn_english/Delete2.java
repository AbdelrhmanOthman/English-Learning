package com.abdelrhman.abdo.learn_english;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Delete2 extends AppCompatActivity {
     EditText mEditText;
    DB2 mDB2 = new DB2(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete2);
        mEditText = (EditText)findViewById(R.id.editTextDelet2);
    }

    public void btn_delete2(View view) {
        String id = mEditText.getText().toString();
        Integer result = mDB2.Delete2(id);
        if (result>0){
            Toast.makeText(this,"تم الحذف",Toast.LENGTH_LONG);
            finish();
        }else {
            Toast.makeText(this,"عذرا لم يتم الحذف",Toast.LENGTH_LONG);

        }

    }

    }

