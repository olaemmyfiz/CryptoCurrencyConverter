package com.example.ibitoyeolarewaju.cryptocurrencyconverter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.*;

import API.ClientAPI;
import API.Network;
import Response.Bitcoin;
import Response.CryptoAPI;
import Response.Ethereum;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    CryptoAPI mCryptoAPI;
    Bitcoin mBitcoin;
    Ethereum mEthereum;

    double BitcoinGetUSD, EthereumGetUSD; //define variable to parse objects value
    ProgressDialog progressDialog;
    TextView textView_bitcoin;
    TextView textView_ethereum;

    CardView bitcoin;
    CardView ethereum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //progressDialog initialization
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("LOADING");
        progressDialog.setMessage("Almost There....");
        progressDialog.show();

        LoadCryptoCompare();



        textView_bitcoin = (TextView)findViewById(R.id.bitcoin);
        textView_ethereum = (TextView) findViewById(R.id.ethereum);

        bitcoin =(CardView) findViewById(R.id.bitcoin_cardView);
        ethereum =(CardView) findViewById(R.id.ethereum_cardView);

        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //parse both BTC & ETH value to ConvertionActivity
                Intent intent = new Intent(getApplicationContext(),ExchangeActivity.class);
                intent.putExtra("Bitcoin", BitcoinGetUSD);
                intent.putExtra("Ethereum", EthereumGetUSD);
                startActivity(intent);

            }
        });

        ethereum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ExchangeActivity.class);
                intent.putExtra("Bitcoin", BitcoinGetUSD);
                intent.putExtra("Ethereum", EthereumGetUSD);
                startActivity(intent);
            }
        });

    }

    //Loading response.....

    public void LoadCryptoCompare(){
        ClientAPI clientAPI = new ClientAPI();

        //Define Network to get client
        //Network network = ClientAPI.getClient.create(Network.class);
        try {
            Network network = ClientAPI.getClient().create(Network.class);
            //Client
            Call<CryptoAPI> BitcoinCall= network.getBitcoin();
            BitcoinCall.enqueue(new Callback<CryptoAPI>() {
                @Override
                public void onResponse(Call<CryptoAPI> call, Response<CryptoAPI> response) {
                    //initialized respond class
                    mCryptoAPI = new CryptoAPI();
                    mCryptoAPI = response.body();

                    //initialized the json object class
                    mBitcoin = new Bitcoin();
                    mEthereum = new Ethereum();

                    //parse object to variable
                    BitcoinGetUSD = mBitcoin.getUSD();
                    EthereumGetUSD = mEthereum.getUSD();

                    //display result in TextView with Local Currency Symbol
                    textView_bitcoin.setText("1 BTC : " + CurrencySymbol.getCurrencySymbol("USD") + BitcoinGetUSD);
                    textView_ethereum.setText("1 ETH : " + CurrencySymbol.getCurrencySymbol("USD") + EthereumGetUSD);

                    //stop progressDialog
                    progressDialog.dismiss();


                }

                @Override
                public void onFailure(Call<CryptoAPI> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
