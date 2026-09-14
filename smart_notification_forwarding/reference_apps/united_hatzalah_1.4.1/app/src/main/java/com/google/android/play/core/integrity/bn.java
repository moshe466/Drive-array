package com.google.android.play.core.integrity;

import I1.AbstractC0111a;
import I1.B;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class bn {

    /* renamed from: a, reason: collision with root package name */
    final I1.d f3979a;

    /* renamed from: b, reason: collision with root package name */
    private final I1.y f3980b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3981c;

    /* renamed from: d, reason: collision with root package name */
    private final TaskCompletionSource f3982d;

    /* renamed from: e, reason: collision with root package name */
    private final at f3983e;

    /* renamed from: f, reason: collision with root package name */
    private final k f3984f;

    public bn(Context context, I1.y yVar, at atVar, k kVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f3982d = taskCompletionSource;
        this.f3981c = context.getPackageName();
        this.f3980b = yVar;
        this.f3983e = atVar;
        this.f3984f = kVar;
        I1.d dVar = new I1.d(context, yVar, "ExpressIntegrityService", bo.f3985a, new B() { // from class: com.google.android.play.core.integrity.bd
            @Override // I1.B
            public final Object a(IBinder iBinder) {
                int i = I1.n.f927j;
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
                if (queryLocalInterface instanceof I1.o) {
                    return (I1.o) queryLocalInterface;
                }
                return new AbstractC0111a(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
            }
        });
        this.f3979a = dVar;
        dVar.a().post(new be(this, taskCompletionSource, context));
    }

    public static Bundle a(bn bnVar, String str, long j2, long j3, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f3981c);
        bundle.putLong("cloud.prj", j2);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j3);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new I1.l(5, System.currentTimeMillis()));
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(T.b.a(arrayList)));
        return bundle;
    }

    public static Bundle b(bn bnVar, long j2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", bnVar.f3981c);
        bundle.putLong("cloud.prj", j2);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        bundle.putInt("webview.request.mode", 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new I1.l(4, System.currentTimeMillis()));
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(T.b.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ boolean k(bn bnVar) {
        if (bnVar.f3982d.getTask().isSuccessful() && ((Integer) bnVar.f3982d.getTask().getResult()).intValue() == 0) {
            return true;
        }
        return false;
    }

    public final Task c(Activity activity, Bundle bundle) {
        int i = bundle.getInt("dialog.intent.type");
        this.f3980b.b("requestAndShowDialog(%s)", Integer.valueOf(i));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f3979a.c(new bh(this, taskCompletionSource, bundle, activity, taskCompletionSource, i), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(String str, long j2, long j3, int i) {
        this.f3980b.b("requestExpressIntegrityToken(%s)", Long.valueOf(j3));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f3979a.c(new bg(this, taskCompletionSource, 0, str, j2, j3, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task e(long j2, int i) {
        this.f3980b.b("warmUpIntegrityToken(%s)", Long.valueOf(j2));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f3979a.c(new bf(this, taskCompletionSource, 0, j2, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
