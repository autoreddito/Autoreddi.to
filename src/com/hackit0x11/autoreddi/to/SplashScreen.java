package com.hackit0x11.autoreddi.to;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import java.util.Random;
import android.util.Log;

import android.widget.Toast;


public class SplashScreen extends Activity {
    Random r = new Random();

    private int SPLASH_TIME = (r.nextInt(3000) + 2000);// 2-5 seconds
    public String counturl;
    public String urlaburla;
    private ProgressBar bar;
    private SharedPreferences lamerda;
    private SharedPreferences.Editor lamerdavera;
    public static final String ACTION_CLOSE = "canigonfi.ACTION_CLOSE";
    private FirstReceiver firstReceiver;

    class FirstReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("FirstReceiver", "FirstReceiver");
            if (intent.getAction().equals(ACTION_CLOSE)) {
                SplashScreen.this.finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }
    }


    boolean isFirstRun(){ return lamerda.getBoolean("first_run", true);  }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
        counturl = getResources().getString(R.string.contami);
        urlaburla = getResources().getString(R.string.burlami);
        lamerda = getSharedPreferences("STORAGE", Context.MODE_PRIVATE);
        lamerdavera = lamerda.edit();
        bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setIndeterminate(true);

        IntentFilter filter = new IntentFilter(ACTION_CLOSE);
        firstReceiver = new FirstReceiver();
        registerReceiver(firstReceiver, filter);


        Thread thread_b = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    String hh = utility.getHttpResponse(urlaburla);
                    Log.w("8=========>", hh!=null ? hh: "No");
                    if ((hh != null)) { // BURLA MODE ON, VIVA!
                        lamerdavera.putBoolean("burla", true);
                        lamerdavera.commit();
                        lamerdavera.putBoolean("pissing", true);
                        lamerdavera.commit();
                        utility.dodaburla(SplashScreen.this, SplashScreen.this);
                        SPLASH_TIME = 0;

                    }
                    else{
                        lamerdavera.putBoolean("burla", false);
                        lamerdavera.commit();
                    }
                } catch (Exception stocazzo) { /* bamba is the new rosa */ }
            }
        });

        thread_b.start();


        if(isFirstRun()){

            utility.setDialog(SplashScreen.this, R.layout.alpha,R.string.AboutTitle,R.id.aboutexit,R.string.AboutText);
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() { utility.getHttpResponse(counturl);}
            });
            thread.start();
            lamerdavera.putBoolean("first_run", false);
            lamerdavera.commit();
        }
        if (!(lamerda.getBoolean("burla", false))){
            Intent servideiservideiservi = new Intent(SplashScreen.this, Servodeiservideiservi.class);
            startService(servideiservideiservi);
        }


        boolean b = new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, AutoAct.class);
                startActivity(intent);
                //SplashScreen.this.finish();
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, SPLASH_TIME);

        new Handler().postDelayed(new Runnable() {
			  @Override
			  public void run(){}
        }, SPLASH_TIME);

	}

	@Override
	public void onBackPressed() {
		this.finish();
		super.onBackPressed();
	}

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        unregisterReceiver(firstReceiver);
        super.onStop();
    }
}
