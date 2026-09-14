package com.google.firebase.firestore;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
final /* synthetic */ class FirestoreRegistrar$$Lambda$1 implements ComponentFactory {
    private static final FirestoreRegistrar$$Lambda$1 instance = new FirestoreRegistrar$$Lambda$1();

    private FirestoreRegistrar$$Lambda$1() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return FirestoreRegistrar.lambda$getComponents$0(componentContainer);
    }
}
