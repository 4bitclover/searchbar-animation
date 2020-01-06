package com.example.searchbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExtendedBar extends AppCompatActivity {
    private Button button;
    private EditText container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extended_bar);

        button = findViewById(R.id.close);
        container = findViewById(R.id.container);

        button.setOnClickListener(new ClickHandler());

    }

    private class ClickHandler implements  View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i =  new Intent(ExtendedBar.this, MainActivity.class);

            Pair[] paris = new Pair[1];
            paris[0] = new Pair(container, container.getTransitionName());

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ExtendedBar.this, paris);
            startActivity(i, options.toBundle());
        }
    }
}
