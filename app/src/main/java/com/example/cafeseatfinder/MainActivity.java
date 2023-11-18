package com.example.cafeseatfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MapFragment mapFragment;
    NotiFragment notiFragment;
    MypageFragment mypageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homeFragment = new HomeFragment();
        mapFragment = new MapFragment();
        notiFragment = new NotiFragment();
        mypageFragment = new MypageFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_nav);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.map:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
                        return true;
                    case R.id.noti:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, notiFragment).commit();
                        return true;
                    case R.id.mypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, mypageFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}