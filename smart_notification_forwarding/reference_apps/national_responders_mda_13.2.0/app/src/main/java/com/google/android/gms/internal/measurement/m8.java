package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class m8 implements v8 {

    /* renamed from: a, reason: collision with root package name */
    private v8[] f5475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m8(v8... v8VarArr) {
        this.f5475a = v8VarArr;
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public final boolean a(Class<?> cls) {
        for (v8 v8Var : this.f5475a) {
            if (v8Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public final w8 b(Class<?> cls) {
        for (v8 v8Var : this.f5475a) {
            if (v8Var.a(cls)) {
                return v8Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
