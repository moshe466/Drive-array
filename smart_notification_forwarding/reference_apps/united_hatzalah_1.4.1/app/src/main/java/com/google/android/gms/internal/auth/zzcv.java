package com.google.android.gms.internal.auth;

import F0.AbstractC0008a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcv extends zzdc {
    public zzcv(zzcz zzczVar, String str, Long l3, boolean z3) {
        super(zzczVar, str, l3, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = zzc();
            StringBuilder sb = new StringBuilder("Invalid long value for ");
            sb.append(zzc);
            sb.append(": ");
            AbstractC0008a.B(sb, (String) obj, "PhenotypeFlag");
            return null;
        }
    }
}
