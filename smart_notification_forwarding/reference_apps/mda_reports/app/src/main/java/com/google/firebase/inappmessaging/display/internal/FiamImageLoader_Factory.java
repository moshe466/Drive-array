package com.google.firebase.inappmessaging.display.internal;

import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FiamImageLoader_Factory implements Factory<FiamImageLoader> {
    private final Provider<Picasso> picassoProvider;

    public FiamImageLoader_Factory(Provider<Picasso> provider) {
        this.picassoProvider = provider;
    }

    public static FiamImageLoader_Factory create(Provider<Picasso> provider) {
        return new FiamImageLoader_Factory(provider);
    }

    public static FiamImageLoader newInstance(Picasso picasso) {
        return new FiamImageLoader(picasso);
    }

    @Override // javax.inject.Provider
    public FiamImageLoader get() {
        return new FiamImageLoader(this.picassoProvider.get());
    }
}
