package com.example.mm.newametapp.helper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.mm.newametapp.R;
import com.example.mm.newametapp.storage.SharedPreferencesStorage;

import de.hdodenhof.circleimageview.CircleImageView;



public class CustomDialog {

    public static final String AVATAR_M_A = "m1";
    public static final String AVATAR_F_A = "f1";
    public static final String AVATAR_M_B = "m2";
    public static final String AVATAR_F_B = "f2";
    public static final String AVATAR_M_C = "m3";
    public static final String AVATAR_F_C = "f3";
    public static final String AVATAR_M_D = "m4";
    public static final String AVATAR_F_D = "f4";

    private CircleImageView mProfileCircleImageView;
    private Context mContext;

    public CustomDialog(Context context, CircleImageView circleImageView) {
        this.mContext = context;
        this.mProfileCircleImageView = circleImageView;
    }



    public void showCustomDialog() {
        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;

        final CircleImageView Male1 = dialog.findViewById(R.id.m1);
        final CircleImageView Female1 = dialog.findViewById(R.id.f1);
        final CircleImageView Male2 = dialog.findViewById(R.id.m2);
        final CircleImageView Female2 = dialog.findViewById(R.id.f2);
        final CircleImageView Male3 = dialog.findViewById(R.id.m3);
        final CircleImageView Female3 = dialog.findViewById(R.id.f3);
        final CircleImageView Male4 = dialog.findViewById(R.id.m4);
        final CircleImageView Female4 = dialog.findViewById(R.id.f4);

        final Button button = dialog.findViewById(R.id.cancel_button);


        Male1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.m1);
                storageStringImage (AVATAR_M_A);
                dialog.dismiss();
            }
        });
        Female1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.f1);
                storageStringImage (AVATAR_F_A);
                dialog.dismiss();
            }
        });
        Male2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.m2);
                storageStringImage (AVATAR_M_B);
                dialog.dismiss();
            }
        });
        Female2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.f2);
                storageStringImage (AVATAR_F_B);
                dialog.dismiss();
            }
        });
        Male3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.m3);
                storageStringImage (AVATAR_M_C);
                dialog.dismiss();
            }
        });
        Female3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.f3);
                storageStringImage (AVATAR_F_C);
                dialog.dismiss();
            }
        });
        Male4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.m4);
                storageStringImage (AVATAR_M_D);
                dialog.dismiss();
            }
        });
        Female4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageResources(R.drawable.f4);
                storageStringImage (AVATAR_F_D);
                dialog.dismiss();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(params);
    }

    private void storageStringImage (String key){
        SharedPreferencesStorage.saveImage(key, mContext);
    }

    private void setImageResources(int id){
        mProfileCircleImageView.setImageDrawable(mContext.getResources().getDrawable(id));
    }




}
