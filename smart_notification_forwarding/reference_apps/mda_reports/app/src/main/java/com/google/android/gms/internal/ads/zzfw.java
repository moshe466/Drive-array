package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class zzfw implements Callable {
    private final String TAG = getClass().getSimpleName();
    protected final zzei a;
    protected final zzbs.zza.zzb b;
    protected Method c;
    private final String className;
    private final String zzaac;
    private final int zzaai;
    private final int zzaaj;

    public zzfw(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        this.a = zzeiVar;
        this.className = str;
        this.zzaac = str2;
        this.b = zzbVar;
        this.zzaai = i;
        this.zzaaj = i2;
    }

    protected abstract void a();

    @Override // java.util.concurrent.Callable
    /* renamed from: zzcp, reason: merged with bridge method [inline-methods] */
    public Void call() {
        long nanoTime;
        try {
            nanoTime = System.nanoTime();
            this.c = this.a.zza(this.className, this.zzaac);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (this.c == null) {
            return null;
        }
        a();
        zzde zzcc = this.a.zzcc();
        if (zzcc != null && this.zzaai != Integer.MIN_VALUE) {
            zzcc.zza(this.zzaaj, this.zzaai, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
