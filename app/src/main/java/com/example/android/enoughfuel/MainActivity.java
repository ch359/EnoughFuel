package com.example.android.enoughfuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button clicky_button;
    TextView result;
    TextView enterDistance;
    Spinner distance_spinner;
    TextView carName;
    TextView carTank;
    Car car;


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
        car = new Car(7); // TODO accept variable inputs
        carName.setText(car.getName());
        carTank.setText((String.valueOf(car.getFuelTankCapacityInGallons())));
        enterDistance = (TextView) findViewById(R.id.enterDistance);
    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            runProgram();
        }
    };





    private void runProgram() {

        Calculator calc = new Calculator(Integer.valueOf(enterDistance.getText().toString()), car);
        result.setText(calc.fuelUse() + "%");

    }
}
