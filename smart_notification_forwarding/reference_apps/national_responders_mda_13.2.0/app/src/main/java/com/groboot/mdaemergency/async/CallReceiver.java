package com.groboot.mdaemergency.async;

import android.content.Context;
import java.util.Date;
import o5.i;

/* loaded from: classes.dex */
public class CallReceiver extends i {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f7590e;

    @Override // o5.i
    protected void b(Context context, String str, Date date) {
        f7590e = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onIncomingCallActive number:");
        sb2.append(str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("isCallActive:");
        sb3.append(f7590e);
    }

    @Override // o5.i
    protected void c(Context context, String str, Date date, Date date2) {
        f7590e = false;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onIncomingCallEnded number:");
        sb2.append(str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("isCallActive:");
        sb3.append(f7590e);
    }

    @Override // o5.i
    protected void d(Context context, String str, Date date) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onIncomingCallStarted number:");
        sb2.append(str);
    }

    @Override // o5.i
    protected void e(Context context, String str, Date date) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onMissedCall number:");
        sb2.append(str);
    }

    @Override // o5.i
    protected void f(Context context, String str, Date date, Date date2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onOutgoingCallEnded number:");
        sb2.append(str);
        f7590e = false;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("isCallActive:");
        sb3.append(f7590e);
    }

    @Override // o5.i
    protected void g(Context context, String str, Date date) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onOutgoingCallStarted number:");
        sb2.append(str);
        f7590e = true;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("isCallActive:");
        sb3.append(f7590e);
    }
}
