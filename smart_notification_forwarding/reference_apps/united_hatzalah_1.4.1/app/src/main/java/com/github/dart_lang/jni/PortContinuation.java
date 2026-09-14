package com.github.dart_lang.jni;

import P2.O;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public class PortContinuation<T> implements InterfaceC0763d {
    private final long port;

    static {
        System.loadLibrary("dartjni");
    }

    public PortContinuation(long j2) {
        this.port = j2;
    }

    private native void _resumeWith(long j2, Object obj);

    @Override // w2.InterfaceC0763d
    public InterfaceC0768i getContext() {
        return O.f1623b;
    }

    @Override // w2.InterfaceC0763d
    public void resumeWith(Object obj) {
        _resumeWith(this.port, obj);
    }
}
