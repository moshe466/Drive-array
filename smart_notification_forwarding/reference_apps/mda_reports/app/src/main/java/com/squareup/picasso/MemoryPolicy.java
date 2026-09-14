package com.squareup.picasso;

/* loaded from: classes2.dex */
public enum MemoryPolicy {
    NO_CACHE(1),
    NO_STORE(2);

    final int a;

    MemoryPolicy(int i) {
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(int i) {
        return (i & NO_CACHE.a) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i) {
        return (i & NO_STORE.a) == 0;
    }
}
