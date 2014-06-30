package com.hackit0x11.autoreddi.to;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;

public class Servodeiservideiservi extends IntentService {
    private int result = Activity.RESULT_OK;
    public static final String che = "wop wop is the sound of the police";
    public static final String chie = "com.hackit0x11.autoreddi.to.service.receiver";
    private Handler O_O = new Handler();
    public Servodeiservideiservi() { super("Servodeiservideiservi"); }
    boolean gnugna = true;

    private Runnable O_o = new Runnable() {



        @Override
        public void run() {
            if (gnugna) {
                Thread castagno = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        /* ogni 60 secondi vedo se e' cambiata la situa raga */
                            String bafometto = utility.getHttpResponse(getResources().getString(R.string.burlami));
                            if (bafometto != null) { // BURLA MODE ON, VIVA!
                                publishResults(result);

                            }
                        } catch (Exception e) { /* rosa is the new bamba */ }
                    }
                });

                castagno.start();
                O_O.postDelayed(this, 60000);
            }
        }
    };

    // chiama me! chiama me! ╰( ´・ω・)
    @Override
    protected void onHandleIntent(Intent intent) { O_O.postDelayed(O_o, 30000);  }

    private void publishResults(int result) {
        gnugna = false;
        Intent cormorano = new Intent(chie);
        cormorano.putExtra(che, result);
        sendBroadcast(cormorano);
    }
}
