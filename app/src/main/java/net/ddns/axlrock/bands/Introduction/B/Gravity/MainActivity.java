package net.ddns.axlrock.bands.Introduction.B.Gravity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import net.ddns.axlrock.bands.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private List<PageView> pageList;
    //宣告物件
    Button fb;
    RecyclerView recyclerView;
    private ImageView imageView1, imageView2,imageView3,imageView4;
    private Dialog dialog1,dialog2,dialog3,dialog4;
    private ImageView image1, image2,image3,image4;
    //初始化網址
    String youtubeURL1 = "https://www.facebook.com/Gravity1213/"; //fb

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        //建立關聯
        fb = findViewById(R.id.fb); //官方臉書

//        //調用方法
//        init();
//        init2();
//        init3();
//        init4();
//        tip();


        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //建立RecyclerView
//        recyclerView = findViewById(R.id.recyclerview_gravitys);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //調用listText()
//        listText();
    }



    //    @SuppressLint("ResourceType")
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.layout.gravity4, menu);
//        return true;
//    }



    //顯示清單文字內容
    public void listText(){

        //初始化Year&Content物件
        ArrayList<Year> years = new ArrayList<>();
        ArrayList<Content> contents1 = new ArrayList<>();

        contents1.add(new Content(
                "1.04/18 Live at Revolver\n\n" +
                        "2.02/22 Live at 台中迴響\n\n" +
                        "etc . . . . . "));

        Year year1 = new Year("2017 - 演出資訊", contents1);
        years.add(year1);


        ArrayList<Content> contents2 = new ArrayList<>();
        contents2.add(new Content(
                "1.12/24 Live at 桃園埔心農場\n\n"+
                        "2.10/15 Live at 新竹Haven Bar\n\n"+
                        "3.09/11 Live at 公館河岸(專場)\n\n"+
                        "4.07/30 Live at 翡翠灣\n\n" +
                        "5.07/24 Live at 台中中山堂\n\n" +
                        "6.07/09 Live at 希望廣場\n\n" +
                        "7.06/11 Live at 翡翠灣\n\n" +
                        "8.03/17 Live at Revolver\n\n"+
                        "9.01/10 Live at 西門杰克(首演)\n\n" +
                        "etc . . . . . "));

        Year year2 = new Year("2016 - 演出資訊", contents2);
        years.add(year2);


        ContentAdapter adapter = new ContentAdapter(years);
        recyclerView.setAdapter(adapter);
    }

    //小圖的點擊事件(彈出大圖)
    public void  tip(){//小圖的點擊事件(彈出大圖)
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog3.show();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4.show();
            }
        });

    }


    private void initData() {
        pageList = new ArrayList<>();
        pageList.add(new Page1(MainActivity.this));
        pageList.add(new Page2(MainActivity.this));
        pageList.add(new Page3(MainActivity.this));
        pageList.add(new Page4(MainActivity.this));
    }

    private void initView() {
        mTablayout = (TabLayout) findViewById(R.id.tabs);
        mTablayout.addTab(mTablayout.newTab().setText("Page one"));
        mTablayout.addTab(mTablayout.newTab().setText("Page two"));
        mTablayout.addTab(mTablayout.newTab().setText("Page three"));
        mTablayout.addTab(mTablayout.newTab().setText("Page four"));

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        initListener();
    }

    private void initListener() {
        mTablayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
    }

    private class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    //前往官方臉書
    public void goFacebook(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL1));
        startActivity(intent);
    }

    private void init() {
        imageView1 = findViewById(R.id.image1);

        //顯示在dialog上面的大圖
        dialog1 = new Dialog(MainActivity.this, R.style.AppTheme);

        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog1.getWindow().setAttributes(attributes);

        image1 = getImageView1();
        dialog1.setContentView(image1);

        //大圖的點擊事件(點擊讓它消失)
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
    }
    private void init2() {
        imageView2 = findViewById(R.id.image2);

        //顯示在dialog上面的大圖
        dialog2 = new Dialog(MainActivity.this, R.style.AppTheme);

        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog2.getWindow().setAttributes(attributes);

        image2 = getImageView2();
        dialog2.setContentView(image2);

        //大圖的點擊事件(點擊讓它消失)
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });
    }
    private void init3() {
        imageView3 = findViewById(R.id.image3);

        //顯示在dialog上面的大圖
        dialog3 = new Dialog(MainActivity.this, R.style.AppTheme);

        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog3.getWindow().setAttributes(attributes);

        image3 = getImageView3();
        dialog3.setContentView(image3);

        //大圖的點擊事件(點擊讓它消失)
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog3.dismiss();
            }
        });
    }
    private void init4() {
        imageView4 = findViewById(R.id.image4);

        //顯示在dialog上面的大圖
        dialog4 = new Dialog(MainActivity.this, R.style.AppTheme);

        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog4.getWindow().setAttributes(attributes);

        image4 = getImageView4();
        dialog4.setContentView(image4);

        //大圖的點擊事件(點擊讓它消失)
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4.dismiss();
            }
        });
    }


    //動態取得ImageView
    private ImageView getImageView1() {

        ImageView imageView1 = new ImageView(this);
        //寬高
        imageView1.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        //imageView是設置圖片
        @SuppressLint("ResourceType")
        InputStream is1 = getResources().openRawResource(R.drawable.gravity13);

        Drawable drawable1 = BitmapDrawable.createFromStream(is1, null);
        imageView1.setImageDrawable(drawable1);

        return imageView1;
    }


    private ImageView getImageView2() {

        ImageView imageView2 = new ImageView(this);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        @SuppressLint("ResourceType")
        InputStream is2 = getResources().openRawResource(R.drawable.gravity14);

        Drawable drawable2 = BitmapDrawable.createFromStream(is2, null);
        imageView2.setImageDrawable(drawable2);

        return imageView2;
    }

    private ImageView getImageView3() {

        ImageView imageView3 = new ImageView(this);
        imageView3.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        @SuppressLint("ResourceType")
        InputStream is3 = getResources().openRawResource(R.drawable.gravity15);

        Drawable drawable3 = BitmapDrawable.createFromStream(is3, null);
        imageView3.setImageDrawable(drawable3);

        return imageView3;
    }

    private ImageView getImageView4() {

        ImageView imageView4 = new ImageView(this);
        imageView4.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        @SuppressLint("ResourceType")
        InputStream is4 = getResources().openRawResource(R.drawable.gravity16);

        Drawable drawable4 = BitmapDrawable.createFromStream(is4, null);
        imageView4.setImageDrawable(drawable4);

        return imageView4;
    }
}
