package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.d;
import java.util.Arrays;
import java.util.Objects;
import k1.h;

/* loaded from: classes.dex */
final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private final Iterable<h> f4703a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f4704b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        private Iterable<h> f4705a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f4706b;

        @Override // com.google.android.datatransport.runtime.backends.d.a
        public d a() {
            String str = "";
            if (this.f4705a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f4705a, this.f4706b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.d.a
        public d.a b(Iterable<h> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.f4705a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.d.a
        public d.a c(byte[] bArr) {
            this.f4706b = bArr;
            return this;
        }
    }

    private a(Iterable<h> iterable, byte[] bArr) {
        this.f4703a = iterable;
        this.f4704b = bArr;
    }

    @Override // com.google.android.datatransport.runtime.backends.d
    public Iterable<h> b() {
        return this.f4703a;
    }

    @Override // com.google.android.datatransport.runtime.backends.d
    public byte[] c() {
        return this.f4704b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f4703a.equals(dVar.b())) {
            if (Arrays.equals(this.f4704b, dVar instanceof a ? ((a) dVar).f4704b : dVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4703a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4704b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f4703a + ", extras=" + Arrays.toString(this.f4704b) + "}";
    }
}
