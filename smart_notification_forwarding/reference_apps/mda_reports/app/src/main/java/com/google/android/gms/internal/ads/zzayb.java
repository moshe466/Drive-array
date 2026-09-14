package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzayb extends zzavo {
    private final String url;
    private final zzayy zzduv;

    public zzayb(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.zzq.zzkq().zzr(context, str));
    }

    private zzayb(String str, String str2) {
        this.zzduv = new zzayy(str2);
        this.url = str;
    }

    @Override // com.google.android.gms.internal.ads.zzavo
    public final void zztu() {
        this.zzduv.zzen(this.url);
    }
}
