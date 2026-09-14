package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.e;
import java.util.Objects;

/* loaded from: classes.dex */
final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    private final e.a f4707a;

    /* renamed from: b, reason: collision with root package name */
    private final long f4708b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e.a aVar, long j10) {
        Objects.requireNonNull(aVar, "Null status");
        this.f4707a = aVar;
        this.f4708b = j10;
    }

    @Override // com.google.android.datatransport.runtime.backends.e
    public long b() {
        return this.f4708b;
    }

    @Override // com.google.android.datatransport.runtime.backends.e
    public e.a c() {
        return this.f4707a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f4707a.equals(eVar.c()) && this.f4708b == eVar.b();
    }

    public int hashCode() {
        int hashCode = (this.f4707a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f4708b;
        return hashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f4707a + ", nextRequestWaitMillis=" + this.f4708b + "}";
    }
}
