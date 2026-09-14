package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaab {
    private final Map<String, zzaac> zzcru = new HashMap();

    @Nullable
    private final zzaae zzcrv;

    public zzaab(@Nullable zzaae zzaaeVar) {
        this.zzcrv = zzaaeVar;
    }

    public final void zza(String str, zzaac zzaacVar) {
        this.zzcru.put(str, zzaacVar);
    }

    public final void zza(String str, String str2, long j) {
        zzaae zzaaeVar = this.zzcrv;
        zzaac zzaacVar = this.zzcru.get(str2);
        String[] strArr = {str};
        if (zzaaeVar != null && zzaacVar != null) {
            zzaaeVar.zza(zzaacVar, j, strArr);
        }
        Map<String, zzaac> map = this.zzcru;
        zzaae zzaaeVar2 = this.zzcrv;
        map.put(str, zzaaeVar2 == null ? null : zzaaeVar2.zzex(j));
    }

    @Nullable
    public final zzaae zzqp() {
        return this.zzcrv;
    }
}
