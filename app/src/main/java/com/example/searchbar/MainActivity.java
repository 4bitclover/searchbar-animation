package com.example.searchbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        container.setOnFocusChangeListener(new ClickHandler());
    }

    private class ClickHandler implements View.OnFocusChangeListener {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Intent i =  new Intent(MainActivity.this, ExtendedBar.class);

            Pair[] paris = new Pair[1];
            paris[0] = new Pair(container, container.getTransitionName());

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, paris);
            startActivity(i, options.toBundle());
        }
    }
}
