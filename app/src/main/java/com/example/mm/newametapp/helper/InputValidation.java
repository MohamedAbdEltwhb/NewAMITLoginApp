package com.example.mm.newametapp.helper;


import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

import static com.example.mm.newametapp.helper.Constants.PASSWORD_PATTERN;


public class InputValidation {


    private Pattern pattern;
    //private Matcher matcher;


    public boolean isValidMail(EditText emailInput) {
        String value = emailInput.getText().toString().trim();

        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            return false;

        }else {
            return true;
        }
    }

    public boolean isValidPassword(EditText passwordInput) {
        String value = passwordInput.getText().toString().trim();
//|| !Constants.PASSWORD_PATTERN.matches(value)

       // pattern = Pattern.compile(PASSWORD_PATTERN);

        if (value.isEmpty() || !Pattern.compile(PASSWORD_PATTERN).matcher(value).matches()){
            return false;
        }else {
            return true;
        }
    }

    public boolean isValidRePassword (EditText rePassword,EditText password){
        String value = rePassword.getText().toString().trim();
        String value1 = password.getText().toString().trim();

        if (value.isEmpty() || !value.contentEquals(value1)){
            return false;
        }else {
            return true;
        }
    }

    public boolean isValidMobile (EditText number){
        String value = number.getText().toString().trim();

        if (value.isEmpty() || !Patterns.PHONE.matcher(value).matches() || value.length() < 10 || value.length() > 11){
            return false;

        }else {
            return true;
        }
    }

    public boolean isValidName (EditText name){
        String value = name.getText().toString().trim();

        if (value.isEmpty() || value.length() < 3 || value.length() > 20){
            return false;

        }else {
            return true;
        }
    }

}
