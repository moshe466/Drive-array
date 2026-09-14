package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.ui.views.e;
import il.org.mda.health.R;
import w6.l0;

/* loaded from: classes.dex */
public class SpinnerField extends LinearLayout {
    boolean A;
    c B;
    String C;
    String D;

    /* renamed from: f, reason: collision with root package name */
    Context f8369f;

    /* renamed from: g, reason: collision with root package name */
    private String f8370g;

    /* renamed from: h, reason: collision with root package name */
    private String f8371h;

    /* renamed from: i, reason: collision with root package name */
    private int f8372i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f8373j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f8374k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f8375l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f8376m;

    /* renamed from: n, reason: collision with root package name */
    private KvTable f8377n;

    /* renamed from: o, reason: collision with root package name */
    private KvTable f8378o;

    /* renamed from: p, reason: collision with root package name */
    private Kv f8379p;

    /* renamed from: q, reason: collision with root package name */
    private KvTable f8380q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8381r;

    /* renamed from: s, reason: collision with root package name */
    private e f8382s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8383t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8384u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f8385v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8386w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8387x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8388y;

    /* renamed from: z, reason: collision with root package name */
    com.groboot.mdaemergency.ui.views.e f8389z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SpinnerField.this.f8385v) {
                SpinnerField.this.setFocusable(true);
                SpinnerField.this.requestFocus();
            }
            SpinnerField.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8391a;

        static {
            int[] iArr = new int[c.values().length];
            f8391a = iArr;
            try {
                iArr[c.regular.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8391a[c.counting.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8391a[c.getCountingMoreThenOne.ordinal()] = 3;
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

        /* synthetic */ d(SpinnerField spinnerField, a aVar) {
            this();
        }

        @Override // com.groboot.mdaemergency.ui.views.e.i
        public void a(Kv kv, boolean z10) {
            if (SpinnerField.this.f8383t) {
                SpinnerField.this.k(kv, z10);
                if (SpinnerField.this.f8382s != null) {
                    SpinnerField.this.f8382s.b(kv, SpinnerField.this);
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCheckedChange ");
            sb2.append(kv.value);
            SpinnerField.this.h(kv, true);
            SpinnerField.this.f8389z.W1();
        }

        @Override // com.groboot.mdaemergency.ui.views.e.i
        public void b() {
            SpinnerField.this.setEmptyValue(true);
            SpinnerField.this.f8389z.W1();
        }

        @Override // com.groboot.mdaemergency.ui.views.e.i
        public void c() {
            if (SpinnerField.this.f8383t && SpinnerField.this.f8382s != null) {
                SpinnerField.this.f8382s.a(SpinnerField.this.f8380q, SpinnerField.this);
            }
            SpinnerField.this.f8389z.W1();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(KvTable kvTable, SpinnerField spinnerField);

        void b(Kv kv, SpinnerField spinnerField);
    }

    public SpinnerField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8370g = "";
        this.f8371h = "";
        this.f8381r = false;
        this.f8385v = false;
        this.f8386w = false;
        this.f8387x = true;
        this.f8388y = true;
        this.A = true;
        this.B = c.regular;
        this.f8369f = context;
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, g5.i.f9850f, 0, 0);
            this.f8379p = new Kv();
            new Kv();
            this.f8380q = new KvTable();
            try {
                this.f8372i = obtainStyledAttributes.getInt(1, -1);
                this.f8370g = obtainStyledAttributes.getString(5);
                this.f8371h = obtainStyledAttributes.getString(2);
                this.f8384u = obtainStyledAttributes.getBoolean(9, true);
                this.f8383t = obtainStyledAttributes.getBoolean(7, false);
                this.f8381r = obtainStyledAttributes.getBoolean(0, false);
                this.f8386w = obtainStyledAttributes.getBoolean(10, false);
                this.f8387x = obtainStyledAttributes.getBoolean(8, false);
                this.f8388y = obtainStyledAttributes.getBoolean(4, false);
                if (this.f8370g == null) {
                    this.f8370g = "";
                }
                if (this.f8371h == null) {
                    this.f8371h = "";
                }
                obtainStyledAttributes.recycle();
                LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(context, R.layout.b_spinner_field, null);
                this.f8373j = linearLayout;
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                addView(this.f8373j);
                this.f8374k = (TextView) findViewById(R.id.textView);
                this.f8375l = (TextView) findViewById(R.id.tv_description);
                ImageView imageView = (ImageView) findViewById(R.id.spinner_arrow);
                this.f8376m = imageView;
                if (!this.f8387x) {
                    imageView.setVisibility(8);
                }
                if (!this.f8388y) {
                    this.f8374k.setVisibility(4);
                }
                setDescription(this.f8371h);
                if (isInEditMode()) {
                    return;
                }
                setEmptyValue(false);
                setOnClickListener(new a());
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } catch (Exception e10) {
            TextView textView = this.f8374k;
            if (textView != null) {
                textView.setText(e10.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Kv kv, boolean z10) {
        e eVar;
        Kv byKey;
        String str;
        if (this.f8383t) {
            setEmptyValue(false);
            k(kv, true);
            e eVar2 = this.f8382s;
            if (eVar2 != null) {
                eVar2.b(kv, this);
                return;
            }
            return;
        }
        KvTable kvTable = this.f8377n;
        if (kvTable != null && kvTable.hasValue()) {
            if (kv.key == -999) {
                byKey = this.f8377n.getByKey(Kv.OTHER_KEY);
                str = kv.value;
            } else if (this.f8377n.contains(Kv.OTHER_KEY)) {
                byKey = this.f8377n.getByKey(Kv.OTHER_KEY);
                str = Kv.OTHER_TEXT;
            }
            byKey.value = str;
        }
        this.f8379p = kv.mo1clone();
        l();
        if (!z10 || (eVar = this.f8382s) == null) {
            return;
        }
        eVar.b(this.f8379p, this);
    }

    private void i(KvTable kvTable, boolean z10) {
        e eVar;
        Kv byKey;
        String str;
        this.f8380q = kvTable;
        KvTable kvTable2 = this.f8377n;
        if (kvTable2 != null && kvTable2.hasValue()) {
            if (this.f8380q.contains(Kv.OTHER_KEY) && this.f8377n.contains(Kv.OTHER_KEY)) {
                byKey = this.f8377n.getByKey(Kv.OTHER_KEY);
                str = this.f8380q.getByKey(Kv.OTHER_KEY).value;
            } else if (this.f8377n.contains(Kv.OTHER_KEY)) {
                byKey = this.f8377n.getByKey(Kv.OTHER_KEY);
                str = Kv.OTHER_TEXT;
            }
            byKey.value = str;
        }
        l();
        if (!z10 || (eVar = this.f8382s) == null) {
            return;
        }
        eVar.a(this.f8380q, this);
    }

    private void setTextM(String str) {
        TextView textView;
        Resources resources;
        int i10;
        this.f8374k.setText(str);
        if (l0.l0(this.f8370g)) {
            return;
        }
        if (f()) {
            textView = this.f8374k;
            resources = getResources();
            i10 = R.color.grayDark;
        } else {
            this.f8374k.setText(this.f8370g);
            textView = this.f8374k;
            resources = getResources();
            i10 = R.color.gray_light;
        }
        textView.setTextColor(resources.getColor(i10));
    }

    public boolean f() {
        if (this.f8383t) {
            return this.f8380q.hasValue();
        }
        Kv kv = this.f8379p;
        return kv != null && kv.hasValue();
    }

    public void g() {
        KvTable kvTable = this.f8377n;
        if (kvTable == null || kvTable.size() == 0) {
            return;
        }
        com.groboot.mdaemergency.ui.views.e eVar = this.f8389z;
        if (eVar == null || !eVar.t0()) {
            com.groboot.mdaemergency.ui.views.e eVar2 = new com.groboot.mdaemergency.ui.views.e(this.f8369f, this);
            this.f8389z = eVar2;
            eVar2.f2(this.A);
            this.f8389z.v2(this.f8383t, this.f8377n, this.f8378o, "", this.f8381r, this.f8386w, this.f8384u, "חיפוש", new d(this, null));
        }
    }

    public KvTable getDataSource() {
        return this.f8377n;
    }

    public String getDescription() {
        return this.f8375l.getText().toString();
    }

    public boolean getIsMultiChoice() {
        return this.f8383t;
    }

    public Kv getSelectedValue() {
        return this.f8379p;
    }

    public KvTable getSelectedValues() {
        return this.f8380q;
    }

    public void j(KvTable kvTable, Kv kv) {
        this.f8377n = kvTable.clone();
        this.f8372i = kv.key;
        this.f8379p = kv;
    }

    public void k(Kv kv, boolean z10) {
        if (z10) {
            if (this.f8380q.contains(kv)) {
                this.f8380q.removeByKey(kv.key);
            }
            this.f8380q.add((KvTable) kv.mo1clone());
        } else {
            this.f8380q.removeByKey(kv.key);
        }
        i(this.f8380q, false);
    }

    public void l() {
        String kvTable;
        String str = "";
        if (this.f8383t) {
            int i10 = b.f8391a[this.B.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return;
                    }
                    if (this.f8380q.size() > 1) {
                        kvTable = String.format(this.C, Integer.valueOf(this.f8380q.size()));
                    }
                } else if (this.f8380q.size() != 0) {
                    kvTable = this.f8380q.size() == 1 ? this.D : String.format(this.C, Integer.valueOf(this.f8380q.size()));
                }
                setTextM(kvTable);
                return;
            }
            kvTable = this.f8380q.toString();
            setTextM(kvTable);
            return;
        }
        Kv kv = this.f8379p;
        if (kv != null) {
            str = kv.value;
        }
        setTextM(str);
    }

    public void setDescription(String str) {
        this.f8375l.setText(str);
        this.f8375l.setVisibility((str == null || str.length() <= 0) ? 8 : 0);
    }

    public void setDialogCancelable(boolean z10) {
        this.A = z10;
    }

    public void setEmptyValue(boolean z10) {
        if (this.f8383t) {
            i(new KvTable(), z10);
        } else {
            h(new Kv(), z10);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        this.f8374k.setEnabled(z10);
        this.f8375l.setEnabled(z10);
        this.f8373j.setEnabled(z10);
        super.setEnabled(z10);
    }

    public void setIsMultiChoice(boolean z10) {
        this.f8383t = z10;
        l();
    }

    public void setKVTableDataSource(KvTable kvTable) {
        Kv byKey;
        Kv kv = new Kv();
        KvTable kvTable2 = new KvTable();
        if (this.f8383t) {
            kvTable2 = getSelectedValues();
        } else {
            kv = getSelectedValue();
        }
        setEmptyValue(false);
        if (kvTable == null) {
            kvTable = new KvTable();
            byKey = new Kv();
        } else {
            byKey = kvTable.getByKey(this.f8372i);
        }
        j(kvTable, byKey);
        if (this.f8383t) {
            i(kvTable2, false);
        } else {
            h(kv, false);
        }
    }

    public void setOnValueSelected(e eVar) {
        this.f8382s = eVar;
    }

    public void setSearchValues(KvTable kvTable) {
        this.f8378o = kvTable;
    }

    public void setSearchVisible(boolean z10) {
        this.f8381r = z10;
    }

    public void setSelectedValue(int i10) {
        Kv byKey;
        KvTable kvTable = this.f8377n;
        if (kvTable == null || (byKey = kvTable.getByKey(i10)) == null || !byKey.hasValue()) {
            return;
        }
        h(byKey, true);
    }

    public void setSelectedValue(Kv kv) {
        if (kv == null) {
            kv = new Kv();
        }
        h(kv, true);
    }

    public void setSelectedValue(String str) {
        Kv firstByValue;
        KvTable kvTable = this.f8377n;
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
