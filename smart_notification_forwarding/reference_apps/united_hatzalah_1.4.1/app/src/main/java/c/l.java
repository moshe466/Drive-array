package c;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.L;
import f.AbstractC0365a;
import w.AbstractC0744b;

/* loaded from: classes.dex */
public final class l extends e.h {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ L f3831h;

    public l(L l3) {
        this.f3831h = l3;
    }

    @Override // e.h
    public final void b(int i, AbstractC0365a contract, Object obj) {
        Bundle bundle;
        int i3;
        kotlin.jvm.internal.j.e(contract, "contract");
        L l3 = this.f3831h;
        I1.h b4 = contract.b(l3, obj);
        if (b4 != null) {
            new Handler(Looper.getMainLooper()).post(new k(this, i, 0, b4));
            return;
        }
        Intent a2 = contract.a(l3, obj);
        if (a2.getExtras() != null) {
            Bundle extras = a2.getExtras();
            kotlin.jvm.internal.j.b(extras);
            if (extras.getClassLoader() == null) {
                a2.setExtrasClassLoader(l3.getClassLoader());
            }
        }
        if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
            String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            AbstractC0744b.d(l3, stringArrayExtra, i);
            return;
        }
        if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
            e.j jVar = (e.j) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                kotlin.jvm.internal.j.b(jVar);
                i3 = i;
            } catch (IntentSender.SendIntentException e4) {
                e = e4;
                i3 = i;
            }
            try {
                l3.startIntentSenderForResult(jVar.f4436a, i3, jVar.f4437b, jVar.f4438c, jVar.f4439d, 0, bundle2);
                return;
            } catch (IntentSender.SendIntentException e5) {
                e = e5;
                new Handler(Looper.getMainLooper()).post(new k(this, i3, 1, e));
                return;
            }
        }
        l3.startActivityForResult(a2, i, bundle2);
    }
}
