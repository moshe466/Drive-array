package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcbp {
    private final zzato zzbkt;
    private final zzdq zzefv;
    private final Executor zzfci;
    private final zzbpm zzfgg;
    private final zzbqj zzfjf;
    private final zzboq zzfke;
    private final zzbjd zzfkf;
    private final zzbst zzfkh;
    private final zzbqa zzfqp;
    private final zzbra zzfqq;
    private final com.google.android.gms.ads.internal.zzc zzfrf;
    private final zzbpg zzfrg;
    private final zzbqw zzfrh;

    public zzcbp(zzboq zzboqVar, zzbpm zzbpmVar, zzbqa zzbqaVar, zzbqj zzbqjVar, zzbra zzbraVar, Executor executor, zzbst zzbstVar, zzbjd zzbjdVar, com.google.android.gms.ads.internal.zzc zzcVar, zzbpg zzbpgVar, @Nullable zzato zzatoVar, zzdq zzdqVar, zzbqw zzbqwVar) {
        this.zzfke = zzboqVar;
        this.zzfgg = zzbpmVar;
        this.zzfqp = zzbqaVar;
        this.zzfjf = zzbqjVar;
        this.zzfqq = zzbraVar;
        this.zzfci = executor;
        this.zzfkh = zzbstVar;
        this.zzfkf = zzbjdVar;
        this.zzfrf = zzcVar;
        this.zzfrg = zzbpgVar;
        this.zzbkt = zzatoVar;
        this.zzefv = zzdqVar;
        this.zzfrh = zzbqwVar;
    }

    public static zzdhe<?> zza(zzbdi zzbdiVar, String str, String str2) {
        final zzazl zzazlVar = new zzazl();
        zzbdiVar.zzaaa().zza(new zzbeu(zzazlVar) { // from class: com.google.android.gms.internal.ads.zzcca
            private final zzazl zzbru;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbru = zzazlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbeu
            public final void zzak(boolean z) {
                zzazl zzazlVar2 = this.zzbru;
                if (z) {
                    zzazlVar2.set(null);
                } else {
                    zzazlVar2.setException(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzbdiVar.zzb(str, str2, null);
        return zzazlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.zzfgg.onAdLeftApplication();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(View view) {
        this.zzfrf.recordClick();
        zzato zzatoVar = this.zzbkt;
        if (zzatoVar != null) {
            zzatoVar.zzum();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbdi zzbdiVar, zzbdi zzbdiVar2, Map map) {
        this.zzfkf.zzf(zzbdiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, String str2) {
        this.zzfqq.onAppEvent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        this.zzfrf.recordClick();
        zzato zzatoVar = this.zzbkt;
        if (zzatoVar == null) {
            return false;
        }
        zzatoVar.zzum();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        this.zzfke.onAdClicked();
    }

    public final void zzb(final zzbdi zzbdiVar, boolean z) {
        zzdg zzbw;
        zzbdiVar.zzaaa().zza(new zzty(this) { // from class: com.google.android.gms.internal.ads.zzcbs
            private final zzcbp zzfrj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfrj = this;
            }

            @Override // com.google.android.gms.internal.ads.zzty
            public final void onAdClicked() {
                this.zzfrj.b();
            }
        }, this.zzfqp, this.zzfjf, new zzaey(this) { // from class: com.google.android.gms.internal.ads.zzcbr
            private final zzcbp zzfrj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfrj = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaey
            public final void onAppEvent(String str, String str2) {
                this.zzfrj.a(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzt(this) { // from class: com.google.android.gms.internal.ads.zzcbu
            private final zzcbp zzfrj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfrj = this;
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzt
            public final void zztv() {
                this.zzfrj.a();
            }
        }, z, null, this.zzfrf, new zzcbz(this), this.zzbkt);
        zzbdiVar.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.gms.internal.ads.zzcbt
            private final zzcbp zzfrj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfrj = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.zzfrj.a(view, motionEvent);
            }
        });
        zzbdiVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.gms.internal.ads.zzcbw
            private final zzcbp zzfrj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfrj = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.zzfrj.a(view);
            }
        });
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzclc)).booleanValue() && (zzbw = this.zzefv.zzbw()) != null) {
            zzbw.zzb(zzbdiVar.getView());
        }
        this.zzfkh.zza(zzbdiVar, this.zzfci);
        this.zzfkh.zza(new zzps(zzbdiVar) { // from class: com.google.android.gms.internal.ads.zzcbv
            private final zzbdi zzehp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehp = zzbdiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzps
            public final void zza(zzpt zzptVar) {
                zzbev zzaaa = this.zzehp.zzaaa();
                Rect rect = zzptVar.zzbob;
                zzaaa.zza(rect.left, rect.top, false);
            }
        }, this.zzfci);
        this.zzfkh.zzq(zzbdiVar.getView());
        zzbdiVar.zza("/trackActiveViewUnit", new zzafn(this, zzbdiVar) { // from class: com.google.android.gms.internal.ads.zzcby
            private final zzbdi zzfpv;
            private final zzcbp zzfrj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfrj = this;
                this.zzfpv = zzbdiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                this.zzfrj.a(this.zzfpv, (zzbdi) obj, map);
            }
        });
        this.zzfkf.zzo(zzbdiVar);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzciv)).booleanValue()) {
            return;
        }
        zzbpg zzbpgVar = this.zzfrg;
        zzbdiVar.getClass();
        zzbpgVar.zza(zzcbx.a(zzbdiVar), this.zzfci);
    }
}
