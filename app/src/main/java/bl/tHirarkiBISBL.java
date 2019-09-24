package bl;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import library.spgmobile.common.tHirarkiBIS;
import library.spgmobile.dal.mParentDA;
import library.spgmobile.dal.tHirarkiBISDA;

/**
 * Created by Dewi Oktaviani on 12/09/2017.
 */

public class tHirarkiBISBL extends clsMainBL {
    //SQLiteDatabase db = getDb();
    public void SaveDataSPGFromTL(tHirarkiBIS dt){
        SQLiteDatabase _db = getDb();
        tHirarkiBISDA _tHirarkiBISDA = new tHirarkiBISDA(_db);
        _tHirarkiBISDA.SaveData(_db, dt);
        _db.close();
    }
    public void DeletetHirarkiBIS(){
        SQLiteDatabase _db = getDb();
        tHirarkiBISDA _tHirarkiBISDA = new tHirarkiBISDA(_db);
        _tHirarkiBISDA.DeleteAllDatatHirarkiBIS(_db);
        _db.close();
    }
    public List<tHirarkiBIS> GetDataByOutlet(String txtOutlet){
        SQLiteDatabase _db = getDb();
        tHirarkiBISDA _tHirarkiBISDA = new tHirarkiBISDA(_db);
        List<tHirarkiBIS> listData = _tHirarkiBISDA.GetDataByOutlet(_db,txtOutlet);
        _db.close();
        return listData;
    }

    public List<tHirarkiBIS> GetDataByOutletSpinner(String txtOutlet, String questionId){
        SQLiteDatabase _db = getDb();
        tHirarkiBISDA _tHirarkiBISDA = new tHirarkiBISDA(_db);
        List<tHirarkiBIS> listData = _tHirarkiBISDA.GetDataByOutletspinner(_db,txtOutlet, questionId);
        _db.close();
        return listData;
    }

    public List<tHirarkiBIS> GetAllData(){
        SQLiteDatabase _db = getDb();
        tHirarkiBISDA _tHirarkiBISDA = new tHirarkiBISDA(_db);
        List<tHirarkiBIS> listData = _tHirarkiBISDA.GetAllData(_db);
        _db.close();
        return listData;
    }
}
