package com.javaandroid.androidimage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Integer> imageResources = new ArrayList<>(List.of(R.drawable.img1, R.drawable.img2, R.drawable.img3));
    List<Integer> textResources = new ArrayList<>(List.of(R.string.do_not_worry, R.string.be_happy, R.string.it_is_fine));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onPushMeButtonClick(View sender) {
        ImageView image = findViewById(R.id.imageView);
        TextView text = findViewById(R.id.textView);
        Random randomizer = new Random();
        int pos1 = randomizer.nextInt(3);
        int pos2 = randomizer.nextInt(3);
        image.setImageResource(imageResources.get(pos1));
        String textString = getResources().getString(textResources.get(pos2));
        text.setText(textString);
    }
}