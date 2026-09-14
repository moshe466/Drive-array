package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class v9 extends ba {

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ q9 f5642g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private v9(q9 q9Var) {
        super(q9Var, null);
        this.f5642g = q9Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v9(q9 q9Var, t9 t9Var) {
        this(q9Var);
    }

    @Override // com.google.android.gms.internal.measurement.ba, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new s9(this.f5642g, null);
    }
}
