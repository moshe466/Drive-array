package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PicassoModule_ProvidesFiamControllerFactory implements Factory<Picasso> {
    private final Provider<Application> applicationProvider;
    private final PicassoModule module;
    private final Provider<PicassoErrorListener> picassoErrorListenerProvider;

    public PicassoModule_ProvidesFiamControllerFactory(PicassoModule picassoModule, Provider<Application> provider, Provider<PicassoErrorListener> provider2) {
        this.module = picassoModule;
        this.applicationProvider = provider;
        this.picassoErrorListenerProvider = provider2;
    }

    public static PicassoModule_ProvidesFiamControllerFactory create(PicassoModule picassoModule, Provider<Application> provider, Provider<PicassoErrorListener> provider2) {
        return new PicassoModule_ProvidesFiamControllerFactory(picassoModule, provider, provider2);
    }

    public static Picasso providesFiamController(PicassoModule picassoModule, Application application, PicassoErrorListener picassoErrorListener) {
        return (Picasso) Preconditions.checkNotNull(picassoModule.a(application, picassoErrorListener), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Picasso get() {
        return providesFiamController(this.module, this.applicationProvider.get(), this.picassoErrorListenerProvider.get());
    }
}
