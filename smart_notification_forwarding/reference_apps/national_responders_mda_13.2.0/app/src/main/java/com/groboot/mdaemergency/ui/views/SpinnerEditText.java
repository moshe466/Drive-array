package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.ui.views.e;

/* loaded from: classes.dex */
public class SpinnerEditText extends EditText {

    /* renamed from: f, reason: collision with root package name */
    Context f8348f;

    /* renamed from: g, reason: collision with root package name */
    private KvTable f8349g;

    /* renamed from: h, reason: collision with root package name */
    com.groboot.mdaemergency.ui.views.e f8350h;

    /* renamed from: i, reason: collision with root package name */
    boolean f8351i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8352j;

    /* renamed from: k, reason: collision with root package name */
    private KvTable f8353k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8354l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8355m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8356n;

    /* renamed from: o, reason: collision with root package name */
    private KvTable f8357o;

    /* renamed from: p, reason: collision with root package name */
    private Kv f8358p;

    /* renamed from: q, reason: collision with root package name */
    private e f8359q;

    /* renamed from: r, reason: collision with root package name */
    private int f8360r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8361s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8362t;

    /* renamed from: u, reason: collision with root package name */
    c f8363u;

    /* renamed from: v, reason: collision with root package name */
    String f8364v;

    /* renamed from: w, reason: collision with root package name */
    String f8365w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SpinnerEditText.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8367a;

