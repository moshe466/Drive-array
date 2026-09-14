package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class zzqg implements Runnable {
    private final /* synthetic */ zzqh zzbpd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqg(zzqh zzqhVar) {
        this.zzbpd = zzqhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List list;
        obj = this.zzbpd.lock;
        synchronized (obj) {
            z = this.zzbpd.foreground;
            if (z) {
                z2 = this.zzbpd.zzbpe;
                if (z2) {
                    zzqh.a(this.zzbpd, false);
                    zzayu.zzea("App went background");
                    list = this.zzbpd.zzbpf;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            ((zzqj) it.next()).zzp(false);
                        } catch (Exception e) {
                            zzayu.zzc("", e);
                        }
                    }
                }
            }
            zzayu.zzea("App is still foreground");
        }
    }
}
