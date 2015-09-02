package com.login.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by priyanka.desai_2 on 04-08-15.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    public  static  final  String  Database_Name="Demo";
    public  static  final String Table_Name="Users";
    public  static  final String col_1="Id";
    public  static  final String col_3="Name";
    public  static  final String col_4="Password";
    public  static  final String col_5="Age";
    public  static  final String col_6="UserName";



    public DatabaseHelper(Context context)
    {
        super(context, Database_Name, null, 1);

        try
        {
        }
        catch (Exception e)
       {
           e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL("Create table "+Table_Name+"("+col_1+" integer primary key autoincrement, "+col_3+" Text, "+col_4+" Text,"+col_5+" Integer, "+col_6+" text"+")");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("Drop table if exists "+Table_Name);
        onCreate(db);
    }


    public boolean insertData(String name,String password,String age,String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_3,name);
        contentValues.put(col_4,password);
        contentValues.put(col_5,age);
        contentValues.put(col_6, username);

        long result = db.insert(Table_Name,null,contentValues);
        if (result == -1)
            return false;
        else
            return  true;

    }



    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+Table_Name,null);
        return  res;

    }

}
