package com.example.alexey.notes;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import io.realm.Realm;




public class MainActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        if(realm.where(DataBase.class).findFirst() != null)
            DataBase.setInstance(realm.where(DataBase.class).findFirst());
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fr_place, new FragmentListdo());
            fragmentTransaction.commit();
        }

        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Сделано", R.drawable.galochka, R.color.colorAccent);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Уведомления", R.drawable.bell, R.color.colorAccent);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Сделать", R.drawable.list, R.color.colorAccent);

// Add items
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item1);

// Set background color
//bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));


// Set listeners
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new FragmentListdo();
                        break;
                    case 1:
                        fragment = new FragmentListbell();
                        break;
                    case 2:
                        fragment = new FragmentListdid();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fr_place, fragment);
                fragmentTransaction.commit();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fr_place, new FragmentListdo());
        fragmentTransaction.commit();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.beginTransaction();
        realm.insert(DataBase.getInstance());
        realm.commitTransaction();
        realm.close();
    }
}
