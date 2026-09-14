package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import D1.a;
import F0.C0110z2;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.firebase.crashlytics.internal.concurrency.b;
import com.lt.plugin.lt_plugin.utils.d;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import t1.k;
import t1.t;
import z1.g;

/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3885a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter(MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR)).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        t.b(context);
        C0110z2 a2 = k.a();
        a2.v(queryParameter);
        a2.f731d = a.b(intValue);
        if (queryParameter2 != null) {
            a2.f730c = Base64.decode(queryParameter2, 0);
        }
        g gVar = t.a().f6457d;
        gVar.f6861e.execute(new d(gVar, a2.g(), i, new b(4), 1));
    }
}
