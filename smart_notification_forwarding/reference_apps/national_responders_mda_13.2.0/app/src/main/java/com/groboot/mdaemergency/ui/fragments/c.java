package com.groboot.mdaemergency.ui.fragments;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.Answer;
import com.groboot.mdaemergency.models.InfectiousDiseaseReportData;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.models.PackageBarcodesData;
import com.groboot.mdaemergency.models.SampleMovementReport;
import com.groboot.mdaemergency.ui.views.DateField;
import com.groboot.mdaemergency.ui.views.SpinnerField;
import g5.h;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l8.w;
import m8.q;
import org.json.JSONException;
import w6.l0;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class c extends a6.a {
    public Map<Integer, View> A0 = new LinkedHashMap();
    private EnumC0127c B0 = EnumC0127c.Movement;
    private ArrayList<SampleMovementReport> C0 = new ArrayList<>();
    private final e D0 = new e();
    private final View.OnClickListener E0 = new View.OnClickListener() { // from class: f6.l1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.groboot.mdaemergency.ui.fragments.c.K2(com.groboot.mdaemergency.ui.fragments.c.this, view);
        }
    };
    private final View.OnClickListener F0 = new View.OnClickListener() { // from class: f6.k1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.groboot.mdaemergency.ui.fragments.c.L2(com.groboot.mdaemergency.ui.fragments.c.this, view);
        }
    };
    private final DateField.d G0;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f8147a;

        /* renamed from: b, reason: collision with root package name */
        private final String f8148b;

        public a(String str, String str2) {
            k.e(str, "filed1");
            k.e(str2, "filed2");
            this.f8147a = str;
            this.f8148b = str2;
        }

        public final String a() {
            return this.f8147a;
        }

        public final String b() {
            return this.f8148b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends l implements x8.l<SampleMovementReport, w> {
        b() {
            super(1);
        }

        public final void a(SampleMovementReport sampleMovementReport) {
            k.e(sampleMovementReport, "sampleMovement");
            if (sampleMovementReport.getPackageUID() != null) {
                c.this.H2(sampleMovementReport);
            }
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ w h(SampleMovementReport sampleMovementReport) {
            a(sampleMovementReport);
            return w.f11824a;
        }
    }

    /* renamed from: com.groboot.mdaemergency.ui.fragments.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0127c {
        Movement(1, new a("משנע", "מעבדה מקבלת")),
        Laboratory(2, new a("תאריך", "מעבדה מקבלת")),
        Refrigerator(3, new a("תאריך", "מקרר"));

        private final a titles;
        private final int value;

        EnumC0127c(int i10, a aVar) {
            this.value = i10;
            this.titles = aVar;
        }

        public final a getTitles() {
            return this.titles;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends com.google.common.reflect.b<List<? extends SampleMovementReport>> {
        d() {
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements SpinnerField.e {
        e() {
        }

        @Override // com.groboot.mdaemergency.ui.views.SpinnerField.e
        public void a(KvTable kvTable, SpinnerField spinnerField) {
        }

        @Override // com.groboot.mdaemergency.ui.views.SpinnerField.e
        public void b(Kv kv, SpinnerField spinnerField) {
            k.e(kv, "value");
            k.e(spinnerField, "spinnerField");
            if (kv.key == -1) {
                c.this.A2(false);
                c cVar = c.this;
                cVar.z2(cVar.B2());
                return;
            }
            ArrayList<SampleMovementReport> B2 = c.this.B2();
            ArrayList arrayList = new ArrayList();
            for (Object obj : B2) {
                if (k.a(((SampleMovementReport) obj).getField2(), kv.value)) {
                    arrayList.add(obj);
                }
            }
            ((TextView) ((a6.a) c.this).f306w0.findViewById(h.U)).setText(kv.value);
            c.this.z2(arrayList);
            c.this.A2(true);
        }
    }

    public c() {
        new View.OnClickListener() { // from class: f6.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.groboot.mdaemergency.ui.fragments.c.J2(com.groboot.mdaemergency.ui.fragments.c.this, view);
            }
        };
        this.G0 = new DateField.d() { // from class: f6.p1
            @Override // com.groboot.mdaemergency.ui.views.DateField.d
            public final void a(View view, Date date) {
                com.groboot.mdaemergency.ui.fragments.c.M2(com.groboot.mdaemergency.ui.fragments.c.this, view, date);
            }
        };
    }

    private final void C2() {
        List d10;
        Context A = A();
        if (A == null) {
            return;
        }
        ((ConstraintLayout) this.f306w0.findViewById(h.f9840v)).setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) this.f306w0.findViewById(h.M);
        d10 = q.d();
        recyclerView.setAdapter(new c6.q(d10, A));
    }

    private final KvTable D2() {
        KvTable kvTable = new KvTable();
        ArrayList<SampleMovementReport> arrayList = this.C0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayList) {
            String field2 = ((SampleMovementReport) obj).getField2();
            Object obj2 = linkedHashMap.get(field2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(field2, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList2.add(new Kv(B2().indexOf(((List) entry.getValue()).get(0)), (String) entry.getKey()));
        }
        kvTable.addAll(arrayList2);
        ((SpinnerField) this.f306w0.findViewById(h.N)).setKVTableDataSource(kvTable);
        return kvTable;
    }

    private final void E2() {
        C2();
        Date date = ((DateField) this.f306w0.findViewById(h.f9841w)).getDate();
        Date date2 = ((DateField) this.f306w0.findViewById(h.f9842x)).getDate();
        if (date == null || date2 == null) {
            return;
        }
        F2(date, date2);
    }

    private final void F2(Date date, Date date2) {
        O2(true);
        date.getTime();
        com.groboot.mdaemergency.async.d.v().u(new InfectiousDiseaseReportData(this.B0.getValue(), k.j(l0.c0(date, l0.f15200m), " 00:00:00"), k.j(l0.c0(date2, l0.f15200m), " 23:59:00")), new b.InterfaceC0098b() { // from class: f6.o1
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                com.groboot.mdaemergency.ui.fragments.c.G2(com.groboot.mdaemergency.ui.fragments.c.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(c cVar, b.a aVar) {
        k.e(cVar, "this$0");
        cVar.O2(false);
        if (aVar.f7614b) {
            try {
                Object j10 = new com.google.gson.e().j(aVar.e("Content"), new d().b());
                k.d(j10, "Gson().fromJson(it.getSt…vementReport>>() {}.type)");
                List<SampleMovementReport> list = (List) j10;
                cVar.C0.addAll(list);
                cVar.z2(list);
                cVar.D2();
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H2(SampleMovementReport sampleMovementReport) {
        com.groboot.mdaemergency.async.d.v().n(sampleMovementReport.getPackageUID(), new b.InterfaceC0098b() { // from class: f6.n1
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                com.groboot.mdaemergency.ui.fragments.c.I2(com.groboot.mdaemergency.ui.fragments.c.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(c cVar, b.a aVar) {
        Answer a10;
        k.e(cVar, "this$0");
        if (!aVar.f7614b || (a10 = aVar.a()) == null) {
            return;
        }
        cVar.o(new f6.b((PackageBarcodesData) new com.google.gson.e().i(a10.getResult(), PackageBarcodesData.class)), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(c cVar, View view) {
        k.e(cVar, "this$0");
        cVar.N2(EnumC0127c.Laboratory);
        ((TextView) cVar.f306w0.findViewById(h.f9821c)).setBackgroundResource(R.drawable.white);
        ((TextView) cVar.f306w0.findViewById(h.f9820b)).setBackgroundResource(R.drawable.tab_select_reports);
        cVar.E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(c cVar, View view) {
        k.e(cVar, "this$0");
        cVar.E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L2(c cVar, View view) {
        View findViewById;
        k.e(cVar, "this$0");
        View view2 = cVar.f306w0;
        int i10 = h.f9821c;
        ((TextView) view2.findViewById(i10)).setBackgroundResource(R.drawable.white);
        int i11 = h.f9820b;
        ((TextView) view2.findViewById(i11)).setBackgroundResource(R.drawable.white);
        int i12 = h.f9822d;
        ((TextView) view2.findViewById(i12)).setBackgroundResource(R.drawable.white);
        if (k.a(view, (TextView) view2.findViewById(i10))) {
            cVar.N2(EnumC0127c.Movement);
            findViewById = view2.findViewById(i10);
        } else {
            if (!k.a(view, (TextView) view2.findViewById(i11))) {
                if (k.a(view, (TextView) view2.findViewById(i12))) {
                    cVar.N2(EnumC0127c.Refrigerator);
                    findViewById = view2.findViewById(i12);
                }
                cVar.E2();
            }
            cVar.N2(EnumC0127c.Laboratory);
            findViewById = view2.findViewById(i11);
        }
        ((TextView) findViewById).setBackgroundResource(R.drawable.tab_select_reports);
        cVar.E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(c cVar, View view, Date date) {
        k.e(cVar, "this$0");
        View view2 = cVar.f306w0;
        if (view.getId() == R.id.dfFrom) {
            ((DateField) view2.findViewById(h.f9842x)).setMinDate(date);
        } else if (view.getId() == R.id.dfTo) {
            ((DateField) view2.findViewById(h.f9841w)).setMaxDate(date);
        }
    }

    private final void N2(EnumC0127c enumC0127c) {
        ((TextView) this.f306w0.findViewById(h.T)).setText(enumC0127c.getTitles().a());
        ((TextView) this.f306w0.findViewById(h.U)).setText(enumC0127c.getTitles().b());
        this.B0 = enumC0127c;
    }

    private final void O2(boolean z10) {
        View view = this.f306w0;
        if (z10) {
            ((ProgressBar) view.findViewById(h.D)).setVisibility(0);
            ((Button) view.findViewById(h.f9824f)).setVisibility(8);
        } else {
            ((ProgressBar) view.findViewById(h.D)).setVisibility(8);
            ((Button) view.findViewById(h.f9824f)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2(List<SampleMovementReport> list) {
        View view = this.f306w0;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(h.M);
        Context context = recyclerView.getContext();
        if (context != null) {
            c6.q qVar = new c6.q(list, context);
            qVar.w(new b());
            recyclerView.setAdapter(qVar);
            RecyclerView.g adapter = recyclerView.getAdapter();
            k.b(adapter);
            adapter.g();
        }
        ((ConstraintLayout) view.findViewById(h.f9840v)).setVisibility(0);
    }

    public final void A2(boolean z10) {
        ((TextView) this.f306w0.findViewById(h.V)).setVisibility(z10 ? 0 : 4);
        if (z10) {
            return;
        }
        ((TextView) this.f306w0.findViewById(h.U)).setText(this.B0.getTitles().b());
    }

    public final ArrayList<SampleMovementReport> B2() {
        return this.C0;
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public /* synthetic */ void I0() {
        super.I0();
        v2();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_samples_summary);
        a("סיכום דגימות");
        View view = this.f306w0;
        int i10 = h.f9841w;
        ((DateField) view.findViewById(i10)).setMaxDate(new Date());
        int i11 = h.f9842x;
        ((DateField) view.findViewById(i11)).setMaxDate(new Date());
        ((SpinnerField) view.findViewById(h.N)).setOnValueSelected(this.D0);
        ((Button) view.findViewById(h.f9824f)).setOnClickListener(this.E0);
        ((TextView) view.findViewById(h.f9821c)).setOnClickListener(this.F0);
        ((TextView) view.findViewById(h.f9820b)).setOnClickListener(this.F0);
        ((TextView) view.findViewById(h.f9822d)).setOnClickListener(this.F0);
        ((DateField) view.findViewById(i10)).setOnDateChange(this.G0);
        ((DateField) view.findViewById(i11)).setOnDateChange(this.G0);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(h.M);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        O2(false);
        A2(false);
        E2();
    }

    @Override // a6.a
    public void o2() {
    }

    public void v2() {
        this.A0.clear();
    }
}
