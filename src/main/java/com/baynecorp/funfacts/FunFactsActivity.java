package com.baynecorp.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    // Declare View variables
    private TextView factTextView;
    private Button showFactButton;
    private FactBook factBook = new FactBook();
    private RelativeLayout relativeLayout;
    private ColorWheel colorWheel = new ColorWheel();
    private String fact;
    private int color;

    //This saves the instanceState in case the user rotates the device
    //When the activity is destroyed and recreated it will grab the outState instance and show the fact that was on the screen before it was rotated
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

            outState.putString(KEY_FACT, fact);
            outState.putInt(KEY_COLOR, color);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layout file to the corresponding variable
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fact = factBook.getFact();
                // Update the screen with a new fact
                factTextView.setText(fact);
                
                color = colorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        };

        showFactButton.setOnClickListener(listener);

        Toast.makeText(this, "Here's yo fact!", Toast.LENGTH_SHORT).show();
    }
}
