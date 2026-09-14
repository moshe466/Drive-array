package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public class r4<K, V> extends w3<K, V> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final transient p4<K, ? extends k4<V>> f5568f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r4(p4<K, ? extends k4<V>> p4Var, int i10) {
        this.f5568f = p4Var;
    }

    @Override // com.google.android.gms.internal.measurement.x3
    public final boolean a(@NullableDecl Object obj) {
        return obj != null && super.a(obj);
    }

    @Override // com.google.android.gms.internal.measurement.x3, com.google.android.gms.internal.measurement.x4
    public final /* synthetic */ Map zza() {
        return this.f5568f;
    }
}
