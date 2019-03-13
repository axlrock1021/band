package net.ddns.axlrock.bands.Introduction.Female;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import net.ddns.axlrock.bands.Home_Menu.Home_Item;
import net.ddns.axlrock.bands.Introduction.B.Introduction_B;
import net.ddns.axlrock.bands.Introduction.Female.Astro_Bunny.Astro_Bunny1;
import net.ddns.axlrock.bands.Introduction.Female.Bearbabes.Bearbabes1;
import net.ddns.axlrock.bands.Introduction.Female.Cherry_Boom.Cherry_Boom1;
import net.ddns.axlrock.bands.Introduction.Female.Chocolate_Tiger.Chocolate_Tiger1;
import net.ddns.axlrock.bands.Introduction.Female.Coming_Soon.Coming_Soon;
import net.ddns.axlrock.bands.Introduction.Female.Elephant_Gym.Elephant_Gym1;
import net.ddns.axlrock.bands.Introduction.Female.Fir.Fir1;
import net.ddns.axlrock.bands.Introduction.Female.Frande.Frande1;
import net.ddns.axlrock.bands.Introduction.Female.Freckles.Freckles1;
import net.ddns.axlrock.bands.Introduction.Female.Mec_Band.Mec_Band1;
import net.ddns.axlrock.bands.Introduction.Female.Morning_Call.Morning_Call1;
import net.ddns.axlrock.bands.Introduction.Female.My_Skin_Against_Your_Skin.My_Skin_Sgainst_Your_Skin1;
import net.ddns.axlrock.bands.Introduction.Female.NekoJam.Nekojam1;
import net.ddns.axlrock.bands.Introduction.Female.Pisco.Pisco1;
import net.ddns.axlrock.bands.Introduction.Female.QueenSuitcase.QueenSuitcase1;
import net.ddns.axlrock.bands.Introduction.Female.Relax_ONE.Relax_ONE1;
import net.ddns.axlrock.bands.Introduction.Female.Solemn.Solemn1;
import net.ddns.axlrock.bands.Introduction.Female.Soundboss.Soundboss1;
import net.ddns.axlrock.bands.Introduction.Female.Super_Obvious.Super_Obvious1;
import net.ddns.axlrock.bands.Introduction.Female.The_Girl_And_The_Robots.The_Girl_And_The_Robots1;
import net.ddns.axlrock.bands.Introduction.Female.Tizzy_Bac.Tizzy_Bac1;
import net.ddns.axlrock.bands.Introduction.Female.Vast_Hazy.Vast_Hazy1;
import net.ddns.axlrock.bands.Introduction.Female.Wonfu.Wonfu1;
import net.ddns.axlrock.bands.Introduction.Female.Zani.Zani1;
import net.ddns.axlrock.bands.Introduction.Male.Introduction_Male;
import net.ddns.axlrock.bands.R;

import java.util.ArrayList;
import java.util.List;

public class Introduction_Female extends AppCompatActivity {

