package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class zzjk implements Iterable {
    public final String toString() {
        Iterator it = iterator();
        StringBuilder sb = new StringBuilder("[");
        boolean z3 = true;
        while (it.hasNext()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(it.next());
            z3 = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
