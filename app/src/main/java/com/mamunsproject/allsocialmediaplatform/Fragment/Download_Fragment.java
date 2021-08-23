package com.mamunsproject.allsocialmediaplatform.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamunsproject.allsocialmediaplatform.R;
import com.mamunsproject.allsocialmediaplatform.WebView___;


public class Download_Fragment extends Fragment {

    CardView tiktokDownloder,facebookDownloader,youtubeDownloader;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_download_, container, false);




        tiktokDownloder=view.findViewById(R.id.tiktok_downloader);
        facebookDownloader=view.findViewById(R.id.facebookDownloader);
        youtubeDownloader=view.findViewById(R.id.youtube_downloader);





        tiktokDownloder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent36 = new Intent(getContext(), WebView___.class);
                intent36.putExtra("key", "https://tiktokdownload.online/");

                startActivity(intent36);
            }
        });




        facebookDownloader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent34 = new Intent(getContext(), WebView___.class);
                intent34.putExtra("key", "https://www.getfvid.com/");

                startActivity(intent34);

            }
        });




        youtubeDownloader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent35 = new Intent(getContext(), WebView___.class);
                intent35.putExtra("key", "https://keepv.id/3/");

                startActivity(intent35);




            }
        });




        return view;
    }
}