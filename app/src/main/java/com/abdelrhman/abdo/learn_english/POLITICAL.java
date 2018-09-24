package com.abdelrhman.abdo.learn_english;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.adsCommon.StartAppAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class POLITICAL extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        int result;
  private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    DB db = new DB(this);
    DB2 mDB2 = new DB2(this);


    TextToSpeech mTextToSpeech;
        EditText mEditTextPolitical;
        Button btnShowlist;
        static String[] political;
        static String[] Arabic_political;
        TextView txt_political, txtArabic_political, txt_numberPolitical;

        static int b = 0;
        static int c = 0;
        static int polit=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_political);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2638567379077144/4740074727");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });



        political = new String[1000];
        Arabic_political = new String[1000];
        txt_political = (TextView) findViewById(R.id.txtpolitical);
        txtArabic_political = (TextView) findViewById(R.id.txtArabic_political);
        txt_numberPolitical = (TextView) findViewById(R.id.txtnumberPolitical);

        mEditTextPolitical = (EditText) findViewById(R.id.editText_PoliticalWords);

        mTextToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    result = mTextToSpeech.setLanguage(Locale.UK);


                } else {
                    Toast.makeText(POLITICAL.this, "لكى تعمل هذة الخاصية غير لغة الهاتف الى الانجليزية",
                            Toast.LENGTH_LONG).show();


                }


            }
        });


        try {
            InputStream inputStream = getAssets().open("political.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            int id = 0;
            while ((line = bufferedReader.readLine()) != null) {
                political[id] = line;
                id++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            InputStream inputStream1 = getAssets().open("political_arabic.txt");
            InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream1);
            BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);

            String line;
            int id = 0;
            while ((line = bufferedReader1.readLine()) != null) {
                Arabic_political[id] = line;
                id++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        txt_political.setText(political[b]);
        txtArabic_political.setText(Arabic_political[c]);
        txt_numberPolitical.setText(String.valueOf(polit));




































        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        txt_political.setText(political[b]);
        txtArabic_political.setText(Arabic_political[c]);
        txt_numberPolitical.setText(String.valueOf(polit));


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.political, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_PublicWords) {
            finish();

            Intent intent = new Intent(this, Public_WOrds.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        } else if (id == R.id.nav_Public1) {
            finish();

            Intent intent = new Intent(this, Public1.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }

        else if (id == R.id.nav_Public2) {
            finish();

            Intent intent = new Intent(this, PUBLIC2.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }

        else if (id == R.id.nav_POLiticalWords) {
            finish();


            Intent intent = new Intent(this,POLITICAL.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        } else if (id == R.id.nav_AccontingWords) {
            finish();

            Intent intent = new Intent(this, COMERCIAL.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        } else if (id == R.id.nav_EconomyWords) {
            finish();

            Intent intent = new Intent(this,ECONOMY.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        } else if (id == R.id.nav_TuristsWords) {
            finish();

            Intent intent = new Intent(this,TOURIST.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        } else if (id == R.id.nav_ComputerWords) {
            finish();

            Intent intent = new Intent(this, Computer.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }
        else if (id == R.id.nav_myExampels) {
            finish();

            Intent intent = new Intent(this, MyExampels.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }
        else if (id == R.id.nav_Favourt) {
            finish();

            Intent intent = new Intent(this, FAVOURT.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }

        else if (id == R.id.nav_commonQuestion) {
            finish();

            Intent intent = new Intent(this, Common_question.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }

        else if (id == R.id.nav_listen2) {
            finish();

            Intent intent = new Intent(this, Listining.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }
        else if (id == R.id.nav_conv2) {
            finish();

            Intent intent = new Intent(this, Conversation.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }

        else if (id == R.id.nav_read2) {
            finish();

            Intent intent = new Intent(this, READMain.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }
           else if (id == R.id.nav_share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("Text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=com.abdelrhman.abdo.learn_english";
            String shareSub = "تطبيق معرفة لتعلم اللغة الانجليزية";
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            startActivity(Intent.createChooser(myIntent, "share Using"));


        }  else if (id == R.id.nav_valuate) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id="+getPackageName())));
            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
            }

        }

        else if (id == R.id.nav_moreApps) {
            Intent morApp = new Intent(Intent.ACTION_VIEW);
            morApp.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Abdelrhman Mohamed"));
            startActivity(morApp);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void btn_addExampel(View view) {
        String EnglisWord = txt_political.getText().toString();
        String ArabicWord = txtArabic_political.getText().toString();
        String myexambels = mEditTextPolitical.getText().toString();
        Boolean result =  mDB2.insertData2(EnglisWord,ArabicWord,myexambels);
        if (result==true){
            Toast.makeText(this,"تمت الاضافة فى صفحة الامثلة",Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(this,"عذرا هناك خطأ ما",Toast.LENGTH_LONG).show();

        }


    }




    public void btn_nextpolitical(View view) {
        polit++;
        b++;
        c++;
        if (b < political.length && c < Arabic_political.length) {

            txt_political.setText(political[b]);
            txtArabic_political.setText(Arabic_political[c]);
            mEditTextPolitical.setText("");
            txt_numberPolitical.setText(String.valueOf(polit));


        } else {
            Toast.makeText(this, "عفوا هذه اخر كلمة فى قائمة الكلمات", Toast.LENGTH_LONG).show();
        }

    }

    public void btn_FavourtPolitical(View view) {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

        String EnglisWord = txt_political.getText().toString();
        String ArabicWord = txtArabic_political.getText().toString();
        Boolean result =  db.insertData(EnglisWord,ArabicWord);
        if (result==true){
            Toast.makeText(this,"تمت الاضافة فى المفضلة",Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(this,"عذرا هناك خطأ ما",Toast.LENGTH_LONG).show();

        }


    }

    public void btn_speakPolitical(View view) {
        //  mTextToSpeech.speak(txt_computer.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
        if (result==TextToSpeech.LANG_NOT_SUPPORTED||result ==TextToSpeech.LANG_MISSING_DATA){
            Toast.makeText(POLITICAL.this,"لكى تعمل هذة الخاصية غير لغة الهاتف الى الانجليزية",Toast.LENGTH_LONG).show();


        }else {
            mTextToSpeech.speak(txt_political.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

        }
    }

    public void btn_backPolitical(View view) {



        b--;
        c--;
        polit--;

        if (b >= 0 && c >= 0) {

            txt_political.setText(political[b]);
            txtArabic_political.setText(Arabic_political[c]);
            mEditTextPolitical.setText("");
            txt_numberPolitical.setText(String.valueOf(polit));


        } else {
            Toast.makeText(this, "عفوا هذه اول كلمة فى قائمة الكلمات", Toast.LENGTH_LONG).show();
        }

    }

    public void list_politicalWords(View view) {
        Intent intent = new Intent(POLITICAL.this,ListWordsPolitical.class);
        startActivity(intent);
      //  StartAppAd.showAd(this);

    }


}
