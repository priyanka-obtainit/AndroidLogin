package com.login.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends Activity implements View.OnClickListener {
    Button bLogin;
    TextView tvRgLink;
    EditText eUsername,ePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsername=(EditText)findViewById(R.id.eUserName);
        ePassword=(EditText)findViewById(R.id.ePassword);
        bLogin=(Button)findViewById(R.id.bLogin);
        tvRgLink=(TextView)findViewById(R.id.tvRgLink);


        bLogin.setOnClickListener(this);

        tvRgLink.setOnClickListener(this);


    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bLogin:

                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.tvRgLink:

                startActivity(new Intent(this,Register.class));
                break;


        }
    }
}
