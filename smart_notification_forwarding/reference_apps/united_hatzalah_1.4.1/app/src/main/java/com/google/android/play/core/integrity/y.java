package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes.dex */
abstract class y {

    /* renamed from: b, reason: collision with root package name */
    private final String f4024b;

    /* renamed from: c, reason: collision with root package name */
    private final long f4025c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4027e;

    /* renamed from: a, reason: collision with root package name */
    private final I1.y f4023a = new I1.y("IntegrityDialogWrapper");

    /* renamed from: d, reason: collision with root package name */
    private final Object f4026d = new Object();

    public y(String str, long j2) {
        this.f4024b = str;
        this.f4025c = j2;
    }

    public final Task a(Activity activity, int i) {
        synchronized (this.f4026d) {
            try {
                if (this.f4027e) {
                    return Tasks.forResult(0);
                }
                this.f4027e = true;
                I1.y yVar = this.f4023a;
                Object[] objArr = {Integer.valueOf(i)};
                yVar.getClass();
                if (Log.isLoggable("PlayCore", 3)) {
                    I1.y.c(yVar.f929a, "checkAndShowDialog(%s)", objArr);
                }
                Bundle bundle = new Bundle();
                bundle.putInt("dialog.intent.type", i);
                bundle.putString("package.name", this.f4024b);
                bundle.putInt("playcore.integrity.version.major", 1);
                bundle.putInt("playcore.integrity.version.minor", 3);
                bundle.putInt("playcore.integrity.version.patch", 0);
                bundle.putLong("request.token.sid", this.f4025c);
                return b(activity, bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Task b(Activity activity, Bundle bundle);
}
