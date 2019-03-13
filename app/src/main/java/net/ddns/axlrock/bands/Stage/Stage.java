package net.ddns.axlrock.bands.Stage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.ddns.axlrock.bands.Home_Menu.Home_Item;
import net.ddns.axlrock.bands.Introduction.Female.Coming_Soon.Coming_Soon;
import net.ddns.axlrock.bands.R;
import net.ddns.axlrock.bands.Stage.Apamini.Apamini1;
import net.ddns.axlrock.bands.Stage.Banchiaofefe.Banchiaofefe1;
import net.ddns.axlrock.bands.Stage.Corner_House.Corner_House1;
import net.ddns.axlrock.bands.Stage.EZ5_Live_House.EZ5_Live_House1;
import net.ddns.axlrock.bands.Stage.Jack_Studio.Jack_Studio_Live_House1;
import net.ddns.axlrock.bands.Stage.Legacy_Taichung.Legacy_Taichung1;
import net.ddns.axlrock.bands.Stage.Legacy_Taipei.Legacy_Taipei1;
import net.ddns.axlrock.bands.Stage.Music_Corner.Music_Corner1;
import net.ddns.axlrock.bands.Stage.Revolver.Revolver1;
import net.ddns.axlrock.bands.Stage.Riverside_Live_House.Riverside_Live_House1;
import net.ddns.axlrock.bands.Stage.Riverside_Music_Cafe.Riverside_Music_Cafe1;
import net.ddns.axlrock.bands.Stage.Sound_Live_House.SOUND_Live_House1;
import net.ddns.axlrock.bands.Stage.The_Wall_Live_House.The_Wall_Live_House1;
import net.ddns.axlrock.bands.Stage.The_Witch_House.The_Witch_House1;
import net.ddns.axlrock.bands.Stage.Tiehua_Music_Village.Tiehua_Music_Village1;

import java.util.ArrayList;
import java.util.List;

public class Stage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //調用itemListMethod()
        itemListMethod();
    }

    //利用集合儲存資料&建立RecyclerView
    protected void itemListMethod() {
        List<Home_Item> itemList = new ArrayList<>();
        itemList.add(new Home_Item(1, R.drawable.riverside_music_cafe1, "河岸留言(公館)"));
        itemList.add(new Home_Item(2, R.drawable.riverside_live_house1, "河岸留言(西門町)"));
        itemList.add(new Home_Item(3, R.drawable.jack_studio_live_house1, "杰克音樂展演空間"));
        itemList.add(new Home_Item(4, R.drawable.revolver1, "左輪手槍"));
        itemList.add(new Home_Item(5, R.drawable.legacy_taipei1, "傳音樂展演空間(台北)"));
        itemList.add(new Home_Item(6, R.drawable.legacy_taichung1, "傳音樂展演空間(台中)"));
        itemList.add(new Home_Item(7, R.drawable.apamini1, "小地方展演空間"));
        itemList.add(new Home_Item(8, R.drawable.the_wall_live_house1, "這牆展演空間"));
        itemList.add(new Home_Item(9, R.drawable.corner_house1, "角落文創"));
        itemList.add(new Home_Item(10, R.drawable.music_corner1, "角落音樂餐廳"));
        itemList.add(new Home_Item(11, R.drawable.sound_live_house1, "台中迴響"));
        itemList.add(new Home_Item(12, R.drawable.tiehua_music_village1, "鐵花村音樂聚落"));
        itemList.add(new Home_Item(13, R.drawable.banchiaofefe1, "板橋飛"));
        itemList.add(new Home_Item(14, R.drawable.ez5_live_house1, "EZ5展演空間"));
        itemList.add(new Home_Item(15, R.drawable.the_witch_house1, "女巫店"));
        itemList.add(new Home_Item(16, R.drawable.coming_soon1, "敬請期待"));

        //建立RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        //建立瀑布流式的ListView
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(
                3, StaggeredGridLayoutManager.HORIZONTAL));//水平
        recyclerView.setAdapter(new itemListAdapter(this, itemList));
    }

    //建立Adapter
    private class itemListAdapter extends RecyclerView.Adapter<Stage.itemListAdapter.ViewHolder> {
        //宣告變數
        private Context context;
        private List<Home_Item> homeList;

        itemListAdapter(Context context, List<Home_Item> memberList) {
            this.context = context;
            this.homeList = memberList;
        }

        //複寫onCreateViewHolder
        @Override
        public Stage.itemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.stage_item, parent, false);
            return new Stage.itemListAdapter.ViewHolder(view);
        }

        //複寫onBindViewHolder
        @Override
        public void onBindViewHolder(final Stage.itemListAdapter.ViewHolder holder, final int position) {
            final Home_Item member = homeList.get(position);
            holder.image3.setImageResource(member.getImage());
            holder.text3.setText(member.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position){
                        case 0:
                            startActivity(new Intent().setClass(Stage.this, Riverside_Music_Cafe1.class));
                            break;
                        case 1:
                            startActivity(new Intent().setClass(Stage.this, Riverside_Live_House1.class));
                            break;
                        case 2:
                            startActivity(new Intent().setClass(Stage.this, Jack_Studio_Live_House1.class));
                            break;
                        case 3:
                            startActivity(new Intent().setClass(Stage.this, Revolver1.class));
                            break;
                        case 4:
                            startActivity(new Intent().setClass(Stage.this, Legacy_Taipei1.class));
                            break;
                        case 5:
                            startActivity(new Intent().setClass(Stage.this, Legacy_Taichung1.class));
                            break;
                        case 6:
                            startActivity(new Intent().setClass(Stage.this, Apamini1.class));
                            break;
                        case 7:
                            startActivity(new Intent().setClass(Stage.this, The_Wall_Live_House1.class));
                            break;
                        case 8:
                            startActivity(new Intent().setClass(Stage.this, Corner_House1.class));
                            break;
                        case 9:
                            startActivity(new Intent().setClass(Stage.this, Music_Corner1.class));
                            break;
                        case 10:
                            startActivity(new Intent().setClass(Stage.this, SOUND_Live_House1.class));
                            break;
                        case 11:
                            startActivity(new Intent().setClass(Stage.this, Tiehua_Music_Village1.class));
                            break;
                        case 12:
                            startActivity(new Intent().setClass(Stage.this, Banchiaofefe1.class));
                            break;
                        case 13:
                            startActivity(new Intent().setClass(Stage.this, EZ5_Live_House1.class));
                            break;
                        case 14:
                            startActivity(new Intent().setClass(Stage.this, The_Witch_House1.class));
                            break;
                        case 15:
                            startActivity(new Intent().setClass(Stage.this, Coming_Soon.class));
                            break;
                    }
                }
            });
        }

        //複寫getItemCount
        @Override
        public int getItemCount() {
            return homeList.size();
        }

        //Adapter需要一個ViewHolder，需實作它的建構子，保存起來的view會放在itemView裡面
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView image3;
            TextView text3;
            ViewHolder(View itemView) {
                super(itemView);
                image3 = itemView.findViewById(R.id.image3);
                text3 = itemView.findViewById(R.id.text3);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
