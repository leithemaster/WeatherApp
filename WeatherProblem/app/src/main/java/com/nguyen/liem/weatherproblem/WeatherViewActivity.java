package com.nguyen.liem.weatherproblem;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class WeatherViewActivity extends AppCompatActivity {

    private static final String TAG = "WeatherViewActivity";

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUserLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                // update our UI later

                if (user != null) {
                    Toast.makeText(WeatherViewActivity.this, user.getLocation(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WeatherViewActivity.this, "No Accounts Has been made.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
