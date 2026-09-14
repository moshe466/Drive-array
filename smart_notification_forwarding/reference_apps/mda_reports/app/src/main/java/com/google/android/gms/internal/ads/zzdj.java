package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.internal.ads.zzbo;
import com.google.android.gms.internal.ads.zzbs;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class zzdj implements zzdg {
    protected static volatile zzei q;
    protected MotionEvent a;
    protected double j;
    protected float k;
    protected float l;
    protected float m;
    protected float n;
    protected DisplayMetrics p;
    private double zzvw;
    private double zzvx;
    protected LinkedList<MotionEvent> b = new LinkedList<>();
    protected long c = 0;
    protected long d = 0;
    protected long e = 0;
    protected long f = 0;
    protected long g = 0;
    protected long h = 0;
    protected long i = 0;
    private boolean zzwc = false;
    protected boolean o = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdj(Context context) {
        try {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzclj)).booleanValue()) {
                zzck.a();
            } else {
                zzeo.a(q);
            }
            this.p = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzde zzdeVar;
        String str2;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzve.zzoy().zzd(zzzn.zzcky)).booleanValue();
        zzbs.zza.zzb zzbVar = null;
        if (booleanValue) {
            zzdeVar = q != null ? q.zzcc() : null;
            str2 = ((Boolean) zzve.zzoy().zzd(zzzn.zzclj)).booleanValue() ? "be" : "te";
        } else {
            zzdeVar = null;
            str2 = null;
        }
        try {
            if (i == zzee.zzxf) {
                zzbVar = b(context, view, activity);
                this.zzwc = true;
                i2 = PointerIconCompat.TYPE_HAND;
            } else if (i == zzee.zzxe) {
                zzbVar = a(context, view, activity);
                i2 = PointerIconCompat.TYPE_TEXT;
            } else {
                zzbVar = a(context, null);
                i2 = 1000;
            }
            if (booleanValue && zzdeVar != null) {
                zzdeVar.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            if (booleanValue && zzdeVar != null) {
                zzdeVar.zza(i == zzee.zzxf ? PointerIconCompat.TYPE_HELP : i == zzee.zzxe ? PointerIconCompat.TYPE_VERTICAL_TEXT : i == zzee.zzxd ? PointerIconCompat.TYPE_CONTEXT_MENU : -1, -1, System.currentTimeMillis() - currentTimeMillis, str2, e);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zzbVar != null) {
            try {
                if (((zzbs.zza) ((zzdrt) zzbVar.zzbaf())).zzazu() != 0) {
                    String a = zzck.a((zzbs.zza) ((zzdrt) zzbVar.zzbaf()), str);
                    if (!booleanValue || zzdeVar == null) {
                        return a;
                    }
                    zzdeVar.zza(i == zzee.zzxf ? PointerIconCompat.TYPE_CELL : i == zzee.zzxe ? PointerIconCompat.TYPE_ALIAS : i == zzee.zzxd ? PointerIconCompat.TYPE_WAIT : -1, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return a;
                }
            } catch (Exception e2) {
                String num = Integer.toString(7);
                if (!booleanValue || zzdeVar == null) {
                    return num;
                }
                zzdeVar.zza(i == zzee.zzxf ? PointerIconCompat.TYPE_CROSSHAIR : i == zzee.zzxe ? PointerIconCompat.TYPE_COPY : i == zzee.zzxd ? 1005 : -1, -1, System.currentTimeMillis() - currentTimeMillis2, str2, e2);
                return num;
            }
        }
        return Integer.toString(5);
    }

    private final void zzbv() {
        this.g = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.h = 0L;
        this.i = 0L;
        if (this.b.size() > 0) {
            Iterator<MotionEvent> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.b.clear();
        } else {
            MotionEvent motionEvent = this.a;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.a = null;
    }

    protected abstract long a(StackTraceElement[] stackTraceElementArr);

    protected abstract zzbs.zza.zzb a(Context context, View view, Activity activity);

    protected abstract zzbs.zza.zzb a(Context context, zzbo.zza zzaVar);

    protected abstract zzeq a(MotionEvent motionEvent);

    protected abstract zzbs.zza.zzb b(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzdg
    public String zza(Context context, View view, Activity activity) {
        return zza(context, null, zzee.zzxe, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzee.zzxf, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public void zza(int i, int i2, int i3) {
        MotionEvent motionEvent;
        if (this.a != null) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzckw)).booleanValue()) {
                zzbv();
            } else {
                this.a.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.p;
        if (displayMetrics != null) {
            float f = displayMetrics.density;
            motionEvent = MotionEvent.obtain(0L, i3, 1, i * f, i2 * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            motionEvent = null;
        }
        this.a = motionEvent;
        this.o = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzwc) {
            zzbv();
            this.zzwc = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.j = 0.0d;
            this.zzvw = motionEvent.getRawX();
            this.zzvx = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d = this.zzvw;
            Double.isNaN(rawX);
            double d2 = rawX - d;
            double d3 = this.zzvx;
            Double.isNaN(rawY);
            double d4 = rawY - d3;
            this.j += Math.sqrt((d2 * d2) + (d4 * d4));
            this.zzvw = rawX;
            this.zzvx = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    this.a = MotionEvent.obtain(motionEvent);
                    this.b.add(this.a);
                    if (this.b.size() > 6) {
                        this.b.remove().recycle();
                    }
                    this.e++;
                    this.g = a(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.d += motionEvent.getHistorySize() + 1;
                    zzeq a = a(motionEvent);
                    if ((a == null || a.zzym == null || a.zzyp == null) ? false : true) {
                        this.h += a.zzym.longValue() + a.zzyp.longValue();
                    }
                    if (this.p != null && a != null && a.zzyn != null && a.zzyq != null) {
                        z = true;
                    }
                    if (z) {
                        this.i += a.zzyn.longValue() + a.zzyq.longValue();
                    }
                } else if (action2 == 3) {
                    this.f++;
                }
            } catch (zzeh unused) {
            }
        } else {
            this.k = motionEvent.getX();
            this.l = motionEvent.getY();
            this.m = motionEvent.getRawX();
            this.n = motionEvent.getRawY();
            this.c++;
        }
        this.o = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public String zzb(Context context) {
        if (zzep.isMainThread()) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcll)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, zzee.zzxd, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdg
    public void zzb(View view) {
    }
}
