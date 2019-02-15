package net.ddns.axlrock.bands.Video.Mec_Band;

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

public class Video_Mec_Band extends AppCompatActivity {

    //宣告網址位置
    String youtubeURL1 = "https://www.youtube.com/user/MECBand/videos";
    String youtubeURL2 = "https://youtu.be/-kpH-YV41JM";
    String youtubeURL3 = "https://youtu.be/60VN7F0mo6U";
    String youtubeURL4 = "https://youtu.be/cBVnwhFTiRg";
    String youtubeURL5 = "https://youtu.be/NrsBmaMv6vs";
    String youtubeURL6 = "https://youtu.be/sLseQTkFt8M";
    String youtubeURL7 = "https://youtu.be/1zfbj1fffpg";
    String youtubeURL8 = "https://youtu.be/PQA9bCa_yK0";
    String youtubeURL9 = "https://youtu.be/Pj4do_Lr68A";
    String youtubeURL10 = "https://youtu.be/R0n0AIjbh_U";
    String youtubeURL11 = "https://youtu.be/b33b1zoiW-Y";
    String youtubeURL12 = "https://youtu.be/_nGeeOZbk5U";
    String youtubeURL13 = "https://youtu.be/DBcW-Ex--A4";
    String youtubeURL14 = "https://youtu.be/N-Xm_DTfDQA";
    String youtubeURL15 = "https://youtu.be/yQbsVULI--A";
    String youtubeURL16 = "https://youtu.be/uxwtEfY6FRM";
    String youtubeURL17 = "https://youtu.be/6T-4Ny7wxC4";

    //宣告圖片陣列(影片圖示)
    int[] image1 = new int[]{R.drawable.mec_band3,R.drawable.mec_band4,R.drawable.mec_band5,
            R.drawable.mec_band6,R.drawable.mec_band7,R.drawable.mec_band8,R.drawable.mec_band9,
            R.drawable.mec_band10,R.drawable.mec_band11, R.drawable.mec_band12,R.drawable.mec_band13,
            R.drawable.mec_band14,R.drawable.mec_band15,R.drawable.mec_band16,R.drawable.mec_band17,
            R.drawable.mec_band18,R.drawable.mec_band19};
    //宣告文字陣列(每個元件)
    //影片主題
    String[] text1 = new String[]{"官方網站","2016貢寮海洋音樂祭","台北暖場",
    "Angel's Pain(MV)","心中的圖畫(MV)","Everything(MV)","我的親愛小孩(MV)","不能再愛你(MV)",
    "Love Rainy Days(MV)","Goodbye(MV)","天降辣妹(MV)","沒空(MV)","我的驕傲(MV)","Never the Point(MV)",
    "Feel The Heat(MV)","It's Up To You(MV)","往哪走(MV)"};
    //影片長度標題
    String text2 = "長度";
    //影片發佈日期標題
    String text3 = "發佈日期";
    //影片長度
    String[] text4 = new String[]{"99:99","57:38","22:09","05:05","04:15","04:15","04:13","04:17",
    "04:47","04:21","03:44","03:27","04:01","03:48","03:34","04:07","03:18"};
    //影片發佈日期
    String[] text5 = new String[]{"2011年11月29日","2016年7月25日","2016年12月31日","2016年12月8日",
    "2015年9月14日","2015年5月8日","2015年7月29日","2017年1月5日","2016年3月24日","2015年6月9日",
    "2015年6月12日","2015年12月2日","2017年12月9日","2018年10月26日","2017年3月4日","2016年9月9日",
    "2018年3月7日"};


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
                    case 14 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL15)));
                        break;
                    case 15 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL16)));
                        break;
                    case 16 :
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL17)));
                        break;

                }
            }
        });
    }

    //自訂MyAdapter類別繼承BaseAdapter
    class MyAdapter extends BaseAdapter {
        LayoutInflater myInflater;

        public MyAdapter(Video_Mec_Band m) {
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
