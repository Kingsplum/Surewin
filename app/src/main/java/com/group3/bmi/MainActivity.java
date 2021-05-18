package com.group3.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText height,weight;
    TextView result,category;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        category = (TextView) findViewById(R.id.category);



        TextWatcher textWatcher = new TextWatcher(){
            String input_weight = weight.getText().toString();
            String input_height = height.getText().toString();

            @Override
            public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
            {
                // TODO: Implement this method
            }

            @Override
            public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
            {
                // TODO: Implement this method
                if(!height.getText().toString().equals("")  && !weight.getText().toString().equals("")){


                    Float temp1 = Float.parseFloat(height.getText().toString());
                    Float temp2 = Float.parseFloat(weight.getText().toString());

                    Float bmiValue = temp2 / ((temp1/100)*(temp1/100));

                    result.setText(bmiValue.toString());

                    if (bmiValue < 16) {
                        category.setText("Severly Under Weight");
                        category.setTextColor(getResources().getColor(R.color.red));


                    } else if (bmiValue < 18.5) {
                        category.setText("Under Weight");
                        category.setTextColor(getResources().getColor(R.color.red));

                    } else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
                        category.setText("Normal Weight");
                        category.setTextColor(getResources().getColor(R.color.green));

                    } else if (bmiValue >= 25 && bmiValue <= 29.9) {
                        category.setText("Over Weight");
                        category.setTextColor(getResources().getColor(R.color.red));

                    } else {
                        category.setText("Obese");
                        category.setTextColor(getResources().getColor(R.color.red));

                    }


                }
            }

            @Override
            public void afterTextChanged(Editable p1)
            {
                // TODO: Implement this method
            }


        };
        height.addTextChangedListener(textWatcher);
        weight.addTextChangedListener(textWatcher);



    }
}