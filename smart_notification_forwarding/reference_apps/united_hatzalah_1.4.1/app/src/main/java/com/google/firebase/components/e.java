package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.inject.Provider;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4171a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4172b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4173c;

    public /* synthetic */ e(int i, Object obj, Object obj2) {
        this.f4171a = i;
        this.f4173c = obj;
        this.f4172b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4171a) {
            case 0:
                ((OptionalProvider) this.f4173c).set((Provider) this.f4172b);
                return;
            case 1:
                ((LazySet) this.f4173c).add((Provider) this.f4172b);
                return;
            default:
                EventBus.lambda$publish$0((Map.Entry) this.f4173c, (Event) this.f4172b);
                return;
        }
    }
}
