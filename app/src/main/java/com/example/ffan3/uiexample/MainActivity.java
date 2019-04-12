package com.example.ffan3.uiexample;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {
    private CircleProgressBar mCircleProgressBar;
    private ImageView mMove;
    private Handler mHandler;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCircleProgressBar = findViewById(R.id.circle_progress);
        mMove = findViewById(R.id.img_move);

//        ObjectAnimator animator = ObjectAnimator.ofFloat(mMove,"translationY",1000.0f);
//        animator.setDuration(5000);
//        animator.setRepeatMode(ValueAnimator.RESTART);
//        animator.start();
        mHandler = new Handler();
        android.graphics.Path path = new android.graphics.Path();
        path.addRect(500,200,505,700, android.graphics.Path.Direction.CW);

        ObjectAnimator ivGreenObjectAnimator = ObjectAnimator.ofFloat(mMove, View.TRANSLATION_X, View.TRANSLATION_Y,path);
        ivGreenObjectAnimator.setDuration(5000).setRepeatCount(ValueAnimator.RESTART);
        ivGreenObjectAnimator.setRepeatMode(ValueAnimator.RESTART);
        ivGreenObjectAnimator.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                i++;
                if (i == 100){
                    i = 0;
                    mCircleProgressBar.setProgress(i);
                    mHandler.postDelayed(this,50);
                }else {
                    mCircleProgressBar.setProgress(i);
                    mHandler.postDelayed(this,50);
                }
            }
        };
        mHandler.post(runnable);
    }
}
