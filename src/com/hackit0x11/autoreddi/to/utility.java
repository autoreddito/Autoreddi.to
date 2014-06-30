package com.hackit0x11.autoreddi.to;

import android.app.*;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Context;
import android.text.Html;
import android.widget.Toast;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class utility{
    private static MediaPlayer rickrollizer = null;
    private static boolean fisting = false;


    public synchronized static void play(Context ctx, int resid) {
        if (rickrollizer == null) {  rickrollizer = new MediaPlayer();  }

        if (!fisting) {
            try {
                Uri u = Uri.parse("android.resource://" + ctx.getPackageName() + "/" + resid);
                if (u == null) Log.e("peso", "pddio");
                rickrollizer.setDataSource(ctx, u);
                rickrollizer.prepare();
            } catch (Exception stocazzo) {}
            fisting = true;
            rickrollizer.start();
            rickrollizer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    fisting = false;
                    mp.reset();
                    try {
                        mp.prepare();
                    } catch (Exception e) {
                    }
                    mp.start();
                    fisting = true;

                }
            });
        }
    }

    public synchronized static void stop() {
        fisting = false;
        if (rickrollizer != null) {
            rickrollizer.release();
            rickrollizer = null;
        }
    }

    public static void createNotification(Context ctx) {
        Bitmap largeIcon = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.ic_rick_astley);
        Intent bozzo =new Intent(ctx.getApplicationContext(),QueRicko.class);
        bozzo.putExtra("NOTIFICATION_DATA", "CACCA");
        PendingIntent strabozzo = PendingIntent.getActivity(ctx.getApplicationContext(), 0, bozzo, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
                ctx.getApplicationContext())
                .setContentTitle("YOU JUST GOT RICK ROLL'D")
                .setContentText("click to stop Never Gonna Give You Up")
                .setSmallIcon(R.drawable.ic_rick_astley)
                .setLargeIcon(largeIcon)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_VIBRATE| Notification.DEFAULT_SOUND)
                .setContentIntent(strabozzo);
        NotificationManager notificationManager =(NotificationManager) ctx.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        // hide the notification after its selected
        Notification notification=notificationBuilder.build();
        notificationManager.notify(0, notification);

    }


    public static void dodaburla(Context ctx, Activity a){
        play(ctx, R.raw.rick);
        Intent goatse = new Intent(Intent.ACTION_VIEW, Uri.parse("http://goatse.ru/"));
        a.startActivity(goatse);
        createNotification(ctx);
    }


    public static void setDialog(Context c, int layout, int title, int b, int text){
        final Dialog dialog = new Dialog(c);
        dialog.setContentView(layout);
        dialog.setTitle(c.getResources().getString(title));
        dialog.setCancelable(true);

        TextView te=(TextView) dialog.findViewById(c.getResources().getIdentifier("testo","id", c.getPackageName()));
        te.setText(Html.fromHtml(c.getResources().getString(text)));

        Button button = (Button) dialog.findViewById(b);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){dialog.dismiss();}
        });
        dialog.show();
    }

    static public void showDialogFor(Toast to, int seconds){
        final Toast t=to;
        new CountDownTimer(seconds*1000, 1000)
        {
            public void onTick(long millisUntilFinished) {t.show();}
            public void onFinish() {t.show();}
        }.start();
    }

    static public Animation blinkaview(View vb, int seconds){
        Animation anima = new AlphaAnimation(0.3f, 1.0f);
        anima.setDuration(seconds);
        anima.setRepeatMode(Animation.REVERSE);
        anima.setRepeatCount(Animation.INFINITE);
        vb.startAnimation(anima);
        return anima;
    }

    /* https://www.youtube.com/watch?v=suQBZzcO0TQ */
    public static String getHttpResponse(String uri) {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    //Your code goes here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



        StringBuilder response = new StringBuilder();
        try {
            HttpGet get = new HttpGet(uri);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = httpClient.execute(get);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity messageEntity = httpResponse.getEntity();
                InputStream is = messageEntity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
            }
            else{
                return null;}
        } catch (Exception e) {
            return null;
        }
        return response.toString();
    }








}





