package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.d;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private int[] O;

    /* renamed from: t, reason: collision with root package name */
    f[] f3466t;

    /* renamed from: u, reason: collision with root package name */
    j f3467u;

    /* renamed from: v, reason: collision with root package name */
    j f3468v;

    /* renamed from: w, reason: collision with root package name */
    private int f3469w;

    /* renamed from: x, reason: collision with root package name */
    private int f3470x;

    /* renamed from: y, reason: collision with root package name */
    private final androidx.recyclerview.widget.f f3471y;

    /* renamed from: s, reason: collision with root package name */
    private int f3465s = -1;

    /* renamed from: z, reason: collision with root package name */
    boolean f3472z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    d E = new d();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.R1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f3474a;

        /* renamed from: b, reason: collision with root package name */
        int f3475b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3476c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3477d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3478e;

        /* renamed from: f, reason: collision with root package name */
        int[] f3479f;

        b() {
            c();
        }

        void a() {
            this.f3475b = this.f3476c ? StaggeredGridLayoutManager.this.f3467u.i() : StaggeredGridLayoutManager.this.f3467u.m();
        }

        void b(int i10) {
            this.f3475b = this.f3476c ? StaggeredGridLayoutManager.this.f3467u.i() - i10 : StaggeredGridLayoutManager.this.f3467u.m() + i10;
        }

        void c() {
            this.f3474a = -1;
            this.f3475b = Integer.MIN_VALUE;
            this.f3476c = false;
            this.f3477d = false;
            this.f3478e = false;
            int[] iArr = this.f3479f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f3479f;
            if (iArr == null || iArr.length < length) {
                this.f3479f = new int[StaggeredGridLayoutManager.this.f3466t.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f3479f[i10] = fVarArr[i10].p(Integer.MIN_VALUE);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        f f3481e;

        /* renamed from: f, reason: collision with root package name */
        boolean f3482f;

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int e() {
            f fVar = this.f3481e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f3503e;
        }

        public boolean f() {
            return this.f3482f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        int[] f3483a;

        /* renamed from: b, reason: collision with root package name */
        List<a> f3484b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0055a();

            /* renamed from: f, reason: collision with root package name */
            int f3485f;

            /* renamed from: g, reason: collision with root package name */
            int f3486g;

            /* renamed from: h, reason: collision with root package name */
            int[] f3487h;

            /* renamed from: i, reason: collision with root package name */
            boolean f3488i;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0055a implements Parcelable.Creator<a> {
                C0055a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i10) {
                    return new a[i10];
                }
            }

            a() {
            }

            a(Parcel parcel) {
                this.f3485f = parcel.readInt();
                this.f3486g = parcel.readInt();
                this.f3488i = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3487h = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i10) {
                int[] iArr = this.f3487h;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3485f + ", mGapDir=" + this.f3486g + ", mHasUnwantedGapAfter=" + this.f3488i + ", mGapPerSpan=" + Arrays.toString(this.f3487h) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f3485f);
                parcel.writeInt(this.f3486g);
                parcel.writeInt(this.f3488i ? 1 : 0);
                int[] iArr = this.f3487h;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f3487h);
                }
            }
        }

        d() {
        }

        private int i(int i10) {
            if (this.f3484b == null) {
                return -1;
            }
            a f10 = f(i10);
            if (f10 != null) {
                this.f3484b.remove(f10);
            }
            int size = this.f3484b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (this.f3484b.get(i11).f3485f >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            a aVar = this.f3484b.get(i11);
            this.f3484b.remove(i11);
            return aVar.f3485f;
        }

        private void l(int i10, int i11) {
            List<a> list = this.f3484b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f3484b.get(size);
                int i12 = aVar.f3485f;
                if (i12 >= i10) {
                    aVar.f3485f = i12 + i11;
                }
            }
        }

        private void m(int i10, int i11) {
            List<a> list = this.f3484b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f3484b.get(size);
                int i13 = aVar.f3485f;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f3484b.remove(size);
                    } else {
                        aVar.f3485f = i13 - i11;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f3484b == null) {
                this.f3484b = new ArrayList();
            }
            int size = this.f3484b.size();
            for (int i10 = 0; i10 < size; i10++) {
                a aVar2 = this.f3484b.get(i10);
                if (aVar2.f3485f == aVar.f3485f) {
                    this.f3484b.remove(i10);
                }
                if (aVar2.f3485f >= aVar.f3485f) {
                    this.f3484b.add(i10, aVar);
                    return;
                }
            }
            this.f3484b.add(aVar);
        }

        void b() {
            int[] iArr = this.f3483a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3484b = null;
        }

        void c(int i10) {
            int[] iArr = this.f3483a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f3483a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f3483a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f3483a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i10) {
            List<a> list = this.f3484b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f3484b.get(size).f3485f >= i10) {
                        this.f3484b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public a e(int i10, int i11, int i12, boolean z10) {
            List<a> list = this.f3484b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                a aVar = this.f3484b.get(i13);
                int i14 = aVar.f3485f;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || aVar.f3486g == i12 || (z10 && aVar.f3488i))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i10) {
            List<a> list = this.f3484b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f3484b.get(size);
                if (aVar.f3485f == i10) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i10) {
            int[] iArr = this.f3483a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        int h(int i10) {
            int[] iArr = this.f3483a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f3483a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f3483a.length;
            }
            int i12 = i11 + 1;
            Arrays.fill(this.f3483a, i10, i12, -1);
            return i12;
        }

        void j(int i10, int i11) {
            int[] iArr = this.f3483a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f3483a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f3483a, i10, i12, -1);
            l(i10, i11);
        }

        void k(int i10, int i11) {
            int[] iArr = this.f3483a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f3483a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f3483a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            m(i10, i11);
        }

        void n(int i10, f fVar) {
            c(i10);
            this.f3483a[i10] = fVar.f3503e;
        }

        int o(int i10) {
            int length = this.f3483a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        int f3489f;

        /* renamed from: g, reason: collision with root package name */
        int f3490g;

        /* renamed from: h, reason: collision with root package name */
        int f3491h;

        /* renamed from: i, reason: collision with root package name */
        int[] f3492i;

        /* renamed from: j, reason: collision with root package name */
        int f3493j;

        /* renamed from: k, reason: collision with root package name */
        int[] f3494k;

        /* renamed from: l, reason: collision with root package name */
        List<d.a> f3495l;

        /* renamed from: m, reason: collision with root package name */
        boolean f3496m;

        /* renamed from: n, reason: collision with root package name */
        boolean f3497n;

        /* renamed from: o, reason: collision with root package name */
        boolean f3498o;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        public e() {
        }

        e(Parcel parcel) {
            this.f3489f = parcel.readInt();
            this.f3490g = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3491h = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f3492i = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f3493j = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f3494k = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f3496m = parcel.readInt() == 1;
            this.f3497n = parcel.readInt() == 1;
            this.f3498o = parcel.readInt() == 1;
            this.f3495l = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f3491h = eVar.f3491h;
            this.f3489f = eVar.f3489f;
            this.f3490g = eVar.f3490g;
            this.f3492i = eVar.f3492i;
            this.f3493j = eVar.f3493j;
            this.f3494k = eVar.f3494k;
            this.f3496m = eVar.f3496m;
            this.f3497n = eVar.f3497n;
            this.f3498o = eVar.f3498o;
            this.f3495l = eVar.f3495l;
        }

        void a() {
            this.f3492i = null;
            this.f3491h = 0;
            this.f3489f = -1;
            this.f3490g = -1;
        }

        void b() {
            this.f3492i = null;
            this.f3491h = 0;
            this.f3493j = 0;
            this.f3494k = null;
            this.f3495l = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3489f);
            parcel.writeInt(this.f3490g);
            parcel.writeInt(this.f3491h);
            if (this.f3491h > 0) {
                parcel.writeIntArray(this.f3492i);
            }
            parcel.writeInt(this.f3493j);
            if (this.f3493j > 0) {
                parcel.writeIntArray(this.f3494k);
            }
            parcel.writeInt(this.f3496m ? 1 : 0);
            parcel.writeInt(this.f3497n ? 1 : 0);
            parcel.writeInt(this.f3498o ? 1 : 0);
            parcel.writeList(this.f3495l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<View> f3499a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        int f3500b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        int f3501c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        int f3502d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f3503e;

        f(int i10) {
            this.f3503e = i10;
        }

        void a(View view) {
            c n10 = n(view);
            n10.f3481e = this;
            this.f3499a.add(view);
            this.f3501c = Integer.MIN_VALUE;
            if (this.f3499a.size() == 1) {
                this.f3500b = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f3502d += StaggeredGridLayoutManager.this.f3467u.e(view);
            }
        }

        void b(boolean z10, int i10) {
            int l10 = z10 ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (l10 == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || l10 >= StaggeredGridLayoutManager.this.f3467u.i()) {
                if (z10 || l10 <= StaggeredGridLayoutManager.this.f3467u.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        l10 += i10;
                    }
                    this.f3501c = l10;
                    this.f3500b = l10;
                }
            }
        }

        void c() {
            d.a f10;
            ArrayList<View> arrayList = this.f3499a;
            View view = arrayList.get(arrayList.size() - 1);
            c n10 = n(view);
            this.f3501c = StaggeredGridLayoutManager.this.f3467u.d(view);
            if (n10.f3482f && (f10 = StaggeredGridLayoutManager.this.E.f(n10.a())) != null && f10.f3486g == 1) {
                this.f3501c += f10.a(this.f3503e);
            }
        }

        void d() {
            d.a f10;
            View view = this.f3499a.get(0);
            c n10 = n(view);
            this.f3500b = StaggeredGridLayoutManager.this.f3467u.g(view);
            if (n10.f3482f && (f10 = StaggeredGridLayoutManager.this.E.f(n10.a())) != null && f10.f3486g == -1) {
                this.f3500b -= f10.a(this.f3503e);
            }
        }

        void e() {
            this.f3499a.clear();
            q();
            this.f3502d = 0;
        }

        public int f() {
            int i10;
            int size;
            if (StaggeredGridLayoutManager.this.f3472z) {
                i10 = this.f3499a.size() - 1;
                size = -1;
            } else {
                i10 = 0;
                size = this.f3499a.size();
            }
            return i(i10, size, true);
        }

        public int g() {
            int size;
            int i10;
            if (StaggeredGridLayoutManager.this.f3472z) {
                size = 0;
                i10 = this.f3499a.size();
            } else {
                size = this.f3499a.size() - 1;
                i10 = -1;
            }
            return i(size, i10, true);
        }

        int h(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int m10 = StaggeredGridLayoutManager.this.f3467u.m();
            int i12 = StaggeredGridLayoutManager.this.f3467u.i();
            int i13 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = this.f3499a.get(i10);
                int g10 = StaggeredGridLayoutManager.this.f3467u.g(view);
                int d10 = StaggeredGridLayoutManager.this.f3467u.d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? g10 >= i12 : g10 > i12;
                if (!z12 ? d10 > m10 : d10 >= m10) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (!z10 || !z11) {
                        if (!z11 && g10 >= m10 && d10 <= i12) {
                        }
                        return StaggeredGridLayoutManager.this.h0(view);
                    }
                    if (g10 >= m10 && d10 <= i12) {
                        return StaggeredGridLayoutManager.this.h0(view);
                    }
                }
                i10 += i13;
            }
            return -1;
        }

        int i(int i10, int i11, boolean z10) {
            return h(i10, i11, false, false, z10);
        }

        public int j() {
            return this.f3502d;
        }

        int k() {
            int i10 = this.f3501c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f3501c;
        }

        int l(int i10) {
            int i11 = this.f3501c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3499a.size() == 0) {
                return i10;
            }
            c();
            return this.f3501c;
        }

        public View m(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f3499a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f3499a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f3472z && staggeredGridLayoutManager.h0(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f3472z && staggeredGridLayoutManager2.h0(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f3499a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = this.f3499a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f3472z && staggeredGridLayoutManager3.h0(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f3472z && staggeredGridLayoutManager4.h0(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i10 = this.f3500b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f3500b;
        }

        int p(int i10) {
            int i11 = this.f3500b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3499a.size() == 0) {
                return i10;
            }
            d();
            return this.f3500b;
        }

        void q() {
            this.f3500b = Integer.MIN_VALUE;
            this.f3501c = Integer.MIN_VALUE;
        }

        void r(int i10) {
            int i11 = this.f3500b;
            if (i11 != Integer.MIN_VALUE) {
                this.f3500b = i11 + i10;
            }
            int i12 = this.f3501c;
            if (i12 != Integer.MIN_VALUE) {
                this.f3501c = i12 + i10;
            }
        }

        void s() {
            int size = this.f3499a.size();
            View remove = this.f3499a.remove(size - 1);
            c n10 = n(remove);
            n10.f3481e = null;
            if (n10.c() || n10.b()) {
                this.f3502d -= StaggeredGridLayoutManager.this.f3467u.e(remove);
            }
            if (size == 1) {
                this.f3500b = Integer.MIN_VALUE;
            }
            this.f3501c = Integer.MIN_VALUE;
        }

        void t() {
            View remove = this.f3499a.remove(0);
            c n10 = n(remove);
            n10.f3481e = null;
            if (this.f3499a.size() == 0) {
                this.f3501c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f3502d -= StaggeredGridLayoutManager.this.f3467u.e(remove);
            }
            this.f3500b = Integer.MIN_VALUE;
        }

        void u(View view) {
            c n10 = n(view);
            n10.f3481e = this;
            this.f3499a.add(0, view);
            this.f3500b = Integer.MIN_VALUE;
            if (this.f3499a.size() == 1) {
                this.f3501c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f3502d += StaggeredGridLayoutManager.this.f3467u.e(view);
            }
        }

        void v(int i10) {
            this.f3500b = i10;
            this.f3501c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d i02 = RecyclerView.o.i0(context, attributeSet, i10, i11);
        G2(i02.f3426a);
        I2(i02.f3427b);
        H2(i02.f3428c);
        this.f3471y = new androidx.recyclerview.widget.f();
        Z1();
    }

    private void A2(RecyclerView.v vVar, int i10) {
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            if (this.f3467u.g(I) < i10 || this.f3467u.q(I) < i10) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f3482f) {
                for (int i11 = 0; i11 < this.f3465s; i11++) {
                    if (this.f3466t[i11].f3499a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f3465s; i12++) {
                    this.f3466t[i12].s();
                }
            } else if (cVar.f3481e.f3499a.size() == 1) {
                return;
            } else {
                cVar.f3481e.s();
            }
            m1(I, vVar);
        }
    }

    private void B2(RecyclerView.v vVar, int i10) {
        while (J() > 0) {
            View I = I(0);
            if (this.f3467u.d(I) > i10 || this.f3467u.p(I) > i10) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f3482f) {
                for (int i11 = 0; i11 < this.f3465s; i11++) {
                    if (this.f3466t[i11].f3499a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f3465s; i12++) {
                    this.f3466t[i12].t();
                }
            } else if (cVar.f3481e.f3499a.size() == 1) {
                return;
            } else {
                cVar.f3481e.t();
            }
            m1(I, vVar);
        }
    }

    private void C2() {
        if (this.f3468v.k() == 1073741824) {
            return;
        }
        float f10 = 0.0f;
        int J = J();
        for (int i10 = 0; i10 < J; i10++) {
            View I = I(i10);
            float e10 = this.f3468v.e(I);
            if (e10 >= f10) {
                if (((c) I.getLayoutParams()).f()) {
                    e10 = (e10 * 1.0f) / this.f3465s;
                }
                f10 = Math.max(f10, e10);
            }
        }
        int i11 = this.f3470x;
        int round = Math.round(f10 * this.f3465s);
        if (this.f3468v.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f3468v.n());
        }
        O2(round);
        if (this.f3470x == i11) {
            return;
        }
        for (int i12 = 0; i12 < J; i12++) {
            View I2 = I(i12);
            c cVar = (c) I2.getLayoutParams();
            if (!cVar.f3482f) {
                if (s2() && this.f3469w == 1) {
                    int i13 = this.f3465s;
                    int i14 = cVar.f3481e.f3503e;
                    I2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.f3470x) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = cVar.f3481e.f3503e;
                    int i16 = this.f3469w;
                    int i17 = (this.f3470x * i15) - (i15 * i11);
                    if (i16 == 1) {
                        I2.offsetLeftAndRight(i17);
                    } else {
                        I2.offsetTopAndBottom(i17);
                    }
                }
            }
        }
    }

    private void D2() {
        this.A = (this.f3469w == 1 || !s2()) ? this.f3472z : !this.f3472z;
    }

    private void F2(int i10) {
        androidx.recyclerview.widget.f fVar = this.f3471y;
        fVar.f3623e = i10;
        fVar.f3622d = this.A != (i10 == -1) ? -1 : 1;
    }

    private void J2(int i10, int i11) {
        for (int i12 = 0; i12 < this.f3465s; i12++) {
            if (!this.f3466t[i12].f3499a.isEmpty()) {
                P2(this.f3466t[i12], i10, i11);
            }
        }
    }

    private boolean K2(RecyclerView.a0 a0Var, b bVar) {
        boolean z10 = this.G;
        int b10 = a0Var.b();
        bVar.f3474a = z10 ? f2(b10) : b2(b10);
        bVar.f3475b = Integer.MIN_VALUE;
        return true;
    }

    private void L1(View view) {
        for (int i10 = this.f3465s - 1; i10 >= 0; i10--) {
            this.f3466t[i10].a(view);
        }
    }

    private void M1(b bVar) {
        boolean z10;
        e eVar = this.I;
        int i10 = eVar.f3491h;
        if (i10 > 0) {
            if (i10 == this.f3465s) {
                for (int i11 = 0; i11 < this.f3465s; i11++) {
                    this.f3466t[i11].e();
                    e eVar2 = this.I;
                    int i12 = eVar2.f3492i[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        i12 += eVar2.f3497n ? this.f3467u.i() : this.f3467u.m();
                    }
                    this.f3466t[i11].v(i12);
                }
            } else {
                eVar.b();
                e eVar3 = this.I;
                eVar3.f3489f = eVar3.f3490g;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.f3498o;
        H2(eVar4.f3496m);
        D2();
        e eVar5 = this.I;
        int i13 = eVar5.f3489f;
        if (i13 != -1) {
            this.C = i13;
            z10 = eVar5.f3497n;
        } else {
            z10 = this.A;
        }
        bVar.f3476c = z10;
        if (eVar5.f3493j > 1) {
            d dVar = this.E;
            dVar.f3483a = eVar5.f3494k;
            dVar.f3484b = eVar5.f3495l;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void N2(int r5, androidx.recyclerview.widget.RecyclerView.a0 r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.f r0 = r4.f3471y
            r1 = 0
            r0.f3620b = r1
            r0.f3621c = r5
            boolean r0 = r4.x0()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.j r5 = r4.f3467u
            int r5 = r5.n()
            goto L2f
        L25:
            androidx.recyclerview.widget.j r5 = r4.f3467u
            int r5 = r5.n()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.M()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.f r0 = r4.f3471y
            androidx.recyclerview.widget.j r3 = r4.f3467u
            int r3 = r3.m()
            int r3 = r3 - r6
            r0.f3624f = r3
            androidx.recyclerview.widget.f r6 = r4.f3471y
            androidx.recyclerview.widget.j r0 = r4.f3467u
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.f3625g = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.f r0 = r4.f3471y
            androidx.recyclerview.widget.j r3 = r4.f3467u
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.f3625g = r3
            androidx.recyclerview.widget.f r5 = r4.f3471y
            int r6 = -r6
            r5.f3624f = r6
        L5d:
            androidx.recyclerview.widget.f r5 = r4.f3471y
            r5.f3626h = r1
            r5.f3619a = r2
            androidx.recyclerview.widget.j r6 = r4.f3467u
            int r6 = r6.k()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.j r6 = r4.f3467u
            int r6 = r6.h()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.f3627i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.N2(int, androidx.recyclerview.widget.RecyclerView$a0):void");
    }

    private void P1(View view, c cVar, androidx.recyclerview.widget.f fVar) {
        if (fVar.f3623e == 1) {
            if (cVar.f3482f) {
                L1(view);
                return;
            } else {
                cVar.f3481e.a(view);
                return;
            }
        }
        if (cVar.f3482f) {
            y2(view);
        } else {
            cVar.f3481e.u(view);
        }
    }

    private void P2(f fVar, int i10, int i11) {
        int j10 = fVar.j();
        if (i10 == -1) {
            if (fVar.o() + j10 > i11) {
                return;
            }
        } else if (fVar.k() - j10 < i11) {
            return;
        }
        this.B.set(fVar.f3503e, false);
    }

    private int Q1(int i10) {
        if (J() == 0) {
            return this.A ? 1 : -1;
        }
        return (i10 < i2()) != this.A ? -1 : 1;
    }

    private int Q2(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    private boolean S1(f fVar) {
        if (this.A) {
            if (fVar.k() < this.f3467u.i()) {
                ArrayList<View> arrayList = fVar.f3499a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).f3482f;
            }
        } else if (fVar.o() > this.f3467u.m()) {
            return !fVar.n(fVar.f3499a.get(0)).f3482f;
        }
        return false;
    }

    private int T1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.a(a0Var, this.f3467u, d2(!this.N), c2(!this.N), this, this.N);
    }

    private int U1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.b(a0Var, this.f3467u, d2(!this.N), c2(!this.N), this, this.N, this.A);
    }

    private int V1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.c(a0Var, this.f3467u, d2(!this.N), c2(!this.N), this, this.N);
    }

    private int W1(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f3469w == 1) ? 1 : Integer.MIN_VALUE : this.f3469w == 0 ? 1 : Integer.MIN_VALUE : this.f3469w == 1 ? -1 : Integer.MIN_VALUE : this.f3469w == 0 ? -1 : Integer.MIN_VALUE : (this.f3469w != 1 && s2()) ? -1 : 1 : (this.f3469w != 1 && s2()) ? 1 : -1;
    }

    private d.a X1(int i10) {
        d.a aVar = new d.a();
        aVar.f3487h = new int[this.f3465s];
        for (int i11 = 0; i11 < this.f3465s; i11++) {
            aVar.f3487h[i11] = i10 - this.f3466t[i11].l(i10);
        }
        return aVar;
    }

    private d.a Y1(int i10) {
        d.a aVar = new d.a();
        aVar.f3487h = new int[this.f3465s];
        for (int i11 = 0; i11 < this.f3465s; i11++) {
            aVar.f3487h[i11] = this.f3466t[i11].p(i10) - i10;
        }
        return aVar;
    }

    private void Z1() {
        this.f3467u = j.b(this, this.f3469w);
        this.f3468v = j.b(this, 1 - this.f3469w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int a2(RecyclerView.v vVar, androidx.recyclerview.widget.f fVar, RecyclerView.a0 a0Var) {
        int i10;
        f fVar2;
        int e10;
        int i11;
        int i12;
        int e11;
        RecyclerView.o oVar;
        View view;
        int i13;
        int i14;
        ?? r92 = 0;
        this.B.set(0, this.f3465s, true);
        if (this.f3471y.f3627i) {
            i10 = fVar.f3623e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i10 = fVar.f3623e == 1 ? fVar.f3625g + fVar.f3620b : fVar.f3624f - fVar.f3620b;
        }
        J2(fVar.f3623e, i10);
        int i15 = this.A ? this.f3467u.i() : this.f3467u.m();
        boolean z10 = false;
        while (fVar.a(a0Var) && (this.f3471y.f3627i || !this.B.isEmpty())) {
            View b10 = fVar.b(vVar);
            c cVar = (c) b10.getLayoutParams();
            int a10 = cVar.a();
            int g10 = this.E.g(a10);
            boolean z11 = g10 == -1;
            if (z11) {
                fVar2 = cVar.f3482f ? this.f3466t[r92] : o2(fVar);
                this.E.n(a10, fVar2);
            } else {
                fVar2 = this.f3466t[g10];
            }
            f fVar3 = fVar2;
            cVar.f3481e = fVar3;
            if (fVar.f3623e == 1) {
                d(b10);
            } else {
                e(b10, r92);
            }
            u2(b10, cVar, r92);
            if (fVar.f3623e == 1) {
                int k22 = cVar.f3482f ? k2(i15) : fVar3.l(i15);
                int e12 = this.f3467u.e(b10) + k22;
                if (z11 && cVar.f3482f) {
                    d.a X1 = X1(k22);
                    X1.f3486g = -1;
                    X1.f3485f = a10;
                    this.E.a(X1);
                }
                i11 = e12;
                e10 = k22;
            } else {
                int n22 = cVar.f3482f ? n2(i15) : fVar3.p(i15);
                e10 = n22 - this.f3467u.e(b10);
                if (z11 && cVar.f3482f) {
                    d.a Y1 = Y1(n22);
                    Y1.f3486g = 1;
                    Y1.f3485f = a10;
                    this.E.a(Y1);
                }
                i11 = n22;
            }
            if (cVar.f3482f && fVar.f3622d == -1) {
                if (!z11) {
                    if (!(fVar.f3623e == 1 ? N1() : O1())) {
                        d.a f10 = this.E.f(a10);
                        if (f10 != null) {
                            f10.f3488i = true;
                        }
                    }
                }
                this.M = true;
            }
            P1(b10, cVar, fVar);
            if (s2() && this.f3469w == 1) {
                int i16 = cVar.f3482f ? this.f3468v.i() : this.f3468v.i() - (((this.f3465s - 1) - fVar3.f3503e) * this.f3470x);
                e11 = i16;
                i12 = i16 - this.f3468v.e(b10);
            } else {
                int m10 = cVar.f3482f ? this.f3468v.m() : (fVar3.f3503e * this.f3470x) + this.f3468v.m();
                i12 = m10;
                e11 = this.f3468v.e(b10) + m10;
            }
            if (this.f3469w == 1) {
                oVar = this;
                view = b10;
                i13 = i12;
                i12 = e10;
                i14 = e11;
            } else {
                oVar = this;
                view = b10;
                i13 = e10;
                i14 = i11;
                i11 = e11;
            }
            oVar.z0(view, i13, i12, i14, i11);
            if (cVar.f3482f) {
                J2(this.f3471y.f3623e, i10);
            } else {
                P2(fVar3, this.f3471y.f3623e, i10);
            }
            z2(vVar, this.f3471y);
            if (this.f3471y.f3626h && b10.hasFocusable()) {
                if (cVar.f3482f) {
                    this.B.clear();
                } else {
                    this.B.set(fVar3.f3503e, false);
                    z10 = true;
                    r92 = 0;
                }
            }
            z10 = true;
            r92 = 0;
        }
        if (!z10) {
            z2(vVar, this.f3471y);
        }
        int m11 = this.f3471y.f3623e == -1 ? this.f3467u.m() - n2(this.f3467u.m()) : k2(this.f3467u.i()) - this.f3467u.i();
        if (m11 > 0) {
            return Math.min(fVar.f3620b, m11);
        }
        return 0;
    }

    private int b2(int i10) {
        int J = J();
        for (int i11 = 0; i11 < J; i11++) {
            int h02 = h0(I(i11));
            if (h02 >= 0 && h02 < i10) {
                return h02;
            }
        }
        return 0;
    }

    private int f2(int i10) {
        for (int J = J() - 1; J >= 0; J--) {
            int h02 = h0(I(J));
            if (h02 >= 0 && h02 < i10) {
                return h02;
            }
        }
        return 0;
    }

    private void g2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10;
        int k22 = k2(Integer.MIN_VALUE);
        if (k22 != Integer.MIN_VALUE && (i10 = this.f3467u.i() - k22) > 0) {
            int i11 = i10 - (-E2(-i10, vVar, a0Var));
            if (!z10 || i11 <= 0) {
                return;
            }
            this.f3467u.r(i11);
        }
    }

    private void h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int m10;
        int n22 = n2(Integer.MAX_VALUE);
        if (n22 != Integer.MAX_VALUE && (m10 = n22 - this.f3467u.m()) > 0) {
            int E2 = m10 - E2(m10, vVar, a0Var);
            if (!z10 || E2 <= 0) {
                return;
            }
            this.f3467u.r(-E2);
        }
    }

    private int k2(int i10) {
        int l10 = this.f3466t[0].l(i10);
        for (int i11 = 1; i11 < this.f3465s; i11++) {
            int l11 = this.f3466t[i11].l(i10);
            if (l11 > l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    private int l2(int i10) {
        int p10 = this.f3466t[0].p(i10);
        for (int i11 = 1; i11 < this.f3465s; i11++) {
            int p11 = this.f3466t[i11].p(i10);
            if (p11 > p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    private int m2(int i10) {
        int l10 = this.f3466t[0].l(i10);
        for (int i11 = 1; i11 < this.f3465s; i11++) {
            int l11 = this.f3466t[i11].l(i10);
            if (l11 < l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    private int n2(int i10) {
        int p10 = this.f3466t[0].p(i10);
        for (int i11 = 1; i11 < this.f3465s; i11++) {
            int p11 = this.f3466t[i11].p(i10);
            if (p11 < p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    private f o2(androidx.recyclerview.widget.f fVar) {
        int i10;
        int i11;
        int i12 = -1;
        if (w2(fVar.f3623e)) {
            i10 = this.f3465s - 1;
            i11 = -1;
        } else {
            i10 = 0;
            i12 = this.f3465s;
            i11 = 1;
        }
        f fVar2 = null;
        if (fVar.f3623e == 1) {
            int i13 = Integer.MAX_VALUE;
            int m10 = this.f3467u.m();
            while (i10 != i12) {
                f fVar3 = this.f3466t[i10];
                int l10 = fVar3.l(m10);
                if (l10 < i13) {
                    fVar2 = fVar3;
                    i13 = l10;
                }
                i10 += i11;
            }
            return fVar2;
        }
        int i14 = Integer.MIN_VALUE;
        int i15 = this.f3467u.i();
        while (i10 != i12) {
            f fVar4 = this.f3466t[i10];
            int p10 = fVar4.p(i15);
            if (p10 > i14) {
                fVar2 = fVar4;
                i14 = p10;
            }
            i10 += i11;
        }
        return fVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void p2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.j2()
            goto Ld
        L9:
            int r0 = r6.i2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.j(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.j(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.A
            if (r7 == 0) goto L4d
            int r7 = r6.i2()
            goto L51
        L4d:
            int r7 = r6.j2()
        L51:
            if (r3 > r7) goto L56
            r6.t1()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.p2(int, int, int):void");
    }

    private void t2(View view, int i10, int i11, boolean z10) {
        j(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int Q2 = Q2(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int Q22 = Q2(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z10 ? H1(view, Q2, Q22, cVar) : F1(view, Q2, Q22, cVar)) {
            view.measure(Q2, Q22);
        }
    }

    private void u2(View view, c cVar, boolean z10) {
        int K;
        int K2;
        if (cVar.f3482f) {
            if (this.f3469w != 1) {
                t2(view, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z10);
                return;
            }
            K = this.J;
        } else {
            if (this.f3469w != 1) {
                K = RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                K2 = RecyclerView.o.K(this.f3470x, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
                t2(view, K, K2, z10);
            }
            K = RecyclerView.o.K(this.f3470x, p0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
        }
        K2 = RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        t2(view, K, K2, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x014b, code lost:
    
        if (R1() != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void v2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.v2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    private boolean w2(int i10) {
        if (this.f3469w == 0) {
            return (i10 == -1) != this.A;
        }
        return ((i10 == -1) == this.A) == s2();
    }

    private void y2(View view) {
        for (int i10 = this.f3465s - 1; i10 >= 0; i10--) {
            this.f3466t[i10].u(view);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r4.f3623e == (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z2(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.f r4) {
        /*
            r2 = this;
            boolean r0 = r4.f3619a
            if (r0 == 0) goto L4d
            boolean r0 = r4.f3627i
            if (r0 == 0) goto L9
            goto L4d
        L9:
            int r0 = r4.f3620b
            r1 = -1
            if (r0 != 0) goto L1e
            int r0 = r4.f3623e
            if (r0 != r1) goto L18
        L12:
            int r4 = r4.f3625g
        L14:
            r2.A2(r3, r4)
            goto L4d
        L18:
            int r4 = r4.f3624f
        L1a:
            r2.B2(r3, r4)
            goto L4d
        L1e:
            int r0 = r4.f3623e
            if (r0 != r1) goto L37
            int r0 = r4.f3624f
            int r1 = r2.l2(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L2c
            goto L12
        L2c:
            int r1 = r4.f3625g
            int r4 = r4.f3620b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L14
        L37:
            int r0 = r4.f3625g
            int r0 = r2.m2(r0)
            int r1 = r4.f3625g
            int r0 = r0 - r1
            if (r0 >= 0) goto L43
            goto L18
        L43:
            int r1 = r4.f3624f
            int r4 = r4.f3620b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L1a
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.z2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.f):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i10) {
        super.C0(i10);
        for (int i11 = 0; i11 < this.f3465s; i11++) {
            this.f3466t[i11].r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i10, int i11) {
        int n10;
        int n11;
        int e02 = e0() + f0();
        int g02 = g0() + d0();
        if (this.f3469w == 1) {
            n11 = RecyclerView.o.n(i11, rect.height() + g02, b0());
            n10 = RecyclerView.o.n(i10, (this.f3470x * this.f3465s) + e02, c0());
        } else {
            n10 = RecyclerView.o.n(i10, rect.width() + e02, c0());
            n11 = RecyclerView.o.n(i11, (this.f3470x * this.f3465s) + g02, b0());
        }
        B1(n10, n11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f3469w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i10) {
        super.D0(i10);
        for (int i11 = 0; i11 < this.f3465s; i11++) {
            this.f3466t[i11].r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    int E2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i10 == 0) {
            return 0;
        }
        x2(i10, a0Var);
        int a22 = a2(vVar, this.f3471y, a0Var);
        if (this.f3471y.f3620b >= a22) {
            i10 = i10 < 0 ? -a22 : a22;
        }
        this.f3467u.r(-i10);
        this.G = this.A;
        androidx.recyclerview.widget.f fVar = this.f3471y;
        fVar.f3620b = 0;
        z2(vVar, fVar);
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public void G2(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i10 == this.f3469w) {
            return;
        }
        this.f3469w = i10;
        j jVar = this.f3467u;
        this.f3467u = this.f3468v;
        this.f3468v = jVar;
        t1();
    }

    public void H2(boolean z10) {
        g(null);
        e eVar = this.I;
        if (eVar != null && eVar.f3496m != z10) {
            eVar.f3496m = z10;
        }
        this.f3472z = z10;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        o1(this.P);
        for (int i10 = 0; i10 < this.f3465s; i10++) {
            this.f3466t[i10].e();
        }
        recyclerView.requestLayout();
    }

    public void I2(int i10) {
        g(null);
        if (i10 != this.f3465s) {
            r2();
            this.f3465s = i10;
            this.B = new BitSet(this.f3465s);
            this.f3466t = new f[this.f3465s];
            for (int i11 = 0; i11 < this.f3465s; i11++) {
                this.f3466t[i11] = new f(i11);
            }
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View B;
        View m10;
        if (J() == 0 || (B = B(view)) == null) {
            return null;
        }
        D2();
        int W1 = W1(i10);
        if (W1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) B.getLayoutParams();
        boolean z10 = cVar.f3482f;
        f fVar = cVar.f3481e;
        int j22 = W1 == 1 ? j2() : i2();
        N2(j22, a0Var);
        F2(W1);
        androidx.recyclerview.widget.f fVar2 = this.f3471y;
        fVar2.f3621c = fVar2.f3622d + j22;
        fVar2.f3620b = (int) (this.f3467u.n() * 0.33333334f);
        androidx.recyclerview.widget.f fVar3 = this.f3471y;
        fVar3.f3626h = true;
        fVar3.f3619a = false;
        a2(vVar, fVar3, a0Var);
        this.G = this.A;
        if (!z10 && (m10 = fVar.m(j22, W1)) != null && m10 != B) {
            return m10;
        }
        if (w2(W1)) {
            for (int i11 = this.f3465s - 1; i11 >= 0; i11--) {
                View m11 = this.f3466t[i11].m(j22, W1);
                if (m11 != null && m11 != B) {
                    return m11;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f3465s; i12++) {
                View m12 = this.f3466t[i12].m(j22, W1);
                if (m12 != null && m12 != B) {
                    return m12;
                }
            }
        }
        boolean z11 = (this.f3472z ^ true) == (W1 == -1);
        if (!z10) {
            View C = C(z11 ? fVar.f() : fVar.g());
            if (C != null && C != B) {
                return C;
            }
        }
        if (w2(W1)) {
            for (int i13 = this.f3465s - 1; i13 >= 0; i13--) {
                if (i13 != fVar.f3503e) {
                    f[] fVarArr = this.f3466t;
                    View C2 = C(z11 ? fVarArr[i13].f() : fVarArr[i13].g());
                    if (C2 != null && C2 != B) {
                        return C2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f3465s; i14++) {
                f[] fVarArr2 = this.f3466t;
                View C3 = C(z11 ? fVarArr2[i14].f() : fVarArr2[i14].g());
                if (C3 != null && C3 != B) {
                    return C3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            View d22 = d2(false);
            View c22 = c2(false);
            if (d22 == null || c22 == null) {
                return;
            }
            int h02 = h0(d22);
            int h03 = h0(c22);
            if (h02 < h03) {
                accessibilityEvent.setFromIndex(h02);
                accessibilityEvent.setToIndex(h03);
            } else {
                accessibilityEvent.setFromIndex(h03);
                accessibilityEvent.setToIndex(h02);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean K1() {
        return this.I == null;
    }

    boolean L2(RecyclerView.a0 a0Var, b bVar) {
        int i10;
        int m10;
        int g10;
        if (!a0Var.e() && (i10 = this.C) != -1) {
            if (i10 >= 0 && i10 < a0Var.b()) {
                e eVar = this.I;
                if (eVar == null || eVar.f3489f == -1 || eVar.f3491h < 1) {
                    View C = C(this.C);
                    if (C != null) {
                        bVar.f3474a = this.A ? j2() : i2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f3476c) {
                                m10 = this.f3467u.i() - this.D;
                                g10 = this.f3467u.d(C);
                            } else {
                                m10 = this.f3467u.m() + this.D;
                                g10 = this.f3467u.g(C);
                            }
                            bVar.f3475b = m10 - g10;
                            return true;
                        }
                        if (this.f3467u.e(C) > this.f3467u.n()) {
                            bVar.f3475b = bVar.f3476c ? this.f3467u.i() : this.f3467u.m();
                            return true;
                        }
                        int g11 = this.f3467u.g(C) - this.f3467u.m();
                        if (g11 < 0) {
                            bVar.f3475b = -g11;
                            return true;
                        }
                        int i11 = this.f3467u.i() - this.f3467u.d(C);
                        if (i11 < 0) {
                            bVar.f3475b = i11;
                            return true;
                        }
                        bVar.f3475b = Integer.MIN_VALUE;
                    } else {
                        int i12 = this.C;
                        bVar.f3474a = i12;
                        int i13 = this.D;
                        if (i13 == Integer.MIN_VALUE) {
                            bVar.f3476c = Q1(i12) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i13);
                        }
                        bVar.f3477d = true;
                    }
                } else {
                    bVar.f3475b = Integer.MIN_VALUE;
                    bVar.f3474a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    void M2(RecyclerView.a0 a0Var, b bVar) {
        if (L2(a0Var, bVar) || K2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f3474a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3469w == 1 ? this.f3465s : super.N(vVar, a0Var);
    }

    boolean N1() {
        int l10 = this.f3466t[0].l(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3465s; i10++) {
            if (this.f3466t[i10].l(Integer.MIN_VALUE) != l10) {
                return false;
            }
        }
        return true;
    }

    boolean O1() {
        int p10 = this.f3466t[0].p(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3465s; i10++) {
            if (this.f3466t[i10].p(Integer.MIN_VALUE) != p10) {
                return false;
            }
        }
        return true;
    }

    void O2(int i10) {
        this.f3470x = i10 / this.f3465s;
        this.J = View.MeasureSpec.makeMeasureSpec(i10, this.f3468v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, androidx.core.view.accessibility.d dVar) {
        int i10;
        int i11;
        int e10;
        boolean z10;
        int i12;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.O0(view, dVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f3469w == 0) {
            i10 = cVar.e();
            z10 = cVar.f3482f;
            i11 = z10 ? this.f3465s : 1;
            e10 = -1;
            i12 = -1;
        } else {
            i10 = -1;
            i11 = -1;
            e10 = cVar.e();
            z10 = cVar.f3482f;
            i12 = z10 ? this.f3465s : 1;
        }
        dVar.Y(d.c.a(i10, i11, e10, i12, z10, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i10, int i11) {
        p2(i10, i11, 1);
    }

    boolean R1() {
        int i22;
        int j22;
        if (J() == 0 || this.F == 0 || !r0()) {
            return false;
        }
        if (this.A) {
            i22 = j2();
            j22 = i2();
        } else {
            i22 = i2();
            j22 = j2();
        }
        if (i22 == 0 && q2() != null) {
            this.E.b();
        } else {
            if (!this.M) {
                return false;
            }
            int i10 = this.A ? -1 : 1;
            int i11 = j22 + 1;
            d.a e10 = this.E.e(i22, i11, i10, true);
            if (e10 == null) {
                this.M = false;
                this.E.d(i11);
                return false;
            }
            d.a e11 = this.E.e(i22, e10.f3485f, i10 * (-1), true);
            if (e11 == null) {
                this.E.d(e10.f3485f);
            } else {
                this.E.d(e11.f3485f + 1);
            }
        }
        u1();
        t1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.E.b();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i10, int i11, int i12) {
        p2(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i10, int i11) {
        p2(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        p2(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        v2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i10) {
        int Q1 = Q1(i10);
        PointF pointF = new PointF();
        if (Q1 == 0) {
            return null;
        }
        if (this.f3469w == 0) {
            pointF.x = Q1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = Q1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            t1();
        }
    }

    View c2(boolean z10) {
        int m10 = this.f3467u.m();
        int i10 = this.f3467u.i();
        View view = null;
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            int g10 = this.f3467u.g(I);
            int d10 = this.f3467u.d(I);
            if (d10 > m10 && g10 < i10) {
                if (d10 <= i10 || !z10) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        int p10;
        int m10;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.f3496m = this.f3472z;
        eVar.f3497n = this.G;
        eVar.f3498o = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f3483a) == null) {
            eVar.f3493j = 0;
        } else {
            eVar.f3494k = iArr;
            eVar.f3493j = iArr.length;
            eVar.f3495l = dVar.f3484b;
        }
        if (J() > 0) {
            eVar.f3489f = this.G ? j2() : i2();
            eVar.f3490g = e2();
            int i10 = this.f3465s;
            eVar.f3491h = i10;
            eVar.f3492i = new int[i10];
            for (int i11 = 0; i11 < this.f3465s; i11++) {
                if (this.G) {
                    p10 = this.f3466t[i11].l(Integer.MIN_VALUE);
                    if (p10 != Integer.MIN_VALUE) {
                        m10 = this.f3467u.i();
                        p10 -= m10;
                        eVar.f3492i[i11] = p10;
                    } else {
                        eVar.f3492i[i11] = p10;
                    }
                } else {
                    p10 = this.f3466t[i11].p(Integer.MIN_VALUE);
                    if (p10 != Integer.MIN_VALUE) {
                        m10 = this.f3467u.m();
                        p10 -= m10;
                        eVar.f3492i[i11] = p10;
                    } else {
                        eVar.f3492i[i11] = p10;
                    }
                }
            }
        } else {
            eVar.f3489f = -1;
            eVar.f3490g = -1;
            eVar.f3491h = 0;
        }
        return eVar;
    }

    View d2(boolean z10) {
        int m10 = this.f3467u.m();
        int i10 = this.f3467u.i();
        int J = J();
        View view = null;
        for (int i11 = 0; i11 < J; i11++) {
            View I = I(i11);
            int g10 = this.f3467u.g(I);
            if (this.f3467u.d(I) > m10 && g10 < i10) {
                if (g10 >= m10 || !z10) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(int i10) {
        if (i10 == 0) {
            R1();
        }
    }

    int e2() {
        View c22 = this.A ? c2(true) : d2(true);
        if (c22 == null) {
            return -1;
        }
        return h0(c22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.I == null) {
            super.g(str);
        }
    }

    int i2() {
        if (J() == 0) {
            return 0;
        }
        return h0(I(0));
    }

    int j2() {
        int J = J();
        if (J == 0) {
            return 0;
        }
        return h0(I(J - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f3469w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3469w == 0 ? this.f3465s : super.k0(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f3469w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int l10;
        int i12;
        if (this.f3469w != 0) {
            i10 = i11;
        }
        if (J() == 0 || i10 == 0) {
            return;
        }
        x2(i10, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f3465s) {
            this.O = new int[this.f3465s];
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.f3465s; i14++) {
            androidx.recyclerview.widget.f fVar = this.f3471y;
            if (fVar.f3622d == -1) {
                l10 = fVar.f3624f;
                i12 = this.f3466t[i14].p(l10);
            } else {
                l10 = this.f3466t[i14].l(fVar.f3625g);
                i12 = this.f3471y.f3625g;
            }
            int i15 = l10 - i12;
            if (i15 >= 0) {
                this.O[i13] = i15;
                i13++;
            }
        }
        Arrays.sort(this.O, 0, i13);
        for (int i16 = 0; i16 < i13 && this.f3471y.a(a0Var); i16++) {
            cVar.a(this.f3471y.f3621c, this.O[i16]);
            androidx.recyclerview.widget.f fVar2 = this.f3471y;
            fVar2.f3621c += fVar2.f3622d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return T1(a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View q2() {
        /*
            r12 = this;
            int r0 = r12.J()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f3465s
            r2.<init>(r3)
            int r3 = r12.f3465s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f3469w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.s2()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.A
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.I(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f3481e
            int r9 = r9.f3503e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f3481e
            boolean r9 = r12.S1(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f3481e
            int r9 = r9.f3503e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f3482f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.I(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.j r10 = r12.f3467u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.j r11 = r12.f3467u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.j r10 = r12.f3467u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.j r11 = r12.f3467u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f3481e
            int r8 = r8.f3503e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f3481e
            int r9 = r9.f3503e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.q2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    public void r2() {
        this.E.b();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return this.F != 0;
    }

    boolean s2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return T1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return E2(i10, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i10) {
        e eVar = this.I;
        if (eVar != null && eVar.f3489f != i10) {
            eVar.a();
        }
        this.C = i10;
        this.D = Integer.MIN_VALUE;
        t1();
    }

    void x2(int i10, RecyclerView.a0 a0Var) {
        int i22;
        int i11;
        if (i10 > 0) {
            i22 = j2();
            i11 = 1;
        } else {
            i22 = i2();
            i11 = -1;
        }
        this.f3471y.f3619a = true;
        N2(i22, a0Var);
        F2(i11);
        androidx.recyclerview.widget.f fVar = this.f3471y;
        fVar.f3621c = i22 + fVar.f3622d;
        fVar.f3620b = Math.abs(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return E2(i10, vVar, a0Var);
    }
}
