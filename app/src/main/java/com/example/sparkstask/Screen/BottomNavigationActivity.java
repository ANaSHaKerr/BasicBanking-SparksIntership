package com.example.sparkstask.Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.basicbankingapp.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class BottomNavigationActivity extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_clients,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UsersList()).commit();
        bottomMenu();
    }

    private void bottomMenu() {


        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.bottom_nav_clients:
                        fragment = new UsersList();
                        break;
                    case R.id.bottom_nav_transfer:
                        fragment = new TransactionHistory();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });


    }
}