package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PicassoErrorListener_Factory implements Factory<PicassoErrorListener> {
    private static final PicassoErrorListener_Factory INSTANCE = new PicassoErrorListener_Factory();

    public static PicassoErrorListener_Factory create() {
        return INSTANCE;
    }

    public static PicassoErrorListener newInstance() {
        return new PicassoErrorListener();
    }

    @Override // javax.inject.Provider
    public PicassoErrorListener get() {
        return new PicassoErrorListener();
    }
}
