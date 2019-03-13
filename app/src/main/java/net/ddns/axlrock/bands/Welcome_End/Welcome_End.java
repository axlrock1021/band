package net.ddns.axlrock.bands.Welcome_End;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import net.ddns.axlrock.bands.Home_Menu.Home;
import net.ddns.axlrock.bands.R;
import net.frakbot.jumpingbeans.JumpingBeans;

public class Welcome_End extends AppCompatActivity {

    private AdView mAdView; //廣告

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_end);

        //建立執行緒，等待1秒跳轉至主頁面
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    startActivity(new Intent().setClass(Welcome_End.this, Home.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //調用junpButton方法
        junpButton();

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立廣告連結(應用程式ID)，XML更換成(*廣告單元ID)
        MobileAds.initialize(this, "ca-app-pub-7259957151155157~8079584006");
        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    //文字跳動
    private void junpButton(){
        //增加文字跳動的點
        final Button button = findViewById(R.id.button);
        JumpingBeans jumpingBeans1 = JumpingBeans.with(button)
                .appendJumpingDots()
                .build();
        //從第一個字串到最後一個字串，形成波浪式循環跳動
        JumpingBeans jumpingBeans2 = JumpingBeans.with(button)
                .makeTextJump(0, button.getText().length())
                .setIsWave(true)
                .setLoopDuration(3000)
                .build();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //返回鍵方法

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //按下返回鍵，則執行退出確認
            ConfirmExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void ConfirmExit() { //退出確認的方法
        //建立AlertDialog
        AlertDialog.Builder ad = new AlertDialog.Builder(Welcome_End.this); //宣告物件實例化

        ad.setIcon(R.drawable.cry);  //設定標題圖片
        ad.setTitle("退 出 程 式"); //設定標題內容
        ad.setMessage("\n想清楚啊 ...... !\n\n您確定要退出此程式嗎 ?"); //設定訊息內容

        ad.setPositiveButton("否", new DialogInterface.OnClickListener() { //設定按鍵(右邊)

            public void onClick(DialogInterface dialog, int i) {
                //選"否"，不退出程式，跳轉至主頁面
                startActivity(new Intent().setClass(Welcome_End.this, Home.class));
            }
        });
        ad.setNegativeButton("是", new DialogInterface.OnClickListener() { //設定按鍵(左邊)

            public void onClick(DialogInterface dialog, int i) {
                //選"是"，退出程式
                Welcome_End.this.finish();
            }
        });
        AlertDialog dialog = ad.create();
        //按下空白地方時不消失
        dialog.setCanceledOnTouchOutside(false);
        //顯示對話框
        dialog.show();
    }

    public void home(View view) { //按下按鈕，跳轉至主頁面
        startActivity(new Intent().setClass(Welcome_End.this, Home.class));
    }
}
