package com.tsquaredapplications.udacityinternshipchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService service = retrofit.create(ContactService.class);

        Call<List<Contact>> contactCall = service.getContacts();


        // Downloads JSON data asynchronously
       contactCall.enqueue(new Callback<List<Contact>>() {
           @Override
           public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
               List<Contact> contactList = response.body();
               for(Contact current: contactList){
                   Log.i(LOG_TAG, current.getFirstName());
               }

           }

           @Override
           public void onFailure(Call<List<Contact>> call, Throwable t) {

           }
       });


    }
}
