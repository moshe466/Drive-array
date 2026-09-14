package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {

    /* renamed from: a, reason: collision with root package name */
    private androidx.core.util.e<b> f3505a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f3506b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<b> f3507c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0056a f3508d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f3509e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f3510f;

    /* renamed from: g, reason: collision with root package name */
    final i f3511g;

    /* renamed from: h, reason: collision with root package name */
    private int f3512h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0056a {
        void a(int i10, int i11);

        void b(b bVar);

        RecyclerView.d0 c(int i10);

        void d(int i10, int i11);

        void e(int i10, int i11);

        void f(int i10, int i11);

        void g(b bVar);

        void h(int i10, int i11, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f3513a;

        /* renamed from: b, reason: collision with root package name */
        int f3514b;

        /* renamed from: c, reason: collision with root package name */
        Object f3515c;

        /* renamed from: d, reason: collision with root package name */
        int f3516d;

        b(int i10, int i11, int i12, Object obj) {
            this.f3513a = i10;
            this.f3514b = i11;
            this.f3516d = i12;
            this.f3515c = obj;
        }

        String a() {
            int i10 = this.f3513a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f3513a;
            if (i10 != bVar.f3513a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f3516d - this.f3514b) == 1 && this.f3516d == bVar.f3514b && this.f3514b == bVar.f3516d) {
                return true;
            }
            if (this.f3516d != bVar.f3516d || this.f3514b != bVar.f3514b) {
                return false;
            }
            Object obj2 = this.f3515c;
            Object obj3 = bVar.f3515c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3513a * 31) + this.f3514b) * 31) + this.f3516d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f3514b + "c:" + this.f3516d + ",p:" + this.f3515c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0056a interfaceC0056a) {
        this(interfaceC0056a, false);
    }

    a(InterfaceC0056a interfaceC0056a, boolean z10) {
        this.f3505a = new androidx.core.util.f(30);
        this.f3506b = new ArrayList<>();
        this.f3507c = new ArrayList<>();
        this.f3512h = 0;
        this.f3508d = interfaceC0056a;
        this.f3510f = z10;
        this.f3511g = new i(this);
    }

    private void c(b bVar) {
        r(bVar);
    }

    private void d(b bVar) {
        r(bVar);
    }

    private void f(b bVar) {
        boolean z10;
        char c10;
        int i10 = bVar.f3514b;
        int i11 = bVar.f3516d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f3508d.c(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    r(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f3516d) {
            a(bVar);
            bVar = b(2, i10, i13, null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private void g(b bVar) {
        int i10 = bVar.f3514b;
        int i11 = bVar.f3516d + i10;
        int i12 = i10;
        char c10 = 65535;
        int i13 = 0;
        while (i10 < i11) {
            if (this.f3508d.c(i10) != null || h(i10)) {
                if (c10 == 0) {
                    k(b(4, i12, i13, bVar.f3515c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 1;
            } else {
                if (c10 == 1) {
                    r(b(4, i12, i13, bVar.f3515c));
                    i12 = i10;
                    i13 = 0;
                }
                c10 = 0;
            }
            i13++;
            i10++;
        }
        if (i13 != bVar.f3516d) {
            Object obj = bVar.f3515c;
            a(bVar);
            bVar = b(4, i12, i13, obj);
        }
        if (c10 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    private boolean h(int i10) {
        int size = this.f3507c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f3507c.get(i11);
            int i12 = bVar.f3513a;
            if (i12 == 8) {
                if (n(bVar.f3516d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f3514b;
                int i14 = bVar.f3516d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i10;
        int i11 = bVar.f3513a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int v10 = v(bVar.f3514b, i11);
        int i12 = bVar.f3514b;
        int i13 = bVar.f3513a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f3516d; i15++) {
            int v11 = v(bVar.f3514b + (i10 * i15), bVar.f3513a);
            int i16 = bVar.f3513a;
            if (i16 == 2 ? v11 == v10 : i16 == 4 && v11 == v10 + 1) {
                i14++;
            } else {
                b b10 = b(i16, v10, i14, bVar.f3515c);
                l(b10, i12);
                a(b10);
                if (bVar.f3513a == 4) {
                    i12 += i14;
                }
                v10 = v11;
                i14 = 1;
            }
        }
        Object obj = bVar.f3515c;
        a(bVar);
        if (i14 > 0) {
            b b11 = b(bVar.f3513a, v10, i14, obj);
            l(b11, i12);
            a(b11);
        }
    }

    private void r(b bVar) {
        this.f3507c.add(bVar);
        int i10 = bVar.f3513a;
        if (i10 == 1) {
            this.f3508d.e(bVar.f3514b, bVar.f3516d);
            return;
        }
        if (i10 == 2) {
            this.f3508d.d(bVar.f3514b, bVar.f3516d);
            return;
        }
        if (i10 == 4) {
            this.f3508d.h(bVar.f3514b, bVar.f3516d, bVar.f3515c);
        } else {
            if (i10 == 8) {
                this.f3508d.a(bVar.f3514b, bVar.f3516d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int v(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        for (int size = this.f3507c.size() - 1; size >= 0; size--) {
            b bVar = this.f3507c.get(size);
            int i18 = bVar.f3513a;
            if (i18 == 8) {
                int i19 = bVar.f3514b;
                int i20 = bVar.f3516d;
                if (i19 < i20) {
                    i14 = i19;
                    i13 = i20;
                } else {
                    i13 = i19;
                    i14 = i20;
                }
                if (i10 < i14 || i10 > i13) {
                    if (i10 < i19) {
                        if (i11 == 1) {
                            bVar.f3514b = i19 + 1;
                            i15 = i20 + 1;
                        } else if (i11 == 2) {
                            bVar.f3514b = i19 - 1;
                            i15 = i20 - 1;
                        }
                        bVar.f3516d = i15;
                    }
                } else if (i14 == i19) {
                    if (i11 == 1) {
                        i17 = i20 + 1;
                    } else {
                        if (i11 == 2) {
                            i17 = i20 - 1;
                        }
                        i10++;
                    }
                    bVar.f3516d = i17;
                    i10++;
                } else {
                    if (i11 == 1) {
                        i16 = i19 + 1;
                    } else {
                        if (i11 == 2) {
                            i16 = i19 - 1;
                        }
                        i10--;
                    }
                    bVar.f3514b = i16;
                    i10--;
                }
            } else {
                int i21 = bVar.f3514b;
                if (i21 > i10) {
                    if (i11 == 1) {
                        i12 = i21 + 1;
                    } else if (i11 == 2) {
                        i12 = i21 - 1;
                    }
                    bVar.f3514b = i12;
                } else if (i18 == 1) {
                    i10 -= bVar.f3516d;
                } else if (i18 == 2) {
                    i10 += bVar.f3516d;
                }
            }
        }
        for (int size2 = this.f3507c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f3507c.get(size2);
            if (bVar2.f3513a == 8) {
                int i22 = bVar2.f3516d;
                if (i22 != bVar2.f3514b && i22 >= 0) {
                }
                this.f3507c.remove(size2);
                a(bVar2);
            } else {
                if (bVar2.f3516d > 0) {
                }
                this.f3507c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }

    @Override // androidx.recyclerview.widget.i.a
    public void a(b bVar) {
        if (this.f3510f) {
            return;
        }
        bVar.f3515c = null;
        this.f3505a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.i.a
    public b b(int i10, int i11, int i12, Object obj) {
        b b10 = this.f3505a.b();
        if (b10 == null) {
            return new b(i10, i11, i12, obj);
        }
        b10.f3513a = i10;
        b10.f3514b = i11;
        b10.f3516d = i12;
        b10.f3515c = obj;
        return b10;
    }

    public int e(int i10) {
        int size = this.f3506b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f3506b.get(i11);
            int i12 = bVar.f3513a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f3514b;
                    if (i13 <= i10) {
                        int i14 = bVar.f3516d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f3514b;
                    if (i15 == i10) {
                        i10 = bVar.f3516d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f3516d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f3514b <= i10) {
                i10 += bVar.f3516d;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f3507c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3508d.b(this.f3507c.get(i10));
        }
        t(this.f3507c);
        this.f3512h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f3506b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f3506b.get(i10);
            int i11 = bVar.f3513a;
            if (i11 == 1) {
                this.f3508d.b(bVar);
                this.f3508d.e(bVar.f3514b, bVar.f3516d);
            } else if (i11 == 2) {
                this.f3508d.b(bVar);
                this.f3508d.f(bVar.f3514b, bVar.f3516d);
            } else if (i11 == 4) {
                this.f3508d.b(bVar);
                this.f3508d.h(bVar.f3514b, bVar.f3516d, bVar.f3515c);
            } else if (i11 == 8) {
                this.f3508d.b(bVar);
                this.f3508d.a(bVar.f3514b, bVar.f3516d);
            }
            Runnable runnable = this.f3509e;
            if (runnable != null) {
                runnable.run();
            }
        }
        t(this.f3506b);
        this.f3512h = 0;
    }

    void l(b bVar, int i10) {
        this.f3508d.g(bVar);
        int i11 = bVar.f3513a;
        if (i11 == 2) {
            this.f3508d.f(i10, bVar.f3516d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f3508d.h(i10, bVar.f3516d, bVar.f3515c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i10) {
        return n(i10, 0);
    }

    int n(int i10, int i11) {
        int size = this.f3507c.size();
        while (i11 < size) {
            b bVar = this.f3507c.get(i11);
            int i12 = bVar.f3513a;
            if (i12 == 8) {
                int i13 = bVar.f3514b;
                if (i13 == i10) {
                    i10 = bVar.f3516d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f3516d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f3514b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f3516d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f3516d;
                }
            }
            i11++;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i10) {
        return (i10 & this.f3512h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f3506b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return (this.f3507c.isEmpty() || this.f3506b.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f3511g.b(this.f3506b);
        int size = this.f3506b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f3506b.get(i10);
            int i11 = bVar.f3513a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f3509e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3506b.clear();
    }

    void t(List<b> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(list.get(i10));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        t(this.f3506b);
        t(this.f3507c);
        this.f3512h = 0;
    }
}
