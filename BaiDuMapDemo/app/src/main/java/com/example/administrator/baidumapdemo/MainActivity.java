package com.example.administrator.baidumapdemo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.radar.RadarNearbyResult;
import com.baidu.mapapi.radar.RadarSearchError;
import com.baidu.mapapi.radar.RadarSearchListener;
import com.baidu.mapapi.radar.RadarSearchManager;
import com.baidu.mapapi.radar.RadarUploadInfo;
import com.baidu.mapapi.radar.RadarUploadInfoCallback;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

public class MainActivity extends AppCompatActivity implements RadarSearchListener, RadarUploadInfoCallback {
    public MapView mapView;
    public BaiduMap baiduMap;
    public  LatLng pt;
    PoiSearch mPoiSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        mapView= (MapView) findViewById(R.id.bmapView);
        baiduMap=mapView.getMap();
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        baiduMap.setTrafficEnabled(true);
        baiduMap.setBaiduHeatMapEnabled(true);
        RadarSearchManager manager=RadarSearchManager.getInstance();
        manager.addNearbyInfoListener(this);
        manager.setUserID(null);
     /*    pt=new LatLng(5.2,3.8);
       RadarUploadInfo info=new RadarUploadInfo();
        info.comments="用户备注信息";
        info.pt=pt;
        manager.uploadInfoRequest(info);
        manager.startUploadAuto(this, 5000);
        RadarNearbySearchOption option=new RadarNearbySearchOption().centerPt(pt).pageNum(1).radius(2000);
        manager.nearbyInfoRequest(option);*/
        mPoiSearch =PoiSearch.newInstance();
        OnGetPoiSearchResultListener poiListener=new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult poiResult) {

            }

            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

            }
        };
        mPoiSearch.setOnGetPoiSearchResultListener(poiListener);
        mPoiSearch.searchInCity(new PoiCitySearchOption().city("武汉").keyword("美食").pageNum(10));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPoiSearch.destroy();
        mapView.onDestroy();
    }
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
       mapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
    }

    @Override
    public void onGetNearbyInfoList(RadarNearbyResult radarNearbyResult, RadarSearchError radarSearchError) {

    }

    @Override
    public void onGetUploadState(RadarSearchError radarSearchError) {
        if (radarSearchError == RadarSearchError.RADAR_NO_ERROR) {
            //上传成功

            Toast.makeText(this, "单次上传位置成功", Toast.LENGTH_LONG)
                    .show();
        } else {
            //上传失败
            Toast.makeText(this, "单次上传位置失败", Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onGetClearInfoState(RadarSearchError radarSearchError) {

    }

    @Override
    public RadarUploadInfo onUploadInfoCallback() {
        RadarUploadInfo info = new RadarUploadInfo();
        info.comments = "用户备注信息";
        info.pt = pt;
        return info;
    }
}
