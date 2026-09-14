package com.google.firebase.inappmessaging;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseInAppMessagingRegistrar$$Lambda$1 implements ComponentFactory {
    private final FirebaseInAppMessagingRegistrar arg$1;

    private FirebaseInAppMessagingRegistrar$$Lambda$1(FirebaseInAppMessagingRegistrar firebaseInAppMessagingRegistrar) {
        this.arg$1 = firebaseInAppMessagingRegistrar;
    }

    public static ComponentFactory lambdaFactory$(FirebaseInAppMessagingRegistrar firebaseInAppMessagingRegistrar) {
        return new FirebaseInAppMessagingRegistrar$$Lambda$1(firebaseInAppMessagingRegistrar);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return FirebaseInAppMessagingRegistrar.access$lambda$0(this.arg$1, componentContainer);
    }
}
