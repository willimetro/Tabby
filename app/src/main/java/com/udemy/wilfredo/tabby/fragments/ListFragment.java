package com.udemy.wilfredo.tabby.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.udemy.wilfredo.tabby.R;
import com.udemy.wilfredo.tabby.adapters.PersonListAdapter;
import com.udemy.wilfredo.tabby.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private PersonListAdapter personListAdapter;
    private List<Person> persons;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView personsListView = view.findViewById(R.id.listViewPersons);
        persons = new ArrayList<>();
        personListAdapter = new PersonListAdapter(this.getContext(),R.layout.list_view_item, persons);

        personsListView.setAdapter(personListAdapter);
        return view;
    }

    public void addPerson(Person person) {
        persons.add(person);
        personListAdapter.notifyDataSetChanged();
    }
}
