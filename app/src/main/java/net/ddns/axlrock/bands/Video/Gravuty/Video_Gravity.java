package net.ddns.axlrock.bands.Video.Gravuty;

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

public class Video_Gravity extends AppCompatActivity {

    //宣告網址位置
    String youtubeURL1 = "https://youtu.be/sRtGJxNc_ec";
    String youtubeURL2 = "https://youtu.be/AUz72w9lD6c";
    String youtubeURL3 = "https://youtu.be/TsG3DZIMl5I";
    String youtubeURL4 = "https://youtu.be/1rZYPvDv6R0";
    String youtubeURL5 = "https://youtu.be/7nPdza4bRlQ";
    String youtubeURL6 = "https://youtu.be/G0kyKgWwNzU";
    String youtubeURL7 = "https://youtu.be/822jEK1EmmY";
    String youtubeURL8 = "https://youtu.be/g4z6GLgXaRU";
    String youtubeURL9 = "https://youtu.be/NH1hOX5yFPs";
    String youtubeURL10 = "https://youtu.be/_gbfQMnQ1S4";
    //宣告圖片陣列(影片圖示)
    int[] image1 = new int[]{R.drawable.gravity3,R.drawable.gravity4,R.drawable.gravity5,
            R.drawable.gravity6,R.drawable.gravity7,R.drawable.gravity8,R.drawable.gravity9,R.drawable.gravity10,
            R.drawable.gravity11, R.drawable.gravity12};
    //宣告文字陣列(每個元件)
    //影片主題
    String[] text1 = new String[]{"公館小河岸專場(全創作)","stage at Revolver","牽心萬苦(Cover)",
            "西門杰克(女主唱大笑?)","Bring Me To Life(Cover)", "萬里翡翠灣夏日樂園","喜劇之王(Cover)",
            "stage at 希望廣場","stage at 台中迴響"};
    //影片長度標題
    String text2 = "長度";
    //影片發佈日期標題
    String text3 = "發佈日期";
    //影片長度
    String[] text4 = new String[]{"33:57","25:02","04:39","01:04","05:03","15:01","04:22","26:41","27:29","17:47"};
    //影片發佈日期
    String[] text5 = new String[]{"2016年10月13日","2017年5月1日","2018年7月14日","2016年1月12日","2016年9月25日",
            "2016年8月8日","2016年3月21日","2016年7月11日","2017年2月28日","2016年3月21日"};


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
                }
            }
        });
    }

    //自訂MyAdapter類別繼承BaseAdapter
    class MyAdapter extends BaseAdapter {
        LayoutInflater myInflater;

        public MyAdapter(Video_Gravity m) {
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
