package com.udemy.wilfredo.tabby.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udemy.wilfredo.tabby.R;
import com.udemy.wilfredo.tabby.model.Person;

import java.util.List;

/**
 * Adapatador para el listView
 * Created by wilfredo on 24-02-18.
 */

public class PersonListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Person> persons;

    public PersonListAdapter(Context context, int layout, List<Person> persons) {
        this.context = context;
        this.layout = layout;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.name = view.findViewById(R.id.textViewItemPersonName);
            viewHolder.country = view.findViewById(R.id.textViewItemPersonCountry);
            viewHolder.image = view.findViewById(R.id.imageViewFlag);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Person currentPerson = getItem(position);

        viewHolder.name.setText(currentPerson.getPersonName());
        viewHolder.country.setText(currentPerson.getPersonCountry().getCountryName());

        String urlFlag = currentPerson.getPersonCountry().getFlagURL();
        Picasso.with(context).load(urlFlag).into(viewHolder.image);
        return view;
    }

    private static class ViewHolder {
        private TextView name;
        private TextView country;
        private ImageView image;
    }
}
