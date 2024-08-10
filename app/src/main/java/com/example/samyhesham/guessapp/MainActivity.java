package com.example.samyhesham.guessapp;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.samyhesham.guessapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ImageView[] imageViews;
    List<Integer> numbers;
    int test;
    int cardId;
    byte wrongs;
    boolean gameStarted;
    ArrayList<ImageView> wallet = new ArrayList<>();
    Random random = new Random();
    int randomNumber;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void start(View view) {

        if (player != null){
            player.stop();
        }

        gameStarted = true;
        preparaCards();
        randomNumber = random.nextInt(9) + 1;
//        Toast.makeText(this, "" + randomNumber, Toast.LENGTH_SHORT).show();
        if (!wallet.isEmpty()) {
            wallet.clear();
            reload();
        }
        wrongs = 0;
        binding.resultNum.setText("");
        binding.statusGame.setText("");
    }

    private void preparaCards() {

        imageViews = new ImageView[]{binding.T1, binding.T2, binding.T3, binding.T4, binding.T5, binding.T6, binding.T7, binding.T8, binding.T9};

        numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 4, 3, 5, 6, 7, 8, 9);

        Collections.shuffle(numbers);

    }

    private void viewNumber(ImageView view) {
        for (int i = 0; i < imageViews.length; i++) {
            if (imageViews[i] == view) {
                test = numbers.get(i);
            }
        }

        cardId = getResources().getIdentifier("icon_" + test, "drawable", getPackageName());
        if (cardId != 0) {
            view.setImageResource(cardId);
        }
    }

    @SuppressLint("SetTextI18n")
    private void checkAnswer() {
        if (randomNumber == test) {
            binding.statusGame.setText("right");
            animation((byte) 2,binding.table);
            gameStarted = false;
            player = MediaPlayer.create(this,R.raw.clap);
            player.start();
        } else {
            binding.statusGame.setText("wrong");
            wrongs++;
            binding.resultNum.setText(String.valueOf(wrongs));
        }
        if (wrongs == 3) {
            Toast.makeText(this, "game over", Toast.LENGTH_SHORT).show();
            gameStarted = false;
            player = MediaPlayer.create(this,R.raw.fail);
            player.start();
        }
    }

    public void click9(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T9);
        checkAnswer();
        wallet.add(binding.T9);
    }

    public void click8(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T8);
        checkAnswer();
        wallet.add(binding.T8);
    }

    public void click7(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T7);
        checkAnswer();
        wallet.add(binding.T7);
    }

    public void click6(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T6);
        checkAnswer();
        wallet.add(binding.T6);
    }

    public void click5(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T5);
        checkAnswer();
        wallet.add(binding.T5);
    }

    public void click4(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T4);
        checkAnswer();
        wallet.add(binding.T4);
    }

    public void click3(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T3);
        checkAnswer();
        wallet.add(binding.T3);
    }

    public void click2(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T2);
        checkAnswer();
        wallet.add(binding.T2);
    }

    public void click(View view) {
        if (!gameStarted) {
//            Toast.makeText(this, "please click start", Toast.LENGTH_SHORT).show();
            animation((byte) 1,binding.start);
            return;
        }
        viewNumber(binding.T1);
        checkAnswer();
        wallet.add(binding.T1);
    }

    private void reload() {
        binding.T1.setImageResource(R.drawable.ic_gift);
        binding.T2.setImageResource(R.drawable.ic_gift);
        binding.T3.setImageResource(R.drawable.ic_gift);
        binding.T4.setImageResource(R.drawable.ic_gift);
        binding.T5.setImageResource(R.drawable.ic_gift);
        binding.T6.setImageResource(R.drawable.ic_gift);
        binding.T7.setImageResource(R.drawable.ic_gift);
        binding.T8.setImageResource(R.drawable.ic_gift);
        binding.T9.setImageResource(R.drawable.ic_gift);
    }

    private void animation(byte times, View view) {
        YoYo.with(Techniques.Shake).duration(600).repeat(times).playOn(view);
    }

    @Override
    public void onBackPressed() {
        if (player != null){
            player.stop();
        }
        super.onBackPressed();
    }
}