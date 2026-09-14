package com.google.firebase.inappmessaging.display;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseInAppMessagingDisplayRegistrar$$Lambda$1 implements ComponentFactory {
    private final FirebaseInAppMessagingDisplayRegistrar arg$1;

    private FirebaseInAppMessagingDisplayRegistrar$$Lambda$1(FirebaseInAppMessagingDisplayRegistrar firebaseInAppMessagingDisplayRegistrar) {
        this.arg$1 = firebaseInAppMessagingDisplayRegistrar;
    }

    public static ComponentFactory lambdaFactory$(FirebaseInAppMessagingDisplayRegistrar firebaseInAppMessagingDisplayRegistrar) {
        return new FirebaseInAppMessagingDisplayRegistrar$$Lambda$1(firebaseInAppMessagingDisplayRegistrar);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return FirebaseInAppMessagingDisplayRegistrar.access$lambda$0(this.arg$1, componentContainer);
    }
}
