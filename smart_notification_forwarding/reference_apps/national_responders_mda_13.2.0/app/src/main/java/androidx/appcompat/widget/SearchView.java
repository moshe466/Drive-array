package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends k0 implements androidx.appcompat.view.c {

    /* renamed from: v0, reason: collision with root package name */
    static final o f1111v0;
    final ImageView A;
    final ImageView B;
    private final View C;
    private q D;
    private Rect E;
    private Rect F;
    private int[] G;
    private int[] H;
    private final ImageView I;
    private final Drawable J;
    private final int K;
    private final int L;
    private final Intent M;
    private final Intent N;
    private final CharSequence O;
    private m P;
    private l Q;
    View.OnFocusChangeListener R;
    private n S;
    private View.OnClickListener T;
    private boolean U;
    private boolean V;
    x.a W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f1112a0;

    /* renamed from: b0, reason: collision with root package name */
    private CharSequence f1113b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f1114c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f1115d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f1116e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f1117f0;

    /* renamed from: g0, reason: collision with root package name */
    private CharSequence f1118g0;

    /* renamed from: h0, reason: collision with root package name */
    private CharSequence f1119h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f1120i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f1121j0;

    /* renamed from: k0, reason: collision with root package name */
    SearchableInfo f1122k0;

    /* renamed from: l0, reason: collision with root package name */
    private Bundle f1123l0;

    /* renamed from: m0, reason: collision with root package name */
    private final Runnable f1124m0;

    /* renamed from: n0, reason: collision with root package name */
    private Runnable f1125n0;

    /* renamed from: o0, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1126o0;

    /* renamed from: p0, reason: collision with root package name */
    private final View.OnClickListener f1127p0;

    /* renamed from: q0, reason: collision with root package name */
    View.OnKeyListener f1128q0;

    /* renamed from: r0, reason: collision with root package name */
    private final TextView.OnEditorActionListener f1129r0;

    /* renamed from: s0, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f1130s0;

    /* renamed from: t0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f1131t0;

    /* renamed from: u, reason: collision with root package name */
    final SearchAutoComplete f1132u;

    /* renamed from: u0, reason: collision with root package name */
    private TextWatcher f1133u0;

    /* renamed from: v, reason: collision with root package name */
    private final View f1134v;

    /* renamed from: w, reason: collision with root package name */
    private final View f1135w;

    /* renamed from: x, reason: collision with root package name */
    private final View f1136x;

    /* renamed from: y, reason: collision with root package name */
    final ImageView f1137y;

    /* renamed from: z, reason: collision with root package name */
    final ImageView f1138z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* renamed from: j, reason: collision with root package name */
        private int f1139j;

        /* renamed from: k, reason: collision with root package name */
        private SearchView f1140k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f1141l;

        /* renamed from: m, reason: collision with root package name */
        final Runnable f1142m;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, e.a.f8869p);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f1142m = new a();
            this.f1139j = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 < 600) {
                return (i10 < 640 || i11 < 480) ? 160 : 192;
            }
            return 192;
        }

        void b() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f1111v0.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void d() {
            if (this.f1141l) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1141l = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1139j <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1141l) {
                removeCallbacks(this.f1142m);
                post(this.f1142m);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f1140k.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1140k.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f1140k.hasFocus() && getVisibility() == 0) {
                this.f1141l = true;
                if (SearchView.M(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f1141l = false;
                removeCallbacks(this.f1142m);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f1141l = true;
                    return;
                }
                this.f1141l = false;
                removeCallbacks(this.f1142m);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f1140k = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f1139j = i10;
        }
    }

    /* loaded from: classes.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.Y(charSequence);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.a aVar = SearchView.this.W;
            if (aVar instanceof s0) {
                aVar.a(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.R;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.B();
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1137y) {
                searchView.V();
                return;
            }
            if (view == searchView.A) {
                searchView.R();
                return;
            }
            if (view == searchView.f1138z) {
                searchView.W();
            } else if (view == searchView.B) {
                searchView.a0();
            } else if (view == searchView.f1132u) {
                searchView.H();
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f1122k0 == null) {
                return false;
            }
            if (searchView.f1132u.isPopupShowing() && SearchView.this.f1132u.getListSelection() != -1) {
                return SearchView.this.X(view, i10, keyEvent);
            }
            if (SearchView.this.f1132u.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.f1132u.getText().toString());
            return true;
        }
    }

    /* loaded from: classes.dex */
    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.S(i10, 0, null);
        }
    }

    /* loaded from: classes.dex */
    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.T(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class k {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i10) {
            searchAutoComplete.setInputMethodMode(i10);
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface n {
        boolean a(int i10);

        boolean b(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        private Method f1154a;

        /* renamed from: b, reason: collision with root package name */
        private Method f1155b;

        /* renamed from: c, reason: collision with root package name */
        private Method f1156c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        o() {
            this.f1154a = null;
            this.f1155b = null;
            this.f1156c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1154a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1155b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1156c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1155b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1154a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1156c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class p extends y.a {
        public static final Parcelable.Creator<p> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        boolean f1157h;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator<p> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel) {
                return new p(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new p(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public p[] newArray(int i10) {
                return new p[i10];
            }
        }

        public p(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1157h = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        p(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1157h + "}";
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f1157h));
        }
    }

    /* loaded from: classes.dex */
    private static class q extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f1158a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f1159b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f1160c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f1161d;

        /* renamed from: e, reason: collision with root package name */
        private final int f1162e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f1163f;

        public q(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1162e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1159b = new Rect();
            this.f1161d = new Rect();
            this.f1160c = new Rect();
            a(rect, rect2);
            this.f1158a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1159b.set(rect);
            this.f1161d.set(rect);
            Rect rect3 = this.f1161d;
            int i10 = this.f1162e;
            rect3.inset(-i10, -i10);
            this.f1160c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            float f10;
            int i10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z11 = this.f1163f;
                    if (z11 && !this.f1161d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                } else {
                    if (action == 3) {
                        z11 = this.f1163f;
                        this.f1163f = false;
                    }
                    z10 = true;
                    z12 = false;
                }
                z12 = z11;
                z10 = true;
            } else {
                if (this.f1159b.contains(x10, y10)) {
                    this.f1163f = true;
                    z10 = true;
                }
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            if (!z10 || this.f1160c.contains(x10, y10)) {
                Rect rect = this.f1160c;
                f10 = x10 - rect.left;
                i10 = y10 - rect.top;
            } else {
                f10 = this.f1158a.getWidth() / 2;
                i10 = this.f1158a.getHeight() / 2;
            }
            motionEvent.setLocation(f10, i10);
            return this.f1158a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f1111v0 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.a.H);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.E = new Rect();
        this.F = new Rect();
        this.G = new int[2];
        this.H = new int[2];
        this.f1124m0 = new b();
        this.f1125n0 = new c();
        this.f1126o0 = new WeakHashMap<>();
        f fVar = new f();
        this.f1127p0 = fVar;
        this.f1128q0 = new g();
        h hVar = new h();
        this.f1129r0 = hVar;
        i iVar = new i();
        this.f1130s0 = iVar;
        j jVar = new j();
        this.f1131t0 = jVar;
        this.f1133u0 = new a();
        int[] iArr = e.j.Z1;
        y0 v10 = y0.v(context, attributeSet, iArr, i10, 0);
        androidx.core.view.a0.h0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        LayoutInflater.from(context).inflate(v10.n(e.j.f9040j2, e.g.f8973r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(e.f.D);
        this.f1132u = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1134v = findViewById(e.f.f8955z);
        View findViewById = findViewById(e.f.C);
        this.f1135w = findViewById;
        View findViewById2 = findViewById(e.f.J);
        this.f1136x = findViewById2;
        ImageView imageView = (ImageView) findViewById(e.f.f8953x);
        this.f1137y = imageView;
        ImageView imageView2 = (ImageView) findViewById(e.f.A);
        this.f1138z = imageView2;
        ImageView imageView3 = (ImageView) findViewById(e.f.f8954y);
        this.A = imageView3;
        ImageView imageView4 = (ImageView) findViewById(e.f.E);
        this.B = imageView4;
        ImageView imageView5 = (ImageView) findViewById(e.f.B);
        this.I = imageView5;
        androidx.core.view.a0.n0(findViewById, v10.g(e.j.f9045k2));
        androidx.core.view.a0.n0(findViewById2, v10.g(e.j.f9065o2));
        int i11 = e.j.f9060n2;
        imageView.setImageDrawable(v10.g(i11));
        imageView2.setImageDrawable(v10.g(e.j.f9030h2));
        imageView3.setImageDrawable(v10.g(e.j.f9015e2));
        imageView4.setImageDrawable(v10.g(e.j.f9075q2));
        imageView5.setImageDrawable(v10.g(i11));
        this.J = v10.g(e.j.f9055m2);
        b1.a(imageView, getResources().getString(e.h.f8987l));
        this.K = v10.n(e.j.f9070p2, e.g.f8972q);
        this.L = v10.n(e.j.f9020f2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f1133u0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f1128q0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(v10.a(e.j.f9035i2, true));
        int f10 = v10.f(e.j.f9000b2, -1);
        if (f10 != -1) {
            setMaxWidth(f10);
        }
        this.O = v10.p(e.j.f9025g2);
        this.f1113b0 = v10.p(e.j.f9050l2);
        int k10 = v10.k(e.j.f9010d2, -1);
        if (k10 != -1) {
            setImeOptions(k10);
        }
        int k11 = v10.k(e.j.f9005c2, -1);
        if (k11 != -1) {
            setInputType(k11);
        }
        setFocusable(v10.a(e.j.f8995a2, true));
        v10.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.M = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.N = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.C = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.U);
        g0();
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1119h0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1123l0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1122k0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i10, String str) {
        int i11;
        String o10;
        try {
            try {
                String o11 = s0.o(cursor, "suggest_intent_action");
                if (o11 == null) {
                    o11 = this.f1122k0.getSuggestIntentAction();
                }
                if (o11 == null) {
                    o11 = "android.intent.action.SEARCH";
                }
                String str2 = o11;
                String o12 = s0.o(cursor, "suggest_intent_data");
                if (o12 == null) {
                    o12 = this.f1122k0.getSuggestIntentData();
                }
                if (o12 != null && (o10 = s0.o(cursor, "suggest_intent_data_id")) != null) {
                    o12 = o12 + "/" + Uri.encode(o10);
                }
                return C(str2, o12 == null ? null : Uri.parse(o12), s0.o(cursor, "suggest_intent_extra_data"), s0.o(cursor, "suggest_intent_query"), i10, str);
            } catch (RuntimeException unused) {
                i11 = -1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Search suggestions cursor at row ");
                sb2.append(i11);
                sb2.append(" returned exception.");
                return null;
            }
        } catch (RuntimeException unused2) {
            i11 = cursor.getPosition();
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Search suggestions cursor at row ");
            sb22.append(i11);
            sb22.append(" returned exception.");
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1123l0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f1132u.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.G);
        getLocationInWindow(this.H);
        int[] iArr = this.G;
        int i10 = iArr[1];
        int[] iArr2 = this.H;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.U || this.J == null) {
            return charSequence;
        }
        int textSize = (int) (this.f1132u.getTextSize() * 1.25d);
        this.J.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.J), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.f1122k0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1122k0.getVoiceSearchLaunchWebSearch()) {
            intent = this.M;
        } else if (this.f1122k0.getVoiceSearchLaunchRecognizer()) {
            intent = this.N;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.f1112a0 || this.f1117f0) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed launch activity: ");
            sb2.append(intent);
        }
    }

    private boolean Q(int i10, int i11, String str) {
        Cursor b10 = this.W.b();
        if (b10 == null || !b10.moveToPosition(i10)) {
            return false;
        }
        O(D(b10, i11, str));
        return true;
    }

    private void b0() {
        post(this.f1124m0);
    }

    private void c0(int i10) {
        CharSequence c10;
        Editable text = this.f1132u.getText();
        Cursor b10 = this.W.b();
        if (b10 == null) {
            return;
        }
        if (!b10.moveToPosition(i10) || (c10 = this.W.c(b10)) == null) {
            setQuery(text);
        } else {
            setQuery(c10);
        }
    }

    private void e0() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1132u.getText());
        if (!z11 && (!this.U || this.f1120i0)) {
            z10 = false;
        }
        this.A.setVisibility(z10 ? 0 : 8);
        Drawable drawable = this.A.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1132u;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(e.d.f8895g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(e.d.f8896h);
    }

    private void h0() {
        this.f1132u.setThreshold(this.f1122k0.getSuggestThreshold());
        this.f1132u.setImeOptions(this.f1122k0.getImeOptions());
        int inputType = this.f1122k0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1122k0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1132u.setInputType(inputType);
        x.a aVar = this.W;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f1122k0.getSuggestAuthority() != null) {
            s0 s0Var = new s0(getContext(), this, this.f1122k0, this.f1126o0);
            this.W = s0Var;
            this.f1132u.setAdapter(s0Var);
            ((s0) this.W).x(this.f1114c0 ? 2 : 1);
        }
    }

    private void i0() {
        this.f1136x.setVisibility((N() && (this.f1138z.getVisibility() == 0 || this.B.getVisibility() == 0)) ? 0 : 8);
    }

    private void j0(boolean z10) {
        this.f1138z.setVisibility((this.f1112a0 && N() && hasFocus() && (z10 || !this.f1117f0)) ? 0 : 8);
    }

    private void k0(boolean z10) {
        this.V = z10;
        int i10 = z10 ? 0 : 8;
        boolean z11 = !TextUtils.isEmpty(this.f1132u.getText());
        this.f1137y.setVisibility(i10);
        j0(z11);
        this.f1134v.setVisibility(z10 ? 8 : 0);
        this.I.setVisibility((this.I.getDrawable() == null || this.U) ? 8 : 0);
        e0();
        l0(!z11);
        i0();
    }

    private void l0(boolean z10) {
        int i10 = 8;
        if (this.f1117f0 && !L() && z10) {
            this.f1138z.setVisibility(8);
            i10 = 0;
        }
        this.B.setVisibility(i10);
    }

    private void setQuery(CharSequence charSequence) {
        this.f1132u.setText(charSequence);
        this.f1132u.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.C.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1135w.getPaddingLeft();
            Rect rect = new Rect();
            boolean b10 = h1.b(this);
            int dimensionPixelSize = this.U ? resources.getDimensionPixelSize(e.d.f8893e) + resources.getDimensionPixelSize(e.d.f8894f) : 0;
            this.f1132u.getDropDownBackground().getPadding(rect);
            int i10 = rect.left;
            this.f1132u.setDropDownHorizontalOffset(b10 ? -i10 : paddingLeft - (i10 + dimensionPixelSize));
            this.f1132u.setDropDownWidth((((this.C.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.f1132u);
            return;
        }
        o oVar = f1111v0;
        oVar.b(this.f1132u);
        oVar.a(this.f1132u);
    }

    public boolean L() {
        return this.V;
    }

    void P(int i10, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i10, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.f1132u.getText())) {
            this.f1132u.setText("");
            this.f1132u.requestFocus();
            this.f1132u.setImeVisibility(true);
        } else if (this.U) {
            l lVar = this.Q;
            if (lVar == null || !lVar.a()) {
                clearFocus();
                k0(true);
            }
        }
    }

    boolean S(int i10, int i11, String str) {
        n nVar = this.S;
        if (nVar != null && nVar.b(i10)) {
            return false;
        }
        Q(i10, 0, null);
        this.f1132u.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i10) {
        n nVar = this.S;
        if (nVar != null && nVar.a(i10)) {
            return false;
        }
        c0(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.f1132u.requestFocus();
        this.f1132u.setImeVisibility(true);
        View.OnClickListener onClickListener = this.T;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.f1132u.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.P;
        if (mVar == null || !mVar.b(text.toString())) {
            if (this.f1122k0 != null) {
                P(0, null, text.toString());
            }
            this.f1132u.setImeVisibility(false);
            G();
        }
    }

    boolean X(View view, int i10, KeyEvent keyEvent) {
        if (this.f1122k0 != null && this.W != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return S(this.f1132u.getListSelection(), 0, null);
            }
            if (i10 == 21 || i10 == 22) {
                this.f1132u.setSelection(i10 == 21 ? 0 : this.f1132u.length());
                this.f1132u.setListSelection(0);
                this.f1132u.clearListSelection();
                this.f1132u.b();
                return true;
            }
            if (i10 == 19) {
                this.f1132u.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.f1132u.getText();
        this.f1119h0 = text;
        boolean z10 = !TextUtils.isEmpty(text);
        j0(z10);
        l0(!z10);
        e0();
        i0();
        if (this.P != null && !TextUtils.equals(charSequence, this.f1118g0)) {
            this.P.a(charSequence.toString());
        }
        this.f1118g0 = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.f1132u.hasFocus()) {
            H();
        }
    }

    void a0() {
        Intent E;
        SearchableInfo searchableInfo = this.f1122k0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                E = F(this.M, searchableInfo);
            } else if (!searchableInfo.getVoiceSearchLaunchRecognizer()) {
                return;
            } else {
                E = E(this.N, searchableInfo);
            }
            getContext().startActivity(E);
        } catch (ActivityNotFoundException unused) {
        }
    }

    @Override // androidx.appcompat.view.c
    public void c() {
        if (this.f1120i0) {
            return;
        }
        this.f1120i0 = true;
        int imeOptions = this.f1132u.getImeOptions();
        this.f1121j0 = imeOptions;
        this.f1132u.setImeOptions(imeOptions | 33554432);
        this.f1132u.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f1115d0 = true;
        super.clearFocus();
        this.f1132u.clearFocus();
        this.f1132u.setImeVisibility(false);
        this.f1115d0 = false;
    }

    public void d0(CharSequence charSequence, boolean z10) {
        this.f1132u.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1132u;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1119h0 = charSequence;
        }
        if (!z10 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    @Override // androidx.appcompat.view.c
    public void f() {
        d0("", false);
        clearFocus();
        k0(true);
        this.f1132u.setImeOptions(this.f1121j0);
        this.f1120i0 = false;
    }

    void f0() {
        int[] iArr = this.f1132u.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f1135w.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1136x.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f1132u.getImeOptions();
    }

    public int getInputType() {
        return this.f1132u.getInputType();
    }

    public int getMaxWidth() {
        return this.f1116e0;
    }

    public CharSequence getQuery() {
        return this.f1132u.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1113b0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1122k0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.O : getContext().getText(this.f1122k0.getHintId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.K;
    }

    public x.a getSuggestionsAdapter() {
        return this.W;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1124m0);
        post(this.f1125n0);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.k0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            I(this.f1132u, this.E);
            Rect rect = this.F;
            Rect rect2 = this.E;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            q qVar = this.D;
            if (qVar != null) {
                qVar.a(this.F, this.E);
                return;
            }
            q qVar2 = new q(this.F, this.E, this.f1132u);
            this.D = qVar2;
            setTouchDelegate(qVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r0 <= 0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    @Override // androidx.appcompat.widget.k0, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.L()
            if (r0 == 0) goto La
            super.onMeasure(r4, r5)
            return
        La:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2c
            if (r0 == 0) goto L22
            if (r0 == r2) goto L1d
            goto L39
        L1d:
            int r0 = r3.f1116e0
            if (r0 <= 0) goto L39
            goto L30
        L22:
            int r4 = r3.f1116e0
            if (r4 <= 0) goto L27
            goto L39
        L27:
            int r4 = r3.getPreferredWidth()
            goto L39
        L2c:
            int r0 = r3.f1116e0
            if (r0 <= 0) goto L31
        L30:
            goto L35
        L31:
            int r0 = r3.getPreferredWidth()
        L35:
            int r4 = java.lang.Math.min(r0, r4)
        L39:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L4b
            if (r0 == 0) goto L46
            goto L53
        L46:
            int r5 = r3.getPreferredHeight()
            goto L53
        L4b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L53:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p pVar = (p) parcelable;
        super.onRestoreInstanceState(pVar.a());
        k0(pVar.f1157h);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        p pVar = new p(super.onSaveInstanceState());
        pVar.f1157h = L();
        return pVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.f1115d0 || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i10, rect);
        }
        boolean requestFocus = this.f1132u.requestFocus(i10, rect);
        if (requestFocus) {
            k0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1123l0 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.U == z10) {
            return;
        }
        this.U = z10;
        k0(z10);
        g0();
    }

    public void setImeOptions(int i10) {
        this.f1132u.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f1132u.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.f1116e0 = i10;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.Q = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.R = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.P = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.T = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.S = nVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1113b0 = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.f1114c0 = z10;
        x.a aVar = this.W;
        if (aVar instanceof s0) {
            ((s0) aVar).x(z10 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1122k0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean K = K();
        this.f1117f0 = K;
        if (K) {
            this.f1132u.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.f1112a0 = z10;
        k0(L());
    }

    public void setSuggestionsAdapter(x.a aVar) {
        this.W = aVar;
        this.f1132u.setAdapter(aVar);
    }
}
