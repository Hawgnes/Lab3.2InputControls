package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking UI to program
        spinnerAge = (Spinner)findViewById(R.id.spinner);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBox);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        // Create an adaptor
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.age_group,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Position:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium (View view) {
        int pos, cost = 0;
        pos = spinnerAge.getSelectedItemPosition();

        if (pos == 0)
            cost += 50;
        else if (pos == 1)
            cost += 55;
        else if (pos == 2)
            cost += 60;
        else if (pos == 3)
            cost += 70;
        else if (pos == 4)
            cost += 120;
        else if (pos == 5)
            cost += 160;
        else if (pos == 6)
            cost += 200;
        else if (pos == 7)
            cost += 250;

        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();
        if (gender == R.id.radioButtonMale) {
            if (pos == 2)
                cost += 50;
            else if (pos == 3)
                cost += 100;
            else if (pos == 4)
                cost += 100;
            else if (pos == 5)
                cost += 50;
            // TODO : calculate premium of male
        } //else {
            //  calculate premium of female
        //}

        if (checkBoxSmoker.isChecked()){
            if (pos == 3)
                cost += 100;
            else if (pos == 4)
                cost += 150;
            else if (pos == 5)
                cost += 150;
            else if (pos == 6)
                cost += 250;
            else if (pos == 7)
                cost += 250;
        }

        textViewPremium.setText("" + cost);
    }


    public void resetUI(View view){

    }
}
