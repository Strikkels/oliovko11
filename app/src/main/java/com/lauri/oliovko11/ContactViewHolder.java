package com.lauri.oliovko11;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView contactNameText, contactNumberText, contactGroupText;
    ImageView removeImage, infoImage;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactNameText = itemView.findViewById(R.id.ContactNameText);
        contactNumberText = itemView.findViewById(R.id.ContactNumberText);
        contactGroupText = itemView.findViewById(R.id.ContactGroupText);
        removeImage = itemView.findViewById(R.id.ContactDeleteButton);
        infoImage = itemView.findViewById(R.id.ContactDetailsButton);

    }
}
