package com.adeneo.lab1.tp1_application.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.objects.Cell;

public class FooterViewHolder extends CellViewHolder {

    private TextView movieNumber;

    public FooterViewHolder(@NonNull View itemView) {
        super(itemView);
        movieNumber = itemView.findViewById(R.id.movieNumber);
    }

    public void layoutForCell(Cell cell){
        if(movieNumber != null) {
            movieNumber.setText(cell.getTitre());
        }
    }
}
