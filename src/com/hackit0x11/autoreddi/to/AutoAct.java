package com.hackit0x11.autoreddi.to;

import android.app.Activity;
import android.content.*;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class AutoAct extends Activity {
    volatile WebView spade;
    private SharedPreferences lucasardella;
    private SharedPreferences.Editor janiramajello;
    public class giucas_casella {
        Context ciste;
        giucas_casella(Context c) { ciste = c; }
        @JavascriptInterface
        public void test1(){ System.out.println("Vaivaivai da Aiazzone vai");
        }
        @JavascriptInterface
        public void notimp(){
            Toast toast = Toast.makeText(ciste, "Alpha Stage: not implemented yet.", Toast.LENGTH_SHORT);
            toast.show();
        }
        @JavascriptInterface
        public void cingomma(String peso){
            Intent goatse = new Intent(Intent.ACTION_VIEW, Uri.parse(peso));
            AutoAct.this.startActivity(goatse);
        }

    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                int resultCode = bundle.getInt(Servodeiservideiservi.che);
                if (resultCode == RESULT_OK) {
                    utility.dodaburla(AutoAct.this, AutoAct.this);
                    spade.loadUrl("file:///android_asset/burla.html");
                }
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(Servodeiservideiservi.chie));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        if (lucasardella.getBoolean("burla", false)){
            MenuItem facezie = menu.findItem(R.id.action_info);
            facezie.setVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu:
                spade.loadUrl("javascript:showpannello()");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lucasardella = getSharedPreferences("STORAGE", Context.MODE_PRIVATE);
        janiramajello = lucasardella.edit();
        setContentView(R.layout.main);
        spade = (WebView)findViewById(R.id.webview);
        if (lucasardella.getBoolean("burla", false)){
            spade.loadUrl("file:///android_asset/burla.html");
        }
        else{
            spade.loadUrl("file:///android_asset/index.html");
            spade.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            spade.setWebChromeClient(new WebChromeClient());
            spade.setWebViewClient(new WebViewClient() {

                public void onPageFinished(WebView view, String url) {
                    Intent myIntent = new Intent(SplashScreen.ACTION_CLOSE);
                    sendBroadcast(myIntent);
                }
            });
            spade.addJavascriptInterface(new giucas_casella(this), "jsinterface");

        }
        WebSettings webSettings = spade.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //spade.setWebContentsDebuggingEnabled(true);
        }

    }
}
