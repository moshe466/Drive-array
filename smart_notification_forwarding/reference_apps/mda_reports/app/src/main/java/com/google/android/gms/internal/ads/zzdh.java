package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdh implements Runnable {
    private final /* synthetic */ zzde zzvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdh(zzde zzdeVar) {
        this.zzvb = zzdeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        zzei zzeiVar;
        ConditionVariable conditionVariable2;
        if (this.zzvb.a != null) {
            return;
        }
        conditionVariable = zzde.zzuw;
        synchronized (conditionVariable) {
            if (this.zzvb.a != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = zzzn.zzckx.get().booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    zzeiVar = this.zzvb.zzuv;
                    zzde.b = new zzsr(zzeiVar.a, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.zzvb.a = Boolean.valueOf(z2);
            conditionVariable2 = zzde.zzuw;
            conditionVariable2.open();
        }
    }
}
