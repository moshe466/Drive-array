package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class a5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, int i10) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append("at index ");
        sb2.append(i10);
        throw new NullPointerException(sb2.toString());
    }
}
