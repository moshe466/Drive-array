package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4174a;

    public /* synthetic */ g(int i) {
        this.f4174a = i;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f4174a) {
            case 0:
                return OptionalProvider.a();
            default:
                return Collections.EMPTY_SET;
        }
    }
}
