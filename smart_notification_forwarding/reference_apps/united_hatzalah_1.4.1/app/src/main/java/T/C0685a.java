package t;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: t.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0685a implements Iterator, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public int f6341a;

    /* renamed from: b, reason: collision with root package name */
    public int f6342b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6343c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6344d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6345e;

    public C0685a(int i) {
        this.f6341a = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6342b < this.f6341a) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object f4;
        if (hasNext()) {
            int i = this.f6342b;
            switch (this.f6344d) {
                case 0:
                    f4 = ((C0689e) this.f6345e).f(i);
                    break;
                case 1:
                    f4 = ((C0689e) this.f6345e).i(i);
                    break;
                default:
                    f4 = ((C0690f) this.f6345e).f6356b[i];
                    break;
            }
            this.f6342b++;
            this.f6343c = true;
            return f4;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f6343c) {
            int i = this.f6342b - 1;
            this.f6342b = i;
            switch (this.f6344d) {
                case 0:
                    ((C0689e) this.f6345e).g(i);
                    break;
                case 1:
                    ((C0689e) this.f6345e).g(i);
                    break;
                default:
                    ((C0690f) this.f6345e).d(i);
                    break;
            }
            this.f6341a--;
            this.f6343c = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0685a(C0690f c0690f) {
        this(c0690f.f6357c);
        this.f6344d = 2;
        this.f6345e = c0690f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0685a(C0689e c0689e, int i) {
        this(c0689e.f6366c);
        this.f6344d = i;
        switch (i) {
            case 1:
                this.f6345e = c0689e;
                this(c0689e.f6366c);
                return;
            default:
                this.f6345e = c0689e;
                return;
        }
    }
}
