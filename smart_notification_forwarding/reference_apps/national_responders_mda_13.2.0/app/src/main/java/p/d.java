package p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import m.i;
import q.o;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private int f12931b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12932c;

    /* renamed from: d, reason: collision with root package name */
    public final e f12933d;

    /* renamed from: e, reason: collision with root package name */
    public final b f12934e;

    /* renamed from: f, reason: collision with root package name */
    public d f12935f;

    /* renamed from: i, reason: collision with root package name */
    m.i f12938i;

    /* renamed from: a, reason: collision with root package name */
    private HashSet<d> f12930a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f12936g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f12937h = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12939a;

        static {
            int[] iArr = new int[b.values().length];
            f12939a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12939a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12939a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12939a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12939a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12939a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12939a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12939a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12939a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f12933d = eVar;
        this.f12934e = bVar;
    }

    public boolean a(d dVar, int i10, int i11, boolean z10) {
        if (dVar == null) {
            p();
            return true;
        }
        if (!z10 && !o(dVar)) {
            return false;
        }
        this.f12935f = dVar;
        if (dVar.f12930a == null) {
            dVar.f12930a = new HashSet<>();
        }
        HashSet<d> hashSet = this.f12935f.f12930a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f12936g = i10;
        this.f12937h = i11;
        return true;
    }

    public void b(int i10, ArrayList<o> arrayList, o oVar) {
        HashSet<d> hashSet = this.f12930a;
        if (hashSet != null) {
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                q.i.a(it.next().f12933d, i10, arrayList, oVar);
            }
        }
    }

    public HashSet<d> c() {
        return this.f12930a;
    }

    public int d() {
        if (this.f12932c) {
            return this.f12931b;
        }
        return 0;
    }

    public int e() {
        d dVar;
        if (this.f12933d.T() == 8) {
            return 0;
        }
        return (this.f12937h == Integer.MIN_VALUE || (dVar = this.f12935f) == null || dVar.f12933d.T() != 8) ? this.f12936g : this.f12937h;
    }

    public final d f() {
        switch (a.f12939a[this.f12934e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f12933d.N;
            case 3:
                return this.f12933d.L;
            case 4:
                return this.f12933d.O;
            case 5:
                return this.f12933d.M;
            default:
                throw new AssertionError(this.f12934e.name());
        }
    }

    public e g() {
        return this.f12933d;
    }

    public m.i h() {
        return this.f12938i;
    }

    public d i() {
        return this.f12935f;
    }

    public b j() {
        return this.f12934e;
    }

    public boolean k() {
        HashSet<d> hashSet = this.f12930a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().n()) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        HashSet<d> hashSet = this.f12930a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean m() {
        return this.f12932c;
    }

    public boolean n() {
        return this.f12935f != null;
    }

    public boolean o(d dVar) {
        if (dVar == null) {
            return false;
        }
        b j10 = dVar.j();
        b bVar = this.f12934e;
        if (j10 == bVar) {
            return bVar != b.BASELINE || (dVar.g().X() && g().X());
        }
        switch (a.f12939a[bVar.ordinal()]) {
            case 1:
                return (j10 == b.BASELINE || j10 == b.CENTER_X || j10 == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z10 = j10 == b.LEFT || j10 == b.RIGHT;
                if (dVar.g() instanceof g) {
                    return z10 || j10 == b.CENTER_X;
                }
                return z10;
            case 4:
            case 5:
                boolean z11 = j10 == b.TOP || j10 == b.BOTTOM;
                if (dVar.g() instanceof g) {
                    return z11 || j10 == b.CENTER_Y;
                }
                return z11;
            case 6:
                return (j10 == b.LEFT || j10 == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f12934e.name());
        }
    }

    public void p() {
        HashSet<d> hashSet;
        d dVar = this.f12935f;
        if (dVar != null && (hashSet = dVar.f12930a) != null) {
            hashSet.remove(this);
            if (this.f12935f.f12930a.size() == 0) {
                this.f12935f.f12930a = null;
            }
        }
        this.f12930a = null;
        this.f12935f = null;
        this.f12936g = 0;
        this.f12937h = Integer.MIN_VALUE;
        this.f12932c = false;
        this.f12931b = 0;
    }

    public void q() {
        this.f12932c = false;
        this.f12931b = 0;
    }

    public void r(m.c cVar) {
        m.i iVar = this.f12938i;
        if (iVar == null) {
            this.f12938i = new m.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.o();
        }
    }

    public void s(int i10) {
        this.f12931b = i10;
        this.f12932c = true;
    }

    public String toString() {
        return this.f12933d.r() + ":" + this.f12934e.toString();
    }
}
