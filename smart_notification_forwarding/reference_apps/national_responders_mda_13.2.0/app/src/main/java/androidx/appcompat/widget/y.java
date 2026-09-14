package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.b;

/* loaded from: classes.dex */
public class y extends Spinner implements androidx.core.view.y {

    /* renamed from: n, reason: collision with root package name */
    @SuppressLint({"ResourceType"})
    private static final int[] f1545n = {R.attr.spinnerMode};

    /* renamed from: f, reason: collision with root package name */
    private final androidx.appcompat.widget.e f1546f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f1547g;

    /* renamed from: h, reason: collision with root package name */
    private j0 f1548h;

    /* renamed from: i, reason: collision with root package name */
    private SpinnerAdapter f1549i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f1550j;

    /* renamed from: k, reason: collision with root package name */
    private j f1551k;

    /* renamed from: l, reason: collision with root package name */
    int f1552l;

    /* renamed from: m, reason: collision with root package name */
    final Rect f1553m;

    /* loaded from: classes.dex */
    class a extends j0 {

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ h f1554o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, h hVar) {
            super(view);
            this.f1554o = hVar;
        }

        @Override // androidx.appcompat.widget.j0
        public androidx.appcompat.view.menu.p b() {
            return this.f1554o;
        }

        @Override // androidx.appcompat.widget.j0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (y.this.getInternalPopup().c()) {
                return true;
            }
            y.this.b();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!y.this.getInternalPopup().c()) {
                y.this.b();
            }
            ViewTreeObserver viewTreeObserver = y.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    c.a(viewTreeObserver, this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class c {
        static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {
        static int a(View view) {
            return view.getTextAlignment();
        }

        static int b(View view) {
            return view.getTextDirection();
        }

        static void c(View view, int i10) {
            view.setTextAlignment(i10);
        }

        static void d(View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    /* loaded from: classes.dex */
    private static final class e {
        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    /* loaded from: classes.dex */
    class f implements j, DialogInterface.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        androidx.appcompat.app.b f1557f;

        /* renamed from: g, reason: collision with root package name */
        private ListAdapter f1558g;

        /* renamed from: h, reason: collision with root package name */
        private CharSequence f1559h;

        f() {
        }

        @Override // androidx.appcompat.widget.y.j
        public void b(Drawable drawable) {
        }

        @Override // androidx.appcompat.widget.y.j
        public boolean c() {
            androidx.appcompat.app.b bVar = this.f1557f;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.y.j
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.y.j
        public void dismiss() {
            androidx.appcompat.app.b bVar = this.f1557f;
            if (bVar != null) {
                bVar.dismiss();
                this.f1557f = null;
            }
        }

        @Override // androidx.appcompat.widget.y.j
        public Drawable g() {
            return null;
        }

        @Override // androidx.appcompat.widget.y.j
        public void i(CharSequence charSequence) {
            this.f1559h = charSequence;
        }

        @Override // androidx.appcompat.widget.y.j
        public void j(int i10) {
        }

        @Override // androidx.appcompat.widget.y.j
        public void k(int i10) {
        }

        @Override // androidx.appcompat.widget.y.j
        public void l(int i10) {
        }

        @Override // androidx.appcompat.widget.y.j
        public void m(int i10, int i11) {
            if (this.f1558g == null) {
                return;
            }
            b.a aVar = new b.a(y.this.getPopupContext());
            CharSequence charSequence = this.f1559h;
            if (charSequence != null) {
                aVar.l(charSequence);
            }
            androidx.appcompat.app.b a10 = aVar.k(this.f1558g, y.this.getSelectedItemPosition(), this).a();
            this.f1557f = a10;
            ListView l10 = a10.l();
            if (Build.VERSION.SDK_INT >= 17) {
                d.d(l10, i10);
                d.c(l10, i11);
            }
            this.f1557f.show();
        }

        @Override // androidx.appcompat.widget.y.j
        public int n() {
            return 0;
        }

        @Override // androidx.appcompat.widget.y.j
        public CharSequence o() {
            return this.f1559h;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            y.this.setSelection(i10);
            if (y.this.getOnItemClickListener() != null) {
                y.this.performItemClick(null, i10, this.f1558g.getItemId(i10));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.y.j
        public void p(ListAdapter listAdapter) {
            this.f1558g = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g implements ListAdapter, SpinnerAdapter {

        /* renamed from: f, reason: collision with root package name */
        private SpinnerAdapter f1561f;

        /* renamed from: g, reason: collision with root package name */
        private ListAdapter f1562g;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1561f = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1562g = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof u0) {
                    u0 u0Var = (u0) spinnerAdapter;
                    if (u0Var.getDropDownViewTheme() == null) {
                        u0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1562g;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1561f;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1561f;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1561f;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1561f;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1561f;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f1562g;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1561f;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1561f;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    class h extends l0 implements j {
        private CharSequence N;
        ListAdapter O;
        private final Rect P;
        private int Q;

        /* loaded from: classes.dex */
        class a implements AdapterView.OnItemClickListener {
            a(y yVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                y.this.setSelection(i10);
                if (y.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    y.this.performItemClick(view, i10, hVar.O.getItemId(i10));
                }
                h.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.Q(y.this)) {
                    h.this.dismiss();
                } else {
                    h.this.O();
                    h.super.a();
                }
            }
        }

        /* loaded from: classes.dex */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1565f;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1565f = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = y.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1565f);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.P = new Rect();
            z(y.this);
            F(true);
            K(0);
            H(new a(y.this));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void O() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.g()
                r1 = 0
                if (r0 == 0) goto L26
                androidx.appcompat.widget.y r1 = androidx.appcompat.widget.y.this
                android.graphics.Rect r1 = r1.f1553m
                r0.getPadding(r1)
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                boolean r0 = androidx.appcompat.widget.h1.b(r0)
                if (r0 == 0) goto L1d
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                android.graphics.Rect r0 = r0.f1553m
                int r0 = r0.right
                goto L24
            L1d:
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                android.graphics.Rect r0 = r0.f1553m
                int r0 = r0.left
                int r0 = -r0
            L24:
                r1 = r0
                goto L2e
            L26:
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                android.graphics.Rect r0 = r0.f1553m
                r0.right = r1
                r0.left = r1
            L2e:
                androidx.appcompat.widget.y r0 = androidx.appcompat.widget.y.this
                int r0 = r0.getPaddingLeft()
                androidx.appcompat.widget.y r2 = androidx.appcompat.widget.y.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.y r3 = androidx.appcompat.widget.y.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.y r4 = androidx.appcompat.widget.y.this
                int r5 = r4.f1552l
                r6 = -2
                if (r5 != r6) goto L78
                android.widget.ListAdapter r5 = r8.O
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.g()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.y r5 = androidx.appcompat.widget.y.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.y r6 = androidx.appcompat.widget.y.this
                android.graphics.Rect r6 = r6.f1553m
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L70
                r4 = r5
            L70:
                int r5 = r3 - r0
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
                goto L7e
            L78:
                r4 = -1
                if (r5 != r4) goto L82
                int r4 = r3 - r0
                int r4 = r4 - r2
            L7e:
                r8.B(r4)
                goto L85
            L82:
                r8.B(r5)
            L85:
                androidx.appcompat.widget.y r4 = androidx.appcompat.widget.y.this
                boolean r4 = androidx.appcompat.widget.h1.b(r4)
                if (r4 == 0) goto L9a
                int r3 = r3 - r2
                int r0 = r8.v()
                int r3 = r3 - r0
                int r0 = r8.P()
                int r3 = r3 - r0
                int r1 = r1 + r3
                goto La0
            L9a:
                int r2 = r8.P()
                int r0 = r0 + r2
                int r1 = r1 + r0
            La0:
                r8.l(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.h.O():void");
        }

        public int P() {
            return this.Q;
        }

        boolean Q(View view) {
            return androidx.core.view.a0.R(view) && view.getGlobalVisibleRect(this.P);
        }

        @Override // androidx.appcompat.widget.y.j
        public void i(CharSequence charSequence) {
            this.N = charSequence;
        }

        @Override // androidx.appcompat.widget.y.j
        public void k(int i10) {
            this.Q = i10;
        }

        @Override // androidx.appcompat.widget.y.j
        public void m(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean c10 = c();
            O();
            E(2);
            super.a();
            ListView h10 = h();
            h10.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                d.d(h10, i10);
                d.c(h10, i11);
            }
            L(y.this.getSelectedItemPosition());
            if (c10 || (viewTreeObserver = y.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            G(new c(bVar));
        }

        @Override // androidx.appcompat.widget.y.j
        public CharSequence o() {
            return this.N;
        }

        @Override // androidx.appcompat.widget.l0, androidx.appcompat.widget.y.j
        public void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.O = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i extends View.BaseSavedState {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        boolean f1567f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<i> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i10) {
                return new i[i10];
            }
        }

        i(Parcel parcel) {
            super(parcel);
            this.f1567f = parcel.readByte() != 0;
        }

        i(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f1567f ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface j {
        void b(Drawable drawable);

        boolean c();

        int d();

        void dismiss();

        Drawable g();

        void i(CharSequence charSequence);

        void j(int i10);

        void k(int i10);

        void l(int i10);

        void m(int i10, int i11);

        int n();

        CharSequence o();

        void p(ListAdapter listAdapter);
    }

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.a.J);
    }

    public y(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public y(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        if (r10 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y(android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.f1553m = r0
            android.content.Context r0 = r5.getContext()
            androidx.appcompat.widget.t0.a(r5, r0)
            int[] r0 = e.j.f9080r2
            r1 = 0
            androidx.appcompat.widget.y0 r0 = androidx.appcompat.widget.y0.v(r6, r7, r0, r8, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r5)
            r5.f1546f = r2
            if (r10 == 0) goto L29
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>(r6, r10)
        L26:
            r5.f1547g = r2
            goto L39
        L29:
            int r10 = e.j.f9105w2
            int r10 = r0.n(r10, r1)
            if (r10 == 0) goto L37
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>(r6, r10)
            goto L26
        L37:
            r5.f1547g = r6
        L39:
            r10 = -1
            r2 = 0
            if (r9 != r10) goto L5f
            int[] r10 = androidx.appcompat.widget.y.f1545n     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
            android.content.res.TypedArray r10 = r6.obtainStyledAttributes(r7, r10, r8, r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
            boolean r3 = r10.hasValue(r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L5c
            if (r3 == 0) goto L4d
            int r9 = r10.getInt(r1, r1)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L5c
        L4d:
            r10.recycle()
            goto L5f
        L51:
            r6 = move-exception
            r2 = r10
            goto L55
        L54:
            r6 = move-exception
        L55:
            if (r2 == 0) goto L5a
            r2.recycle()
        L5a:
            throw r6
        L5b:
            r10 = r2
        L5c:
            if (r10 == 0) goto L5f
            goto L4d
        L5f:
            r10 = 1
            if (r9 == 0) goto L9c
            if (r9 == r10) goto L65
            goto Lac
        L65:
            androidx.appcompat.widget.y$h r9 = new androidx.appcompat.widget.y$h
            android.content.Context r3 = r5.f1547g
            r9.<init>(r3, r7, r8)
            android.content.Context r3 = r5.f1547g
            int[] r4 = e.j.f9080r2
            androidx.appcompat.widget.y0 r1 = androidx.appcompat.widget.y0.v(r3, r7, r4, r8, r1)
            int r3 = e.j.f9100v2
            r4 = -2
            int r3 = r1.m(r3, r4)
            r5.f1552l = r3
            int r3 = e.j.f9090t2
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r9.b(r3)
            int r3 = e.j.f9095u2
            java.lang.String r3 = r0.o(r3)
            r9.i(r3)
            r1.w()
            r5.f1551k = r9
            androidx.appcompat.widget.y$a r1 = new androidx.appcompat.widget.y$a
            r1.<init>(r5, r9)
            r5.f1548h = r1
            goto Lac
        L9c:
            androidx.appcompat.widget.y$f r9 = new androidx.appcompat.widget.y$f
            r9.<init>()
            r5.f1551k = r9
            int r1 = e.j.f9095u2
            java.lang.String r1 = r0.o(r1)
            r9.i(r1)
        Lac:
            int r9 = e.j.f9085s2
            java.lang.CharSequence[] r9 = r0.q(r9)
            if (r9 == 0) goto Lc4
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r6, r3, r9)
            int r6 = e.g.f8975t
            r1.setDropDownViewResource(r6)
            r5.setAdapter(r1)
        Lc4:
            r0.w()
            r5.f1550j = r10
            android.widget.SpinnerAdapter r6 = r5.f1549i
            if (r6 == 0) goto Ld2
            r5.setAdapter(r6)
            r5.f1549i = r2
        Ld2:
            androidx.appcompat.widget.e r6 = r5.f1546f
            r6.e(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        drawable.getPadding(this.f1553m);
        Rect rect = this.f1553m;
        return i11 + rect.left + rect.right;
    }

    void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1551k.m(d.b(this), d.a(this));
        } else {
            this.f1551k.m(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.f1546f;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        j jVar = this.f1551k;
        if (jVar != null) {
            return jVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        j jVar = this.f1551k;
        if (jVar != null) {
            return jVar.n();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f1551k != null) {
            return this.f1552l;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final j getInternalPopup() {
        return this.f1551k;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        j jVar = this.f1551k;
        if (jVar != null) {
            return jVar.g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1547g;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        j jVar = this.f1551k;
        return jVar != null ? jVar.o() : super.getPrompt();
    }

    @Override // androidx.core.view.y
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.f1546f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.y
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.f1546f;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.f1551k;
        if (jVar == null || !jVar.c()) {
            return;
        }
        this.f1551k.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f1551k == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        if (!iVar.f1567f || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        j jVar = this.f1551k;
        iVar.f1567f = jVar != null && jVar.c();
        return iVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j0 j0Var = this.f1548h;
        if (j0Var == null || !j0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        j jVar = this.f1551k;
        if (jVar == null) {
            return super.performClick();
        }
        if (jVar.c()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1550j) {
            this.f1549i = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1551k != null) {
            Context context = this.f1547g;
            if (context == null) {
                context = getContext();
            }
            this.f1551k.p(new g(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.f1546f;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        androidx.appcompat.widget.e eVar = this.f1546f;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        j jVar = this.f1551k;
        if (jVar != null) {
            jVar.k(i10);
            this.f1551k.l(i10);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        j jVar = this.f1551k;
        if (jVar != null) {
            jVar.j(i10);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f1551k != null) {
            this.f1552l = i10;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        j jVar = this.f1551k;
        if (jVar != null) {
            jVar.b(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(f.a.b(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        j jVar = this.f1551k;
        if (jVar != null) {
            jVar.i(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.f1546f;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.f1546f;
        if (eVar != null) {
            eVar.j(mode);
        }
    }
}
