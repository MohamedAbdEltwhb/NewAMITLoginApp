package com.example.mm.newametapp.helper;

import android.content.Context;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.mm.newametapp.R;
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

public class DisplayImageResources {

    private Context mContext;
    private CircleImageView mCircleImageView;

    public DisplayImageResources(Context mContext, CircleImageView mCircleImageView) {
        this.mContext = mContext;
        this.mCircleImageView = mCircleImageView;
    }

    public void displayImage(){
        String image = SharedPreferencesStorage.getImage(mContext);
        switch (image) {
            case AVATAR_M_A:
                setImageResources(R.drawable.m1);
                break;
            case AVATAR_F_A:
                setImageResources(R.drawable.f1);
                break;
            case AVATAR_M_B:
                setImageResources(R.drawable.m2);
                break;
            case AVATAR_F_B:
                setImageResources(R.drawable.f2);
                break;
            case AVATAR_M_C:
                setImageResources(R.drawable.m3);
                break;
            case AVATAR_F_C:
                setImageResources(R.drawable.f3);
                break;
            case AVATAR_M_D:
                setImageResources(R.drawable.m4);
                break;
            case AVATAR_F_D:
                setImageResources(R.drawable.f4);
                break;
            default:
                Toast.makeText(mContext, "no", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void setImageResources(int id){
        mCircleImageView.setImageDrawable(mContext.getResources().getDrawable(id));
    }
}
