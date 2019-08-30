package com.example.keyaanpaymentvochers;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Paymentslist_Activty extends AppCompatActivity {

    private List<PaymentList> paymentlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private PaymentsList_Adapter mAdapter;

    private SearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentslist_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        mAdapter = new PaymentsList_Adapter(this,paymentlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent mIntent;
                switch (position) {
                    case 0: //first item in Recycler view
                        mIntent = new Intent (getApplicationContext(), Payment1_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 1: //second item in Recycler view
                        mIntent = new Intent (getApplicationContext(), Payment1_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 2: //third item in Recycler view
                        mIntent = new Intent (getApplicationContext(), Payment1_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 3: //first item in Recycler view
                        mIntent = new Intent (getApplicationContext(), Payment1_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 4: //second item in Recycler view
                        mIntent = new Intent (getApplicationContext(), Payment1_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 5: //third item in Recycler view
                        mIntent = new Intent (getApplicationContext(), Payment1_Activity.class);
                        startActivity(mIntent);
                        break;

                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareListdata();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_view_menu_item,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (mAdapter != null){
                    mAdapter.getFilter().filter(newText);
                }

                return true;
            }
        });
//        int searchPlateId = searchView.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
//        // Getting the 'search_plate' LinearLayout.
//        View searchPlate = searchView.findViewById(searchPlateId);
//        // Setting background of 'search_plate' to earlier defined drawable.
//        searchPlate.setBackgroundResource(R.drawable.textfield_searchview_holo_light);

        return true;
    }


    private void prepareListdata() {
        PaymentList list = new PaymentList("001", "14/02/2019", "12:52","1500","Yeshwanth", R.drawable.profile1);
        paymentlist.add(list);

        list = new PaymentList("002", "18/02/2019", "21:25","4000","Revanth", R.drawable.profile);
        paymentlist.add(list);

        list = new PaymentList("003", "19/02/2019", "12:00","800","Himanshu", R.drawable.profile1);
        paymentlist.add(list);

        list = new PaymentList("004", "21/02/2019", "09:52","1400","Sadwik", R.drawable.profile);
        paymentlist.add(list);
    }
}
