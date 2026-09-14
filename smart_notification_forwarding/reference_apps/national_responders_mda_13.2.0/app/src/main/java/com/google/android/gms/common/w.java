package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class w extends x {

    /* renamed from: e, reason: collision with root package name */
    private final Callable f5127e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(Callable callable, z1.k kVar) {
        super();
        this.f5127e = callable;
    }

    @Override // com.google.android.gms.common.x
    final String a() {
        try {
            return (String) this.f5127e.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
