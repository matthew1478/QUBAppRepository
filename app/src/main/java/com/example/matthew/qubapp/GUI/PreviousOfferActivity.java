package com.example.matthew.qubapp.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matthew.qubapp.Model.BeaconOffer;
import com.example.matthew.qubapp.Database.PreviousOfferDataSource;
import com.example.matthew.qubapp.R;

import java.sql.SQLException;

/**
 * Created by Matthew on 24/08/2015.
 */
public class PreviousOfferActivity extends Activity {

    TextView offerName;
    TextView offerShop;
    TextView offerExpiry;
    ImageView icon;
    PreviousOfferDataSource myPreviousOfferDB;
    Button delete;

    BeaconOffer beaconOffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_offer);
        Intent intent = getIntent();
        beaconOffer = (BeaconOffer)intent.getSerializableExtra("BeaconOffer");

        myPreviousOfferDB = new PreviousOfferDataSource(this);
        try {
            myPreviousOfferDB.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        offerName = (TextView)findViewById(R.id.previousOfferName2);
        offerShop = (TextView)findViewById(R.id.textViewProductPrice);
        offerExpiry = (TextView)findViewById(R.id.textViewPreviousExpiry);
        icon = (ImageView)findViewById(R.id.imageViewPreviousIcon);
        delete = (Button)findViewById(R.id.buttonDelete);

        setBeaconOfferDetails(beaconOffer);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onDeleteButtonClick(beaconOffer);
                Intent intent = new Intent(PreviousOfferActivity.this, MainActivity.class);
                Toast.makeText(PreviousOfferActivity.this, "Offer deleted", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_offer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setBeaconOfferDetails(BeaconOffer beaconOffer){

        offerName.setText(beaconOffer.getDescription());
        offerShop.setText(beaconOffer.getStore());
        offerExpiry.setText(beaconOffer.getExpiry());
        icon.setImageResource(Integer.valueOf(beaconOffer.getIcon()));

    }

    public void onDeleteButtonClick(BeaconOffer beaconOffer) {

        String description = beaconOffer.getDescription();
        String UUID = beaconOffer.getUUID();
        int major = beaconOffer.getMajor();
        int minor = beaconOffer.getMinor();

        myPreviousOfferDB.deleteBeaconOffer(description, UUID, major, minor);


    }
}
