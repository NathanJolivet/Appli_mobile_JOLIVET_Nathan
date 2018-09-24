package com.adeneo.lab1.tp1_application.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.objects.Cell;

public class HeaderViewHolder extends CellViewHolder{


    private TextView headerTitle;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        headerTitle = itemView.findViewById(R.id.headerTitle);
    }

    @Override
    public void layoutForCell(Cell cell) {
        if(headerTitle != null){
            headerTitle.setText(cell.getTitre());
        }
    }
}
