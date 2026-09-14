package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.model.InAppMessage;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes2.dex */
public class InflaterModule {
    private final Application application;
    private final InAppMessage inAppMessage;
    private final InAppMessageLayoutConfig inAppMessageLayoutConfig;

    public InflaterModule(InAppMessage inAppMessage, InAppMessageLayoutConfig inAppMessageLayoutConfig, Application application) {
        this.inAppMessage = inAppMessage;
        this.inAppMessageLayoutConfig = inAppMessageLayoutConfig;
        this.application = application;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @InAppMessageScope
    public InAppMessageLayoutConfig a() {
        return this.inAppMessageLayoutConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public InAppMessage b() {
        return this.inAppMessage;
    }

    @Provides
    @InAppMessageScope
    public LayoutInflater providesInflaterservice() {
        return (LayoutInflater) this.application.getSystemService("layout_inflater");
    }
}
