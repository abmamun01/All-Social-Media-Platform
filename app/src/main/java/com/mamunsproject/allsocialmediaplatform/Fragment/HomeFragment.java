package com.mamunsproject.allsocialmediaplatform.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.mamunsproject.allsocialmediaplatform.Adapter.SocialAdapter;
import com.mamunsproject.allsocialmediaplatform.MainActivity;
import com.mamunsproject.allsocialmediaplatform.Model.SocialModel;
import com.mamunsproject.allsocialmediaplatform.R;
import com.mamunsproject.allsocialmediaplatform.Utils.ItemAnimation;
import com.mamunsproject.allsocialmediaplatform.WebView___;
import java.util.ArrayList;



public class HomeFragment extends Fragment implements SocialAdapter.OnItemListener {


    RecyclerView recyclerView;
    private int animation_type = ItemAnimation.FADE_IN;
    private InterstitialAd interstitialAd;
    private com.google.android.gms.ads.interstitial.InterstitialAd admobInterstitialAds;
    public AdRequest adRequest;



    Intent intent1, intent2, intent3, intent4, intent5, intent6, intent7, intent8, intent9, intent10, intent11, intent12,
            intent13, intent14, intent15, intent16, intent17, intent18, intent19, intent20, intent21, intent22, intent23, intent24, intent25,
            intent26, intent27, intent28, intent29, intent30, intent31, intent32, intent33,
            intent34, intent35, intent36, intent37, intent38;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        recyclerView = view.findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        adRequest = new AdRequest.Builder().build();


        //--------------------INTERSTITIAL ADS---------------------
        com.google.android.gms.ads.interstitial.InterstitialAd.load(getContext(), "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        Log.d("ADSDSDS", "onAdLoaded: ");

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("ADSDSDS", "Failed: ");

                    }
                });


        //--------------------INTERSTITIAL ADS---------------------
        //===============================================FB INTERSTITIAL AD============================================

        interstitialAd = new InterstitialAd(getContext(), "335418644388179_335418824388161");


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


        //===============================================FB INTERSTITIAL AD============================================
