package bl;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import library.spgmobile.common.mKategoriData;
import library.spgmobile.dal.mKategoriDA;

/**
 * Created by Dewi Oktaviani on 05/05/2017.
 */

public class mKategoriBL extends clsMainBL {
    //SQLiteDatabase db = getDb();

    public void SaveData(mKategoriData dt){
        SQLiteDatabase _db = getDb();
        mKategoriDA _mKategoriDA = new mKategoriDA(_db);
        _mKategoriDA.SaveDatamKategori(_db, dt);
        _db.close();
    }

    public List<mKategoriData> GetAllData(){
        SQLiteDatabase _db = getDb();
        mKategoriDA _mKategoriDA = new mKategoriDA(_db);
        List<mKategoriData> dt = _mKategoriDA.GetAllData(_db);
        _db.close();
        return dt;
    }

    public mKategoriData GetCategoryById(String intId){
        SQLiteDatabase _db = getDb();
        mKategoriDA _mKategoriDA = new mKategoriDA(_db);
        mKategoriData dt = _mKategoriDA.GetCategoryById(_db, intId);
        _db.close();
        return dt;
    }

    public void DeletemKategori(){
        SQLiteDatabase _db = getDb();
        mKategoriDA _mKategoriDA = new mKategoriDA(_db);
        _mKategoriDA.DeleteAllDatamKategori(_db) ;
        _db.close();
    }
}
