package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class l4 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(@NullableDecl Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
