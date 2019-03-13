package net.ddns.axlrock.bands.Music_Play;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import net.ddns.axlrock.bands.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Music_Play extends AppCompatActivity {

    //宣告物件
    private ListView mListView;
    private List<Song> list;
    private MyAdapter adapter;
    private static final int REQUEST_CONTACTS = 1;
    private MediaPlayer mediaPlayer;//播放音檔
    private int playPosition;//當前播放歌曲的索引值
    private boolean IsPlay = false;//是否有歌曲在播放
    private int pausePosition; // 記錄的暫停時的播放位置
    private ImageButton playPause; //暫停和播放按鈕
    private TextView song;//歌曲
    private TextView singer;//歌手
    private TextView control_song;
    private ImageView imageView;//控制台的圖片
    private Animation animation;//動畫
    private SeekBar seekBar;
    Handler handler = new Handler(); //處理seekBar
    private  int Duration; //seekBar持續時間
    private boolean isSeekBarChanging;//互斥變量，防止進度條與定時器衝突。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_play);

        //建立關聯
        playPause = findViewById(R.id.playing_btn_pause);
        mediaPlayer = new MediaPlayer();

        song = findViewById(R.id.item_mymusic_song);
        control_song = findViewById(R.id.control_song);
        control_song.setSelected(true);
        //seekBar = findViewById(R.id.sbSize);

        //音檔持續時間
        //Duration = mediaPlayer.getDuration();
        //設置SeekBar最大值為音檔持續時間
        //seekBar.setMax(mediaPlayer.getDuration());
        initView();

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    //初始化ListView點擊的音樂
    private void initView() {
        //建立關聯
        mListView = findViewById(R.id.main_listview);
        list = new ArrayList<>();
        //把搜尋到的音樂赋值给list
        list = MusicUtils.getMusicData(this);
        adapter = new MyAdapter(this,list);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //建立一個播放音檔的方法，把點擊到的索引值傳過去
                //path這個就是歌曲的索引值
                list.get(position);
                play(list.get(position).path);
                //把當前點擊的項目的索引值拿到，知道當前播放歌曲的索引值
                playPosition = position;
                //歌曲跑馬燈
                control_song.setText(list.get(position).song);
                //播放音樂的時候把是否在播放賦值為真
                IsPlay = true;
                //設定暫停的進度爲0（即爲從頭播放）
                pausePosition = 0;
                //點擊項目讓控制台顯示出來
                findViewById(R.id.main_control_rl).setVisibility(View.VISIBLE);
            }
        });
        //設定seekBar監聽
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                //SeekBar确定位置後，跳到指定的位置
//                //mediaPlayer.seekTo(seekBar.getProgress());
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//
//            }
//        });
    }


    //播放音樂的方法
    private void play(String path) {
        try {
            //播放之前要先把音檔文件重置
            mediaPlayer.reset();
            //調用方法傳進去要播放的音檔路徑
            mediaPlayer.setDataSource(path);
            //同步準備音檔資源
            mediaPlayer.prepareAsync();
            //調用mediaPlayer的監聽方法，音檔準備完畢會響應此方法
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    //開始播放
                    mediaPlayer.start();
//                    seekBar.setMax(mediaPlayer.getDuration());
//                    mediaPlayer.seekTo(0);
                }
            });
            //設定監聽(自動播放)
            mediaPlayer.setOnCompletionListener(new InnerOnCompletionListener());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //自動播放
    private final class InnerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            //歌曲索引值>=0歌曲列表的大小-1時，讓歌曲索引值為第一首
            if (playPosition >= list.size() - 1) {
                playPosition = 0;
            } else {
                //點擊下一首讓歌曲的序號加一
                playPosition++;
            }
            //播放
            play(list.get(playPosition).path);
            //跑馬燈
            control_song.setText(list.get(playPosition).song);
        }
    }


