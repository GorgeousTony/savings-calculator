package net.androidbootcamp.savingscalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float initAmount;
    float interestRate;
    int numberOfYears;
    float savingsGoal;
    float totalSavings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText amount = (EditText)findViewById(R.id.txtAmount);
        final EditText rate = (EditText)findViewById(R.id.txtRate);
        final EditText years =(EditText)findViewById(R.id.txtYears);
        final EditText goal = (EditText)findViewById(R.id.txtGoal);
        Button button = (Button)findViewById(R.id.btnCalc);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAmount = Float.parseFloat(amount.getText().toString());
                interestRate = Float.parseFloat(rate.getText().toString());
                numberOfYears = Integer.parseInt(years.getText().toString());
                savingsGoal = Float.parseFloat(goal.getText().toString());
                totalSavings = initAmount * (1 + ((interestRate / 100) * numberOfYears));
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", totalSavings);
                editor.putFloat("key2", savingsGoal);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Results.class));
            }
        });
    }
}
