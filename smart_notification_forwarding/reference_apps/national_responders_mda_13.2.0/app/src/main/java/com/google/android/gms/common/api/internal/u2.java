package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class u2 {

    /* renamed from: c, reason: collision with root package name */
    public static final Status f5017c = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: a, reason: collision with root package name */
    final Set f5018a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: b, reason: collision with root package name */
    private final t2 f5019b = new t2(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BasePendingResult basePendingResult) {
        this.f5018a.add(basePendingResult);
        basePendingResult.o(this.f5019b);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f5018a.toArray(new BasePendingResult[0])) {
            basePendingResult.o(null);
            if (basePendingResult.n()) {
                this.f5018a.remove(basePendingResult);
            }
        }
    }
}
