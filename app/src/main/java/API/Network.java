package API;

import Response.CryptoAPI;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ibitoye Olarewaju on 10/11/2017.
 */

public interface Network {
    //API call to get json object & append the URL
    @GET("/data/pricemulti?fsyms=BTC,ETH&tsyms=USD&e=Coinbase&extraParams=your_app_name")
    Call<CryptoAPI> getBitcoin();
}
