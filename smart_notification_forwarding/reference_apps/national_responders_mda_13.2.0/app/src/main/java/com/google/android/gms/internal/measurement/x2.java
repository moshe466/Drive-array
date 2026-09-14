package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x2 extends t2<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public x2(y2 y2Var, String str, Boolean bool, boolean z10) {
        super(y2Var, str, bool, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.t2
    final /* synthetic */ Boolean e(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (a2.f5158c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (a2.f5159d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String n10 = super.n();
        String valueOf = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(n10).length() + 28 + valueOf.length());
        sb2.append("Invalid boolean value for ");
        sb2.append(n10);
        sb2.append(": ");
        sb2.append(valueOf);
        return null;
    }
}
