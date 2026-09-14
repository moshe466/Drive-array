package com.google.android.gms.common.api.internal;

import java.util.Set;

/* loaded from: classes.dex */
public final class c3 {

    /* renamed from: a, reason: collision with root package name */
    private final l.a f4803a;

    /* renamed from: b, reason: collision with root package name */
    private final l.a f4804b;

    /* renamed from: c, reason: collision with root package name */
    private final z2.m f4805c;

    /* renamed from: d, reason: collision with root package name */
    private int f4806d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4807e;

    public final Set a() {
        return this.f4803a.keySet();
    }

    public final void b(b bVar, com.google.android.gms.common.a aVar, String str) {
        this.f4803a.put(bVar, aVar);
        this.f4804b.put(bVar, str);
        this.f4806d--;
        if (!aVar.t()) {
            this.f4807e = true;
        }
        if (this.f4806d == 0) {
            if (!this.f4807e) {
                this.f4805c.c(this.f4804b);
            } else {
                this.f4805c.b(new a2.c(this.f4803a));
            }
        }
    }
}
