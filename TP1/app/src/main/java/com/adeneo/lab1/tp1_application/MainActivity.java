package com.adeneo.lab1.tp1_application;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView commentaires;
    private LinearLayout btn_share;
    private LinearLayout btn_comment;
    private LinearLayout btn_like;
    private ImageView btn_close;
    private LinearLayout btn_back;
    private EditText editTextZone;
    private ImageButton btn_send;
    private TextView zoneCommentaire;

    private boolean btnLikeColor = true;
    private boolean firstComment = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_like = findViewById(R.id.btn_like);
        btn_like.setOnClickListener(this);

        btn_comment = findViewById(R.id.btn_comment);
        btn_comment.setOnClickListener(this);

        btn_share = findViewById(R.id.btn_comment);
        btn_share.setOnClickListener(this);

        btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(this);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

        editTextZone = findViewById(R.id.editTextZone);
        editTextZone.setOnClickListener(this);

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);

        zoneCommentaire = findViewById(R.id.zoneCommentaire);

    }


    @Override
    public void onClick(View v) {

        //Bouton like
        if (v.equals(btn_like)){
            LinearLayout linearLayout = (LinearLayout) v;

            if(btnLikeColor){
                TextView textView = (TextView) linearLayout.getChildAt(1);
                textView.setTextColor(getResources().getColor(R.color.black));

                ImageView imageView = (ImageView) linearLayout.getChildAt(0);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_thumb_up_black_24dp));

                Drawable button = v.getBackground();
                button.setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_OVER);

                btnLikeColor = false;
            }

            else{
                TextView textView = (TextView) linearLayout.getChildAt(1);
                textView.setTextColor(getResources().getColor(R.color.white));

                ImageView imageView = (ImageView) linearLayout.getChildAt(0);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_thumb_up_white_24dp));

                Drawable button = v.getBackground();
                button.setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_OVER);

                btnLikeColor = true;
            }

        }

        //Bouton commentaire
        if(v.equals(btn_comment)){
            if(editTextZone.hasFocus()){
                editTextZone.clearFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editTextZone.getWindowToken(), 0);
            }

            else{
                editTextZone.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(editTextZone, InputMethodManager.SHOW_IMPLICIT);
            }
        }

        //Bouton Retour et quitter
        if(v.equals(btn_back) || v.equals(btn_close)){
            MainActivity.this.finish();
        }

        if(v.equals(btn_send)){

            String message;

            if(firstComment){
                message = editTextZone.getText().toString();
                if(message.length()>0) {
                    zoneCommentaire.setText(null);

                    zoneCommentaire.setTypeface(null, Typeface.NORMAL);
                    zoneCommentaire.setGravity(Gravity.NO_GRAVITY);

                    firstComment = false;
                }
            }

            else {
                String ancienCommentaire = zoneCommentaire.getText().toString();
                message = ancienCommentaire + "\n\n" + editTextZone.getText().toString();
            }

            if(editTextZone.getText().length()>0){
                zoneCommentaire.setText(message);
                editTextZone.getText().clear();

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) zoneCommentaire.getLayoutParams();
                params.height = zoneCommentaire.getHeight() + 46;
                zoneCommentaire.setLayoutParams(params);
            }
        }
    }

}
