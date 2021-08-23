package com.mamunsproject.allsocialmediaplatform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mamunsproject.allsocialmediaplatform.Adapter.SocialAdapter;
import com.mamunsproject.allsocialmediaplatform.Fragment.Download_Fragment;
import com.mamunsproject.allsocialmediaplatform.Fragment.HomeFragment;
import com.mamunsproject.allsocialmediaplatform.Utils.ItemAnimation;
import static com.facebook.ads.AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;



public class MainActivity extends AppCompatActivity implements SocialAdapter.OnItemListener {

    private BottomNavigationView navigation;
    RecyclerView recyclerView;
    private int animation_type = ItemAnimation.FADE_IN;
    public static InterstitialAd admobInterstitialAds;
    public static AdRequest adRequest;
    AdView admobBannerAds;

/*
    Intent intent1, intent2, intent3, intent4, intent5, intent6, intent7, intent8, intent9, intent10, intent11, intent12,
            intent13, intent14, intent15, intent16, intent17, intent18, intent19, intent20, intent21, intent22, intent23, intent24, intent25,
            intent26, intent27, intent28, intent29, intent30, intent31, intent32, intent33,
            intent34, intent35, intent36, intent37, intent38;
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnection();

// Initialize the Audience Network SDK
        AdSettings.setIntegrationErrorMode(INTEGRATION_ERROR_CRASH_DEBUG_MODE);
        AudienceNetworkAds.initialize(this);



//-------------------BANNER ADS---------------------------
        admobBannerAds = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        admobBannerAds.loadAd(adRequest);
//-------------------BANNER ADS---------------------------


/*
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
*/



        //===============================================FB INTERSTITIAL AD============================================
/*

        interstitialAd = new InterstitialAd(getApplicationContext(), "335418644388179_335418824388161");


        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e("TAG", "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e("TAG", "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d("TAG", "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d("TAG", "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d("TAG", "Interstitial ad impression logged!");
            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
*/


        //===============================================FB INTERSTITIAL AD============================================


    //    setRecyclerView();










        //===============================================FB INTERSTITIAL AD============================================

//        interstitialAd = new InterstitialAd(getApplicationContext(), "335418644388179_335418824388161");
//
//
//        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
//            @Override
//            public void onInterstitialDisplayed(Ad ad) {
//                // Interstitial ad displayed callback
//                Log.e("TAG", "Interstitial ad displayed.");
//            }
//
//            @Override
//            public void onInterstitialDismissed(Ad ad) {
//                // Interstitial dismissed callback
//                Log.e("TAG", "Interstitial ad dismissed.");
//            }
//
//            @Override
//            public void onError(Ad ad, AdError adError) {
//                // Ad error callback
//                Log.e("TAG", "Interstitial ad failed to load: " + adError.getErrorMessage());
//            }
//
//            @Override
//            public void onAdLoaded(Ad ad) {
//                // Interstitial ad is loaded and ready to be displayed
//                Log.d("TAG", "Interstitial ad is loaded and ready to be displayed!");
//                // Show the ad
//                interstitialAd.show();
//            }
//
//            @Override
//            public void onAdClicked(Ad ad) {
//                // Ad clicked callback
//                Log.d("TAG", "Interstitial ad clicked!");
//            }
//
//            @Override
//            public void onLoggingImpression(Ad ad) {
//                // Ad impression logged callback
//                Log.d("TAG", "Interstitial ad impression logged!");
//            }
//        };
//
//        // For auto play video ads, it's recommended to load the ad
//        // at least 30 seconds before it is shown
//        interstitialAd.loadAd(
//                interstitialAd.buildLoadAdConfig()
//                        .withAdListener(interstitialAdListener)
//                        .build());
//

//
//        ScheduledExecutorService scheduledExecutorService
//                = Executors.newSingleThreadScheduledExecutor();
//
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        if (interstitialAd.isAdInvalidated()) {
//                            interstitialAd.loadAd();
//                        }
////                        if (interstitialAd.isAdInvalidated()) {
////                            interstitialAd.loadAd();
////                        }
//
//                    }
//                });
//            }
//        },200,200, TimeUnit.SECONDS);
//

//===============================================FB INTERSTITIAL AD============================================


        //===============================================FB BANNER AD============================================


/*        adView = new AdView(this, "335418644388179_335419014388142", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();*/


//===============================================FB BANNER AD============================================


        //===================================================Bottom Navigation==========================================
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(bottomMathod);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerid,new HomeFragment()).commit();


        //===================================================Bottom Navigation==========================================


    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomMathod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

          //  Fragment fragment = null;

            switch (item.getItemId()) {

                case R.id.homemenuid:

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerid,new HomeFragment()).commit();

                    break;


