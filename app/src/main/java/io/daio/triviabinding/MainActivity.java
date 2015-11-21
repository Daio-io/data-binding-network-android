package io.daio.triviabinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.daio.triviabinding.fragments.TriviaFragment;
import io.daio.triviabinding.networking.TriviaNetworkClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
