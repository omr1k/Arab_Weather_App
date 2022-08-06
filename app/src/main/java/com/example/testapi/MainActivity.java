package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void passingMethod(String city){
    Intent intent = new Intent(this, MasterClass.class);
    intent.putExtra("city",city);
    startActivity(intent);
}


    public void jordan(View view) {
        passingMethod("amman");
    }

    public void iraq(View view) {
        passingMethod("baghdad");
    }

    public void syr(View view) {
        passingMethod("damascus");
    }

    public void lebanon(View view) {
        passingMethod("beirut");
    }

    public void pla(View view) {
        passingMethod("jerusalem");
    }

    public void yemen(View view) {
        passingMethod("sanaa");
    }

    public void ksa(View view) {
        passingMethod("riyadh");
    }

    public void UAE(View view) {
        passingMethod("dubai");
    }

    public void bahrain(View view) {
        passingMethod("manama");
    }

    public void ku(View view) {
        passingMethod("kuwait");
    }

    public void oman(View view) {
        passingMethod("muscat");
    }

    public void qatar(View view) {
        passingMethod("doha");
    }

    public void egy(View view) {
        passingMethod("cairo");
    }

    public void mor(View view) {
        passingMethod("Casablanca");
    }

    public void tni(View view) {
        passingMethod("tunis");
    }

    public void alg(View view) {
        passingMethod("algiers");
    }

    public void lib(View view) {
        passingMethod("tripoli");
    }


    public void sudan(View view) {
        passingMethod("khartoum");
    }


    public void more(View view) {
        passingMethod("nouakchott");
    }


    public void soma(View view) {
        passingMethod("mogadishu");
    }


    public void gb(View view) {
        passingMethod("djibouti");
    }


    public void com(View view) {
        passingMethod("moroni");
    }

}





















//package com.example.testapi;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.sql.Time;
//
//public class MainActivity extends AppCompatActivity {
//
//    TextView ctv,contv,ttv,htv,ltv,fltv,vtv,hutv,srtv,sstv;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        ctv = (TextView)findViewById(R.id.ctv);
//        contv = (TextView)findViewById(R.id.contv);
//        ttv = (TextView)findViewById(R.id.ttv);
//        htv = (TextView)findViewById(R.id.htv);
//        ltv = (TextView)findViewById(R.id.ltv);
//        fltv = (TextView)findViewById(R.id.fltv);
//        vtv = (TextView)findViewById(R.id.vtv);
//        hutv = (TextView)findViewById(R.id.hutv);
//        srtv = (TextView)findViewById(R.id.srtv);
//        sstv = (TextView)findViewById(R.id.sstv);
//
//        find_weather();
//    }
//
//    public void find_weather(){
//        String url = "http://api.openweathermap.org/data/2.5/weather?q=london&appid=90ebdc57172a838d0fce0abbc044df8e";
//        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try
//                {
//                    JSONObject main_object = response.getJSONObject("main");
//
//                    String city = response.getString("name");
//                    ctv.setText(city);
//
//                    JSONArray array=response.getJSONArray("weather");
//                    JSONObject weather_object=array.getJSONObject(0);
//                    String main_con = weather_object.getString("main");
//                    String main_con_desc = weather_object.getString("description");
//                    contv.setText(main_con+" ("+main_con_desc+")");
//
//
//                    String temp = String.valueOf(main_object.getDouble("temp"));
//                    double temp_right = Double.parseDouble(temp);
//                    double c = (temp_right - 273);
//                    c = Math.round(c);
//                    int final_temp = (int)c;
//                    ttv.setText(String.valueOf(final_temp) + "°C");
//
//                    String temp_h = String.valueOf(main_object.getDouble("temp_max"));
//                    double temp_h_right = Double.parseDouble(temp_h);
//                    double c_h = (temp_h_right - 273);
//                    c_h = Math.round(c_h);
//                    int final_temp_h = (int)c_h;
//                    htv.setText("H:"+String.valueOf(final_temp_h) + "°C");
//
//                    String temp_l = String.valueOf(main_object.getDouble("temp_min"));
//                    double temp_l_right = Double.parseDouble(temp_l);
//                    double c_l = (temp_l_right - 273);
//                    c_l = Math.round(c_l);
//                    int final_temp_l = (int)c_l;
//                    ltv.setText("L:"+String.valueOf(final_temp_l) + "°C");
//
//                    String temp_f = String.valueOf(main_object.getDouble("feels_like"));
//                    double temp_fd = Double.parseDouble(temp_f);
//                    double c_f = (temp_fd - 273);
//                    c_f = Math.round(c_f);
//                    int final_temp_f = (int)c_f;
//                    fltv.setText("Feels Like : "+String.valueOf(final_temp_f) + "°C");
//
//                    String v_s  =response.getString("visibility");
//                    double v_d = Double.parseDouble(v_s);
//                    double v_k = (v_d / 1000);
//                    int final_v = (int)v_k;
//                    vtv.setText("Visibility"+"\n"+String.valueOf(final_v)+" km");
//
//                    String hu_s = String.valueOf(main_object.getDouble("humidity"));
//                    double hu_d = Double.parseDouble(hu_s);
//                    int final_hu = (int)hu_d;
//                    hutv.setText("Humidity"+"\n"+final_hu + " %");
//
//                    JSONObject sys_object = response.getJSONObject("sys");
//
//                    String sunR = String.valueOf(sys_object.getDouble("sunrise"));
//                    srtv.setText("Sunrise: "+sunR);
//
//                    String sunS = String.valueOf(sys_object.getDouble("sunset"));
//                    sstv.setText("Sunset: "+sunS);
//
//                }
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        }
//        );
//        RequestQueue queue= Volley.newRequestQueue(this);
//        queue.add(jor);
//    }}





