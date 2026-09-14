package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes.dex */
final class zzavb implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzazl zzdpv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavb(zzauy zzauyVar, Context context, zzazl zzazlVar) {
        this.val$context = context;
        this.zzdpv = zzazlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzdpv.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzdpv.setException(e);
            zzayu.zzc("Exception while getting advertising Id info", e);
        }
    }
}
