package com.example.mm.newametapp.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mm.newametapp.R;
import com.example.mm.newametapp.helper.InputValidation;
import com.example.mm.newametapp.storage.DataBaseHelper;

import static com.example.mm.newametapp.helper.Constants.EXTRA_EMILE;

public class ConfirmPassword extends AppCompatActivity implements View.OnClickListener {

    private ActionBar mActionBar;
    private EditText mEditTextPassword, mEditTextRePassword;
    private Button mButtonReset;

    private InputValidation mInputValidation;
    private DataBaseHelper mDatabaseHelper;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);

        initObjects();
        initViews();
        initListeners();

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(getString(R.string.Confirm_Password));
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        Intent intent = getIntent();
        email = intent.getStringExtra(EXTRA_EMILE);
    }

    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId){
            case R.id.confirm_new_password_button:
                updatePassword();
                break;
        }
    }

    private void updatePassword() {
        String newPassword = mEditTextPassword.getText().toString().trim();
        String rePassword = mEditTextRePassword.getText().toString().trim();

        if (!mInputValidation.isValidPassword(mEditTextPassword)){
            mEditTextPassword.setError("Please Enter Strong Password..");
            return;

        }else if (!mInputValidation.isValidRePassword(mEditTextRePassword, mEditTextPassword)){
            mEditTextRePassword.setError("Re Password Is not equal Password..");
            return;

        }if (!mDatabaseHelper.checkAndGetUser(email)){
            Toast.makeText(this, "email doesn't exist",Toast.LENGTH_LONG).show();
            return;

        }else {
            mDatabaseHelper.updatePassword(email, newPassword, rePassword);
            Toast.makeText(this, "password reset successfully", Toast.LENGTH_SHORT).show();
            emptyInputEditText();

            Intent toSignInActivity = new Intent(this, SignInActivity.class);
            toSignInActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            toSignInActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(toSignInActivity);

            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int geIid = item.getItemId();
        switch (geIid){
            case android.R.id.home:
                startActivity(new Intent(ConfirmPassword.this, ForgotPassword.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initObjects(){
        mDatabaseHelper = new DataBaseHelper(this);
        mInputValidation = new InputValidation();
    }

    private void initViews() {
        mEditTextPassword = findViewById(R.id.new_password);
        mEditTextRePassword = findViewById(R.id.new_re_password);
        mButtonReset = findViewById(R.id.confirm_new_password_button);
    }

    private void initListeners(){
        mButtonReset.setOnClickListener(this);
    }

    private void emptyInputEditText(){
        mEditTextPassword.setText(null);
        mEditTextRePassword.setText(null);
    }


}
