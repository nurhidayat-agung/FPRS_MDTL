package com.kalbenutritionals.app.kalbespgmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import adapter.AppAdapterViewCusBase;
import bl.clsHelperBL;
import bl.tSalesProductDetailBL;
import bl.tSalesProductHeaderBL;
import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;
import edu.swu.pulltorefreshswipemenulistview.library.swipemenu.interfaces.OnMenuItemClickListener;
import edu.swu.pulltorefreshswipemenulistview.library.swipemenu.interfaces.SwipeMenuCreator;
import edu.swu.pulltorefreshswipemenulistview.library.util.RefreshTime;
import library.spgmobile.common.clsSwipeList;
import library.spgmobile.common.tSalesProductDetailData;
import library.spgmobile.common.tSalesProductHeaderData;
import library.spgmobile.common.visitplanAbsenData;

/**
 * Created by aan.junianto on 24/08/2017.
 */

public class FragmentViewResoFPE extends Fragment implements IXListViewListener {
    private static List<clsSwipeList> swipeList = new ArrayList<clsSwipeList>();
    private AppAdapterViewCusBase mAdapter;

    private PullToRefreshSwipeMenuListView mListView2;

    private Handler mHandler;
    private Map<String, HashMap> mapMenu;
    private List<tSalesProductHeaderData> dt;
    private List<tSalesProductDetailData> data;
    private FloatingActionButton fab;

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_view_global,container,false);

        fab = (FloatingActionButton) v.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
                toolbar.setTitle("Add Reso");

                FragmentAddResoFPE fragmentAddResoFPE = new FragmentAddResoFPE();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragmentAddResoFPE);
                fragmentTransaction.commit();
            }
        });
        final PullToRefreshSwipeMenuListView swipeMenuList = (PullToRefreshSwipeMenuListView) v.findViewById(R.id.SwipelistView);
        swipeMenuList.setPullRefreshEnable(true);
        swipeMenuList.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int previousDistanceFromFirstCellToTop;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                View firstCell = mListView2.getChildAt(0);
                if(firstCell == null){ return; }
                int distanceFromFirstCellTop = mListView2.getFirstVisiblePosition() * firstCell.getHeight()-firstCell.getTop();
                if(distanceFromFirstCellTop > previousDistanceFromFirstCellToTop){
                    fab.hide();
                }
                if(distanceFromFirstCellTop < previousDistanceFromFirstCellToTop){
                    fab.show();
                }
                previousDistanceFromFirstCellToTop = distanceFromFirstCellTop;

            }
        });
        loadData();
        return v;
    }

    private void viewList(Context ctx, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        final View promptView = layoutInflater.inflate(R.layout.activity_preview_so, null);

        final TextView _tvNoSO = (TextView) promptView.findViewById(R.id.tvnoSOtbl);
        final TextView _tvKet = (TextView) promptView.findViewById(R.id.tvkettbl);
        _tvNoSO.setText(dt.get(position).get_txtNoSo());
        _tvKet.setText(dt.get(position).get_txtKeterangan());
        final TextView tv_item = (TextView) promptView.findViewById(R.id.tvItemtbl);
        tv_item.setTypeface(null, Typeface.BOLD);
        tv_item.setText(String.valueOf(dt.get(position).get_intSumItem()));
        final  TextView tv_amount = (TextView) promptView.findViewById(R.id.tvSumAmount) ;
        tv_amount.setTypeface(null, Typeface.BOLD);
        tv_amount.setText(new clsMainActivity().convertNumberDec(Double.valueOf(dt.get(position).get_intSumAmount())));
        final  TextView tv_status = (TextView) promptView.findViewById(R.id.tvStatus);
        tv_status.setTypeface(null, Typeface.BOLD);

        if (dt.get(position).get_intSubmit().equals("1")&&dt.get(position).get_intSync().equals("0")){
            tv_status.setText("Submit");
        } else if (dt.get(position).get_intSubmit().equals("1")&&dt.get(position).get_intSync().equals("1")){
            tv_status.setText("Sync");
        }

        TableLayout tlb = (TableLayout) promptView.findViewById(R.id.tlProduct);
        tlb.removeAllViews();

        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(1, 1, 1, 1);

        TableRow tr = new TableRow(getContext());

        TableLayout tl = new TableLayout(getContext());

        String[] colTextHeader = {"Nama", "Qty", "Price", "Amount"};

        for (String text : colTextHeader) {
            TextView tv = new TextView(getContext());
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1));

            tv.setTextSize(14);
            tv.setPadding(10, 10, 10, 10);
            tv.setText(text);
            tv.setGravity(Gravity.CENTER);
            tv.setBackgroundColor(Color.parseColor("#4CAF50"));
            tv.setTextColor(Color.WHITE);
            tr.addView(tv,params);
        }
        tl.addView(tr);

        data = new tSalesProductDetailBL().GetDataByNoSO(dt.get(position).get_txtNoSo());

        double qtySum=0;
        double qtyNum;
        for(tSalesProductDetailData dat : data){
            tr = new TableRow(getContext());
            TableLayout.LayoutParams tableRowParams=
                    new TableLayout.LayoutParams
                            (TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);

            int leftMargin=0;
            int topMargin=0;
            int rightMargin=0;
            int bottomMargin=0;
            tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

            tr.setLayoutParams(tableRowParams);

            TextView product = new TextView(getContext());
            product.setTextSize(12);
            product.setWidth(200);
            product.setPadding(10, 10, 10, 10);
            product.setBackgroundColor(Color.parseColor("#f0f0f0"));
            product.setTextColor(Color.BLACK);
            product.setText(dat.get_txtNameProduct());
            tr.addView(product,params);

            TextView qty = new TextView(getContext());
            qty.setTextSize(12);
            qty.setPadding(10, 10, 10, 10);
            qty.setBackgroundColor(Color.parseColor("#f0f0f0"));
            qty.setTextColor(Color.BLACK);
            qty.setGravity(Gravity.RIGHT);
            qty.setText(dat.get_intQty());
            tr.addView(qty,params);

            TextView price = new TextView(getContext());
            price.setTextSize(12);
            price.setPadding(10, 10, 10, 10);
            price.setBackgroundColor(Color.parseColor("#f0f0f0"));
            price.setTextColor(Color.BLACK);
            price.setGravity(Gravity.RIGHT);
            price.setText(new clsMainActivity().convertNumberDec(Double.valueOf(dat.get_intPrice())));
            tr.addView(price,params);

            TextView amount = new TextView(getContext());
            amount.setTextSize(12);
            amount.setWidth(200);
            amount.setPadding(10, 10, 10, 10);
            amount.setBackgroundColor(Color.parseColor("#f0f0f0"));
            amount.setTextColor(Color.BLACK);
            amount.setGravity(Gravity.RIGHT);
            double prc = Double.valueOf(dat.get_intPrice());
            double itm = Double.valueOf(dat.get_intQty());
            qtyNum = prc * itm;
            qtySum += qtyNum;
            amount.setText(new clsMainActivity().convertNumberDec(qtyNum));
            tr.addView(amount,params);

            tl.addView(tr, tableRowParams);
        }

        tlb.addView(tl);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.getContext());
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder
                .setCancelable(false)
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alertD = alertDialogBuilder.create();
        alertD.show();
    }

    private void loadData(){

//        tUserLoginData dtLogin = new tUserLoginBL().getUserActive();
        visitplanAbsenData _viAbsenData = new visitplanAbsenData();
        _viAbsenData = new clsHelperBL().getDataCheckInActive();

        clsSwipeList swplist;
        dt = new tSalesProductHeaderBL().getAllSalesProductHeaderByOutletCode(_viAbsenData.get_txtOutletCode());

        swipeList.clear();

        if(dt!=null) {
            for (int i = 0; i < dt.size(); i++) {
                swplist = new clsSwipeList();
                swplist.set_txtTitle("No : " + dt.get(i).get_txtNoSo());
                String desc = dt.get(i).get_txtKeterangan();
                if(desc.length()>20){
                    desc = dt.get(i).get_txtKeterangan().substring(0,20) + "...";
                }
                swplist.set_txtDescription("Description : " + desc);
                if (dt.get(i).get_intSubmit().equals("1")&&dt.get(i).get_intSync().equals("0")){
                    swplist.set_txtDescription2("Submit");
                } else if (dt.get(i).get_intSubmit().equals("1")&&dt.get(i).get_intSync().equals("1")){
                    swplist.set_txtDescription2("Sync");
                }

                swipeList.add(swplist);
            }
        }

        clsMainActivity clsMain = new clsMainActivity();

        mListView2 = (PullToRefreshSwipeMenuListView) v.findViewById(R.id.SwipelistView);
        mAdapter = clsMain.setListViewCusBase(getActivity().getApplicationContext(), swipeList);
        mListView2.setAdapter(mAdapter);
        mListView2.setPullRefreshEnable(true);
        mListView2.setPullLoadEnable(true);
        mListView2.setEmptyView( v.findViewById(R.id.LayoutEmpty));
        mListView2.setXListViewListener(this);
        mHandler = new Handler();
        HashMap<String, String> mapView = new HashMap<String, String>();

        mapView.put("name", "View");
        mapView.put("bgColor", "#3498db");

        mapMenu = new HashMap<String, HashMap>();
        mapMenu.put("0", mapView);

        SwipeMenuCreator creator = clsMain.setCreator(getActivity().getApplicationContext(), mapMenu);
        mListView2.setMenuCreator(creator);
        mListView2.setEmptyView(v.findViewById(R.id.LayoutEmpty));
        mListView2.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, edu.swu.pulltorefreshswipemenulistview.library.swipemenu.bean.SwipeMenu menu, int index) {
                clsSwipeList item = swipeList.get(position);
                switch (index) {
                    case 0:
                        viewList(getContext(), position);
                        break;
                }
            }
        });

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        RefreshTime.setRefreshTime(getContext(), " " + df.format(new Date()));
        mListView2.setRefreshTime(RefreshTime.getRefreshTime(getActivity().getApplicationContext()));
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
                mListView2.stopRefresh();
                mListView2.stopLoadMore();
            }
        }, 500);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, 1);
    }
}
