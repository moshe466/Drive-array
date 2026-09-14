package com.google.firebase.inappmessaging.model;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ProtoMarshallerClient_Factory implements Factory<ProtoMarshallerClient> {
    private static final ProtoMarshallerClient_Factory INSTANCE = new ProtoMarshallerClient_Factory();

    public static ProtoMarshallerClient_Factory create() {
        return INSTANCE;
    }

    public static ProtoMarshallerClient newInstance() {
        return new ProtoMarshallerClient();
    }

    @Override // javax.inject.Provider
    public ProtoMarshallerClient get() {
        return new ProtoMarshallerClient();
    }
}
