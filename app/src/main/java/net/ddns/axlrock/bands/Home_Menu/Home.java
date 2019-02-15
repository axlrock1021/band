package net.ddns.axlrock.bands.Home_Menu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.ddns.axlrock.bands.Introduction.Introduction;
import net.ddns.axlrock.bands.Stage.stage;
import net.ddns.axlrock.bands.R;
import net.ddns.axlrock.bands.Setting;
import net.ddns.axlrock.bands.Video.Video_Band_Introduction;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    //宣告變數
    private int soundID; //SoundPool_ID
    private SoundPool soundPool;
    private Handler aHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_menu);

        //調用soundPool()
        soundPool();

        //調用itemListMethod()
        itemListMethod();

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        itemList.add(new Home_Item(1, R.drawable.bandintroduction, "樂團介紹"));
        itemList.add(new Home_Item(2, R.drawable.moive, "影片欣賞"));
        itemList.add(new Home_Item(3, R.drawable.musicplay, "音樂播放器"));
        itemList.add(new Home_Item(4, R.drawable.live, "表演舞台"));
        itemList.add(new Home_Item(5, R.drawable.setting, "專區"));

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
                            startActivity(new Intent().setClass(Home.this, Introduction.class));
                            soundPool.release();
                            break;
                        case 1: //影片欣賞
                            startActivity(new Intent().setClass(Home.this, Video_Band_Introduction.class));
                            soundPool.release();
                            break;
                        case 2: //音樂播放器
                            startActivity(new Intent().setClass(Home.this, Video_Band_Introduction.class));
                            soundPool.release();
                            break;
                        case 3: //表演舞台
                            startActivity(new Intent().setClass(Home.this, stage.class));
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

