package com.ak.user.customcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{


    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonMin, buttonSub,  buttonDev, buttonC , buttonDot, buttonEqual ;

    EditText editText;
    TextView textView;



    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        textView = (TextView) findViewById(R.id.infoTextView);
        editText = (EditText)findViewById(R.id.editText);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        buttonAdd =(Button) findViewById(R.id.buttonadadd);
        buttonMin =(Button) findViewById(R.id.buttonmin);
        buttonSub =(Button) findViewById(R.id.buttonsub);
        buttonDev =(Button) findViewById(R.id.buttondiv);

        buttonDot =(Button) findViewById(R.id.buttondot);
        buttonEqual = (Button) findViewById(R.id.buttondeEcl);
        buttonC = (Button) findViewById(R.id.buttonC);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"0");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+".");
            }
        });

        // Operation

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
                CURRENT_ACTION = ADDITION;
                textView.setText(decimalFormat.format(valueOne)+ "+");
                editText.setText(null);
            }
        });

        buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
                CURRENT_ACTION = SUBTRACTION;
                textView.setText(decimalFormat.format(valueOne)+ "-");
                editText.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
                CURRENT_ACTION = MULTIPLICATION;
                textView.setText(decimalFormat.format(valueOne)+ "*");
                editText.setText(null);
            }
        });

        buttonDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
                CURRENT_ACTION = DIVISION;
                textView.setText(decimalFormat.format(valueOne)+ "/");
                editText.setText(null);
            }
        });


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(editText.getText().length()>0)
                {
                    CharSequence currentText =  editText.getText();
                    editText.setText(currentText.subSequence(0,currentText.length()-1));
                }
                else{
                        valueOne=Double.NaN;
                        valueTwo=Double.NaN;
                        editText.setText("");
                        textView.setText("");
                }

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
                textView.setText(textView.getText().toString() +
                decimalFormat.format(valueTwo)+ "=" + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION ='0';
            }
        });


    }

    private void makeCalculations()
    {
        if(!Double.isNaN(valueOne))
        {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);
            if (CURRENT_ACTION == ADDITION) {
                valueOne = this.valueOne + valueTwo;
            }
            else if (CURRENT_ACTION == SUBTRACTION)
            {
                valueOne = this.valueOne - valueTwo;
            }
            else if (CURRENT_ACTION == MULTIPLICATION)
            {
                valueOne = this.valueOne * valueTwo;
            }
            else if (CURRENT_ACTION == DIVISION)
            {
                valueOne = this.valueOne / valueTwo;
            }
        }
        else
            {
                try {
                valueOne = Double.parseDouble(editText.getText().toString());
            }
                catch (Exception e){}
            }
    }
}
