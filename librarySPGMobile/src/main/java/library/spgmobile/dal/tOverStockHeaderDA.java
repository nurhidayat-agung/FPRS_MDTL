package library.spgmobile.dal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import library.spgmobile.common.tKemasanRusakHeaderData;
import library.spgmobile.common.tOverStockHeaderData;
import library.spgmobile.common.tSalesProductQuantityHeaderData;

/**
 * Created by aan.junianto on 15/09/2017.
 */

public class tOverStockHeaderDA {
    // All Static variables

    // Contacts table name
    private static final String TABLE_CONTACTS = new clsHardCode().txtTable_tOverStockHeader;

    // Contacts Table Columns names

    public tOverStockHeaderDA(SQLiteDatabase db){
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
                + dt.Property_intId + " TEXT PRIMARY KEY,"
                + dt.Property_txtOverStock + " TEXT NULL,"
                + dt.Property_txtDate + " TEXT NULL,"
                + dt.Property_OutletCode + " TEXT NULL,"
                + dt.Property_OutletName + " TEXT NULL,"
                + dt.Property_txtKeterangan + " TEXT NULL,"
                + dt.Property_intSumItem + " TEXT NULL,"
                + dt.Property_intSumAmount + " TEXT NULL,"
                + dt.Property_UserId + " TEXT NULL,"
                + dt.Property_intSubmit + " TEXT NULL,"
                + dt.Property_intSync + " TEXT NULL,"
                + dt.Property_txtBranchCode + " TEXT NULL,"
                + dt.Property_txtBranchName + " TEXT NULL,"
                + dt.Property_intIdAbsenUser + " TEXT NULL,"
                + dt.Property_txtRoleId + " TEXT NULL,"
                + dt.Property_txtAfterImg1 + " BLOB NULL,"
                + dt.Property_txtAfterImg2 + " BLOB NULL,"
                + dt.Property_txtBeforeImg1 + " BLOB NULL,"
                + dt.Property_txtBeforeImg2 + " BLOB NULL,"
                + dt.Property_txtNIK + " TEXT NULL" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // upgrading database
    public void Droptable(SQLiteDatabase db) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void SaveDataOverStockData(SQLiteDatabase db, tOverStockHeaderData data) {
        tOverStockHeaderData dt = new tOverStockHeaderData();
        ContentValues cv = new ContentValues();
        cv.put(dt.Property_txtOverStock, data.get_txtOverStock());
        cv.put(dt.Property_OutletCode, data.get_OutletCode());
        cv.put(dt.Property_OutletName, data.get_OutletName());
        cv.put(dt.Property_txtDate, data.get_dtDate());
        cv.put(dt.Property_txtKeterangan, data.get_txtKeterangan());
        cv.put(dt.Property_txtNIK, data.get_txtNIK());
        cv.put(dt.Property_intSumAmount, data.get_intSumAmount());
        cv.put(dt.Property_intSumItem, data.get_intSumItem());
        cv.put(dt.Property_UserId, data.get_UserId());
        cv.put(dt.Property_intSubmit, data.get_intSubmit());
        cv.put(dt.Property_intSync, data.get_intSync());
        cv.put(dt.Property_txtBranchCode, data.get_txtBranchCode());
        cv.put(dt.Property_txtBranchName, data.get_txtBranchName());
        cv.put(dt.Property_intIdAbsenUser, data.get_intIdAbsenUser());
        cv.put(dt.Property_txtRoleId, data.get_txtRoleId());
//        cv.put(dt.Property_txtAfterImg1, data.get_txtAfterImg1());
//        cv.put(dt.Property_txtAfterImg2, data.get_txtAfterImg2());
//        cv.put(dt.Property_txtBeforeImg1, data.get_txtBeforeImg1());
//        cv.put(dt.Property_txtBeforeImg2, data.get_txtBeforeImg2());
        if (data.get_intId() == null){
            db.insert(TABLE_CONTACTS, null, cv);
        } else {
            cv.put(dt.Property_intId, data.get_intId());
            db.replace(TABLE_CONTACTS, null, cv);
        }
//        tSalesProductQuantityHeaderData dt1 = getData(db,data.get_intId());
//        if (dt1 == null) {
//            cv.put(dt.Property_intId, String.valueOf(data.get_intId()));
//            db.insert(TABLE_CONTACTS, null, cv);
//        } else {
//            cv.put(dt.Property_intId, String.valueOf(data.get_intId()));
//            db.replace(TABLE_CONTACTS, null, cv);
//        }
    }

    public void UpdateDataItem(SQLiteDatabase db, tOverStockHeaderData data) {
        tOverStockHeaderData dt = new tOverStockHeaderData();
        db.execSQL("Update " + TABLE_CONTACTS + " set  "
                + dt.Property_intSumAmount + "="
                + String.valueOf(data.get_intSumAmount())
                + dt.Property_intSumItem + "="
                + String.valueOf(data.get_intSumItem())
                + " Where " + dt.Property_intId + "='" + data.get_intId() + "'");
    }

    public void UpdateDataItemForSubmit(SQLiteDatabase db, String dataid) {
        tOverStockHeaderData dt = new tOverStockHeaderData();
        db.execSQL("Update " + TABLE_CONTACTS + " set  "
                + dt.Property_intSubmit + "=1"
                + " Where " + dt.Property_intId + "='" + dataid + "'");
    }

    // Getting single contact
    public tOverStockHeaderData getData(SQLiteDatabase db, String id){
        tOverStockHeaderData dt = new tOverStockHeaderData();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{dt.Property_intId, dt.Property_txtOverStock,
                        dt.Property_OutletCode, dt.Property_OutletName,
                        dt.Property_txtDate, dt.Property_txtKeterangan, dt.Property_txtNIK
                        , dt.Property_intSumAmount, dt.Property_intSumItem, dt.Property_UserId, dt.Property_intSubmit, dt.Property_txtRoleId
                        , dt.Property_intSync, dt.Property_txtBranchCode, dt.Property_txtBranchName, dt.Property_intIdAbsenUser
                        , dt.Property_txtAfterImg1, dt.Property_txtAfterImg2, dt.Property_txtBeforeImg1, dt.Property_txtBeforeImg2}, dt.Property_intId + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        tOverStockHeaderData contact = null;
        if (cursor.getCount() > 0) {
            contact = new tOverStockHeaderData();
            if (cursor != null)
                cursor.moveToFirst();
            contact.set_intId(cursor.getString(0));
            contact.set_txtOverStock(cursor.getString(1));
            contact.set_OutletCode(cursor.getString(2));
            contact.set_OutletName(cursor.getString(3));
            contact.set_dtDate(cursor.getString(4));
            contact.set_txtKeterangan(cursor.getString(5));
            contact.set_txtNIK(cursor.getString(6));
            contact.set_intSumAmount(cursor.getString(7));
            contact.set_intSumItem(cursor.getString(8));
            contact.set_UserId(cursor.getString(9));
            contact.set_intSubmit(cursor.getString(10));
            contact.set_intSync(cursor.getString(11));
            contact.set_txtBranchCode(cursor.getString(12));
            contact.set_txtBranchName(cursor.getString(13));
            contact.set_intIdAbsenUser(cursor.getString(14));
            contact.set_txtRoleId(cursor.getString(15));
            contact.set_txtAfterImg1(cursor.getBlob(16));
            contact.set_txtAfterImg2(cursor.getBlob(17));
            contact.set_txtBeforeImg1(cursor.getBlob(18));
            contact.set_txtBeforeImg2(cursor.getBlob(19));
        }
        cursor.close();
        return contact;
    }

    public boolean CheckDataPushData(SQLiteDatabase db) {
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT 1 FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSubmit + "=1 AND " + dt.Property_intSync + "=0";
        Cursor cursor = db.rawQuery(selectQuery, null);
        boolean result = false;
        if (cursor.getCount() > 0) {
            result = true;
        }
        cursor.close();
        // return contact list
        return result;
    }

    //getting data status submit
    public int countOStockStatusSubmit(SQLiteDatabase db, String code) {

        String selectQuery = "select coalesce(sum(1),0) from [tOverStockHeader] where OutletCode='" + code + "' and intSubmit=1 and [intSync]=0";

        Cursor cursor = db.rawQuery(selectQuery, null);

        int count = 0;

        if (cursor.moveToFirst()) {
            do {
                count=Integer.valueOf(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return contact list
        return count;
    }

    //getting count data push
    public int countOStockPush(SQLiteDatabase db,  String code) {
        String selectQuery = "select coalesce(sum(1),0) from [tOverStockHeader] where OutletCode='" + code + "' and intSubmit=1 and [intSync]=1";

        Cursor cursor = db.rawQuery(selectQuery, null);

        int count = 0;

        if (cursor.moveToFirst()) {
            do {
                count=Integer.valueOf(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return contact list
        return count;
    }
    public int getAllCheckPushData(SQLiteDatabase db) {
        List<tOverStockHeaderData> contactList = null;
        // Select All Query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  1 FROM "
                + TABLE_CONTACTS +" WHERE " +dt.Property_intSubmit +" ='1' And "+dt.Property_intSync+"=0" ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // return count
        int index = cursor.getCount();
        cursor.close();
        return index;
    }
    // Getting All Contacts
    public List<tOverStockHeaderData> getAllDataToPushData(SQLiteDatabase db){
        List<tOverStockHeaderData> contactList = null;
        // Select All Query
        tOverStockHeaderData dt = new tOverStockHeaderData();

        String selectQuery = "SELECT " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSubmit + "=1 AND " + dt.Property_intSync + "=0";
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_txtOverStock(cursor.getString(1));
                contact.set_dtDate(cursor.getString(2));
                contact.set_OutletCode(cursor.getString(3));
                contact.set_OutletName(cursor.getString(4));
                contact.set_txtKeterangan(cursor.getString(5));
                contact.set_intSumItem(cursor.getString(6));
                contact.set_intSumAmount(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtNIK(cursor.getString(14));
                contact.set_txtRoleId(cursor.getString(15));
                contact.set_txtAfterImg1(cursor.getBlob(16));
                contact.set_txtAfterImg2(cursor.getBlob(17));
                contact.set_txtBeforeImg1(cursor.getBlob(18));
                contact.set_txtBeforeImg2(cursor.getBlob(19));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public List<tOverStockHeaderData> getAllData(SQLiteDatabase db) {
        List<tOverStockHeaderData> contactList = null;
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " ORDER BY txtOverStock DESC";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_txtOverStock(cursor.getString(1));
                contact.set_dtDate(cursor.getString(2));
                contact.set_OutletCode(cursor.getString(3));
                contact.set_OutletName(cursor.getString(4));
                contact.set_txtKeterangan(cursor.getString(5));
                contact.set_intSumItem(cursor.getString(6));
                contact.set_intSumAmount(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtNIK(cursor.getString(14));
                contact.set_txtRoleId(cursor.getString(15));
                contact.set_txtAfterImg1(cursor.getBlob(16));
                contact.set_txtAfterImg2(cursor.getBlob(17));
                contact.set_txtBeforeImg1(cursor.getBlob(18));
                contact.set_txtBeforeImg2(cursor.getBlob(19));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllDataByOutlet(SQLiteDatabase db, String txtOutletCode) {
        List<tOverStockHeaderData> contactList = null;
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_OutletCode + "='" + txtOutletCode + "' AND " + dt.Property_intSubmit + "=1";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_OutletCode(cursor.getString(1));
                contact.set_OutletName(cursor.getString(2));
                contact.set_dtDate(cursor.getString(3));
                contact.set_txtKeterangan(cursor.getString(4));
                contact.set_txtNIK(cursor.getString(5));
                contact.set_intSumAmount(cursor.getString(6));
                contact.set_intSumItem(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtAfterImg1(cursor.getBlob(15));
                contact.set_txtAfterImg2(cursor.getBlob(16));
                contact.set_txtBeforeImg1(cursor.getBlob(17));
                contact.set_txtBeforeImg2(cursor.getBlob(18));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllDataSubmit(SQLiteDatabase db) {
        List<tOverStockHeaderData> contactList = null;
        // Select All Query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSubmit + "=1";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()){
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_OutletCode(cursor.getString(1));
                contact.set_OutletName(cursor.getString(2));
                contact.set_dtDate(cursor.getString(3));
                contact.set_txtKeterangan(cursor.getString(4));
                contact.set_txtNIK(cursor.getString(5));
                contact.set_intSumAmount(cursor.getString(6));
                contact.set_intSumItem(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtAfterImg1(cursor.getBlob(15));
                contact.set_txtAfterImg2(cursor.getBlob(16));
                contact.set_txtBeforeImg1(cursor.getBlob(17));
                contact.set_txtBeforeImg2(cursor.getBlob(18));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllDataNotSync(SQLiteDatabase db) {
        List<tOverStockHeaderData> contactList = null;
        // select All Query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSync + "=0";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_OutletCode(cursor.getString(1));
                contact.set_OutletName(cursor.getString(2));
                contact.set_dtDate(cursor.getString(3));
                contact.set_txtKeterangan(cursor.getString(4));
                contact.set_txtNIK(cursor.getString(5));
                contact.set_intSumAmount(cursor.getString(6));
                contact.set_intSumItem(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllDataByIdAbsen(SQLiteDatabase db, String Id) {
        List<tOverStockHeaderData> contactList = null;
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intIdAbsenUser + "='" + Id + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_OutletCode(cursor.getString(1));
                contact.set_OutletName(cursor.getString(2));
                contact.set_dtDate(cursor.getString(3));
                contact.set_txtKeterangan(cursor.getString(4));
                contact.set_txtNIK(cursor.getString(5));
                contact.set_intSumAmount(cursor.getString(6));
                contact.set_intSumItem(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtAfterImg1(cursor.getBlob(15));
                contact.set_txtAfterImg2(cursor.getBlob(16));
                contact.set_txtBeforeImg1(cursor.getBlob(17));
                contact.set_txtBeforeImg2(cursor.getBlob(18));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    //get data by int sync
    public List<tOverStockHeaderData> getAllDataByIntSyc(SQLiteDatabase db, String int_sync) {
        List<tOverStockHeaderData> contactList = null;
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSync + "='" + int_sync + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_OutletCode(cursor.getString(1));
                contact.set_OutletName(cursor.getString(2));
                contact.set_dtDate(cursor.getString(3));
                contact.set_txtKeterangan(cursor.getString(4));
                contact.set_txtNIK(cursor.getString(5));
                contact.set_intSumAmount(cursor.getString(6));
                contact.set_intSumItem(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtAfterImg1(cursor.getBlob(15));
                contact.set_txtAfterImg2(cursor.getBlob(16));
                contact.set_txtBeforeImg1(cursor.getBlob(17));
                contact.set_txtBeforeImg2(cursor.getBlob(18));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllDataByIntSycAndOutlet(SQLiteDatabase db, String int_sync, String outlet){
        List<tOverStockHeaderData> contactList = null;
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSync + "='" + int_sync + "' AND " + dt.Property_OutletCode + "='" + outlet + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_OutletCode(cursor.getString(1));
                contact.set_OutletName(cursor.getString(2));
                contact.set_dtDate(cursor.getString(3));
                contact.set_txtKeterangan(cursor.getString(4));
                contact.set_txtNIK(cursor.getString(5));
                contact.set_intSumAmount(cursor.getString(6));
                contact.set_intSumItem(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtAfterImg1(cursor.getBlob(15));
                contact.set_txtAfterImg2(cursor.getBlob(16));
                contact.set_txtBeforeImg1(cursor.getBlob(17));
                contact.set_txtBeforeImg2(cursor.getBlob(18));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllDataByOutletCode(SQLiteDatabase db, String code){
        List<tOverStockHeaderData> contactList = null;
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_OutletCode + "='" + code + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_txtOverStock(cursor.getString(1));
                contact.set_dtDate(cursor.getString(2));
                contact.set_OutletCode(cursor.getString(3));
                contact.set_OutletName(cursor.getString(4));
                contact.set_txtKeterangan(cursor.getString(5));
                contact.set_intSumItem(cursor.getString(6));
                contact.set_intSumAmount(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtNIK(cursor.getString(14));
                contact.set_txtRoleId(cursor.getString(15));
                contact.set_txtAfterImg1(cursor.getBlob(16));
                contact.set_txtAfterImg2(cursor.getBlob(17));
                contact.set_txtBeforeImg1(cursor.getBlob(18));
                contact.set_txtBeforeImg2(cursor.getBlob(19));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getDataByTxtOverStock(SQLiteDatabase db, String id){
        List<tOverStockHeaderData> contactList = new ArrayList<tOverStockHeaderData>();
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_txtOverStock + "='" + id + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_txtOverStock(cursor.getString(1));
                contact.set_dtDate(cursor.getString(2));
                contact.set_OutletCode(cursor.getString(3));
                contact.set_OutletName(cursor.getString(4));
                contact.set_txtKeterangan(cursor.getString(5));
                contact.set_intSumItem(cursor.getString(6));
                contact.set_intSumAmount(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtNIK(cursor.getString(14));
                contact.set_txtRoleId(cursor.getString(15));
                contact.set_txtAfterImg1(cursor.getBlob(16));
                contact.set_txtAfterImg2(cursor.getBlob(17));
                contact.set_txtBeforeImg1(cursor.getBlob(18));
                contact.set_txtBeforeImg2(cursor.getBlob(19));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllDataByDateCheckin(SQLiteDatabase db, String date) {
        List<tOverStockHeaderData> contactList = null;
        // select All Query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_txtDate + "='" + date + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_txtOverStock(cursor.getString(1));
                contact.set_dtDate(cursor.getString(2));
                contact.set_OutletCode(cursor.getString(3));
                contact.set_OutletName(cursor.getString(4));
                contact.set_txtKeterangan(cursor.getString(5));
                contact.set_intSumItem(cursor.getString(6));
                contact.set_intSumAmount(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtNIK(cursor.getString(14));
                contact.set_txtRoleId(cursor.getString(15));
                contact.set_txtAfterImg1(cursor.getBlob(16));
                contact.set_txtAfterImg2(cursor.getBlob(17));
                contact.set_txtBeforeImg1(cursor.getBlob(18));
                contact.set_txtBeforeImg2(cursor.getBlob(19));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tOverStockHeaderData> getAllData2(SQLiteDatabase db) {
        List<tOverStockHeaderData> contactList = new ArrayList<tOverStockHeaderData>();
        // Select All Query
        tOverStockHeaderData dt=new tOverStockHeaderData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_txtOverStock(cursor.getString(1));
                contact.set_txtNIK(cursor.getString(2));
                contact.set_txtKeterangan(cursor.getString(3));
                contact.set_dtDate(cursor.getString(4));
                contact.set_OutletCode(cursor.getString(5));
                contact.set_OutletName(cursor.getString(6));
                contact.set_intSumItem(cursor.getString(7));
                contact.set_intSumAmount(cursor.getString(8));
                contact.set_UserId(cursor.getString(9));
                contact.set_intSubmit(cursor.getString(10));
                contact.set_intSync(cursor.getString(11));
                contact.set_txtBranchCode(cursor.getString(12));
                contact.set_txtBranchName(cursor.getString(13));
                contact.set_intIdAbsenUser(cursor.getString(14));
                contact.set_txtRoleId(cursor.getString(15));
                contact.set_txtAfterImg1(cursor.getBlob(16));
                contact.set_txtAfterImg2(cursor.getBlob(17));
                contact.set_txtBeforeImg1(cursor.getBlob(18));
                contact.set_txtAfterImg2(cursor.getBlob(19));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    // Deleting single contact
    public void deleteContact(SQLiteDatabase db, String id) {
        tOverStockHeaderData dt = new tOverStockHeaderData();
        db.delete(TABLE_CONTACTS, dt.Property_intId + " = ?",
                new String[]{String.valueOf(id)});
    }

    public void DeleteAllDAta(SQLiteDatabase db) {
        // Drop older table if existed
        db.execSQL("DELETE FROM " + TABLE_CONTACTS);
    }

    // Getting contacts Count
    public int getContactsCount(SQLiteDatabase db) {
        String countQuery = "SELECT 1 FROM " + TABLE_CONTACTS;
        Cursor cursor = db.rawQuery(countQuery, null);
        // return count
        int index = cursor.getCount();
        cursor.close();
        return index;
    }

    public List<tOverStockHeaderData> getLastData(SQLiteDatabase db) {
        List<tOverStockHeaderData> contactList = null;
        // select all query
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS  + " order by " + dt.Property_txtOverStock;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToLast()) {
            contactList = new ArrayList<tOverStockHeaderData>();
            do {
                tOverStockHeaderData contact = new tOverStockHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_txtOverStock(cursor.getString(1));
                contact.set_dtDate(cursor.getString(2));
                contact.set_OutletCode(cursor.getString(3));
                contact.set_OutletName(cursor.getString(4));
                contact.set_txtKeterangan(cursor.getString(5));
                contact.set_intSumItem(cursor.getString(6));
                contact.set_intSumAmount(cursor.getString(7));
                contact.set_UserId(cursor.getString(8));
                contact.set_intSubmit(cursor.getString(9));
                contact.set_intSync(cursor.getString(10));
                contact.set_txtBranchCode(cursor.getString(11));
                contact.set_txtBranchName(cursor.getString(12));
                contact.set_intIdAbsenUser(cursor.getString(13));
                contact.set_txtNIK(cursor.getString(14));
                contact.set_txtRoleId(cursor.getString(15));
                contact.set_txtAfterImg1(cursor.getBlob(16));
                contact.set_txtAfterImg2(cursor.getBlob(17));
                contact.set_txtBeforeImg1(cursor.getBlob(18));
                contact.set_txtBeforeImg2(cursor.getBlob(19));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public void deleteByQuantityStock(SQLiteDatabase db, String Noso) {
        tOverStockHeaderData dt = new tOverStockHeaderData();
        String whereClause = dt.Property_txtOverStock + " = ?";
        String[] whereArgs = new String[]{
                String.valueOf(Noso)
        };

        db.delete(TABLE_CONTACTS, whereClause, whereArgs);
    }
}
