package com.abdelrhman.abdo.learn_english;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.os.Bundle;
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
import android.widget.ImageView;

public class Words extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener {
    ImageView words1,words2,words3,acounting, politi,economic,tourism,comput,question,examp,favo;
 //  private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

     //   mAdView = findViewById(R.id.adView);
     //   AdRequest adRequest = new AdRequest.Builder().build();
      //  mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2638567379077144/2206244874");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });



        words1 = (ImageView)findViewById(R.id.imagewords1);
        words2 = (ImageView)findViewById(R.id.imagewords2);
        words3 = (ImageView)findViewById(R.id.imagewords3);
        acounting = (ImageView)findViewById(R.id.imagewordacounting);
        politi = (ImageView)findViewById(R.id.imagewordspolitical);
        economic = (ImageView)findViewById(R.id.imagewordseconomic);
        tourism = (ImageView)findViewById(R.id.imagewordstourism);
        comput = (ImageView)findViewById(R.id.imagewordscomputer);
        question = (ImageView)findViewById(R.id.imagewordsquestion);
        examp = (ImageView)findViewById(R.id.imageexampel);
        favo = (ImageView)findViewById(R.id.imagefavourit);


        words1.setOnClickListener(this);
        words2.setOnClickListener(this);
        words3.setOnClickListener(this);
        acounting.setOnClickListener(this);
        politi.setOnClickListener(this);
        economic.setOnClickListener(this);
        tourism.setOnClickListener(this);
        comput.setOnClickListener(this);
        question.setOnClickListener(this);
        examp.setOnClickListener(this);
        favo.setOnClickListener(this);


























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
        getMenuInflater().inflate(R.menu.words, menu);
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

    @Override
    public void onClick(View view) {
        if (view == words1){
            Intent intent = new Intent(Words.this,Public1.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==words2){
            Intent intent = new Intent(Words.this,PUBLIC2.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }else if (view==words3){

            Intent intent = new Intent(Words.this,Public_WOrds.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==acounting){
            Intent intent = new Intent(Words.this,COMERCIAL.class);
            startActivity(intent);


            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==politi){
            Intent intent = new Intent(Words.this,POLITICAL.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==economic){
            Intent intent = new Intent(Words.this,ECONOMY.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }else if (view==tourism){

            Intent intent = new Intent(Words.this,TOURIST.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==comput){
            Intent intent = new Intent(Words.this,Computer.class);
            startActivity(intent);


            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==examp){

            Intent intent = new Intent(Words.this,MyExampels.class);
            startActivity(intent);


            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }else if (view==question){
            Intent intent = new Intent(Words.this,Common_question.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==favo){
            Intent intent = new Intent(Words.this,FAVOURT.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }
    }
}
