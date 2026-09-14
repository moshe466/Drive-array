package f6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.models.SamplerShift;
import com.groboot.mdaemergency.models.ShiftContainer;
import com.groboot.mdaemergency.ui.views.SpinnerEditText;
import com.groboot.mdaemergency.ui.views.TimeField;
import il.org.mda.health.R;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes.dex */
public class e extends a6.a {
    c A0;
    ShiftContainer B0;
    String C0;
    boolean D0;
    boolean E0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0098b {

        /* renamed from: f6.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0161a implements Runnable {
            RunnableC0161a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.A0.h();
            }
        }

        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x00af  */
        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(com.groboot.mdaemergency.async.b.a r5) {
            /*
                r4 = this;
                f6.e r0 = f6.e.this
                r1 = 0
                r0.D0 = r1
                boolean r0 = r5.f7614b
                if (r0 != 0) goto L4f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                int r1 = r5.f7618f
                r0.append(r1)
                java.lang.String r1 = ""
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r0 = w6.l0.L(r0)
                f6.e r1 = f6.e.this
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "שגיאה מספר ["
                java.lang.String r3 = w6.l0.O(r3)
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = "]"
                java.lang.String r0 = w6.l0.O(r0)
                r2.append(r0)
                java.lang.String r0 = w6.l0.K()
                r2.append(r0)
                java.lang.String r5 = r5.f7617e
                r2.append(r5)
                java.lang.String r5 = r2.toString()
            L4c:
                r1.C0 = r5
                goto La7
            L4f:
                r0 = 0
                com.google.gson.e r1 = new com.google.gson.e     // Catch: java.lang.Exception -> L9d
                r1.<init>()     // Catch: java.lang.Exception -> L9d
                java.lang.String r5 = r5.f7616d     // Catch: java.lang.Exception -> L9d
                java.lang.Class<f6.d$h> r2 = f6.d.h.class
                java.lang.Object r5 = r1.i(r5, r2)     // Catch: java.lang.Exception -> L9d
                f6.d$h r5 = (f6.d.h) r5     // Catch: java.lang.Exception -> L9d
                if (r5 != 0) goto L68
                f6.e r5 = f6.e.this     // Catch: java.lang.Exception -> L9d
                java.lang.String r1 = "לא התקבלו נתונים"
            L65:
                r5.C0 = r1     // Catch: java.lang.Exception -> L9d
                goto La7
            L68:
                f6.e r1 = f6.e.this     // Catch: java.lang.Exception -> L9d
                java.lang.String r5 = r5.f9425a     // Catch: java.lang.Exception -> L9d
                java.lang.Class<com.groboot.mdaemergency.models.ShiftContainer> r2 = com.groboot.mdaemergency.models.ShiftContainer.class
                java.lang.Object r5 = w6.j.a(r5, r2)     // Catch: java.lang.Exception -> L9d
                com.groboot.mdaemergency.models.ShiftContainer r5 = (com.groboot.mdaemergency.models.ShiftContainer) r5     // Catch: java.lang.Exception -> L9d
                r1.B0 = r5     // Catch: java.lang.Exception -> L9d
                f6.e r5 = f6.e.this     // Catch: java.lang.Exception -> L9d
                com.groboot.mdaemergency.models.ShiftContainer r1 = r5.B0     // Catch: java.lang.Exception -> L9d
                if (r1 != 0) goto L7f
                java.lang.String r1 = "התקבלו נתונים ריקים"
                goto L65
            L7f:
                java.util.Hashtable<java.lang.Integer, java.lang.String> r2 = r1.Stations     // Catch: java.lang.Exception -> L9d
                if (r2 != 0) goto L8a
                java.lang.String r1 = "התקבלו נתונים ריקים1"
                r5.C0 = r1     // Catch: java.lang.Exception -> L9d
                r5.B0 = r0     // Catch: java.lang.Exception -> L9d
                goto La7
            L8a:
                com.groboot.mdaemergency.models.SamplerShift r5 = r1.Shift     // Catch: java.lang.Exception -> L9d
                if (r5 != 0) goto L95
                com.groboot.mdaemergency.models.SamplerShift r5 = new com.groboot.mdaemergency.models.SamplerShift     // Catch: java.lang.Exception -> L9d
                r5.<init>()     // Catch: java.lang.Exception -> L9d
                r1.Shift = r5     // Catch: java.lang.Exception -> L9d
            L95:
                f6.e r5 = f6.e.this     // Catch: java.lang.Exception -> L9d
                f6.e$c r5 = r5.A0     // Catch: java.lang.Exception -> L9d
                f6.e.c.d(r5)     // Catch: java.lang.Exception -> L9d
                goto La7
            L9d:
                r5 = move-exception
                f6.e r1 = f6.e.this
                r1.B0 = r0
                java.lang.String r5 = r5.getMessage()
                goto L4c
            La7:
                f6.e r5 = f6.e.this
                androidx.fragment.app.j r5 = r5.t()
                if (r5 == 0) goto Lbd
                f6.e r5 = f6.e.this
                androidx.fragment.app.j r5 = r5.t()
                f6.e$a$a r0 = new f6.e$a$a
                r0.<init>()
                r5.runOnUiThread(r0)
            Lbd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f6.e.a.a(com.groboot.mdaemergency.async.b$a):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9455a;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.B0 = null;
                eVar.G2();
            }
        }

        /* renamed from: f6.e$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0162b implements Runnable {
            RunnableC0162b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.A0.h();
            }
        }

        b(boolean z10) {
            this.f9455a = z10;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            e eVar = e.this;
            eVar.E0 = false;
            if (aVar.f7614b) {
                if (this.f9455a) {
                    ShiftContainer shiftContainer = eVar.B0;
                    shiftContainer.OnShift = false;
                    shiftContainer.Shift = new SamplerShift();
                } else {
                    eVar.B0.OnShift = true;
                }
                w6.l0.L0(w6.l0.v(), "הפעולה נשמרה", true);
                if (e.this.t() != null) {
                    e.this.t().runOnUiThread(new a());
                    return;
                }
                return;
            }
            Context v10 = w6.l0.v();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" הפעולה נכשלה");
            String str = aVar.f7617e;
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            w6.l0.L0(v10, sb2.toString(), true);
            if (e.this.t() != null) {
                e.this.t().runOnUiThread(new RunnableC0162b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener, SpinnerEditText.e, TimeField.d {

        /* renamed from: f, reason: collision with root package name */
        View f9459f;

        /* renamed from: g, reason: collision with root package name */
        View f9460g;

        /* renamed from: h, reason: collision with root package name */
        View f9461h;

        /* renamed from: i, reason: collision with root package name */
        SpinnerEditText f9462i;

        /* renamed from: j, reason: collision with root package name */
        TimeField f9463j;

        /* renamed from: k, reason: collision with root package name */
        TimeField f9464k;

        /* renamed from: l, reason: collision with root package name */
        TextView f9465l;

        /* renamed from: m, reason: collision with root package name */
        TextView f9466m;

        /* renamed from: n, reason: collision with root package name */
        TextView f9467n;

        /* renamed from: o, reason: collision with root package name */
        TextView f9468o;

        /* renamed from: p, reason: collision with root package name */
        TextView f9469p;

        /* renamed from: q, reason: collision with root package name */
        Button f9470q;

        /* renamed from: r, reason: collision with root package name */
        Button f9471r;

        /* renamed from: s, reason: collision with root package name */
        Button f9472s;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            KvTable kvTable = new KvTable();
            Iterator<Integer> it = e.this.B0.Stations.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                kvTable.add((KvTable) new Kv(intValue, e.this.B0.Stations.get(Integer.valueOf(intValue))));
            }
            this.f9462i.setKVTableDataSource(kvTable);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x010b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void f() {
            /*
                Method dump skipped, instructions count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: f6.e.c.f():void");
        }

        @Override // com.groboot.mdaemergency.ui.views.SpinnerEditText.e
        public void a(Kv kv, SpinnerEditText spinnerEditText) {
            if (spinnerEditText.getId() == R.id.sf_station) {
                e.this.B0.Shift.StationId = kv != null ? kv.key : 0;
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.TimeField.d
        public void b(View view, int i10, int i11) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(11, i10);
            calendar.set(12, i11);
            calendar.set(13, 0);
            if (view.getId() == R.id.et_from) {
                e.this.B0.Shift.FromTime = calendar.getTime();
            }
            if (view.getId() == R.id.et_to) {
                e.this.B0.Shift.ToTime = calendar.getTime();
            }
            SamplerShift samplerShift = e.this.B0.Shift;
            if (samplerShift.ToTime == null || samplerShift.FromTime == null) {
                this.f9468o.setText("");
            } else {
                f();
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.SpinnerEditText.e
        public void c(KvTable kvTable, SpinnerEditText spinnerEditText) {
        }

        public void g() {
            this.f9459f = ((a6.a) e.this).f306w0.findViewById(R.id.ll_data_views);
            this.f9460g = ((a6.a) e.this).f306w0.findViewById(R.id.pb_wait);
            this.f9462i = (SpinnerEditText) ((a6.a) e.this).f306w0.findViewById(R.id.sf_station);
            this.f9469p = (TextView) ((a6.a) e.this).f306w0.findViewById(R.id.tv_car);
            this.f9461h = ((a6.a) e.this).f306w0.findViewById(R.id.rl_car);
            this.f9463j = (TimeField) ((a6.a) e.this).f306w0.findViewById(R.id.et_from);
            this.f9464k = (TimeField) ((a6.a) e.this).f306w0.findViewById(R.id.et_to);
            this.f9465l = (TextView) ((a6.a) e.this).f306w0.findViewById(R.id.tv_error);
            this.f9466m = (TextView) ((a6.a) e.this).f306w0.findViewById(R.id.tv_wait);
            this.f9467n = (TextView) ((a6.a) e.this).f306w0.findViewById(R.id.tv_message);
            this.f9470q = (Button) ((a6.a) e.this).f306w0.findViewById(R.id.btn_enter);
            this.f9471r = (Button) ((a6.a) e.this).f306w0.findViewById(R.id.btn_exit);
            this.f9472s = (Button) ((a6.a) e.this).f306w0.findViewById(R.id.btn_action);
            this.f9468o = (TextView) ((a6.a) e.this).f306w0.findViewById(R.id.tv_AmountHour);
            this.f9470q.setOnClickListener(this);
            this.f9471r.setOnClickListener(this);
            this.f9472s.setOnClickListener(this);
            this.f9462i.setOnValueSelected(this);
            this.f9462i.f8362t = false;
            this.f9463j.setOnTimeChange(this);
            this.f9464k.setOnTimeChange(this);
        }

        public void h() {
            this.f9467n.setText("");
            this.f9465l.setText("");
            this.f9460g.setVisibility(8);
            this.f9466m.setVisibility(8);
            this.f9472s.setVisibility(8);
            this.f9470q.setVisibility(8);
            this.f9471r.setVisibility(8);
            this.f9459f.setVisibility(8);
            this.f9461h.setVisibility(8);
            e eVar = e.this;
            if (eVar.D0) {
                this.f9460g.setVisibility(0);
                this.f9467n.setText("טוען נתונים");
                this.f9466m.setVisibility(0);
                return;
            }
            if (eVar.B0 == null) {
                if (w6.l0.l0(eVar.C0)) {
                    e.this.C0 = "תקלה לא צפויה";
                }
                this.f9465l.setText(Html.fromHtml(e.this.C0));
                this.f9472s.setVisibility(0);
                return;
            }
            if (eVar.E0) {
                this.f9460g.setVisibility(0);
                this.f9467n.setText("שולח נתונים לשרת");
                this.f9466m.setVisibility(0);
                return;
            }
            this.f9459f.setVisibility(0);
            (e.this.B0.OnShift ? this.f9471r : this.f9470q).setVisibility(0);
            f();
            this.f9462i.setSelectedValue(e.this.B0.Shift.StationId);
            if (w6.l0.l0(e.this.B0.Shift.Vehicle)) {
                this.f9461h.setVisibility(8);
            } else {
                this.f9469p.setText(" " + e.this.B0.Shift.Vehicle + " ");
                this.f9461h.setVisibility(0);
            }
            this.f9463j.setTime(e.this.B0.Shift.FromTime);
            this.f9464k.setTime(e.this.B0.Shift.ToTime);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            ShiftContainer shiftContainer = eVar.B0;
            if (shiftContainer == null) {
                if (view.getId() == R.id.btn_action) {
                    e eVar2 = e.this;
                    if (eVar2.D0) {
                        return;
                    }
                    eVar2.G2();
                    return;
                }
                return;
            }
            SamplerShift samplerShift = shiftContainer.Shift;
            if (samplerShift.StationId == 0) {
                eVar.I2("אנא בחר תחנה");
            } else if (samplerShift.FromTime == null || samplerShift.ToTime == null) {
                eVar.I2("נא הגדר את שעות המשמרת המתוכננת");
            } else {
                eVar.H2(view.getId() == R.id.btn_exit);
                e.this.A0.h();
            }
        }
    }

    @SuppressLint({"ValidFragment"})
    public e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G2() {
        if (this.D0) {
            return;
        }
        this.D0 = true;
        this.C0 = "";
        this.A0.h();
        com.groboot.mdaemergency.async.d.v().L(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(boolean z10) {
        this.E0 = true;
        com.groboot.mdaemergency.async.d.v().m0(z10, this.B0.Shift, new b(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(String str) {
        w6.l0.L0(A(), str, true);
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        if (this.B0 == null) {
            G2();
        }
        this.A0.h();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.corona_tester_fragment);
        a("הגדרת משמרת - דוגמים");
        c cVar = new c();
        this.A0 = cVar;
        cVar.g();
    }

    @Override // a6.a
    public void o2() {
    }
}
