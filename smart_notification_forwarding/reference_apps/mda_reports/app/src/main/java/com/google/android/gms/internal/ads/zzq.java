package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzag;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class zzq<T> implements Comparable<zzq<T>> {
    private final Object mLock;
    private final zzag.zza zzae;
    private final int zzaf;
    private final String zzag;
    private final int zzah;

    @Nullable
    @GuardedBy("mLock")
    private zzy zzai;
    private Integer zzaj;
    private zzu zzak;
    private boolean zzal;

    @GuardedBy("mLock")
    private boolean zzam;

    @GuardedBy("mLock")
    private boolean zzan;
    private boolean zzao;
    private zzad zzap;
    private zzd zzaq;

    @GuardedBy("mLock")
    private zzs zzar;

    public zzq(int i, String str, @Nullable zzy zzyVar) {
        Uri parse;
        String host;
        this.zzae = zzag.zza.zzbl ? new zzag.zza() : null;
        this.mLock = new Object();
        this.zzal = true;
        int i2 = 0;
        this.zzam = false;
        this.zzan = false;
        this.zzao = false;
        this.zzaq = null;
        this.zzaf = i;
        this.zzag = str;
        this.zzai = zzyVar;
        this.zzap = new zzg();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.zzah = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzz<T> a(zzo zzoVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        zzs zzsVar;
        synchronized (this.mLock) {
            zzsVar = this.zzar;
        }
        if (zzsVar != null) {
            zzsVar.zza(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        zzu zzuVar = this.zzak;
        if (zzuVar != null) {
            zzuVar.a(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzs zzsVar) {
        synchronized (this.mLock) {
            this.zzar = zzsVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzz<?> zzzVar) {
        zzs zzsVar;
        synchronized (this.mLock) {
            zzsVar = this.zzar;
        }
        if (zzsVar != null) {
            zzsVar.zza(this, zzzVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        zzu zzuVar = this.zzak;
        if (zzuVar != null) {
            zzuVar.a(this);
        }
        if (zzag.zza.zzbl) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzt(this, str, id));
            } else {
                this.zzae.zza(str, id);
                this.zzae.zzc(toString());
            }
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzq zzqVar = (zzq) obj;
        zzv zzvVar = zzv.NORMAL;
        return zzvVar == zzvVar ? this.zzaj.intValue() - zzqVar.zzaj.intValue() : zzvVar.ordinal() - zzvVar.ordinal();
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzaf;
    }

    public final String getUrl() {
        return this.zzag;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzah));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        isCanceled();
        String str = this.zzag;
        String valueOf2 = String.valueOf(zzv.NORMAL);
        String valueOf3 = String.valueOf(this.zzaj);
        StringBuilder sb = new StringBuilder("[ ] ".length() + 3 + String.valueOf(str).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(concat);
        sb.append(" ");
        sb.append(valueOf2);
        sb.append(" ");
        sb.append(valueOf3);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzq<?> zza(zzd zzdVar) {
        this.zzaq = zzdVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzq<?> zza(zzu zzuVar) {
        this.zzak = zzuVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzq<?> zzb(int i) {
        this.zzaj = Integer.valueOf(i);
        return this;
    }

    public final void zzb(zzae zzaeVar) {
        zzy zzyVar;
        synchronized (this.mLock) {
            zzyVar = this.zzai;
        }
        if (zzyVar != null) {
            zzyVar.zzc(zzaeVar);
        }
    }

    public final void zzb(String str) {
        if (zzag.zza.zzbl) {
            this.zzae.zza(str, Thread.currentThread().getId());
        }
    }

    public final int zzc() {
        return this.zzah;
    }

    public final String zzd() {
        String str = this.zzag;
        int i = this.zzaf;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final zzd zze() {
        return this.zzaq;
    }

    public byte[] zzf() {
        return null;
    }

    public final boolean zzg() {
        return this.zzal;
    }

    public final int zzh() {
        return this.zzap.zza();
    }

    public final zzad zzi() {
        return this.zzap;
    }

    public final void zzj() {
        synchronized (this.mLock) {
            this.zzan = true;
        }
    }

    public final boolean zzk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzan;
        }
        return z;
    }
}
