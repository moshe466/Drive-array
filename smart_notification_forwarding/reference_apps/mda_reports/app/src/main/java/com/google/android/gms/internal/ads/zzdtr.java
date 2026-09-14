package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdtr implements zzdtc {
    private final int flags;
    private final String info;
    private final Object[] zzhoy;
    private final zzdte zzhpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtr(zzdte zzdteVar, String str, Object[] objArr) {
        this.zzhpb = zzdteVar;
        this.info = str;
        this.zzhoy = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.flags = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.info;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] b() {
        return this.zzhoy;
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final int zzbbg() {
        return (this.flags & 1) == 1 ? zzdrt.zze.zzhna : zzdrt.zze.zzhnb;
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final boolean zzbbh() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final zzdte zzbbi() {
        return this.zzhpb;
    }
}
