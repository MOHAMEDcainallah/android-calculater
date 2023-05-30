package com.example.calculatrice;

import androidx.appcompat.app.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {


    private Calculater mcalculater;
    private EditText mx, my;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcalculater = new Calculater();
        mx = findViewById(R.id.operand_one);
        my = findViewById(R.id.operand_two);
        result = findViewById(R.id.Result_text);
                  }

    public void onAdd(View view) {
        compute(Calculater.Operator.ADD);
    }

    public void onSub(View view) {
        compute(Calculater.Operator.SUB);
    }

    public void onMul(View view) {
        compute(Calculater.Operator.MUL);
    }

    @SuppressLint("LongLogTag")
    public void onDiv(View view) {
        try {
            compute(Calculater.Operator.DIV);
        } catch (IllegalArgumentException ae) {
            Log.e("la division est impossible", "IllegalArgumentException", ae);
        }


    }

    @SuppressLint("LongLogTag")
    public void compute(Calculater.Operator operator) {
        double operandOne;
        double operandTwo;
        try{
            operandOne = getOperandOne(mx);
            operandTwo = getOperandOne(my);
        }
        catch (NumberFormatException nf) {
            Log.e("l'operand doit avoir une valeur",
                    "NumberFormatException", nf);
            result.setText(getString(R.string.ComputeError));
            return;
        }
        String r ;
        switch (operator){
            case ADD:
                r=String.valueOf(mcalculater.add(operandOne,operandTwo));
                break;
            case SUB:
                r=String.valueOf(mcalculater.sub(operandOne,operandTwo));
                break;
            case MUL:
                r=String.valueOf(mcalculater.mul(operandOne,operandTwo));
                break;
            case DIV:
                r=String.valueOf(mcalculater.div(operandOne,operandTwo));
                break;
            default: r = getString(R.string.ComputeError);
            break;
        }
                result.setText(r);
    }



public static Double getOperandOne( EditText mx ){

      String operandtext = getOperandtext(mx);
      return Double.valueOf(operandtext);

    }

    private static String getOperandtext(EditText mx) {
        String operandtext = mx.getText().toString();
        if (TextUtils.isEmpty(operandtext)) {
            throw new NumberFormatException("L'opérateur ne doit pas etre vide");
        }
            return  operandtext;
        }

}