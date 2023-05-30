package com.example.calculatrice;

import androidx.appcompat.app.*;

import android.app.Activity;
import android.os.Bundle;

public class Calculater extends Activity {


    public enum Operator {ADD, SUB, MUL, DIV}


    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {

        if (x == 0) {
            throw new IllegalArgumentException("la division sur 0 est imppossible");
        }
            return x / y;
    }
}
