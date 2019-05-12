package com.example.emplyeesapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API.EmployeeAPI;
import model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etempNo;
    private TextView tvData;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etempNo = findViewById(R.id.etEmpID);
        tvData = findViewById(R.id.tvdata);
        btnSearch = findViewById(R.id.btnSearch);

        
    }


    @Override
    public void onClick(View v) {
        loadData();
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(etempNo.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(SearchActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                String content = "";
                content += " Id : " + response.body().getId() + "\n";
                content += " Name : " + response.body().getEmployee_name() + "\n";
                content += " Age : " + response.body().getEmployee_age() + "\n";
                content += " Salary : " + response.body().getEmployee_salary() + "\n";

                tvData.setText(content);
            }
            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
