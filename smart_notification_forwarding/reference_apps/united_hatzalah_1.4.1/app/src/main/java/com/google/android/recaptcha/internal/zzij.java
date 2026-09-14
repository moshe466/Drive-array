package com.google.android.recaptcha.internal;

import P2.C0169t;
import P2.InterfaceC0168s;
import android.webkit.JavascriptInterface;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import s2.C0684i;

/* loaded from: classes.dex */
public final class zzij {
    final /* synthetic */ zzja zza;
    private Long zzb;
    private final zzjh zzc = zzjh.zzb();

    public zzij(zzja zzjaVar) {
        this.zza = zzjaVar;
    }

    private final void zzb() {
        if (this.zzb == null) {
            this.zzc.zzf();
            this.zzb = Long.valueOf(this.zzc.zza(TimeUnit.MILLISECONDS));
        }
    }

    public final Long zza() {
        return this.zzb;
    }

    @JavascriptInterface
    public final void zzlce(String str) {
        zzek zzekVar;
        zzen zzenVar;
        zzja zzjaVar = this.zza;
        if (zzjaVar.zzq().zzb == null) {
            zzenVar = zzjaVar.zzp;
            if (zzenVar != null) {
                zzenVar.zza();
            }
            this.zza.zzp = null;
        }
        zzb();
        zzrc zzl = zzrc.zzl(zzbt.zza(str));
        zztw zzi = zztx.zzi();
        zzi.zzf(zzl);
        zztx zztxVar = (zztx) zzi.zzk();
        zzekVar = this.zza.zzj;
        zzekVar.zze(zztxVar);
    }

    @JavascriptInterface
    public final void zzlsm(String str) {
        zzek zzekVar;
        zzb();
        zztw zzi = zztx.zzi();
        zzi.zzq(zzrr.zzi(zzbt.zza(str)));
        zztx zztxVar = (zztx) zzi.zzk();
        zzekVar = this.zza.zzj;
        zzekVar.zze(zztxVar);
    }

    @JavascriptInterface
    public final void zzoid(String str) {
        zzb();
        zzts zzg = zzts.zzg(zzbt.zza(str));
        zzg.zzi().name();
        if (zzg.zzi() == zztv.JS_CODE_SUCCESS) {
            this.zza.zzA().hashCode();
            if (!((C0169t) this.zza.zzA()).D(C0684i.f6340a)) {
                this.zza.zzA().hashCode();
                return;
            }
            return;
        }
        zzg.zzi().name();
        int i = zzbd.zza;
        zzbd zza = zzbc.zza(zzg.zzi());
        this.zza.zzA().hashCode();
        ((C0169t) this.zza.zzA()).P(zza);
    }

    @JavascriptInterface
    public final void zzrp(String str) {
        zzb();
        zzfo zzfoVar = this.zza.zzb;
        if (zzfoVar == null) {
            zzfoVar = null;
        }
        zzfoVar.zza(str);
    }

    @JavascriptInterface
    public final void zzscd(String str) {
        Map map;
        zzb();
        zzsi zzi = zzsi.zzi(zzbt.zza(str));
        zzi.toString();
        map = this.zza.zze;
        InterfaceC0168s interfaceC0168s = (InterfaceC0168s) map.remove(zzi.zzk());
        if (interfaceC0168s != null) {
            ((C0169t) interfaceC0168s).D(zzi);
        }
    }
}
