package net.ddns.axlrock.bands.Video.Vast_Hazy;

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

public class Video_Vast_Hazy extends AppCompatActivity {

    //宣告網址位置
    String youtubeURL1 = "https://youtu.be/AB4lz1c9S9o";
    String youtubeURL2 = "https://youtu.be/gwbB6TDwWGc";
    String youtubeURL3 = "https://youtu.be/10DHUqSVu6I";
    String youtubeURL4 = "https://youtu.be/0vv149qqciw";
    String youtubeURL5 = "https://youtu.be/_mcdnRHrXCQ";
    String youtubeURL6 = "https://youtu.be/5jFW6PsuJIo";
    String youtubeURL7 = "https://youtu.be/dKatg043PDU";
    String youtubeURL8 = "https://youtu.be/B8vdGsASiI0";
    String youtubeURL9 = "https://youtu.be/v-7ygGWkU8A";
    String youtubeURL10 = "https://youtu.be/SNb8Ee34gb8";
    String youtubeURL11 = "https://youtu.be/IOUOrsexQFM";
    String youtubeURL12 = "https://youtu.be/S6kQPEMhEfM";
    String youtubeURL13 = "https://youtu.be/nwMZSORP3pM";
    String youtubeURL14 = "https://youtu.be/pBQK-Lwt1sA";

    //宣告圖片陣列(影片圖示)
    int[] image1 = new int[]{R.drawable.vast_hazy3,R.drawable.vast_hazy4,R.drawable.vast_hazy5, R.drawable.vast_hazy6,
            R.drawable.vast_hazy7,R.drawable.vast_hazy8,R.drawable.vast_hazy9,R.drawable.vast_hazy10,
            R.drawable.vast_hazy11,R.drawable.vast_hazy12,R.drawable.vast_hazy13,R.drawable.vast_hazy14,
            R.drawable.vast_hazy15,R.drawable.vast_hazy16,};
    //宣告文字陣列(每個元件)
    //影片主題
    String[] text1 = new String[]{"全專輯試聽版(求救訊號)","華山Legacy - 與浪之間","與浪之間(MV)",
    "求救訊號(MV)","食人夢(MV)","歸屬(MV)","故障(MV)","下次見(MV)","yet(MV)","次等秘密最終場",
    "與浪之間(stage)","樂人Session","我想成為你(MV)","拾起(MV)"};
    //影片長度標題
    String text2 = "長度";
    //影片發佈日期標題
    String text3 = "發佈日期";
    //影片長度
    String[] text4 = new String[]{"05:10","05:21","05:23","05:05","04:36","05:10","03:22","04:53",
    "05:28","03:52","04:33","04:25","04:17","04:19",};
    //影片發佈日期
    String[] text5 = new String[]{"2018年6月6日","2017年3月10日","2017年11月17日","2018年6月20日",
            "2016年12月11日","2017年8月23日","2018年5月31日","2018年11月18日","2018年5月10日",
    "2017年7月13日","2016年12月28日","2012年6月29日","2018年11月29日","2019年1月25日"};

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
                    case 12 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL13)));
                        break;
                    case 13 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL14)));
                        break;
                }
            }
        });
    }

    //自訂MyAdapter類別繼承BaseAdapter
    class MyAdapter extends BaseAdapter {
        LayoutInflater myInflater;

        public MyAdapter(Video_Vast_Hazy m) {
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
