package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u2 extends t2<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u2(y2 y2Var, String str, Long l10, boolean z10) {
        super(y2Var, str, l10, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.t2
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Long e(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String n10 = super.n();
        String valueOf = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(n10).length() + 25 + valueOf.length());
        sb2.append("Invalid long value for ");
        sb2.append(n10);
        sb2.append(": ");
        sb2.append(valueOf);
        return null;
    }
}
