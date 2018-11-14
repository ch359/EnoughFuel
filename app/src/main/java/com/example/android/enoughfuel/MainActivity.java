package com.example.android.enoughfuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class MainActivity extends AppCompatActivity {

    EditText carMakeButton;

    EditText carTank;
    Double fuelTankSize;

    Spinner fuelTankSpinner;
    String fuelTankUnit;

    EditText fuelEconomy;
    Spinner fuelEconomySpinner;
    String fuelEconomyUnit;

    EditText enterDistance;
    Spinner distanceSpinner;

    String distanceUnit;
    Car car;

    Button clicky_button;
    TextView result;

    CustomGauge gauge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carMakeButton = (EditText) findViewById(R.id.carDescription);
        carMakeButton.addTextChangedListener(fieldTextWatcher);

        carTank = (EditText) findViewById(R.id.fuelTankSize);
        carTank.addTextChangedListener(fieldTextWatcher);

        fuelTankSpinner = (Spinner) findViewById(R.id.fuelTankSpinner);
        ArrayAdapter<CharSequence> fuel_adapter = ArrayAdapter.createFromResource(this, R.array.liquid_units, R.layout.support_simple_spinner_dropdown_item);
        fuelTankSpinner.setAdapter(fuel_adapter);
        fuelTankSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fuelTankUnit = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fuelEconomy = (EditText) findViewById(R.id.carFuelEconomy);
        fuelEconomy.addTextChangedListener(fieldTextWatcher);

        fuelEconomySpinner = (Spinner) findViewById(R.id.carFuelEconomyUnits);
        ArrayAdapter<CharSequence> fuel_economy_adapter = ArrayAdapter.createFromResource(this, R.array.fuel_economy_units, R.layout.support_simple_spinner_dropdown_item);
        fuelEconomySpinner.setAdapter(fuel_economy_adapter);
        fuelEconomySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fuelEconomyUnit = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        enterDistance = (EditText) findViewById(R.id.enterDistance);
        enterDistance.addTextChangedListener(fieldTextWatcher);

        distanceSpinner = (Spinner) findViewById(R.id.distanceSpinner);
        ArrayAdapter<CharSequence> distance_adapter = ArrayAdapter.createFromResource(this, R.array.distance_units, R.layout.support_simple_spinner_dropdown_item);
        distanceSpinner.setAdapter(distance_adapter);
        distanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                distanceUnit = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        clicky_button = (Button) findViewById(R.id.clickButton);
        clicky_button.setOnClickListener(buttonListener);
        clicky_button.setEnabled(false);
        result = (TextView) findViewById(R.id.result);

        gauge = (CustomGauge) findViewById(R.id.gauge);




    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (inputManager != null) {
                inputManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
            runProgram();
        }
    };

    private TextWatcher fieldTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String carMake = carMakeButton.getText().toString().trim();
            String carFuelTank = carTank.getText().toString().trim();
            String carEconomy = fuelEconomy.getText().toString().trim();
            String distance = enterDistance.getText().toString().trim();

            clicky_button.setEnabled(!carMake.isEmpty() && !carFuelTank.isEmpty() && !carEconomy.isEmpty() && !distance.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void runProgram() {

        car = new Car(Double.valueOf(carTank.getText().toString()), fuelTankUnit) ;

        Calculator calc = new Calculator(Double.valueOf(enterDistance.getText().toString()), distanceUnit, car);
        Double rawResult = calc.fuelUse();
        result.setText(displayResult(rawResult));
        populateGauge(rawResult);
    }

    private void populateGauge(Double rawResult) {
        int fuelGaugeTopLimit = 180;
        int fuelGaugeMarker = fuelGaugeTopLimit - (int) Math.round(fuelGaugeTopLimit * rawResult/100);
        if (fuelGaugeMarker < fuelGaugeTopLimit) {
            gauge.setPointSize(0);
        }
        else
            gauge.setPointSize(fuelGaugeMarker);
    }

    private String displayResult(Double result) {
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(result) + "%";
    }




}