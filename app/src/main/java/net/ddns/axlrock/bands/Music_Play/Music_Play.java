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
import android.widget.SeekBar;
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
    private MediaPlayer mediaPlayer;//播放音檔
    private int playPosition;//當前播放歌曲的索引值
    private boolean IsPlay = false;//是否有歌曲在播放
    private Button playPause;//暫停和播放按鈕
    private TextView song;//歌曲
    private TextView singer;//歌手
    private ImageView imageView;//控制台的圖片
    private Animation animation;//動畫
    private SeekBar seekBar;
    private boolean isSeekBarChanging;//互斥變量，防止進度條與定時器衝突。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_play);

        mediaPlayer = new MediaPlayer();

        seekBar = findViewById(R.id.sbSize);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isSeekBarChanging = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isSeekBarChanging = false;
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        initView();
    }

     //初始化view
    private void initView() {
        mListView = findViewById(R.id.main_listview);
        list = new ArrayList<>();
        //把搜尋到的音樂赋值给list
        list = MusicUtils.getMusicData(this);
        adapter = new MyAdapter(this,list);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //創建一個播放音檔的方法，把點擊到的地址傳過去
                list.get(i); //path這個就是歌曲的地址。
                play(list.get(i).path);
                //播放暫停按鈕圖片變成播放狀態
                //playPause.setBackgroundResource(R.drawable.);
                //把當前點擊的項目的位置拿到，知道當前播放歌曲的序號
                playPosition = i;
                //播放音樂的時候把是否在播放賦值為真
                IsPlay = true;
                //點擊項目讓控制台顯示出來
                findViewById(R.id.main_control_rl).setVisibility(View.VISIBLE);
            }
        });
    }


    /**
     * 播放音樂的方法
     */
    private void play(String path) {
        //播放之前要先把音檔文件重置
        try {
            mediaPlayer.reset();
            //調用方法傳進去要播放的音檔路徑
            mediaPlayer.setDataSource(path);
            //異步準備音檔資源
            mediaPlayer.prepareAsync();
            //調用mediaPlayer的監聽方法，音檔準備完畢會響應此方法
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();//開始音檔
                    seekBar.setMax(mediaPlayer.getDuration());
                    mediaPlayer.seekTo(0);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 底部控制台按鈕的點擊事件
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
                    mediaPlayer.seekTo(0);
                }
                break;
            case R.id.playing_btn_pause://暫停和播放
                if (IsPlay == false) {
                    //播放暫停按鈕圖片變成播放狀態
                    //playPause.setBackgroundResource(R.drawable.pause_press);
                    //繼續播放
                    mediaPlayer.start();
                    mediaPlayer.seekTo(0);
                    //imageView.startAnimation(animation);
                    IsPlay = true;//是否在播放赋值為true
                    //animation.start();
                    Toast.makeText(Music_Play.this, "播放" + list.get(playPosition).song, Toast.LENGTH_SHORT).show();
                } else {
                    //播放暫停按鈕圖片變成暫停狀態
                    //playPause.setBackgroundResource(R.drawable.play_press);
                    //暫停歌曲
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    //imageView.clearAnimation();//停止動畫
                    IsPlay = false; //否在播放赋值為false
                    Toast.makeText(Music_Play.this, "暫停" + list.get(playPosition).song, Toast.LENGTH_SHORT).show();
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
                mediaPlayer.seekTo(0);
                //播放暫停按鈕圖片變成播放狀態
                //playPause.setBackgroundResource(R.drawable.pause_press);
                break;
        }
    }

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
