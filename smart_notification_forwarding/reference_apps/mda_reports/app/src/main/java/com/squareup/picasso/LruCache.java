package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class LruCache implements Cache {
    final android.util.LruCache<String, BitmapAndSize> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class BitmapAndSize {
        final Bitmap a;
        final int b;

        BitmapAndSize(Bitmap bitmap, int i) {
            this.a = bitmap;
            this.b = i;
        }
    }

    public LruCache(int i) {
        this.a = new android.util.LruCache<String, BitmapAndSize>(this, i) { // from class: com.squareup.picasso.LruCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, BitmapAndSize bitmapAndSize) {
                return bitmapAndSize.b;
            }
        };
    }

    public LruCache(@NonNull Context context) {
        this(Utils.a(context));
    }

    @Override // com.squareup.picasso.Cache
    public void clear() {
        this.a.evictAll();
    }

    @Override // com.squareup.picasso.Cache
    public void clearKeyUri(String str) {
        for (String str2 : this.a.snapshot().keySet()) {
            if (str2.startsWith(str) && str2.length() > str.length() && str2.charAt(str.length()) == '\n') {
                this.a.remove(str2);
            }
        }
    }

    public int evictionCount() {
        return this.a.evictionCount();
    }

    @Override // com.squareup.picasso.Cache
    @Nullable
    public Bitmap get(@NonNull String str) {
        BitmapAndSize bitmapAndSize = this.a.get(str);
        if (bitmapAndSize != null) {
            return bitmapAndSize.a;
        }
        return null;
    }

    public int hitCount() {
        return this.a.hitCount();
    }

    @Override // com.squareup.picasso.Cache
    public int maxSize() {
        return this.a.maxSize();
    }

    public int missCount() {
        return this.a.missCount();
    }

    public int putCount() {
        return this.a.putCount();
    }

    @Override // com.squareup.picasso.Cache
    public void set(@NonNull String str, @NonNull Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int a = Utils.a(bitmap);
        if (a > maxSize()) {
            this.a.remove(str);
        } else {
            this.a.put(str, new BitmapAndSize(bitmap, a));
        }
    }

    @Override // com.squareup.picasso.Cache
    public int size() {
        return this.a.size();
    }
}
