package com.example.shopbantraicay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.shopbantraicay.fragment.CartFragment;
import com.example.shopbantraicay.fragment.HomeFragment;
import com.example.shopbantraicay.fragment.PersonalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {
    private static final int HOME_FRAGMENT_ID = R.id.action_home;
    private static final int NOTIFICATION_FRAGMENT_ID = R.id.action_notification;
    private static final int PERSONAL_FRAGMENT_ID = R.id.action_personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        replaceFragment(new HomeFragment());
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == HOME_FRAGMENT_ID) {
            replaceFragment(new HomeFragment());
            return true;
        } else if (itemId == R.id.action_notification) {
            replaceFragment(new CartFragment());
            return true;
        } else if (itemId == R.id.action_personal) {
            replaceFragment(new PersonalFragment());
            return true;
        }
        return false;
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }


}
