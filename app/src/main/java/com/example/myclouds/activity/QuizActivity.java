package com.example.myclouds.activity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import com.example.myclouds.R;

public class QuizActivity extends MainMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
