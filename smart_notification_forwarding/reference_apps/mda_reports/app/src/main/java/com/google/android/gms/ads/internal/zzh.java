package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzayk;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzazd;
import com.google.android.gms.internal.ads.zzdg;
import com.google.android.gms.internal.ads.zzdr;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzzn;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzh implements zzdg, Runnable {
    private zzazb zzbli;
    private Context zzup;
    private final List<Object[]> zzblg = new Vector();
    private final AtomicReference<zzdg> zzblh = new AtomicReference<>();
    private CountDownLatch zzblj = new CountDownLatch(1);

    public zzh(Context context, zzazb zzazbVar) {
        this.zzup = context;
        this.zzbli = zzazbVar;
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzclm)).booleanValue()) {
            zzve.zzou();
            if (!zzayk.zzxe()) {
                run();
                return;
            }
        }
        zzazd.zzdwe.execute(this);
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean zzjt() {
        try {
            this.zzblj.await();
            return true;
        } catch (InterruptedException e) {
            zzayu.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzju() {
        if (this.zzblg.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.zzblg) {
            if (objArr.length == 1) {
                this.zzblh.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.zzblh.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzblg.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbli.zzdwb;
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcjf)).booleanValue() && z2) {
                z = true;
            }
            this.zzblh.set(zzdr.zza(this.zzbli.zzbma, zze(this.zzup), z));
        } finally {
            this.zzblj.countDown();
            this.zzup = null;
            this.zzbli = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final String zza(Context context, View view, Activity activity) {
        zzdg zzdgVar = this.zzblh.get();
        return zzdgVar != null ? zzdgVar.zza(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final String zza(Context context, String str, View view, Activity activity) {
        zzdg zzdgVar;
        if (!zzjt() || (zzdgVar = this.zzblh.get()) == null) {
            return "";
        }
        zzju();
        return zzdgVar.zza(zze(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final void zza(int i, int i2, int i3) {
        zzdg zzdgVar = this.zzblh.get();
        if (zzdgVar == null) {
            this.zzblg.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            zzju();
            zzdgVar.zza(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final void zza(MotionEvent motionEvent) {
        zzdg zzdgVar = this.zzblh.get();
        if (zzdgVar == null) {
            this.zzblg.add(new Object[]{motionEvent});
        } else {
            zzju();
            zzdgVar.zza(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final String zzb(Context context) {
        zzdg zzdgVar;
        if (!zzjt() || (zzdgVar = this.zzblh.get()) == null) {
            return "";
        }
        zzju();
        return zzdgVar.zzb(zze(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final void zzb(View view) {
        zzdg zzdgVar = this.zzblh.get();
        if (zzdgVar != null) {
            zzdgVar.zzb(view);
        }
    }
}