//    private View.OnClickListener playlis = new View.OnClickListener(){
//
//        @Override
//        public void onClick(View v) {
//            //调用handler播放
//            handler.post(start);
//        }
//    };
//    Runnable start = new Runnable(){
//
//        @Override
//        public void run() {
//            mediaPlayer.start();
//            //用一個handler更新SeekBar
//            handler.post(updatesb);
//        }
//    };
//    Runnable updatesb = new Runnable(){
//
//        @Override
//        public void run() {
//            seekBar.setProgress(mediaPlayer.getCurrentPosition());
//            //每秒鐘更新一次
//            handler.postDelayed(updatesb, 1000);
//        }
//    };
//    private View.OnClickListener pauselis = new View.OnClickListener(){
//
//        @Override
//        public void onClick(View v) {
//            //暫停
//            mediaPlayer.pause();
//        }
//    };


    //底部控制台按鈕的點擊事件
    public void control(View view) throws IOException {

        switch (view.getId()) {
            case R.id.playing_btn_previous: //上一首
                //如果播放歌曲的索引值<=0的話，繼續點擊上一首就會提示"已經是第一首了"
                if (playPosition <= 0) {
                    Toast.makeText(Music_Play.this, "已經是第一首歌了", Toast.LENGTH_SHORT).show();
                } else {
                    //讓歌曲的索引值減一
                    playPosition--;
                    //播放
                    play(list.get(playPosition).path);
                    //按下上一首，播放按鈕圖片就變成暫停狀態
                    playPause.setBackgroundResource(R.drawable.play_pause);
                    //歌曲跑馬燈
                    control_song.setText(list.get(playPosition).song);
                    //mediaPlayer.seekTo(0);
                }
                break;

            case R.id.playing_btn_pause: //暫停和繼續播放
                if (mediaPlayer.isPlaying() && !IsPlay) {
                    //播放暫停按鈕圖片變成播放狀態
                    playPause.setBackgroundResource(R.drawable.play_music);
                    //暫停
                    mediaPlayer.pause();
                    //是否在播放赋值為true
                    IsPlay = true;
                    //點擊就會提示"暫停 xxx"
                    //Toast.makeText(Music_Play.this, "暫停 " + list.get(playPosition).song, Toast.LENGTH_SHORT).show();
                    //歌曲跑馬燈
                    control_song.setText(list.get(playPosition).song);
                    //mediaPlayer.seekTo(0);

                } else {
                    //播放暫停按鈕圖片變成暫停狀態
                    playPause.setBackgroundResource(R.drawable.play_pause);
                    //播放
                    mediaPlayer.start();
                    //是否在播放赋值為false
                    IsPlay = false;
                    //點擊就會提示"播放 xxx"
                    //Toast.makeText(Music_Play.this, "播放 " + list.get(playPosition).song, Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.playing_btn_next: //下一首
                //歌曲索引值>=0歌曲列表的大小-1時，讓歌曲索引值為第一首
                if (playPosition >= list.size() - 1) {
                    playPosition = 0;
                } else {
                    //點擊下一首讓歌曲的序號加一
                    playPosition++;
                }
                //播放
                play(list.get(playPosition).path);
                //按下下一首，播放按鈕圖片就變成暫停狀態
                playPause.setBackgroundResource(R.drawable.play_pause);
                //歌曲跑馬燈
                control_song.setText(list.get(playPosition).song);
                //mediaPlayer.seekTo(0);
                break;

            case R.id.playing_btn_shuffle://隨機播放

                    //歌曲跑馬燈
                    control_song.setText(list.get(playPosition).song);
                    //播放
                    play(list.get(playPosition).path);
                    //利用亂數隨機播放
                    playPosition = new Random().nextInt(list.size());
                    //Toast.makeText(Music_Play.this, "" + list.get(playPosition).song, Toast.LENGTH_SHORT).show();
                    //按下隨機播放紐，播放按鈕圖片就變成暫停狀態
                    playPause.setBackgroundResource(R.drawable.play_pause);
                    //重啟，讓跑馬燈更新同步
                    mediaPlayer.reset();
                    mediaPlayer.start();
                    //mediaPlayer.seekTo(0);

                break;
        }
    }

    //釋放mediaPlayer
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
