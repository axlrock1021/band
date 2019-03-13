package net.ddns.axlrock.bands.Video.Chocolate_Tiger;

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

public class Video_Chocolate_Tiger extends AppCompatActivity {

    //宣告網址位置
    String youtubeURL1 = "https://youtu.be/YITPWiq0EF0";
    String youtubeURL2 = "https://youtu.be/S0wuSbUl2gM";
    String youtubeURL3 = "https://youtu.be/FXBDEOGgy1Q";
    String youtubeURL4 = "https://youtu.be/I1lXCDw7dKE";
    String youtubeURL5 = "https://youtu.be/TFrMLoPpNBo";
    String youtubeURL6 = "https://youtu.be/3J0EXPfh8lQ";
    String youtubeURL7 = "https://youtu.be/111O4dghwko";
    //宣告圖片陣列(影片圖示)
    int[] image1 = new int[]{R.drawable.chocolate_tiger3,R.drawable.chocolate_tiger4,R.drawable.chocolate_tiger5,
            R.drawable.chocolate_tiger6,R.drawable.chocolate_tiger7,R.drawable.chocolate_tiger8,R.drawable.chocolate_tiger9,};
    //宣告文字陣列(每個元件)
    //影片主題
    String[] text1 = new String[]{"不再是少年(Stage)","不再是少年(MV)","別讓我孤單(MV)","給奇怪的你(MV)",
    "永恆的夢(MV)","理由(MV)","止水之湖(MV)"};
    //影片長度標題
    String text2 = "長度";
    //影片發佈日期標題
    String text3 = "發佈日期";
    //影片長度
    String[] text4 = new String[]{"06:08","04:55","03:16","05:43","06:49","05:02","04:16"};
    //影片發佈日期
    String[] text5 = new String[]{"2016年3月30日","2015年4月23日","2013年6月9日","2015年4月27日",
    "2015年6月24日","2014年1月10日","2015年8月3日"};

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
                }
            }
        });
    }

    //自訂MyAdapter類別繼承BaseAdapter
    class MyAdapter extends BaseAdapter {
        LayoutInflater myInflater;

        public MyAdapter(Video_Chocolate_Tiger m) {
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
