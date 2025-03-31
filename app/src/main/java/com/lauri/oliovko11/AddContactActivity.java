package com.lauri.oliovko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {
    private EditText contactFirstName;
    private EditText contactLastName;
    private EditText contactNumber;
    private RadioGroup rgContactGroup;
    private String contactGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        contactFirstName = findViewById(R.id.FirstNameEdit);
        contactLastName = findViewById(R.id.LastNameEdit);
        contactNumber = findViewById(R.id.PhoneNumberEdit);
        rgContactGroup = findViewById(R.id.ContactTypeRadioGroup);
    }
    public void switchToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void createContact(View view){
        String lastName = contactLastName.getText().toString();
        String firstName = contactFirstName.getText().toString();
        String phoneNumber = contactNumber.getText().toString();

        int checkedRadioButtonId = rgContactGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.WorkRadioButton) {
            contactGroup = "Työ";
        } else if (checkedRadioButtonId == R.id.PersonalRadioButton) {
            contactGroup = "Henkilökohtainen";
        }
        Contact newNote = new Contact(firstName, lastName,phoneNumber,contactGroup);
        ContactStorage.getInstance().addContact(newNote);
    }
}