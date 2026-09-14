package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public final class zzdee {
    private final String className;
    private final zzdeh zzgty;
    private zzdeh zzgtz;
    private boolean zzgua;

    private zzdee(String str) {
        this.zzgty = new zzdeh();
        this.zzgtz = this.zzgty;
        this.zzgua = false;
        this.className = (String) zzdei.checkNotNull(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdeh zzdehVar = this.zzgty.b;
        String str = "";
        while (zzdehVar != null) {
            Object obj = zzdehVar.a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            zzdehVar = zzdehVar.b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzdee zzaa(@NullableDecl Object obj) {
        zzdeh zzdehVar = new zzdeh();
        this.zzgtz.b = zzdehVar;
        this.zzgtz = zzdehVar;
        zzdehVar.a = obj;
        return this;
    }
}
