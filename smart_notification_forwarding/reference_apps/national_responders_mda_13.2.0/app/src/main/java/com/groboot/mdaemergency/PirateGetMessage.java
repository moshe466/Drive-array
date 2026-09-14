package com.groboot.mdaemergency;

import android.content.Context;
import android.util.Log;
import com.groboot.mdaemergency.async.d;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PirateGetMessage implements Runnable {
    String message;

    public PirateGetMessage(String str) {
        this.message = str;
        Log.d("PirateGetMessage", str);
    }

    public PirateGetMessage(Map<String, String> data) {
        String str4;
        try {
            String str = data.get("Message");
            String str2 = data.get("Title");
            String str3 = data.get("S");
            if ((str != null || str2 != null || str3 != null) && (str4 = data.get("D")) != null && !str4.isEmpty()) {
                Log.d("PirateGetMessage-str4", str4);
                try {
                    this.message = new JSONObject(str4).getString("Id");
                } catch (JSONException e10) {
                    this.message = str4;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.message.isEmpty()) {
            d.v().B((Context) null, this.message, new PirateGetMessageCallback());
        }
    }
}
