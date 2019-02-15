package net.ddns.axlrock.bands.Introduction;

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
import net.ddns.axlrock.bands.Introduction.Astro_Bunny.Astro_Bunny1;
import net.ddns.axlrock.bands.Introduction.Chocolate_Tiger.Chocolate_Tiger1;
import net.ddns.axlrock.bands.Introduction.Coming_Soon.Coming_Soon;
import net.ddns.axlrock.bands.Introduction.Gravity.Gravitys1;
import net.ddns.axlrock.bands.Introduction.Mec_Band.Mec_Band1;
import net.ddns.axlrock.bands.Introduction.Morning_Call.Morning_Call1;
import net.ddns.axlrock.bands.Introduction.My_Skin_Against_Your_Skin.My_Skin_Sgainst_Your_Skin1;
import net.ddns.axlrock.bands.Introduction.NekoJam.Nekojam1;
import net.ddns.axlrock.bands.Introduction.Vast_Hazy.Vast_Hazy1;
import net.ddns.axlrock.bands.Introduction.Zani.Zani1;
import net.ddns.axlrock.bands.R;
import java.util.ArrayList;
import java.util.List;

public class Introduction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //調用itemListMethod()
        itemListMethod();
    }

    //利用集合儲存資料&建立RecyclerView
    protected void itemListMethod() {
        List<Home_Item> itemList = new ArrayList<>();
        itemList.add(new Home_Item(1, R.drawable.gravity1, "Gravity"));
        itemList.add(new Home_Item(2, R.drawable.astro_bunny1, "Astro Bunny"));
        itemList.add(new Home_Item(3, R.drawable.chocolate_tiger1, "Chocolate Tiger"));
        itemList.add(new Home_Item(4, R.drawable.mec_band1, "MECBand"));
        itemList.add(new Home_Item(5, R.drawable.morning_call1, "Morning call"));
        itemList.add(new Home_Item(6, R.drawable.my_skin_against_your_skin1, "My Skin Against Your Skin"));
        itemList.add(new Home_Item(7, R.drawable.nekojam1, "NekoJam"));
        itemList.add(new Home_Item(8, R.drawable.vast_hazy1, "Vast & Hazy"));
        itemList.add(new Home_Item(9, R.drawable.zani1, "Zani"));
        itemList.add(new Home_Item(10, R.drawable.coming_soon, "Coming Soon"));

        //建立RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        //建立瀑布流式的ListView
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new itemListAdapter(this, itemList));
    }

    //建立Adapter
    private class itemListAdapter extends RecyclerView.Adapter<Introduction.itemListAdapter.ViewHolder> {
        //宣告變數
        private Context context;
        private List<Home_Item> homeList;

        itemListAdapter(Context context, List<Home_Item> memberList) {
            this.context = context;
            this.homeList = memberList;
        }

        //複寫onCreateViewHolder
        @Override
        public Introduction.itemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.introduction_item, parent, false);
            return new Introduction.itemListAdapter.ViewHolder(view);
        }

        //複寫onBindViewHolder
        @Override
        public void onBindViewHolder(final Introduction.itemListAdapter.ViewHolder holder, final int position) {
            final Home_Item member = homeList.get(position);
            holder.image2.setImageResource(member.getImage());
            holder.text2.setText(member.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position){
                        case 0:
                            startActivity(new Intent().setClass(Introduction.this, Gravitys1.class));
                            break;
                        case 1:
                            startActivity(new Intent().setClass(Introduction.this, Astro_Bunny1.class));
                            break;
                        case 2:
                            startActivity(new Intent().setClass(Introduction.this, Chocolate_Tiger1.class));
                            break;
                        case 3:
                            startActivity(new Intent().setClass(Introduction.this, Mec_Band1.class));
                            break;
                        case 4:
                            startActivity(new Intent().setClass(Introduction.this, Morning_Call1.class));
                            break;
                        case 5:
                            startActivity(new Intent().setClass(Introduction.this, My_Skin_Sgainst_Your_Skin1.class));
                            break;
                        case 6:
                            startActivity(new Intent().setClass(Introduction.this, Nekojam1.class));
                            break;
                        case 7:
                            startActivity(new Intent().setClass(Introduction.this, Vast_Hazy1.class));
                            break;
                        case 8:
                            startActivity(new Intent().setClass(Introduction.this, Zani1.class));
                            break;
                        case 9:
                            startActivity(new Intent().setClass(Introduction.this, Coming_Soon.class));
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
            ImageView image2;
            TextView text2;
            ViewHolder(View itemView) {
                super(itemView);
                image2 = itemView.findViewById(R.id.image2);
                text2 = itemView.findViewById(R.id.text2);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
