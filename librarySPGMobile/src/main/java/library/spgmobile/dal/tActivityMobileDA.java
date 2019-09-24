package library.spgmobile.dal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import library.spgmobile.common.tActivityData;
import library.spgmobile.common.tActivityMobileData;
import library.spgmobile.common.tCustomerBasedMobileHeaderData;
import library.spgmobile.common.tSalesProductQuantityHeaderData;

/**
 * Created by rhezaTesar on 7/19/2017.
 */

public class tActivityMobileDA {
    // All Static variables

    // Contacts table name
    private static final String TABLE_CONTACTS = new clsHardCode().txtTable_tActivityMobile;

    // Contacts Table Columns names

    public tActivityMobileDA(SQLiteDatabase db) {
        tActivityMobileData dt=new tActivityMobileData();
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
                + dt.Property_intId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + dt.Property_dtActivity + " TEXT NULL,"
                + dt.Property_intActive + " TEXT NULL,"
                + dt.Property_intIdSyn + " TEXT NULL,"
                + dt.Property_intSubmit + " TEXT NULL,"
                + dt.Property_txtDesc + " TEXT NULL,"
                + dt.Property_txtImg1 + " BLOB NULL,"
                + dt.Property_txtImg2 + " BLOB NULL,"
                + dt.Property_txtOutletCode + " TEXT NULL,"
                + dt.Property_txtOutletName + " TEXT NULL,"
                + dt.Property_txtUserId + " TEXT NULL,"
                + dt.Property_intFlag + " TEXT NULL,"
                + dt.Property_txtBranch + " TEXT NULL,"
                + dt.Property_txtRoleId + " TEXT NULL,"
                + dt.Property_txtTypeActivity + " TEXT NULL,"
                + dt.Property_intSubTypeActivity + " TEXT NULL,"
                + dt.Property__intIsValid + " TEXT NULL,"
                + dt.Property_txtDeviceId + " TEXT NULL"
                +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    public void DropTable(SQLiteDatabase db) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void SaveDatatActivityData(SQLiteDatabase db,tActivityMobileData data) {
        tActivityMobileData dt=new tActivityMobileData();
        //ContentValues values = new ContentValues();
        //values.put(dt.Property_intIdMenu, data.get_intIdMenu());
        //values.put(dt.Property_txtRoleId, data.get_txtRoleId());
        // Inserting Row
        //db.insert(TABLE_CONTACTS, null, values);
//				db.execSQL("INSERT OR REPLACE into "+TABLE_CONTACTS+" ("+dt.Property_All+") "+
//					"values('"	+String.valueOf(data.get_dtActivity())+"','"
//						+String.valueOf(data.get_intActive())+"',"
//						+String.valueOf(data.get_intId())+",'"
//						+String.valueOf(data.get_intIdSyn())+"','"
//						+String.valueOf(data.get_intSubmit())+"','"
//						+String.valueOf(data.get_txtDesc())+"','"
//						+String.valueOf(data.get_txtDeviceId())+"','"
//						+String.valueOf(data.get_txtImg1())+"','"
//						+String.valueOf(data.get_txtImg2())+"','"
//						+String.valueOf(data.get_txtOutletCode())+"','"
//						+String.valueOf(data.get_txtOutletName())+"','"
//						+String.valueOf(data.get_txtUserId())+"','"
//						+String.valueOf(data.get_intFlag())+"','"
//						+String.valueOf(data.get_txtBranch())+"'"
//						+")");
        ContentValues cv = new ContentValues();
        cv.put(dt.Property_dtActivity, String.valueOf(data.get_dtActivity()));
        cv.put(dt.Property_intActive, String.valueOf(data.get_intActive()));

        cv.put(dt.Property_intIdSyn, String.valueOf(data.get_intIdSyn()));
        cv.put(dt.Property_intSubmit, String.valueOf(data.get_intSubmit()));
        cv.put(dt.Property_txtDesc, String.valueOf(data.get_txtDesc()));
        cv.put(dt.Property_txtDeviceId, String.valueOf(data.get_txtDeviceId()));
        cv.put(dt.Property_txtImg1, data.get_txtImg1());
        cv.put(dt.Property_txtImg2, data.get_txtImg2());
        cv.put(dt.Property_txtOutletCode, String.valueOf(data.get_txtOutletCode()));
        cv.put(dt.Property_txtOutletName, String.valueOf(data.get_txtOutletName()));
        cv.put(dt.Property_txtUserId, String.valueOf(data.get_txtUserId()));
        cv.put(dt.Property_intFlag, data.get_intFlag());
        cv.put(dt.Property_txtRoleId, String.valueOf(data.get_txtRoleId()));
        cv.put(dt.Property_txtBranch, data.get_txtBranch());
        cv.put(dt.Property_txtTypeActivity, data.get_txtTypeActivity());
        cv.put(dt.Property_intSubTypeActivity, data.get_intSubTypeActivity());
        cv.put(dt.Property__intIsValid, data.get_intIsValid());
        if(data.get_intId() == null){
            db.insert(TABLE_CONTACTS, null, cv);
        } else {
            cv.put(dt.Property_intId, String.valueOf(data.get_intId()));
            db.replace(TABLE_CONTACTS, null, cv);
        }
    }

    // Getting single contact
    public tActivityMobileData getData(SQLiteDatabase db,int id) {
        tActivityMobileData dt=new tActivityMobileData();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { dt.Property_dtActivity,
                        dt.Property_intActive,dt.Property_intId, dt.Property_intIdSyn, dt.Property_intSubmit
                        ,dt.Property_txtDesc
                        ,dt.Property_txtDeviceId
                        ,dt.Property_txtImg1
                        ,dt.Property_txtImg2
                        ,dt.Property_txtOutletCode
                        ,dt.Property_txtOutletName
                        ,dt.Property_txtUserId
                        ,dt.Property_intFlag
                        ,dt.Property_txtRoleId
                        ,dt.Property_txtBranch
                        ,dt.Property_txtTypeActivity
                }, dt.Property_intId + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        tActivityMobileData contact = new tActivityMobileData();
        contact.set_dtActivity(cursor.getString(0));
        contact.set_intActive(cursor.getString(1));
        contact.set_intId(cursor.getString(2));
        contact.set_intIdSyn(cursor.getString(3));
        contact.set_intSubmit(cursor.getString(4));
        contact.set_txtDesc(cursor.getString(5));
        contact.set_txtDeviceId(cursor.getString(6));
        contact.set_txtImg1(cursor.getBlob(7));
        contact.set_txtImg2(cursor.getBlob(8));
        contact.set_txtOutletCode(cursor.getString(9));
        contact.set_txtOutletName(cursor.getString(10));
        contact.set_txtUserId(cursor.getString(11));
        contact.set_intFlag(cursor.getString(12));
        contact.set_txtRoleId(cursor.getString(13));
        contact.set_txtBranch(cursor.getString(14));
        contact.set_txtTypeActivity(cursor.getString(15));
        // return contact
        cursor.close();
        return contact;
    }
    public tActivityMobileData getDataSubmit(SQLiteDatabase db,int id) {
        tActivityMobileData dt=new tActivityMobileData();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { dt.Property_dtActivity,
                        dt.Property_intActive,dt.Property_intId, dt.Property_intIdSyn, dt.Property_intSubmit
                        ,dt.Property_txtDesc
                        ,dt.Property_txtDeviceId
                        ,dt.Property_txtImg1
                        ,dt.Property_txtImg2
                        ,dt.Property_txtOutletCode
                        ,dt.Property_txtOutletName
                        ,dt.Property_txtUserId
                        ,dt.Property_intFlag
                        ,dt.Property_txtBranch
                        ,dt.Property_txtRoleId
                        ,dt.Property_txtTypeActivity
                }, dt.Property_intId + "=? AND "+dt.Property_intSubmit+"=?",
                new String[] { String.valueOf(id),"1" }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        tActivityMobileData contact = new tActivityMobileData();
        contact.set_dtActivity(cursor.getString(0));
        contact.set_intActive(cursor.getString(1));
        contact.set_intId(cursor.getString(2));
        contact.set_intIdSyn(cursor.getString(3));
        contact.set_intSubmit(cursor.getString(4));
        contact.set_txtDesc(cursor.getString(5));
        contact.set_txtDeviceId(cursor.getString(6));
        contact.set_txtImg1(cursor.getBlob(7));
        contact.set_txtImg2(cursor.getBlob(8));
        contact.set_txtOutletCode(cursor.getString(9));
        contact.set_txtOutletName(cursor.getString(10));
        contact.set_txtUserId(cursor.getString(11));
        contact.set_intFlag(cursor.getString(12));
        contact.set_txtBranch(cursor.getString(13));
        contact.set_txtRoleId(cursor.getString(14));
        contact.set_txtTypeActivity(cursor.getString(15));
        // return contact
        cursor.close();
        return contact;
    }
    public List<tActivityMobileData> getDataByOutletCode(SQLiteDatabase db, String id) {
        tActivityMobileData dt=new tActivityMobileData();
        List<tActivityMobileData> contactList = new ArrayList<tActivityMobileData>();
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { dt.Property_dtActivity,
                        dt.Property_intActive,dt.Property_intId, dt.Property_intIdSyn, dt.Property_intSubmit
                        ,dt.Property_txtDesc
                        ,dt.Property_txtDeviceId
                        ,dt.Property_txtImg1
                        ,dt.Property_txtImg2
                        ,dt.Property_txtOutletCode
                        ,dt.Property_txtOutletName
                        ,dt.Property_txtUserId
                        ,dt.Property_intFlag
                        ,dt.Property_txtRoleId
                        ,dt.Property_txtBranch
                        ,dt.Property_txtTypeActivity
                }, dt.Property_txtOutletCode + "=? AND "+dt.Property_intSubmit+"=?",
                new String[] { String.valueOf(id),"1" }, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact
        cursor.close();
        return contactList;
    }
    //getting count data push
    public int countActivityHomeAbsenPush(SQLiteDatabase db,  String code) {
        String selectQuery = "select coalesce(sum(1),0) from [tActivityMobile] where txtOutletCode='" + code + "' and intSubmit=1 and [intIdSyn]=1";

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
    //getting data status submit
    public int countActivityV2HomeAbsenByStatusSubmit(SQLiteDatabase db, String code) {

        String selectQuery = "select coalesce(sum(1),0) from [tActivityMobile] where txtOutletCode='" + code + "' and intSubmit=1 and [intIdSyn]=0";

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

    public int countActivityV2Mandatori(SQLiteDatabase db, String code) {

        String selectQuery = "select coalesce(sum(1),0) from [tActivityMobile] where txtOutletCode='" + code + "'";

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

    // Getting All Contacts
    public List<tActivityMobileData> getAllData(SQLiteDatabase db) {
        List<tActivityMobileData> contactList = new ArrayList<tActivityMobileData>();
        // Select All Query
        tActivityMobileData dt=new tActivityMobileData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                contact.set_intSubTypeActivity(cursor.getString(16));
                contact.set_intIsValid(cursor.getString(17));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }


    public List<tActivityMobileData> getAllDataByOutletCode(SQLiteDatabase db, String outletcode) {
        List<tActivityMobileData> contactList = new ArrayList<tActivityMobileData>();
        // Select All Query
        tActivityMobileData dt=new tActivityMobileData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS + " WHERE txtOutletCode='" + outletcode +"'" + "order by dtActivity desc";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                contact.set_intSubTypeActivity(cursor.getString(16));
                contact.set_intIsValid(cursor.getString(17));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public List<tActivityMobileData> getAllOutletCode(SQLiteDatabase db, String outletname) {
        List<tActivityMobileData> contactList = new ArrayList<tActivityMobileData>();
        // Select All Query
        tActivityMobileData dt=new tActivityMobileData();
        String selectQuery;
        if (outletname == "ALL OUTLET"){
            selectQuery = "SELECT  "+dt.Property_txtOutletCode+ "," + dt.Property_txtOutletName +
                    " FROM " + TABLE_CONTACTS + " group by " + dt.Property_txtOutletCode;
        } else {
            selectQuery = "SELECT  "+dt.Property_txtOutletCode+ "," + dt.Property_txtOutletName +
                    " FROM " + TABLE_CONTACTS + " WHERE txtOutletName='" + outletname +"' group by " + dt.Property_txtOutletCode;
        }

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_txtOutletCode(cursor.getString(0));
                contact.set_txtOutletName(cursor.getString(1));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    // Getting All Contacts
    public List<tActivityMobileData> getAllDataNew(SQLiteDatabase db) {
        List<tActivityMobileData> contactList = new ArrayList<tActivityMobileData>();
        // Select All Query
        tActivityData dt=new tActivityData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS +" WHERE "+dt.Property_intSubmit+"=0";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                contact.set_intSubTypeActivity(cursor.getString(16));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public tActivityMobileData getAllDataByBitActive(SQLiteDatabase db) {
        tActivityMobileData contact = new tActivityMobileData();
        // Select All Query
        tActivityMobileData dt=new tActivityMobileData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS +" WHERE "+dt.Property_intActive+"=1";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                contact.set_intSubTypeActivity(cursor.getString(16));
                contact.set_intIsValid(cursor.getString(17));
                // Adding contact to list
//						contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contact;
    }

    //get data by int sync
    public List<tActivityMobileData> getAllDataByIntSyc(SQLiteDatabase db, String int_sync) {
        List<tActivityMobileData> contactList = null;
        // Select All Query
        tActivityMobileData dt=new tActivityMobileData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS +" WHERE "+dt.Property_intIdSyn +"='"+int_sync+"'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList=new ArrayList<tActivityMobileData>();
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                contact.set_intSubTypeActivity(cursor.getString(16));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }



    public List<tActivityMobileData> getAllDataByIntSycAndOutlet(SQLiteDatabase db, String int_sync, String outlet) {
        List<tActivityMobileData> contactList = null;
        // Select All Query
        tActivityMobileData dt=new tActivityMobileData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS +" WHERE "+dt.Property_intIdSyn +"='"+int_sync+"'" + " AND " + dt.Property_txtOutletCode + "='" + outlet + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList=new ArrayList<tActivityMobileData>();
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                contact.set_intSubTypeActivity(cursor.getString(16));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public void DeleteDataNew(SQLiteDatabase db) {
        // Select All Query
        tActivityData dt=new tActivityData();
        db.delete(TABLE_CONTACTS, dt.Property_intSubmit + " = ?",
                new String[] { String.valueOf(0) });
        // return contact list
    }

    public List<tActivityMobileData> getAllDataSubmit(SQLiteDatabase db) {
        List<tActivityMobileData> contactList = new ArrayList<tActivityMobileData>();
        // Select All Query
        tActivityData dt=new tActivityData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS+" WHERE "+dt.Property_intSubmit+"=1";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }
    public int getAllCheckPushData(SQLiteDatabase db) {
        List<tActivityMobileData> contactList = null;
        // Select All Query
        tActivityMobileData dt = new tActivityMobileData();
        String selectQuery = "SELECT  1 FROM "
                + TABLE_CONTACTS +" WHERE " +dt.Property_intSubmit +" ='1' And "+dt.Property_intIdSyn+"=0" ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // return count
        int index = cursor.getCount();
        cursor.close();
        return index;
    }
    // Getting All Contacts
    public List<tActivityMobileData> getAllDataToPushData(SQLiteDatabase db) {
        List<tActivityMobileData> contactList = null;
        // Select All Query
        tActivityMobileData dt=new tActivityMobileData();
        String selectQuery = "SELECT  "+dt.Property_All+" FROM " + TABLE_CONTACTS +" WHERE "+dt.Property_intSubmit+"='1' AND "+dt.Property_intIdSyn+"='0'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            contactList=new ArrayList<tActivityMobileData>();
            do {
                tActivityMobileData contact = new tActivityMobileData();
                contact.set_dtActivity(cursor.getString(0));
                contact.set_intActive(cursor.getString(1));
                contact.set_intId(cursor.getString(2));
                contact.set_intIdSyn(cursor.getString(3));
                contact.set_intSubmit(cursor.getString(4));
                contact.set_txtDesc(cursor.getString(5));
                contact.set_txtDeviceId(cursor.getString(6));
                contact.set_txtImg1(cursor.getBlob(7));
                contact.set_txtImg2(cursor.getBlob(8));
                contact.set_txtOutletCode(cursor.getString(9));
                contact.set_txtOutletName(cursor.getString(10));
                contact.set_txtUserId(cursor.getString(11));
                contact.set_intFlag(cursor.getString(12));
                contact.set_txtBranch(cursor.getString(13));
                contact.set_txtRoleId(cursor.getString(14));
                contact.set_txtTypeActivity(cursor.getString(15));
                contact.set_intSubTypeActivity(cursor.getString(16));
                contact.set_intIsValid(cursor.getString(17));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    // Deleting single contact
    public void deleteContact(SQLiteDatabase db,String intIdSyn) {
        tActivityData dt = new tActivityData();
        db.delete(TABLE_CONTACTS, dt.Property_intIdSyn + " = ?",
                new String[] { String.valueOf(intIdSyn) });
    }

    public void DeleteAllDAta(SQLiteDatabase db) {
        // Drop older table if existed
        db.execSQL("DELETE FROM " + TABLE_CONTACTS);
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
