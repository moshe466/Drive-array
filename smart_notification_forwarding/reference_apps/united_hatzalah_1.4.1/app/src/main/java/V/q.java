package V;

import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public int f2413a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final t f2414b;

    /* renamed from: c, reason: collision with root package name */
    public t f2415c;

    /* renamed from: d, reason: collision with root package name */
    public t f2416d;

    /* renamed from: e, reason: collision with root package name */
    public int f2417e;

    /* renamed from: f, reason: collision with root package name */
    public int f2418f;

    public q(t tVar) {
        this.f2414b = tVar;
        this.f2415c = tVar;
    }

    public final int a(int i) {
        t tVar;
        SparseArray sparseArray = this.f2415c.f2431a;
        if (sparseArray == null) {
            tVar = null;
        } else {
            tVar = (t) sparseArray.get(i);
        }
        int i3 = 1;
        int i4 = 2;
        if (this.f2413a != 2) {
            if (tVar == null) {
                b();
            } else {
                this.f2413a = 2;
                this.f2415c = tVar;
                this.f2418f = 1;
                i3 = i4;
            }
        } else {
            if (tVar != null) {
                this.f2415c = tVar;
                this.f2418f++;
            } else if (i == 65038) {
                b();
            } else if (i != 65039) {
                t tVar2 = this.f2415c;
                if (tVar2.f2432b != null) {
                    i4 = 3;
                    if (this.f2418f == 1) {
                        if (c()) {
                            this.f2416d = this.f2415c;
                            b();
                        } else {
                            b();
                        }
                    } else {
                        this.f2416d = tVar2;
                        b();
                    }
                } else {
                    b();
                }
            }
            i3 = i4;
        }
        this.f2417e = i;
        return i3;
    }

    public final void b() {
        this.f2413a = 1;
        this.f2415c = this.f2414b;
        this.f2418f = 0;
    }

    public final boolean c() {
        W.a b4 = this.f2415c.f2432b.b();
        int a2 = b4.a(6);
        if ((a2 != 0 && ((ByteBuffer) b4.f946d).get(a2 + b4.f943a) != 0) || this.f2417e == 65039) {
            return true;
        }
        return false;
    }
}
