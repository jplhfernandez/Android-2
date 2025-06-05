package com.jp.atv2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jp.atv2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // João Pedro Leme Hernandez Fernandez - RA: 1110482412013

    private EditText editTextBaseMaior;
    private EditText editTextBaseMenor;
    private EditText editTextAltura;
    private Button buttonCalculate;
    private TextView textViewResult;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBaseMaior = findViewById(R.id.editTextBaseMaior);
        editTextBaseMenor = findViewById(R.id.editTextBaseMenor);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);
        textViewMessage = findViewById(R.id.textViewMessage);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTrapezoidArea();
            }
        });
    }

    private void calculateTrapezoidArea() {
        try {
            int baseMaior = Integer.parseInt(editTextBaseMaior.getText().toString());
            int baseMenor = Integer.parseInt(editTextBaseMenor.getText().toString());
            int altura = Integer.parseInt(editTextAltura.getText().toString());

            textViewResult.setText("");
            textViewMessage.setText("");

            if (baseMaior < 0 || baseMenor < 0 || altura < 0) {
                textViewMessage.setText(R.string.positive_values_only);
                return;
            }

            if (baseMaior < baseMenor) {
                textViewMessage.setText(R.string.base_maior_error);
                return;
            }

            int area = ((baseMaior + baseMenor) * altura) / 2;
            textViewResult.setText(getString(R.string.area_result, area));

        } catch (NumberFormatException e) {
            textViewMessage.setText(R.string.invalid_input);
        }
    }
}}