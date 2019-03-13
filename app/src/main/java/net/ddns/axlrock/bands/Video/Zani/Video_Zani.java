package net.ddns.axlrock.bands.Video.Zani;

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

public class Video_Zani extends AppCompatActivity {

    //宣告網址位置
    String youtubeURL1 = "https://www.youtube.com/channel/UCfCHDhaqPz8C1SXUQ_gVIBA/videos";
    String youtubeURL2 = "https://youtu.be/GedcwChv85k";
    String youtubeURL3 = "https://youtu.be/8gllITU8wkc";
    String youtubeURL4 = "https://youtu.be/kiSwS-4nFd0";
    String youtubeURL5 = "https://youtu.be/psARqEuhbuw";
    String youtubeURL6 = "https://youtu.be/t52y9SZephw";
    String youtubeURL7 = "https://youtu.be/zlolnpK_U1o";
    String youtubeURL8 = "https://youtu.be/k0TswIEf1FA";
    //宣告圖片陣列(影片圖示)
    int[] image1 = new int[]{R.drawable.zani3,R.drawable.zani4,R.drawable.zani5, R.drawable.zani6,
            R.drawable.zani7,R.drawable.zani8,R.drawable.zani9,R.drawable.zani10,};
    //宣告文字陣列(每個元件)
    //影片主題
    String[] text1 = new String[]{"官方網站","半心(MV)","半心(Stage)","可是(MV)","心碎東尼(Drum Play)",
    "甜約翰專場(開場)","半心EP見面(The Wall)","2018添翼校園巡演開場"};
    //影片長度標題
    String text2 = "長度";
    //影片發佈日期標題
    String text3 = "發佈日期";
    //影片長度
    String[] text4 = new String[]{"99:99","03:52","05:21","03:22","04:32","04:26","02:05","01:21"};
    //影片發佈日期
    String[] text5 = new String[]{"2017年8月28日","2017年11月22日","2018年7月10日","2018年5月10日","2018年2月15日",
    "2018年4月1日","2018年1月3日","2018年3月16日"};

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
                }
            }
        });
    }

    //自訂MyAdapter類別繼承BaseAdapter
    class MyAdapter extends BaseAdapter {
        LayoutInflater myInflater;

        public MyAdapter(Video_Zani m) {
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
