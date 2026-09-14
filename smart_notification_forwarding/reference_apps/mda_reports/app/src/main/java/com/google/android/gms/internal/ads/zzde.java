package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbm;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public class zzde {

    @VisibleForTesting
    protected volatile Boolean a;
    private zzei zzuv;
    private static final ConditionVariable zzuw = new ConditionVariable();

    @VisibleForTesting
    protected static volatile zzsr b = null;
    private static volatile Random zzuz = null;

    public zzde(zzei zzeiVar) {
        this.zzuv = zzeiVar;
        zzeiVar.zzbx().execute(new zzdh(this));
    }

    public static int zzbr() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzbs().nextInt();
        } catch (RuntimeException unused) {
            return zzbs().nextInt();
        }
    }

    private static Random zzbs() {
        if (zzuz == null) {
            synchronized (zzde.class) {
                if (zzuz == null) {
                    zzuz = new Random();
                }
            }
        }
        return zzuz;
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, null, null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzuw.block();
            if (!this.a.booleanValue() || b == null) {
                return;
            }
            zzbm.zza.C0009zza zzc = zzbm.zza.zzs().zzi(this.zzuv.a.getPackageName()).zzc(j);
            if (str != null) {
                zzc.zzl(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzdpt.zza(exc, new PrintWriter(stringWriter));
                zzc.zzj(stringWriter.toString()).zzk(exc.getClass().getName());
            }
            zzsv zzf = b.zzf(((zzbm.zza) ((zzdrt) zzc.zzbaf())).toByteArray());
            zzf.zzbr(i);
            if (i2 != -1) {
                zzf.zzbq(i2);
            }
            zzf.zzdn();
        } catch (Exception unused) {
        }
    }
}
