package androidx.datastore.preferences.protobuf;

import com.google.crypto.tink.shaded.protobuf.C0336h;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0237d implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3158a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3159b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f3160c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3161d;

    public C0237d(C0240g c0240g) {
        this.f3161d = c0240g;
        this.f3160c = c0240g.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3158a) {
            case 0:
                if (this.f3159b < this.f3160c) {
                    return true;
                }
                return false;
            default:
                if (this.f3159b < this.f3160c) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3158a) {
            case 0:
                int i = this.f3159b;
                if (i < this.f3160c) {
                    this.f3159b = i + 1;
                    return Byte.valueOf(((C0240g) this.f3161d).l(i));
                }
                throw new NoSuchElementException();
            default:
                int i3 = this.f3159b;
                if (i3 < this.f3160c) {
                    this.f3159b = i3 + 1;
                    return Byte.valueOf(((C0336h) this.f3161d).m(i3));
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3158a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public C0237d(C0336h c0336h) {
        this.f3161d = c0336h;
        this.f3160c = c0336h.size();
    }
}
