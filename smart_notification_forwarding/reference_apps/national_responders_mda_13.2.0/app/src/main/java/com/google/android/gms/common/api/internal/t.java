package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.i;

/* loaded from: classes.dex */
public class t extends i.a {

    /* renamed from: a, reason: collision with root package name */
    private final e<Status> f4989a;

    public t(e<Status> eVar) {
        this.f4989a = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.i
    public void U(Status status) {
        this.f4989a.a(status);
    }
}
