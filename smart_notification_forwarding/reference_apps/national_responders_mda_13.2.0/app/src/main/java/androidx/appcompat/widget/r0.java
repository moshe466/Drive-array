package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.k0;

/* loaded from: classes.dex */
public class r0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: f, reason: collision with root package name */
    Runnable f1480f;

    /* renamed from: g, reason: collision with root package name */
    private c f1481g;

    /* renamed from: h, reason: collision with root package name */
    k0 f1482h;

    /* renamed from: i, reason: collision with root package name */
    private Spinner f1483i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1484j;

    /* renamed from: k, reason: collision with root package name */
    int f1485k;

    /* renamed from: l, reason: collision with root package name */
    int f1486l;

    /* renamed from: m, reason: collision with root package name */
    private int f1487m;

    /* renamed from: n, reason: collision with root package name */
    private int f1488n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f1489f;

        a(View view) {
            this.f1489f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            r0.this.smoothScrollTo(this.f1489f.getLeft() - ((r0.this.getWidth() - this.f1489f.getWidth()) / 2), 0);
            r0.this.f1480f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return r0.this.f1482h.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ((d) r0.this.f1482h.getChildAt(i10)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return r0.this.c((a.c) getItem(i10), true);
            }
            ((d) view).a((a.c) getItem(i10));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = r0.this.f1482h.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = r0.this.f1482h.getChildAt(i10);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: f, reason: collision with root package name */
        private final int[] f1493f;

        /* renamed from: g, reason: collision with root package name */
        private a.c f1494g;

        /* renamed from: h, reason: collision with root package name */
        private TextView f1495h;

        /* renamed from: i, reason: collision with root package name */
        private ImageView f1496i;

        /* renamed from: j, reason: collision with root package name */
        private View f1497j;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public d(android.content.Context r6, androidx.appcompat.app.a.c r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.r0.this = r5
                int r5 = e.a.f8857d
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f1493f = r1
                r4.f1494g = r7
                androidx.appcompat.widget.y0 r5 = androidx.appcompat.widget.y0.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L26
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L26:
                r5.w()
                if (r8 == 0) goto L31
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L31:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r0.d.<init>(androidx.appcompat.widget.r0, android.content.Context, androidx.appcompat.app.a$c, boolean):void");
        }

        public void a(a.c cVar) {
            this.f1494g = cVar;
            c();
        }

        public a.c b() {
            return this.f1494g;
        }

        public void c() {
            a.c cVar = this.f1494g;
            View b10 = cVar.b();
            if (b10 != null) {
                ViewParent parent = b10.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b10);
                    }
                    addView(b10);
                }
                this.f1497j = b10;
                TextView textView = this.f1495h;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1496i;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1496i.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1497j;
            if (view != null) {
                removeView(view);
                this.f1497j = null;
            }
            Drawable c10 = cVar.c();
            CharSequence d10 = cVar.d();
            if (c10 != null) {
                if (this.f1496i == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1496i = appCompatImageView;
                }
                this.f1496i.setImageDrawable(c10);
                this.f1496i.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1496i;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1496i.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(d10);
            if (z10) {
                if (this.f1495h == null) {
                    b0 b0Var = new b0(getContext(), null, e.a.f8858e);
                    b0Var.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    b0Var.setLayoutParams(layoutParams2);
                    addView(b0Var);
                    this.f1495h = b0Var;
                }
                this.f1495h.setText(d10);
                this.f1495h.setVisibility(0);
            } else {
                TextView textView2 = this.f1495h;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1495h.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1496i;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            b1.a(this, z10 ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (r0.this.f1485k > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = r0.this.f1485k;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        y yVar = new y(getContext(), null, e.a.f8861h);
        yVar.setLayoutParams(new k0.a(-2, -1));
        yVar.setOnItemSelectedListener(this);
        return yVar;
    }

    private boolean d() {
        Spinner spinner = this.f1483i;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f1483i == null) {
            this.f1483i = b();
        }
        removeView(this.f1482h);
        addView(this.f1483i, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1483i.getAdapter() == null) {
            this.f1483i.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f1480f;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f1480f = null;
        }
        this.f1483i.setSelection(this.f1488n);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1483i);
        addView(this.f1482h, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1483i.getSelectedItemPosition());
        return false;
    }

    public void a(int i10) {
        View childAt = this.f1482h.getChildAt(i10);
        Runnable runnable = this.f1480f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f1480f = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z10) {
        d dVar = new d(this, getContext(), cVar, z10);
        if (z10) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1487m));
        } else {
            dVar.setFocusable(true);
            if (this.f1481g == null) {
                this.f1481g = new c();
            }
            dVar.setOnClickListener(this.f1481g);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1480f;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(getContext());
        setContentHeight(b10.f());
        this.f1486l = b10.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1480f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int mode = View.MeasureSpec.getMode(i10);
        boolean z10 = mode == 1073741824;
        setFillViewport(z10);
        int childCount = this.f1482h.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i12 = -1;
        } else {
            if (childCount > 2) {
                this.f1485k = (int) (View.MeasureSpec.getSize(i10) * 0.4f);
            } else {
                this.f1485k = View.MeasureSpec.getSize(i10) / 2;
            }
            i12 = Math.min(this.f1485k, this.f1486l);
        }
        this.f1485k = i12;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1487m, 1073741824);
        if (!z10 && this.f1484j) {
            this.f1482h.measure(0, makeMeasureSpec);
            if (this.f1482h.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                e();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i10, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z10 || measuredWidth == measuredWidth2) {
                }
                setTabSelected(this.f1488n);
                return;
            }
        }
        f();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i10, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z10) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f1484j = z10;
    }

    public void setContentHeight(int i10) {
        this.f1487m = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        this.f1488n = i10;
        int childCount = this.f1482h.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = this.f1482h.getChildAt(i11);
            boolean z10 = i11 == i10;
            childAt.setSelected(z10);
            if (z10) {
                a(i10);
            }
            i11++;
        }
        Spinner spinner = this.f1483i;
        if (spinner == null || i10 < 0) {
            return;
        }
        spinner.setSelection(i10);
    }
}
