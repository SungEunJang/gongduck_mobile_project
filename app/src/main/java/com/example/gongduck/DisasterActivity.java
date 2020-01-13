package com.example.gongduck;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class DisasterActivity extends AppCompatActivity {

    private ListView listview;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster);

        //뒤로가기 이벤트
        Button back_btn=findViewById(R.id.btn_back_h);
        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Adapter 생성
        adapter = new ListViewAdapter();


        //리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.LH);
        listview.setAdapter(adapter);

        StrictMode.enableDefaults();
        String resultText = "값이 없음";
        try {
            resultText = new Task().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] data = jsonParser(resultText);
    }

    public String[] jsonParser(String jsonString) {

        String create_date;
        String location_id;
        String location_name;
        String msg;

        String[] arraysum = new String[4];

        try {
            String tmpArray = new JSONObject(jsonString).getJSONArray("DisasterMsg").toString();
            String tmpObject = new JSONArray(tmpArray).getJSONObject(1).toString();
            JSONArray jsonArray = new JSONObject(tmpObject).getJSONArray("row");

            for (int i = 0; i < jsonArray.length(); i++) {
                //HashMap map = new HashMap<>();
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                location_id = jsonObject.optString("location_id");
                if (location_id.contains("136") ) {
                    location_name = jsonObject.optString("location_name");
                    create_date = jsonObject.optString("create_date");
                    msg = jsonObject.optString("msg");

                    arraysum[0] = create_date;
                    arraysum[1] = location_id;
                    arraysum[2] = "서울특별시 전체";
                    arraysum[3] = msg;
                    adapter.addItem(arraysum[0] + " " + arraysum[2], arraysum[3]);

                } else if (location_id.contains("149")) {
                    location_name = jsonObject.optString("location_name");
                    create_date = jsonObject.optString("create_date");
                    msg = jsonObject.optString("msg");

                    arraysum[0] = create_date;
                    arraysum[1] = location_id;
                    arraysum[2] = "서울특별시 마포구";
                    arraysum[3] = msg;
                    adapter.addItem(arraysum[0] + " " + arraysum[2], arraysum[3]);
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arraysum;
    }

    public class Task extends AsyncTask<String, String, String> {

        String AppKey = "ETPpSGqqkWofexpAcjdDjwncpDSDE8qunR3mFxcXP12W9u1tI2Fh96kNYzrv44wyMKR5IptxH7TvbqOfpUOxKg%3D%3D";

        BufferedReader br = null;
        private String str, receiveMsg;

        @Override
        protected String doInBackground(String... strings) {
            try {
                String urlstr = "http://apis.data.go.kr/1741000/DisasterMsg2/getDisasterMsgList"
                        + "?" + "ServiceKey=" + AppKey
                        + "&" + "pageNo=" + "1"
                        + "&" + "numOfRows=" + "999"
                        + "&" + "type=" + "json"
                        + "&" + "flag=" + "Y";

                URL url = new URL(urlstr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                if (conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((str = reader.readLine()) != null) {
                        buffer.append(str);
                    }
                    receiveMsg = buffer.toString();
                    reader.close();
                } else {
                    Log.i("통신결과", conn.getResponseCode() + "에러");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return receiveMsg;
        }
    }
}
