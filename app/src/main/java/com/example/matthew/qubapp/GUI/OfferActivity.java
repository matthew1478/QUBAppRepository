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

import com.example.matthew.qubapp.Database.GeneralOfferDataSource;
import com.example.matthew.qubapp.Database.GeneralOfferTable;
import com.example.matthew.qubapp.Model.Offer;
import com.example.matthew.qubapp.R;

public class OfferActivity extends Activity {

    TextView offerName;
    TextView offerShop;
    TextView offerExpiry;
    GeneralOfferTable myOfferDB;
    Button button;
    GeneralOfferDataSource datasource;
    ImageView icon;


    public String store;

    public Offer offer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        offerName = (TextView)findViewById(R.id.textViewOfferName12);
        offerShop = (TextView)findViewById(R.id.textViewProductPrice);
        offerExpiry = (TextView)findViewById(R.id.textViewPreviousExpiry);

        icon = (ImageView)findViewById(R.id.imageViewPreviousIcon);


        Intent intent = getIntent();
        offer = (Offer) intent.getSerializableExtra("Offer");
        setOfferDetails(offer);


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

    public void onMapButtonClick(View v){

        Intent mapIntent = new Intent(this, MapsActivity.class);

            mapIntent.putExtra("Offer", offer);
            startActivity(mapIntent);

    }

    public void setOfferDetails(Offer offer){

        offerName.setText(offer.getName());
        offerShop.setText(offer.getShop());
        offerExpiry.setText(offer.getExpiry());
        icon.setImageResource(Integer.valueOf(offer.getIcon()));


    }


}