        static {
            int[] iArr = new int[c.values().length];
            f8367a = iArr;
            try {
                iArr[c.regular.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8367a[c.counting.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8367a[c.getCountingMoreThenOne.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        regular,
        counting,
        getCountingMoreThenOne
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements e.i {
        private d() {
        }

        /* synthetic */ d(SpinnerEditText spinnerEditText, a aVar) {
            this();
        }

        @Override // com.groboot.mdaemergency.ui.views.e.i
        public void a(Kv kv, boolean z10) {
            if (!SpinnerEditText.this.f8352j) {
                SpinnerEditText.this.h(kv, true);
                SpinnerEditText.this.f8350h.W1();
            } else {
                SpinnerEditText.this.k(kv, z10);
                if (SpinnerEditText.this.f8359q != null) {
                    SpinnerEditText.this.f8359q.a(kv, SpinnerEditText.this);
                }
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.e.i
        public void b() {
            SpinnerEditText.this.setEmptyValue(true);
            SpinnerEditText.this.f8350h.W1();
        }

        @Override // com.groboot.mdaemergency.ui.views.e.i
        public void c() {
            if (SpinnerEditText.this.f8352j && SpinnerEditText.this.f8359q != null) {
                SpinnerEditText.this.f8359q.c(SpinnerEditText.this.f8357o, SpinnerEditText.this);
            }
            SpinnerEditText.this.f8350h.W1();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(Kv kv, SpinnerEditText spinnerEditText);

        void c(KvTable kvTable, SpinnerEditText spinnerEditText);
    }

    public SpinnerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8351i = true;
        this.f8354l = false;
        this.f8355m = false;
        this.f8361s = false;
        this.f8362t = true;
        this.f8363u = c.regular;
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, g5.i.f9849e, 0, 0);
            try {
                this.f8356n = obtainStyledAttributes.getBoolean(2, true);
                this.f8352j = obtainStyledAttributes.getBoolean(1, false);
                this.f8354l = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } catch (Exception unused) {
        }
        f(context);
    }

    private void f(Context context) {
        this.f8348f = context;
        setKeyListener(null);
        this.f8358p = new Kv();
        new Kv();
        this.f8357o = new KvTable();
        setSelectAllOnFocus(true);
        setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Kv kv, boolean z10) {
        e eVar;
        if (this.f8352j) {
            setEmptyValue(false);
            k(kv, true);
            e eVar2 = this.f8359q;
            if (eVar2 != null) {
                eVar2.a(kv, this);
                return;
            }
            return;
        }
        this.f8358p = kv.mo1clone();
        l();
        if (!z10 || (eVar = this.f8359q) == null) {
            return;
        }
        eVar.a(this.f8358p, this);
    }

    private void i(KvTable kvTable, boolean z10) {
        e eVar;
        this.f8357o = kvTable;
        l();
        if (!z10 || (eVar = this.f8359q) == null) {
            return;
        }
        eVar.c(this.f8357o, this);
    }

    private void setTextM(String str) {
        setText(str);
    }

    public boolean e() {
        if (this.f8352j) {
            return this.f8357o.hasValue();
        }
        Kv kv = this.f8358p;
        return kv != null && kv.hasValue();
    }

    public void g() {
        if (this.f8361s) {
            setFocusable(true);
            requestFocus();
        }
        KvTable kvTable = this.f8349g;
        if (kvTable == null || kvTable.size() == 0) {
            return;
        }
        com.groboot.mdaemergency.ui.views.e eVar = new com.groboot.mdaemergency.ui.views.e(this.f8348f, getSelectedValues());
        this.f8350h = eVar;
        eVar.f2(this.f8351i);
        this.f8350h.v2(this.f8352j, this.f8349g, this.f8353k, "", this.f8354l, this.f8355m, this.f8356n, "חיפוש", new d(this, null));
    }

    public Kv getSelectedValue() {
        return this.f8358p;
    }

    public KvTable getSelectedValues() {
        return this.f8357o;
    }

    public void j(KvTable kvTable, Kv kv) {
        this.f8349g = kvTable;
        this.f8360r = kv.key;
        this.f8358p = kv;
    }

    public void k(Kv kv, boolean z10) {
        if (z10) {
            if (this.f8357o.contains(kv)) {
                return;
            } else {
                this.f8357o.add((KvTable) kv.mo1clone());
            }
        } else if (!this.f8357o.contains(kv)) {
            return;
        } else {
            this.f8357o.remove(kv);
        }
        i(this.f8357o, false);
    }

    public void l() {
        String kvTable;
        String str = "";
        if (this.f8352j) {
            int i10 = b.f8367a[this.f8363u.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return;
                    }
                    if (this.f8357o.size() > 1) {
                        kvTable = String.format(this.f8364v, Integer.valueOf(this.f8357o.size()));
                    }
                } else if (this.f8357o.size() != 0) {
                    kvTable = this.f8357o.size() == 1 ? this.f8365w : String.format(this.f8364v, Integer.valueOf(this.f8357o.size()));
                }
                setTextM(kvTable);
                return;
            }
            kvTable = this.f8357o.toString();
            setTextM(kvTable);
            return;
        }
        Kv kv = this.f8358p;
        if (kv != null) {
            str = kv.value;
        }
        setTextM(str);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setClickable(true);
        setLongClickable(false);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10 && this.f8362t) {
            g();
        }
    }

    public void setEmptyValue(boolean z10) {
        if (this.f8352j) {
            i(new KvTable(), z10);
        } else {
            h(new Kv(), z10);
        }
    }

    public void setKVTableDataSource(KvTable kvTable) {
        Kv byKey;
        Kv kv = new Kv();
        KvTable kvTable2 = new KvTable();
        if (this.f8352j) {
            kvTable2 = getSelectedValues();
        } else {
            kv = getSelectedValue();
        }
        setEmptyValue(false);
        if (kvTable == null) {
            kvTable = new KvTable();
            byKey = new Kv();
        } else {
            byKey = kvTable.getByKey(this.f8360r);
        }
        j(kvTable, byKey);
        if (this.f8352j) {
            i(kvTable2, false);
        } else {
            h(kv, false);
        }
    }

    public void setOnValueSelected(e eVar) {
        this.f8359q = eVar;
    }

    public void setSelectedValue(int i10) {
        KvTable kvTable = this.f8349g;
        if (kvTable == null) {
            return;
        }
        Kv byKey = kvTable.getByKey(i10);
        if (byKey == null || !byKey.hasValue()) {
            setEmptyValue(false);
        } else {
            h(byKey, true);
        }
    }

    public void setSelectedValue(Kv kv) {
        if (kv == null) {
            kv = new Kv();
        }
        h(kv, true);
    }

    public void setSelectedValue(String str) {
        Kv firstByValue;
        KvTable kvTable = this.f8349g;
        if (kvTable == null || (firstByValue = kvTable.getFirstByValue(str)) == null || !firstByValue.hasValue()) {
            return;
        }
        h(firstByValue, true);
    }

    public void setSelectedValues(KvTable kvTable) {
        if (kvTable == null) {
            kvTable = new KvTable();
        }
        i(kvTable, false);
    }
}
