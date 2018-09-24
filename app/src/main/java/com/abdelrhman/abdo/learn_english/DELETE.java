package com.abdelrhman.abdo.learn_english;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DELETE extends AppCompatActivity {
    EditText mEditText;
    DB db = new DB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        mEditText = (EditText)findViewById(R.id.editTextDelet);
    }

    public void btn_delete(View view) {
        String id = mEditText.getText().toString();
        Integer result = db.Delete(id);
        if (result>0){
            Toast.makeText(this,"تم الحذف",Toast.LENGTH_LONG);
            finish();
        }else {
            Toast.makeText(this,"عذرا لم يتم الحذف",Toast.LENGTH_LONG);

        }

    }
}
