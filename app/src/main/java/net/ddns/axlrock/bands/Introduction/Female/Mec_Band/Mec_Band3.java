package net.ddns.axlrock.bands.Introduction.Female.Mec_Band;

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
import net.ddns.axlrock.bands.Introduction.B.Gravity.Content;
import net.ddns.axlrock.bands.Introduction.B.Gravity.ContentAdapter;
import net.ddns.axlrock.bands.Introduction.B.Gravity.Year;
import net.ddns.axlrock.bands.R;
import java.util.ArrayList;

public class Mec_Band3 extends AppCompatActivity implements OnGestureListener {

    //定義手勢檢測器
    GestureDetector detector;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mec_band3);

        //初始化手勢檢測器
        detector = new GestureDetector(this, this);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立RecyclerView
        recyclerView = findViewById(R.id.recyclerview_mec_band);
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
                "1.高雄Live Warehouse\n\n" +
                        "2.台中TADA方舟\n\n"+
                        "3.台北Legacy\n\n"+
                        "4.台東縣鐵花村\n\n" +
                        "etc . . . . . "));

        Year year1 = new Year("2017 - Rock Angel", contents1);
        years.add(year1);


        ArrayList<Content> contents2 = new ArrayList<>();
        contents2.add(new Content(
                "1.馬來西亞(Fahrenheit 88 KL Venue)\n\n" +
                        "etc . . . . . "));

        Year year2 = new Year("2016 - 首場海外演唱會", contents2);
        years.add(year2);


        ArrayList<Content> contents3 = new ArrayList<>();
        contents3.add(new Content(
                "1.台南Room335\n\n" +
                        "2.台中Legacy\n\n"+
                        "3.台北Legacy\n\n"+
                        "4.高雄Live Warehouse\n\n"+
                        "5.台東鐵花村\n\n" +
                        "etc . . . . . "));

        Year year3 = new Year("2015 - 我的親愛小孩\n巡迴演唱會", contents3);
        years.add(year3);


        ArrayList<Content> contents4 = new ArrayList<>();
        contents4.add(new Content(
                "1.台北小地方展演空間\n\n" +
                        "etc . . . . . "));

        Year year4 = new Year("2015 - 首場售票演唱會", contents4);
        years.add(year4);


        ContentAdapter adapter = new ContentAdapter(years);
        recyclerView.setAdapter(adapter);
    }

        @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.mec_band3, menu);
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
            Intent intent = new Intent(this, Mec_Band1.class);
            startActivity(intent);
            finish();
            //設置切換方向，從右邊進入，左邊退出
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
        else if(e2.getX() - e1.getX() > 50){
            Intent intent2 = new Intent(this, Mec_Band2.class);
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
