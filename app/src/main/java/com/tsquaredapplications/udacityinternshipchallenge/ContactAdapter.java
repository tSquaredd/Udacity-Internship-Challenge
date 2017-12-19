package com.tsquaredapplications.udacityinternshipchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by tylerturnbull on 12/19/17.
 * <p>
 * Adapts a List<Contact> for a RecyclerView
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder> {

    private List<Contact> mContactList;
    private Context mContext;

    @Override
    public ContactAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        int layoutId = R.layout.contact_list_item;
        boolean shouldAttackToParentImmediately = false;
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(layoutId, parent, shouldAttackToParentImmediately);
        return new ContactAdapterViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ContactAdapterViewHolder holder, int position) {

        Contact currentContact = mContactList.get(position);
        Picasso.with(mContext).load(currentContact.getAvatar()).into(holder.image);
        String name = currentContact.getFirstName() + " " + currentContact.getLastName();
        holder.name.setText(name);
        holder.email.setText(currentContact.getEmail());
        holder.company.setText(currentContact.getCompany());
        holder.startDate.setText(currentContact.getStartDate());
        holder.bio.setText(currentContact.getBio());


    }

    @Override
    public int getItemCount() {
        if (mContactList == null)
            return 0;
        else
            return mContactList.size();
    }

    public class ContactAdapterViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView email;
        private final TextView company;
        private final TextView startDate;
        private final TextView bio;
        private final ImageView image;


        public ContactAdapterViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_contact_name);
            email = (TextView) itemView.findViewById(R.id.tv_contact_email);
            company = (TextView) itemView.findViewById(R.id.tv_contact_company);
            startDate = (TextView) itemView.findViewById(R.id.tv_contact_start_date);
            bio = (TextView) itemView.findViewById(R.id.tv_contact_bio);
            image = (ImageView) itemView.findViewById(R.id.iv_contact_photo);

        }
    }

    public void setData(List<Contact> data) {
        mContactList = data;
        notifyDataSetChanged();

    }
}
