package net.ddns.axlrock.bands.Introduction.Female.Astro_Bunny;

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

public class Astro_Bunny3 extends AppCompatActivity implements OnGestureListener {

    //定義手勢檢測器
    GestureDetector detector;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astro_bunny3);

        //初始化手勢檢測器
        detector = new GestureDetector(this, this);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立RecyclerView
        recyclerView = findViewById(R.id.recyclerview_astro_bunny);
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
                "1.台北三創Clapper Studio\n\n" +
                        "2.高雄Live Warehouse\n\n" +
                        "3.台東鐵花村\n\n" +
                        "4.宜蘭賣捌所\n\n" +
                        "5.北京疆進酒\n\n" +
                        "6.上海育英堂\n\n" +
                        "7.廣州中央車站\n\n" +
                        "8.香港Mom livehouse\n\n" +
                        "9.台中Legacy\n\n" +
                        "etc . . . . . "));

        Year year1 = new Year("2017 - 2018\n謝謝你曾經讓我悲傷\n巡迴演唱會", contents1);
        years.add(year1);


        ArrayList<Content> contents2 = new ArrayList<>();
        contents2.add(new Content(
                "1.師大附中(冬樂賞演唱會)\n\n" +
                        "2.武陵高中校慶演唱會\n\n" +
                        "3.心中山生活節\n\n" +
                        "4.上海杉杉(in象音花季音樂趴)\n\n" +
                        "5.南投曁南大學校唱\n\n" +
                        "6.高雄義守大學校唱\n\n" +
                        "7.Lamigo動紫大盛音樂祭\n\n" +
                        "8.台北景文科大畢業演唱會\n\n" +
                        "9.中山醫學大學校唱\n\n" +
                        "10.文化大學校唱\n\n" +
                        "11.屈臣氏千人一起跳Zumba\n\n" +
                        "12.台中教育大學畢業演唱會\n\n" +
                        "13.覺醒音樂祭\n\n" +
                        "14.貢寮海洋音樂季\n\n" +
                        "15.第二屆CMA音樂獎頒獎典禮\n\n" +
                        "16.景美女中秋季舞會\n\n" +
                        "17.中崙高中校慶晚會\n\n" +
                        "18.公益演唱會\n\n" +
                        "etc . . . . . "));

        Year year2 = new Year("2018 - 演出資訊", contents2);
        years.add(year2);


        ArrayList<Content> contents3 = new ArrayList<>();
        contents3.add(new Content(
                "1.北投(Aloft Hotels)\n\n" +
                        "2.嘉義中正大學(草地野餐音樂會)\n\n" +
                        "3.華山1914文創園區(金旋音樂節)\n\n" +
                        "4.淡江大學(法文系歌唱大賽)\n\n" +
                        "5.嘉義大學(嘉大狂人音樂祭)\n\n" +
                        "6.中興大學湖畔音樂季\n\n" +
                        "7.台北三創生活園區(夢響音樂祭)\n\n" +
                        "8.長庚大學風車節\n\n" +
                        "9.艾斯摩爾野餐家庭日\n\n" +
                        "10.彰化師範大學(TEDx年會活動)\n\n" +
                        "11.清華大學阿特梅藝術季音樂講座\n\n" +
                        "12.東吳大學金弦獎決賽嘉賓\n\n" +
                        "13.艾斯摩爾野餐家庭日\n\n" +
                        "14.文化大學(初文不如相見)\n\n" +
                        "15.政大(Fixsure w/法蘭黛)\n\n" +
                        "16.台北大學三峽校區(夢響音樂節)\n\n" +
                        "17.輔大進修部畢業活動\n\n" +
                        "18.大直美麗華百樂音樂季\n\n" +
                        "19.嘉義覺醒音樂季(Wake up)\n\n" +
                        "20.aloft屋頂音樂節\n\n" +
                        "21.新光三越台北信義新天地\n\n" +
                        "22.宜蘭縣政府南方澳情人節\n\n" +
                        "23.獨立原創苗北戶外系列\n\n" +
                        "24.台南屋頂音樂節\n\n" +
                        "25.決定瘋狂！美光企業中秋晚會\n\n" +
                        "26.高雄應用科技大學草地音樂節\n\n" +
                        "27.新光三越桃園站前店\n\n" +
                        "28.新竹明新科技大學\n\n" +
                        "29.廣州見面會後車站Rock Coffee)\n\n" +
                        "30.廣州校園(蝦米音樂)\n\n" +
                        "31.新竹交通大學(清交草地音樂祭)\n\n" +
                        "32.北京傳媒大學(蝦米音樂)\n\n" +
                        "33.原子邦妮專場(台北三創)\n\n" +
                        "34.台南崑山科技大學\n\n" +
                        "35.大園高中和桃園高中演出\n\n" +
                        "36.屏東縣政府跨年晚會\n\n" +
                        "etc . . . . . "));

        Year year3 = new Year("2017 - 演出資訊", contents3);
        years.add(year3);


        ContentAdapter adapter = new ContentAdapter(years);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.astro_bunny3, menu);
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
            Intent intent = new Intent(this, Astro_Bunny1.class);
            startActivity(intent);
            finish();
            //設置切換方向，從右邊進入，左邊退出
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
        else if(e2.getX() - e1.getX() > 50){
            Intent intent2 = new Intent(this,Astro_Bunny2.class);
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
