package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcvw {
    private final zzaqk zzfvs;

    public zzcvw(zzaqk zzaqkVar) {
        this.zzfvs = zzaqkVar;
    }

    public final String zzant() {
        return this.zzfvs.packageName;
    }

    public final String zzanu() {
        return this.zzfvs.zzdlu.getString("ms");
    }

    @Nullable
    public final PackageInfo zzanv() {
        return this.zzfvs.zzdip;
    }

    public final boolean zzanw() {
        return this.zzfvs.zzdlv;
    }

    public final List<String> zzanx() {
        return this.zzfvs.zzdiz;
    }

    public final ApplicationInfo zzany() {
        return this.zzfvs.applicationInfo;
    }

    public final String zzanz() {
        return this.zzfvs.zzdlw;
    }
}
