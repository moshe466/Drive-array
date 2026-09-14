package com.groboot.mdaemergency.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.w;
import com.groboot.mdaemergency.PirateGetMessage;
import java.util.Map;
import p5.d;
import r5.a;
import w6.l0;

/* loaded from: classes.dex */
public class FCMNotificationIntentService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void p(w wVar) {
        a.a().f(this);
        String str = d.f13074j;
        String j10 = wVar.j();
        Map<String, String> g10 = wVar.g();
        String str2 = g10.get("message");
        if (l0.l0(str2)) {
            str2 = g10.get("Message");
        }
        String str3 = d.f13074j;
        if (j10 != null) {
            String str4 = d.f13074j;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("From: ");
            sb2.append(j10);
        } else {
            j10 = "";
        }
        if (str2 == null || str2.isEmpty()) {
            String str5 = d.f13074j;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("message == null, from:");
            sb3.append(j10);
        } else {
            String str6 = d.f13074j;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Message: ");
            sb4.append(str2);
        }
        d.n(getApplicationContext(), g10, true);
        new PirateGetMessage(g10);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void r(String str) {
        super.r(str);
        d.r(getApplicationContext(), str);
    }
}
