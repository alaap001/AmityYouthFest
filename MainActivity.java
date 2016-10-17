package com.example.alaap.amityyouthfest;

// androidimport
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

//Custom inports
import com.example.alaap.amityyouthfest.Fragments.AboutUs;
import com.example.alaap.amityyouthfest.Fragments.BlankFragment;
import com.example.alaap.amityyouthfest.Fragments.Contactus;
import com.example.alaap.amityyouthfest.Fragments.Events;
import com.example.alaap.amityyouthfest.Fragments.Partners;
import com.example.alaap.amityyouthfest.Fragments.Photos;
import com.example.alaap.amityyouthfest.Fragments.Registration;
import com.example.alaap.amityyouthfest.Fragments.Vedios;
import com.example.alaap.amityyouthfest.Fragments.committee;
import com.example.alaap.amityyouthfest.Fragments.feedback;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Context c = this;
    NavigationView navigationView;
    int navid;
    ActionBarDrawerToggle toggle;
    String tag;
    int count;

    private void changeMenu() {

        android.app.Fragment fragmentbyid = getFragmentManager().findFragmentById(R.id.content_main);
        try {
            getSupportActionBar().setTitle(fragmentbyid.getTag());
        } catch (NullPointerException e) {
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        count = getFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        android.app.Fragment
                fragment = new BlankFragment();
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content_main, fragment, "Home");
        ft.addToBackStack(null);
        tag = "Home";
        ft.commit();
        getSupportActionBar().setTitle("AYF 2017");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "you're invited to AYF 2017");
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "Send via.."));
                Snackbar.make(view, "Send Invitation For AYF 2017", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navhome);
        navid = navigationView.getId();
        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                changeMenu();
                changeitemselected();
            }
        });


    }

    String temptag = "Home";

    public void changeitemselected() {

        android.app.Fragment fragmentbyid = getFragmentManager().findFragmentById(R.id.content_main);
        try {
            temptag = fragmentbyid.getTag();
        } catch (NullPointerException e) {
            temptag = "Home";
        }
        switch (temptag) {
            case "Home":
                navigationView.setCheckedItem(R.id.navhome);
                break;
            case "Events":
                navigationView.setCheckedItem(R.id.events);
                break;
            case "feedback":
                navigationView.setCheckedItem(R.id.feedback);
                break;
            case "Committee":
                navigationView.setCheckedItem(R.id.committee);
                break;
            case "Register":
                navigationView.setCheckedItem(R.id.register);
                break;
            case "Contact Us":
                navigationView.setCheckedItem(R.id.contact);
                break;
            case "Photos":
                navigationView.setCheckedItem(R.id.photos);
                break;
            case "Vedios":
                navigationView.setCheckedItem(R.id.vedios);
                break;
            case "Partners":
                navigationView.setCheckedItem(R.id.partners);
                break;
            default:
                navigationView.setCheckedItem(R.id.navhome);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Settings.class));
        }
        if (id == R.id.maps) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:000,000"));
            Intent chooser = Intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    int tempid;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        tempid = item.getItemId();
        if (id == R.id.navhome) {
            android.app.Fragment
                    fragment = new BlankFragment();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            getSupportActionBar().setTitle(item.getTitle());
            ft.commit();
            tag = (String) item.getTitle();
            navigationView.setCheckedItem(id);
        } else if (id == R.id.photos) {

            android.app.Fragment
                    fragment = new Photos();
            navigationView.setCheckedItem(id);
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            getSupportActionBar().setTitle(item.getTitle());
            ft.addToBackStack(null);
            tag = (String) item.getTitle();
            ft.commit();

        } else if (id == R.id.vedios) {
            android.app.Fragment
                    fragment = new Vedios();
            getSupportActionBar().setTitle(item.getTitle());
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            navigationView.setCheckedItem(id);
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            ft.commit();
            tag = (String) item.getTitle();


        } else if (id == R.id.events) {

            android.app.Fragment
                    fragment = new Events();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            navigationView.setCheckedItem(id);
            tag = (String) item.getTitle();
            ft.commit();
            getSupportActionBar().setTitle(item.getTitle());

        } else if (id == R.id.register) {

            android.app.Fragment
                    fragment = new Registration();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            tag = (String) item.getTitle();
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            navigationView.setCheckedItem(id);
            ft.commit();
            getSupportActionBar().setTitle(item.getTitle());


        } else if (id == R.id.partners) {
            android.app.Fragment
                    fragment = new Partners();
            android.app.FragmentManager fm = getFragmentManager();
            tag = (String) item.getTitle();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            getSupportActionBar().setTitle(item.getTitle());
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            ft.commit();
            navigationView.setCheckedItem(id);


        } else if (id == R.id.contact) {
            android.app.Fragment
                    fragment = new Contactus();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            getSupportActionBar().setTitle(item.getTitle());
            tag = (String) item.getTitle();
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            navigationView.setCheckedItem(id);
            ft.commit();


        } else if (id == R.id.about_us) {

            android.app.Fragment
                    fragment = new AboutUs();
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            navigationView.setCheckedItem(id);
            tag = (String) item.getTitle();
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            getSupportActionBar().setTitle(item.getTitle());
            //item.setChecked(true);
            ft.addToBackStack(null);
            ft.commit();


        } else if (id == R.id.feedback) {

            android.app.Fragment
                    fragment = new feedback();
            android.app.FragmentManager fm = getFragmentManager();
            navigationView.setCheckedItem(id);
            tag = (String) item.getTitle();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            ft.commit();
            //item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        } else if (id == R.id.committee) {
            android.app.Fragment
                    fragment = new committee();
            navigationView.setCheckedItem(id);
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction ft = fm.beginTransaction();
            tag = (String) item.getTitle();

            ft.replace(R.id.content_main, fragment, (String) item.getTitle());
            ft.addToBackStack(null);
            ft.commit();
            getSupportActionBar().setTitle(item.getTitle());

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
