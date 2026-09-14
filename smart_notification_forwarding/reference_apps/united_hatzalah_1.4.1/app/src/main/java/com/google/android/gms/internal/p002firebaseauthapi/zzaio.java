package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaio {
    private List<String> zza;

    public zzaio() {
        this(null);
    }

    public static zzaio zza() {
        return new zzaio(null);
    }

    public final List<String> zzb() {
        return this.zza;
    }

    private zzaio(List<String> list) {
        this.zza = new ArrayList();
    }

    public zzaio(int i, List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.set(i3, Strings.emptyToNull(list.get(i3)));
            }
            this.zza = Collections.unmodifiableList(list);
            return;
        }
        this.zza = Collections.EMPTY_LIST;
    }
}
