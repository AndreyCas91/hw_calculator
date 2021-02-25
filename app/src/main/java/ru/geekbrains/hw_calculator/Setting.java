package ru.geekbrains.hw_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {

    private static final String NAME = "NAME";
    private static final String KEY = "key";

    private static final int DARK_THEME = 0;
    private static int DAY_THEME = 1;

    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSetting() == 0) {
            setTheme(R.style.Theme_Hw_calculator_one);
        } else if (getSetting() == 1) {
            setTheme(R.style.Theme_Hw_calculator);
        }
        setContentView(R.layout.activity_setting);
        initBtn();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSetting(DAY_THEME);
                recreate();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSetting(DARK_THEME);
                recreate();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initBtn() {
        button = findViewById(R.id.btm);
        button1 = findViewById(R.id.btn_day);
        button2 = findViewById(R.id.btn_dark);
    }

    private void saveSetting(int x) {
        SharedPreferences sp = getSharedPreferences(NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(KEY, x);
        editor.apply();
    }

    private int getSetting() {
        SharedPreferences sp = getSharedPreferences(NAME, MODE_PRIVATE);
        return sp.getInt(KEY, -1);
    }
}