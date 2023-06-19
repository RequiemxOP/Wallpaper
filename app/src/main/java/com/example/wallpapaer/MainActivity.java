package com.example.wallpapaer;
import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changewallpaper;
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    int prev=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytimer = new Timer();
        wpm=WallpaperManager.getInstance(this);
        changewallpaper=findViewById(R.id.button);
        changewallpaper.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view){
                setWallpaper();
            }
        });
    }
    private void setWallpaper() {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1) {
                    drawable = getResources().getDrawable(R.drawable.candle);
                    prev = 2;
                }
                else if(prev==2) {
                    drawable = getResources().getDrawable(R.drawable.lime);
                    prev=3;
                }
                else if(prev==3) {
                    drawable = getResources().getDrawable(R.drawable.leaf);
                    prev=4;
                }
                else if(prev==4) {
                    drawable = getResources().getDrawable(R.drawable.think);
                    prev=5;
                }
                Bitmap wallpapaer = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpapaer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },0,30000);

    }
}
