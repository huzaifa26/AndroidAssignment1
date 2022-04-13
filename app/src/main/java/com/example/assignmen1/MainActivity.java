package com.example.assignmen1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String buttonText="";
    String[] digit1;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public float sum(float num1, @NonNull String op, float num2){
        switch(op) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
        }
        return 1;
    }

    public float checkOP(){
        if (buttonText.contains("+")){
            operator="+";
            digit1=buttonText.split("\\+");
        }

        if (buttonText.contains("-")){
            operator="-";
            digit1=buttonText.split("-");
        }

        if (buttonText.contains("*")){
            operator="*";
            digit1=buttonText.split("\\*");
        }

        if (buttonText.contains("/")){
            operator="/";
            digit1=buttonText.split("/");
        }
        float answer=sum(Float.parseFloat(digit1[0]),operator,Float.parseFloat(digit1[1]));
        return answer;
    }

    public void buttonOnClick(@NonNull View view) {
        Button b = findViewById(view.getId());
        TextView tvValue = (TextView) findViewById(R.id.textViewValue);
        TextView tvAnswer = (TextView) findViewById(R.id.textViewAnswer);

        if (view.getId() == R.id.on_off){
            tvValue.setText("");
            tvAnswer.setText("");
            buttonText="";
            return;
        }

        if(b.getText().toString().contains("=")
        || (buttonText.contains("+") && b.getText().toString().contains("+"))
        || (buttonText.contains("+") && b.getText().toString().contains("-"))
        || (buttonText.contains("+") && b.getText().toString().contains("*"))
        || (buttonText.contains("+") && b.getText().toString().contains("/"))

        || (buttonText.contains("-") && b.getText().toString().contains("-"))
        || (buttonText.contains("-") && b.getText().toString().contains("+"))
        || (buttonText.contains("-") && b.getText().toString().contains("*"))
        || (buttonText.contains("-") && b.getText().toString().contains("/"))

        || (buttonText.contains("*") && b.getText().toString().contains("*"))
        || (buttonText.contains("*") && b.getText().toString().contains("-"))
        || (buttonText.contains("*") && b.getText().toString().contains("/"))
        || (buttonText.contains("*") && b.getText().toString().contains("+"))

        || (buttonText.contains("/") && b.getText().toString().contains("/"))
        || (buttonText.contains("/") && b.getText().toString().contains("-"))
        || (buttonText.contains("/") && b.getText().toString().contains("+"))
        || (buttonText.contains("/") && b.getText().toString().contains("*"))){
            float answer=checkOP();
            buttonText=Float.toString((float) answer);
            tvValue.setText(Float.toString((float) answer));
            tvAnswer.setText(Float.toString((float) answer));
        }

        if(!b.getText().toString().contains("=")){
            buttonText = buttonText + b.getText().toString();
            tvValue.setText(buttonText);
        }
    }
}