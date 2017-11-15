package cl.labs.steinnx.sanguchote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.labs.steinnx.sanguchote.retrofit.API_Usuario_Interface;
import cl.labs.steinnx.sanguchote.retrofit.Instance;
import cl.labs.steinnx.sanguchote.retrofit.UsuarioResponse;
import cl.labs.steinnx.sanguchote.view.activities.MenuPrincipalActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_ingresar;
    private EditText edt_nombre,edt_pass;

    Retrofit retrofit= new Instance().getConexion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ingresar = (Button) findViewById(R.id.btnIngresar);
        edt_nombre = (EditText) findViewById(R.id.etUsuarioLogin);
        edt_pass = (EditText) findViewById(R.id.etPasswordLogin);
        btn_ingresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnIngresar)
        {
            login();
        }
    }

    private void login() {

        API_Usuario_Interface anInterface = retrofit.create(API_Usuario_Interface.class);
        Call<UsuarioResponse> usuarioResponseCall = anInterface.loginUsuario(edt_nombre.getText().toString(),edt_pass.getText().toString());
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                if (response.isSuccessful()){
                    UsuarioResponse resp = response.body();
                    Log.e("BODY LO!!!!!!!!!!!!!","onResponeseeeeeeeeeeee: "+response.body().getEstado());
                    if (resp.getEstado()==1 ){
                        Intent i = new Intent(LoginActivity.this, MenuPrincipalActivity.class);
                        startActivity(i);  
                    }else if(  resp.getEstado()==2  ){
                        Toast.makeText(LoginActivity.this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                    }else if(resp.getEstado()==3 ){
                        Toast.makeText(LoginActivity.this, "Ingrese los campos necesarios", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Log.e("ERRORRRRR!!!!!!!!!!!!!!","onResponeseeeeeeeeeeee: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.e("ERRORRRRR!!!!!!!!!!!!!!","onFailureeeeeeeeeee: "+t.getMessage());
            }
        });



    }
}
