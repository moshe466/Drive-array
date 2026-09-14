package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w2 extends t2<Double> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public w2(y2 y2Var, String str, Double d10, boolean z10) {
        super(y2Var, str, d10, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.t2
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Double e(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String n10 = super.n();
        String valueOf = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(n10).length() + 27 + valueOf.length());
        sb2.append("Invalid double value for ");
        sb2.append(n10);
        sb2.append(": ");
        sb2.append(valueOf);
        return null;
    }
}
