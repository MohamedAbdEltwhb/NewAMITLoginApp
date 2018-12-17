package com.example.mm.newametapp.customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TitleFont extends TextView {

    public TitleFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TitleFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleFont(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/font_a.ttf");
            setTypeface(tf);
        }
    }
}
