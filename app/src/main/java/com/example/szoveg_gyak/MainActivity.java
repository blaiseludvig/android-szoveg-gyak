package com.example.szoveg_gyak;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnUpper;
    private Button btnLower;
    private Button btnRandom;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        set_components();
        add_event_listeners();
    }

    private void add_event_listeners() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                return;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                return;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                textView.setText(editText.getText());
            }
        });

        btnUpper.setOnClickListener(view -> {
            editText.setText(editText.getText().toString().toUpperCase());
        });

        btnLower.setOnClickListener(view -> {
            editText.setText(editText.getText().toString().toLowerCase());
        });

        btnRandom.setOnClickListener(view -> {
            int r = ThreadLocalRandom.current().nextInt(0, 255);
            int g = ThreadLocalRandom.current().nextInt(0, 255);
            int b = ThreadLocalRandom.current().nextInt(0, 255);

            // inverted colors
            int ir = 255 - r;
            int ig = 255 - g;
            int ib = 255 - b;

            textView.setBackgroundColor(Color.rgb(r, g, b));
            textView.setTextColor(Color.rgb(ir, ig, ib));

        });

    }

    private void set_components() {
        editText = findViewById(R.id.ediText);
        btnUpper = findViewById(R.id.btnUpper);
        btnLower = findViewById(R.id.btnLower);
        btnRandom = findViewById(R.id.btnRandom);
        textView = findViewById(R.id.textView);

    }

}