package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class zzmx {
    public final int viewportHeight;
    public final int viewportWidth;
    public final String zzbdi;
    public final String zzbdj;
    public final boolean zzbdk;
    public final boolean zzbdl;
    public final int zzbdm;
    public final int zzbdn;
    public final int zzbdo;
    public final boolean zzbdp;
    public final boolean zzbdq;
    public final boolean zzbdr;

    public zzmx() {
        this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    private zzmx(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzbdi = null;
        this.zzbdj = null;
        this.zzbdk = false;
        this.zzbdl = true;
        this.zzbdm = Integer.MAX_VALUE;
        this.zzbdn = Integer.MAX_VALUE;
        this.zzbdo = Integer.MAX_VALUE;
        this.zzbdp = true;
        this.zzbdq = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbdr = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmx.class == obj.getClass()) {
            zzmx zzmxVar = (zzmx) obj;
            if (this.zzbdl == zzmxVar.zzbdl && this.zzbdm == zzmxVar.zzbdm && this.zzbdn == zzmxVar.zzbdn && this.zzbdp == zzmxVar.zzbdp && this.zzbdq == zzmxVar.zzbdq && this.zzbdr == zzmxVar.zzbdr && this.viewportWidth == zzmxVar.viewportWidth && this.viewportHeight == zzmxVar.viewportHeight && this.zzbdo == zzmxVar.zzbdo && TextUtils.equals(null, null) && TextUtils.equals(null, null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.zzbdl ? 1 : 0)) * 31) + this.zzbdm) * 31) + this.zzbdn) * 31) + this.zzbdo) * 31) + (this.zzbdp ? 1 : 0)) * 31) + (this.zzbdq ? 1 : 0)) * 31) + (this.zzbdr ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }
}
