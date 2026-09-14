package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes.dex */
public final class zzbpm extends zzbrl<zzbov> {
    public zzbpm(Set<zzbsu<zzbov>> set) {
        super(set);
    }

    public final void onAdClosed() {
        a(zzbpp.a);
    }

    public final void onAdLeftApplication() {
        a(zzbpo.a);
    }

    public final void onAdOpened() {
        a(zzbpr.a);
    }

    public final void onRewardedVideoCompleted() {
        a(zzbps.a);
    }

    public final void onRewardedVideoStarted() {
        a(zzbpq.a);
    }

    public final void zzb(final zzare zzareVar, final String str, final String str2) {
        a(new zzbrn(zzareVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbpt
            private final String zzcyr;
            private final String zzdbl;
            private final zzare zzfhs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhs = zzareVar;
                this.zzcyr = str;
                this.zzdbl = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbrn
            public final void zzp(Object obj) {
                ((zzbov) obj).zzb(this.zzfhs, this.zzcyr, this.zzdbl);
            }
        });
    }
}
