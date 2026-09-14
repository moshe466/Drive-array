package com.google.common.graph;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry1;

    @NullableDecl
    private transient CacheEntry<K, V> cacheEntry2;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class CacheEntry<K, V> {
        final K a;
        final V b;

        CacheEntry(K k, V v) {
            this.a = k;
            this.b = v;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    private void addToCache(CacheEntry<K, V> cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }

    private void addToCache(K k, V v) {
        addToCache(new CacheEntry<>(k, v));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.graph.MapIteratorCache
    public V a(@NullableDecl Object obj) {
        V v = (V) super.a(obj);
        if (v != null) {
            return v;
        }
        CacheEntry<K, V> cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.a == obj) {
            return cacheEntry.b;
        }
        CacheEntry<K, V> cacheEntry2 = this.cacheEntry2;
        if (cacheEntry2 == null || cacheEntry2.a != obj) {
            return null;
        }
        addToCache(cacheEntry2);
        return cacheEntry2.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.graph.MapIteratorCache
    public void a() {
        super.a();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    public V get(@NullableDecl Object obj) {
        V a = a(obj);
        if (a != null) {
            return a;
        }
        V withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }
}
