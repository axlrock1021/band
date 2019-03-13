package net.ddns.axlrock.bands.Introduction.Female.Bearbabes;

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

public class Bearbabes3 extends AppCompatActivity implements OnGestureListener {

    //定義手勢檢測器
    GestureDetector detector;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bearbabes3);

        //初始化手勢檢測器
        detector = new GestureDetector(this, this);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立RecyclerView
        recyclerView = findViewById(R.id.recyclerview_bearbabes);
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
                "1.熊團補完計畫\n\n" +
                        "etc . . . . . "));

        Year year1 = new Year("2018 - 演出資訊", contents1);
        years.add(year1);


        ArrayList<Content> contents2 = new ArrayList<>();
        contents2.add(new Content(
                "1.上海Mao演出\n\n" +
                        "2.北京愚公移山演出\n\n" +
                        "etc . . . . . "));

        Year year2 = new Year("2010 - 演出資訊", contents2);
        years.add(year2);


        ArrayList<Content> contents3 = new ArrayList<>();
        contents3.add(new Content(
                "1.香港的蒲窩青少年中心\n\n" +
                        "2.草地音樂節\n\n" +
                        "3.誠品十年音樂會\n\n" +
                        "etc . . . . . "));

        Year year3 = new Year("2009 - 演出資訊", contents3);
        years.add(year3);


        ArrayList<Content> contents4 = new ArrayList<>();
        contents4.add(new Content(
                "1.西門町快閃搖滾\n\n" +
                        "2.野台開唱\n\n" +
                        "3.屋頂音樂節\n\n" +
                        "4.獵熊計畫巡迴演唱會\n\n" +
                        "5.簡單生活節\n\n" +
                        "etc . . . . . "));

        Year year4 = new Year("2008 - 演出資訊", contents4);
        years.add(year4);


        ArrayList<Content> contents5 = new ArrayList<>();
        contents5.add(new Content(
                "1.日本關東關西巡迴演出\n\n" +
                        "2.創意新世代\n\n" +
                        "3.台大青年理想節\n\n" +
                        "4.粉樂町\n\n" +
                        "5.屋頂音樂節\n\n" +
                        "6.台灣大霹靂音樂節\n\n" +
                        "7.The Wall 2007跨年演唱會\n\n" +
                        "etc . . . . . "));

        Year year5 = new Year("2007 - 演出資訊", contents5);
        years.add(year5);


        ArrayList<Content> contents6 = new ArrayList<>();
        contents6.add(new Content(
                "1.國立交通大學校慶\n\n" +
                        "2.擁抱青春熊寶貝\n\n" +
                        "3.海洋音樂祭\n\n" +
                        "4.上海1234海灘音樂節\n\n" +
                        "5.簡單生活節\n\n" +
                        "etc . . . . . "));

        Year year6 = new Year("2006 - 演出資訊", contents6);
        years.add(year6);


        ContentAdapter adapter = new ContentAdapter(years);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.bearbabes3, menu);
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
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //如果向右滑動的距離 > 50mm
        if (e1.getX() - e2.getX() > 50) {
            Intent intent = new Intent(this, Bearbabes1.class);
            startActivity(intent);
            finish();
            //設置切換方向，從右邊進入，左邊退出
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
        else if(e2.getX() - e1.getX() > 50){
            Intent intent2 = new Intent(this, Bearbabes2.class);
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
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,float distanceY) {
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
