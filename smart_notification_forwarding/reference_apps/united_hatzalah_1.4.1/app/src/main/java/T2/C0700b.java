package t2;

import F0.AbstractC0008a;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: t2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0700b extends AbstractC0701c implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6463a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f6464b;

    /* renamed from: c, reason: collision with root package name */
    public int f6465c;

    /* renamed from: d, reason: collision with root package name */
    public final List f6466d;

    public C0700b(ArrayList arrayList) {
        this.f6466d = arrayList;
    }

    @Override // t2.AbstractC0701c
    public final int g() {
        switch (this.f6463a) {
            case 0:
                return this.f6465c;
            default:
                return this.f6465c;
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        switch (this.f6463a) {
            case 0:
                int i3 = this.f6465c;
                if (i >= 0 && i < i3) {
                    return ((AbstractC0701c) this.f6466d).get(this.f6464b + i);
                }
                throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
            default:
                int i4 = this.f6465c;
                if (i >= 0 && i < i4) {
                    return ((ArrayList) this.f6466d).get(this.f6464b + i);
                }
                throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i4, ", size: "));
        }
    }

    @Override // t2.AbstractC0701c, java.util.List
    public List subList(int i, int i3) {
        switch (this.f6463a) {
            case 0:
                p3.h.f(i, i3, this.f6465c);
                AbstractC0701c abstractC0701c = (AbstractC0701c) this.f6466d;
                int i4 = this.f6464b;
                return new C0700b(abstractC0701c, i + i4, i4 + i3);
            default:
                return super.subList(i, i3);
        }
    }

    public C0700b(AbstractC0701c abstractC0701c, int i, int i3) {
        this.f6466d = abstractC0701c;
        this.f6464b = i;
        p3.h.f(i, i3, abstractC0701c.g());
        this.f6465c = i3 - i;
    }
}
