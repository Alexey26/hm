package com.example.alexey.notes;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAddDo extends AppCompatActivity {
    FloatingActionButton butok;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_do);
        name = findViewById(R.id.editText);
        butok = findViewById(R.id.floatingActionButton2);
        butok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().length() == 0)
                    Toast.makeText(ActivityAddDo.this, "Заполните поля", Toast.LENGTH_LONG).show();
                else {
                    DataBase.getInstance().getListDo().add(name.getText().toString());
                    finish();
                }
            }
        });
    }
}
