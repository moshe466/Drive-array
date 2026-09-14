package f6;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.EvacuationSites;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.models.PackageBarcodesData;
import com.groboot.mdaemergency.models.TestsSite;
import com.groboot.mdaemergency.ui.views.c;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class b extends a6.a implements c.a {
    GridView A0;
    TextView B0;
    EditText C0;
    Kv D0;
    Kv E0;
    Kv F0;
    Kv G0;
    KvTable H0;
    KvTable I0;
    EvacuationSites J0;
    Boolean K0;
    PackageBarcodesData L0;
    Hashtable<Integer, Integer> M0;
    Boolean N0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            b bVar = b.this;
            if (bVar.D0 == null || bVar.E0 == null) {
                return;
            }
            if (!bVar.N0.booleanValue()) {
                b.this.w2();
            }
            b.this.N0 = Boolean.FALSE;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f6.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0158b extends com.google.common.reflect.b<Hashtable<Integer, Integer>> {
        C0158b(b bVar) {
        }
    }

    public b() {
        this.M0 = new Hashtable<>();
        this.N0 = Boolean.FALSE;
    }

    public b(EvacuationSites evacuationSites) {
        this.M0 = new Hashtable<>();
        this.N0 = Boolean.FALSE;
        this.J0 = evacuationSites;
        this.K0 = Boolean.TRUE;
    }

    public b(PackageBarcodesData packageBarcodesData) {
        this.M0 = new Hashtable<>();
        Boolean bool = Boolean.FALSE;
        this.N0 = bool;
        this.J0 = new EvacuationSites(packageBarcodesData.getEvacuationSites());
        this.L0 = packageBarcodesData;
        this.K0 = bool;
    }

    private void r2() {
        if (this.K0.booleanValue()) {
            com.groboot.mdaemergency.async.d.v().m(new b.InterfaceC0098b() { // from class: f6.a
                @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                public final void a(b.a aVar) {
                    b.this.x2(aVar);
                }
            });
        }
    }

    private List<TestsSite> s2(KvTable kvTable) {
        ArrayList arrayList = new ArrayList();
        Iterator<Kv> it = kvTable.iterator();
        while (it.hasNext()) {
            Kv next = it.next();
            arrayList.add(new TestsSite(next, this.M0.containsKey(Integer.valueOf(next.key)) ? this.M0.get(Integer.valueOf(next.key)).intValue() : 0));
        }
        return arrayList;
    }

    private void t2(KvTable kvTable, String str) {
        u2(kvTable, str, Boolean.TRUE);
    }

    private void u2(KvTable kvTable, String str, Boolean bool) {
        com.groboot.mdaemergency.ui.views.c cVar = new com.groboot.mdaemergency.ui.views.c(A(), kvTable, str, false, this);
        cVar.a(bool.booleanValue());
        this.A0.setAdapter((ListAdapter) cVar);
    }

    private void v2(List<TestsSite> list, String str) {
        this.A0.setAdapter((ListAdapter) new c6.f(A(), list, str, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2() {
        if (this.C0.length() < 2) {
            u2(this.H0, "", Boolean.FALSE);
            return;
        }
        String obj = this.C0.getText().toString();
        KvTable kvTable = new KvTable();
        Iterator<Kv> it = this.H0.iterator();
        while (it.hasNext()) {
            Kv next = it.next();
            if (next.value.indexOf(obj) > -1) {
                kvTable.add((KvTable) next);
            }
        }
        u2(kvTable, obj, Boolean.FALSE);
        v2(s2(kvTable), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(b.a aVar) {
        if (aVar.f7614b) {
            this.M0 = (Hashtable) new com.google.gson.e().j(aVar.e("Content"), new C0158b(this).b());
        }
    }

    private TextWatcher y2() {
        return new a();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.G0 = null;
        this.F0 = null;
        this.E0 = null;
        this.D0 = null;
        r2();
        z2();
    }

    @Override // com.groboot.mdaemergency.ui.views.c.a
    public void h(Kv kv) {
        if (this.K0.booleanValue()) {
            if (this.D0 != null) {
                if (this.E0 == null) {
                    this.E0 = kv;
                } else if (this.F0 == null) {
                    this.F0 = kv;
                }
                z2();
                return;
            }
            this.D0 = kv;
            KvTable filter = this.J0.SiteTypes.filter(kv);
            this.I0 = filter;
            if (filter.size() == 1) {
                this.E0 = this.I0.get(0);
            }
            z2();
            return;
        }
        if (this.G0 == null) {
            this.G0 = kv;
            o(this.K0.booleanValue() ? new u1(this.F0, this.G0) : new u1(this.L0.getBarcodes(), this.G0), true);
        }
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_choose_site);
        a("אתר בדיקות");
        this.A0 = (GridView) k2(R.id.gv_items);
        this.B0 = (TextView) k2(R.id.tv_title);
        EditText editText = (EditText) k2(R.id.et_search);
        this.C0 = editText;
        editText.addTextChangedListener(y2());
    }

    @Override // a6.a
    public void o2() {
    }

    protected void z2() {
        TextView textView;
        StringBuilder sb2;
        if (this.K0.booleanValue()) {
            if (this.D0 == null) {
                this.C0.setVisibility(8);
                this.B0.setText("אנא בחר קטגוריה");
                t2(w6.l0.f0(this.J0.SiteCategories), "");
                return;
            }
            if (this.E0 == null) {
                this.C0.setVisibility(8);
                this.B0.setText("אנא בחר סוג אתר");
                t2(this.J0.SiteTypes.filter(this.D0), "");
                return;
            }
            if (this.F0 == null) {
                if (this.I0.size() > 1) {
                    textView = this.B0;
                    sb2 = new StringBuilder();
                    sb2.append(w6.l0.N("קטגוריה: "));
                    sb2.append(this.D0.value);
                    sb2.append(" ");
                } else {
                    textView = this.B0;
                    sb2 = new StringBuilder();
                }
                sb2.append(w6.l0.N("סוג אתר: "));
                sb2.append(this.E0.value);
                sb2.append(" ");
                textView.setText(Html.fromHtml(sb2.toString()));
                KvTable filter = this.J0.Sites.filter(this.E0.key);
                this.H0 = filter;
                List<TestsSite> s22 = s2(filter);
                if (s22.size() == 0) {
                    w6.l0.M0("לא מוגדרים אתרים מהסוג הזה");
                    this.E0 = null;
                    this.D0 = null;
                    z2();
                    return;
                }
                this.C0.setVisibility(0);
                this.C0.setText("");
                this.N0 = Boolean.TRUE;
                v2(s22, "");
                return;
            }
        }
        if (this.G0 == null) {
            this.C0.setVisibility(8);
            this.B0.setText("אנא בחר מעבדה מקבלת");
            u2(w6.l0.f0(this.J0.EvacuationSites), "", Boolean.TRUE);
        }
    }
}
