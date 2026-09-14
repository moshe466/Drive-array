package androidx.fragment.app;

import F0.AbstractC0008a;
import F0.C0110z2;
import J.InterfaceC0123k;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.EnumC0304n;
import androidx.lifecycle.InterfaceC0309t;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.uh.sf.R;
import d0.C0355a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import l0.C0514d;
import l0.InterfaceC0516f;
import org.apache.tika.metadata.TikaCoreProperties;
import x.InterfaceC0776g;
import x.InterfaceC0777h;

/* renamed from: androidx.fragment.app.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0272g0 {

    /* renamed from: A, reason: collision with root package name */
    public final Z f3373A;

    /* renamed from: B, reason: collision with root package name */
    public final A.n f3374B;

    /* renamed from: C, reason: collision with root package name */
    public e.g f3375C;

    /* renamed from: D, reason: collision with root package name */
    public e.g f3376D;

    /* renamed from: E, reason: collision with root package name */
    public e.g f3377E;

    /* renamed from: F, reason: collision with root package name */
    public ArrayDeque f3378F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f3379G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f3380H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f3381I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f3382J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f3383K;

    /* renamed from: L, reason: collision with root package name */
    public ArrayList f3384L;

    /* renamed from: M, reason: collision with root package name */
    public ArrayList f3385M;

    /* renamed from: N, reason: collision with root package name */
    public ArrayList f3386N;

    /* renamed from: O, reason: collision with root package name */
    public k0 f3387O;

    /* renamed from: P, reason: collision with root package name */
    public final RunnableC0282q f3388P;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3390b;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f3393e;

    /* renamed from: g, reason: collision with root package name */
    public c.x f3395g;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f3401n;

    /* renamed from: o, reason: collision with root package name */
    public final M f3402o;
    public final CopyOnWriteArrayList p;

    /* renamed from: q, reason: collision with root package name */
    public final V f3403q;

    /* renamed from: r, reason: collision with root package name */
    public final V f3404r;

    /* renamed from: s, reason: collision with root package name */
    public final V f3405s;

    /* renamed from: t, reason: collision with root package name */
    public final V f3406t;

    /* renamed from: u, reason: collision with root package name */
    public final Y f3407u;

    /* renamed from: v, reason: collision with root package name */
    public int f3408v;

    /* renamed from: w, reason: collision with root package name */
    public S f3409w;

    /* renamed from: x, reason: collision with root package name */
    public O f3410x;
    public G y;

    /* renamed from: z, reason: collision with root package name */
    public G f3411z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3389a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final p0 f3391c = new p0();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f3392d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final U f3394f = new U(this);

    /* renamed from: h, reason: collision with root package name */
    public C0259a f3396h = null;
    public boolean i = false;

    /* renamed from: j, reason: collision with root package name */
    public final X f3397j = new X(this);

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f3398k = new AtomicInteger();

    /* renamed from: l, reason: collision with root package name */
    public final Map f3399l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    public final Map f3400m = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.fragment.app.V] */
    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.fragment.app.V] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.fragment.app.V] */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.fragment.app.V] */
    public AbstractC0272g0() {
        Collections.synchronizedMap(new HashMap());
        this.f3401n = new ArrayList();
        this.f3402o = new M(this);
        this.p = new CopyOnWriteArrayList();
        final int i = 0;
        this.f3403q = new I.a(this) { // from class: androidx.fragment.app.V

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC0272g0 f3328b;

            {
                this.f3328b = this;
            }

            @Override // I.a, androidx.window.extensions.core.util.function.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        AbstractC0272g0 abstractC0272g0 = this.f3328b;
                        if (abstractC0272g0.L()) {
                            abstractC0272g0.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        AbstractC0272g0 abstractC0272g02 = this.f3328b;
                        if (abstractC0272g02.L() && num.intValue() == 80) {
                            abstractC0272g02.m(false);
                            return;
                        }
                        return;
                    case 2:
                        w.g gVar = (w.g) obj;
                        AbstractC0272g0 abstractC0272g03 = this.f3328b;
                        if (abstractC0272g03.L()) {
                            abstractC0272g03.n(gVar.f6635a, false);
                            return;
                        }
                        return;
                    default:
                        w.s sVar = (w.s) obj;
                        AbstractC0272g0 abstractC0272g04 = this.f3328b;
                        if (abstractC0272g04.L()) {
                            abstractC0272g04.s(sVar.f6678a, false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i3 = 1;
        this.f3404r = new I.a(this) { // from class: androidx.fragment.app.V

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC0272g0 f3328b;

            {
                this.f3328b = this;
            }

            @Override // I.a, androidx.window.extensions.core.util.function.Consumer
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        AbstractC0272g0 abstractC0272g0 = this.f3328b;
                        if (abstractC0272g0.L()) {
                            abstractC0272g0.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        AbstractC0272g0 abstractC0272g02 = this.f3328b;
                        if (abstractC0272g02.L() && num.intValue() == 80) {
                            abstractC0272g02.m(false);
                            return;
                        }
                        return;
                    case 2:
                        w.g gVar = (w.g) obj;
                        AbstractC0272g0 abstractC0272g03 = this.f3328b;
                        if (abstractC0272g03.L()) {
                            abstractC0272g03.n(gVar.f6635a, false);
                            return;
                        }
                        return;
                    default:
                        w.s sVar = (w.s) obj;
                        AbstractC0272g0 abstractC0272g04 = this.f3328b;
                        if (abstractC0272g04.L()) {
                            abstractC0272g04.s(sVar.f6678a, false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i4 = 2;
        this.f3405s = new I.a(this) { // from class: androidx.fragment.app.V

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC0272g0 f3328b;

            {
                this.f3328b = this;
            }

            @Override // I.a, androidx.window.extensions.core.util.function.Consumer
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        AbstractC0272g0 abstractC0272g0 = this.f3328b;
                        if (abstractC0272g0.L()) {
                            abstractC0272g0.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        AbstractC0272g0 abstractC0272g02 = this.f3328b;
                        if (abstractC0272g02.L() && num.intValue() == 80) {
                            abstractC0272g02.m(false);
                            return;
                        }
                        return;
                    case 2:
                        w.g gVar = (w.g) obj;
                        AbstractC0272g0 abstractC0272g03 = this.f3328b;
                        if (abstractC0272g03.L()) {
                            abstractC0272g03.n(gVar.f6635a, false);
                            return;
                        }
                        return;
                    default:
                        w.s sVar = (w.s) obj;
                        AbstractC0272g0 abstractC0272g04 = this.f3328b;
                        if (abstractC0272g04.L()) {
                            abstractC0272g04.s(sVar.f6678a, false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i5 = 3;
        this.f3406t = new I.a(this) { // from class: androidx.fragment.app.V

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC0272g0 f3328b;

            {
                this.f3328b = this;
            }

            @Override // I.a, androidx.window.extensions.core.util.function.Consumer
            public final void accept(Object obj) {
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        AbstractC0272g0 abstractC0272g0 = this.f3328b;
                        if (abstractC0272g0.L()) {
                            abstractC0272g0.i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        AbstractC0272g0 abstractC0272g02 = this.f3328b;
                        if (abstractC0272g02.L() && num.intValue() == 80) {
                            abstractC0272g02.m(false);
                            return;
                        }
                        return;
                    case 2:
                        w.g gVar = (w.g) obj;
                        AbstractC0272g0 abstractC0272g03 = this.f3328b;
                        if (abstractC0272g03.L()) {
                            abstractC0272g03.n(gVar.f6635a, false);
                            return;
                        }
                        return;
                    default:
                        w.s sVar = (w.s) obj;
                        AbstractC0272g0 abstractC0272g04 = this.f3328b;
                        if (abstractC0272g04.L()) {
                            abstractC0272g04.s(sVar.f6678a, false);
                            return;
                        }
                        return;
                }
            }
        };
        this.f3407u = new Y(this);
        this.f3408v = -1;
        this.f3373A = new Z(this);
        this.f3374B = new A.n(28);
        this.f3378F = new ArrayDeque();
        this.f3388P = new RunnableC0282q(this, 2);
    }

    public static HashSet F(C0259a c0259a) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < c0259a.f3497a.size(); i++) {
            G g3 = ((q0) c0259a.f3497a.get(i)).f3489b;
            if (g3 != null && c0259a.f3503g) {
                hashSet.add(g3);
            }
        }
        return hashSet;
    }

    public static boolean J(int i) {
        if (Log.isLoggable("FragmentManager", i)) {
            return true;
        }
        return false;
    }

    public static boolean K(G g3) {
        if (!g3.mHasMenu || !g3.mMenuVisible) {
            ArrayList e4 = g3.mChildFragmentManager.f3391c.e();
            int size = e4.size();
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                Object obj = e4.get(i);
                i++;
                G g4 = (G) obj;
                if (g4 != null) {
                    z3 = K(g4);
                }
                if (z3) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean M(G g3) {
        if (g3 != null) {
            AbstractC0272g0 abstractC0272g0 = g3.mFragmentManager;
            if (g3.equals(abstractC0272g0.f3411z) && M(abstractC0272g0.y)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void A(C0259a c0259a, boolean z3) {
        if (z3 && (this.f3409w == null || this.f3382J)) {
            return;
        }
        y(z3);
        C0259a c0259a2 = this.f3396h;
        if (c0259a2 != null) {
            c0259a2.f3336r = false;
            c0259a2.e();
            if (J(3)) {
                Objects.toString(this.f3396h);
                Objects.toString(c0259a);
            }
            this.f3396h.f(false, false);
            this.f3396h.a(this.f3384L, this.f3385M);
            ArrayList arrayList = this.f3396h.f3497a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                G g3 = ((q0) obj).f3489b;
                if (g3 != null) {
                    g3.mTransitioning = false;
                }
            }
            this.f3396h = null;
        }
        c0259a.a(this.f3384L, this.f3385M);
        this.f3390b = true;
        try {
            U(this.f3384L, this.f3385M);
            d();
            d0();
            boolean z4 = this.f3383K;
            p0 p0Var = this.f3391c;
            if (z4) {
                this.f3383K = false;
                ArrayList d2 = p0Var.d();
                int size2 = d2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = d2.get(i3);
                    i3++;
                    o0 o0Var = (o0) obj2;
                    G g4 = o0Var.f3473c;
                    if (g4.mDeferStart) {
                        if (this.f3390b) {
                            this.f3383K = true;
                        } else {
                            g4.mDeferStart = false;
                            o0Var.i();
                        }
                    }
                }
            }
            p0Var.f3483b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:134:0x0230. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:171:0x0329. Please report as an issue. */
    public final void B(ArrayList arrayList, ArrayList arrayList2, int i, int i3) {
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        int i6;
        int i7;
        boolean z5;
        int i8;
        int i9;
        int i10 = i;
        boolean z6 = ((C0259a) arrayList.get(i10)).f3510o;
        ArrayList arrayList3 = this.f3386N;
        if (arrayList3 == null) {
            this.f3386N = new ArrayList();
        } else {
            arrayList3.clear();
        }
        ArrayList arrayList4 = this.f3386N;
        p0 p0Var = this.f3391c;
        arrayList4.addAll(p0Var.f());
        G g3 = this.f3411z;
        int i11 = i10;
        boolean z7 = false;
        while (true) {
            int i12 = 1;
            if (i11 < i3) {
                C0259a c0259a = (C0259a) arrayList.get(i11);
                if (!((Boolean) arrayList2.get(i11)).booleanValue()) {
                    ArrayList arrayList5 = this.f3386N;
                    ArrayList arrayList6 = c0259a.f3497a;
                    int i13 = 0;
                    while (i13 < arrayList6.size()) {
                        q0 q0Var = (q0) arrayList6.get(i13);
                        boolean z8 = z6;
                        int i14 = q0Var.f3488a;
                        if (i14 != i12) {
                            if (i14 != 2) {
                                if (i14 != 3 && i14 != 6) {
                                    if (i14 != 7) {
                                        if (i14 != 8) {
                                            i6 = i11;
                                        } else {
                                            i6 = i11;
                                            arrayList6.add(i13, new q0(g3, 9, 0));
                                            q0Var.f3490c = true;
                                            i13++;
                                            g3 = q0Var.f3489b;
                                        }
                                    } else {
                                        i6 = i11;
                                        i7 = 1;
                                    }
                                } else {
                                    i6 = i11;
                                    arrayList5.remove(q0Var.f3489b);
                                    G g4 = q0Var.f3489b;
                                    if (g4 == g3) {
                                        arrayList6.add(i13, new q0(g4, 9));
                                        i13++;
                                        z5 = z7;
                                        g3 = null;
                                        i7 = 1;
                                    }
                                }
                                z5 = z7;
                                i7 = 1;
                            } else {
                                i6 = i11;
                                G g5 = q0Var.f3489b;
                                int i15 = g5.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z9 = false;
                                while (size >= 0) {
                                    boolean z10 = z7;
                                    G g6 = (G) arrayList5.get(size);
                                    int i16 = size;
                                    if (g6.mContainerId == i15) {
                                        if (g6 == g5) {
                                            i8 = i15;
                                            z9 = true;
                                        } else {
                                            if (g6 == g3) {
                                                i8 = i15;
                                                i9 = 0;
                                                arrayList6.add(i13, new q0(g6, 9, 0));
                                                i13++;
                                                g3 = null;
                                            } else {
                                                i8 = i15;
                                                i9 = 0;
                                            }
                                            q0 q0Var2 = new q0(g6, 3, i9);
                                            q0Var2.f3491d = q0Var.f3491d;
                                            q0Var2.f3493f = q0Var.f3493f;
                                            q0Var2.f3492e = q0Var.f3492e;
                                            q0Var2.f3494g = q0Var.f3494g;
                                            arrayList6.add(i13, q0Var2);
                                            arrayList5.remove(g6);
                                            i13++;
                                            g3 = g3;
                                        }
                                    } else {
                                        i8 = i15;
                                    }
                                    size = i16 - 1;
                                    i15 = i8;
                                    z7 = z10;
                                }
                                z5 = z7;
                                i7 = 1;
                                if (z9) {
                                    arrayList6.remove(i13);
                                    i13--;
                                } else {
                                    q0Var.f3488a = 1;
                                    q0Var.f3490c = true;
                                    arrayList5.add(g5);
                                }
                            }
                            i13 += i7;
                            i12 = i7;
                            z6 = z8;
                            i11 = i6;
                            z7 = z5;
                        } else {
                            i6 = i11;
                            i7 = i12;
                        }
                        z5 = z7;
                        arrayList5.add(q0Var.f3489b);
                        i13 += i7;
                        i12 = i7;
                        z6 = z8;
                        i11 = i6;
                        z7 = z5;
                    }
                    z3 = z6;
                    i5 = i11;
                    z4 = z7;
                } else {
                    z3 = z6;
                    i5 = i11;
                    z4 = z7;
                    int i17 = 1;
                    ArrayList arrayList7 = this.f3386N;
                    ArrayList arrayList8 = c0259a.f3497a;
                    int size2 = arrayList8.size() - 1;
                    while (size2 >= 0) {
                        q0 q0Var3 = (q0) arrayList8.get(size2);
                        int i18 = q0Var3.f3488a;
                        if (i18 != i17) {
                            if (i18 != 3) {
                                switch (i18) {
                                    case 8:
                                        g3 = null;
                                        break;
                                    case 9:
                                        g3 = q0Var3.f3489b;
                                        break;
                                    case 10:
                                        q0Var3.i = q0Var3.f3495h;
                                        break;
                                }
                                size2--;
                                i17 = 1;
                            }
                            arrayList7.add(q0Var3.f3489b);
                            size2--;
                            i17 = 1;
                        }
                        arrayList7.remove(q0Var3.f3489b);
                        size2--;
                        i17 = 1;
                    }
                }
                if (!z4 && !c0259a.f3503g) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                i11 = i5 + 1;
                z6 = z3;
            } else {
                boolean z11 = z6;
                boolean z12 = z7;
                this.f3386N.clear();
                if (!z11 && this.f3408v >= 1) {
                    for (int i19 = i10; i19 < i3; i19++) {
                        ArrayList arrayList9 = ((C0259a) arrayList.get(i19)).f3497a;
                        int size3 = arrayList9.size();
                        int i20 = 0;
                        while (i20 < size3) {
                            Object obj = arrayList9.get(i20);
                            i20++;
                            G g7 = ((q0) obj).f3489b;
                            if (g7 != null && g7.mFragmentManager != null) {
                                p0Var.g(g(g7));
                            }
                        }
                    }
                }
                int i21 = i10;
                while (i21 < i3) {
                    C0259a c0259a2 = (C0259a) arrayList.get(i21);
                    if (((Boolean) arrayList2.get(i21)).booleanValue()) {
                        c0259a2.d(-1);
                        AbstractC0272g0 abstractC0272g0 = c0259a2.f3335q;
                        ArrayList arrayList10 = c0259a2.f3497a;
                        boolean z13 = true;
                        for (int size4 = arrayList10.size() - 1; size4 >= 0; size4--) {
                            q0 q0Var4 = (q0) arrayList10.get(size4);
                            G g8 = q0Var4.f3489b;
                            if (g8 != null) {
                                g8.mBeingSaved = false;
                                g8.setPopDirection(z13);
                                int i22 = c0259a2.f3502f;
                                int i23 = 8194;
                                int i24 = 4097;
                                if (i22 != 4097) {
                                    if (i22 != 8194) {
                                        i23 = 4100;
                                        if (i22 != 8197) {
                                            i24 = 4099;
                                            if (i22 != 4099) {
                                                if (i22 != 4100) {
                                                    i23 = 0;
                                                } else {
                                                    i23 = 8197;
                                                }
                                            }
                                        }
                                    }
                                    i23 = i24;
                                }
                                g8.setNextTransition(i23);
                                g8.setSharedElementNames(c0259a2.f3509n, c0259a2.f3508m);
                            }
                            switch (q0Var4.f3488a) {
                                case 1:
                                    g8.setAnimations(q0Var4.f3491d, q0Var4.f3492e, q0Var4.f3493f, q0Var4.f3494g);
                                    z13 = true;
                                    abstractC0272g0.Y(g8, true);
                                    abstractC0272g0.T(g8);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + q0Var4.f3488a);
                                case 3:
                                    g8.setAnimations(q0Var4.f3491d, q0Var4.f3492e, q0Var4.f3493f, q0Var4.f3494g);
                                    abstractC0272g0.a(g8);
                                    z13 = true;
                                case 4:
                                    g8.setAnimations(q0Var4.f3491d, q0Var4.f3492e, q0Var4.f3493f, q0Var4.f3494g);
                                    abstractC0272g0.getClass();
                                    if (J(2)) {
                                        Objects.toString(g8);
                                    }
                                    if (g8.mHidden) {
                                        g8.mHidden = false;
                                        g8.mHiddenChanged = !g8.mHiddenChanged;
                                    }
                                    z13 = true;
                                case 5:
                                    g8.setAnimations(q0Var4.f3491d, q0Var4.f3492e, q0Var4.f3493f, q0Var4.f3494g);
                                    abstractC0272g0.Y(g8, true);
                                    if (J(2)) {
                                        Objects.toString(g8);
                                    }
                                    if (!g8.mHidden) {
                                        g8.mHidden = true;
                                        g8.mHiddenChanged = !g8.mHiddenChanged;
                                        abstractC0272g0.b0(g8);
                                    }
                                    z13 = true;
                                case 6:
                                    g8.setAnimations(q0Var4.f3491d, q0Var4.f3492e, q0Var4.f3493f, q0Var4.f3494g);
                                    abstractC0272g0.c(g8);
                                    z13 = true;
                                case 7:
                                    g8.setAnimations(q0Var4.f3491d, q0Var4.f3492e, q0Var4.f3493f, q0Var4.f3494g);
                                    abstractC0272g0.Y(g8, true);
                                    abstractC0272g0.h(g8);
                                    z13 = true;
                                case 8:
                                    abstractC0272g0.a0(null);
                                    z13 = true;
                                case 9:
                                    abstractC0272g0.a0(g8);
                                    z13 = true;
                                case 10:
                                    q0Var4.i = g8.mMaxState;
                                    abstractC0272g0.Z(g8, q0Var4.f3495h);
                                    z13 = true;
                            }
                        }
                    } else {
                        c0259a2.d(1);
                        AbstractC0272g0 abstractC0272g02 = c0259a2.f3335q;
                        ArrayList arrayList11 = c0259a2.f3497a;
                        int size5 = arrayList11.size();
                        int i25 = 0;
                        while (i25 < size5) {
                            q0 q0Var5 = (q0) arrayList11.get(i25);
                            G g9 = q0Var5.f3489b;
                            if (g9 != null) {
                                g9.mBeingSaved = false;
                                g9.setPopDirection(false);
                                g9.setNextTransition(c0259a2.f3502f);
                                g9.setSharedElementNames(c0259a2.f3508m, c0259a2.f3509n);
                            }
                            switch (q0Var5.f3488a) {
                                case 1:
                                    i4 = i21;
                                    g9.setAnimations(q0Var5.f3491d, q0Var5.f3492e, q0Var5.f3493f, q0Var5.f3494g);
                                    abstractC0272g02.Y(g9, false);
                                    abstractC0272g02.a(g9);
                                    i25++;
                                    i21 = i4;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + q0Var5.f3488a);
                                case 3:
                                    i4 = i21;
                                    g9.setAnimations(q0Var5.f3491d, q0Var5.f3492e, q0Var5.f3493f, q0Var5.f3494g);
                                    abstractC0272g02.T(g9);
                                    i25++;
                                    i21 = i4;
                                case 4:
                                    i4 = i21;
                                    g9.setAnimations(q0Var5.f3491d, q0Var5.f3492e, q0Var5.f3493f, q0Var5.f3494g);
                                    abstractC0272g02.getClass();
                                    if (J(2)) {
                                        Objects.toString(g9);
                                    }
                                    if (!g9.mHidden) {
                                        g9.mHidden = true;
                                        g9.mHiddenChanged = !g9.mHiddenChanged;
                                        abstractC0272g02.b0(g9);
                                    }
                                    i25++;
                                    i21 = i4;
                                case 5:
                                    i4 = i21;
                                    g9.setAnimations(q0Var5.f3491d, q0Var5.f3492e, q0Var5.f3493f, q0Var5.f3494g);
                                    abstractC0272g02.Y(g9, false);
                                    if (J(2)) {
                                        Objects.toString(g9);
                                    }
                                    if (g9.mHidden) {
                                        g9.mHidden = false;
                                        g9.mHiddenChanged = !g9.mHiddenChanged;
                                    }
                                    i25++;
                                    i21 = i4;
                                case 6:
                                    i4 = i21;
                                    g9.setAnimations(q0Var5.f3491d, q0Var5.f3492e, q0Var5.f3493f, q0Var5.f3494g);
                                    abstractC0272g02.h(g9);
                                    i25++;
                                    i21 = i4;
                                case 7:
                                    i4 = i21;
                                    g9.setAnimations(q0Var5.f3491d, q0Var5.f3492e, q0Var5.f3493f, q0Var5.f3494g);
                                    abstractC0272g02.Y(g9, false);
                                    abstractC0272g02.c(g9);
                                    i25++;
                                    i21 = i4;
                                case 8:
                                    abstractC0272g02.a0(g9);
                                    i4 = i21;
                                    i25++;
                                    i21 = i4;
                                case 9:
                                    abstractC0272g02.a0(null);
                                    i4 = i21;
                                    i25++;
                                    i21 = i4;
                                case 10:
                                    q0Var5.f3495h = g9.mMaxState;
                                    abstractC0272g02.Z(g9, q0Var5.i);
                                    i4 = i21;
                                    i25++;
                                    i21 = i4;
                            }
                        }
                    }
                    i21++;
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
                ArrayList arrayList12 = this.f3401n;
                if (z12 && !arrayList12.isEmpty()) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int size6 = arrayList.size();
                    int i26 = 0;
                    while (i26 < size6) {
                        Object obj2 = arrayList.get(i26);
                        i26++;
                        linkedHashSet.addAll(F((C0259a) obj2));
                    }
                    if (this.f3396h == null) {
                        int size7 = arrayList12.size();
                        int i27 = 0;
                        while (i27 < size7) {
                            Object obj3 = arrayList12.get(i27);
                            i27++;
                            if (obj3 == null) {
                                Iterator it = linkedHashSet.iterator();
                                if (it.hasNext()) {
                                    throw null;
                                }
                            } else {
                                throw new ClassCastException();
                            }
                        }
                        int size8 = arrayList12.size();
                        int i28 = 0;
                        while (i28 < size8) {
                            Object obj4 = arrayList12.get(i28);
                            i28++;
                            if (obj4 == null) {
                                Iterator it2 = linkedHashSet.iterator();
                                if (it2.hasNext()) {
                                    throw null;
                                }
                            } else {
                                throw new ClassCastException();
                            }
                        }
                    }
                }
                for (int i29 = i10; i29 < i3; i29++) {
                    C0259a c0259a3 = (C0259a) arrayList.get(i29);
                    if (booleanValue) {
                        for (int size9 = c0259a3.f3497a.size() - 1; size9 >= 0; size9--) {
                            G g10 = ((q0) c0259a3.f3497a.get(size9)).f3489b;
                            if (g10 != null) {
                                g(g10).i();
                            }
                        }
                    } else {
                        ArrayList arrayList13 = c0259a3.f3497a;
                        int size10 = arrayList13.size();
                        int i30 = 0;
                        while (i30 < size10) {
                            Object obj5 = arrayList13.get(i30);
                            i30++;
                            G g11 = ((q0) obj5).f3489b;
                            if (g11 != null) {
                                g(g11).i();
                            }
                        }
                    }
                }
                O(this.f3408v, true);
                Iterator it3 = f(arrayList, i10, i3).iterator();
                while (it3.hasNext()) {
                    C0281p c0281p = (C0281p) it3.next();
                    c0281p.f3480e = booleanValue;
                    c0281p.l();
                    c0281p.e();
                }
                while (i10 < i3) {
                    C0259a c0259a4 = (C0259a) arrayList.get(i10);
                    if (((Boolean) arrayList2.get(i10)).booleanValue() && c0259a4.f3337s >= 0) {
                        c0259a4.f3337s = -1;
                    }
                    if (c0259a4.p != null) {
                        for (int i31 = 0; i31 < c0259a4.p.size(); i31++) {
                            ((Runnable) c0259a4.p.get(i31)).run();
                        }
                        c0259a4.p = null;
                    }
                    i10++;
                }
                if (z12 && arrayList12.size() > 0) {
                    throw e0.a.b(0, arrayList12);
                }
                return;
            }
        }
    }

    public final G C(int i) {
        p0 p0Var = this.f3391c;
        ArrayList arrayList = p0Var.f3482a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            G g3 = (G) arrayList.get(size);
            if (g3 != null && g3.mFragmentId == i) {
                return g3;
            }
        }
        for (o0 o0Var : p0Var.f3483b.values()) {
            if (o0Var != null) {
                G g4 = o0Var.f3473c;
                if (g4.mFragmentId == i) {
                    return g4;
                }
            }
        }
        return null;
    }

    public final G D(String str) {
        p0 p0Var = this.f3391c;
        ArrayList arrayList = p0Var.f3482a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            G g3 = (G) arrayList.get(size);
            if (g3 != null && str.equals(g3.mTag)) {
                return g3;
            }
        }
        for (o0 o0Var : p0Var.f3483b.values()) {
            if (o0Var != null) {
                G g4 = o0Var.f3473c;
                if (str.equals(g4.mTag)) {
                    return g4;
                }
            }
        }
        return null;
    }

    public final void E() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            C0281p c0281p = (C0281p) it.next();
            if (c0281p.f3481f) {
                J(2);
                c0281p.f3481f = false;
                c0281p.e();
            }
        }
    }

    public final ViewGroup G(G g3) {
        ViewGroup viewGroup = g3.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (g3.mContainerId > 0 && this.f3410x.c()) {
            View b4 = this.f3410x.b(g3.mContainerId);
            if (b4 instanceof ViewGroup) {
                return (ViewGroup) b4;
            }
            return null;
        }
        return null;
    }

    public final Z H() {
        G g3 = this.y;
        if (g3 != null) {
            return g3.mFragmentManager.H();
        }
        return this.f3373A;
    }

    public final A.n I() {
        G g3 = this.y;
        if (g3 != null) {
            return g3.mFragmentManager.I();
        }
        return this.f3374B;
    }

    public final boolean L() {
        G g3 = this.y;
        if (g3 == null) {
            return true;
        }
        if (g3.isAdded() && this.y.getParentFragmentManager().L()) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        if (!this.f3380H && !this.f3381I) {
            return false;
        }
        return true;
    }

    public final void O(int i, boolean z3) {
        S s3;
        if (this.f3409w == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z3 || i != this.f3408v) {
            this.f3408v = i;
            p0 p0Var = this.f3391c;
            HashMap hashMap = p0Var.f3483b;
            ArrayList arrayList = p0Var.f3482a;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                o0 o0Var = (o0) hashMap.get(((G) obj).mWho);
                if (o0Var != null) {
                    o0Var.i();
                }
            }
            for (o0 o0Var2 : hashMap.values()) {
                if (o0Var2 != null) {
                    o0Var2.i();
                    G g3 = o0Var2.f3473c;
                    if (g3.mRemoving && !g3.isInBackStack()) {
                        if (g3.mBeingSaved && !p0Var.f3484c.containsKey(g3.mWho)) {
                            p0Var.i(o0Var2.l(), g3.mWho);
                        }
                        p0Var.h(o0Var2);
                    }
                }
            }
            ArrayList d2 = p0Var.d();
            int size2 = d2.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = d2.get(i4);
                i4++;
                o0 o0Var3 = (o0) obj2;
                G g4 = o0Var3.f3473c;
                if (g4.mDeferStart) {
                    if (this.f3390b) {
                        this.f3383K = true;
                    } else {
                        g4.mDeferStart = false;
                        o0Var3.i();
                    }
                }
            }
            if (this.f3379G && (s3 = this.f3409w) != null && this.f3408v == 7) {
                ((K) s3).f3307e.invalidateMenu();
                this.f3379G = false;
            }
        }
    }

    public final void P() {
        if (this.f3409w != null) {
            this.f3380H = false;
            this.f3381I = false;
            this.f3387O.f3432g = false;
            for (G g3 : this.f3391c.f()) {
                if (g3 != null) {
                    g3.noteStateNotSaved();
                }
            }
        }
    }

    public final boolean Q() {
        return R(-1, 0);
    }

    public final boolean R(int i, int i3) {
        z(false);
        y(true);
        G g3 = this.f3411z;
        if (g3 != null && i < 0 && g3.getChildFragmentManager().Q()) {
            return true;
        }
        boolean S3 = S(this.f3384L, this.f3385M, i, i3);
        if (S3) {
            this.f3390b = true;
            try {
                U(this.f3384L, this.f3385M);
            } finally {
                d();
            }
        }
        d0();
        boolean z3 = this.f3383K;
        p0 p0Var = this.f3391c;
        if (z3) {
            this.f3383K = false;
            ArrayList d2 = p0Var.d();
            int size = d2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = d2.get(i4);
                i4++;
                o0 o0Var = (o0) obj;
                G g4 = o0Var.f3473c;
                if (g4.mDeferStart) {
                    if (this.f3390b) {
                        this.f3383K = true;
                    } else {
                        g4.mDeferStart = false;
                        o0Var.i();
                    }
                }
            }
        }
        p0Var.f3483b.values().removeAll(Collections.singleton(null));
        return S3;
    }

    public final boolean S(ArrayList arrayList, ArrayList arrayList2, int i, int i3) {
        boolean z3;
        if ((i3 & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i4 = -1;
        if (!this.f3392d.isEmpty()) {
            if (i < 0) {
                i4 = z3 ? 0 : this.f3392d.size() - 1;
            } else {
                int size = this.f3392d.size() - 1;
                while (size >= 0) {
                    C0259a c0259a = (C0259a) this.f3392d.get(size);
                    if (i >= 0 && i == c0259a.f3337s) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    i4 = size;
                } else if (z3) {
                    i4 = size;
                    while (i4 > 0) {
                        C0259a c0259a2 = (C0259a) this.f3392d.get(i4 - 1);
                        if (i < 0 || i != c0259a2.f3337s) {
                            break;
                        }
                        i4--;
                    }
                } else if (size != this.f3392d.size() - 1) {
                    i4 = size + 1;
                }
            }
        }
        if (i4 < 0) {
            return false;
        }
        for (int size2 = this.f3392d.size() - 1; size2 >= i4; size2--) {
            arrayList.add((C0259a) this.f3392d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void T(G g3) {
        if (J(2)) {
            Objects.toString(g3);
        }
        boolean isInBackStack = g3.isInBackStack();
        if (g3.mDetached && isInBackStack) {
            return;
        }
        p0 p0Var = this.f3391c;
        synchronized (p0Var.f3482a) {
            p0Var.f3482a.remove(g3);
        }
        g3.mAdded = false;
        if (K(g3)) {
            this.f3379G = true;
        }
        g3.mRemoving = true;
        b0(g3);
    }

    public final void U(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i = 0;
                int i3 = 0;
                while (i < size) {
                    if (!((C0259a) arrayList.get(i)).f3510o) {
                        if (i3 != i) {
                            B(arrayList, arrayList2, i3, i);
                        }
                        i3 = i + 1;
                        if (((Boolean) arrayList2.get(i)).booleanValue()) {
                            while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C0259a) arrayList.get(i3)).f3510o) {
                                i3++;
                            }
                        }
                        B(arrayList, arrayList2, i, i3);
                        i = i3 - 1;
                    }
                    i++;
                }
                if (i3 != size) {
                    B(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [androidx.fragment.app.q0, java.lang.Object] */
    public final void V(Bundle bundle) {
        M m4;
        int i;
        int i3;
        boolean z3;
        o0 o0Var;
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle4 = bundle.getBundle(str)) != null) {
                bundle4.setClassLoader(this.f3409w.f3321b.getClassLoader());
                this.f3400m.put(str.substring(7), bundle4);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle3 = bundle.getBundle(str2)) != null) {
                bundle3.setClassLoader(this.f3409w.f3321b.getClassLoader());
                hashMap.put(str2.substring(9), bundle3);
            }
        }
        p0 p0Var = this.f3391c;
        HashMap hashMap2 = p0Var.f3484c;
        HashMap hashMap3 = p0Var.f3483b;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        i0 i0Var = (i0) bundle.getParcelable(RemoteConfigConstants.ResponseFieldKey.STATE);
        if (i0Var == null) {
            return;
        }
        hashMap3.clear();
        ArrayList arrayList = i0Var.f3415a;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            m4 = this.f3402o;
            i = 2;
            if (i4 >= size) {
                break;
            }
            Object obj = arrayList.get(i4);
            i4++;
            Bundle i5 = p0Var.i(null, (String) obj);
            if (i5 != null) {
                G g3 = (G) this.f3387O.f3427b.get(((m0) i5.getParcelable(RemoteConfigConstants.ResponseFieldKey.STATE)).f3441b);
                if (g3 != null) {
                    if (J(2)) {
                        g3.toString();
                    }
                    o0Var = new o0(m4, p0Var, g3, i5);
                    bundle2 = i5;
                } else {
                    o0Var = new o0(this.f3402o, this.f3391c, this.f3409w.f3321b.getClassLoader(), H(), i5);
                    bundle2 = i5;
                }
                G g4 = o0Var.f3473c;
                g4.mSavedFragmentState = bundle2;
                g4.mFragmentManager = this;
                if (J(2)) {
                    g4.toString();
                }
                o0Var.j(this.f3409w.f3321b.getClassLoader());
                p0Var.g(o0Var);
                o0Var.f3475e = this.f3408v;
            }
        }
        k0 k0Var = this.f3387O;
        k0Var.getClass();
        ArrayList arrayList2 = new ArrayList(k0Var.f3427b.values());
        int size2 = arrayList2.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj2 = arrayList2.get(i6);
            i6++;
            G g5 = (G) obj2;
            if (hashMap3.get(g5.mWho) == null) {
                if (J(2)) {
                    g5.toString();
                    Objects.toString(i0Var.f3415a);
                }
                this.f3387O.f(g5);
                g5.mFragmentManager = this;
                o0 o0Var2 = new o0(m4, p0Var, g5);
                o0Var2.f3475e = 1;
                o0Var2.i();
                g5.mRemoving = true;
                o0Var2.i();
            }
        }
        ArrayList arrayList3 = i0Var.f3416b;
        p0Var.f3482a.clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i7 = 0;
            while (i7 < size3) {
                Object obj3 = arrayList3.get(i7);
                i7++;
                String str3 = (String) obj3;
                G b4 = p0Var.b(str3);
                if (b4 != null) {
                    if (J(2)) {
                        b4.toString();
                    }
                    p0Var.a(b4);
                } else {
                    throw new IllegalStateException(e0.a.e("No instantiated fragment for (", str3, ")"));
                }
            }
        }
        if (i0Var.f3417c != null) {
            this.f3392d = new ArrayList(i0Var.f3417c.length);
            int i8 = 0;
            while (true) {
                C0261b[] c0261bArr = i0Var.f3417c;
                if (i8 >= c0261bArr.length) {
                    break;
                }
                C0261b c0261b = c0261bArr[i8];
                ArrayList arrayList4 = c0261b.f3340b;
                C0259a c0259a = new C0259a(this);
                int[] iArr = c0261b.f3339a;
                int i9 = 0;
                int i10 = 0;
                while (i9 < iArr.length) {
                    ?? obj4 = new Object();
                    int i11 = i9 + 1;
                    obj4.f3488a = iArr[i9];
                    if (J(i)) {
                        Objects.toString(c0259a);
                        int i12 = iArr[i11];
                    }
                    int i13 = i;
                    obj4.f3495h = EnumC0304n.values()[c0261b.f3341c[i10]];
                    obj4.i = EnumC0304n.values()[c0261b.f3342d[i10]];
                    int i14 = i9 + 2;
                    if (iArr[i11] != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    obj4.f3490c = z3;
                    int i15 = iArr[i14];
                    obj4.f3491d = i15;
                    int i16 = iArr[i9 + 3];
                    obj4.f3492e = i16;
                    int i17 = i9 + 5;
                    int i18 = iArr[i9 + 4];
                    obj4.f3493f = i18;
                    i9 += 6;
                    int i19 = iArr[i17];
                    obj4.f3494g = i19;
                    c0259a.f3498b = i15;
                    c0259a.f3499c = i16;
                    c0259a.f3500d = i18;
                    c0259a.f3501e = i19;
                    c0259a.b(obj4);
                    i10++;
                    i = i13;
                }
                int i20 = i;
                c0259a.f3502f = c0261b.f3343e;
                c0259a.f3504h = c0261b.f3344f;
                c0259a.f3503g = true;
                c0259a.i = c0261b.f3346k;
                c0259a.f3505j = c0261b.f3347l;
                c0259a.f3506k = c0261b.f3348m;
                c0259a.f3507l = c0261b.f3349n;
                c0259a.f3508m = c0261b.f3350o;
                c0259a.f3509n = c0261b.p;
                c0259a.f3510o = c0261b.f3351q;
                c0259a.f3337s = c0261b.f3345j;
                for (int i21 = 0; i21 < arrayList4.size(); i21++) {
                    String str4 = (String) arrayList4.get(i21);
                    if (str4 != null) {
                        ((q0) c0259a.f3497a.get(i21)).f3489b = p0Var.b(str4);
                    }
                }
                c0259a.d(1);
                if (J(i20)) {
                    c0259a.toString();
                    PrintWriter printWriter = new PrintWriter(new B0());
                    c0259a.g("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3392d.add(c0259a);
                i8++;
                i = i20;
            }
            i3 = 0;
        } else {
            i3 = 0;
            this.f3392d = new ArrayList();
        }
        this.f3398k.set(i0Var.f3418d);
        String str5 = i0Var.f3419e;
        if (str5 != null) {
            G b5 = p0Var.b(str5);
            this.f3411z = b5;
            r(b5);
        }
        ArrayList arrayList5 = i0Var.f3420f;
        if (arrayList5 != null) {
            while (i3 < arrayList5.size()) {
                this.f3399l.put((String) arrayList5.get(i3), (C0263c) i0Var.f3421j.get(i3));
                i3++;
            }
        }
        this.f3378F = new ArrayDeque(i0Var.f3422k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [androidx.fragment.app.i0, android.os.Parcelable, java.lang.Object] */
    public final Bundle W() {
        int i;
        ArrayList arrayList;
        C0261b[] c0261bArr;
        Bundle bundle = new Bundle();
        E();
        w();
        z(true);
        this.f3380H = true;
        this.f3387O.f3432g = true;
        p0 p0Var = this.f3391c;
        p0Var.getClass();
        HashMap hashMap = p0Var.f3483b;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (o0 o0Var : hashMap.values()) {
            if (o0Var != null) {
                G g3 = o0Var.f3473c;
                p0Var.i(o0Var.l(), g3.mWho);
                arrayList2.add(g3.mWho);
                if (J(2)) {
                    g3.toString();
                    Objects.toString(g3.mSavedFragmentState);
                }
            }
        }
        HashMap hashMap2 = this.f3391c.f3484c;
        if (hashMap2.isEmpty()) {
            J(2);
            return bundle;
        }
        p0 p0Var2 = this.f3391c;
        synchronized (p0Var2.f3482a) {
            try {
                if (p0Var2.f3482a.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(p0Var2.f3482a.size());
                    ArrayList arrayList3 = p0Var2.f3482a;
                    int size = arrayList3.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList3.get(i3);
                        i3++;
                        G g4 = (G) obj;
                        arrayList.add(g4.mWho);
                        if (J(2)) {
                            g4.toString();
                        }
                    }
                }
            } finally {
            }
        }
        int size2 = this.f3392d.size();
        if (size2 > 0) {
            c0261bArr = new C0261b[size2];
            for (i = 0; i < size2; i++) {
                c0261bArr[i] = new C0261b((C0259a) this.f3392d.get(i));
                if (J(2)) {
                    Objects.toString(this.f3392d.get(i));
                }
            }
        } else {
            c0261bArr = null;
        }
        ?? obj2 = new Object();
        obj2.f3419e = null;
        ArrayList arrayList4 = new ArrayList();
        obj2.f3420f = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        obj2.f3421j = arrayList5;
        obj2.f3415a = arrayList2;
        obj2.f3416b = arrayList;
        obj2.f3417c = c0261bArr;
        obj2.f3418d = this.f3398k.get();
        G g5 = this.f3411z;
        if (g5 != null) {
            obj2.f3419e = g5.mWho;
        }
        arrayList4.addAll(this.f3399l.keySet());
        arrayList5.addAll(this.f3399l.values());
        obj2.f3422k = new ArrayList(this.f3378F);
        bundle.putParcelable(RemoteConfigConstants.ResponseFieldKey.STATE, obj2);
        for (String str : this.f3400m.keySet()) {
            bundle.putBundle(e0.a.d("result_", str), (Bundle) this.f3400m.get(str));
        }
        for (String str2 : hashMap2.keySet()) {
            bundle.putBundle(e0.a.d("fragment_", str2), (Bundle) hashMap2.get(str2));
        }
        return bundle;
    }

    public final void X() {
        synchronized (this.f3389a) {
            try {
                if (this.f3389a.size() == 1) {
                    this.f3409w.f3322c.removeCallbacks(this.f3388P);
                    this.f3409w.f3322c.post(this.f3388P);
                    d0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Y(G g3, boolean z3) {
        ViewGroup G3 = G(g3);
        if (G3 != null && (G3 instanceof P)) {
            ((P) G3).setDrawDisappearingViewsLast(!z3);
        }
    }

    public final void Z(G g3, EnumC0304n enumC0304n) {
        if (g3.equals(this.f3391c.b(g3.mWho)) && (g3.mHost == null || g3.mFragmentManager == this)) {
            g3.mMaxState = enumC0304n;
            return;
        }
        throw new IllegalArgumentException("Fragment " + g3 + " is not an active fragment of FragmentManager " + this);
    }

    public final o0 a(G g3) {
        String str = g3.mPreviousWho;
        if (str != null) {
            a0.c.c(g3, str);
        }
        if (J(2)) {
            g3.toString();
        }
        o0 g4 = g(g3);
        g3.mFragmentManager = this;
        p0 p0Var = this.f3391c;
        p0Var.g(g4);
        if (!g3.mDetached) {
            p0Var.a(g3);
            g3.mRemoving = false;
            if (g3.mView == null) {
                g3.mHiddenChanged = false;
            }
            if (K(g3)) {
                this.f3379G = true;
            }
        }
        return g4;
    }

    public final void a0(G g3) {
        if (g3 != null) {
            if (!g3.equals(this.f3391c.b(g3.mWho)) || (g3.mHost != null && g3.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + g3 + " is not an active fragment of FragmentManager " + this);
            }
        }
        G g4 = this.f3411z;
        this.f3411z = g3;
        r(g4);
        r(this.f3411z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(S s3, O o2, G g3) {
        String str;
        if (this.f3409w == null) {
            this.f3409w = s3;
            this.f3410x = o2;
            this.y = g3;
            CopyOnWriteArrayList copyOnWriteArrayList = this.p;
            if (g3 != null) {
                copyOnWriteArrayList.add(new C0260a0(g3));
            } else if (s3 instanceof l0) {
                copyOnWriteArrayList.add((l0) s3);
            }
            if (this.y != null) {
                d0();
            }
            if (s3 instanceof c.y) {
                c.y yVar = (c.y) s3;
                c.x onBackPressedDispatcher = yVar.getOnBackPressedDispatcher();
                this.f3395g = onBackPressedDispatcher;
                InterfaceC0309t interfaceC0309t = yVar;
                if (g3 != null) {
                    interfaceC0309t = g3;
                }
                onBackPressedDispatcher.a(interfaceC0309t, this.f3397j);
            }
            if (g3 != null) {
                k0 k0Var = g3.mFragmentManager.f3387O;
                HashMap hashMap = k0Var.f3428c;
                k0 k0Var2 = (k0) hashMap.get(g3.mWho);
                if (k0Var2 == null) {
                    k0Var2 = new k0(k0Var.f3430e);
                    hashMap.put(g3.mWho, k0Var2);
                }
                this.f3387O = k0Var2;
            } else if (s3 instanceof androidx.lifecycle.a0) {
                androidx.lifecycle.Z store = ((androidx.lifecycle.a0) s3).getViewModelStore();
                kotlin.jvm.internal.j.e(store, "store");
                C0355a defaultCreationExtras = C0355a.f4411b;
                kotlin.jvm.internal.j.e(defaultCreationExtras, "defaultCreationExtras");
                C0110z2 c0110z2 = new C0110z2(store, k0.f3426h, defaultCreationExtras);
                kotlin.jvm.internal.e a2 = kotlin.jvm.internal.s.a(k0.class);
                String b4 = a2.b();
                if (b4 != null) {
                    this.f3387O = (k0) c0110z2.r(a2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(b4));
                } else {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
            } else {
                this.f3387O = new k0(false);
            }
            this.f3387O.f3432g = N();
            this.f3391c.f3485d = this.f3387O;
            Object obj = this.f3409w;
            if ((obj instanceof InterfaceC0516f) && g3 == null) {
                C0514d savedStateRegistry = ((InterfaceC0516f) obj).getSavedStateRegistry();
                savedStateRegistry.c("android:support:fragments", new H(this, 1));
                Bundle a4 = savedStateRegistry.a("android:support:fragments");
                if (a4 != null) {
                    V(a4);
                }
            }
            Object obj2 = this.f3409w;
            if (obj2 instanceof e.i) {
                e.h activityResultRegistry = ((e.i) obj2).getActivityResultRegistry();
                if (g3 != null) {
                    str = AbstractC0008a.u(new StringBuilder(), g3.mWho, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
                } else {
                    str = "";
                }
                String d2 = e0.a.d("FragmentManager:", str);
                this.f3375C = activityResultRegistry.d(AbstractC0008a.n(d2, "StartActivityForResult"), new C0262b0(3), new W(this, 1));
                this.f3376D = activityResultRegistry.d(AbstractC0008a.n(d2, "StartIntentSenderForResult"), new C0262b0(0), new W(this, 2));
                this.f3377E = activityResultRegistry.d(AbstractC0008a.n(d2, "RequestPermissions"), new C0262b0(2), new W(this, 0));
            }
            Object obj3 = this.f3409w;
            if (obj3 instanceof InterfaceC0776g) {
                ((InterfaceC0776g) obj3).addOnConfigurationChangedListener(this.f3403q);
            }
            Object obj4 = this.f3409w;
            if (obj4 instanceof InterfaceC0777h) {
                ((InterfaceC0777h) obj4).addOnTrimMemoryListener(this.f3404r);
            }
            Object obj5 = this.f3409w;
            if (obj5 instanceof w.q) {
                ((w.q) obj5).addOnMultiWindowModeChangedListener(this.f3405s);
            }
            Object obj6 = this.f3409w;
            if (obj6 instanceof w.r) {
                ((w.r) obj6).addOnPictureInPictureModeChangedListener(this.f3406t);
            }
            Object obj7 = this.f3409w;
            if ((obj7 instanceof InterfaceC0123k) && g3 == null) {
                ((InterfaceC0123k) obj7).addMenuProvider(this.f3407u);
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void b0(G g3) {
        ViewGroup G3 = G(g3);
        if (G3 != null) {
            if (g3.getPopExitAnim() + g3.getPopEnterAnim() + g3.getExitAnim() + g3.getEnterAnim() > 0) {
                if (G3.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    G3.setTag(R.id.visible_removing_fragment_view_tag, g3);
                }
                ((G) G3.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(g3.getPopDirection());
            }
        }
    }

    public final void c(G g3) {
        if (J(2)) {
            Objects.toString(g3);
        }
        if (g3.mDetached) {
            g3.mDetached = false;
            if (!g3.mAdded) {
                this.f3391c.a(g3);
                if (J(2)) {
                    g3.toString();
                }
                if (K(g3)) {
                    this.f3379G = true;
                }
            }
        }
    }

    public final void c0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new B0());
        S s3 = this.f3409w;
        if (s3 != null) {
            try {
                ((K) s3).f3307e.dump("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e4) {
                Log.e("FragmentManager", "Failed dumping state", e4);
                throw illegalStateException;
            }
        }
        try {
            v("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e5) {
            Log.e("FragmentManager", "Failed dumping state", e5);
            throw illegalStateException;
        }
    }

    public final void d() {
        this.f3390b = false;
        this.f3385M.clear();
        this.f3384L.clear();
    }

    public final void d0() {
        int i;
        synchronized (this.f3389a) {
            try {
                boolean z3 = true;
                if (!this.f3389a.isEmpty()) {
                    this.f3397j.setEnabled(true);
                    if (J(3)) {
                        toString();
                    }
                    return;
                }
                int size = this.f3392d.size();
                if (this.f3396h != null) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (size + i <= 0 || !M(this.y)) {
                    z3 = false;
                }
                if (J(3)) {
                    toString();
                }
                this.f3397j.setEnabled(z3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final HashSet e() {
        C0281p c0281p;
        HashSet hashSet = new HashSet();
        ArrayList d2 = this.f3391c.d();
        int size = d2.size();
        int i = 0;
        while (i < size) {
            Object obj = d2.get(i);
            i++;
            ViewGroup viewGroup = ((o0) obj).f3473c.mContainer;
            if (viewGroup != null) {
                A.n factory = I();
                kotlin.jvm.internal.j.e(factory, "factory");
                Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
                if (tag instanceof C0281p) {
                    c0281p = (C0281p) tag;
                } else {
                    c0281p = new C0281p(viewGroup);
                    viewGroup.setTag(R.id.special_effects_controller_view_tag, c0281p);
                }
                hashSet.add(c0281p);
            }
        }
        return hashSet;
    }

    public final HashSet f(ArrayList arrayList, int i, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i3) {
            ArrayList arrayList2 = ((C0259a) arrayList.get(i)).f3497a;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                G g3 = ((q0) obj).f3489b;
                if (g3 != null && (viewGroup = g3.mContainer) != null) {
                    hashSet.add(C0281p.j(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    public final o0 g(G g3) {
        String str = g3.mWho;
        p0 p0Var = this.f3391c;
        o0 o0Var = (o0) p0Var.f3483b.get(str);
        if (o0Var != null) {
            return o0Var;
        }
        o0 o0Var2 = new o0(this.f3402o, p0Var, g3);
        o0Var2.j(this.f3409w.f3321b.getClassLoader());
        o0Var2.f3475e = this.f3408v;
        return o0Var2;
    }

    public final void h(G g3) {
        if (J(2)) {
            Objects.toString(g3);
        }
        if (!g3.mDetached) {
            g3.mDetached = true;
            if (g3.mAdded) {
                if (J(2)) {
                    g3.toString();
                }
                p0 p0Var = this.f3391c;
                synchronized (p0Var.f3482a) {
                    p0Var.f3482a.remove(g3);
                }
                g3.mAdded = false;
                if (K(g3)) {
                    this.f3379G = true;
                }
                b0(g3);
            }
        }
    }

    public final void i(boolean z3, Configuration configuration) {
        if (z3 && (this.f3409w instanceof InterfaceC0776g)) {
            c0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (G g3 : this.f3391c.f()) {
            if (g3 != null) {
                g3.performConfigurationChanged(configuration);
                if (z3) {
                    g3.mChildFragmentManager.i(true, configuration);
                }
            }
        }
    }

    public final boolean j(MenuItem menuItem) {
        if (this.f3408v < 1) {
            return false;
        }
        for (G g3 : this.f3391c.f()) {
            if (g3 != null && g3.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(Menu menu, MenuInflater menuInflater) {
        if (this.f3408v < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z3 = false;
        for (G g3 : this.f3391c.f()) {
            if (g3 != null && g3.isMenuVisible() && g3.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(g3);
                z3 = true;
            }
        }
        if (this.f3393e != null) {
            for (int i = 0; i < this.f3393e.size(); i++) {
                G g4 = (G) this.f3393e.get(i);
                if (arrayList == null || !arrayList.contains(g4)) {
                    g4.onDestroyOptionsMenu();
                }
            }
        }
        this.f3393e = arrayList;
        return z3;
    }

    public final void l() {
        boolean z3 = true;
        this.f3382J = true;
        z(true);
        w();
        S s3 = this.f3409w;
        boolean z4 = s3 instanceof androidx.lifecycle.a0;
        p0 p0Var = this.f3391c;
        if (z4) {
            z3 = p0Var.f3485d.f3431f;
        } else {
            L l3 = s3.f3321b;
            if (l3 != null) {
                z3 = true ^ l3.isChangingConfigurations();
            }
        }
        if (z3) {
            Iterator it = this.f3399l.values().iterator();
            while (it.hasNext()) {
                ArrayList arrayList = ((C0263c) it.next()).f3353a;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    p0Var.f3485d.d((String) obj, false);
                }
            }
        }
        u(-1);
        Object obj2 = this.f3409w;
        if (obj2 instanceof InterfaceC0777h) {
            ((InterfaceC0777h) obj2).removeOnTrimMemoryListener(this.f3404r);
        }
        Object obj3 = this.f3409w;
        if (obj3 instanceof InterfaceC0776g) {
            ((InterfaceC0776g) obj3).removeOnConfigurationChangedListener(this.f3403q);
        }
        Object obj4 = this.f3409w;
        if (obj4 instanceof w.q) {
            ((w.q) obj4).removeOnMultiWindowModeChangedListener(this.f3405s);
        }
        Object obj5 = this.f3409w;
        if (obj5 instanceof w.r) {
            ((w.r) obj5).removeOnPictureInPictureModeChangedListener(this.f3406t);
        }
        Object obj6 = this.f3409w;
        if ((obj6 instanceof InterfaceC0123k) && this.y == null) {
            ((InterfaceC0123k) obj6).removeMenuProvider(this.f3407u);
        }
        this.f3409w = null;
        this.f3410x = null;
        this.y = null;
        if (this.f3395g != null) {
            this.f3397j.remove();
            this.f3395g = null;
        }
        e.g gVar = this.f3375C;
        if (gVar != null) {
            gVar.b();
            this.f3376D.b();
            this.f3377E.b();
        }
    }

    public final void m(boolean z3) {
        if (z3 && (this.f3409w instanceof InterfaceC0777h)) {
            c0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (G g3 : this.f3391c.f()) {
            if (g3 != null) {
                g3.performLowMemory();
                if (z3) {
                    g3.mChildFragmentManager.m(true);
                }
            }
        }
    }

    public final void n(boolean z3, boolean z4) {
        if (z4 && (this.f3409w instanceof w.q)) {
            c0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (G g3 : this.f3391c.f()) {
            if (g3 != null) {
                g3.performMultiWindowModeChanged(z3);
                if (z4) {
                    g3.mChildFragmentManager.n(z3, true);
                }
            }
        }
    }

    public final void o() {
        ArrayList e4 = this.f3391c.e();
        int size = e4.size();
        int i = 0;
        while (i < size) {
            Object obj = e4.get(i);
            i++;
            G g3 = (G) obj;
            if (g3 != null) {
                g3.onHiddenChanged(g3.isHidden());
                g3.mChildFragmentManager.o();
            }
        }
    }

    public final boolean p(MenuItem menuItem) {
        if (this.f3408v < 1) {
            return false;
        }
        for (G g3 : this.f3391c.f()) {
            if (g3 != null && g3.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void q(Menu menu) {
        if (this.f3408v >= 1) {
            for (G g3 : this.f3391c.f()) {
                if (g3 != null) {
                    g3.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void r(G g3) {
        if (g3 != null) {
            if (g3.equals(this.f3391c.b(g3.mWho))) {
                g3.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void s(boolean z3, boolean z4) {
        if (z4 && (this.f3409w instanceof w.r)) {
            c0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (G g3 : this.f3391c.f()) {
            if (g3 != null) {
                g3.performPictureInPictureModeChanged(z3);
                if (z4) {
                    g3.mChildFragmentManager.s(z3, true);
                }
            }
        }
    }

    public final boolean t(Menu menu) {
        boolean z3 = false;
        if (this.f3408v < 1) {
            return false;
        }
        for (G g3 : this.f3391c.f()) {
            if (g3 != null && g3.isMenuVisible() && g3.performPrepareOptionsMenu(menu)) {
                z3 = true;
            }
        }
        return z3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        G g3 = this.y;
        if (g3 != null) {
            sb.append(g3.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.y)));
            sb.append("}");
        } else {
            S s3 = this.f3409w;
            if (s3 != null) {
                sb.append(s3.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3409w)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(int i) {
        try {
            this.f3390b = true;
            for (o0 o0Var : this.f3391c.f3483b.values()) {
                if (o0Var != null) {
                    o0Var.f3475e = i;
                }
            }
            O(i, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((C0281p) it.next()).i();
            }
            this.f3390b = false;
            z(true);
        } catch (Throwable th) {
            this.f3390b = false;
            throw th;
        }
    }

    public final void v(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String n4 = AbstractC0008a.n(str, "    ");
        p0 p0Var = this.f3391c;
        ArrayList arrayList = p0Var.f3482a;
        String n5 = AbstractC0008a.n(str, "    ");
        HashMap hashMap = p0Var.f3483b;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (o0 o0Var : hashMap.values()) {
                printWriter.print(str);
                if (o0Var != null) {
                    G g3 = o0Var.f3473c;
                    printWriter.println(g3);
                    g3.dump(n5, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size2; i++) {
                G g4 = (G) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(g4.toString());
            }
        }
        ArrayList arrayList2 = this.f3393e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size; i3++) {
                G g5 = (G) this.f3393e.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(g5.toString());
            }
        }
        int size3 = this.f3392d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                C0259a c0259a = (C0259a) this.f3392d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(c0259a.toString());
                c0259a.g(n4, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3398k.get());
        synchronized (this.f3389a) {
            try {
                int size4 = this.f3389a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        Object obj = (InterfaceC0266d0) this.f3389a.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3409w);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3410x);
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.y);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3408v);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3380H);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3381I);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3382J);
        if (this.f3379G) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3379G);
        }
    }

    public final void w() {
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((C0281p) it.next()).i();
        }
    }

    public final void x(InterfaceC0266d0 interfaceC0266d0, boolean z3) {
        if (!z3) {
            if (this.f3409w == null) {
                if (this.f3382J) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (N()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f3389a) {
            try {
                if (this.f3409w == null) {
                    if (z3) {
                    } else {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f3389a.add(interfaceC0266d0);
                    X();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(boolean z3) {
        if (!this.f3390b) {
            if (this.f3409w == null) {
                if (this.f3382J) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.f3409w.f3322c.getLooper()) {
                if (!z3 && N()) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.f3384L == null) {
                    this.f3384L = new ArrayList();
                    this.f3385M = new ArrayList();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public final boolean z(boolean z3) {
        boolean z4;
        C0259a c0259a;
        y(z3);
        if (!this.i && (c0259a = this.f3396h) != null) {
            c0259a.f3336r = false;
            c0259a.e();
            if (J(3)) {
                Objects.toString(this.f3396h);
                Objects.toString(this.f3389a);
            }
            this.f3396h.f(false, false);
            this.f3389a.add(0, this.f3396h);
            ArrayList arrayList = this.f3396h.f3497a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                G g3 = ((q0) obj).f3489b;
                if (g3 != null) {
                    g3.mTransitioning = false;
                }
            }
            this.f3396h = null;
        }
        boolean z5 = false;
        while (true) {
            ArrayList arrayList2 = this.f3384L;
            ArrayList arrayList3 = this.f3385M;
            synchronized (this.f3389a) {
                if (this.f3389a.isEmpty()) {
                    z4 = false;
                } else {
                    try {
                        int size2 = this.f3389a.size();
                        z4 = false;
                        for (int i3 = 0; i3 < size2; i3++) {
                            z4 |= ((InterfaceC0266d0) this.f3389a.get(i3)).a(arrayList2, arrayList3);
                        }
                    } finally {
                    }
                }
            }
            if (!z4) {
                break;
            }
            this.f3390b = true;
            try {
                U(this.f3384L, this.f3385M);
                d();
                z5 = true;
            } catch (Throwable th) {
                d();
                throw th;
            }
        }
        d0();
        if (this.f3383K) {
            this.f3383K = false;
            ArrayList d2 = this.f3391c.d();
            int size3 = d2.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj2 = d2.get(i4);
                i4++;
                o0 o0Var = (o0) obj2;
                G g4 = o0Var.f3473c;
                if (g4.mDeferStart) {
                    if (this.f3390b) {
                        this.f3383K = true;
                    } else {
                        g4.mDeferStart = false;
                        o0Var.i();
                    }
                }
            }
        }
        this.f3391c.f3483b.values().removeAll(Collections.singleton(null));
        return z5;
    }
}
