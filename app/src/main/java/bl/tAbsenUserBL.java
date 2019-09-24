package bl;

import android.database.sqlite.SQLiteDatabase;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import library.spgmobile.common.clsHelper;
import library.spgmobile.common.linkAPI;
import library.spgmobile.common.mconfigData;
import library.spgmobile.common.tAbsenUserData;
import library.spgmobile.common.tUserLoginData;
import library.spgmobile.common.tVisitPlanRealisasiData;
import library.spgmobile.dal.clsHardCode;
import library.spgmobile.dal.enumConfigData;
import library.spgmobile.dal.mconfigDA;
import library.spgmobile.dal.tAbsenUserDA;
import library.spgmobile.dal.tUserLoginDA;
import library.spgmobile.dal.tVisitPlanRealisasiDA;

public class tAbsenUserBL extends clsMainBL {
	public void saveData(List<tAbsenUserData> Listdata){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);		
		for(tAbsenUserData data:Listdata){
			_tAbsenUserDA.SaveDatatAbsenUserData(db, data);	
		}
		db.close();
	}

    public void saveDataDownload(List<tAbsenUserData> Listdata){
        SQLiteDatabase db=getDb();
        tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
        for(tAbsenUserData data:Listdata){
            _tAbsenUserDA.saveAbsenDownload(db, data);
        }
		db.close();
    }

	public List<tAbsenUserData> GetData(String IdAbsen){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		List<tAbsenUserData> ListData=new ArrayList<tAbsenUserData>();
		if(IdAbsen.equals("")){
			ListData=_tAbsenUserDA.getAllData(db);
		}else{
			tAbsenUserData dt=new tAbsenUserData();
			dt=_tAbsenUserDA.getData(db, Integer.valueOf(IdAbsen));
			ListData.add(dt);
		}
		db.close();
		return ListData;
	}
	public tAbsenUserData getDataCheckInActive(){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		tAbsenUserData dt=new tAbsenUserData();
		dt=_tAbsenUserDA.getDataCheckInActive(db);
		db.close();
		return dt;
	}
	public List<tAbsenUserData>  getAllDataToPushData(){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		List<tAbsenUserData> ListData=new ArrayList<tAbsenUserData>();
		ListData=_tAbsenUserDA.getAllDataToPushData(db);
		db.close();
		return ListData;
	}

	public List<tAbsenUserData>  getAllDataActive(){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		List<tAbsenUserData> ListData=new ArrayList<tAbsenUserData>();
		ListData=_tAbsenUserDA.getAllDataActive(db);
		db.close();
		return ListData;
	}

	public List<tAbsenUserData>  getAllDataActiveOrderByDate(){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		List<tAbsenUserData> ListData=new ArrayList<tAbsenUserData>();
		ListData=_tAbsenUserDA.getAllDataActiveOrderByDate(db);
		db.close();
		return ListData;
	}

	public int  getContactsCount(){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		int intCount=_tAbsenUserDA.getContactsCount(db);
		db.close();
		return intCount;
	}
	public void  getContactsCount(String IdData){
		SQLiteDatabase db=getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		_tAbsenUserDA.SaveDataSubmit(db,IdData);
		db.close();
	}

	public JSONArray DownloadAbsen(String versionName) throws Exception {
		SQLiteDatabase _db = getDb();
		tUserLoginDA _tUserLoginDA = new tUserLoginDA(_db);
		mconfigDA _mconfigDA = new mconfigDA(_db);

		String strVal2 = "";
		mconfigData dataAPI = _mconfigDA.getData(_db, enumConfigData.ApiKalbe.getidConfigData());
		strVal2 = dataAPI.get_txtValue();
		if (dataAPI.get_txtValue() == "") {
			strVal2 = dataAPI.get_txtDefaultValue();
		}
		//ambil version dari webservices
		tUserLoginData _dataUserLogin = _tUserLoginDA.getData(_db, 1);
		clsHelper _help = new clsHelper();
		linkAPI dtlinkAPI = new linkAPI();
		String txtMethod = "GetDatatAbsenUser_mobile";
		JSONObject resJson = new JSONObject();
		dtlinkAPI.set_txtMethod(txtMethod);
		dtlinkAPI.set_txtParam(_dataUserLogin.get_txtUserId());
		dtlinkAPI.set_txtToken(new clsHardCode().txtTokenAPI);
		dtlinkAPI.set_txtVesion(versionName);

//		String strLinkAPI = dtlinkAPI.QueryString(strVal2);
//		String JsonData = _help.pushtData(strLinkAPI, dtlinkAPI.get_txtParam(), Integer.valueOf(getBackGroundServiceOnline()));

		String strLinkAPI= dtlinkAPI.QueryString(strVal2);
		String JsonData= _help.ResultJsonData(_help.getHTML(strLinkAPI));

		org.json.simple.JSONArray JsonArray = _help.ResultJsonArray(JsonData);

		_db.close();
		return JsonArray;
	}

	public void checkOutSystem(String id, String time) {
		SQLiteDatabase db = getDb();
		tAbsenUserDA _tAbsenUserDA=new tAbsenUserDA(db);
		_tAbsenUserDA.checkoutSystem(db, id, time);
		db.close();
	}
}
