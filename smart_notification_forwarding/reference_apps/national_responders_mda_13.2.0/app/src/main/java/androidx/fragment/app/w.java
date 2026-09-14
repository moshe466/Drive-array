package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.f;
import androidx.fragment.app.f0;
import androidx.lifecycle.h;
import e0.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class w {
    private static boolean S;
    private androidx.activity.result.c<Intent> D;
    private androidx.activity.result.c<androidx.activity.result.f> E;
    private androidx.activity.result.c<String[]> F;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList<androidx.fragment.app.a> M;
    private ArrayList<Boolean> N;
    private ArrayList<Fragment> O;
    private z P;
    private d.c Q;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3100b;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f3102d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f3103e;

    /* renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f3105g;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<m> f3111m;

    /* renamed from: v, reason: collision with root package name */
    private androidx.fragment.app.o<?> f3120v;

    /* renamed from: w, reason: collision with root package name */
    private androidx.fragment.app.l f3121w;

    /* renamed from: x, reason: collision with root package name */
    private Fragment f3122x;

    /* renamed from: y, reason: collision with root package name */
    Fragment f3123y;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<n> f3099a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final e0 f3101c = new e0();

    /* renamed from: f, reason: collision with root package name */
    private final p f3104f = new p(this);

    /* renamed from: h, reason: collision with root package name */
    private final androidx.activity.g f3106h = new b(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f3107i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, androidx.fragment.app.c> f3108j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Bundle> f3109k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, Object> f3110l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    private final q f3112n = new q(this);

    /* renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList<a0> f3113o = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    private final androidx.core.util.a<Configuration> f3114p = new androidx.core.util.a() { // from class: androidx.fragment.app.r
        @Override // androidx.core.util.a
        public final void a(Object obj) {
            w.this.Q0((Configuration) obj);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private final androidx.core.util.a<Integer> f3115q = new androidx.core.util.a() { // from class: androidx.fragment.app.u
        @Override // androidx.core.util.a
        public final void a(Object obj) {
            w.this.R0((Integer) obj);
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private final androidx.core.util.a<androidx.core.app.h> f3116r = new androidx.core.util.a() { // from class: androidx.fragment.app.s
        @Override // androidx.core.util.a
        public final void a(Object obj) {
            w.this.S0((androidx.core.app.h) obj);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private final androidx.core.util.a<androidx.core.app.r> f3117s = new androidx.core.util.a() { // from class: androidx.fragment.app.t
        @Override // androidx.core.util.a
        public final void a(Object obj) {
            w.this.T0((androidx.core.app.r) obj);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private final androidx.core.view.l f3118t = new c();

    /* renamed from: u, reason: collision with root package name */
    int f3119u = -1;

    /* renamed from: z, reason: collision with root package name */
    private androidx.fragment.app.n f3124z = null;
    private androidx.fragment.app.n A = new d();
    private m0 B = null;
    private m0 C = new e(this);
    ArrayDeque<l> G = new ArrayDeque<>();
    private Runnable R = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.result.b<Map<String, Boolean>> {
        a() {
        }

        @Override // androidx.activity.result.b
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            l pollFirst = w.this.G.pollFirst();
            if (pollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No permissions were requested for ");
                sb2.append(this);
                return;
            }
            String str = pollFirst.f3133f;
            int i11 = pollFirst.f3134g;
            Fragment i12 = w.this.f3101c.i(str);
            if (i12 != null) {
                i12.V0(i11, strArr, iArr);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Permission request result delivered for unknown Fragment ");
            sb3.append(str);
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.activity.g {
        b(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.g
        public void b() {
            w.this.D0();
        }
    }

    /* loaded from: classes.dex */
    class c implements androidx.core.view.l {
        c() {
        }

        @Override // androidx.core.view.l
        public boolean a(MenuItem menuItem) {
            return w.this.K(menuItem);
        }

        @Override // androidx.core.view.l
        public void b(Menu menu) {
            w.this.L(menu);
        }

        @Override // androidx.core.view.l
        public void c(Menu menu, MenuInflater menuInflater) {
            w.this.D(menu, menuInflater);
        }

        @Override // androidx.core.view.l
        public void d(Menu menu) {
            w.this.P(menu);
        }
    }

    /* loaded from: classes.dex */
    class d extends androidx.fragment.app.n {
        d() {
        }

        @Override // androidx.fragment.app.n
        public Fragment a(ClassLoader classLoader, String str) {
            return w.this.u0().c(w.this.u0().j(), str, null);
        }
    }

    /* loaded from: classes.dex */
    class e implements m0 {
        e(w wVar) {
        }

        @Override // androidx.fragment.app.m0
        public l0 a(ViewGroup viewGroup) {
            return new androidx.fragment.app.d(viewGroup);
        }
    }

    /* loaded from: classes.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.b0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements a0 {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f3130f;

        g(w wVar, Fragment fragment) {
            this.f3130f = fragment;
        }

        @Override // androidx.fragment.app.a0
        public void a(w wVar, Fragment fragment) {
            this.f3130f.z0(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements androidx.activity.result.b<androidx.activity.result.a> {
        h() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            l pollFirst = w.this.G.pollFirst();
            if (pollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No Activities were started for result for ");
                sb2.append(this);
                return;
            }
            String str = pollFirst.f3133f;
            int i10 = pollFirst.f3134g;
            Fragment i11 = w.this.f3101c.i(str);
            if (i11 != null) {
                i11.w0(i10, aVar.b(), aVar.a());
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Activity result delivered for unknown Fragment ");
            sb3.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements androidx.activity.result.b<androidx.activity.result.a> {
        i() {
        }

        @Override // androidx.activity.result.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.activity.result.a aVar) {
            l pollFirst = w.this.G.pollFirst();
            if (pollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No IntentSenders were started for ");
                sb2.append(this);
                return;
            }
            String str = pollFirst.f3133f;
            int i10 = pollFirst.f3134g;
            Fragment i11 = w.this.f3101c.i(str);
            if (i11 != null) {
                i11.w0(i10, aVar.b(), aVar.a());
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Intent Sender result delivered for unknown Fragment ");
            sb3.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class j extends d.a<androidx.activity.result.f, androidx.activity.result.a> {
        j() {
        }

        @Override // d.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, androidx.activity.result.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a10 = fVar.a();
            if (a10 != null && (bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a10.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new f.b(fVar.d()).b(null).c(fVar.c(), fVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CreateIntent created the following intent: ");
                sb2.append(intent);
            }
            return intent;
        }

        @Override // d.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.activity.result.a c(int i10, Intent intent) {
            return new androidx.activity.result.a(i10, intent);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        String f3133f;

        /* renamed from: g, reason: collision with root package name */
        int f3134g;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<l> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i10) {
                return new l[i10];
            }
        }

        l(Parcel parcel) {
            this.f3133f = parcel.readString();
            this.f3134g = parcel.readInt();
        }

        l(String str, int i10) {
            this.f3133f = str;
            this.f3134g = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f3133f);
            parcel.writeInt(this.f3134g);
        }
    }

    /* loaded from: classes.dex */
    public interface m {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface n {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class o implements n {

        /* renamed from: a, reason: collision with root package name */
        final String f3135a;

        /* renamed from: b, reason: collision with root package name */
        final int f3136b;

        /* renamed from: c, reason: collision with root package name */
        final int f3137c;

        o(String str, int i10, int i11) {
            this.f3135a = str;
            this.f3136b = i10;
            this.f3137c = i11;
        }

        @Override // androidx.fragment.app.w.n
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = w.this.f3123y;
            if (fragment == null || this.f3136b >= 0 || this.f3135a != null || !fragment.z().b1()) {
                return w.this.e1(arrayList, arrayList2, this.f3135a, this.f3136b, this.f3137c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fragment B0(View view) {
        Object tag = view.getTag(d0.b.f8628a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean H0(int i10) {
        return S || Log.isLoggable("FragmentManager", i10);
    }

    private boolean I0(Fragment fragment) {
        return (fragment.J && fragment.K) || fragment.A.p();
    }

    private boolean J0() {
        Fragment fragment = this.f3122x;
        if (fragment == null) {
            return true;
        }
        return fragment.m0() && this.f3122x.S().J0();
    }

    private void M(Fragment fragment) {
        if (fragment == null || !fragment.equals(f0(fragment.f2836k))) {
            return;
        }
        fragment.u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(Configuration configuration) {
        if (J0()) {
            A(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(Integer num) {
        if (J0() && num.intValue() == 80) {
            G(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(androidx.core.app.h hVar) {
        if (J0()) {
            H(hVar.a(), false);
        }
    }

    private void T(int i10) {
        try {
            this.f3100b = true;
            this.f3101c.d(i10);
            V0(i10, false);
            Iterator<l0> it = u().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
            this.f3100b = false;
            b0(true);
        } catch (Throwable th) {
            this.f3100b = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(androidx.core.app.r rVar) {
        if (J0()) {
            O(rVar.a(), false);
        }
    }

    private void W() {
        if (this.L) {
            this.L = false;
            r1();
        }
    }

    private void Y() {
        Iterator<l0> it = u().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    private void a0(boolean z10) {
        if (this.f3100b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3120v == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f3120v.k().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            q();
        }
        if (this.M == null) {
            this.M = new ArrayList<>();
            this.N = new ArrayList<>();
        }
    }

    private static void d0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            androidx.fragment.app.a aVar = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                aVar.t(-1);
                aVar.y();
            } else {
                aVar.t(1);
                aVar.x();
            }
            i10++;
        }
    }

    private boolean d1(String str, int i10, int i11) {
        b0(false);
        a0(true);
        Fragment fragment = this.f3123y;
        if (fragment != null && i10 < 0 && str == null && fragment.z().b1()) {
            return true;
        }
        boolean e12 = e1(this.M, this.N, str, i10, i11);
        if (e12) {
            this.f3100b = true;
            try {
                g1(this.M, this.N);
            } finally {
                r();
            }
        }
        t1();
        W();
        this.f3101c.b();
        return e12;
    }

    private void e0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f3009p;
        ArrayList<Fragment> arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.f3101c.o());
        Fragment y02 = y0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            androidx.fragment.app.a aVar = arrayList.get(i12);
            y02 = !arrayList2.get(i12).booleanValue() ? aVar.z(this.O, y02) : aVar.C(this.O, y02);
            z11 = z11 || aVar.f3000g;
        }
        this.O.clear();
        if (!z10 && this.f3119u >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<f0.a> it = arrayList.get(i13).f2994a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f3012b;
                    if (fragment != null && fragment.f2850y != null) {
                        this.f3101c.r(w(fragment));
                    }
                }
            }
        }
        d0(arrayList, arrayList2, i10, i11);
        boolean booleanValue = arrayList2.get(i11 - 1).booleanValue();
        for (int i14 = i10; i14 < i11; i14++) {
            androidx.fragment.app.a aVar2 = arrayList.get(i14);
            if (booleanValue) {
                for (int size = aVar2.f2994a.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = aVar2.f2994a.get(size).f3012b;
                    if (fragment2 != null) {
                        w(fragment2).m();
                    }
                }
            } else {
                Iterator<f0.a> it2 = aVar2.f2994a.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = it2.next().f3012b;
                    if (fragment3 != null) {
                        w(fragment3).m();
                    }
                }
            }
        }
        V0(this.f3119u, true);
        for (l0 l0Var : v(arrayList, i10, i11)) {
            l0Var.r(booleanValue);
            l0Var.p();
            l0Var.g();
        }
        while (i10 < i11) {
            androidx.fragment.app.a aVar3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && aVar3.f2891t >= 0) {
                aVar3.f2891t = -1;
            }
            aVar3.B();
            i10++;
        }
        if (z11) {
            h1();
        }
    }

    private int g0(String str, int i10, boolean z10) {
        ArrayList<androidx.fragment.app.a> arrayList = this.f3102d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f3102d.size() - 1;
        }
        int size = this.f3102d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = this.f3102d.get(size);
            if ((str != null && str.equals(aVar.A())) || (i10 >= 0 && i10 == aVar.f2891t)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f3102d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = this.f3102d.get(size - 1);
            if ((str == null || !str.equals(aVar2.A())) && (i10 < 0 || i10 != aVar2.f2891t)) {
                return size;
            }
            size--;
        }
        return size;
    }

    private void g1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!arrayList.get(i10).f3009p) {
                if (i11 != i10) {
                    e0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (arrayList2.get(i10).booleanValue()) {
                    while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f3009p) {
                        i11++;
                    }
                }
                e0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            e0(arrayList, arrayList2, i11, size);
        }
    }

    private void h1() {
        if (this.f3111m != null) {
            for (int i10 = 0; i10 < this.f3111m.size(); i10++) {
                this.f3111m.get(i10).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 8194) {
            return 4097;
        }
        if (i10 == 8197) {
            return 4100;
        }
        if (i10 != 4099) {
            return i10 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w k0(View view) {
        Fragment l02 = l0(view);
        if (l02 != null) {
            if (l02.m0()) {
                return l02.z();
            }
            throw new IllegalStateException("The Fragment " + l02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        androidx.fragment.app.j jVar = null;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof androidx.fragment.app.j) {
                jVar = (androidx.fragment.app.j) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (jVar != null) {
            return jVar.d0();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private static Fragment l0(View view) {
        while (view != null) {
            Fragment B0 = B0(view);
            if (B0 != null) {
                return B0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void m0() {
        Iterator<l0> it = u().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    private boolean n0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f3099a) {
            if (this.f3099a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f3099a.size();
                boolean z10 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    z10 |= this.f3099a.get(i10).a(arrayList, arrayList2);
                }
                return z10;
            } finally {
                this.f3099a.clear();
                this.f3120v.k().removeCallbacks(this.R);
            }
        }
    }

    private z p0(Fragment fragment) {
        return this.P.j(fragment);
    }

    private void p1(Fragment fragment) {
        ViewGroup r02 = r0(fragment);
        if (r02 == null || fragment.B() + fragment.G() + fragment.U() + fragment.V() <= 0) {
            return;
        }
        int i10 = d0.b.f8630c;
        if (r02.getTag(i10) == null) {
            r02.setTag(i10, fragment);
        }
        ((Fragment) r02.getTag(i10)).L1(fragment.T());
    }

    private void q() {
        if (O0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void r() {
        this.f3100b = false;
        this.N.clear();
        this.M.clear();
    }

    private ViewGroup r0(Fragment fragment) {
        ViewGroup viewGroup = fragment.M;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.D > 0 && this.f3121w.g()) {
            View d10 = this.f3121w.d(fragment.D);
            if (d10 instanceof ViewGroup) {
                return (ViewGroup) d10;
            }
        }
        return null;
    }

    private void r1() {
        Iterator<d0> it = this.f3101c.k().iterator();
        while (it.hasNext()) {
            Y0(it.next());
        }
    }

    private void s() {
        androidx.fragment.app.o<?> oVar = this.f3120v;
        boolean z10 = true;
        if (oVar instanceof androidx.lifecycle.f0) {
            z10 = this.f3101c.p().n();
        } else if (oVar.j() instanceof Activity) {
            z10 = true ^ ((Activity) this.f3120v.j()).isChangingConfigurations();
        }
        if (z10) {
            Iterator<androidx.fragment.app.c> it = this.f3108j.values().iterator();
            while (it.hasNext()) {
                Iterator<String> it2 = it.next().f2907f.iterator();
                while (it2.hasNext()) {
                    this.f3101c.p().g(it2.next());
                }
            }
        }
    }

    private void s1(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new k0("FragmentManager"));
        androidx.fragment.app.o<?> oVar = this.f3120v;
        try {
            if (oVar != null) {
                oVar.l("  ", null, printWriter, new String[0]);
            } else {
                X("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception unused) {
            throw runtimeException;
        }
    }

    private void t1() {
        synchronized (this.f3099a) {
            if (this.f3099a.isEmpty()) {
                this.f3106h.f(o0() > 0 && M0(this.f3122x));
            } else {
                this.f3106h.f(true);
            }
        }
    }

    private Set<l0> u() {
        HashSet hashSet = new HashSet();
        Iterator<d0> it = this.f3101c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().M;
            if (viewGroup != null) {
                hashSet.add(l0.o(viewGroup, z0()));
            }
        }
        return hashSet;
    }

    private Set<l0> v(ArrayList<androidx.fragment.app.a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<f0.a> it = arrayList.get(i10).f2994a.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f3012b;
                if (fragment != null && (viewGroup = fragment.M) != null) {
                    hashSet.add(l0.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    void A(Configuration configuration, boolean z10) {
        if (z10 && (this.f3120v instanceof androidx.core.content.b)) {
            s1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null) {
                fragment.e1(configuration);
                if (z10) {
                    fragment.A.A(configuration, true);
                }
            }
        }
    }

    public d.c A0() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B(MenuItem menuItem) {
        if (this.f3119u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null && fragment.f1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.e0 C0(Fragment fragment) {
        return this.P.m(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f3119u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null && L0(fragment) && fragment.h1(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f3103e != null) {
            for (int i10 = 0; i10 < this.f3103e.size(); i10++) {
                Fragment fragment2 = this.f3103e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.H0();
                }
            }
        }
        this.f3103e = arrayList;
        return z10;
    }

    void D0() {
        b0(true);
        if (this.f3106h.c()) {
            b1();
        } else {
            this.f3105g.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        this.K = true;
        b0(true);
        Y();
        s();
        T(-1);
        Object obj = this.f3120v;
        if (obj instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj).u(this.f3115q);
        }
        Object obj2 = this.f3120v;
        if (obj2 instanceof androidx.core.content.b) {
            ((androidx.core.content.b) obj2).K(this.f3114p);
        }
        Object obj3 = this.f3120v;
        if (obj3 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj3).G(this.f3116r);
        }
        Object obj4 = this.f3120v;
        if (obj4 instanceof androidx.core.app.p) {
            ((androidx.core.app.p) obj4).r(this.f3117s);
        }
        Object obj5 = this.f3120v;
        if (obj5 instanceof androidx.core.view.i) {
            ((androidx.core.view.i) obj5).h(this.f3118t);
        }
        this.f3120v = null;
        this.f3121w = null;
        this.f3122x = null;
        if (this.f3105g != null) {
            this.f3106h.d();
            this.f3105g = null;
        }
        androidx.activity.result.c<Intent> cVar = this.D;
        if (cVar != null) {
            cVar.c();
            this.E.c();
            this.F.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E0(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("hide: ");
            sb2.append(fragment);
        }
        if (fragment.F) {
            return;
        }
        fragment.F = true;
        fragment.R = true ^ fragment.R;
        p1(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        T(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0(Fragment fragment) {
        if (fragment.f2842q && I0(fragment)) {
            this.H = true;
        }
    }

    void G(boolean z10) {
        if (z10 && (this.f3120v instanceof androidx.core.content.c)) {
            s1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null) {
                fragment.n1();
                if (z10) {
                    fragment.A.G(true);
                }
            }
        }
    }

    public boolean G0() {
        return this.K;
    }

    void H(boolean z10, boolean z11) {
        if (z11 && (this.f3120v instanceof androidx.core.app.o)) {
            s1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null) {
                fragment.o1(z10);
                if (z11) {
                    fragment.A.H(z10, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(Fragment fragment) {
        Iterator<a0> it = this.f3113o.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        for (Fragment fragment : this.f3101c.l()) {
            if (fragment != null) {
                fragment.L0(fragment.n0());
                fragment.A.J();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K(MenuItem menuItem) {
        if (this.f3119u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null && fragment.p1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.n0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(Menu menu) {
        if (this.f3119u < 1) {
            return;
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null) {
                fragment.q1(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.p0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        w wVar = fragment.f2850y;
        return fragment.equals(wVar.y0()) && M0(wVar.f3122x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        T(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N0(int i10) {
        return this.f3119u >= i10;
    }

    void O(boolean z10, boolean z11) {
        if (z11 && (this.f3120v instanceof androidx.core.app.p)) {
            s1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null) {
                fragment.s1(z10);
                if (z11) {
                    fragment.A.O(z10, true);
                }
            }
        }
    }

    public boolean O0() {
        return this.I || this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean P(Menu menu) {
        boolean z10 = false;
        if (this.f3119u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null && L0(fragment) && fragment.t1(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        t1();
        M(this.f3123y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        this.J = true;
        this.P.p(true);
        T(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (this.D == null) {
            this.f3120v.q(fragment, intent, i10, bundle);
            return;
        }
        this.G.addLast(new l(fragment.f2836k, i10));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.D.a(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        T(2);
    }

    void V0(int i10, boolean z10) {
        androidx.fragment.app.o<?> oVar;
        if (this.f3120v == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f3119u) {
            this.f3119u = i10;
            this.f3101c.t();
            r1();
            if (this.H && (oVar = this.f3120v) != null && this.f3119u == 7) {
                oVar.s();
                this.H = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0() {
        if (this.f3120v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.p(false);
        for (Fragment fragment : this.f3101c.o()) {
            if (fragment != null) {
                fragment.u0();
            }
        }
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f3101c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f3103e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                Fragment fragment = this.f3103e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f3102d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                androidx.fragment.app.a aVar = this.f3102d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.v(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3107i.get());
        synchronized (this.f3099a) {
            int size3 = this.f3099a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    n nVar = this.f3099a.get(i12);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println(nVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3120v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3121w);
        if (this.f3122x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3122x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3119u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X0(FragmentContainerView fragmentContainerView) {
        View view;
        for (d0 d0Var : this.f3101c.k()) {
            Fragment k10 = d0Var.k();
            if (k10.D == fragmentContainerView.getId() && (view = k10.N) != null && view.getParent() == null) {
                k10.M = fragmentContainerView;
                d0Var.b();
            }
        }
    }

    void Y0(d0 d0Var) {
        Fragment k10 = d0Var.k();
        if (k10.O) {
            if (this.f3100b) {
                this.L = true;
            } else {
                k10.O = false;
                d0Var.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(n nVar, boolean z10) {
        if (!z10) {
            if (this.f3120v == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            q();
        }
        synchronized (this.f3099a) {
            if (this.f3120v == null) {
                if (!z10) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f3099a.add(nVar);
                l1();
            }
        }
    }

    public void Z0() {
        Z(new o(null, -1, 0), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            Z(new o(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b0(boolean z10) {
        a0(z10);
        boolean z11 = false;
        while (n0(this.M, this.N)) {
            this.f3100b = true;
            try {
                g1(this.M, this.N);
                r();
                z11 = true;
            } catch (Throwable th) {
                r();
                throw th;
            }
        }
        t1();
        W();
        this.f3101c.b();
        return z11;
    }

    public boolean b1() {
        return d1(null, -1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(n nVar, boolean z10) {
        if (z10 && (this.f3120v == null || this.K)) {
            return;
        }
        a0(z10);
        if (nVar.a(this.M, this.N)) {
            this.f3100b = true;
            try {
                g1(this.M, this.N);
            } finally {
                r();
            }
        }
        t1();
        W();
        this.f3101c.b();
    }

    public boolean c1(int i10, int i11) {
        if (i10 >= 0) {
            return d1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    boolean e1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        int g02 = g0(str, i10, (i11 & 1) != 0);
        if (g02 < 0) {
            return false;
        }
        for (int size = this.f3102d.size() - 1; size >= g02; size--) {
            arrayList.add(this.f3102d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f0(String str) {
        return this.f3101c.f(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f1(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remove: ");
            sb2.append(fragment);
            sb2.append(" nesting=");
            sb2.append(fragment.f2849x);
        }
        boolean z10 = !fragment.o0();
        if (!fragment.G || z10) {
            this.f3101c.u(fragment);
            if (I0(fragment)) {
                this.H = true;
            }
            fragment.f2843r = true;
            p1(fragment);
        }
    }

    public Fragment h0(int i10) {
        return this.f3101c.g(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(androidx.fragment.app.a aVar) {
        if (this.f3102d == null) {
            this.f3102d = new ArrayList<>();
        }
        this.f3102d.add(aVar);
    }

    public Fragment i0(String str) {
        return this.f3101c.h(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i1(Parcelable parcelable) {
        d0 d0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f3120v.j().getClassLoader());
                this.f3109k.put(str.substring(7), bundle2);
            }
        }
        ArrayList<c0> arrayList = new ArrayList<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f3120v.j().getClassLoader());
                arrayList.add((c0) bundle.getParcelable("state"));
            }
        }
        this.f3101c.x(arrayList);
        y yVar = (y) bundle3.getParcelable("state");
        if (yVar == null) {
            return;
        }
        this.f3101c.v();
        Iterator<String> it = yVar.f3139f.iterator();
        while (it.hasNext()) {
            c0 B = this.f3101c.B(it.next(), null);
            if (B != null) {
                Fragment i10 = this.P.i(B.f2910g);
                if (i10 != null) {
                    if (H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("restoreSaveState: re-attaching retained ");
                        sb2.append(i10);
                    }
                    d0Var = new d0(this.f3112n, this.f3101c, i10, B);
                } else {
                    d0Var = new d0(this.f3112n, this.f3101c, this.f3120v.j().getClassLoader(), s0(), B);
                }
                Fragment k10 = d0Var.k();
                k10.f2850y = this;
                if (H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("restoreSaveState: active (");
                    sb3.append(k10.f2836k);
                    sb3.append("): ");
                    sb3.append(k10);
                }
                d0Var.o(this.f3120v.j().getClassLoader());
                this.f3101c.r(d0Var);
                d0Var.t(this.f3119u);
            }
        }
        for (Fragment fragment : this.P.l()) {
            if (!this.f3101c.c(fragment.f2836k)) {
                if (H0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Discarding retained Fragment ");
                    sb4.append(fragment);
                    sb4.append(" that was not found in the set of active Fragments ");
                    sb4.append(yVar.f3139f);
                }
                this.P.o(fragment);
                fragment.f2850y = this;
                d0 d0Var2 = new d0(this.f3112n, this.f3101c, fragment);
                d0Var2.t(1);
                d0Var2.m();
                fragment.f2843r = true;
                d0Var2.m();
            }
        }
        this.f3101c.w(yVar.f3140g);
        if (yVar.f3141h != null) {
            this.f3102d = new ArrayList<>(yVar.f3141h.length);
            int i11 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = yVar.f3141h;
                if (i11 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a b10 = bVarArr[i11].b(this);
                if (H0(2)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("restoreAllState: back stack #");
                    sb5.append(i11);
                    sb5.append(" (index ");
                    sb5.append(b10.f2891t);
                    sb5.append("): ");
                    sb5.append(b10);
                    PrintWriter printWriter = new PrintWriter(new k0("FragmentManager"));
                    b10.w("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3102d.add(b10);
                i11++;
            }
        } else {
            this.f3102d = null;
        }
        this.f3107i.set(yVar.f3142i);
        String str3 = yVar.f3143j;
        if (str3 != null) {
            Fragment f02 = f0(str3);
            this.f3123y = f02;
            M(f02);
        }
        ArrayList<String> arrayList2 = yVar.f3144k;
        if (arrayList2 != null) {
            for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                this.f3108j.put(arrayList2.get(i12), yVar.f3145l.get(i12));
            }
        }
        this.G = new ArrayDeque<>(yVar.f3146m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0 j(Fragment fragment) {
        String str = fragment.U;
        if (str != null) {
            e0.d.h(fragment, str);
        }
        if (H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("add: ");
            sb2.append(fragment);
        }
        d0 w10 = w(fragment);
        fragment.f2850y = this;
        this.f3101c.r(w10);
        if (!fragment.G) {
            this.f3101c.a(fragment);
            fragment.f2843r = false;
            if (fragment.N == null) {
                fragment.R = false;
            }
            if (I0(fragment)) {
                this.H = true;
            }
        }
        return w10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment j0(String str) {
        return this.f3101c.i(str);
    }

    public void k(a0 a0Var) {
        this.f3113o.add(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public Bundle P0() {
        int size;
        Bundle bundle = new Bundle();
        m0();
        Y();
        b0(true);
        this.I = true;
        this.P.p(true);
        ArrayList<String> y10 = this.f3101c.y();
        ArrayList<c0> m10 = this.f3101c.m();
        if (m10.isEmpty()) {
            H0(2);
        } else {
            ArrayList<String> z10 = this.f3101c.z();
            androidx.fragment.app.b[] bVarArr = null;
            ArrayList<androidx.fragment.app.a> arrayList = this.f3102d;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                bVarArr = new androidx.fragment.app.b[size];
                for (int i10 = 0; i10 < size; i10++) {
                    bVarArr[i10] = new androidx.fragment.app.b(this.f3102d.get(i10));
                    if (H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("saveAllState: adding back stack #");
                        sb2.append(i10);
                        sb2.append(": ");
                        sb2.append(this.f3102d.get(i10));
                    }
                }
            }
            y yVar = new y();
            yVar.f3139f = y10;
            yVar.f3140g = z10;
            yVar.f3141h = bVarArr;
            yVar.f3142i = this.f3107i.get();
            Fragment fragment = this.f3123y;
            if (fragment != null) {
                yVar.f3143j = fragment.f2836k;
            }
            yVar.f3144k.addAll(this.f3108j.keySet());
            yVar.f3145l.addAll(this.f3108j.values());
            yVar.f3146m = new ArrayList<>(this.G);
            bundle.putParcelable("state", yVar);
            for (String str : this.f3109k.keySet()) {
                bundle.putBundle("result_" + str, this.f3109k.get(str));
            }
            Iterator<c0> it = m10.iterator();
            while (it.hasNext()) {
                c0 next = it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", next);
                bundle.putBundle("fragment_" + next.f2910g, bundle2);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f3107i.getAndIncrement();
    }

    void l1() {
        synchronized (this.f3099a) {
            boolean z10 = true;
            if (this.f3099a.size() != 1) {
                z10 = false;
            }
            if (z10) {
                this.f3120v.k().removeCallbacks(this.R);
                this.f3120v.k().post(this.R);
                t1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(androidx.fragment.app.o<?> r4, androidx.fragment.app.l r5, androidx.fragment.app.Fragment r6) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.w.m(androidx.fragment.app.o, androidx.fragment.app.l, androidx.fragment.app.Fragment):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m1(Fragment fragment, boolean z10) {
        ViewGroup r02 = r0(fragment);
        if (r02 == null || !(r02 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) r02).setDrawDisappearingViewsLast(!z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("attach: ");
            sb2.append(fragment);
        }
        if (fragment.G) {
            fragment.G = false;
            if (fragment.f2842q) {
                return;
            }
            this.f3101c.a(fragment);
            if (H0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("add from attach: ");
                sb3.append(fragment);
            }
            if (I0(fragment)) {
                this.H = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n1(Fragment fragment, h.c cVar) {
        if (fragment.equals(f0(fragment.f2836k)) && (fragment.f2851z == null || fragment.f2850y == this)) {
            fragment.V = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public f0 o() {
        return new androidx.fragment.app.a(this);
    }

    public int o0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f3102d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o1(Fragment fragment) {
        if (fragment == null || (fragment.equals(f0(fragment.f2836k)) && (fragment.f2851z == null || fragment.f2850y == this))) {
            Fragment fragment2 = this.f3123y;
            this.f3123y = fragment;
            M(fragment2);
            M(this.f3123y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    boolean p() {
        boolean z10 = false;
        for (Fragment fragment : this.f3101c.l()) {
            if (fragment != null) {
                z10 = I0(fragment);
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.fragment.app.l q0() {
        return this.f3121w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q1(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("show: ");
            sb2.append(fragment);
        }
        if (fragment.F) {
            fragment.F = false;
            fragment.R = !fragment.R;
        }
    }

    public androidx.fragment.app.n s0() {
        androidx.fragment.app.n nVar = this.f3124z;
        if (nVar != null) {
            return nVar;
        }
        Fragment fragment = this.f3122x;
        return fragment != null ? fragment.f2850y.s0() : this.A;
    }

    public final void t(String str) {
        this.f3109k.remove(str);
        if (H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing fragment result with key ");
            sb2.append(str);
        }
    }

    public List<Fragment> t0() {
        return this.f3101c.o();
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f3122x;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            obj = this.f3122x;
        } else {
            androidx.fragment.app.o<?> oVar = this.f3120v;
            if (oVar == null) {
                sb2.append("null");
                sb2.append("}}");
                return sb2.toString();
            }
            sb2.append(oVar.getClass().getSimpleName());
            sb2.append("{");
            obj = this.f3120v;
        }
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        sb2.append("}");
        sb2.append("}}");
        return sb2.toString();
    }

    public androidx.fragment.app.o<?> u0() {
        return this.f3120v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 v0() {
        return this.f3104f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0 w(Fragment fragment) {
        d0 n10 = this.f3101c.n(fragment.f2836k);
        if (n10 != null) {
            return n10;
        }
        d0 d0Var = new d0(this.f3112n, this.f3101c, fragment);
        d0Var.o(this.f3120v.j().getClassLoader());
        d0Var.t(this.f3119u);
        return d0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q w0() {
        return this.f3112n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(Fragment fragment) {
        if (H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("detach: ");
            sb2.append(fragment);
        }
        if (fragment.G) {
            return;
        }
        fragment.G = true;
        if (fragment.f2842q) {
            if (H0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("remove from detach: ");
                sb3.append(fragment);
            }
            this.f3101c.u(fragment);
            if (I0(fragment)) {
                this.H = true;
            }
            p1(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment x0() {
        return this.f3122x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(4);
    }

    public Fragment y0() {
        return this.f3123y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        this.I = false;
        this.J = false;
        this.P.p(false);
        T(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0 z0() {
        m0 m0Var = this.B;
        if (m0Var != null) {
            return m0Var;
        }
        Fragment fragment = this.f3122x;
        return fragment != null ? fragment.f2850y.z0() : this.C;
    }
}
