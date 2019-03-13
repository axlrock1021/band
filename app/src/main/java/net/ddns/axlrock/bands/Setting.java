package net.ddns.axlrock.bands;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import net.ddns.axlrock.bands.util.IabHelper;
import net.ddns.axlrock.bands.util.IabResult;

public class Setting extends AppCompatActivity implements BillingProcessor.IBillingHandler{

    //宣告物件
    Button button1; //臉書粉絲團
    Button button2; //發送mail
    Button button3; //分享
    Button button4; //商店評分
    Button button5; //關於作者
    Button button6; //版本資訊
    Button button7; //小額贊助
    Button button8; //語言切換
    private AdView mAdView; //廣告
    //初始化網址
    String youtubeURL1 = "https://www.facebook.com/andyrock1021/";
    //金流處理
    BillingProcessor bp;
    //Base64編碼RSA公開金鑰
    String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiUSbj5hYDxOK4O9gO87x5cDrgw8JCm698S9vS/kkLCXCkekXcvyyqay3Ijl9zoYkY3P9zQmUuiT6JlEuJ9FkWnDHhDacFa2qmyOWvh3tf+GnzEAghssk5HQfJB1zk+zieD/5BifzXK6K/O4MZBmxCAevSqpo3LIoZr9RAPrll09SJUk+gz+G/7ucueQwfRbsKxXHfiU7sTeKuztCzdJh6btZuLKe02GoLgUAluxcXwe3ZGkAn2ysLmSotl+ALwpDQa/3VCPWLAVJi8Y7C3nrURoI5Tzgv4pp6Mg/qRIdT5e9WyZM7M71Zveq3ziNUD2+SbpEe1RI740Jd5iCN4NJXQIDAQAB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);



        button1 = findViewById(R.id.button1); //臉書粉絲團
        button2 = findViewById(R.id.button2); //發送mail
        button3 = findViewById(R.id.button3); //分享
        button4 = findViewById(R.id.button4); //商店評分
        button5 = findViewById(R.id.button5); //關於作者
        button6 = findViewById(R.id.button6); //版本資訊
//        button7 = findViewById(R.id.button7); //語言切換

        //調用setLanguage();
//        setLanguage();


        //建立廣告連結(應用程式ID)，XML更換成(*廣告單元ID)
        MobileAds.initialize(this, "ca-app-pub-7259957151155157~8079584006");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //禁止螢幕翻轉
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //google play base64EncodedPublicKey
        bp = new BillingProcessor(this, base64EncodedPublicKey,this);
        bp.initialize();


        //調用startSetup方法
