package com.abdelrhman.abdo.learn_english;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        try {
            InputStream inputStream = getAssets().open("help1.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            int id = 0;
            StringBuilder msg = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                msg.append(line+"\n");
            }

            AlertDialog.Builder builder= new AlertDialog.Builder(getBaseContext());
            builder.setTitle("مساعدة");
            builder.setMessage(Html.fromHtml(msg+""));
            builder.setNegativeButton("اغلاق", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
