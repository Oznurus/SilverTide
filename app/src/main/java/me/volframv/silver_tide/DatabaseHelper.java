package me.volframv.silver_tide;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by PRIME-USER-X10423 on 11/10/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);

    }

    private static String DB_NAME="my_silvertide.sqlite";
    private static String DB_PATH="";

    private SQLiteDatabase myDatabase;
    private Context myContext;

    public DatabaseHelper(Context context){
        super(context, DB_NAME,null, 1);
        if (Build.VERSION.SDK_INT>=15) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }else {
            DB_PATH = Environment.getDataDirectory() + "/data/" + context.getPackageName() + "/databases/";
        }
        this.myContext = context;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void checkAndCopyDatabase(){
        boolean dbExist = checkDatabase();
        if (dbExist){
            Log.d("TAG","database already exists");
        }else{
            this.getReadableDatabase();
        }
        try{
            copyDatabase();
        }catch (IOException e){
            e.printStackTrace();
            Log.d("TAG","Error copy database");
        }
    }
    public boolean checkDatabase(){
        SQLiteDatabase checkDB =null;
        String myPath=DB_PATH+DB_NAME;
        checkDB=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
        if (checkDB !=null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    public void copyDatabase() throws IOException {
        InputStream myInput= myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer=new byte[1024];
        int length;
        while((length = myInput.read(buffer)) > 0){
            myOutput.write(buffer, 0,length);
        }
        myOutput.flush();
        myOutput.close();

    }
    public synchronized void close(){
        if(myDatabase !=null){
            myDatabase.close();
        }
        super.close();
    }
    public Cursor QueryData(String query){
        return myDatabase.rawQuery(query,null);
    }
}