/*
        ScheduledExecutorService scheduledExecutorService
                = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (interstitialAd.isAdInvalidated()) {
                            interstitialAd.loadAd();
                        }


                    }
                });
            }
        },250,250, TimeUnit.SECONDS);

*/





        setRecyclerView();

        return view;
    }


    
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

        SocialAdapter adapter = new SocialAdapter(getActivity(), list, this, animation_type);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:

                if (admobInterstitialAds != null) {
                    admobInterstitialAds.show((Activity) getContext());
                } else {
                    Log.d("ADSDSDS", "The interstitial ad wasn't ready yet.");
                }
                intent1 = new Intent(getContext(), WebView___.class);
                intent1.putExtra("key", "https://www.google.com/?hl=en");
                startActivity(intent1);

                break;

            case 1:
                if (admobInterstitialAds != null) {
                    admobInterstitialAds.show((Activity) getContext());
                } else {
                    Log.d("ADSDSDS", "The interstitial ad wasn't ready yet.");
                }
                intent2 = new Intent(getContext(), WebView___.class);
                intent2.putExtra("key", "https://www.facebook.com/");
                startActivity(intent2);
                break;

            case 2:
               MainActivity.loadInterstitialAds(getContext());
                intent2 = new Intent(getContext(), WebView___.class);
                intent2.putExtra("key", "https://www.messenger.com/");
                startActivity(intent2);
                break;

            case 3:
               MainActivity.loadInterstitialAds(getContext());

                intent3 = new Intent(getContext(), WebView___.class);
                intent3.putExtra("key", "https://www.whatsapp.com/");
                startActivity(intent3);
                break;


            case 4:
               MainActivity.loadInterstitialAds(getContext());
                intent4 = new Intent(getContext(), WebView___.class);
                intent4.putExtra("key", "https://www.instagram.com/");
                startActivity(intent4);
                break;

            case 5:
               MainActivity.loadInterstitialAds(getContext());
                intent5 = new Intent(getContext(), WebView___.class);
                intent5.putExtra("key", "https://twitter.com/");

                startActivity(intent5);
                break;


            case 6:
               MainActivity.loadInterstitialAds(getContext());
                intent6 = new Intent(getContext(), WebView___.class);
                intent6.putExtra("key", "https://www.snapchat.com/");

                startActivity(intent6);

                break;

            case 7:
               MainActivity.loadInterstitialAds(getContext());
                intent7 = new Intent(getContext(), WebView___.class);
                intent7.putExtra("key", "https://www.youtube.com/");

                startActivity(intent7);

                break;

            case 8:
               MainActivity.loadInterstitialAds(getContext());
                intent8 = new Intent(getContext(), WebView___.class);
                intent8.putExtra("key", "https://www.tiktok.com/");

                startActivity(intent8);
                break;

            case 9:
               MainActivity.loadInterstitialAds(getContext());
                intent9 = new Intent(getContext(), WebView___.class);
                intent9.putExtra("key", "https://likee.video/trending");

                startActivity(intent9);
                break;
            case 10:
               MainActivity.loadInterstitialAds(getContext());
                intent10 = new Intent(getContext(), WebView___.class);
                intent10.putExtra("key", "https://www.pinterest.com/");

                startActivity(intent10);
                break;

            case 11:

               MainActivity.loadInterstitialAds(getContext());
                intent11 = new Intent(getContext(), WebView___.class);
                intent11.putExtra("key", "https://www.netflix.com/bd/");

                startActivity(intent11);
                break;

            case 12:
               MainActivity.loadInterstitialAds(getContext());
                intent12 = new Intent(getContext(), WebView___.class);
                intent12.putExtra("key", "https://www.imdb.com/");

                startActivity(intent12);
                break;
            case 13:
               MainActivity.loadInterstitialAds(getContext());
                intent13 = new Intent(getContext(), WebView___.class);
                intent13.putExtra("key", "https://www.bing.com/");

                startActivity(intent13);
                break;
            case 14:
               MainActivity.loadInterstitialAds(getContext());
                intent14 = new Intent(getContext(), WebView___.class);
                intent14.putExtra("key", "https://duckduckgo.com/");

                startActivity(intent14);
                break;
            case 15:
               MainActivity.loadInterstitialAds(getContext());
                intent15 = new Intent(getContext(), WebView___.class);
                intent15.putExtra("key", "https://www.reddit.com/");

                startActivity(intent15);
                break;


            case 16:
               MainActivity.loadInterstitialAds(getContext());
                intent16 = new Intent(getContext(), WebView___.class);
                intent16.putExtra("key", "https://www.quora.com/");

                startActivity(intent16);
                break;


            case 17:
               MainActivity.loadInterstitialAds(getContext());
                intent17 = new Intent(getContext(), WebView___.class);
                intent17.putExtra("key", "https://telegram.org/");

                startActivity(intent17);
                break;


            case 18:
               MainActivity.loadInterstitialAds(getContext());
                intent18 = new Intent(getContext(), WebView___.class);
                intent18.putExtra("key", "https://www.wikipedia.org/");

                startActivity(intent18);
                break;


            case 19:
               MainActivity.loadInterstitialAds(getContext());
                intent19 = new Intent(getContext(), WebView___.class);
                intent19.putExtra("key", "https://vimeo.com/");

                startActivity(intent19);
                break;


            case 20:
               MainActivity.loadInterstitialAds(getContext());
                intent20 = new Intent(getContext(), WebView___.class);
                intent20.putExtra("key", "https://www.tumblr.com/");

                startActivity(intent20);
                break;


            case 21:
               MainActivity.loadInterstitialAds(getContext());
                intent21 = new Intent(getContext(), WebView___.class);
                intent21.putExtra("key", "https://vk.com/");

                startActivity(intent21);
                break;


            case 22:
               MainActivity.loadInterstitialAds(getContext());
                intent22 = new Intent(getContext(), WebView___.class);
                intent22.putExtra("key", "https://www.yelp.com/");

                startActivity(intent22);
                break;


            case 23:
               MainActivity.loadInterstitialAds(getContext());
                intent23 = new Intent(getContext(), WebView___.class);
                intent23.putExtra("key", "https://www.amazon.com/");

                startActivity(intent23);
                break;


            case 24:
               MainActivity.loadInterstitialAds(getContext());
                intent24 = new Intent(getContext(), WebView___.class);
                intent24.putExtra("key", "https://www.flipkart.com/");

                startActivity(intent24);
                break;


            case 25:
               MainActivity.loadInterstitialAds(getContext());
                intent25 = new Intent(getContext(), WebView___.class);
                intent25.putExtra("key", "https://www.box.com/home");

                startActivity(intent25);
                break;


            case 26:
                if (interstitialAd.isAdInvalidated()) {
                interstitialAd.loadAd();
            }

                intent26 = new Intent(getContext(), WebView___.class);
                intent26.putExtra("key", "https://mail.google.com/");

                startActivity(intent26);
                break;


            case 27:
               MainActivity.loadInterstitialAds(getContext());
                intent27 = new Intent(getContext(), WebView___.class);
                intent27.putExtra("key", "https://www.linkedin.com/");

                startActivity(intent27);
                break;


            case 28:
               MainActivity.loadInterstitialAds(getContext());
                intent28 = new Intent(getContext(), WebView___.class);
                intent28.putExtra("key", "https://www.flickr.com/photos/tags/flicker/");

                startActivity(intent28);
                break;


            case 29:
               MainActivity.loadInterstitialAds(getContext());
                intent29 = new Intent(getContext(), WebView___.class);
                intent29.putExtra("key", "https://www.classmateshop.com/");

                startActivity(intent29);
                break;


            case 30:
               MainActivity.loadInterstitialAds(getContext());
                intent30 = new Intent(getContext(), WebView___.class);
                intent30.putExtra("key", "https://www.meetup.com/");

                startActivity(intent30);
                break;


            case 31:
               MainActivity.loadInterstitialAds(getContext());
                intent31 = new Intent(getContext(), WebView___.class);
                intent31.putExtra("key", "https://www.meetme.com/");

                startActivity(intent31);
                break;


            case 32:
               MainActivity.loadInterstitialAds(getContext());
                intent32 = new Intent(getContext(), WebView___.class);
                intent32.putExtra("key", "https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");

                startActivity(intent32);
                break;


            case 33:
               MainActivity.loadInterstitialAds(getContext());
                intent33 = new Intent(getContext(), WebView___.class);
                intent33.putExtra("key", "https://sharechat.com/");

                startActivity(intent33);
                break;






        }

    }
}