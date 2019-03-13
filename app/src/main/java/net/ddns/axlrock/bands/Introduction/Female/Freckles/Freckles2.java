package net.ddns.axlrock.bands.Introduction.Female.Freckles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import net.ddns.axlrock.bands.R;

public class Freckles2 extends AppCompatActivity implements OnGestureListener {

    //定義手勢檢測器
    GestureDetector detector;
    //宣告物件
    Button fb3;
    Button ig3;
    Button streetvoice3;
    //初始化網址
    String youtubeURL1 = "https://www.facebook.com/frecklesarethebest/"; //fb
    String youtubeURL2 = "https://insta-stalker.com/tag/%E9%9B%80%E6%96%91%E6%A8%82%E5%9C%98/"; //ig
    String youtubeURL3 = "https://streetvoice.com/freckleben/"; //streetvoice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freckles2);

        //初始化手勢檢測器
        detector = new GestureDetector(this, this);

        //建立關聯
        fb3 = findViewById(R.id.fb3); //官方臉書
        ig3 = findViewById(R.id.ig3); //官方IG
        streetvoice3 = findViewById(R.id.streetvoice3); //官方streetvoice

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.freckles2, menu);
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
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY) {
        //如果向右滑動的距離 > 50mm
        if (e1.getX() - e2.getX() > 50) {
            Intent intent = new Intent(this, Freckles3.class);
            startActivity(intent);
            //設置切換方向，從右邊進入，左邊退出
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
            else if(e2.getX()-e1.getX()>50){
                Intent intent2=new Intent(this, Freckles1.class);
                startActivity(intent2);
            //設置切換方向，從左邊進入，右邊退出
                finish();
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

    //前往官方臉書
    public void goFacebook(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL1));
        startActivity(intent);
    }

    //前往官方IG
    public void goInstagram(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL2));
        startActivity(intent);
    }

    //前往官方streetvoice
    public void goStreetvoice(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL3));
        startActivity(intent);
    }
}
