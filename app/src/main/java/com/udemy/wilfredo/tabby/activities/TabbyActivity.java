package com.udemy.wilfredo.tabby.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.udemy.wilfredo.tabby.R;
import com.udemy.wilfredo.tabby.adapters.ViewPagerAdapter;
import com.udemy.wilfredo.tabby.fragments.ListFragment;
import com.udemy.wilfredo.tabby.interfaces.OnCreateNewPerson;
import com.udemy.wilfredo.tabby.model.Person;

public class TabbyActivity extends AppCompatActivity implements OnCreateNewPerson{

    private ViewPager viewPager;

    // Índice de posición de los fragments
    public static final int PERSON_FORM_FRAGMENT = 0;
    public static final int PERSON_LIST_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabby);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Form"));
        tabLayout.addTab(tabLayout.newTab().setText("List"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void createNewPerson(Person person) {
        ListFragment fragment = (ListFragment) getSupportFragmentManager().getFragments().get(PERSON_LIST_FRAGMENT);
        // Llamamos al método de nuestro fragment
        fragment.addPerson(person);
        // Movemos el viewpager hacia el ListFragment para ver la persona añadida en el listView
        viewPager.setCurrentItem(PERSON_LIST_FRAGMENT);
    }
}
