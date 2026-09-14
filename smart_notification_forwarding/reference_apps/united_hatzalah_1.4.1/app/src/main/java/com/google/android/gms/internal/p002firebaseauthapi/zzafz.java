package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import e0.a;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzafz extends zzaeg {
    private final String zza;
    private final /* synthetic */ zzafu zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzafz(zzafu zzafuVar, zzaeg zzaegVar, String str) {
        super(zzaegVar);
        this.zzb = zzafuVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zza(Status status) {
        Logger logger;
        HashMap hashMap;
        logger = zzafu.zza;
        logger.e(a.f("SMS verification code request failed: ", CommonStatusCodes.getStatusCodeString(status.getStatusCode()), StringUtils.SPACE, status.getStatusMessage()), new Object[0]);
        hashMap = this.zzb.zzd;
        zzagb zzagbVar = (zzagb) hashMap.get(this.zza);
        if (zzagbVar == null) {
            return;
        }
        Iterator<zzaeg> it = zzagbVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(status);
        }
        this.zzb.zzb(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb(String str) {
        Logger logger;
        HashMap hashMap;
        logger = zzafu.zza;
        logger.d("onCodeSent", new Object[0]);
        hashMap = this.zzb.zzd;
        zzagb zzagbVar = (zzagb) hashMap.get(this.zza);
        if (zzagbVar != null) {
            Iterator<zzaeg> it = zzagbVar.zzb.iterator();
            while (it.hasNext()) {
                it.next().zzb(str);
            }
            zzagbVar.zzg = true;
            zzagbVar.zzd = str;
            if (zzagbVar.zza <= 0) {
                this.zzb.zze(this.zza);
            } else if (!zzagbVar.zzc) {
                this.zzb.zzd(this.zza);
            } else if (!zzae.zzc(zzagbVar.zze)) {
                zzafu.zzb(this.zzb, this.zza);
            }
        }
    }
}
