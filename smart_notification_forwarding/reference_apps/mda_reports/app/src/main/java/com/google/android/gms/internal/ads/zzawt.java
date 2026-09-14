package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzawt {
    private Handler handler;
    private int state;
    private String zzbma;
    private String zzbqz;
    private String zzdhw;

    @Nullable
    private String zzdle;
    private int zzdtb;
    private PointF zzdtc;
    private PointF zzdtd;
    private Runnable zzdte;
    private final Context zzup;

    public zzawt(Context context) {
        this.state = 0;
        this.zzdte = new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzaws
            private final zzawt zzdta;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdta = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdta.c();
            }
        };
        this.zzup = context;
        this.zzdtb = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzq.zzle().zzxb();
        this.handler = com.google.android.gms.ads.internal.zzq.zzle().getHandler();
    }

    public zzawt(Context context, String str) {
        this(context);
        this.zzdhw = str;
    }

    private static int zza(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    private final boolean zza(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzdtc.x - f) < ((float) this.zzdtb) && Math.abs(this.zzdtc.y - f2) < ((float) this.zzdtb) && Math.abs(this.zzdtd.x - f3) < ((float) this.zzdtb) && Math.abs(this.zzdtd.y - f4) < ((float) this.zzdtb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        com.google.android.gms.ads.internal.zzq.zzla().zza(this.zzup, this.zzbqz, this.zzbma, this.zzdle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void a(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L9b
            android.content.Context r1 = r0.zzup
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto Le
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzayu.zzey(r1)
            return
        Le:
            java.lang.String r1 = r0.zzdhw
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzq.zzkq()
            java.util.Map r1 = com.google.android.gms.internal.ads.zzawb.zzi(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L3f
        L62:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            goto L73
        L71:
            java.lang.String r1 = "No debug information"
        L73:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.zzup
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            com.google.android.gms.internal.ads.zzawu r3 = new com.google.android.gms.internal.ads.zzawu
            r3.<init>(r0, r1)
            java.lang.String r1 = "Share"
            r2.setPositiveButton(r1, r3)
            android.content.DialogInterface$OnClickListener r1 = com.google.android.gms.internal.ads.zzawx.a
            java.lang.String r3 = "Close"
            r2.setNegativeButton(r3, r1)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L9b:
            if (r5 != r2) goto Lad
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzayu.zzea(r1)
            com.google.android.gms.internal.ads.zzdhd r1 = com.google.android.gms.internal.ads.zzazd.zzdwe
            com.google.android.gms.internal.ads.zzaww r2 = new com.google.android.gms.internal.ads.zzaww
            r2.<init>(r0)
            r1.execute(r2)
            return
        Lad:
            if (r5 != r3) goto Lbe
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzayu.zzea(r1)
            com.google.android.gms.internal.ads.zzdhd r1 = com.google.android.gms.internal.ads.zzazd.zzdwe
            com.google.android.gms.internal.ads.zzawz r2 = new com.google.android.gms.internal.ads.zzawz
            r2.<init>(r0)
            r1.execute(r2)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawt.a(int, int, int, android.content.DialogInterface, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzq.zzkq();
        zzawb.zza(this.zzup, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        com.google.android.gms.ads.internal.zzq.zzla().zze(this.zzup, this.zzbqz, this.zzbma);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.state = 4;
        showDialog();
    }

    public final void setAdUnitId(String str) {
        this.zzbqz = str;
    }

    public final void showDialog() {
        try {
            if (!(this.zzup instanceof Activity)) {
                zzayu.zzey("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzq.zzla().zzwx()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = com.google.android.gms.ads.internal.zzq.zzla().zzwy() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            final int zza = zza(arrayList, "Ad Information", true);
            final int zza2 = zza(arrayList, str, true);
            final int zza3 = zza(arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zzup, com.google.android.gms.ads.internal.zzq.zzks().zzwr());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, zza, zza2, zza3) { // from class: com.google.android.gms.internal.ads.zzawv
                private final zzawt zzdta;
                private final int zzdtf;
                private final int zzdtg;
                private final int zzdth;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdta = this;
                    this.zzdtf = zza;
                    this.zzdtg = zza2;
                    this.zzdth = zza3;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zzdta.a(this.zzdtf, this.zzdtg, this.zzdth, dialogInterface, i);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            zzavs.zza("", e);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzdhw);
        sb.append(",DebugSignal: ");
        sb.append(this.zzdle);
        sb.append(",AFMA Version: ");
        sb.append(this.zzbma);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzbqz);
        sb.append("}");
        return sb.toString();
    }

    public final void zzd(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.state = 0;
            this.zzdtc = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.state;
        if (i == -1) {
            return;
        }
        boolean z = true;
        if (i == 0 && actionMasked == 5) {
            this.state = 5;
            this.zzdtd = new PointF(motionEvent.getX(1), motionEvent.getY(1));
            this.handler.postDelayed(this.zzdte, ((Long) zzve.zzoy().zzd(zzzn.zzcnl)).longValue());
            return;
        }
        if (this.state == 5) {
            if (pointerCount == 2) {
                if (actionMasked == 2) {
                    boolean z2 = false;
                    for (int i2 = 0; i2 < historySize; i2++) {
                        if (!zza(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2))) {
                            z2 = true;
                        }
                    }
                    if (zza(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                        z = z2;
                    }
                } else {
                    z = false;
                }
            }
            if (z) {
                this.state = -1;
                this.handler.removeCallbacks(this.zzdte);
            }
        }
    }

    public final void zzeo(String str) {
        this.zzdhw = str;
    }

    public final void zzep(String str) {
        this.zzdle = str;
    }

    public final void zzx(String str) {
        this.zzbma = str;
    }
}
