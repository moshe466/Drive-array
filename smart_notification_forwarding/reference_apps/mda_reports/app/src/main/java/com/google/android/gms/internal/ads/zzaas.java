package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzaas<T> extends zzaan<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    public zzaas(String str, Object obj, int i) {
        super(str, obj, i);
    }

    public static zzaan<Boolean> zzf(String str, boolean z) {
        return new zzaas(str, true, zzaap.zzcsh);
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final T get() {
        if (zzabn.a.get()) {
            return (T) super.get();
        }
        throw new IllegalStateException("Striped code is accessed: 54c42518-856a-44fb-aae0-cd6676d514e5");
    }
}
