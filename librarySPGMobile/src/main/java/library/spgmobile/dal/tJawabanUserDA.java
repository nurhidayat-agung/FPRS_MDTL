package library.spgmobile.dal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import library.spgmobile.common.mPertanyaanData;
import library.spgmobile.common.tJawabanUserData;
import library.spgmobile.common.tTidakSesuaiPesananHeaderData;


/**
 * Created by Dewi Oktaviani on 04/05/2017.
 */

public class tJawabanUserDA {
    private static final String TABLE_CONTACTS = new clsHardCode().txtTable_tJawabanUser;
    private static final String TABLE_QUESTION = new clsHardCode().txtTable_mPertanyaan;
    public tJawabanUserDA(SQLiteDatabase db){
        tJawabanUserData dt = new tJawabanUserData();
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_CONTACTS + "( " + dt.Property_intUserAnswer + " TEXT PRIMARY KEY,"
                + dt.Property_intHeaderId + " TEXT NULL," + dt.Property_dtDate + " TEXT NULL,"
                + dt.Property_dtDatetime + " TEXT NULL," + dt.Property_intUserId + " TEXT NULL,"
                + dt.Property_intNik + " TEXT NULL," + dt.Property_intRoleId + " TEXT NULL,"
                + dt.Property_intQuestionId + " TEXT NULL," + dt.Property_intTypeQuestionId + " TEXT NULL,"
                + dt.Property_bolHaveAnswerList + " TEXT NULL," + dt.Property_intAnswerId + " TEXT NULL,"
                + dt.Property_txtValue + " TEXT NULL," + dt.Property_ptQuiz + " TEXT NULL,"
                + dt.Property_txtFileQuiz + " TEXT NULL," + dt.Property_decBobot + " TEXT NULL,"
                + dt.Property_intSubmit + " TEXT NULL," + dt.Property_intSync + " TEXT NULL)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    public void DropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
    }
    public void SaveDatatJawabanUser(SQLiteDatabase db, tJawabanUserData data){
        tJawabanUserData dt = new tJawabanUserData();
        ContentValues cv = new ContentValues();
        cv.put(dt.Property_intUserAnswer, String.valueOf(data.get_intUserAnswer()));
        cv.put(dt.Property_intUserId, String.valueOf(data.get_intUserId()));
        cv.put(dt.Property_intNik, String.valueOf(data.get_intNik()));
        cv.put(dt.Property_intRoleId, String.valueOf(data.get_intRoleId()));
        cv.put(dt.Property_intQuestionId, String.valueOf(data.get_intQuestionId()));
        cv.put(dt.Property_intTypeQuestionId, String.valueOf(data.get_intTypeQuestionId()));
        cv.put(dt.Property_bolHaveAnswerList, String.valueOf(data.get_bolHaveAnswerList()));
        cv.put(dt.Property_intAnswerId, String.valueOf(data.get_intAnswerId()));
        cv.put(dt.Property_txtValue, String.valueOf(data.get_txtValue()));
        cv.put(dt.Property_ptQuiz, data.get_ptQuiz());
        cv.put(dt.Property_txtFileQuiz, data.get_txtFileQuiz());
        cv.put(dt.Property_decBobot, String.valueOf(data.get_decBobot()));
        cv.put(dt.Property_intSubmit, String.valueOf(data.get_intSubmit()));
        cv.put(dt.Property_intHeaderId, String.valueOf(data.get_intHeaderId()));
        cv.put(dt.Property_dtDate, String.valueOf(data.get_dtDate()));
        cv.put(dt.Property_dtDatetime, String.valueOf(data.get_dtDatetime()));
        if (data.get_intAnswerId() == null){
            cv.put(dt.Property_intSync, String.valueOf(data.get_intSync()));
            db.insert(TABLE_CONTACTS, null, cv);
        } else {
            cv.put(dt.Property_intSync, String.valueOf(data.get_intSync()));
            db.replace(TABLE_CONTACTS, null, cv);
        }
    }
    public void DeleteAllDatatJawabanUser(SQLiteDatabase db){
        db.execSQL("DELETE FROM " + TABLE_CONTACTS);
    }
    public List<tJawabanUserData> GetAllData(SQLiteDatabase db){
        List<tJawabanUserData> contactList = new ArrayList<tJawabanUserData>();
        tJawabanUserData dt = new tJawabanUserData();
        String selectQuery = "Select " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSubmit + "=1" + " ORDER BY intUserId ASC";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                tJawabanUserData contact = new tJawabanUserData();
                contact.set_intUserAnswer(cursor.getString(0));
                contact.set_intUserId(cursor.getString(1));
                contact.set_intNik(cursor.getString(2));
                contact.set_intRoleId(cursor.getString(3));
                contact.set_intQuestionId(cursor.getString(4));
                contact.set_intTypeQuestionId(cursor.getString(5));
                contact.set_bolHaveAnswerList(cursor.getString(6));
                contact.set_intAnswerId(cursor.getString(7));
                contact.set_txtValue(cursor.getString(8));
                byte[] blob = cursor.getBlob(9);
                contact.set_ptQuiz(blob);
                contact.set_txtFileQuiz(cursor.getBlob(10));
                contact.set_decBobot(cursor.getString(11));
                contact.set_intSubmit(cursor.getString(12));
                contact.set_intSync(cursor.getString(13));
                contact.set_intHeaderId(cursor.getString(14));
                contact.set_dtDate(cursor.getString(15));
                contact.set_dtDatetime(cursor.getString(16));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tJawabanUserData> GetDataByHeaderId(SQLiteDatabase db, String intHeaderId){
        List<tJawabanUserData> contactList = new ArrayList<tJawabanUserData>();
        tJawabanUserData dt = new tJawabanUserData();
        String selectQuery = "Select " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intHeaderId + "='" + intHeaderId +"' GROUP BY " + dt.Property_intQuestionId;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                tJawabanUserData contact = new tJawabanUserData();
                contact.set_intUserAnswer(cursor.getString(0));
                contact.set_intUserId(cursor.getString(1));
                contact.set_intNik(cursor.getString(2));
                contact.set_intRoleId(cursor.getString(3));
                contact.set_intQuestionId(cursor.getString(4));
                contact.set_intTypeQuestionId(cursor.getString(5));
                contact.set_bolHaveAnswerList(cursor.getString(6));
                contact.set_intAnswerId(cursor.getString(7));
                contact.set_txtValue(cursor.getString(8));
                byte[] blob = cursor.getBlob(9);
                contact.set_ptQuiz(blob);
                contact.set_txtFileQuiz(cursor.getBlob(10));
                contact.set_decBobot(cursor.getString(11));
                contact.set_intSubmit(cursor.getString(12));
                contact.set_intSync(cursor.getString(13));
                contact.set_intHeaderId(cursor.getString(14));
                contact.set_dtDate(cursor.getString(15));
                contact.set_dtDatetime(cursor.getString(16));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tJawabanUserData> GetDataByHeaderIdOrderBySoalId(SQLiteDatabase db, String intHeaderId){
        List<tJawabanUserData> contactList = new ArrayList<tJawabanUserData>();
        tJawabanUserData dt = new tJawabanUserData();
        mPertanyaanData data = new mPertanyaanData();
        String selectQuery = "Select " + (dt.Property_Alls + " FROM " + TABLE_CONTACTS + " LEFT OUTER JOIN "+ TABLE_QUESTION +
                " ON " + TABLE_CONTACTS + "." + dt.Property_intQuestionId + "=" +TABLE_QUESTION + "." + data.Property_intQuestionId +
                " WHERE " + TABLE_CONTACTS + "." + dt.Property_intHeaderId + "='" + intHeaderId +"' GROUP BY " + TABLE_CONTACTS + "." + dt.Property_intQuestionId +
                " ORDER BY " + TABLE_QUESTION + "." + data.Property_intCategoryId + "," +TABLE_QUESTION + "." + data.Property_intSoalId);
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                tJawabanUserData contact = new tJawabanUserData();
                contact.set_intUserAnswer(cursor.getString(0));
                contact.set_intUserId(cursor.getString(1));
                contact.set_intNik(cursor.getString(2));
                contact.set_intRoleId(cursor.getString(3));
                contact.set_intQuestionId(cursor.getString(4));
                contact.set_intTypeQuestionId(cursor.getString(5));
                contact.set_bolHaveAnswerList(cursor.getString(6));
                contact.set_intAnswerId(cursor.getString(7));
                contact.set_txtValue(cursor.getString(8));
                byte[] blob = cursor.getBlob(9);
                contact.set_ptQuiz(blob);
                contact.set_txtFileQuiz(cursor.getBlob(10));
                contact.set_decBobot(cursor.getString(11));
                contact.set_intSubmit(cursor.getString(12));
                contact.set_intSync(cursor.getString(13));
                contact.set_intHeaderId(cursor.getString(14));
                contact.set_dtDate(cursor.getString(15));
                contact.set_dtDatetime(cursor.getString(16));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public List<tJawabanUserData> GetDataByQuestionId(SQLiteDatabase db, String intQuestionId, String intHeaderId){
        List<tJawabanUserData> contactList = new ArrayList<tJawabanUserData>();
        tJawabanUserData dt = new tJawabanUserData();
        String selectQuery = "Select " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intQuestionId + "='"
                + intQuestionId + "' AND " + dt.Property_intHeaderId + "='" + intHeaderId + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                tJawabanUserData contact = new tJawabanUserData();
                contact.set_intUserAnswer(cursor.getString(0));
                contact.set_intUserId(cursor.getString(1));
                contact.set_intNik(cursor.getString(2));
                contact.set_intRoleId(cursor.getString(3));
                contact.set_intQuestionId(cursor.getString(4));
                contact.set_intTypeQuestionId(cursor.getString(5));
                contact.set_bolHaveAnswerList(cursor.getString(6));
                contact.set_intAnswerId(cursor.getString(7));
                contact.set_txtValue(cursor.getString(8));
                byte[] blob = cursor.getBlob(9);
                contact.set_ptQuiz(blob);
                contact.set_txtFileQuiz(cursor.getBlob(10));
                contact.set_decBobot(cursor.getString(11));
                contact.set_intSubmit(cursor.getString(12));
                contact.set_intSync(cursor.getString(13));
                contact.set_intHeaderId(cursor.getString(14));
                contact.set_dtDate(cursor.getString(15));
                contact.set_dtDatetime(cursor.getString(16));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    public int getAllCheckPushData(SQLiteDatabase db) {
        List<tJawabanUserData> contactList = null;
        // Select All Query
        tJawabanUserData dt = new tJawabanUserData();
        String selectQuery = "SELECT  1 FROM "
                + TABLE_CONTACTS +" WHERE " +dt.Property_intSubmit +" ='1' And "+dt.Property_intSync+"=0" ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        // return count
        int index = cursor.getCount();
        cursor.close();
        return index;
    }

    public List<tJawabanUserData> GetDataToPushAnswer(SQLiteDatabase db){
        List<tJawabanUserData> contactList = null;
        tJawabanUserData dt = new tJawabanUserData();
        String selectQuery = "Select " + dt.Property_All + " FROM " + TABLE_CONTACTS + " WHERE " + dt.Property_intSubmit + "=1 AND " + dt.Property_intSync + " =0";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            contactList = new ArrayList<tJawabanUserData>();
            do {
                tJawabanUserData contact = new tJawabanUserData();
                contact.set_intUserAnswer(cursor.getString(0));
                contact.set_intUserId(cursor.getString(1));
                contact.set_intNik(cursor.getString(2));
                contact.set_intRoleId(cursor.getString(3));
                contact.set_intQuestionId(cursor.getString(4));
                contact.set_intTypeQuestionId(cursor.getString(5));
                contact.set_bolHaveAnswerList(cursor.getString(6));
                contact.set_intAnswerId(cursor.getString(7));
                contact.set_txtValue(cursor.getString(8));
                byte[] blob = cursor.getBlob(9);
                contact.set_ptQuiz(blob);
                byte[] blobFile = cursor.getBlob(10);
                contact.set_txtFileQuiz(blobFile);
                contact.set_decBobot(cursor.getString(11));
                contact.set_intSubmit(cursor.getString(12));
                contact.set_intSync(cursor.getString(13));
                contact.set_intHeaderId(cursor.getString(14));
                contact.set_dtDate(cursor.getString(15));
                contact.set_dtDatetime(cursor.getString(16));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }
}