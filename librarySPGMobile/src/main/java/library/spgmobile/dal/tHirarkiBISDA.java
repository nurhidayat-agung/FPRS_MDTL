package library.spgmobile.dal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import library.spgmobile.common.tHirarkiBIS;
import library.spgmobile.common.tJawabanUserData;

/**
 * Created by Dewi Oktaviani on 11/09/2017.
 */

public class tHirarkiBISDA {
    private static final String TABLE_CONTACTS = new clsHardCode().txtTable_tHirarkiBIS;
    private static final String TABLE_JAWABANSPG = new clsHardCode().txtTable_tJawabanUser;
    private static final String TABLE_QUESTION = new clsHardCode().txtTable_mPertanyaan;
    public tHirarkiBISDA(SQLiteDatabase db){
        tHirarkiBIS dt = new tHirarkiBIS();
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_CONTACTS + "( " + dt.Property_intId  + " INTEGER PRIMARY KEY,"
                + dt.Property_txtNik + " TEXT NULL," + dt.Property_txtName + " TEXT NULL,"
                + dt.Property_txtLOB + " TEXT NULL,"  + dt.Property_intBranchId + " TEXT NULL,"
                + dt.Property_txtBranchCode + " TEXT NULL," + dt.Property_txtBranchName + " TEXT NULL,"
                + dt.Property_intOutletId + " TEXT NULL,"+ dt.Property_txtOutletCode + " TEXT NULL,"
                + dt.Property_txtOutletName + " TEXT NULL)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    public void DropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
    }
    public void SaveData(SQLiteDatabase db, tHirarkiBIS data){
        tHirarkiBIS dt = new tHirarkiBIS();
        ContentValues cv = new ContentValues();
        cv.put(dt.Property_intId, String.valueOf(data.get_intId()));
        cv.put(dt.Property_txtNik, String.valueOf(data.get_txtNik()));
        cv.put(dt.Property_txtName, String.valueOf(data.get_txtName()));
        cv.put(dt.Property_txtLOB, String.valueOf(data.get_txtLOB()));
        cv.put(dt.Property_intBranchId, String.valueOf(data.get_intBranchId()));
        cv.put(dt.Property_txtBranchCode, String.valueOf(data.get_txtBranchCode()));
        cv.put(dt.Property_txtBranchName, String.valueOf(data.get_txtBranchName()));
        cv.put(dt.Property_intOutletId, String.valueOf(data.get_intOutletId()));
        cv.put(dt.Property_txtOutletCode, String.valueOf(data.get_txtOutletCode()));
        cv.put(dt.Property_txtOutletName, String.valueOf(data.get_txtOutletName()));
        if (data.get_intId() == null){
            db.insert(TABLE_CONTACTS, null, cv);
        } else {
            db.replace(TABLE_CONTACTS, null, cv);
        }
    }
    public void DeleteAllDatatHirarkiBIS(SQLiteDatabase db){
        db.execSQL("DELETE FROM " + TABLE_CONTACTS);
    }
    public List<tHirarkiBIS> GetDataByOutlet(SQLiteDatabase db, String txtOutlet){
        List<tHirarkiBIS> contactList = new ArrayList<tHirarkiBIS>();
        tHirarkiBIS dt = new tHirarkiBIS();
        String selectQuery = "Select " + dt.Property_All + " FROM " + TABLE_CONTACTS + " Where " + dt.Property_txtOutletCode + "='" + txtOutlet + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                tHirarkiBIS contact = new tHirarkiBIS();
                contact.set_txtNik(cursor.getString(0));
                contact.set_txtName(cursor.getString(1));
                contact.set_txtLOB(cursor.getString(2));
                contact.set_intBranchId(cursor.getString(3));
                contact.set_txtBranchCode(cursor.getString(4));
                contact.set_txtBranchName(cursor.getString(5));
                contact.set_intOutletId(cursor.getString(6));
                contact.set_txtOutletCode(cursor.getString(7));
                contact.set_txtOutletName(cursor.getString(8));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tHirarkiBIS> GetAllData(SQLiteDatabase db){
        List<tHirarkiBIS> contactList = new ArrayList<tHirarkiBIS>();
        tHirarkiBIS dt = new tHirarkiBIS();
        String selectQuery = "Select " + dt.Property_All + " FROM " + TABLE_CONTACTS;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                tHirarkiBIS contact = new tHirarkiBIS();
                contact.set_txtNik(cursor.getString(0));
                contact.set_txtName(cursor.getString(1));
                contact.set_txtLOB(cursor.getString(2));
                contact.set_intBranchId(cursor.getString(3));
                contact.set_txtBranchCode(cursor.getString(4));
                contact.set_txtBranchName(cursor.getString(5));
                contact.set_intOutletId(cursor.getString(6));
                contact.set_txtOutletCode(cursor.getString(7));
                contact.set_txtOutletName(cursor.getString(8));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tHirarkiBIS> GetDataByOutletspinner(SQLiteDatabase db, String txtOutlet, String questionId){
        List<tHirarkiBIS> contactList = new ArrayList<tHirarkiBIS>();
        tHirarkiBIS dt = new tHirarkiBIS();
        tJawabanUserData data = new tJawabanUserData();
        String selectQuery = "Select " + dt.Property_Alls + " FROM " + TABLE_CONTACTS + " LEFT OUTER JOIN " + TABLE_JAWABANSPG + " ON "
                + TABLE_CONTACTS + "." + dt.Property_txtNik + "=" + TABLE_JAWABANSPG +  "." + data.Property_txtValue +
                " Where " + TABLE_CONTACTS + "." +  dt.Property_txtOutletCode + "='" + txtOutlet + "' AND " //+ TABLE_JAWABANSPG +  "." + data.Property_txtValue + " IS NULL OR "
                + TABLE_JAWABANSPG +  "." + data.Property_intQuestionId + "='" + questionId + "'";
               // + questionId + "'";// AND " + TABLE_JAWABANSPG +  "." + data.Property_txtValue + " IS NULL ";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                tHirarkiBIS contact = new tHirarkiBIS();
                contact.set_txtNik(cursor.getString(0));
                contact.set_txtName(cursor.getString(1));
                contact.set_txtLOB(cursor.getString(2));
                contact.set_intBranchId(cursor.getString(3));
                contact.set_txtBranchCode(cursor.getString(4));
                contact.set_txtBranchName(cursor.getString(5));
                contact.set_intOutletId(cursor.getString(6));
                contact.set_txtOutletCode(cursor.getString(7));
                contact.set_txtOutletName(cursor.getString(8));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }
    // Getting contacts Count
    public int getContactsCount(SQLiteDatabase db) {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        Cursor cursor = db.rawQuery(countQuery, null);
        int countData = cursor.getCount();
        cursor.close();
        // return count
        return countData;
    }
}
