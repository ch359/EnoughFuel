package com.example.android.enoughfuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button clicky_button;
    TextView result;
    TextView enterDistance;
    Spinner distance_spinner;
    TextView carName;
    TextView carTank;
    Car car;
    String distanceUnit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clicky_button = (Button) findViewById(R.id.clickButton);
        clicky_button.setOnClickListener(buttonListener);
        result = (TextView) findViewById(R.id.result);
        distance_spinner = (Spinner) findViewById(R.id.distanceSpinner);
        ArrayAdapter<CharSequence> distance_adapter = ArrayAdapter.createFromResource(this, R.array.distance_units, R.layout.support_simple_spinner_dropdown_item);
        distance_spinner.setAdapter(distance_adapter);
        carName = (TextView) findViewById(R.id.carDescription);
        carTank = (TextView) findViewById(R.id.fuelTankSize);
        car = new Car(7, "gallons");
        carName.setText(car.getName());
        carTank.setText(car.displayFuelTankCapacity("gallons"));
        enterDistance = (TextView) findViewById(R.id.enterDistance);
        distance_spinner.setOnItemSelectedListener(this);
    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            runProgram();
        }
    };

    private void runProgram() {

        Calculator calc = new Calculator(sanitiseInput(), distanceUnit, car);
        result.setText(calc.fuelUse() + "%");


    }

    private double sanitiseInput() {
        double distance;
        try {
            distance = Integer.valueOf(enterDistance.getText().toString());
        }
        catch (NumberFormatException e) {
            System.err.println("Caught NumberFormatException: " + e.getMessage() );
            distance = 0;
        }

        return distance;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        distanceUnit = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Method stub
    }
}
