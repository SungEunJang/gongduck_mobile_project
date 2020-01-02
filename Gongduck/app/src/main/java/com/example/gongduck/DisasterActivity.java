package com.example.gongduck;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DisasterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster);

        /*ListView list = (ListView) findViewById(R.id.LH);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);*/

        ListView listview;
        ListViewAdapter adapter;

        //Adapter 생성
        adapter = new ListViewAdapter();

        //리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.LH);
        listview.setAdapter(adapter);

        //첫 번째 아이템 추가.
        adapter.addItem("2019.08.13 08:53","[행정안전부] 오늘 10시 서울지역 폭염경보. 물 충분히 마시기, 무더위쉼터 이용, 실외 작업장 폭염 안전수칙(물, 그늘, 휴식) 지키기 등 안전에 유의바랍니다. ");
        //두 번째 아이템 추가.
        adapter.addItem("2018.10.07 18:27", "[마포구청] 금일덕양구화전동784-1송유관공사화재발생으로유해가스가발생되고있으니인근주민꼐서는창문을닫고외출자제바랍니다.");
        adapter.addItem("2018.11.24 13:18", "[마포구청] 금일 서대문 충정로 3가 KT건물 화재발생, 마포구 일대 통신장애 복구중이오니 양해바랍니다. ");
        adapter.addItem("2018.11.24 16:55","[서울특별시청] 금일 서대문 KT통신구 화재관련,휴대전화복구는 금일 중 70퍼센트/유선전화,인터넷,카드결제 복구는1~2일소요예정 ");
        //세 번째 아이템 추가.
        adapter.addItem("2018.11.24 14:29","[소방재난본부청] 서대문통신구화재로 KT휴대폰,전화,인터넷등 통신장애(중구,서대문구,마포구일대)가복구1~2일,복구일주일예정");

    }
}
