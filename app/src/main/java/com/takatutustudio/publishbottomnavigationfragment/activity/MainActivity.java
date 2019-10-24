package com.takatutustudio.publishbottomnavigationfragment.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.takatutustudio.publishbottomnavigationfragment.R;
import com.takatutustudio.publishbottomnavigationfragment.fragment.FavoriteFragment;
import com.takatutustudio.publishbottomnavigationfragment.fragment.HomeFragment;
import com.takatutustudio.publishbottomnavigationfragment.fragment.SearchFragment;

//Note:
//Untuk mengubah font di Action bar silahkan cek di styles.xml
//Cek AppTheme
//Ubah Font di Android:fontfamily
//---

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //Mengganti Judul Pada Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Kabalai Project");
        }

        //Memunculkan fragment di awal
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_favorite:
                            selectedFragment = new FavoriteFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                    }

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();

                    return true;
                }
            };
}
