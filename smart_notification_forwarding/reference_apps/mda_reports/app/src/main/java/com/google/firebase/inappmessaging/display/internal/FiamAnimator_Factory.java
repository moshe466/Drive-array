package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FiamAnimator_Factory implements Factory<FiamAnimator> {
    private static final FiamAnimator_Factory INSTANCE = new FiamAnimator_Factory();

    public static FiamAnimator_Factory create() {
        return INSTANCE;
    }

    public static FiamAnimator newInstance() {
        return new FiamAnimator();
    }

    @Override // javax.inject.Provider
    public FiamAnimator get() {
        return new FiamAnimator();
    }
}
