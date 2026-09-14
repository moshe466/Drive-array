package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbwk extends zzbmd {
    private final zzazb zzbll;
    private final zzdq zzefv;
    private final Executor zzfci;
    private final zzbwz zzfea;
    private final zzats zzffo;
    private final zzbws zzfkc;
    private final zzbxa zzflg;
    private final zzbxj zzflh;
    private final zzbww zzfli;
    private final zzdxa<zzcab> zzflj;
    private final zzdxa<zzbzz> zzflk;
    private final zzdxa<zzcai> zzfll;
    private final zzdxa<zzbzv> zzflm;
    private final zzdxa<zzcad> zzfln;
    private zzbxz zzflo;
    private boolean zzflp;
    private final zzbwq zzflq;
    private final Context zzup;

    public zzbwk(zzbmg zzbmgVar, Executor executor, zzbws zzbwsVar, zzbxa zzbxaVar, zzbxj zzbxjVar, zzbww zzbwwVar, zzbwz zzbwzVar, zzdxa<zzcab> zzdxaVar, zzdxa<zzbzz> zzdxaVar2, zzdxa<zzcai> zzdxaVar3, zzdxa<zzbzv> zzdxaVar4, zzdxa<zzcad> zzdxaVar5, zzats zzatsVar, zzdq zzdqVar, zzazb zzazbVar, Context context, zzbwq zzbwqVar) {
        super(zzbmgVar);
        this.zzfci = executor;
        this.zzfkc = zzbwsVar;
        this.zzflg = zzbxaVar;
        this.zzflh = zzbxjVar;
        this.zzfli = zzbwwVar;
        this.zzfea = zzbwzVar;
        this.zzflj = zzdxaVar;
        this.zzflk = zzdxaVar2;
        this.zzfll = zzdxaVar3;
        this.zzflm = zzdxaVar4;
        this.zzfln = zzdxaVar5;
        this.zzffo = zzatsVar;
        this.zzefv = zzdqVar;
        this.zzbll = zzazbVar;
        this.zzup = context;
        this.zzflq = zzbwqVar;
    }

    public static boolean zzy(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.zzflg.destroy();
        this.zzfkc.destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z) {
        this.zzflg.zza(this.zzflo.zzaga(), this.zzflo.zzajz(), this.zzflo.zzaka(), z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        try {
            int zzaja = this.zzfkc.zzaja();
            if (zzaja == 1) {
                if (this.zzfea.zzajp() != null) {
                    zzg("Google", true);
                    this.zzfea.zzajp().zza(this.zzflj.get());
                    return;
                }
                return;
            }
            if (zzaja == 2) {
                if (this.zzfea.zzajq() != null) {
                    zzg("Google", true);
                    this.zzfea.zzajq().zza(this.zzflk.get());
                    return;
                }
                return;
            }
            if (zzaja == 3) {
                if (this.zzfea.zzfz(this.zzfkc.getCustomTemplateId()) != null) {
                    if (this.zzfkc.zzajf() != null) {
                        zzg("Google", true);
                    }
                    this.zzfea.zzfz(this.zzfkc.getCustomTemplateId()).zzb(this.zzfln.get());
                    return;
                }
                return;
            }
            if (zzaja == 6) {
                if (this.zzfea.zzajr() != null) {
                    zzg("Google", true);
                    this.zzfea.zzajr().zza(this.zzfll.get());
                    return;
                }
                return;
            }
            if (zzaja != 7) {
                zzayu.zzex("Wrong native template id!");
            } else if (this.zzfea.zzajt() != null) {
                this.zzfea.zzajt().zza(this.zzflm.get());
            }
        } catch (RemoteException e) {
            zzayu.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzflg.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzbmd
    public final synchronized void destroy() {
        this.zzfci.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbwl
            private final zzbwk zzflf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzflf = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzflf.a();
            }
        });
        super.destroy();
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzflg.isCustomClickGestureEnabled();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzflo == null) {
            zzayu.zzea("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = this.zzflo instanceof zzbxi;
            this.zzfci.execute(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.zzbwo
                private final boolean zzdym;
                private final zzbwk zzflf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzflf = this;
                    this.zzdym = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzflf.a(this.zzdym);
                }
            });
        }
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzflg.setClickConfirmingView(view);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzflg.zza(view, motionEvent, view2);
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqc)).booleanValue()) {
            this.zzflh.zzc(this.zzflo);
        }
        this.zzflg.zza(view, view2, map, map2, z);
    }

    public final synchronized void zza(zzaeb zzaebVar) {
        this.zzflg.zza(zzaebVar);
    }

    public final synchronized void zza(zzbxz zzbxzVar) {
        zzdg zzbw;
        this.zzflo = zzbxzVar;
        this.zzflh.zza(zzbxzVar);
        this.zzflg.zza(zzbxzVar.zzaga(), zzbxzVar.zzaka(), zzbxzVar.zzakb(), zzbxzVar, zzbxzVar);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzclc)).booleanValue() && (zzbw = this.zzefv.zzbw()) != null) {
            zzbw.zzb(zzbxzVar.zzaga());
        }
        if (zzbxzVar.zzake() != null) {
            zzbxzVar.zzake().zza(this.zzffo);
        }
    }

    public final synchronized void zza(zzwn zzwnVar) {
        this.zzflg.zza(zzwnVar);
    }

    public final synchronized void zza(@Nullable zzwr zzwrVar) {
        this.zzflg.zza(zzwrVar);
    }

    public final void zzaa(View view) {
        IObjectWrapper zzajh = this.zzfkc.zzajh();
        if (!this.zzfli.zzaiw() || zzajh == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzlf().zzb(zzajh, view);
    }

    @Override // com.google.android.gms.internal.ads.zzbmd
    @AnyThread
    public final void zzagf() {
        this.zzfci.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbwj
            private final zzbwk zzflf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzflf = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzflf.b();
            }
        });
        if (this.zzfkc.zzaja() != 7) {
            Executor executor = this.zzfci;
            zzbxa zzbxaVar = this.zzflg;
            zzbxaVar.getClass();
            executor.execute(zzbwm.a(zzbxaVar));
        }
        super.zzagf();
    }

    public final synchronized void zzaio() {
        if (this.zzflp) {
            return;
        }
        this.zzflg.zzaio();
    }

    public final boolean zzaiv() {
        return this.zzfli.zzajn();
    }

    public final boolean zzaiw() {
        return this.zzfli.zzaiw();
    }

    public final zzbwq zzaix() {
        return this.zzflq;
    }

    public final synchronized void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.zzflp) {
            return;
        }
        if (z) {
            this.zzflg.zza(view, map, map2);
            this.zzflp = true;
            return;
        }
        if (!z) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcmi)).booleanValue() && map != null) {
                Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    View view2 = it.next().getValue().get();
                    if (view2 != null && zzy(view2)) {
                        this.zzflg.zza(view, map, map2);
                        this.zzflp = true;
                        return;
                    }
                }
            }
        }
    }

    public final synchronized void zzb(zzbxz zzbxzVar) {
        this.zzflg.zza(zzbxzVar.zzaga(), zzbxzVar.zzajz());
        if (zzbxzVar.zzakd() != null) {
            zzbxzVar.zzakd().setClickable(false);
            zzbxzVar.zzakd().removeAllViews();
        }
        if (zzbxzVar.zzake() != null) {
            zzbxzVar.zzake().zzb(this.zzffo);
        }
        this.zzflo = null;
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzflg.zzf(bundle);
    }

    public final synchronized void zzfu(String str) {
        this.zzflg.zzfu(str);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzflg.zzg(bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzbww r0 = r10.zzfli
            boolean r0 = r0.zzaiw()
            if (r0 != 0) goto L9
            return
        L9:
            com.google.android.gms.internal.ads.zzbws r0 = r10.zzfkc
            com.google.android.gms.internal.ads.zzbdi r0 = r0.zzajg()
            com.google.android.gms.internal.ads.zzbws r1 = r10.zzfkc
            com.google.android.gms.internal.ads.zzbdi r1 = r1.zzajf()
            if (r0 != 0) goto L1a
            if (r1 != 0) goto L1a
            return
        L1a:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L20
            r4 = 1
            goto L21
        L20:
            r4 = 0
        L21:
            if (r1 == 0) goto L24
            goto L25
        L24:
            r2 = 0
        L25:
            r3 = 0
            if (r4 == 0) goto L2a
        L28:
            r8 = r3
            goto L32
        L2a:
            if (r2 == 0) goto L30
            java.lang.String r3 = "javascript"
            r0 = r1
            goto L28
        L30:
            r0 = r3
            r8 = r0
        L32:
            android.webkit.WebView r3 = r0.getWebView()
            if (r3 != 0) goto L39
            return
        L39:
            com.google.android.gms.internal.ads.zzaoq r3 = com.google.android.gms.ads.internal.zzq.zzlf()
            android.content.Context r4 = r10.zzup
            boolean r3 = r3.zzp(r4)
            if (r3 == 0) goto L95
            com.google.android.gms.internal.ads.zzazb r3 = r10.zzbll
            int r4 = r3.zzdvz
            int r3 = r3.zzdwa
            r5 = 23
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r4)
            java.lang.String r4 = "."
            r6.append(r4)
            r6.append(r3)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzaoq r3 = com.google.android.gms.ads.internal.zzq.zzlf()
            android.webkit.WebView r5 = r0.getWebView()
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            r9 = r11
            com.google.android.gms.dynamic.IObjectWrapper r11 = r3.zza(r4, r5, r6, r7, r8, r9)
            if (r11 != 0) goto L75
            return
        L75:
            com.google.android.gms.internal.ads.zzbws r3 = r10.zzfkc
            r3.zzaq(r11)
            r0.zzan(r11)
            if (r2 == 0) goto L8c
            android.view.View r0 = r1.getView()
            if (r0 == 0) goto L8c
            com.google.android.gms.internal.ads.zzaoq r1 = com.google.android.gms.ads.internal.zzq.zzlf()
            r1.zza(r11, r0)
        L8c:
            if (r12 == 0) goto L95
            com.google.android.gms.internal.ads.zzaoq r12 = com.google.android.gms.ads.internal.zzq.zzlf()
            r12.zzab(r11)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwk.zzg(java.lang.String, boolean):void");
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.zzflp) {
            return true;
        }
        boolean zzh = this.zzflg.zzh(bundle);
        this.zzflp = zzh;
        return zzh;
    }

    public final synchronized void zzrp() {
        this.zzflg.zzrp();
    }

    public final void zzz(View view) {
        IObjectWrapper zzajh = this.zzfkc.zzajh();
        boolean z = this.zzfkc.zzajg() != null;
        if (!this.zzfli.zzaiw() || zzajh == null || !z || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzq.zzlf().zza(zzajh, view);
    }
}
