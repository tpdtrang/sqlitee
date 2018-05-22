package com.example.doantrang.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import adapters.ContactListAdapter;
import database.ContactDB;

public class MainActivity extends AppCompatActivity {
    private Button btnadd;
    private ListView lvadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnadd = (Button) findViewById(R.id.btnadd);
        this.lvadd=(ListView)findViewById(R.id.lvadd);
        this.btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,AddContactActivity.class);
                startActivity(intent1);
            }
        });
       ContactDB contactDB=new ContactDB(this);
        this.lvadd=(ListView)findViewById(R.id.lvadd);
        this.lvadd.setAdapter(new ContactListAdapter(this,contactDB.findAll()));
    }
}
