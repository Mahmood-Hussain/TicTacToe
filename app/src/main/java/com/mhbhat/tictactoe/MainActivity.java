package com.mhbhat.tictactoe;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer = 0;
    int myGameState[] = {2,2,2,2,2,2,2,2,2};
    public void imageTapped(View view){
        ImageView myTapped = (ImageView) view;
        int imageTappedTag = Integer.parseInt(myTapped.getTag().toString());
        if (myGameState[imageTappedTag] == 2){
            myGameState[imageTappedTag] = myActivePlayer;
            if (myActivePlayer == 0){
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            }else{
                myTapped.setImageResource(R.drawable.circle);
                myActivePlayer = 0;
            }
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Position already filled!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void playAgain(View view){
//        change myGameState back to 2
        for (int i = 0; i < myGameState.length; i++){
            myGameState[i] = 2;
        }


//        make active palyer 0 agian
        myActivePlayer = 0;


//        change all images to initial images
        LinearLayout linearLayoutone = (LinearLayout) findViewById(R.id.lineOne);
        for (int i = 0; i < linearLayoutone.getChildCount(); i++){
            ((ImageView) linearLayoutone.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayouttwo= (LinearLayout) findViewById(R.id.lineTwo);
        for (int i = 0; i < linearLayouttwo.getChildCount(); i++){
            ((ImageView) linearLayouttwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayoutthree = (LinearLayout) findViewById(R.id.lineThree);
        for (int i = 0; i < linearLayoutthree.getChildCount(); i++){
            ((ImageView) linearLayoutthree.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
