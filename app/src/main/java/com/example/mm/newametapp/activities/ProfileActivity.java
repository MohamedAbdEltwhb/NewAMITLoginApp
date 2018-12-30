package com.example.mm.newametapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mm.newametapp.R;
import com.example.mm.newametapp.helper.CustomDialog;
import com.example.mm.newametapp.helper.DisplayImageResources;
import com.example.mm.newametapp.storage.SharedPreferencesStorage;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_F_A;
import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_F_B;
import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_F_C;
import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_F_D;
import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_M_A;
import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_M_B;
import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_M_C;
import static com.example.mm.newametapp.helper.CustomDialog.AVATAR_M_D;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private DisplayImageResources mDisplayImageResources;
    private CustomDialog mCustomDialog ;
    private CircleImageView mProfileCircleImageView;
    private TextView mProfileTextView;


    private TextView f_name, l_name, email, password, phone;

    @Override
    protected void onStart() {
        super.onStart();
        getStorageData();
        mDisplayImageResources = new DisplayImageResources(ProfileActivity.this, mProfileCircleImageView);
        mDisplayImageResources.displayImage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        initListeners();
    }

    @Override
    public void onClick(View v) {

        int getId = v.getId();
        switch (getId){
            case R.id.profileCircleImageView:
                mCustomDialog = new CustomDialog(ProfileActivity.this, mProfileCircleImageView);
                mCustomDialog.showCustomDialog();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, UsersActivity.class);
        startActivity(intent);
    }

    private void getStorageData(){
        mProfileTextView.setText(SharedPreferencesStorage.getEmail(this));

        f_name.setText(SharedPreferencesStorage.getFirstName(this));
        l_name.setText(SharedPreferencesStorage.getLastName(this));
        email.setText(SharedPreferencesStorage.getEmail(this));
        password.setText(SharedPreferencesStorage.getPassword(this));
        phone.setText(SharedPreferencesStorage.getPhone(this));

    }

    private void initViews() {
        mProfileCircleImageView = findViewById(R.id.profileCircleImageView);
        mProfileTextView = findViewById(R.id.profileTextView);

        f_name = findViewById(R.id.f_name);
        l_name = findViewById(R.id.l_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
    }

    private void initListeners(){
        mProfileCircleImageView.setOnClickListener(this);
    }


}
