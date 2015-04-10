package jp.ac.kcska.s3a111.gpssample;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity implements LocationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LocationManagerの取得
        LocationManager locationManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //Criteriaオブジェクトの生成
        Criteria criteria = new Criteria();
        //Accuracy(精度)を指定
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        //PowerRequirement(所要電力)を指定
        criteria.setPowerRequirement(criteria.POWER_LOW);
        //LocationProviderの取得
        String provider = locationManager.getBestProvider(criteria,true);

        //位置情報を表示
        TextView textView_provider = (TextView)findViewById(R.id.textView_provider);
        textView_provider.setText("Provider:" + provider);
        //LocationListenerの登録
        locationManager.requestLocationUpdates(provider,0,0,this);

    }


    @Override
    public void onLocationChanged(Location location) {
        //緯度の表示
        TextView textView_latitude = (TextView)findViewById(R.id.textView_latitude);
        textView_latitude.setText("Latitude:" + location.getLatitude());
        //経度の表示
        TextView textView_longitude = (TextView)findViewById(R.id.textView_longitude);
        textView_longitude.setText("Longitude:" + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
