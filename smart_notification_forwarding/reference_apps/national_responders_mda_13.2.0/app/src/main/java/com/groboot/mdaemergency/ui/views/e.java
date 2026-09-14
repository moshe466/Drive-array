package com.groboot.mdaemergency.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.j;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.ui.views.d;
import com.groboot.mdaemergency.ui.views.f;
import il.org.mda.health.R;
import java.util.Iterator;
import w6.l0;

/* loaded from: classes.dex */
public class e extends androidx.fragment.app.e {
    i A0;
    boolean B0;
    KvTable C0;
    KvTable D0;
    KvTable E0;
    String F0 = "";
    String G0;
    boolean H0;
    boolean I0;
    String J0;
    KvTable K0;

    /* renamed from: u0, reason: collision with root package name */
    Context f8446u0;

    /* renamed from: v0, reason: collision with root package name */
    View f8447v0;

    /* renamed from: w0, reason: collision with root package name */
    EditText f8448w0;

    /* renamed from: x0, reason: collision with root package name */
    Button f8449x0;

    /* renamed from: y0, reason: collision with root package name */
    View f8450y0;

    /* renamed from: z0, reason: collision with root package name */
    ListAdapter f8451z0;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f8449x0.setVisibility(8);
            e.this.f8448w0.setVisibility(0);
            e.this.f8450y0.setVisibility(0);
            e.this.f8448w0.setFocusable(true);
            e.this.f8448w0.requestFocus();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f8448w0.getText().length() > 0) {
                e.this.f8448w0.setText("");
            } else {
                e.this.f8449x0.setVisibility(0);
                e.this.f8448w0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().equals(e.this.F0)) {
                return;
            }
            e.this.F0 = editable.toString().toLowerCase();
            e.this.t2();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements f.a {
        d() {
        }

        @Override // com.groboot.mdaemergency.ui.views.f.a
        public void a() {
            l0.g0();
        }

        @Override // com.groboot.mdaemergency.ui.views.f.a
        public void b(String str) {
            e.this.D0.getByKey(Kv.OTHER_KEY).value = str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onSave ");
            sb2.append(e.this.D0.toString());
            e.this.C0.getByKey(Kv.OTHER_KEY).value = str;
            e.this.A0.a(new Kv(Kv.OTHER_KEY, str), true);
            if (e.this.B0) {
                l0.g0();
                e.this.t2();
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.f.a
        public void c() {
            e.this.D0.getByKey(Kv.OTHER_KEY).value = Kv.OTHER_TEXT;
            e.this.C0.getByKey(Kv.OTHER_KEY).value = Kv.OTHER_TEXT;
            e.this.A0.a(new Kv(Kv.OTHER_KEY, Kv.OTHER_TEXT), false);
            if (e.this.B0) {
                l0.g0();
                e.this.t2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.groboot.mdaemergency.ui.views.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0135e implements View.OnClickListener {
        ViewOnClickListenerC0135e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                e.this.Z1().getWindow().setSoftInputMode(3);
                e.this.A0.c();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.Z1().getWindow().setSoftInputMode(3);
            e.this.A0.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements AdapterView.OnItemClickListener {
        g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            Kv kv = e.this.D0.get(i10);
            if (kv.key == -999) {
                e.this.k2(kv.value);
            } else {
                e.this.A0.a(kv, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements d.b {
        h() {
        }

        @Override // com.groboot.mdaemergency.ui.views.d.b
        public void a(Kv kv, boolean z10, int i10) {
            if (kv.key == -999) {
                e.this.k2(kv.value);
            } else {
                e.this.A0.a(kv, z10);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(Kv kv, boolean z10);

        void b();

        void c();
    }

    public e() {
    }

    public e(Context context, KvTable kvTable) {
        this.f8446u0 = context;
        this.K0 = kvTable;
    }

    @SuppressLint({"ValidFragment"})
    public e(Context context, SpinnerField spinnerField) {
        this.f8446u0 = context;
    }

    private ListAdapter m2() {
        return new com.groboot.mdaemergency.ui.views.c(this.f8446u0, this.D0, "", this.I0, null);
    }

    private boolean[] n2() {
        KvTable kvTable = this.D0;
        if (kvTable == null) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[kvTable.size()];
        KvTable kvTable2 = this.K0;
        if (kvTable2 != null && kvTable2.size() != 0) {
            Iterator<Kv> it = this.K0.iterator();
            while (it.hasNext()) {
                int indexOf = this.D0.indexOf(it.next());
                if (indexOf > -1) {
                    zArr[indexOf] = true;
                }
            }
        }
        return zArr;
    }

    private ListAdapter o2() {
        return new com.groboot.mdaemergency.ui.views.d(this.f8446u0, this.D0, n2(), this.I0, new h());
    }

    public static boolean p2(Kv kv) {
        int i10;
        return (kv == null || (i10 = kv.key) >= -1 || i10 == -999) ? false : true;
    }

    private AdapterView.OnItemClickListener q2() {
        return new g();
    }

    private View.OnClickListener r2() {
        return new f();
    }

    private View.OnClickListener s2() {
        return new ViewOnClickListenerC0135e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        String str;
        Kv byKey;
        this.D0 = this.C0;
        if (this.H0 && (str = this.F0) != null && str.length() > 0) {
            this.D0 = new KvTable();
            Iterator<Kv> it = this.C0.iterator();
            while (it.hasNext()) {
                Kv next = it.next();
                if (!p2(next)) {
                    if (next.value.toLowerCase().indexOf(this.F0) < 0) {
                        if (this.I0) {
                            if ((next.key + "").indexOf(this.F0) >= 0) {
                            }
                        }
                    }
                    this.D0.add((KvTable) next);
                }
            }
            KvTable kvTable = this.E0;
            if (kvTable != null) {
                Iterator<Kv> it2 = kvTable.iterator();
                while (it2.hasNext()) {
                    Kv next2 = it2.next();
                    if (next2.value.toLowerCase().indexOf(this.F0) >= 0 && !this.D0.contains(next2.key) && (byKey = this.C0.getByKey(next2.key)) != null) {
                        this.D0.add((KvTable) byKey);
                    }
                }
            }
        }
        if (this.B0) {
            this.f8451z0 = o2();
        } else {
            this.f8451z0 = m2();
            ((ListView) l2(R.id.lv_data)).setOnItemClickListener(q2());
        }
        ((ListView) l2(R.id.lv_data)).setAdapter(this.f8451z0);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8447v0 = layoutInflater.inflate(R.layout.spinner_dialog, viewGroup);
        Z1().getWindow().requestFeature(1);
        this.f8448w0 = (EditText) l2(R.id.et_search);
        l2(R.id.ll_search).setVisibility(this.H0 ? 0 : 8);
        this.f8448w0.setHint(this.J0);
        ((Button) l2(R.id.btn_clear)).setText("נקה בחירה");
        l2(R.id.btn_clear).setOnClickListener(r2());
        if (this.B0) {
            ((Button) l2(R.id.btn_ok)).setText("אישור");
        } else {
            ((Button) l2(R.id.btn_ok)).setText(R.string.cancel);
        }
        l2(R.id.btn_ok).setOnClickListener(s2());
        Button button = (Button) l2(R.id.btn_search);
        this.f8449x0 = button;
        button.setOnClickListener(new a());
        View l22 = l2(R.id.btn_close);
        this.f8450y0 = l22;
        l22.setOnClickListener(new b());
        this.f8448w0.addTextChangedListener(new c());
        t2();
        this.f8448w0.setVisibility(8);
        this.f8450y0.setVisibility(8);
        this.f8449x0.setVisibility(0);
        return this.f8447v0;
    }

    public void k2(String str) {
        String str2;
        if (this.G0.length() > 0) {
            str2 = this.G0 + " - אחר";
        } else {
            str2 = "";
        }
        com.groboot.mdaemergency.ui.views.f.j2(t(), str, str2, new d());
    }

    public View l2(int i10) {
        return this.f8447v0.findViewById(i10);
    }

    public void u2() {
        try {
            super.i2(((j) this.f8446u0).d0(), "123");
        } catch (Exception unused) {
            l0.L0(l0.v(), "בשלב זה, SpinnerField נתמך רק תחת FragmentActivity", true);
        }
    }

    public void v2(boolean z10, KvTable kvTable, KvTable kvTable2, String str, boolean z11, boolean z12, boolean z13, String str2, i iVar) {
        this.B0 = z10;
        this.C0 = kvTable;
        this.E0 = kvTable2;
        this.G0 = str;
        this.H0 = z11;
        this.I0 = z12;
        this.J0 = str2;
        this.A0 = iVar;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("show ");
        sb2.append(kvTable.toString());
        u2();
    }
}
