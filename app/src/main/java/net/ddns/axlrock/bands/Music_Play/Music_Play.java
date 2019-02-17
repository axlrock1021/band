package net.ddns.axlrock.bands.Music_Play;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.ddns.axlrock.bands.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Music_Play extends AppCompatActivity {

    private ListView mListView;
    private List<Song> list;
    private MyAdapter adapter;
    private static final int REQUEST_CONTACTS = 1;
    private MediaPlayer mediaPlayer;//播放音频的
    private int playPosition;//当前播放歌曲的序号
    private boolean IsPlay = false;//是否有歌曲在播放
    private Button playPause;//暂停和播放按钮
    private TextView song;//歌曲名
    private TextView singer;//歌手名
    private ImageView imageView;//控制台的图片
    private Animation animation;//动画


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_play);

        mediaPlayer = new MediaPlayer();

//        //首先，在程式中若想存取屬於危險權限的資源之前，需先檢查是否已經取得使用者的授權，檢查權限語法：
//        int permission = ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);
//
//        if(permission != PackageManager.PERMISSION_GRANTED){
//            //未取得權限，向使用者要求允許權限
//            ActivityCompat.requestPermissions(this,new String[]{READ_EXTERNAL_STORAGE},1);
//        }else{
//            //已有權限，可進行檔案存取
//            Toast.makeText(this, "已經拿到權限囉!", Toast.LENGTH_SHORT).show();
//        }

        initView();
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode){
//            case REQUEST_CONTACTS:
//                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    //取得權限，進行存取
//                }else{
//                    //使用者拒絕權限，顯示對話框告知
//                    new AlertDialog.Builder(this)
//                            .setMessage("允許才能顯示")
//                            .setPositiveButton("OK",null)
//                            .show();
//                }
//                return;
//        }
//    }



     //初始化view
    private void initView() {
        mListView = (ListView) findViewById(R.id.main_listview);
        list = new ArrayList<>();
        //把搜尋到的音樂赋值给list
        list = MusicUtils.getMusicData(this);
        adapter = new MyAdapter(this,list);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //创建一个播放音频的方法，把点击到的地址传过去
                //list.get(i).path这个就是歌曲的地址
                play(list.get(i).path);
                ////播放暂停按钮图片变成播放状态
                //playPause.setBackgroundResource(R.drawable.);
                //把当前点击的item的position拿到,知道当前播放歌曲的序号
                playPosition = i;
                //播放音乐的时候把是否在播放赋值为true
                IsPlay = true;
                //点击item让控制台显示出来
                findViewById(R.id.main_control_rl).setVisibility(View.VISIBLE);

            }
        });
    }


    /**
     * 播放音频的方法
     */
    private void play(String path) {
        //播放之前要先把音频文件重置
        try {
            mediaPlayer.reset();
            //调用方法传进去要播放的音频路径
            mediaPlayer.setDataSource(path);
            //异步准备音频资源
            mediaPlayer.prepareAsync();
            //调用mediaPlayer的监听方法，音频准备完毕会响应此方法
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();//开始音频
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 底部控制栏的点击事件
     *
     * @param view
     */
    public void control(View view) {
        switch (view.getId()) {
            case R.id.playing_btn_previous://上一曲
                //如果播放歌曲的序號小於或者等於0的話點擊上一曲就提示已經是第一首了
                if (playPosition <= 0) {
                    Toast.makeText(Music_Play.this, "已经是第一首歌了", Toast.LENGTH_SHORT).show();
                } else {
                    //讓歌曲的序號減一
                    playPosition--;
                    //播放
                    play(list.get(playPosition).path);
                   // playPause.setBackgroundResource(R.drawable.pause_press);
                }
                break;
            case R.id.playing_btn_pause://暫停和播放
                if (IsPlay == false) {
                    //播放暫停按鈕圖片變成播放狀態
                   // playPause.setBackgroundResource(R.drawable.pause_press);
                    //繼續播放
                    mediaPlayer.start();
                    //imageView.startAnimation(animation);
                    IsPlay = true;//是否在播放赋值為true
                   // animation.start();
                    Toast.makeText(Music_Play.this, "播放" + list.get(playPosition).song, Toast.LENGTH_SHORT).show();
                } else {
                    //播放暫停按鈕圖片變成暫停狀態
                   // playPause.setBackgroundResource(R.drawable.play_press);
                    //暫停歌曲
                    mediaPlayer.pause();
                  //  imageView.clearAnimation();//停止動畫
                    IsPlay = false;//否在播放赋值為false
                    Toast.makeText(Music_Play.this, "暂停" + list.get(playPosition).song, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.playing_btn_next://下一曲
                //歌曲序號大於或者等於歌曲列表的大小-1時，讓歌曲序號為第一首
                if (playPosition >= list.size() - 1) {
                    playPosition = 0;
                } else {
                    //點擊下一曲讓歌曲的序號加一
                    playPosition++;
                }
                //播放
                play(list.get(playPosition).path);
                //播放暫停按鈕圖片變成播放狀態
              //  playPause.setBackgroundResource(R.drawable.pause_press);
                break;
        }

    }

}
