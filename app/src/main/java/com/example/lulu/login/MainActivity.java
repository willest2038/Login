package com.example.lulu.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "netUtils";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpURLConnection conn = null;
        Log.i(TAG, "開始访问" + "onCreate");

        RequestQueue mQueue = Volley.newRequestQueue(this);
        StringRequest getRequest = new StringRequest("http://192.168.23.123:8081/WebForAndroid/LoginServlet?name=sa&password=sa123456",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("TAG", "onResponse : "+s.toString());
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("TAG", "onErrorResponse : "+ volleyError.toString());
                    }
                });
        mQueue.add(getRequest);
//        try {
//            URL mURL = new URL("http://192.168.23.123:8081/WebForAndroid/LoginServlet?name=sa&password=sa123456");
//            conn = (HttpURLConnection) mURL.openConnection();
//            Log.i(TAG, "開始访问" + "openConnection");
//            int responseCode = conn.getResponseCode();// 调用此方法就不必再使用conn.connect()方法
//            if (responseCode == 200) {
//
//            //    InputStream is = conn.getInputStream();
//             //   String state = getStringFromInputStream(is);
//                Log.i(TAG, "访问成功" + responseCode);
//            } else {
//                Log.i(TAG, "访问失败" + responseCode);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                conn.disconnect();// 关闭连接
//                Log.i(TAG, "關閉連線");
//            }
//        }

        // JNetUtils.loginOfPost("sa","sa123456");
        //Log.v("FirstLogin","Test01");
    }
}
