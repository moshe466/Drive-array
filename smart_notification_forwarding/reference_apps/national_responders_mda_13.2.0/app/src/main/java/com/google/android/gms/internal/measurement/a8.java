package com.google.android.gms.internal.measurement;

import java.util.Map;

/* loaded from: classes.dex */
final class a8<K> implements Map.Entry<K, Object> {

    /* renamed from: f, reason: collision with root package name */
    private Map.Entry<K, y7> f5178f;

    private a8(Map.Entry<K, y7> entry) {
        this.f5178f = entry;
    }

    public final y7 a() {
        return this.f5178f.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f5178f.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f5178f.getValue() == null) {
            return null;
        }
        return y7.e();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof y8) {
            return this.f5178f.getValue().a((y8) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
