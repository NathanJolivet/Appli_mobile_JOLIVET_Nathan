package com.adeneo.lab1.tp1_application.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.adapters.CategoryAdapter;
import com.adeneo.lab1.tp1_application.adapters.CommentAdapter;
import com.adeneo.lab1.tp1_application.manager.MovieManager;
import com.adeneo.lab1.tp1_application.objects.Comment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout btn_share;
    private LinearLayout btn_comment;
    private LinearLayout btn_like;
    private ImageView btn_close;
    private LinearLayout btn_back;
    private EditText editTextZone;
    private ImageButton btn_send;
    private RecyclerView zoneCommentaire;
    private ScrollView scrollView;
    private TextView mainTitle;

    private TextView tableTitle;
    private TextView tableOriginalTitle;
    private TextView tableDescription;
    private TextView tableKeyWords;
    private ImageView imageMovie;

    private boolean btnLikeColor = true;

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

        scrollView = findViewById(R.id.scrollView);

        mainTitle = findViewById(R.id.mainTitle);

        tableTitle = findViewById(R.id.tableTitle);

        tableOriginalTitle = findViewById(R.id.tableOriginalTitle);

        tableDescription = findViewById(R.id.tableDescription);

        tableKeyWords = findViewById(R.id.tableKeyWords);

        imageMovie = findViewById(R.id.imageMovie);

        zoneCommentaire = findViewById(R.id.zoneCommentaire);
        CommentAdapter commentAdapter = new CommentAdapter();
        this.zoneCommentaire.setAdapter(commentAdapter);
        this.zoneCommentaire.setLayoutManager(new LinearLayoutManager(this));

        this.zoneCommentaire.setNestedScrollingEnabled(false);
        this.zoneCommentaire.getAdapter().notifyDataSetChanged();

        List<Comment> comments = MovieManager.getInstance().getComments();

        commentAdapter.setComments(comments);
        commentAdapter.notifyDataSetChanged();


    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent i = getIntent();

        String title = i.getStringExtra("Titre");
        mainTitle.setText(title);
        tableTitle.setText(title);
        tableOriginalTitle.setText(title);
        tableDescription.setText( i.getStringExtra("Description"));
        imageMovie.setImageResource(i.getIntExtra("Image", 0));


    }

    @Override
    public void onClick(View v) {

        //Bouton like
        if (v.equals(btn_like)) {
            LinearLayout linearLayout = (LinearLayout) v;

            if (btnLikeColor) {
                TextView textView = (TextView) linearLayout.getChildAt(1);
                textView.setTextColor(getResources().getColor(R.color.black));

                ImageView imageView = (ImageView) linearLayout.getChildAt(0);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_thumb_up_black_24dp));

                Drawable button = v.getBackground();
                button.setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_OVER);

                btnLikeColor = false;
            } else {
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
        if (v.equals(btn_comment)) {
            if (editTextZone.hasFocus()) {
                editTextZone.clearFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editTextZone.getWindowToken(), 0);
            } else {
                editTextZone.requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(editTextZone, InputMethodManager.SHOW_IMPLICIT);
            }
        }

        //Bouton Retour et quitter
        if (v.equals(btn_close) || v.equals(btn_back)) {
            MainActivity.this.finish();
            //System.exit(0);
        }

        //Bouton envoyer
        if (v.equals(btn_send)) {

            String message;

            message = editTextZone.getText().toString();
            if (message.length() > 0) {

                Comment comment = new Comment("Philippe", message, R.drawable.avatar);

                CommentAdapter commentAdapter = (CommentAdapter) zoneCommentaire.getAdapter();

                commentAdapter.addComment(comment);
                commentAdapter.notifyDataSetChanged();

                editTextZone.getText().clear();


                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextZone.getWindowToken(), 0);

                scrollView.fullScroll(scrollView.FOCUS_DOWN);
            }


        }
    }


}
