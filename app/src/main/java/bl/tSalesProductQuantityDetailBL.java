package bl;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import library.spgmobile.common.tSalesProductQuantityDetailData;
import library.spgmobile.dal.tSalesProductQuantityDetailDA;

/**
 * Created by Rian Andrivani on 3/17/2017.
 */

public class tSalesProductQuantityDetailBL extends clsMainBL{
    //SQLiteDatabase db;

    public List<tSalesProductQuantityDetailData> GetDataNoQuantityStock(String Noso){
        SQLiteDatabase db=getDb();
        tSalesProductQuantityDetailDA _tSalesProductQuantityDetailDA = new tSalesProductQuantityDetailDA(db);
        List<tSalesProductQuantityDetailData>ListData = _tSalesProductQuantityDetailDA.getDataNoQuantityStock(db, Noso);
        db.close();
        return ListData;
    }

    public void saveData(tSalesProductQuantityDetailData dt) {
        SQLiteDatabase _db = getDb();
        tSalesProductQuantityDetailDA _tSalesProductQuantityDetailDA = new tSalesProductQuantityDetailDA(_db);
        _tSalesProductQuantityDetailDA.SaveDatatSalesProductQuantityDetailData(_db, dt);
        _db.close();
    }

    public List<tSalesProductQuantityDetailData> getAllDataByHeaderId(String id){
        SQLiteDatabase _db = getDb();
        List<tSalesProductQuantityDetailData> dtDetail = new tSalesProductQuantityDetailDA(_db).getAllDataByHeaderId(_db, id);
        _db.close();
        return dtDetail;
    }

    public List<tSalesProductQuantityDetailData> GetDataByNoQuantityStock(String id) {
        SQLiteDatabase _db =getDb();
        List<tSalesProductQuantityDetailData> ListData = new tSalesProductQuantityDetailDA(_db).getDataByQuantityStock(_db, id);
        _db.close();
        return ListData;
    }

    public void deleteData(tSalesProductQuantityDetailData dt){
        SQLiteDatabase _db = getDb();
        new tSalesProductQuantityDetailDA(_db).deleteByID(_db, dt.getIntId());
        _db.close();
    }

    public void deleteDataByProductId(String id) {
        SQLiteDatabase _db=getDb();
        new tSalesProductQuantityDetailDA(_db).deleteByID(_db, id);
        _db.close();
    }
}
