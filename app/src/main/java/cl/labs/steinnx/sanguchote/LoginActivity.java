package cl.labs.steinnx.sanguchote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.labs.steinnx.sanguchote.view.MenuPrincipalActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ingresar = (Button) findViewById(R.id.btnIngresar);

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
        Intent i = new Intent(LoginActivity.this, MenuPrincipalActivity.class);
        startActivity(i);
    }
}
