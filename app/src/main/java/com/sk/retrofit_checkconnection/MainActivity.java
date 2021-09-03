package com.sk.retrofit_checkconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtstatus;
    Button check;

    String WEB_URL = "https://androidbatch2.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtstatus = findViewById(R.id.status);
        check = findViewById(R.id.checkbtn);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
            }
        });
    }

    public void checkConnection() {
        Retrofit retrofit = null;

        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(WEB_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        ApiInterface apiInterface;

        apiInterface = retrofit.create(ApiInterface.class);

        Call<PojoClass> call = apiInterface.checkDatabaseConnection();

        call.enqueue(new Callback<PojoClass>() {
            @Override
            public void onResponse(Call<PojoClass> call, Response<PojoClass> response) {
                if(response.body().getSuccess()==1)
                {
                    txtstatus.setText(response.body().getMessage());
                    //txtstatus.setText("sheetal");
                }
            }

            @Override
            public void onFailure(Call<PojoClass> call, Throwable t) {
                txtstatus.setText(t.getMessage());
            }
        });
    }
}