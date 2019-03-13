package net.ddns.axlrock.bands.Introduction.B.Gravity;

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

public class Gravity3 extends AppCompatActivity implements OnGestureListener {

    //定義手勢檢測器
    GestureDetector detector;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gravity3);

        //初始化手勢檢測器
        detector = new GestureDetector(this, this);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立RecyclerView
        recyclerView = findViewById(R.id.recyclerview_gravitys);
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
                "1.04/18 Live at Revolver\n\n" +
                        "2.02/22 Live at 台中迴響\n\n" +
                        "etc . . . . . "));

        Year year1 = new Year("2017 - 演出資訊", contents1);
        years.add(year1);


        ArrayList<Content> contents2 = new ArrayList<>();
        contents2.add(new Content(
                "1.12/24 Live at 桃園埔心農場\n\n"+
                        "2.10/15 Live at 新竹Haven Bar\n\n"+
                        "3.09/11 Live at 公館河岸(專場)\n\n"+
                        "4.07/30 Live at 翡翠灣\n\n" +
                        "5.07/24 Live at 台中中山堂\n\n" +
                        "6.07/09 Live at 希望廣場\n\n" +
                        "7.06/11 Live at 翡翠灣\n\n" +
                        "8.03/17 Live at Revolver\n\n"+
                        "9.01/10 Live at 西門杰克(首演)\n\n" +
                        "etc . . . . . "));

        Year year2 = new Year("2016 - 演出資訊", contents2);
        years.add(year2);


        ContentAdapter adapter = new ContentAdapter(years);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.gravity3, menu);
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
            Intent intent = new Intent(this, Gravity4.class);
            startActivity(intent);
            finish();
            //設置切換方向，從右邊進入，左邊退出
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
        else if(e2.getX() - e1.getX() > 50){
            Intent intent2 = new Intent(this, Gravity2.class);
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
