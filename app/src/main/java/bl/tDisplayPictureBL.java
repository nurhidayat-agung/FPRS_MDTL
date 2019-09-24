package bl;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import library.spgmobile.common.tDisplayPictureData;
import library.spgmobile.dal.tDisplayPictureDA;

/**
 * Created by ASUS ZE on 23/08/2016.
 */
public class tDisplayPictureBL extends clsMainBL{

    public void saveData(List<tDisplayPictureData> Listdata){
        SQLiteDatabase db=getDb();
        tDisplayPictureDA _tDisplayPictureDA = new tDisplayPictureDA(db);
        for(tDisplayPictureData data:Listdata){
            _tDisplayPictureDA.SaveData(db, data);
        }
        db.close();
    }

    public tDisplayPictureData getData(){
        SQLiteDatabase db=getDb();
        tDisplayPictureDA _tDisplayPictureDA = new tDisplayPictureDA(db);
        tDisplayPictureData data=_tDisplayPictureDA.getData(db);
        db.close();
        return data;
    }
}
