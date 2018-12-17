package com.example.mm.newametapp.model;

public final class UserInfo {

    private String mFirstName, mLastName,mPassword, mRe_password, mEmail, mPhoneN;

    public UserInfo(String mFirstName, String mLastName,
                    String mPassword, String mRe_password,
                    String mEmail, String mPhoneN) {

        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mPassword = mPassword;
        this.mRe_password = mRe_password;
        this.mEmail = mEmail;
        this.mPhoneN = mPhoneN;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmRe_password() {
        return mRe_password;
    }

    public void setmRe_password(String mRe_password) {
        this.mRe_password = mRe_password;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhoneN() {
        return mPhoneN;
    }

    public void setmPhoneN(String mPhoneN) {
        this.mPhoneN = mPhoneN;
    }
}
