package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class zzarc extends zzarh {
    private final String type;
    private final int zzdno;

    public zzarc(String str, int i) {
        this.type = str;
        this.zzdno = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzarc)) {
            zzarc zzarcVar = (zzarc) obj;
            if (Objects.equal(this.type, zzarcVar.type) && Objects.equal(Integer.valueOf(this.zzdno), Integer.valueOf(zzarcVar.zzdno))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzare
    public final int getAmount() {
        return this.zzdno;
    }

    @Override // com.google.android.gms.internal.ads.zzare
    public final String getType() {
        return this.type;
    }
}
