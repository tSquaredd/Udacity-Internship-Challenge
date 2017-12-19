package com.tsquaredapplications.udacityinternshipchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();

    private RecyclerView mRecyclerView;
    private ContactAdapter mContactAdapter;
    private static final String BASE_URL = "https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true); // every child of RV has fixed size

        mContactAdapter = new ContactAdapter();

        mRecyclerView.setAdapter(mContactAdapter);


        // Forces Card Views to snap to position when scrolling through Recycler View
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService service = retrofit.create(ContactService.class);

        Call<List<Contact>> contactCall = service.getContacts();


        // Downloads JSON data asynchronously
       contactCall.enqueue(new Callback<List<Contact>>() {
           @Override
           public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
               List<Contact> contactList = response.body();

               // Sort contact list by first name
               Collections.sort(contactList, new Comparator<Contact>() {
                   @Override
                   public int compare(Contact o1, Contact o2) {
                       return o1.getFirstName().compareTo(o2.getFirstName());
                   }
               });

               mContactAdapter.setData(contactList);

           }

           @Override
           public void onFailure(Call<List<Contact>> call, Throwable t) {
               // TODO: Better error handling..
               Toast.makeText(MainActivity.this, "Failed to load contact data", Toast.LENGTH_SHORT).show();
           }
       });


    }
}
