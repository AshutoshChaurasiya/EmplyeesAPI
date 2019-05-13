package API;

import java.util.List;

import model.Employee;
import model.EmployeeCUD;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeAPI {
        //Get all the employees
        @GET("employees")
        Call<List<Employee>> getEmployee();

        //Get employee on basis of EmpID

        @GET("employee/{empID}")
        Call<Employee> getEmployeeByID(@Path("empID") int empId);

        @POST("create")
        Call<Void> registerEmployee(@Body EmployeeCUD emp);

        @PUT("update/{empID}")
        Call<Void> updateEmployee(@Path("empID") int empID, @Body EmployeeCUD emp);


        @DELETE("delete/{empID}")
        Call<Void> deleteEmployee(@Path("empID") int empID);
    }
