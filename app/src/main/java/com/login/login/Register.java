package com.login.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity implements View.OnClickListener {
    DatabaseHelper dh;


    Button bRegister;
    EditText eUsername,ePassword,eName,eAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dh=new DatabaseHelper(this);


        eName=(EditText)findViewById(R.id.eName);
        eAge=(EditText)findViewById(R.id.eAge);
        eUsername=(EditText)findViewById(R.id.eUserName);
        ePassword=(EditText)findViewById(R.id.ePassword);
        bRegister=(Button)findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);




    }

     public  void  showMessage(String title,String msg)
     {
         AlertDialog.Builder builder=new AlertDialog.Builder(this);
         builder.setCancelable(true);
         builder.setTitle(title);
         builder.setMessage(msg);
     }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bRegister:

                boolean isInserted =  dh.insertData(eName.getText().toString(),ePassword.getText().toString(),eAge.getText().toString(),eUsername.getText().toString());
                if(isInserted == true)
                {
                    Toast.makeText(Register.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Register.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                }

               Cursor res= dh.getData();
                if(res.getCount() ==0)
                {
                    showMessage("Error","No data found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Id :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Password :"+res.getString(2)+"\n");
                    buffer.append("Age :"+res.getString(3)+"\n");
                    buffer.append("UserName :"+res.getString(4)+"\n");
                }
                //startActivity(new Intent(this, MainActivity.class));
                showMessage("Data",buffer.toString());

                break;


        }
    }
}
