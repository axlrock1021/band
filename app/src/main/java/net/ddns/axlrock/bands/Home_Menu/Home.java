package net.ddns.axlrock.bands.Home_Menu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import net.ddns.axlrock.bands.Introduction.B.Gravity.MainActivity;
import net.ddns.axlrock.bands.Music_Play.Music_Play;
import net.ddns.axlrock.bands.R;
import net.ddns.axlrock.bands.Setting;
import net.ddns.axlrock.bands.Stage.Stage;
import net.ddns.axlrock.bands.Video.Video_Band_Introduction;
import java.util.ArrayList;
import java.util.List;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class Home extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    //宣告變數
    private int soundID; //SoundPool_ID
    private SoundPool soundPool;
    private Handler aHandler;
    private InterstitialAd interstitial; //插頁式廣告

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_menu);

        //危險權限
        //需先檢查是否已經取得使用者的授權
        int permission = ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);

        if(permission != PackageManager.PERMISSION_GRANTED){
            //未取得權限，向使用者要求允許權限
            ActivityCompat.requestPermissions(this,new String[]{READ_EXTERNAL_STORAGE},1);
        }else{
            //已有權限，可進行音樂檔案存取
        }

        //調用soundPool()
        soundPool();

        //調用itemListMethod()
        itemListMethod();

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //建立插頁式廣告
//        interstitial = new InterstitialAd(this);
//        interstitial.setAdUnitId("ca-app-pub-7259957151155157/4206985274");
//        interstitial.loadAd(new AdRequest.Builder().build());
//        requestNewInterstitial();
//
//        interstitial.setAdListener(new AdListener()
//        {
//            @Override
//            public void onAdLoaded()
//            {
//                interstitial.show();
//            }
//        });
    }

    //當您準備好顯示插頁式廣告時，調用displayInterstitial()
    private void requestNewInterstitial()
    {
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial.loadAd(adRequest);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //Android 6.0以後執行階段需取得使用者授權
        //在此將授權回應交由EasyPermissions類別處理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    //實作EasyPermissions.PermissionCallbacks兩個方法
    //允許授權
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        //已有權限，可進行音樂檔案存取
    }

    //拒絕授權
    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {

        //判斷使用者是否勾選(不要再顯示)
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)){
            //開啟應用程式設定畫面，讓使用者手動允許權限
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    //使用者手動允許授權
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE){
        }
    }


    //建立soundPool背景音效&延遲緩衝
    protected void soundPool(){ //建立soundPool
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 5);
        soundID = soundPool.load(this, R.raw.backmusic, 1);

        final Runnable runnable = new Runnable() { //延遲緩衝
            public void run() {
                try{
                    Thread.sleep(200);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                soundPool.play(soundID, 1, 1, 0, 0, 1);
            }};
        aHandler = new Handler();
        aHandler.post(runnable);
    }

    //利用集合儲存資料&建立RecyclerView
    protected void itemListMethod() {
        List<Home_Item> itemList = new ArrayList<>();
        itemList.add(new Home_Item(1, R.drawable.bandintroduction, "Band Introduction"));
        itemList.add(new Home_Item(2, R.drawable.moive, "Video Appreciation"));
        itemList.add(new Home_Item(3, R.drawable.live, "Performance Stage"));
        itemList.add(new Home_Item(4, R.drawable.musicplay, "Music Player"));
        itemList.add(new Home_Item(5, R.drawable.setting, "Other"));

        //建立RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Home.this,
                LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new itemListAdapter(this, itemList));
    }


    //建立Adapter
    private class itemListAdapter extends RecyclerView.Adapter<itemListAdapter.ViewHolder> {
        //宣告變數
        private Context context;
        private List<Home_Item> homeList;

        itemListAdapter(Context context, List<Home_Item> memberList) {
            this.context = context;
            this.homeList = memberList;
        }

        //複寫onCreateViewHolder
        @Override
        public itemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_menu_item, parent, false);
            return new ViewHolder(view);
        }

        //複寫onBindViewHolder
        @Override
        public void onBindViewHolder(final itemListAdapter.ViewHolder holder, final int position) {
            final Home_Item member = homeList.get(position);
            holder.image.setImageResource(member.getImage());
            holder.text.setText(member.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position){
                        case 0: //樂團介紹
                            startActivity(new Intent().setClass(Home.this, MainActivity.class));
                            soundPool.release();
                            break;
                        case 1: //影片欣賞
                            startActivity(new Intent().setClass(Home.this, Video_Band_Introduction.class));
                            soundPool.release();
                            break;
                        case 2: //表演舞台
                            startActivity(new Intent().setClass(Home.this, Stage.class));
                            soundPool.release();
                            break;
                        case 3: //音樂播放器
                            startActivity(new Intent().setClass(Home.this, Music_Play.class));
                            soundPool.release();
                            break;
                        case 4: //專區
                            startActivity(new Intent().setClass(Home.this, Setting.class));
                            soundPool.release();
                            break;
                    }
                }
            });
        }

        //複寫getItemCount
        @Override
        public int getItemCount() {
            return homeList.size();
        }

        //Adapter需要一個ViewHolder，需實作它的建構子，保存起來的view會放在itemView裡面
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView image;
            TextView text;
            ViewHolder(View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image);
                text = itemView.findViewById(R.id.text);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
    }
}

