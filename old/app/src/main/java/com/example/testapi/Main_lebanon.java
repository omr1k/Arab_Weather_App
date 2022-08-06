package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

public class Main_lebanon extends AppCompatActivity {

    TextView ctv,contv,ttv,htv,ltv,fltv,vtv,hutv,srtv,sstv,datetv,ww2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lebanon);

        ctv = (TextView)findViewById(R.id.ctv);
        contv = (TextView)findViewById(R.id.contv);
        ttv = (TextView)findViewById(R.id.ttv);
        htv = (TextView)findViewById(R.id.htv);
        ltv = (TextView)findViewById(R.id.ltv);
        fltv = (TextView)findViewById(R.id.fltv);
        vtv = (TextView)findViewById(R.id.vtv);
        hutv = (TextView)findViewById(R.id.hutv);
        srtv = (TextView)findViewById(R.id.srtv);
        sstv = (TextView)findViewById(R.id.sstv);

        datetv = (TextView)findViewById(R.id.datetv);
        ww2 = (TextView)findViewById(R.id.ww);
        imageView = (ImageView)findViewById(R.id.imageView);
        find_weather();
    }

    public void back(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void find_weather(){

        String url = "http://api.openweathermap.org/data/2.5/weather?q=beirut&appid=90ebdc57172a838d0fce0abbc044df8e";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try
                {
                    JSONObject main_object = response.getJSONObject("main");

                    String city = response.getString("name");
                    ctv.setText(city);
//                    ============================================
                    String dt_s = response.getString("dt");
                    Long dt_l = Long.parseLong(dt_s);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm a ");
                    String cov1 = sdf1.format(new java.util.Date(dt_l*1000));
                    datetv.setText("Last Update "+cov1);

//                    ===================================

                    JSONArray array=response.getJSONArray("weather");
                    JSONObject weather_object=array.getJSONObject(0);
//                    String main_con = weather_object.getString("main");
                    String main_con_desc = weather_object.getString("description");
                    contv.setText(main_con_desc);

                    String temp = String.valueOf(main_object.getDouble("temp"));
                    double temp_right = Double.parseDouble(temp);
                    double c = (temp_right - 273);
                    c = Math.round(c);
                    int final_temp = (int)c;
                    ttv.setText(String.valueOf(final_temp) + "°C");

                    String temp_h = String.valueOf(main_object.getDouble("temp_max"));
                    double temp_h_right = Double.parseDouble(temp_h);
                    double c_h = (temp_h_right - 273);
                    c_h = Math.round(c_h);
                    int final_temp_h = (int)c_h;
                    htv.setText("H:"+String.valueOf(final_temp_h) + "°C");

                    String temp_l = String.valueOf(main_object.getDouble("temp_min"));
                    double temp_l_right = Double.parseDouble(temp_l);
                    double c_l = (temp_l_right - 273);
                    c_l = Math.round(c_l);
                    int final_temp_l = (int)c_l;
                    ltv.setText("L:"+String.valueOf(final_temp_l) + "°C");

                    String temp_f = String.valueOf(main_object.getDouble("feels_like"));
                    double temp_fd = Double.parseDouble(temp_f);
                    double c_f = (temp_fd - 273);
                    c_f = Math.round(c_f);
                    int final_temp_f = (int)c_f;
                    fltv.setText(String.valueOf(final_temp_f) + "°C");

                    String v_s  =response.getString("visibility");
                    double v_d = Double.parseDouble(v_s);
                    double v_k = (v_d / 1000);
                    int final_v = (int)v_k;
                    vtv.setText(String.valueOf(final_v)+" km");

                    String hu_s = String.valueOf(main_object.getDouble("humidity"));
                    double hu_d = Double.parseDouble(hu_s);
                    int final_hu = (int)hu_d;
                    hutv.setText(final_hu + " %");

//                    =======================

                    JSONObject sys_object = response.getJSONObject("sys");

                    String sunR = String.valueOf(sys_object.getString("sunrise"));
                    Long sr_l = Long.parseLong(sunR);
                    SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm a ");
                    String cov_sr = sdf2.format(new java.util.Date(sr_l*1000));
                    srtv.setText(cov_sr);

                    String sun_s = String.valueOf(sys_object.getString("sunset"));
                    Long ss_l = Long.parseLong(sun_s);
                    SimpleDateFormat sdf3 = new SimpleDateFormat("hh:mm a ");
                    String cov_ss = sdf3.format(new java.util.Date(ss_l*1000));
                    sstv.setText(cov_ss);


                    JSONObject wind_object = response.getJSONObject("wind");
                    String windSpeed_s = String.valueOf(wind_object.getDouble("speed"));
                    ww2.setText(windSpeed_s+" km");

                    String icon = weather_object.getString("icon");
                    String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
                    Picasso.get().load(iconUrl).into(imageView);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }
        );
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(jor);
    }
}