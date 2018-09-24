package com.abdelrhman.abdo.learn_english;

import android.content.ActivityNotFoundException;
import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.MobileAds;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.Html;
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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{
    ImageView words,reading,listining, convers,dictionary,speak;
    SQLiteDatabase sql ;
    DB myDB;
 //  private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //   StartAppSDK.init(this, "203026584", true);


        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-2638567379077144~3846629601");
     //  mAdView = findViewById(R.id.adView);
     //  AdRequest adRequest = new AdRequest.Builder().build();
     //  mAdView.loadAd(adRequest);

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


        words = (ImageView)findViewById(R.id.imagewords);
      reading = (ImageView)findViewById(R.id.imagereading);
      listining = (ImageView)findViewById(R.id.imagelisten);
      convers = (ImageView)findViewById(R.id.imageconversation);
      dictionary = (ImageView)findViewById(R.id.imagedictionary);
      speak = (ImageView)findViewById(R.id.imagespeaking);
        words.setOnClickListener(this);
        reading.setOnClickListener(this);
        listining.setOnClickListener(this);
        convers.setOnClickListener(this);
        dictionary.setOnClickListener(this);

        speak.setOnClickListener(this);







/*
        mGridView = (GridView)findViewById(R.id.grideViewMain);
        imageAdapter im = new imageAdapter(this);
        mGridView.setAdapter(im);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0);{
                    Intent intent = new Intent(MainActivity.this,Words.class);
                    startActivity(intent);

                }
                if (i == 1){
                    Intent intent = new Intent(MainActivity.this,Listining.class);
                    startActivity(intent);


                }


                }


        });
        */

















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
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent intent = new Intent(this, Public_WOrds.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }
        } else if (id == R.id.nav_Public1) {
            Intent intent = new Intent(this, Public1.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }
        }

        else if (id == R.id.nav_Public2) {
            Intent intent = new Intent(this, PUBLIC2.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

        }

        else if (id == R.id.nav_POLiticalWords) {

            Intent intent = new Intent(MainActivity.this,POLITICAL.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

        } else if (id == R.id.nav_AccontingWords) {

            Intent intent = new Intent(this, COMERCIAL.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

        } else if (id == R.id.nav_EconomyWords) {
            Intent intent = new Intent(MainActivity.this,ECONOMY.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

        } else if (id == R.id.nav_TuristsWords) {
            Intent intent = new Intent(MainActivity.this,TOURIST.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

        } else if (id == R.id.nav_ComputerWords) {
            Intent intent = new Intent(this, Computer.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }
        }
        else if (id == R.id.nav_myExampels) {
            Intent intent = new Intent(this, MyExampels.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }
        }
        else if (id == R.id.nav_Favourt) {
            Intent intent = new Intent(this, FAVOURT.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

        }

        else if (id == R.id.nav_commonQuestion) {
            Intent intent = new Intent(this, Common_question.class);
            startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

        }

      else if (id == R.id.nav_listen2) {

          Intent intent = new Intent(this, Listining.class);
          startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

      }
      else if (id == R.id.nav_conv2) {

          Intent intent = new Intent(this, Conversation.class);
          startActivity(intent);

          if (mInterstitialAd.isLoaded()) {
              mInterstitialAd.show();
          } else {
              Log.d("TAG", "The interstitial wasn't loaded yet.");
          }

      }

      else if (id == R.id.nav_read2) {

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


      }
      else if (id == R.id.nav_valuate) {
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
        if (view ==words){
            Intent intent = new Intent(MainActivity.this,Words.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }

        }else if (view==reading){
            Intent intent = new Intent(MainActivity.this,READMain.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }



        }else if (view == listining){
            Intent intent = new Intent(MainActivity.this,Listining.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }



        }else if (view==convers){
            Intent intent = new Intent(MainActivity.this,Conversation.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }



        }else if (view==dictionary){
            Intent intent = new Intent(MainActivity.this,DictionaryWebView.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }




        }else if (view == speak){
            Intent intent = new Intent(MainActivity.this,Speaking.class);
            startActivity(intent);

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        }

    }

    /*
    public class imageAdapter extends BaseAdapter{
        Context mContext;
        private int []images ={R.drawable.words,R.drawable.reading,R.drawable.speaking,R.drawable.listen,
        R.drawable.conversation,R.drawable.dictionary};



        public imageAdapter (Context c){
            mContext = c ;
        }
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            if (view==null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(300,300));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8,8,8,8);

            }else{
                imageView =(ImageView)view;
            }
            imageView.setImageResource(images[i]);

            return imageView;
        }
    }
    */

}