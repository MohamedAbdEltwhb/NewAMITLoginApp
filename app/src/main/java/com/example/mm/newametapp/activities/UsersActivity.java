package com.example.mm.newametapp.activities;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mm.newametapp.R;
import com.example.mm.newametapp.activities.settings.SettingsActivity;
import com.example.mm.newametapp.helper.DisplayImageResources;
import com.example.mm.newametapp.helper.UsersAdapter;
import com.example.mm.newametapp.model.Sport;
import com.example.mm.newametapp.storage.SharedPreferencesStorage;

import java.util.ArrayList;
import java.util.Collections;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.mm.newametapp.helper.Constants.EXTRA_EMILE;

public class UsersActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DisplayImageResources mDisplayImageResources;
    private View header;
    private TextView mNameTextView;
    private CircleImageView imageView;

    private ArrayList<Sport> mSportsData;
    private RecyclerView mRecyclerView;
    private UsersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * my recyclerview
         * */
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mSportsData = new ArrayList<>();
        mAdapter = new UsersAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);
        initializeData();

        int swipeDirs;
        if (gridColumnCount > 1){
            swipeDirs = 0;
        }else {swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;}

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN|ItemTouchHelper.UP, swipeDirs) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mSportsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mSportsData.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(mRecyclerView);

        /**___________________________________________________________________________________________________*/




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        header = navigationView.getHeaderView(0);
        mNameTextView =  header.findViewById(R.id.name);
        imageView = header.findViewById(R.id.imageView_title_nav);

        mDisplayImageResources = new DisplayImageResources(UsersActivity.this, imageView);
        mDisplayImageResources.displayImage();

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_EMILE)) {
            String nameFromIntent = intent.getStringExtra(EXTRA_EMILE);
            mNameTextView.setText("Welcome " + nameFromIntent);

        }else {
            String email = SharedPreferencesStorage.getEmail(this);
            mNameTextView.setText("Welcome " + "\n" + email);
        }
    }
    private void initializeData() {
        String []sportsList = getResources().getStringArray(R.array.sports_titles);
        String []sportsInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        mSportsData.clear();
        for (int i = 0; i < sportsList.length; i++) {
            mSportsData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0)));
        }

        sportsImageResources.recycle();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            moveTaskToBack(true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.nav_share:

                break;
            case R.id.nav_settings:
                startActivity(new Intent(UsersActivity.this, SettingsActivity.class));
                break;
            case R.id.nav_logout:
                userLogout();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void userLogout() {
        SharedPreferencesStorage.saveEmail(null, this);
        SharedPreferencesStorage.savePassword(null, this);
        Intent toLogin = new Intent(this, SignInActivity.class);
        //toLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        toLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        toLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(toLogin);
        //finish();
    }

}
