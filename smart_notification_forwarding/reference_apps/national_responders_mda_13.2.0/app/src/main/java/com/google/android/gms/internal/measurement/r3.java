package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public final class r3 {
    public static <T> o3<T> a(o3<T> o3Var) {
        return ((o3Var instanceof t3) || (o3Var instanceof q3)) ? o3Var : o3Var instanceof Serializable ? new q3(o3Var) : new t3(o3Var);
    }

    public static <T> o3<T> b(@NullableDecl T t10) {
        return new s3(t10);
    }
}