                case R.id.downloadId:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerid,new Download_Fragment()).commit();

                    break;
            }

       /*     getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerid,fragment)
                    .commit();
*/

            return false;
        }
    };

    public void checkConnection(){

        ConnectivityManager manager=(ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();

        if (null!=activeNetwork){

            if (activeNetwork.getType()==ConnectivityManager.TYPE_WIFI){

            }
            if (activeNetwork.getType()==ConnectivityManager.TYPE_WIFI){

            }



        }else {

            new AlertDialog.Builder(this)
                    .setTitle("No Internet Connection!")
                    .setMessage("You Have To Turn On Your Mobile Data or Wifi!")
                    .setCancelable(false)

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation

                            checkConnection();
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(R.drawable.ic_warn)
                    .show();



        }

    }

/*
    private void setRecyclerView() {

        ArrayList<SocialModel> list = new ArrayList<>();


        list.add(new SocialModel("Google", R.drawable.ic_google));
        list.add(new SocialModel("Facebook", R.drawable.facebook));
        list.add(new SocialModel("Messenger", R.drawable.ic_mg));
        list.add(new SocialModel("WhatsApp", R.drawable.ic_whatsappp));
        list.add(new SocialModel("Instragram", R.drawable.ic_ig));
        list.add(new SocialModel("Twitter", R.drawable.twitter));

        list.add(new SocialModel("Snapchat", R.drawable.ic_snapchatf));
        list.add(new SocialModel("YouTube", R.drawable.ic_yt));
        list.add(new SocialModel("TikTok", R.drawable.ic_tiktok));
        list.add(new SocialModel("Likee", R.drawable.ic_likee));
        list.add(new SocialModel("Pinterest", R.drawable.pinterest));
        list.add(new SocialModel("Netflix", R.drawable.ic_netflix));
        list.add(new SocialModel("Imdb", R.drawable.ic_imd));
        list.add(new SocialModel("Bing", R.drawable.ic_bing));
        list.add(new SocialModel("Duck Duck GO", R.drawable.ic_dg));
        list.add(new SocialModel("Reddit", R.drawable.ic_reddt));
        list.add(new SocialModel("Quora", R.drawable.ic_qoura));
        list.add(new SocialModel("Telegram", R.drawable.ic_telegrams));
        list.add(new SocialModel("Wikipedia", R.drawable.wk));
        list.add(new SocialModel("Vimeo", R.drawable.vimeo));
        list.add(new SocialModel("Tumblr", R.drawable.tumblr));
        list.add(new SocialModel("VK", R.drawable.vk));
        list.add(new SocialModel("Yelp", R.drawable.yelp));
        list.add(new SocialModel("Amazon", R.drawable.ic_aaa));
        list.add(new SocialModel("FlipKart", R.drawable.flipkart));
        list.add(new SocialModel("Box", R.drawable.ic_box));
        list.add(new SocialModel("Gmail", R.drawable.gmail));
        list.add(new SocialModel("Linkedin", R.drawable.linkedin));
        list.add(new SocialModel("Flickr", R.drawable.flickr));
        list.add(new SocialModel("ClassMate", R.drawable.ic_cm));
        list.add(new SocialModel("Meet Up", R.drawable.meetup));
        list.add(new SocialModel("Meetme", R.drawable.meetme));
        list.add(new SocialModel("Yahoo!", R.drawable.yahoo));
        list.add(new SocialModel("Sharechat!", R.drawable.ic_sharechat));

        SocialAdapter adapter = new SocialAdapter(getApplicationContext(), list, this, animation_type);
        recyclerView.setAdapter(adapter);


    }
*/

    @Override
    public void onItemClick(int position) {

    }

/*
    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:

      
                intent1 = new Intent(getApplicationContext(), WebView___.class);
                intent1.putExtra("key", "https://www.google.com/?hl=en");
                startActivity(intent1);

                break;

            case 1:


                intent2 = new Intent(getApplicationContext(), WebView___.class);
                intent2.putExtra("key", "https://www.facebook.com/");
                startActivity(intent2);
                break;

            case 2:


                intent2 = new Intent(getApplicationContext(), WebView___.class);
                intent2.putExtra("key", "https://www.messenger.com/");
                startActivity(intent2);
                break;

            case 3:
               
                intent3 = new Intent(getApplicationContext(), WebView___.class);
                intent3.putExtra("key", "https://www.whatsapp.com/");
                startActivity(intent3);
                break;


            case 4:

                intent4 = new Intent(getApplicationContext(), WebView___.class);
                intent4.putExtra("key", "https://www.instagram.com/");
                startActivity(intent4);
                break;

            case 5:

                intent5 = new Intent(getApplicationContext(), WebView___.class);
                intent5.putExtra("key", "https://twitter.com/");

                startActivity(intent5);
                break;


            case 6:

                intent6 = new Intent(getApplicationContext(), WebView___.class);
                intent6.putExtra("key", "https://www.snapchat.com/");

                startActivity(intent6);

                break;

            case 7:

                intent7 = new Intent(getApplicationContext(), WebView___.class);
                intent7.putExtra("key", "https://www.youtube.com/");

                startActivity(intent7);

                break;

            case 8:

                intent8 = new Intent(getApplicationContext(), WebView___.class);
                intent8.putExtra("key", "https://www.tiktok.com/");

                startActivity(intent8);
                break;

            case 9:

                intent9 = new Intent(getApplicationContext(), WebView___.class);
                intent9.putExtra("key", "https://likee.video/trending");

                startActivity(intent9);
                break;
            case 10:

                intent10 = new Intent(getApplicationContext(), WebView___.class);
                intent10.putExtra("key", "https://www.pinterest.com/");

                startActivity(intent10);
                break;

            case 11:


                intent11 = new Intent(getApplicationContext(), WebView___.class);
                intent11.putExtra("key", "https://www.netflix.com/bd/");

                startActivity(intent11);
                break;

            case 12:

                intent12 = new Intent(getApplicationContext(), WebView___.class);
                intent12.putExtra("key", "https://www.imdb.com/");

                startActivity(intent12);
                break;
            case 13:

                intent13 = new Intent(getApplicationContext(), WebView___.class);
                intent13.putExtra("key", "https://www.bing.com/");

                startActivity(intent13);
                break;
            case 14:

                intent14 = new Intent(getApplicationContext(), WebView___.class);
                intent14.putExtra("key", "https://duckduckgo.com/");

                startActivity(intent14);
                break;
            case 15:

                intent15 = new Intent(getApplicationContext(), WebView___.class);
                intent15.putExtra("key", "https://www.reddit.com/");

                startActivity(intent15);
                break;


            case 16:

                intent16 = new Intent(getApplicationContext(), WebView___.class);
                intent16.putExtra("key", "https://www.quora.com/");

                startActivity(intent16);
                break;


            case 17:

                intent17 = new Intent(getApplicationContext(), WebView___.class);
                intent17.putExtra("key", "https://telegram.org/");

                startActivity(intent17);
                break;


            case 18:

                intent18 = new Intent(getApplicationContext(), WebView___.class);
                intent18.putExtra("key", "https://www.wikipedia.org/");

                startActivity(intent18);
                break;


            case 19:

                intent19 = new Intent(getApplicationContext(), WebView___.class);
                intent19.putExtra("key", "https://vimeo.com/");

                startActivity(intent19);
                break;


            case 20:

                intent20 = new Intent(getApplicationContext(), WebView___.class);
                intent20.putExtra("key", "https://www.tumblr.com/");

                startActivity(intent20);
                break;


            case 21:

                intent21 = new Intent(getApplicationContext(), WebView___.class);
                intent21.putExtra("key", "https://vk.com/");

                startActivity(intent21);
                break;


            case 22:

                intent22 = new Intent(getApplicationContext(), WebView___.class);
                intent22.putExtra("key", "https://www.yelp.com/");

                startActivity(intent22);
                break;


            case 23:

                intent23 = new Intent(getApplicationContext(), WebView___.class);
                intent23.putExtra("key", "https://www.amazon.com/");

                startActivity(intent23);
                break;


            case 24:

                intent24 = new Intent(getApplicationContext(), WebView___.class);
                intent24.putExtra("key", "https://www.flipkart.com/");

                startActivity(intent24);
                break;


            case 25:

                intent25 = new Intent(getApplicationContext(), WebView___.class);
                intent25.putExtra("key", "https://www.box.com/home");

                startActivity(intent25);
                break;


            case 26:


                intent26 = new Intent(getApplicationContext(), WebView___.class);
                intent26.putExtra("key", "https://mail.google.com/");

                startActivity(intent26);
                break;


            case 27:

                intent27 = new Intent(getApplicationContext(), WebView___.class);
                intent27.putExtra("key", "https://www.linkedin.com/");

                startActivity(intent27);
                break;


            case 28:

                intent28 = new Intent(getApplicationContext(), WebView___.class);
                intent28.putExtra("key", "https://www.flickr.com/photos/tags/flicker/");

                startActivity(intent28);
                break;


            case 29:

                intent29 = new Intent(getApplicationContext(), WebView___.class);
                intent29.putExtra("key", "https://www.classmateshop.com/");

                startActivity(intent29);
                break;


            case 30:

                intent30 = new Intent(getApplicationContext(), WebView___.class);
                intent30.putExtra("key", "https://www.meetup.com/");

                startActivity(intent30);
                break;


            case 31:

                intent31 = new Intent(getApplicationContext(), WebView___.class);
                intent31.putExtra("key", "https://www.meetme.com/");

                startActivity(intent31);
                break;


            case 32:

                intent32 = new Intent(getApplicationContext(), WebView___.class);
                intent32.putExtra("key", "https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");

                startActivity(intent32);
                break;


            case 33:

                intent33 = new Intent(getApplicationContext(), WebView___.class);
                intent33.putExtra("key", "https://sharechat.com/");

                startActivity(intent33);
                break;






        }

    }
*/


    public static void loadInterstitialAds(Context context){
        //--------------------INTERSTITIAL ADS---------------------
        InterstitialAd.load(context, "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        Log.d("ADSDSDS", "onAdLoaded: ");
                        showInterstitial(context);
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("ADSDSDS", "Failed: ");

                    }
                });


                //--------------------INTERSTITIAL ADS---------------------
    }
    public static void showInterstitial(Context context) {
        if (admobInterstitialAds != null) {
            admobInterstitialAds.show((Activity) context);
        } else {
            Log.d("ADSDSDS", "The interstitial ad wasn't ready yet.");
        }
    }
}



