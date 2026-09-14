package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class w {
    public static <ResultT> void a(Status status, ResultT resultt, z2.m<ResultT> mVar) {
        if (status.t()) {
            mVar.c(resultt);
        } else {
            mVar.b(b2.b.a(status));
        }
    }

    public static void b(Status status, z2.m<Void> mVar) {
        a(status, null, mVar);
    }
}
