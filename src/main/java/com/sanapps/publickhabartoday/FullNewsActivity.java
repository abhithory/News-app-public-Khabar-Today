package com.sanapps.publickhabartoday;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class FullNewsActivity extends AppCompatActivity {

    TextView postTitle, postDes;
    private WebView postDes_webview;
    ImageView imgView;

    private ShimmerFrameLayout full_news_shimmer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);


        Toolbar pkt_appbar = findViewById(R.id.pkt_appbarfull);
        full_news_shimmer = findViewById(R.id.full_news_shimmerlayout);


        setSupportActionBar(pkt_appbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        ImageButton back =  findViewById(R.id.back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        postDes_webview = findViewById(R.id.post_des_webview);
        Document documents = Jsoup.parse(getIntent().getStringExtra("content"));

        String data = documents.toString();

        postDes_webview.requestFocus();
        postDes_webview.getSettings().setLightTouchEnabled(true);
        postDes_webview.getSettings().setJavaScriptEnabled(true);
        postDes_webview.getSettings().setGeolocationEnabled(true);
        postDes_webview.setSoundEffectsEnabled(true);
        postDes_webview.loadData(data,
                "text/html", "UTF-8");
        postDes_webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {

                }
                if (progress == 100) {
                    full_news_shimmer.stopShimmer();
                    full_news_shimmer.setVisibility(View.GONE);
                }
            }
        });


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.profile){

           // Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}