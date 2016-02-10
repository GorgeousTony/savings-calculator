package net.androidbootcamp.savingscalculator;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView result = (TextView) findViewById(R.id.txtResult);
        TextView goal = (TextView) findViewById(R.id.txtGoalMet);
        ImageView congrats = (ImageView) findViewById(R.id.imgCongrats);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float totalSavings = sharedPref.getFloat("key1", 0);
        float savingsGoal = sharedPref.getFloat("key2", 0);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        result.setText("Your total savings are " + currency.format(totalSavings) + ".");
        if (totalSavings < savingsGoal) {
            goal.setText("You did not meet your savings goal of " + currency.format(savingsGoal) + ".");
            congrats.setVisibility(View.INVISIBLE);
        } else {
            goal.setText("You met your savings goal of " + currency.format(savingsGoal) + "!");
            congrats.setVisibility(View.VISIBLE);
        }
    }
}
