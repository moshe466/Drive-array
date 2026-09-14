package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzfo extends zzfw {
    private final StackTraceElement[] zzzz;

    public zzfo(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzeiVar, str, str2, zzbVar, i, 45);
        this.zzzz = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        StackTraceElement[] stackTraceElementArr = this.zzzz;
        if (stackTraceElementArr != null) {
            zzeg zzegVar = new zzeg((String) this.c.invoke(null, stackTraceElementArr));
            synchronized (this.b) {
                this.b.zzbi(zzegVar.zzxh.longValue());
                if (zzegVar.zzxi.booleanValue()) {
                    this.b.zzg(zzegVar.zzxj.booleanValue() ? zzcd.ENUM_FALSE : zzcd.ENUM_TRUE);
                } else {
                    this.b.zzg(zzcd.ENUM_FAILURE);
                }
            }
        }
    }
}
