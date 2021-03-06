package net.ddns.axlrock.bands.Introduction.Female.Wonfu;

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

public class Wonfu3 extends AppCompatActivity implements OnGestureListener {

    //定義手勢檢測器
    GestureDetector detector;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wonfu3);

        //初始化手勢檢測器
        detector = new GestureDetector(this, this);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立RecyclerView
        recyclerView = findViewById(R.id.recyclerview_wonfu);
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
                "1.台漢神巨蛋\n\n" +
                        "2.樂團新勢力\n\n" +
                        "3.高雄啤酒音樂節\n\n" +
                        "4.TICC\n\n" +
                        "5.不插電音樂大賽\n\n" +
                        "6.新北投車站生日慶\n\n" +
                        "7.台中市民廣場\n\n" +
                        "8.午茶音樂食光\n\n" +
                        "etc . . . . . "));

        Year year1 = new Year("2018 - 演出資訊", contents1);
        years.add(year1);


        ArrayList<Content> contents2 = new ArrayList<>();
        contents2.add(new Content(
                "1.Taipei Legacy\n\n" +
                        "2.簡單生活節\n\n" +
                        "3.臺虎啤酒村\n\n" +
                        "4.尊彩藝術中心\n\n" +
                        "5.大港開唱(人生的音樂祭)\n\n" +
                        "etc . . . . . "));

        Year year2 = new Year("2017 - 演出資訊", contents2);
        years.add(year2);


        ArrayList<Content> contents3 = new ArrayList<>();
        contents3.add(new Content(
                "1.STUDIO LIVE SESSION\n\n" +
                        "2.桃園鐵玫瑰\n\n" +
                        "3.澳亞藝術節\n\n" +
                        "4.第七屆金音創作獎\n\n" +
                        "etc . . . . . "));

        Year year3 = new Year("2016 - 演出資訊", contents3);
        years.add(year3);


        ContentAdapter adapter = new ContentAdapter(years);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.wonfu3, menu);
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
            Intent intent = new Intent(this, Wonfu1.class);
            startActivity(intent);
            finish();
            //設置切換方向，從右邊進入，左邊退出
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
        else if(e2.getX() - e1.getX() > 50){
            Intent intent2 = new Intent(this, Wonfu2.class);
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
