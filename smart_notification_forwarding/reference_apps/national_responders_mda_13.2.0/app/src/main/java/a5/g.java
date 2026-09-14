package a5;

import com.google.gson.q;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class g extends f5.c {

    /* renamed from: t, reason: collision with root package name */
    private static final Writer f209t = new a();

    /* renamed from: u, reason: collision with root package name */
    private static final q f210u = new q("closed");

    /* renamed from: q, reason: collision with root package name */
    private final List<com.google.gson.k> f211q;

    /* renamed from: r, reason: collision with root package name */
    private String f212r;

    /* renamed from: s, reason: collision with root package name */
    private com.google.gson.k f213s;

    /* loaded from: classes.dex */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f209t);
        this.f211q = new ArrayList();
        this.f213s = com.google.gson.m.f7516a;
    }

    private com.google.gson.k s0() {
        return this.f211q.get(r0.size() - 1);
    }

    private void t0(com.google.gson.k kVar) {
        if (this.f212r != null) {
            if (!kVar.u() || H()) {
                ((com.google.gson.n) s0()).x(this.f212r, kVar);
            }
            this.f212r = null;
            return;
        }
        if (this.f211q.isEmpty()) {
            this.f213s = kVar;
            return;
        }
        com.google.gson.k s02 = s0();
        if (!(s02 instanceof com.google.gson.h)) {
            throw new IllegalStateException();
        }
        ((com.google.gson.h) s02).x(kVar);
    }

    @Override // f5.c
    public f5.c D() {
        if (this.f211q.isEmpty() || this.f212r != null) {
            throw new IllegalStateException();
        }
        if (!(s0() instanceof com.google.gson.n)) {
            throw new IllegalStateException();
        }
        this.f211q.remove(r0.size() - 1);
        return this;
    }

    @Override // f5.c
    public f5.c O(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f211q.isEmpty() || this.f212r != null) {
            throw new IllegalStateException();
        }
        if (!(s0() instanceof com.google.gson.n)) {
            throw new IllegalStateException();
        }
        this.f212r = str;
        return this;
    }

    @Override // f5.c
    public f5.c b0() {
        t0(com.google.gson.m.f7516a);
        return this;
    }

    @Override // f5.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f211q.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f211q.add(f210u);
    }

    @Override // f5.c
    public f5.c f() {
        com.google.gson.h hVar = new com.google.gson.h();
        t0(hVar);
        this.f211q.add(hVar);
        return this;
    }

    @Override // f5.c, java.io.Flushable
    public void flush() {
    }

    @Override // f5.c
    public f5.c g() {
        com.google.gson.n nVar = new com.google.gson.n();
        t0(nVar);
        this.f211q.add(nVar);
        return this;
    }

    @Override // f5.c
    public f5.c l0(long j10) {
        t0(new q(Long.valueOf(j10)));
        return this;
    }

    @Override // f5.c
    public f5.c m0(Boolean bool) {
        if (bool == null) {
            return b0();
        }
        t0(new q(bool));
        return this;
    }

    @Override // f5.c
    public f5.c n0(Number number) {
        if (number == null) {
            return b0();
        }
        if (!N()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        t0(new q(number));
        return this;
    }

    @Override // f5.c
    public f5.c o0(String str) {
        if (str == null) {
            return b0();
        }
        t0(new q(str));
        return this;
    }

    @Override // f5.c
    public f5.c p0(boolean z10) {
        t0(new q(Boolean.valueOf(z10)));
        return this;
    }

    public com.google.gson.k r0() {
        if (this.f211q.isEmpty()) {
            return this.f213s;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f211q);
    }

    @Override // f5.c
    public f5.c v() {
        if (this.f211q.isEmpty() || this.f212r != null) {
            throw new IllegalStateException();
        }
        if (!(s0() instanceof com.google.gson.h)) {
            throw new IllegalStateException();
        }
        this.f211q.remove(r0.size() - 1);
        return this;
    }
}
