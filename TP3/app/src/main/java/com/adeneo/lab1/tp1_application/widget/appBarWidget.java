package com.adeneo.lab1.tp1_application.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adeneo.lab1.tp1_application.R;

public class appBarWidget extends LinearLayout {

    private TextView mainTitleTextView;
    private TextView backTitleTextView;

    public appBarWidget(Context context) {
        super(context);
        this.initialize(context, null);
    }

    public appBarWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initialize(context, attrs);
    }

    public appBarWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initialize(context, attrs);

    }

    public appBarWidget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs) {
        inflate(context, R.layout.appbar_widget, this);

        this.mainTitleTextView = findViewById(R.id.mainTitle);
        this.backTitleTextView = findViewById(R.id.backTitle);

        if(attrs != null){
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.appBarWidget, 0,0);

            String mainTitle = array.getString(R.styleable.appBarWidget_mainTitle);
            if(this.mainTitleTextView != null) {
                this.mainTitleTextView.setText(mainTitle);
            }

            String backTitle = array.getString(R.styleable.appBarWidget_backTitle);
            if(this.backTitleTextView != null) {
                this.backTitleTextView.setText(backTitle);
            }
        }
    }
}
