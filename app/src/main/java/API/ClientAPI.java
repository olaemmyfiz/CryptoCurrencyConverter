package API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ibitoye Olarewaju on 10/11/2017.
 */

    public  class ClientAPI {

    //cryptocompare api
    public static final String API_BASE_URL = "https://min-api.cryptocompare.com";

    //Define Retrofit library
    private static Retrofit retrofit = null;

    //get Client API
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()

                    //Parse the BASE_URL
                    .baseUrl(API_BASE_URL)
                    //Convert API into Gson format
                    .addConverterFactory(GsonConverterFactory.create())
                    //Build the URL
                    .build();
        }
        //return retrofit
        return retrofit;
    }

    }

