package com.example.mm.newametapp.helper;

public abstract class Constants {

    public static final String EXTRA_EMILE = "EMAIL";

    /**
     *
     * @InputValidation Class Constants
     *
     *  (?=.*\d)      #   must contains one digit from 0-9
     *  (?=.*[a-z])   #   must contains one lowercase characters
     *  (?=.*[A-Z])   #   must contains one uppercase characters
     *  (?=.*[@#$%])  #   must contains one special symbols in the list "@#$%"
     *          .     #   match anything with previous condition checking
     *  {6,20}        #   length at least 6 characters and maximum of 20
     * */

    public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{6,20})";

   // public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
            //"(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
            //"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})";
    //public static final String PASSWORD_PATTERN ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    //String password_pattern = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    /**
     * @SharedPreferencesStorage Class Constants
     * */
    public static String KEY_EMAIL = "email";
    public static String KEY_PASSWORD = "password";

    public static String KEY_FNAME = "f_name";
    public static String KEY_LNAME = "l_name";
    public static String KEY_PHONE = "phone";

    public static String KEY_IMAGE = "image";



    /**
     * @DataBaseHelper Class Constants
     * */
    public static final String DATABASE_NAME = "regester.db";
    public static final String TABLE_NAME = "registeration";

    public static final int VERSION = 6;

    public static final String ID_1 = "ID";
    public static final String FIRSTNAME_2 = "FirstName";
    public static final String LASTNAME_3 = "LastName";
    public static final String PASSORD_4 = "Password";
    public static final String RE_PASSORD_5 = "RePassword";
    public static final String EMAIL_6 = "Email";
    public static final String PHONE_7 = "Phone";

    public static String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FIRSTNAME_2 + " TEXT," + LASTNAME_3 + " TEXT,"
            + PASSORD_4 + " TEXT," + RE_PASSORD_5 + " TEXT,"
            + EMAIL_6 + " TEXT," + PHONE_7 + " TEXT" + ")";

    public static String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
