package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzfu {
    private static final String TAG = "zzfu";
    private final String className;
    private final String zzaac;
    private final Class<?>[] zzaaf;
    private final zzei zzuv;
    private final int zzaad = 2;
    private volatile Method zzaae = null;
    private CountDownLatch zzaag = new CountDownLatch(1);

    public zzfu(zzei zzeiVar, String str, String str2, Class<?>... clsArr) {
        this.zzuv = zzeiVar;
        this.className = str;
        this.zzaac = str2;
        this.zzaaf = clsArr;
        this.zzuv.zzbx().submit(new zzft(this));
    }

    private final String zzb(byte[] bArr, String str) {
        return new String(this.zzuv.zzbz().zza(bArr, str), HttpRequest.CHARSET_UTF8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcr() {
        try {
            try {
                Class loadClass = this.zzuv.zzby().loadClass(zzb(this.zzuv.zzca(), this.className));
                if (loadClass != null) {
                    this.zzaae = loadClass.getMethod(zzb(this.zzuv.zzca(), this.zzaac), this.zzaaf);
                    Method method = this.zzaae;
                }
            } finally {
                this.zzaag.countDown();
            }
        } catch (zzdv | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        }
    }

    public final Method zzcs() {
        if (this.zzaae != null) {
            return this.zzaae;
        }
        try {
            if (this.zzaag.await(2L, TimeUnit.SECONDS)) {
                return this.zzaae;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
