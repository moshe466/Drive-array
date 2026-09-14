package com.google.android.gms.common.api.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a0 implements z2.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z2.m f4773a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f4774b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(b0 b0Var, z2.m mVar) {
        this.f4774b = b0Var;
        this.f4773a = mVar;
    }

    @Override // z2.f
    public final void a(z2.l lVar) {
        Map map;
        map = this.f4774b.f4786b;
        map.remove(this.f4773a);
    }
}
