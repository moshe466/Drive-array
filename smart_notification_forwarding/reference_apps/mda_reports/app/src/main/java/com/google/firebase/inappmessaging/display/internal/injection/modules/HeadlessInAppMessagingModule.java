package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes2.dex */
public class HeadlessInAppMessagingModule {
    private final FirebaseInAppMessaging headless;

    public HeadlessInAppMessagingModule(FirebaseInAppMessaging firebaseInAppMessaging) {
        this.headless = firebaseInAppMessaging;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @FirebaseAppScope
    public FirebaseInAppMessaging a() {
        return this.headless;
    }
}
