package com.example.mm.newametapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mm.newametapp.R;
import com.example.mm.newametapp.helper.InputValidation;
import com.example.mm.newametapp.storage.DataBaseHelper;
import com.example.mm.newametapp.storage.SharedPreferencesStorage;

import static com.example.mm.newametapp.helper.Constants.EXTRA_EMILE;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox mCheckBox;
    private EditText mEditTextMail, mEditTextPassword;
    private Button mLoginButton;
    private TextView mSignUnLink, mForgotPassword;

    private InputValidation mInputValidation;
    private DataBaseHelper mDataBaseHelper;

    private View mLoginCustomPar;
    private FrameLayout mCloseApp;
    private TextView mActivityName;


    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferencesStorage storage = new SharedPreferencesStorage();
        if (storage.getEmail(this) != null){
            Intent intent = new Intent(this, UsersActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initViews();
        initListeners();
        initObjects();

        mActivityName.setText(getString(R.string.login_activity));
        mCloseApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //System.exit(0);
                moveTaskToBack(true);
            }
        });
    }


    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId){
            case R.id.show_id:
                showAndHidePassword();
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(this, ForgotPassword.class));
                break;

            case R.id.signUp_link:
                startActivity(new Intent(this, SignUpActivity.class));
                break;

            case R.id.sign_in_button:
                connectAndStoreData();
                break;
        }
    }

    public void connectAndStoreData(){
        String textMail = mEditTextMail.getText().toString().trim();
        String textPassword = mEditTextPassword.getText().toString().trim();

        if (!mInputValidation.isValidMail(mEditTextMail)) {
            mEditTextMail.setError("Please Enter Correct Email..");
            return;

        }else if (!mInputValidation.isValidPassword(mEditTextPassword)) {
            mEditTextPassword.setError("Please Enter Strong Password..");
            return;

        }else {
            if (mDataBaseHelper.checkAndGetUser(textMail, textPassword)){

                SharedPreferencesStorage.saveEmail(textMail, this);
                SharedPreferencesStorage.savePassword(textPassword, this);

                Intent toMain = new Intent(this, UsersActivity.class);
                toMain.putExtra(EXTRA_EMILE, textMail);

                toMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                toMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                emptyInputEditText();
                startActivity(toMain);
                finish();

            }else {
                Toast.makeText(this, "FFFF", Toast.LENGTH_SHORT).show();

            }
        }

    }

    private void showAndHidePassword() {
        if (mCheckBox.isChecked()){
            mEditTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            mCheckBox.setText(getString(R.string.hide_checkBox));

        }else {
            mEditTextPassword.setInputType(129);
            mCheckBox.setText(getString(R.string.show_checkBox));
        }
    }

    private void initObjects(){
        mDataBaseHelper = new DataBaseHelper(this);
        mInputValidation = new InputValidation();
    }

    private void initViews() {
        mCheckBox = findViewById(R.id.show_id);
        mEditTextPassword = findViewById(R.id.passowrd_id);
        mEditTextMail = findViewById(R.id.email_id);
        mLoginButton = findViewById(R.id.sign_in_button);
        mSignUnLink = findViewById(R.id.signUp_link);
        mForgotPassword = findViewById(R.id.forgotPassword);

        mLoginCustomPar = findViewById(R.id.login_toolbar);
        mCloseApp = mLoginCustomPar.findViewById(R.id.close);
        mActivityName = mLoginCustomPar.findViewById(R.id.activity_name);

    }

    private void initListeners(){
        mCheckBox.setOnClickListener(this);
        mSignUnLink.setOnClickListener(this);
        mForgotPassword.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }

    private void emptyInputEditText(){
        mEditTextMail.setText(null);
        mEditTextPassword.setText(null);
    }


}
