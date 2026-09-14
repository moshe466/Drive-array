package com.groboot.mdaemergency.locations.transition;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.groboot.mdaemergency.enums.b;
import s2.d;
import u5.f;
import w6.m;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class TransitionRecognitionReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f7714a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7715b = "[Location][TransitionRecognition]";

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final void b(d dVar) {
        f.f14390a.a(dVar);
        int g10 = dVar.g();
        if (g10 == 0 || g10 == 1 || g10 == 7 || g10 == 8) {
            d(dVar);
        }
        e(dVar);
    }

    private final void d(d dVar) {
        if (m.O() == null || m.O().getTrackingType() != b.a.FULL) {
            return;
        }
        String str = dVar.l() == 0 ? "ransitionRecognition_Enter" : "ransitionRecognition_Exit";
        k.j("action : ", str);
        Intent intent = new Intent(str);
        intent.putExtra("GeofencingReceiver_Extra_Provider", com.groboot.mdaemergency.locations.a.transitionRecognition.ordinal());
        intent.putExtra("TransitionRecognition_EXTRA_ACTIVITY_TYPE", dVar.g());
        a().sendBroadcast(intent);
    }

    public final Context a() {
        Context context = this.f7714a;
        if (context != null) {
            return context;
        }
        k.o("mContext");
        return null;
    }

    public final void c(s2.f fVar) {
        k.e(fVar, "result");
        for (d dVar : fVar.j()) {
            k.d(dVar, "event");
            b(dVar);
        }
    }

    public final void e(d dVar) {
        k.e(dVar, "<set-?>");
    }

    public final void f(Context context) {
        k.e(context, "<set-?>");
        this.f7714a = context;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        k.b(context);
        f(context);
        if (s2.f.l(intent)) {
            s2.f g10 = intent == null ? null : s2.f.g(intent);
            if (g10 != null) {
                c(g10);
            }
        }
    }
}
