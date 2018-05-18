package com.gustavojung.pin1;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    Dialog myDialog;
    Spinner spinner;

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<Integer> mImageUrls1 = new ArrayList<>();
    private ArrayList<Integer> mImageUrls2 = new ArrayList<>();
    private ArrayList<Integer> mImageUrls3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);



        addImages();



        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView list = (RecyclerView)findViewById(R.id.list);
        list.setLayoutManager(layoutManager);
        list.setAdapter(new HorizontalAdapter(this,mImageUrls));


        RecyclerView list2 = (RecyclerView)findViewById(R.id.list2);
        list2.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));
        list2.setAdapter(new HorizontalAdapter(this,mImageUrls1));


        RecyclerView list3 = (RecyclerView)findViewById(R.id.list3);
        list3.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));
        list3.setAdapter(new HorizontalAdapter(this,mImageUrls2));


        RecyclerView list4 = (RecyclerView)findViewById(R.id.list4);
        list4.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));
        list4.setAdapter(new HorizontalAdapter(this,mImageUrls3));

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void addImages(){
        mImageUrls.add(R.drawable.gotham);
        mImageUrls.add(R.drawable.between);
        mImageUrls.add(R.drawable.dexter);


        mImageUrls1.add(R.drawable.houseofcards);
        mImageUrls1.add(R.drawable.lost);
        mImageUrls1.add(R.drawable.orphanblack);
        mImageUrls1.add(R.drawable.sherlock);
        mImageUrls1.add(R.drawable.slasher);


        mImageUrls2.add(R.drawable.atypical);
        mImageUrls2.add(R.drawable.howimetyourmother);
        mImageUrls2.add(R.drawable.lacasadepapel);
        mImageUrls2.add(R.drawable.santaclaritadiet);
        mImageUrls2.add(R.drawable.vikings);
        mImageUrls2.add(R.drawable.theranch);


        mImageUrls3.add(R.drawable.atypical);
        mImageUrls3.add(R.drawable.howimetyourmother);
        mImageUrls3.add(R.drawable.lacasadepapel);
        mImageUrls3.add(R.drawable.santaclaritadiet);
        mImageUrls3.add(R.drawable.vikings);
        mImageUrls3.add(R.drawable.theranch);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.list_fav) {

            TextView txtclose;
            myDialog.setContentView(R.layout.popup_menu1);
            txtclose = (TextView) myDialog.findViewById(R.id.txtclose);

            txtclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();

        }
        else if (id == R.id.nav_camera) {

            TextView txtclose;
            myDialog.setContentView(R.layout.popup_menu1);
            txtclose = (TextView) myDialog.findViewById(R.id.txtclose);

            txtclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            myDialog.show();

        } else if (id == R.id.nav_gallery) {

            TextView txtclose2;
            myDialog.setContentView(R.layout.popup_menu2);
            txtclose2 = myDialog.findViewById(R.id.txtclose2);

            txtclose2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();
        } else if (id == R.id.nav_slideshow) {

            TextView txtclose3;
            myDialog.setContentView(R.layout.popup_menu3);
            txtclose3 = myDialog.findViewById(R.id.txtclose3);

            txtclose3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();

        } else if (id == R.id.nav_manage) {
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Deseja fechar o aplicativo?");
            msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);
                }
            });

            msg.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
            AlertDialog alert = msg.create();
            alert.show();
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
