package com.example.ibitoyeolarewaju.cryptocurrencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class ExchangeActivity extends AppCompatActivity {


    DecimalFormat df = new DecimalFormat("####0.00");
    EditText first;
    TextView second;
    Spinner spinner, spinner2;
    //defined String Array for spinner
    String[] first_spinner = {"BTC - BitCoin", "ETH- Ethereum"};
    String[] second_spinner = {"USD - US Dollar", "EUR", "NAIRA - Nigeria", "GBP - British Pound",
            "ING - Indian Ruppe", "AUD - Austrialian Dollar", "CAD - Canadian Dollar",
            "SGD - Singapore Dollar", "CHF - Swiss Frame", "MYR - Malaysian Riggit", "JPY - Japanese Yen",
            "CNY - Chinese Yuan Renminbi", "NZD - New Zealand Dollar", "ZAR - South Africa Rand", "BRL - Brazilian Real",
            "SAR - Saudi Arabian Riyal", "KES - Kenyan Shilling", "KRW - South Korean Won", "GHS - Ghanaian Cedi",
            "ARS - Argentine Peso", "RUB - Russian Ruble"};
    //defined variable for spinner selected value
    double first_selected, second_selected;

    //defined variable for the value parsed from MainActivity
    double BitcoinGetUSD, EthereumGetUSD;

    //vairable to store editText value
    double getText;

    ImageView mImageView;
    View seprator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);


        // get value parsed from MainActivity
        BitcoinGetUSD = getIntent().getExtras().getDouble("Bitcoin");
        EthereumGetUSD = getIntent().getExtras().getDouble("Ethereum");

        //initialized views
        first = (EditText) findViewById(R.id.firstEdit);
        second = (TextView) findViewById(R.id.secondEdit);
        mImageView = (ImageView) findViewById(R.id.img);
        seprator = findViewById(R.id.view);

        //initialized spinnerFirst
        spinner = (Spinner) findViewById(R.id.spinnerFirst);
        //define ArrayAdapter1 for the Spinner and String Array defined (spinner_first)
        //Note
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ExchangeActivity.this,
                R.layout.support_simple_spinner_dropdown_item, first_spinner);

        //parse arrayAdapter1
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int pos = spinner.getSelectedItemPosition();
                if (pos == 0) {
                    mImageView.setImageResource(R.drawable.btc_logo1);
                    //get Spinner selected item value
                    first_selected = BitcoinGetUSD;

                    //Convert
                    double ops = (first_selected / second_selected) * getText;

                    //display in TextView
                    second.setText(df.format(ops));
                    //NOTE COLOR
                    seprator.setBackgroundColor(getResources().getColor(R.color.btcColor));
                }

                if (pos == 1) {
                    //get Spinner selected item value
                    first_selected = EthereumGetUSD;

                    //Convert
                    double ops = (first_selected / second_selected) * getText;

                    //display in TextView
                    second.setText(df.format(ops));
                    mImageView.setImageResource(R.drawable.eth_logo1);
                    seprator.setBackgroundColor(getResources().getColor(R.color.ethColor));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //initialized spinnersecond
        spinner2 = (Spinner) findViewById(R.id.spinnerSecond);

        //define ArrayAdapter2 for the Spinner and String Array defined (spinner_second)
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(ExchangeActivity.this,
                R.layout.support_simple_spinner_dropdown_item, second_spinner);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                //get spinner2 selected item value to string
                String sel = spinner2.getSelectedItem().toString();

                //compare the value
                //if true second_selected should set currency exchange rate. e.g EUR = 1.16095
                if (sel == "USD - US Dollar") {
                    second_selected = 1;
                    //Convert
                    double ops = (first_selected / second_selected) * getText;
                    //display the result in TextView with Local CurrencySymbol Symbol
                    //NOTE TO SELF
                    second.setText(CurrencySymbol.getCurrencySymbol("USD") + df.format(ops));
                } else if (sel == "EUR") {
                    second_selected = 1.16095;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("EUR") + df.format(ops));
                } else if (sel == "NAIRA - Nigeria") {
                    second_selected = 0.0033;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("NGN") + df.format(ops));
                } else if (sel == "GBP - British Pound") {
                    second_selected = 1.31281;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("GBP") + df.format(ops));
                } else if (sel == "ING - Indian Ruppe") {
                    second_selected = 0.01538;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("ING") + df.format(ops));
                } else if (sel == "AUD - Austrialian Dollar") {
                    second_selected = 0.76834;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("AUD") + df.format(ops));
                } else if (sel == "CAD - Canadian Dollar") {
                    second_selected = 0.78099;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("CAD") + df.format(ops));
                } else if (sel == "SGD - Singapore Dollar") {
                    second_selected = 0.73270;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("SGD") + df.format(ops));
                } else if (sel == "CHF - Swiss Franc") {
                    second_selected = 1.00224;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("CHF") + df.format(ops));
                } else if (sel == "MYR - Malaysian Riggit") {
                    second_selected = 0.23565;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("MYR") + df.format(ops));
                } else if (sel == "JPY - Japanese Yen") {
                    second_selected = 0.00880;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("JPY") + df.format(ops));
                } else if (sel == "CNY - Chinese Yuan Renminbi") {
                    second_selected = 0.15040;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("CNY") + df.format(ops));
                } else if (sel == "NZD - New Zealand Dollar") {
                    second_selected = 0.68779;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("NZD") + df.format(ops));
                } else if (sel == "ZAR - South Africa Rand") {
                    second_selected = 0.07097;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("ZAR") + df.format(ops));
                } else if (sel == "BRL - Brazilian Real") {
                    second_selected = 0.30903;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("BRL") + df.format(ops));
                } else if (sel == "SAR - Saudi Arabian Riyal") {
                    second_selected = 0.26665;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("SAR") + df.format(ops));
                } else if (sel == "KES - Kenyan Shilling") {
                    second_selected = 0.00962;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("KES") + df.format(ops));
                } else if (sel == "KRW - South Korean Won") {
                    second_selected = 0.00089;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("KRW") + df.format(ops));
                } else if (sel == "GHS - Ghanaian Cedi") {
                    second_selected = 0.22547;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("GHS") + df.format(ops));
                } else if (sel == "ARS - Argentine Peso") {
                    second_selected = 0.05687;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("ARS") + df.format(ops));
                } else if (sel == "RUB - Russian Ruble") {
                    second_selected = 0.01719;
                    double ops = (first_selected / second_selected) * getText;
                    second.setText(CurrencySymbol.getCurrencySymbol("RUB") + df.format(ops));
                }

            }
                        ///Note
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        first.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String get = editable.toString();
                if (get.length() > 0) {
                    getText = Double.valueOf(get);
                    double uu = (first_selected / second_selected) * getText;
                    second.setText(df.format(uu));
                }


            }
        });
    }
}
