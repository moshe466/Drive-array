package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbxq implements View.OnClickListener {

    @Nullable
    @VisibleForTesting
    String a;

    @Nullable
    @VisibleForTesting
    Long b;

    @Nullable
    @VisibleForTesting
    WeakReference<View> c;
    private final Clock zzbmq;
    private final zzcaj zzfnx;

    @Nullable
    private zzaeb zzfny;

    @Nullable
    private zzafn<Object> zzfnz;

    public zzbxq(zzcaj zzcajVar, Clock clock) {
        this.zzfnx = zzcajVar;
        this.zzbmq = clock;
    }

    private final void zzaki() {
        View view;
        this.a = null;
        this.b = null;
        WeakReference<View> weakReference = this.c;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.c = null;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfny == null || this.b == null) {
            return;
        }
        zzaki();
        try {
            this.zzfny.onUnconfirmedClickCancelled();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference<View> weakReference = this.c;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.a != null && this.b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.a);
            hashMap.put("time_interval", String.valueOf(this.zzbmq.currentTimeMillis() - this.b.longValue()));
            hashMap.put("messageType", "onePointFiveClick");
            this.zzfnx.zza("sendMessageToNativeJs", hashMap);
        }
        zzaki();
    }

    public final void zza(final zzaeb zzaebVar) {
        this.zzfny = zzaebVar;
        zzafn<Object> zzafnVar = this.zzfnz;
        if (zzafnVar != null) {
            this.zzfnx.zzb("/unconfirmedClick", zzafnVar);
        }
        this.zzfnz = new zzafn(this, zzaebVar) { // from class: com.google.android.gms.internal.ads.zzbxp
            private final zzbxq zzfnv;
            private final zzaeb zzfnw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfnv = this;
                this.zzfnw = zzaebVar;
            }

            @Override // com.google.android.gms.internal.ads.zzafn
            public final void zza(Object obj, Map map) {
                zzbxq zzbxqVar = this.zzfnv;
                zzaeb zzaebVar2 = this.zzfnw;
                try {
                    zzbxqVar.b = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    zzayu.zzex("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzbxqVar.a = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzaebVar2 == null) {
                    zzayu.zzea("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzaebVar2.onUnconfirmedClickReceived(str);
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        };
        this.zzfnx.zza("/unconfirmedClick", this.zzfnz);
    }

    @Nullable
    public final zzaeb zzakh() {
        return this.zzfny;
    }
}
