package com.example.emplyeesapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
    private Button btnAllEmployee;
    private Button btnRegisterEmployee;
    private Button btnSearcheEmp;
    private Button btnUpdateDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAllEmployee = findViewById(R.id.btnAllEmployee);
        btnRegisterEmployee = findViewById(R.id.btnRegisterEmployee);
        btnSearcheEmp = findViewById(R.id.btnSearcheEmp);
        btnUpdateDelete = findViewById(R.id.btnUpdateDelete);

       btnSearcheEmp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(DashboardActivity.this, SearchActivity.class);
                startActivity(intent);

           }
       });

        btnRegisterEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, RegisterEmployeeActivity.class);
                startActivity(intent);
            }
        });

        btnAllEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnUpdateDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, UpdateEmployeeActivity.class);
                startActivity(intent);
            }
        });


    }

}