//    public void goooo(View view) {
//
//        final String[] cc = new String[1];
//        Intent nx = new Intent(this,MainActivity2.class);
//        nx.putExtra("cityy", cc);
//        startActivity(nx);
//
//        String url = "http://api.openweathermap.org/data/2.5/weather?q=riyadh&appid=90ebdc57172a838d0fce0abbc044df8e";
//        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try
//                {
//                    JSONObject main_object = response.getJSONObject("main");
//
//                      String city = response.getString("name");
//                      cc[0] = city;
////                      ctv.setText(city[0]);
//
//
//
//
//
//
//                    JSONArray array=response.getJSONArray("weather");
//                    JSONObject weather_object=array.getJSONObject(0);
//                    String main_con = weather_object.getString("main");
//                    String main_con_desc = weather_object.getString("description");
////                    contv.setText(main_con+" ("+main_con_desc+")");
//
//
//                    String temp = String.valueOf(main_object.getDouble("temp"));
//                    double temp_right = Double.parseDouble(temp);
//                    double c = (temp_right - 273);
//                    c = Math.round(c);
//                    int final_temp = (int)c;
////                    ttv.setText(String.valueOf(final_temp) + "°C");
//
//                    String temp_h = String.valueOf(main_object.getDouble("temp_max"));
//                    double temp_h_right = Double.parseDouble(temp_h);
//                    double c_h = (temp_h_right - 273);
//                    c_h = Math.round(c_h);
//                    int final_temp_h = (int)c_h;
////                    htv.setText("H:"+String.valueOf(final_temp_h) + "°C");
//
//                    String temp_l = String.valueOf(main_object.getDouble("temp_min"));
//                    double temp_l_right = Double.parseDouble(temp_l);
//                    double c_l = (temp_l_right - 273);
//                    c_l = Math.round(c_l);
//                    int final_temp_l = (int)c_l;
////                    ltv.setText("L:"+String.valueOf(final_temp_l) + "°C");
//
//                    String temp_f = String.valueOf(main_object.getDouble("feels_like"));
//                    double temp_fd = Double.parseDouble(temp_f);
//                    double c_f = (temp_fd - 273);
//                    c_f = Math.round(c_f);
//                    int final_temp_f = (int)c_f;
////                    fltv.setText("Feels Like : "+String.valueOf(final_temp_f) + "°C");
//
//                    String v_s  =response.getString("visibility");
//                    double v_d = Double.parseDouble(v_s);
//                    double v_k = (v_d / 1000);
//                    int final_v = (int)v_k;
////                    vtv.setText("Visibility"+"\n"+String.valueOf(final_v)+" km");
//
//                    String hu_s = String.valueOf(main_object.getDouble("humidity"));
//                    double hu_d = Double.parseDouble(hu_s);
//                    int final_hu = (int)hu_d;
////                    hutv.setText("Humidity"+"\n"+final_hu + " %");
//
//                    JSONObject sys_object = response.getJSONObject("sys");
//
//                    String sunR = String.valueOf(sys_object.getDouble("sunrise"));
//                    srtv.setText("Sunrise: "+sunR);
//
//                    String sunS = String.valueOf(sys_object.getDouble("sunset"));
////                    sstv.setText("Sunset: "+sunS);
//
//                }
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        }
//        );
//        RequestQueue queue= Volley.newRequestQueue(this);
//        queue.add(jor);
//
//
//
//    }
//}















//package com.example.testapi;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.os.Bundle;
//        import android.widget.TextView;
//
//        import com.android.volley.Request;
//        import com.android.volley.RequestQueue;
//        import com.android.volley.Response;
//        import com.android.volley.VolleyError;
//        import com.android.volley.toolbox.JsonObjectRequest;
//        import com.android.volley.toolbox.Volley;
//
//        import org.json.JSONArray;
//        import org.json.JSONException;
//        import org.json.JSONObject;
//
//public class MainActivity extends AppCompatActivity {
//
//    TextView t1,t2,t3,t4,t5;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        t1 = (TextView)findViewById(R.id.t1);
//        t2 = (TextView)findViewById(R.id.t2);
//        t3 = (TextView)findViewById(R.id.t3);
//        t4 = (TextView)findViewById(R.id.t4);
//        t5 = (TextView)findViewById(R.id.t5);
//
//
//        find_weather();
//    }
//
//    public void find_weather(){
//
//        String url = "http://api.openweathermap.org/data/2.5/weather?q=Amman&appid=90ebdc57172a838d0fce0abbc044df8e";
//
//        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try
//                {
//                    JSONObject main_object = response.getJSONObject("main");
//                    JSONArray array=response.getJSONArray("weather");
//                    JSONObject object=array.getJSONObject(0);
//
//
//                    String temp = String.valueOf(main_object.getDouble("temp"));
//                    double temp_right = Double.parseDouble(temp);
//                    double c = (temp_right - 273);
//                    c = Math.round(c);
//                    int final_temp = (int)c;
//                    t2.setText(String.valueOf(final_temp));
//
//                    String city = response.getString("name");
//                    t1.setText(city);
//
//                    String hum = String.valueOf(main_object.getDouble("humidity"));
//                    t3.setText(hum);
//
//                    JSONObject main_object1 = response.getJSONObject("wind");
//                    String speed = String.valueOf(main_object1.getDouble("speed"));
//                    t4.setText(speed);
//
//                    String vi  =response.getString("visibility");
//                    t5.setText(vi);
//                }
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//
//
//                }
//
//
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }
//        );
//        RequestQueue queue= Volley.newRequestQueue(this);
//        queue.add(jor);
//
//
//    }
//}