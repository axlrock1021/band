package net.ddns.axlrock.bands.Video.Astro_Bunny;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import net.ddns.axlrock.bands.R;

public class Video_Astro_Bunny extends AppCompatActivity {

    //宣告網址位置
    String youtubeURL1 = "https://www.youtube.com/channel/UCiuMb0mv6XtwQjQQ95LnJHw/videos";
    String youtubeURL2 = "https://youtu.be/KGI7we8KXW4";
    String youtubeURL3 = "https://youtu.be/0aJhkT6C0FA";
    String youtubeURL4 = "https://youtu.be/n-hy9MswmcA";
    String youtubeURL5 = "https://youtu.be/smgzP8qNXTo";
    String youtubeURL6 = "https://youtu.be/o1xlxZMQX00";
    String youtubeURL7 = "https://youtu.be/5Kb98kW0bVE";
    String youtubeURL8 = "https://youtu.be/gBhAequ7yjA";
    String youtubeURL9 = "https://youtu.be/_qoBG-3JwfQ";
    String youtubeURL10 = "https://youtu.be/iTIKzLyQDS0";
    String youtubeURL11 = "https://youtu.be/c4Qi78Bhvck";
    String youtubeURL12 = "https://youtu.be/P00D-zUm3bg";

    //宣告圖片陣列(影片圖示)
    int[] image1 = new int[]{R.drawable.astro_bunny3,R.drawable.astro_bunny4,R.drawable.astro_bunny5,
            R.drawable.astro_bunny6,R.drawable.astro_bunny7,R.drawable.astro_bunny8,R.drawable.astro_bunny9,
            R.drawable.astro_bunny10,R.drawable.astro_bunny11, R.drawable.astro_bunny12,
            R.drawable.astro_bunny13,R.drawable.astro_bunny14};
    //宣告文字陣列(每個元件)
    //影片主題
    String[] text1 = new String[]{"官方網站","樂人Session","咪咕音樂現場","這樣我就能忘記你了(MV)",
    "被你遺忘的森林(MV)","也許你不懂(MV)","現在你好嗎(MV)","蒸發的世界剩下我(MV)",
    "年少的憂愁(MV)(Ft.晨悠)","謝謝你曾經讓我悲傷(MV)","I miss you so bad(Ft.Yalu)","I miss you so bad(MV)"};
    //影片長度標題
    String text2 = "長度";
    //影片發佈日期標題
    String text3 = "發佈日期";
    //影片長度
    String[] text4 = new String[]{"99:99","05:26","01:03:16","04:13","04:38","04:25","03:59","03:32",
    "03:36","03:55","03:47","03:51"};
    //影片發佈日期
    String[] text5 = new String[]{"2014年8月26日","2016年1月2日","2018年12月26日","2018年9月19日",
    "2017年3月8日","2017年12月13日","2017年7月26日","2017年5月3日","2017年6月14日","2018年1月31日",
            "2017年2月16日","2018年4月18日"};

    private ListView myListView;
    MyAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_bands);

        myListView = findViewById(R.id.listView2);

        //調用myListView()
        myListView();

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //導入影片網址
    public void myListView(){

        //建立adapter
        adapter = new MyAdapter(this);
        //設定監聽
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL1)));
                        break;
                    case 1 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL2)));
                        break;
                    case 2 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL3)));
                        break;
                    case 3 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL4)));
                        break;
                    case 4 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL5)));
                        break;
                    case 5 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL6)));
                        break;
                    case 6 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL7)));
                        break;
                    case 7 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL8)));
                        break;
                    case 8 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL9)));
                        break;
                    case 9 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL10)));
                        break;
                    case 10 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL11)));
                        break;
                    case 11 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL12)));
                        break;
                }
            }
        });
    }

    //自訂MyAdapter類別繼承BaseAdapter
    class MyAdapter extends BaseAdapter {
        LayoutInflater myInflater;

        public MyAdapter(Video_Astro_Bunny m) {
            myInflater = LayoutInflater.from(m);
        }

        //覆寫getCount()，利用文字陣列取得長度
        @Override
        public int getCount() {
            return text1.length;
        }

        //覆寫getItem()，利用position取得索引值
        @Override
        public Object getItem(int position) {
            return text1[position];
        }

        //覆寫getItemId()，利用position取得索引值
        @Override
        public long getItemId(int position) {
            return position;
        }

        //覆寫getView()，取得UI相關資訊
        @SuppressLint("ResourceType")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //宣告物件，建立關聯
            convertView = myInflater.inflate(R.layout.video_bands_item, null);

            ImageView imageView = convertView.findViewById(R.id.image_list); //影片圖示
            TextView textView1 = convertView.findViewById(R.id.title_list); //影片主題
            TextView textView2 = convertView.findViewById(R.id.long_title_list); //影片長度標題
            TextView textView3 = convertView.findViewById(R.id.launch_date_title_list); //影片發佈標題
            TextView textView4 = convertView.findViewById(R.id.long_list); //影片長度
            TextView textView5 = convertView.findViewById(R.id.launch_date_list); //影片發佈日期

            //利用position取得索引值(圖片、文字)
            imageView.setImageResource(image1[position]); //影片圖示
            textView1.setText(text1[position]); //影片主題
            textView2.setText(text2); //影片長度標題
            textView3.setText(text3); //影片發佈標題
            textView4.setText(text4[position]); //影片長度
            textView5.setText(text5[position]); //影片發佈日期

            return convertView;
        }
    }
}
