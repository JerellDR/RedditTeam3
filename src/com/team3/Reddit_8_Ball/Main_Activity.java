package com.team3.Reddit_8_Ball;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.Random;

public class Main_Activity extends Activity {
    private TextView mMagikText;
    private String[] myArray;
    private static final Random mRgenerator = new Random();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myArray = getResources().getStringArray(R.array.questionsArray);
        mMagikText = (TextView) findViewById(R.id.magicTextView);


        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(3000);
        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(3000);

        mMagikText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //clicked = true;
                generateAnswer(in, out);
                return true;
            }
        });


    }

    private void generateAnswer(Animation in, Animation out) {

        mMagikText.startAnimation(out);

        String text = myArray[mRgenerator.nextInt(myArray.length)];
        mMagikText.setText(text);

        mMagikText.startAnimation(in);
    }
}
