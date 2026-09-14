package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class zzaan<T> {
    private final String zzcc;
    private final T zzcfu;
    private final int zzcsg;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public zzaan(String str, Object obj, int i) {
        this.zzcc = str;
        this.zzcfu = obj;
        this.zzcsg = i;
    }

    public static zzaan<Long> zzb(String str, long j) {
        return new zzaan<>(str, Long.valueOf(j), zzaap.zzcsi);
    }

    public static zzaan<Boolean> zzf(String str, boolean z) {
        return new zzaan<>(str, Boolean.valueOf(z), zzaap.zzcsh);
    }

    public static zzaan<String> zzi(String str, String str2) {
        return new zzaan<>(str, str2, zzaap.zzcsk);
    }

    public T get() {
        zzabo a = zzabn.a();
        if (a == null) {
            throw new IllegalStateException("Flag is not initialized.");
        }
        int i = zzaaq.a[this.zzcsg - 1];
        if (i == 1) {
            return (T) a.zze(this.zzcc, ((Boolean) this.zzcfu).booleanValue());
        }
        if (i == 2) {
            return (T) a.getLong(this.zzcc, ((Long) this.zzcfu).longValue());
        }
        if (i == 3) {
            return (T) a.zza(this.zzcc, ((Double) this.zzcfu).doubleValue());
        }
        if (i == 4) {
            return (T) a.get(this.zzcc, (String) this.zzcfu);
        }
        throw new IllegalStateException();
    }
}
