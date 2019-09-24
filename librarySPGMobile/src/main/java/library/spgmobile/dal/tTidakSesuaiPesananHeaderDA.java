package library.spgmobile.dal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import library.spgmobile.common.KoordinasiOutletData;
import library.spgmobile.common.tActivityMobileData;
import library.spgmobile.common.tOverStockHeaderData;
import library.spgmobile.common.tTidakSesuaiPesananHeaderData;

/**
 * Created by aan.junianto on 10/10/2017.
 */

public class tTidakSesuaiPesananHeaderDA {
    // All Static variables

    // Contacts table name
    private static final String TABLE_CONTACTS = new clsHardCode().txtTable_tTidakSesuaiPesananHeader;

    // Contacts Table Columns names
    public tTidakSesuaiPesananHeaderDA(SQLiteDatabase db) {
        tTidakSesuaiPesananHeaderData dt = new tTidakSesuaiPesananHeaderData();
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
                + dt.Property_intId + " TEXT PRIMARY KEY,"
                + dt.Property_dtDate + " TEXT NULL,"
                + dt.Property_txtKeterangan + " TEXT NULL,"
                + dt.Property_txtUserId + " TEXT NULL,"
                + dt.Property_txtUsername + " TEXT NULL,"
                + dt.Property_txtRoleId + " TEXT NULL,"
                + dt.Property_txtOutletCode + " TEXT NULL,"
                + dt.Property_txtOutletName + " TEXT NULL,"
                + dt.Property_txtBranchCode + " TEXT NULL,"
                + dt.Property_txtBranchName + " TEXT NULL,"
                + dt.Property_intCategoriId + " TEXT NULL,"
                + dt.Property_txtCategory + " TEXT NULL,"
                + dt.Property_txtNIK + " TEXT NULL,"
                + dt.Property_intSubmit + " TEXT NULL,"
                + dt.Property_intSync + " TEXT NULL" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    public void DropTable(SQLiteDatabase db) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
    }
    public List<tTidakSesuaiPesananHeaderData> getAllData(SQLiteDatabase db) {
        List<tTidakSesuaiPesananHeaderData> contactList = new ArrayList<tTidakSesuaiPesananHeaderData>();
        // select All Query
        tTidakSesuaiPesananHeaderData dt = new tTidakSesuaiPesananHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM "
                + TABLE_CONTACTS;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tTidakSesuaiPesananHeaderData contact = new tTidakSesuaiPesananHeaderData();
                contact.set_intId(String.valueOf(cursor.getString(0)));
                contact.set_dtDate(cursor.getString(1));
                contact.set_txtKeterangan(cursor.getString(2));
                contact.set_txtUserId(cursor.getString(3));
                contact.set_txtUsername(cursor.getString(4));
                contact.set_txtRoleId(cursor.getString(5));
                contact.set_txtOutletCode(cursor.getString(6));
                contact.set_txtOutletName(cursor.getString(7));
                contact.set_txtBranchCode(cursor.getString(8));
                contact.set_txtBranchName(cursor.getString(9));
                contact.set_txtNIK(cursor.getString(10));
                contact.set_intSubmit(cursor.getString(11));
                contact.set_intSync(cursor.getString(12));
                contact.set_intCategoriId(cursor.getString(13));
                contact.set_txtCategory(cursor.getString(14));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }
    public void SaveData(SQLiteDatabase db, tTidakSesuaiPesananHeaderData data) {
        tTidakSesuaiPesananHeaderData dt = new tTidakSesuaiPesananHeaderData();
        ContentValues cv = new ContentValues();
        cv.put(dt.Property_dtDate, String.valueOf(data.get_dtDate()));
        cv.put(dt.Property_txtKeterangan, String.valueOf(data.get_txtKeterangan()));
        cv.put(dt.Property_txtUserId, String.valueOf(data.get_txtUserId()));
        cv.put(dt.Property_txtUsername, String.valueOf(data.get_txtUsername()));
        cv.put(dt.Property_txtRoleId, String.valueOf(data.get_txtRoleId()));
        cv.put(dt.Property_txtOutletCode, String.valueOf(data.get_txtOutletCode()));
        cv.put(dt.Property_txtOutletName, String.valueOf(data.get_txtOutletName()));
        cv.put(dt.Property_txtBranchCode, String.valueOf(data.get_txtBranchCode()));
        cv.put(dt.Property_txtBranchName, String.valueOf(data.get_txtBranchName()));
        cv.put(dt.Property_intCategoriId, String.valueOf(data.get_intCategoriId()));
        cv.put(dt.Property_txtCategory, String.valueOf(data.get_txtCategory()));
        cv.put(dt.Property_txtNIK, String.valueOf(data.get_txtNIK()));
        cv.put(dt.Property_intSubmit, String.valueOf(data.get_intSubmit()));
        cv.put(dt.Property_intSync, String.valueOf(data.get_intSync()));
        if (data.get_intId() == null){
            db.insert(TABLE_CONTACTS, null, cv);
        } else {
            cv.put(dt.Property_intId, String.valueOf(data.get_intId()));
            db.replace(TABLE_CONTACTS, null, cv);
        }
    }
    public List<tTidakSesuaiPesananHeaderData> getAllDataByOutletCodeReport(SQLiteDatabase db, String outletcode) {
        List<tTidakSesuaiPesananHeaderData> contactList = new ArrayList<tTidakSesuaiPesananHeaderData>();
        // Select All Query
        tTidakSesuaiPesananHeaderData dt=new tTidakSesuaiPesananHeaderData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS + " WHERE txtOutletCode='" + outletcode +"'" + "order by dtDate desc";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tTidakSesuaiPesananHeaderData contact = new tTidakSesuaiPesananHeaderData();
                contact.set_intId(String.valueOf(cursor.getString(0)));
                contact.set_dtDate(cursor.getString(1));
                contact.set_txtKeterangan(cursor.getString(2));
                contact.set_txtUserId(cursor.getString(3));
                contact.set_txtUsername(cursor.getString(4));
                contact.set_txtRoleId(cursor.getString(5));
                contact.set_txtOutletCode(cursor.getString(6));
                contact.set_txtOutletName(cursor.getString(7));
                contact.set_txtBranchCode(cursor.getString(8));
                contact.set_txtBranchName(cursor.getString(9));
                contact.set_txtNIK(cursor.getString(10));
                contact.set_intSubmit(cursor.getString(11));
                contact.set_intSync(cursor.getString(12));
                contact.set_intCategoriId(cursor.getString(13));
                contact.set_txtCategory(cursor.getString(14));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }
    public List<tTidakSesuaiPesananHeaderData> getAllDataByOutletCode(SQLiteDatabase db, String code){
        List<tTidakSesuaiPesananHeaderData> contactList = null;
        // select all query
        tTidakSesuaiPesananHeaderData dt = new tTidakSesuaiPesananHeaderData();
        String selectQuery = "SELECT  " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_txtOutletCode + "='" + code + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tTidakSesuaiPesananHeaderData>();
            do {
                tTidakSesuaiPesananHeaderData contact = new tTidakSesuaiPesananHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_dtDate(cursor.getString(1));
                contact.set_txtKeterangan(cursor.getString(2));
                contact.set_txtUserId(cursor.getString(3));
                contact.set_txtUsername(cursor.getString(4));
                contact.set_txtRoleId(cursor.getString(5));
                contact.set_txtOutletCode(cursor.getString(6));
                contact.set_txtOutletName(cursor.getString(7));
                contact.set_txtBranchCode(cursor.getString(8));
                contact.set_txtBranchName(cursor.getString(9));
                contact.set_txtNIK(cursor.getString(10));
                contact.set_intSubmit(cursor.getString(11));
                contact.set_intSync(cursor.getString(12));
                contact.set_intCategoriId(cursor.getString(13));
                contact.set_txtCategory(cursor.getString(14));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }
    public int getAllCheckPushData(SQLiteDatabase db) {
        List<tTidakSesuaiPesananHeaderData> contactList = null;
        // Select All Query
        tTidakSesuaiPesananHeaderData dt = new tTidakSesuaiPesananHeaderData();
        String selectQuery = "SELECT  1 FROM "
                + TABLE_CONTACTS +" WHERE " +dt.Property_intSubmit +" ='1' And "+dt.Property_intSync+"=0" ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // return count
        int index = cursor.getCount();
        cursor.close();
        return index;
    }
    public List<tTidakSesuaiPesananHeaderData> getAllDataToPushData(SQLiteDatabase db){
        List<tTidakSesuaiPesananHeaderData> contactList = null;
        tTidakSesuaiPesananHeaderData dt = new tTidakSesuaiPesananHeaderData();

        String selectQuery = "SELECT " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSubmit + "=1 AND " + dt.Property_intSync + "=0";
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList = new ArrayList<tTidakSesuaiPesananHeaderData>();
            do {
                tTidakSesuaiPesananHeaderData contact = new tTidakSesuaiPesananHeaderData();
                contact.set_intId(cursor.getString(0));
                contact.set_dtDate(cursor.getString(1));
                contact.set_txtKeterangan(cursor.getString(2));
                contact.set_txtUserId(cursor.getString(3));
                contact.set_txtUsername(cursor.getString(4));
                contact.set_txtRoleId(cursor.getString(5));
                contact.set_txtOutletCode(cursor.getString(6));
                contact.set_txtOutletName(cursor.getString(7));
                contact.set_txtBranchCode(cursor.getString(8));
                contact.set_txtBranchName(cursor.getString(9));
                contact.set_txtNIK(cursor.getString(10));
                contact.set_intSubmit(cursor.getString(11));
                contact.set_intSync(cursor.getString(12));
                contact.set_intCategoriId(cursor.getString(13));
                contact.set_txtCategory(cursor.getString(14));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }
    //getting data status submit
    public int countStatusSubmit(SQLiteDatabase db, String code) {

        String selectQuery = "select coalesce(sum(1),0) from [tTidakSesuaiPesananHeader] where txtOutletCode='" + code + "' and intSubmit=1 and [intSync]=0";

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
    public int countPush(SQLiteDatabase db,  String code) {
        String selectQuery = "select coalesce(sum(1),0) from [tTidakSesuaiPesananHeader] where txtOutletCode='" + code + "' and intSubmit=1 and [intSync]=1";

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
    // Getting contacts Count
    public int getContactsCount(SQLiteDatabase db) {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        Cursor cursor = db.rawQuery(countQuery, null);
        int num =cursor.getCount();
        cursor.close();

        // return count
        return num;
    }
}
