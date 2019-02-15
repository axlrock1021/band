package net.ddns.axlrock.bands.Introduction.My_Skin_Against_Your_Skin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import net.ddns.axlrock.bands.R;
import java.util.ArrayList;

public class My_Skin_Sgainst_Your_Skin3 extends AppCompatActivity implements OnGestureListener {

    //定義手勢檢測器
    GestureDetector detector;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_skin_against_your_skin3);

        //初始化手勢檢測器
        detector = new GestureDetector(this, this);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立RecyclerView
        recyclerView = findViewById(R.id.recyclerview6);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //調用listText()
        listText();
    }

    //顯示清單文字內容
    public void listText(){

        //初始化Year&Content物件
        ArrayList<Year> years = new ArrayList<>();
        ArrayList<Content> contents1 = new ArrayList<>();

        contents1.add(new Content(
                "1.北京迷笛音樂節\n\n" +
                        "2.北京草莓音樂節\n\n"+
                        "3.上海草莓音樂節\n\n" +
                        "4.中國巡演(北京、上海、廣州、杭州、南京、武漢和鄭州)\n\n" +
                        "5.海南力加熱浪沙灘嘉年華\n\n" +
                        "6.青年戶外音樂會\n\n"));

        Year year1 = new Year("2013 - 演出資訊", contents1);
        years.add(year1);


        ArrayList<Content> contents2 = new ArrayList<>();
        contents2.add(new Content(
                "1.英國水晶獎提名樂團(開場嘉賓)\n\n" +
                        "2.東北亞日韓音樂節\n\n" +
                        "3.韓國仁川音樂節\n\n" +
                        "4.貢寮國際海洋音樂節\n\n" +
                        "5.美國The Pretty Reckless台北演唱會演出嘉賓\n\n" +
                        "6.香港呼叫音樂節\n\n" +
                        "7.台灣簡單生活節\n\n" +
                        "8.汽車城市音樂節(Audi Q3)\n\n" +
                        "9.香港、廣州、深圳巡演"));

        Year year2 = new Year("2012 - 演出資訊", contents2);
        years.add(year2);


        ArrayList<Content> contents3 = new ArrayList<>();
        contents3.add(new Content(
                "1.The Next Big Thing 見證大團誕生之「年度十大新團」\n\n" +
                        "2.春天吶喊 Spring Scream\n\n" +
                        "3.中國海洋迷笛音樂節\n\n" +
                        "4.The Next Big Thing:Yahoo!\n\n" +
                        "5.Japan Tour(東京、大阪、神戸)\n\n" +
                        "6.香港、澳門巡演\n\n" +
                        "7.魏如萱唱會(開場嘉賓)" ));

        Year year3 = new Year("2011 - 演出資訊", contents3);
        years.add(year3);


        ArrayList<Content> contents4 = new ArrayList<>();
        contents4.add(new Content(
                "1.大港開唱\n\n" +
                        "2.墾丁半島嘉年華\n\n" +
                        "3.春天吶喊 Spring Scream\n\n" +
                        "4.Vicious Circle Nite\n\n" +
                        "5.台北國際服裝服飾品牌展\n\n" +
                        "6.搖滾台中音樂節(主舞台;)\n\n" +
                        "7.香港Asia Live Case"));

        Year year4 = new Year("2010 - 演出資訊", contents4);
        years.add(year4);


        ContentAdapter adapter = new ContentAdapter(years);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.my_skin_against_your_skin3, menu);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //將觸控事件交给GestureDetector處理
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        //如果向右滑動的距離 > 50mm
        if (e1.getX() - e2.getX() > 50) {
            Intent intent = new Intent(this, My_Skin_Sgainst_Your_Skin1.class);
            startActivity(intent);
            finish();
            //設置切換方向，從右邊進入，左邊退出
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
        else if(e2.getX() - e1.getX() > 50){
            Intent intent2 = new Intent(this,My_Skin_Sgainst_Your_Skin2.class);
            startActivity(intent2);
            finish();
            //設置切換方向，從左邊進入，右邊退出
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
}
