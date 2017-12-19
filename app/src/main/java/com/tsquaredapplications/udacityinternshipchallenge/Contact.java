package com.tsquaredapplications.udacityinternshipchallenge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tylerturnbull on 12/19/17.
 *
 * Contact class for containing instances of a contact
 */

public class Contact {


    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("startDate")
    @Expose
    private String startDate;

    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
