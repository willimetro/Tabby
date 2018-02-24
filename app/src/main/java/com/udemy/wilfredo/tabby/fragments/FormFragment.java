package com.udemy.wilfredo.tabby.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.udemy.wilfredo.tabby.R;
import com.udemy.wilfredo.tabby.interfaces.OnCreateNewPerson;
import com.udemy.wilfredo.tabby.model.Country;
import com.udemy.wilfredo.tabby.model.Person;
import com.udemy.wilfredo.tabby.util.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    private EditText editTextPersonName;
    private Spinner spinnerCountry;

    private OnCreateNewPerson onCreateNewPerson;


    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        //Se inicializan los componentes de la UI
        editTextPersonName = view.findViewById(R.id.editTextPersonName);
        spinnerCountry = view.findViewById(R.id.spinnerCountry);
        Button btnCreatePerson = view.findViewById(R.id.buttonCreate);

        //Se crea adaptador de spinner
        ArrayAdapter<Country> spinnerAdapter = new ArrayAdapter<>(this.getContext(),
                android.R.layout.simple_spinner_item, Utils.getAllCountries());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(spinnerAdapter);

        //Se crea listener en el boton para crear a la persona
        btnCreatePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String personName = editTextPersonName.getText().toString();
                if(personName.trim().length() > 0){
                    Country country = (Country)spinnerCountry.getSelectedItem();
                    Person person = new Person(personName,country);
                    onCreateNewPerson.createNewPerson(person);
                } else {
                    Toast.makeText(getContext(), "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    /**
     * Método necesario para enlazar el fragment con el activity que lo soporta, a partir de una interfaz
     * @param context se recibe este parámetro para saber si ha implementado la interfaz
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnCreateNewPerson) {
            onCreateNewPerson = (OnCreateNewPerson) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnCreateNewPerson");
        }
    }

    /**
     * Método que permite deselazar la relación fragment - activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        onCreateNewPerson = null;
    }
}
