package library.spgmobile.common;

import library.spgmobile.dal.clsHardCode;

/**
 * Created by Dewi Oktaviani on 03/05/2017.
 */

public class tJawabanUserData {
    private String _intUserAnswer;
    private String _intUserId;
    private String _intRoleId;
    private String _intQuestionId;
    private String _intTypeQuestionId;
    private String _bolHaveAnswerList;
    private String _intAnswerId;
    private String _txtValue;
    private String _decBobot;
    private String _intSubmit;
    private String _intSync;
    private String _intNik;
    private String _txtPath;
    private byte[] _ptQuiz;
    private byte[] _txtFileQuiz;
    private String _intHeaderId;
    private String _dtDate;
    private String _dtDatetime;

    public String get_dtDatetime() {
        return _dtDatetime;
    }

    public void set_dtDatetime(String _dtDatetime) {
        this._dtDatetime = _dtDatetime;
    }

    public String get_intHeaderId() {
        return _intHeaderId;
    }

    public void set_intHeaderId(String _intHeaderId) {
        this._intHeaderId = _intHeaderId;
    }

    public String get_dtDate() {
        return _dtDate;
    }

    public void set_dtDate(String _dtDate) {
        this._dtDate = _dtDate;
    }

    public String get_txtPath() {
        return _txtPath;
    }

    public void set_txtPath(String _txtPath) {
        this._txtPath = _txtPath;
    }
    public byte[] get_txtFileQuiz() {
        return _txtFileQuiz;
    }

    public void set_txtFileQuiz(byte[] _txtFileQuiz) {
        this._txtFileQuiz = _txtFileQuiz;
    }

    public byte[] get_ptQuiz() {
        return _ptQuiz;
    }

    public void set_ptQuiz(byte[] _ptQuiz) {
        this._ptQuiz = _ptQuiz;
    }

    public String get_intNik() {
        return _intNik;
    }

    public void set_intNik(String _intNik) {
        this._intNik = _intNik;
    }

    public String get_intSubmit() {
        return _intSubmit;
    }

    public void set_intSubmit(String _intSubmit) {
        this._intSubmit = _intSubmit;
    }

    public String get_intSync() {
        return _intSync;
    }

    public void set_intSync(String _intSync) {
        this._intSync = _intSync;
    }

    public synchronized String get_intUserAnswer() {
        return _intUserAnswer;
    }

    public synchronized void set_intUserAnswer(String _intUserAnswer) {
        this._intUserAnswer = _intUserAnswer;
    }

    public synchronized String get_intUserId() {
        return _intUserId;
    }

    public synchronized void set_intUserId(String _intUserId) {
        this._intUserId = _intUserId;
    }

    public synchronized String get_intRoleId() {
        return _intRoleId;
    }

    public synchronized void set_intRoleId(String _intRoleId) {
        this._intRoleId = _intRoleId;
    }

    public synchronized String get_intQuestionId() {
        return _intQuestionId;
    }

    public synchronized void set_intQuestionId(String _intQuestionId) {
        this._intQuestionId = _intQuestionId;
    }

    public synchronized String get_intTypeQuestionId() {
        return _intTypeQuestionId;
    }

    public synchronized void set_intTypeQuestionId(String _intTypeQuestionId) {
        this._intTypeQuestionId = _intTypeQuestionId;
    }

    public synchronized String get_bolHaveAnswerList() {
        return _bolHaveAnswerList;
    }

    public synchronized void set_bolHaveAnswerList(String _bolHaveAnswerList) {
        this._bolHaveAnswerList = _bolHaveAnswerList;
    }

    public synchronized String get_intAnswerId() {
        return _intAnswerId;
    }

    public synchronized void set_intAnswerId(String _intAnswerId) {
        this._intAnswerId = _intAnswerId;
    }

    public synchronized String get_txtValue() {
        return _txtValue;
    }

    public synchronized void set_txtValue(String _txtValue) {
        this._txtValue = _txtValue;
    }

    public synchronized String get_decBobot() {
        return _decBobot;
    }

    public synchronized void set_decBobot(String _decBobot) {
        this._decBobot = _decBobot;
    }

    private static final String TABLE_CONTACTS = new clsHardCode().txtTable_tJawabanUser;

    public String Property_intUserAnswer = "intUserAnswer";
    public String Property_intUserId = "intUserId";
    public String Property_intRoleId = "intRoleId";
    public String Property_intQuestionId = "intQuestionId";
    public String Property_intTypeQuestionId = "intTypeQuestionId";
    public String Property_bolHaveAnswerList = "bolHaveAnswerList";
    public String Property_intAnswerId = "intAnswerId";
    public String Property_txtValue = "txtValue";
    public String Property_decBobot = "decBobot";
    public String Property_intSubmit = "intSubmit";
    public String Property_intSync = "intSync";
    public String Property_intNik = "intNik";
    public String Property_ptQuiz = "ptQuiz";
    public String Property_txtFileQuiz = "txtFileQuiz";
    public String Property_intHeaderId = "intHeaderId";
    public String Property_dtDate = "dtDate";
    public String Property_dtDatetime = "dtDatetime";
    public String Property_ListOftJawabanUserData = "ListOftJawabanUserData";
    public String Property_All = Property_intUserAnswer + "," + Property_intUserId + "," + Property_intNik + ","
            + Property_intRoleId + "," + Property_intQuestionId + "," + Property_intTypeQuestionId + "," + Property_bolHaveAnswerList
            + "," + Property_intAnswerId + "," + Property_txtValue + "," + Property_ptQuiz + ","
            + Property_txtFileQuiz + "," + Property_decBobot + "," + Property_intSubmit + "," + Property_intSync + ","
            + Property_intHeaderId + "," + Property_dtDate + "," + Property_dtDatetime;

    public String Property_Alls = TABLE_CONTACTS + "." +Property_intUserAnswer + "," + TABLE_CONTACTS + "." + Property_intUserId + ","
            + TABLE_CONTACTS + "." + Property_intNik + "," + TABLE_CONTACTS + "." + Property_intRoleId + ","
            + TABLE_CONTACTS + "." + Property_intQuestionId + "," + TABLE_CONTACTS + "." + Property_intTypeQuestionId + ","
            + TABLE_CONTACTS + "." + Property_bolHaveAnswerList + "," + TABLE_CONTACTS + "." + Property_intAnswerId + ","
            + TABLE_CONTACTS + "." + Property_txtValue + "," + TABLE_CONTACTS + "." + Property_ptQuiz + ","
            + TABLE_CONTACTS + "." + Property_txtFileQuiz + "," + TABLE_CONTACTS + "." + Property_decBobot + ","
            + TABLE_CONTACTS + "." + Property_intSubmit + "," + TABLE_CONTACTS + "." + Property_intSync + ","
            + TABLE_CONTACTS + "." + Property_intHeaderId + "," + TABLE_CONTACTS + "." + Property_dtDate + "," + TABLE_CONTACTS + "." + Property_dtDatetime;
    public tJawabanUserData(){
        super();
    }
}

