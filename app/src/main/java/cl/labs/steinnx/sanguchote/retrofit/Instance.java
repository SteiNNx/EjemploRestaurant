package cl.labs.steinnx.sanguchote.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DUOC on 14-11-2017.
 */

public class  Instance {
    Retrofit retrofit;

    public Instance() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://kailalkalil.esy.es/WebServices_Restaurante/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getConexion(){
        return  retrofit;
    }
}
