package com.groboot.mdaemergency;

import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.Message;

/* loaded from: classes.dex */
public class PirateGetMessageCallback implements d.w {
    public void messageReceived(Message message) {
        if (message != null) {
            new Thread(new PirateHttpsGetContent(message.HtmlURL)).start();
        }
    }

    public void onError(String str) {
    }
}
