package com.google.android.gms.internal.auth;

import F0.AbstractC0008a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcx extends zzdc {
    public zzcx(zzcz zzczVar, String str, Double d2, boolean z3) {
        super(zzczVar, str, d2, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = zzc();
            StringBuilder sb = new StringBuilder("Invalid double value for ");
            sb.append(zzc);
            sb.append(": ");
            AbstractC0008a.B(sb, (String) obj, "PhenotypeFlag");
            return null;
        }
    }
}
