package net.ddns.axlrock.bands;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Setting extends AppCompatActivity {

    //宣告物件，建立關聯
    Button button1;
    Button button2;
    Button button3;
    Button button7;
    //初始化網址
    String youtubeURL1 = "https://www.facebook.com/andyrock1021/";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        button1 = findViewById(R.id.button1); //粉絲團
        button2 = findViewById(R.id.button2); //發送mail
        button3 = findViewById(R.id.button3); //商店評分
        button7 = findViewById(R.id.button7); //語言切換

        //調用setLanguage();
        setLanguage();
    }

    //前往粉絲團
    public  void goFacebook(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL1));
        startActivity(intent);
    }

    //發送mail
    public  void goMail(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:axlrock1021@hotmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "主旨。");
        intent.putExtra(Intent.EXTRA_TEXT, "內容。");
        startActivity(intent);
    }

    //前往Google play商店評分
    public void goGooglePlay(View view){

        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + getPackageName())); //核心代碼
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "大爺~您沒有安裝應用市場或瀏覽器", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //語言切換
    public void languageSwitch(View view) {

        button7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
                builder.setSingleChoiceItems(new String[]{"中文", "English"},
                        getSharedPreferences("Language", Context.MODE_PRIVATE).getInt("Language", 0),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences preferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putInt("Language", i);
                                editor.apply();
                                dialogInterface.dismiss();

                                Intent intent = new Intent(Setting.this, Setting.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    private void setLanguage() {

        SharedPreferences preferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
        int language = preferences.getInt("Language", 0);

        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();

        switch (language){
            case 0:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    configuration.locale = Locale.CHINESE;
                }
                break;
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    configuration.setLocale(Locale.US);
                }
                break;
        }
        resources.updateConfiguration(configuration,displayMetrics);
    }
}
