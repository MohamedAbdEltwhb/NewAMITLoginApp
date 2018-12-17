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

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener{

    private ActionBar mActionBar;
    private EditText mEditTextEmile;
    private Button mConfirmButton;

    private DataBaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initObjects();
        initViews();
        initListeners();

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(getString(R.string.Forgot_Password));
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_back);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int geIid = item.getItemId();
        switch (geIid){
            case android.R.id.home:
                startActivity(new Intent(ForgotPassword.this, SignInActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int getId = v.getId();
        switch (getId){
            case R.id.confirm_button:
                verifyFromSQLite();
                break;
        }

    }

    private void verifyFromSQLite() {
        String emile = mEditTextEmile.getText().toString().trim();

        if (emile.isEmpty()){
            Toast.makeText(this, "Please fill your email", Toast.LENGTH_LONG).show();
            return;

        }if(mDatabaseHelper.checkAndGetUser(emile)){
            Intent toConfirmPassword = new Intent(this, ConfirmPassword.class);
            toConfirmPassword.putExtra(EXTRA_EMILE, emile);
            emptyInputEditText();
            startActivity(toConfirmPassword);

        } else {
            Toast.makeText(this, "FFFF", Toast.LENGTH_SHORT).show();
        }

    }

    private void initObjects(){
        mDatabaseHelper = new DataBaseHelper(this);
    }

    private void initViews() {
        mEditTextEmile = findViewById(R.id.editTextEmail);
        mConfirmButton = findViewById(R.id.confirm_button);

    }

    private void initListeners(){
        mConfirmButton.setOnClickListener(this);
    }

    private void emptyInputEditText(){
        mEditTextEmile.setText(null);
    }
}
