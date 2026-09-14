package com.google.android.gms.common.api.internal;

import a2.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class e0 extends a2.f {

    /* renamed from: b, reason: collision with root package name */
    private final String f4829b = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";

    public e0(String str) {
    }

    @Override // a2.f
    public final void d() {
        throw new UnsupportedOperationException(this.f4829b);
    }

    @Override // a2.f
    public final void e() {
        throw new UnsupportedOperationException(this.f4829b);
    }

    @Override // a2.f
    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.f4829b);
    }

    @Override // a2.f
    public final void i(f.c cVar) {
        throw new UnsupportedOperationException(this.f4829b);
    }

    @Override // a2.f
    public final void j(f.c cVar) {
        throw new UnsupportedOperationException(this.f4829b);
    }
}
