package com.example.sebas.sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_sensors=(TextView) findViewById(R.id.textView2);
        tv_sensors.setVisibility(View.GONE);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors_list= mSensorManager.getSensorList(Sensor.TYPE_ALL);


        for (int i = 1; i < sensors_list.size(); i++) {
            tv_sensors.setVisibility(View.VISIBLE);
            tv_sensors.append("\n" + sensors_list.get(i).getName() + "\n" + sensors_list.get(i).getVendor() + "\n" + sensors_list.get(i).getVersion());
        }
    }
}