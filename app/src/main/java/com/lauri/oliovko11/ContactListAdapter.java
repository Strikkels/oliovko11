package com.lauri.oliovko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private Context context;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactListAdapter(Context context, ArrayList<Contact> contacts){
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.contactNameText.setText(contacts.get(position).getFirstName() + " " + contacts.get(position).getLastName());

        holder.infoImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            holder.contactNumberText.setText(contacts.get(position).getNumber());
            holder.contactGroupText.setText(contacts.get(position).getContactGroup());
        });

        holder.removeImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ContactStorage.getInstance().removeContact(contacts.get(pos).getId());
            notifyItemRemoved(pos);
        });
    }

    @Override
    public int getItemCount() {
        return ContactStorage.getInstance().getContacts().size();
    }
}