    //宣告物件
    SearchView searchView;
    LinearLayout introduction_item;
    RecyclerView recyclerView2;
    Button button1,button2,button3;
    List<Home_Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //調用itemListMethod()
        itemListMethod();

//        recyclerView2 = findViewById(R.id.recyclerView2);

//        introduction_item = findViewById(R.id.introduction_item);
//        searchView = findViewById(R.id.searchView);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Toast.makeText(Introduction_Male.this, "搜尋結果為：" + query, Toast.LENGTH_SHORT).show();
//
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                return false;
//            }
//        });
    }



    //利用集合儲存資料&建立RecyclerView
    protected void itemListMethod() {
        itemList = new ArrayList<>();
        itemList.add(new Home_Item(1, R.drawable.soundboss1, "Soundboss"));
        itemList.add(new Home_Item(2, R.drawable.astro_bunny1, "Astro Bunny"));
        itemList.add(new Home_Item(3, R.drawable.chocolate_tiger1, "Chocolate Tiger"));
        itemList.add(new Home_Item(4, R.drawable.mec_band1, "MECBand"));
        itemList.add(new Home_Item(5, R.drawable.morning_call1, "Morning call"));
        itemList.add(new Home_Item(6, R.drawable.my_skin_against_your_skin1, "My Skin Against Your Skin"));
        itemList.add(new Home_Item(7, R.drawable.nekojam1, "NekoJam"));
        itemList.add(new Home_Item(8, R.drawable.vast_hazy1, "Vast & Hazy"));
        itemList.add(new Home_Item(9, R.drawable.zani1, "Zani"));
        itemList.add(new Home_Item(10, R.drawable.wonfu1, "Wonfu"));
        itemList.add(new Home_Item(11, R.drawable.cherry_boom1, "Cherry Boom"));
        itemList.add(new Home_Item(12, R.drawable.tizzy_bac1, "Tizzy Bac"));
        itemList.add(new Home_Item(13, R.drawable.the_girl_and_the_robots1, "The Girl And The Robots"));
        itemList.add(new Home_Item(14, R.drawable.freckles1, "Freckles"));
        itemList.add(new Home_Item(15, R.drawable.frande1, "Frandé"));
        itemList.add(new Home_Item(16, R.drawable.elephant_gym1, "Elephant Gym"));
        itemList.add(new Home_Item(17, R.drawable.fir1, "F.I.R."));
        itemList.add(new Home_Item(18, R.drawable.bearbabes1, "Bearbabes"));
        itemList.add(new Home_Item(19, R.drawable.relax_one1, "Relax-ONE"));
        itemList.add(new Home_Item(20, R.drawable.solemn1, "Solemn"));
        itemList.add(new Home_Item(21, R.drawable.queensuitcase1, "QueenSuitcase"));
        itemList.add(new Home_Item(22, R.drawable.super_obvious1, "Super Obvious"));
        itemList.add(new Home_Item(23, R.drawable.pisco1, "P!sco"));
        itemList.add(new Home_Item(24, R.drawable.coming_soon, "Coming Soon"));

        //建立RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        //建立瀑布流式的ListView
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL));//垂直
        recyclerView.setAdapter(new itemListAdapter(this, itemList));
    }

    //切換至女主唱
    public void switchPage1(View view) {
    }

    //切換至男主唱
    public void switchPage2(View view) {
        startActivity(new Intent().setClass(Introduction_Female.this, Introduction_Male.class));
        finish();

    }
    //切換至素人
    public void switchPage3(View view) {
        startActivity(new Intent().setClass(Introduction_Female.this, Introduction_B.class));
        finish();
    }



    //建立Adapter
    private class itemListAdapter extends RecyclerView.Adapter<Introduction_Female.itemListAdapter.ViewHolder> {
        //宣告變數
        private Context context;
        private List<Home_Item> homeList;

        itemListAdapter(Context context, List<Home_Item> memberList) {
            this.context = context;
            this.homeList = memberList;
        }

        //複寫onCreateViewHolder
        @Override
        public Introduction_Female.itemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.introduction_item, parent, false);
            return new Introduction_Female.itemListAdapter.ViewHolder(view);
        }

        //複寫onBindViewHolder
        @Override
        public void onBindViewHolder(final Introduction_Female.itemListAdapter.ViewHolder holder, final int position) {
            final Home_Item member = homeList.get(position);
            holder.image2.setImageResource(member.getImage());
            holder.text2.setText(member.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position){
                        case 0:
                            startActivity(new Intent().setClass(Introduction_Female.this, Soundboss1.class));
                            break;
                        case 1:
                            startActivity(new Intent().setClass(Introduction_Female.this, Astro_Bunny1.class));
                            break;
                        case 2:
                            startActivity(new Intent().setClass(Introduction_Female.this, Chocolate_Tiger1.class));
                            break;
                        case 3:
                            startActivity(new Intent().setClass(Introduction_Female.this, Mec_Band1.class));
                            break;
                        case 4:
                            startActivity(new Intent().setClass(Introduction_Female.this, Morning_Call1.class));
                            break;
                        case 5:
                            startActivity(new Intent().setClass(Introduction_Female.this, My_Skin_Sgainst_Your_Skin1.class));
                            break;
                        case 6:
                            startActivity(new Intent().setClass(Introduction_Female.this, Nekojam1.class));
                            break;
                        case 7:
                            startActivity(new Intent().setClass(Introduction_Female.this, Vast_Hazy1.class));
                            break;
                        case 8:
                            startActivity(new Intent().setClass(Introduction_Female.this, Zani1.class));
                            break;
                        case 9:
                            startActivity(new Intent().setClass(Introduction_Female.this, Wonfu1.class));
                            break;
                        case 10:
                            startActivity(new Intent().setClass(Introduction_Female.this, Cherry_Boom1.class));
                            break;
                        case 11:
                            startActivity(new Intent().setClass(Introduction_Female.this, Tizzy_Bac1.class));
                            break;
                        case 12:
                            startActivity(new Intent().setClass(Introduction_Female.this, The_Girl_And_The_Robots1.class));
                            break;
                        case 13:
                            startActivity(new Intent().setClass(Introduction_Female.this, Freckles1.class));
                               break;
                        case 14:
                            startActivity(new Intent().setClass(Introduction_Female.this, Frande1.class));
                            break;
                        case 15:
                            startActivity(new Intent().setClass(Introduction_Female.this, Elephant_Gym1.class));
                            break;
                        case 16:
                            startActivity(new Intent().setClass(Introduction_Female.this, Fir1.class));
                            break;
                        case 17:
                            startActivity(new Intent().setClass(Introduction_Female.this, Bearbabes1.class));
                            break;
                        case 18:
                            startActivity(new Intent().setClass(Introduction_Female.this, Relax_ONE1.class));
                            break;
                        case 19:
                            startActivity(new Intent().setClass(Introduction_Female.this, Solemn1.class));
                            break;
                        case 20:
                            startActivity(new Intent().setClass(Introduction_Female.this, QueenSuitcase1.class));
                            break;
                        case 21:
                            startActivity(new Intent().setClass(Introduction_Female.this, Super_Obvious1.class));
                            break;
                        case 22:
                            startActivity(new Intent().setClass(Introduction_Female.this, Pisco1.class));
                            break;
                        case 23:
                            startActivity(new Intent().setClass(Introduction_Female.this, Coming_Soon.class));
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
