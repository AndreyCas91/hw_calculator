package ru.geekbrains.hw_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String KEY_SAVE = "calculator";

    private String btm_1 = "1";
    private String btm_2 = "2";
    private String btm_3 = "3";
    private String btm_4 = "4";
    private String btm_5 = "5";
    private String btm_6 = "6";
    private String btm_7 = "7";
    private String btm_8 = "8";
    private String btm_9 = "9";
    private String btm_0 = "0";
    private String clear = "";
    private String plus = "+";
    private String minus = "-";
    private String div = "/";
    private String mul = "*";

    private String conclusion = "";

    private TextView textView;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        } else if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_lang);
        }

        initView();
        initOnClickListener();
    }

    private void initOnClickListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
    }

    private void initView() {
        textView = findViewById(R.id._textViev);

        button1 = findViewById(R.id.btm_1);
        button2 = findViewById(R.id.btm_2);
        button3 = findViewById(R.id.btm_3);
        button4 = findViewById(R.id.btm_4);
        button5 = findViewById(R.id.btm_5);
        button6 = findViewById(R.id.btm_6);
        button7 = findViewById(R.id.btm_7);
        button8 = findViewById(R.id.btm_8);
        button9 = findViewById(R.id.btm_9);
        button10 = findViewById(R.id.btm_0);
        button11 = findViewById(R.id.btm_clear);
        button12 = findViewById(R.id.btm_plus);
        button13 = findViewById(R.id.btm_minus);
        button14 = findViewById(R.id.btm_mul);
        button15 = findViewById(R.id.btm_div);
        button16 = findViewById(R.id.btm_equality);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btm_1:
                setTextView(btm_1);
                break;
            case R.id.btm_2:
                setTextView(btm_2);
                break;
            case R.id.btm_3:
                setTextView(btm_3);
                break;
            case R.id.btm_4:
                setTextView(btm_4);
                break;
            case R.id.btm_5:
                setTextView(btm_5);
                break;
            case R.id.btm_6:
                setTextView(btm_6);
                break;
            case R.id.btm_7:
                setTextView(btm_7);
                break;
            case R.id.btm_8:
                setTextView(btm_8);
                break;
            case R.id.btm_9:
                setTextView(btm_9);
                break;
            case R.id.btm_0:
                setTextView(btm_0);
                break;
            case R.id.btm_clear:
                conclusion = "";
                setTextView(clear);
                break;
            case R.id.btm_plus:
                setTextView(plus);
                break;
            case R.id.btm_minus:
                setTextView(minus);
                break;
            case R.id.btm_div:
                setTextView(div);
                break;
            case R.id.btm_mul:
                setTextView(mul);
                break;
            case R.id.btm_equality:
// Не прописал метод для знака "=", а то придется до конца калькулятор дописать. Переживаю что вперед забегу.
                break;
        }
    }

    private void setTextView(String str) {
        conclusion = conclusion + str;
        textView.setText(String.format(Locale.getDefault(), "%s", conclusion));
    }

    private void setTextView() {
        textView.setText(String.format(Locale.getDefault(), "%s", conclusion));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(KEY_SAVE, conclusion);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        conclusion = (String) instanceState.getSerializable(KEY_SAVE);
        setTextView();
    }
}