package com.example.matthew.qubapp.GUI;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.matthew.qubapp.Database.GeneralOfferDataSource;
import com.example.matthew.qubapp.Database.GeneralOfferTable;
import com.example.matthew.qubapp.Model.Offer;
import com.example.matthew.qubapp.R;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Matthew on 18/08/2015.
 */
public class OfferListFragment extends Fragment {

    private GeneralOfferDataSource datasource;
    private OfferListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view;

        view = inflater.inflate(R.layout.offer_list_fragment, container, false);

        datasource = new GeneralOfferDataSource(this.getActivity());
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Offer> values  = datasource.getAllOffers();


        adapter = new OfferListAdapter(this.getActivity());
        adapter.replaceWith(values);
        ListView list = (ListView) view.findViewById(R.id.listViewProducts);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Offer offer = adapter.getItem(position);
                Intent intent = new Intent(OfferListFragment.this.getActivity(), OfferActivity.class);
                intent.putExtra("Offer", offer);
                startActivity(intent);
            }

        });

        return view;
    }


}