package com.dylanedwards.homework9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView totalSumView = findViewById(R.id.totalSumView);
        Integer totalSum = getIntent().getIntExtra("totalSum", 10);
        totalSumView.setText(String.valueOf(totalSum));
        findViewById(R.id.goHomeButton).setOnClickListener(new HandleSubmitClick());
    }


    private class HandleSubmitClick implements View.OnClickListener {
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        }
    }


}
