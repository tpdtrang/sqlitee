package com.example.doantrang.firebase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.ContactDB;
import enbities.Contact;


public class AddContactActivity extends AppCompatActivity {
    private Button btnback;
    private Button btnsave;
    private EditText edtykien;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        edtykien = (EditText) findViewById(R.id.edtykien);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AddContactActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactDB contactDB = new ContactDB(getBaseContext());
                Contact contact = new Contact();
                contact.setYkien(edtykien.getText().toString());
                if (contactDB.create(contact)) {
                    Intent intent1 = new Intent(AddContactActivity.this, MainActivity.class);
                    startActivity(intent1);
                }else {
                    AlertDialog.Builder builder = new AlertDialog
                            .Builder(view.getContext());
                    builder.setMessage("Fail");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();

                        }
                    });
                    builder.create().show();
                }

            }
        });

    }
}
