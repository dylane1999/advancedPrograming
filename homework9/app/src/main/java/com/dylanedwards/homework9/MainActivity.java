package com.dylanedwards.homework9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer totalSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addButton).setOnClickListener(new AddButtonHandleClick());
        findViewById(R.id.submitButton).setOnClickListener(new HandleSubmitClick());
    }

    private class AddButtonHandleClick implements View.OnClickListener {
        public void onClick(View view) {
            TextView itemSelection = findViewById(R.id.itemInputText);
            TextView itemPrice = findViewById(R.id.priceInputText);
            if (itemSelection.getText().length() != 0 && itemPrice.getText().length() != 0 ){
                totalSum += Integer.parseInt(itemPrice.getText().toString());
                LinearLayout linearLayout = findViewById(R.id.linearLayout2);
                TextView newChoice = new TextView(view.getContext());
                newChoice.setText(String.format("%s %s", itemSelection.getText(), itemPrice.getText()));
                linearLayout.addView(newChoice);
                System.out.println(totalSum);
            }
        }
    }

    private class HandleSubmitClick implements View.OnClickListener {
        public void onClick(View view) {
            try {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("totalSum", totalSum);
                startActivity(intent);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }


}