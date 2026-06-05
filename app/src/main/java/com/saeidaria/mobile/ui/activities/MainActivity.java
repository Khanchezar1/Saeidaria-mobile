package com.saeidaria.mobile.ui.activities;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            
            if (item.getItemId() == R.id.nav_orders) {
                Toast.makeText(this, "سفارشات", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_customers) {
                Toast.makeText(this, "مشتریان", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_parts) {
                Toast.makeText(this, "قطعات", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.nav_reports) {
                Toast.makeText(this, "گزارشات", Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }
}
