package net.ddns.axlrock.bands.Video;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
import net.ddns.axlrock.bands.Video.Astro_Bunny.Video_Astro_Bunny;
import net.ddns.axlrock.bands.Video.Chocolate_Tiger.Video_Chocolate_Tiger;
import net.ddns.axlrock.bands.Video.Coming_Soon.Video_Coming_Soon;
import net.ddns.axlrock.bands.Video.Gravuty.Video_Gravity;
import net.ddns.axlrock.bands.Video.Mec_Band.Video_Mec_Band;
import net.ddns.axlrock.bands.Video.Morning_Call.Video_Morning_Call;
import net.ddns.axlrock.bands.Video.My_Kkin_Against_Your_Skin.Video_My_Skin_Against_Your_Skin;
import net.ddns.axlrock.bands.Video.NekoJam.Video_NekoJam;
import net.ddns.axlrock.bands.Video.Vast_Hazy.Video_Vast_Hazy;
import net.ddns.axlrock.bands.Video.Zani.Video_Zani;

public class Video_Band_Introduction extends AppCompatActivity {

    //宣告圖片陣列(團照)
    int[] image = new int[]{R.drawable.gravity2,R.drawable.astro_bunny2,R.drawable.chocolate_tiger2,
            R.drawable.mec_band2,R.drawable.morning_call2,R.drawable.my_skin_against_your_skin2,
            R.drawable.nekojam2,R.drawable.vast_hazy2,R.drawable.zani2,R.drawable.coming_soon};

    //宣告文字陣列(團名)
    String[] text = new String[]{"Gravity","Astro Bunny","Chocolate Tiger","MEC Band","Morning Call",
            "My Skin Against Your Skin","NekoJam","Vast Hazy","Zani","Coming Soon..."};

    private ListView myListView;
    MyAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_band_introduction);

        myListView = findViewById(R.id.listView);

        //建立adapter
        adapter = new MyAdapter(this);
        //設定監聽
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Gravity.class));
                    break;
                    case 1 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Astro_Bunny.class));
                        break;
                    case 2 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Chocolate_Tiger.class));
                        break;
                    case 3 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Mec_Band.class));
                        break;
                    case 4 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Morning_Call.class));
                        break;
                    case 5 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_My_Skin_Against_Your_Skin.class));
                        break;
                    case 6 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_NekoJam.class));
                        break;
                    case 7 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Vast_Hazy.class));
                        break;
                    case 8 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Zani.class));
                        break;
                    case 9 :
                        startActivity(new Intent().setClass(Video_Band_Introduction.this, Video_Coming_Soon.class));
                        break;

                }
            }
        });
        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //自訂MyAdapter類別繼承BaseAdapter
    class MyAdapter extends BaseAdapter {
        LayoutInflater myInflater;

        public MyAdapter(Video_Band_Introduction m) {
            myInflater = LayoutInflater.from(m);
        }

        //覆寫getCount()，利用文字陣列取得長度
        @Override
        public int getCount() {
            return text.length;
        }

        //覆寫getItem()，利用position取得索引值
        @Override
        public Object getItem(int position) {
            return text[position];
        }

        //覆寫getItemId()，利用position取得索引值
        @Override
        public long getItemId(int position) {
            return position;
        }

        //覆寫getView()，取得UI相關資訊
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //宣告物件，建立關聯
            convertView = myInflater.inflate(R.layout.video_band_introduction_item, null);
            ImageView imageView = convertView.findViewById(R.id.imageView1);
            TextView textView = convertView.findViewById(R.id.textView1);

            //利用position取得索引值(圖片、文字)
            imageView.setImageResource(image[position]);
            textView.setText(text[position]);
            return convertView;
        }
    }
}
