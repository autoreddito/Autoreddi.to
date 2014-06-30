package com.hackit0x11.autoreddi.to;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class QueRicko extends Activity {
    private TextView magalli;

    @Override
    public void onCreate(Bundle ilcomitato) {
        super.onCreate(ilcomitato);
        setContentView(R.layout.rickrollo);
        magalli = (TextView) findViewById(R.id.ricktesto);
        magalli.setMovementMethod(LinkMovementMethod.getInstance());
        magalli.setText(Html.fromHtml(getApplicationContext().getResources().getString(R.string.RickText)));
        if(ilcomitato==null){ utility.stop(); }
    }
}