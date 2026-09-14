package io.fabric.sdk.android.services.cache;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class AbstractValueCache<T> implements ValueCache<T> {
    private final ValueCache<T> childCache;

    public AbstractValueCache() {
        this(null);
    }

    public AbstractValueCache(ValueCache<T> valueCache) {
        this.childCache = valueCache;
    }

    private void cache(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        a(context, t);
    }

    protected abstract void a(Context context);

    protected abstract void a(Context context, T t);

    protected abstract T b(Context context);

    @Override // io.fabric.sdk.android.services.cache.ValueCache
    public final synchronized T get(Context context, ValueLoader<T> valueLoader) {
        T b;
        b = b(context);
        if (b == null) {
            b = this.childCache != null ? this.childCache.get(context, valueLoader) : valueLoader.load(context);
            cache(context, b);
        }
        return b;
    }

    @Override // io.fabric.sdk.android.services.cache.ValueCache
    public final synchronized void invalidate(Context context) {
        a(context);
    }
}
