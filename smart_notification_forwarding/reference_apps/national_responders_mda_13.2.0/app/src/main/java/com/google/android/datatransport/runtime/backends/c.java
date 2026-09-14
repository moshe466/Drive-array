package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import java.util.Objects;

/* loaded from: classes.dex */
final class c extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4709a;

    /* renamed from: b, reason: collision with root package name */
    private final t1.a f4710b;

    /* renamed from: c, reason: collision with root package name */
    private final t1.a f4711c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4712d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, t1.a aVar, t1.a aVar2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.f4709a = context;
        Objects.requireNonNull(aVar, "Null wallClock");
        this.f4710b = aVar;
        Objects.requireNonNull(aVar2, "Null monotonicClock");
        this.f4711c = aVar2;
        Objects.requireNonNull(str, "Null backendName");
        this.f4712d = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public Context b() {
        return this.f4709a;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public String c() {
        return this.f4712d;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public t1.a d() {
        return this.f4711c;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public t1.a e() {
        return this.f4710b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f4709a.equals(fVar.b()) && this.f4710b.equals(fVar.e()) && this.f4711c.equals(fVar.d()) && this.f4712d.equals(fVar.c());
    }

    public int hashCode() {
        return ((((((this.f4709a.hashCode() ^ 1000003) * 1000003) ^ this.f4710b.hashCode()) * 1000003) ^ this.f4711c.hashCode()) * 1000003) ^ this.f4712d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f4709a + ", wallClock=" + this.f4710b + ", monotonicClock=" + this.f4711c + ", backendName=" + this.f4712d + "}";
    }
}
