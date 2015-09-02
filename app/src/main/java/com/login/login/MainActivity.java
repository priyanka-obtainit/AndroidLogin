package com.login.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {



    Button bLogout;
    EditText eUsername,eName,eAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName=(EditText)findViewById(R.id.eName);
        eAge=(EditText)findViewById(R.id.eAge);
        eUsername=(EditText)findViewById(R.id.eUserName);
        bLogout=(Button)findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);


    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bLogout:

                startActivity(new Intent(this,login.class));
                break;


        }
    }
}
