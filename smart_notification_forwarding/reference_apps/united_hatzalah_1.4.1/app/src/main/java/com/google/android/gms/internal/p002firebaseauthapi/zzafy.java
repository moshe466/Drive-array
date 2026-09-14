package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzafy extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzafu zzb;

    public zzafy(zzafu zzafuVar, String str) {
        this.zzb = zzafuVar;
        this.zza = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        HashMap hashMap;
        Logger logger;
        Logger logger2;
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                hashMap = this.zzb.zzd;
                zzagb zzagbVar = (zzagb) hashMap.get(this.zza);
                if (zzagbVar == null) {
                    logger2 = zzafu.zza;
                    logger2.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    String zza = zzafu.zza(str);
                    zzagbVar.zze = zza;
                    if (zza == null) {
                        logger = zzafu.zza;
                        logger.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzae.zzc(zzagbVar.zzd)) {
                        zzafu.zzb(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
