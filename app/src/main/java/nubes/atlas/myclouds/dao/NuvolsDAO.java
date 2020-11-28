package nubes.atlas.myclouds.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import nubes.atlas.myclouds.activity.MainMenu;
import nubes.atlas.myclouds.model.Nuvol;
import java.util.ArrayList;

public class NuvolsDAO extends MainMenu {

    private SQLiteHelper connexion;
    private SQLiteDatabase db;
    private ArrayList<Nuvol> nuvolList;

    public NuvolsDAO(Context context){
        connexion = new SQLiteHelper(context);
        db =  connexion.getWritableDatabase();
    }

    public ArrayList<Nuvol> getAnimals() {
        String sql = "SELECT * FROM nuvols";
        Cursor c = db.rawQuery(sql, null);
        nuvolList = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                Nuvol n = new Nuvol();
                n.setNom(c.getString(1));
                n.setAbrev(c.getString(2));
                n.setAltura(c.getString(3));
                n.setPrecipitacio(c.getString(4));
                n.setDescripcio(c.getString(5));
                n.setImatge(c.getString(6));
                n.setIcono(c.getString(7));
                nuvolList.add(n);
            }while(c.moveToNext());
        }
        return nuvolList;
    }
    public Nuvol getNuvolInfo(String s) {
        String sql = "SELECT * FROM nuvols WHERE abrev = '"+s+"'";
        Log.d("kk", sql);
        Cursor c = db.rawQuery(sql, null);
        Nuvol n = new Nuvol();
        if(c.moveToFirst()){
            do{
                n.setNom(c.getString(1));
                n.setAbrev(c.getString(2));
                n.setAltura(c.getString(3));
                n.setPrecipitacio(c.getString(4));
                n.setDescripcio(c.getString(5));
                n.setImatge(c.getString(6));
                n.setIcono(c.getString(7));
            }while(c.moveToNext());
        }
        return n;
    }
}