//        bp.startSetup(new IabHelper.OnIabSetupFinishedListener() {
//            private static final String TAG = "Setting";
//
//            @Override
//            public void onIabSetupFinished(IabResult result) {
//                if (!result.isSuccess()) {
//                    Log.e(TAG, "Problem setting up In-app Billing: " + result);
//                }
//                if (bp == null) {
//                    return;
//                }
//            }
//        });
    }








    //前往粉絲團
    public void goFacebook(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeURL1));
        startActivity(intent);
    }


    //發送mail(給予建議)
    public void goMail(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:axlrock1021@hotmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "主旨 : ");
        intent.putExtra(Intent.EXTRA_TEXT, "內容 : ");
        startActivity(intent);
    }

    //分享
    public void goShareTo(View view){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String subject = null;
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        String body = null;
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=net.ddns.axlrock.bands");
        String chooserTitle = null;
        startActivity(Intent.createChooser(sharingIntent, chooserTitle));
    }

    //前往Google play商店評分
    public void goGooglePlay(View view){

        button4.setOnClickListener(new View.OnClickListener() {

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
                        Toast.makeText(getApplicationContext(), "您沒有安裝應用市場或瀏覽器", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //關於作者
    public void about_the_author(View view) {

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //建立AlertDialog
                AlertDialog.Builder ad = new AlertDialog.Builder(Setting.this); //宣告物件實例化

                ad.setIcon(R.drawable.smile);  //設定標題圖片
                ad.setTitle("關 於 作 者"); //設定標題內容
                ad.setMessage("\n熱愛音樂的夥伴們\n\n你們好，我叫Andy\n\n本身熱愛音樂，音樂就是我的生命之泉，" +
                        "於是做了這個樂團介紹APP，當中還有許多功能需要改進，也歡迎大家鞭我，但請小力點，我會虛心受教的" +
                        "\n\n最後，請慢慢欣賞吧，陸續還會持續更新，讓內容更豐富，希望你們會喜歡"); //設定訊息內容

                ad.setPositiveButton("OK", new DialogInterface.OnClickListener() { //設定按鍵(右邊)

                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
                AlertDialog dialog = ad.create();
                //按下空白地方時不消失
                dialog.setCanceledOnTouchOutside(false);
                //顯示對話框
                dialog.show();
                //自訂長寬
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            }
        });
    }

    //版本資訊
    public void version(View view) {

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //建立AlertDialog
                AlertDialog.Builder ad = new AlertDialog.Builder(Setting.this); //宣告物件實例化

                ad.setIcon(R.drawable.version);  //設定標題圖片
                ad.setTitle("版 本 資 訊"); //設定標題內容
                ad.setMessage("\n第一版[1.1.4]\n\n功能列表\n\n1.樂團介紹\n(目前共26組樂團)\n\n" +
                        "2.影片欣賞\n(目前共10組樂團)\n\n3.音樂播放器\n(自動播放、暫停播放、隨機播放、上一首、下一首)\n\n" +
                        "4.表演舞台\n(目前共15組商家)\n\n5.專區\n\n\n"); //設定訊息內容

                ad.setPositiveButton("OK", new DialogInterface.OnClickListener() { //設定按鍵(右邊)

                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
                AlertDialog dialog = ad.create();
                //按下空白地方時不消失
                dialog.setCanceledOnTouchOutside(false);
                //顯示對話框
                dialog.show();
                //自訂長寬
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            }
        });
    }

//    //小額贊助
////    public void pay(View view) {
////       button6.setOnClickListener(new View.OnClickListener() {
////           @Override
////           public void onClick(View v) {
////               bp.purchase(Setting.this,"1");
////           }
////       });
////    }


    //IBillingHandler implementation
    //在BillingProcessor初始化並準備購買時調用
    @Override
    public void onBillingInitialized() {
        /*
         * Called when BillingProcessor was initialized and it's ready to purchase
         */


    }

    //成功購買所需的PRODUCT ID時調用
    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        /*
         * Called when requested PRODUCT ID was successfully purchased
         */
    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        /*
         * Called when some error occurred. See Constants class for more details
         *
         * Note - this includes handling the case where the user canceled the buy dialog:
         * errorCode = Constants.BILLING_RESPONSE_RESULT_USER_CANCELED
         */

    }

    @Override
    public void onPurchaseHistoryRestored() {
        /*
         * Called when purchase history was restored and the list of all owned PRODUCT ID's
         * was loaded from Google Play
         */
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //    //語言切換
//    public void languageSwitch(View view) {
//
//        button7.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
//                builder.setSingleChoiceItems(new String[]{"中文", "English"},
//                        getSharedPreferences("Language", Context.MODE_PRIVATE).getInt("Language", 0),
//                        new DialogInterface.OnClickListener() {
//
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                SharedPreferences preferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
//                                SharedPreferences.Editor editor = preferences.edit();
//                                editor.putInt("Language", i);
//                                editor.apply();
//                                dialogInterface.dismiss();
//
//                            }
//                        });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });
//    }
//
//    //語言切換
//    private void setLanguage() {
//
//        SharedPreferences preferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
//        int language = preferences.getInt("Language", 0);
//
//        Resources resources = getResources();
//        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
//        Configuration configuration = resources.getConfiguration();
//
//        switch (language){
//            case 0:
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                    configuration.locale = Locale.CHINESE;
//
//                }
//                break;
//            case 1:
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                    configuration.setLocale(Locale.US);
//
//                }
//                break;
//        }
//        resources.updateConfiguration(configuration,displayMetrics);
//    }


    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
    }
}
