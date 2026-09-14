package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final b0.b f2814a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f2815b;

    /* renamed from: c, reason: collision with root package name */
    private final a f2816c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    private final Typeface f2817d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<a> f2818a;

        /* renamed from: b, reason: collision with root package name */
        private g f2819b;

        private a() {
            this(1);
        }

        a(int i10) {
            this.f2818a = new SparseArray<>(i10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(int i10) {
            SparseArray<a> sparseArray = this.f2818a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final g b() {
            return this.f2819b;
        }

        void c(g gVar, int i10, int i11) {
            a a10 = a(gVar.b(i10));
            if (a10 == null) {
                a10 = new a();
                this.f2818a.put(gVar.b(i10), a10);
            }
            if (i11 > i10) {
                a10.c(gVar, i10 + 1, i11);
            } else {
                a10.f2819b = gVar;
            }
        }
    }

    private m(Typeface typeface, b0.b bVar) {
        this.f2817d = typeface;
        this.f2814a = bVar;
        this.f2815b = new char[bVar.k() * 2];
        a(bVar);
    }

    private void a(b0.b bVar) {
        int k10 = bVar.k();
        for (int i10 = 0; i10 < k10; i10++) {
            g gVar = new g(this, i10);
            Character.toChars(gVar.f(), this.f2815b, i10 * 2);
            h(gVar);
        }
    }

    public static m b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            androidx.core.os.k.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, l.b(byteBuffer));
        } finally {
            androidx.core.os.k.b();
        }
    }

    public char[] c() {
        return this.f2815b;
    }

    public b0.b d() {
        return this.f2814a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f2814a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a f() {
        return this.f2816c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface g() {
        return this.f2817d;
    }

    void h(g gVar) {
        androidx.core.util.h.g(gVar, "emoji metadata cannot be null");
        androidx.core.util.h.a(gVar.c() > 0, "invalid metadata codepoint length");
        this.f2816c.c(gVar, 0, gVar.c() - 1);
    }
}
