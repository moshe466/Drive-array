package com.groboot.mdaemergency;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public class PirateHttpsGetContent implements Runnable {
    String html;
    String url;

    public PirateHttpsGetContent(String str) {
        if (str.indexOf("loadDataWithBaseURL") > -1) {
            this.html = str;
            Log.d("PirateHttpsGetContent", this.url);
        } else {
            this.url = str;
            Log.d("PirateHttpsGetContent", str);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.url != null && !this.url.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                URLConnection urlConnection = new URL(this.url).openConnection();
                urlConnection.addRequestProperty("Host", "m.mda.org.il");
                urlConnection.addRequestProperty("Referer", this.url);
                urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb2.append(readLine);
                    } else {
                        bufferedReader.close();
                        new Thread(new PirateHttpsRequest("html", sb2.toString(), "url", this.url, true)).start();
                        return;
                    }
                }
            }
        } catch (IOException e10) {
        }
    }
}
