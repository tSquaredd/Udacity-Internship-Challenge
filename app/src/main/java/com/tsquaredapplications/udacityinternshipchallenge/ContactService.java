package com.tsquaredapplications.udacityinternshipchallenge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tylerturnbull on 12/19/17.
 *
 * Interface for use with Retrofit.
 */

public interface ContactService {

    // getContacts will return a list of contact objects
    @GET("CardData.json")
    Call<List<Contact>> getContacts();
}
