package com.icruz.finctechmovsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.icruz.showcard.CardNumberHorizontalView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.container);

        CardNumberHorizontalView cardNumberHorizontalView = new CardNumberHorizontalView(this);
        cardNumberHorizontalView.setNumHidden(10);
        cardNumberHorizontalView.setText(new StringBuilder("5364781756187120"));
        cardNumberHorizontalView.setFormat(true);
        cardNumberHorizontalView.build();

        linearLayout.addView(cardNumberHorizontalView);
    }
}