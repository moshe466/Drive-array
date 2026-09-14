package f6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c6.j;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.Answer;
import com.groboot.mdaemergency.models.CoronaBarcode;
import com.groboot.mdaemergency.models.CoronaBarcodesAction;
import com.groboot.mdaemergency.models.DeliveryObject;
import com.groboot.mdaemergency.models.EvacuationSite;
import com.groboot.mdaemergency.models.EvacuationSites;
import com.groboot.mdaemergency.models.Ksv;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.ui.views.f;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import rb.c;
import w6.m0;

/* loaded from: classes.dex */
public class d extends a6.a implements c.b {
    boolean A0 = false;
    private v6.a B0;
    CoronaBarcodesAction C0;
    i D0;
    EvacuationSites E0;
    String F0;
    boolean G0;
    c6.d H0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0098b {

        /* renamed from: f6.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0159a implements Runnable {
            RunnableC0159a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.D0.b();
            }
        }

        a() {
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            d dVar;
            String str;
            d.this.G0 = false;
            if (aVar.f7614b) {
                try {
                    h hVar = (h) new com.google.gson.e().i(aVar.f7616d, h.class);
                    if (hVar == null) {
                        dVar = d.this;
                    } else {
                        hVar.f9425a = (String) new com.google.gson.e().i(hVar.f9425a, String.class);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("sd.Result:");
                        sb2.append(hVar.f9425a);
                        d.this.E0 = (EvacuationSites) new com.google.gson.e().i(hVar.f9425a, EvacuationSites.class);
                        dVar = d.this;
                        EvacuationSites evacuationSites = dVar.E0;
                        if (evacuationSites == null) {
                            dVar.F0 = "התקבלו נתונים ריקים1";
                        }
                        if (evacuationSites.Refrigerators == null) {
                            dVar.F0 = "התקבלו נתונים ריקים2";
                        }
                        str = evacuationSites.EvacuationSites == null ? "התקבלו נתונים ריקים3" : "לא התקבלו נתונים";
                    }
                    dVar.F0 = str;
                } catch (Exception e10) {
                    d dVar2 = d.this;
                    dVar2.E0 = null;
                    dVar2.F0 = e10.getMessage();
                }
            } else {
                String L = w6.l0.L(aVar.f7618f + "");
                d.this.F0 = w6.l0.O("שגיאה מספר [") + L + w6.l0.O("]") + w6.l0.K() + aVar.f7617e;
            }
            if (d.this.t() != null) {
                d.this.t().runOnUiThread(new RunnableC0159a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CoronaBarcode f9412a;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.H0.notifyDataSetChanged();
            }
        }

        b(CoronaBarcode coronaBarcode) {
            this.f9412a = coronaBarcode;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            StringBuilder sb2;
            String str;
            String str2;
            if (aVar.f7614b) {
                d dVar = d.this;
                if (dVar.C0.barcodes == null || dVar.H0 == null) {
                    return;
                }
                if (((Answer) new com.google.gson.e().i(aVar.f7616d, Answer.class)) == null) {
                    sb2 = new StringBuilder();
                    str = "json error data:";
                } else {
                    g gVar = (g) new com.google.gson.e().i(aVar.f7616d, g.class);
                    if (gVar != null) {
                        this.f9412a.HMO = new Kv(gVar.f9423a, gVar.f9424b);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("result:");
                        sb3.append(gVar.f9423a);
                        sb3.append(",");
                        sb3.append(gVar.f9424b);
                        if (d.this.t() != null) {
                            d.this.t().runOnUiThread(new a());
                            return;
                        }
                        return;
                    }
                    sb2 = new StringBuilder();
                    str = "json error2 data:";
                }
                sb2.append(str);
                str2 = aVar.f7616d;
            } else {
                sb2 = new StringBuilder();
                sb2.append("error: ");
                str2 = aVar.f7617e;
            }
            sb2.append(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d.this.C0.sourceType = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f6.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC0160d implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC0160d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d.this.C0.sourceType = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f9417a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f9418b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f9419c;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.D0.b();
            }
        }

        e(ArrayList arrayList, ArrayList arrayList2, boolean z10) {
            this.f9417a = arrayList;
            this.f9418b = arrayList2;
            this.f9419c = z10;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            d.this.C0.sending = false;
            if (aVar.f7614b) {
                Iterator it = this.f9417a.iterator();
                while (it.hasNext()) {
                    ((CoronaBarcode) it.next()).isSaved = true;
                }
                d dVar = d.this;
                if (dVar.C0.actionType == 2) {
                    dVar.E0.Deliveries.removeAll(this.f9418b);
                } else {
                    Iterator it2 = this.f9418b.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!d.this.E0.Deliveries.contains(str)) {
                            d.this.E0.Deliveries.add(str);
                        }
                    }
                }
                if (this.f9419c) {
                    d.this.T2();
                    return;
                }
            } else {
                Context v10 = w6.l0.v();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" הפעולה נכשלה");
                sb2.append(aVar.f7617e);
                w6.l0.L0(v10, sb2.toString() != null ? aVar.f7617e : "", true);
            }
            if (d.this.t() != null) {
                d.this.t().runOnUiThread(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements j.a {
        f() {
        }

        @Override // c6.j.a
        public void a(Ksv ksv) {
            if (ksv.hasValue()) {
                d.this.C0.evacuationSite = new EvacuationSite();
                d dVar = d.this;
                EvacuationSite evacuationSite = dVar.C0.evacuationSite;
                evacuationSite.Id = ksv.key;
                evacuationSite.Name = ksv.value;
                dVar.D0.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        int f9423a;

        /* renamed from: b, reason: collision with root package name */
        String f9424b;
    }

    /* loaded from: classes.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        public String f9425a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        TextView f9426f;

        /* renamed from: g, reason: collision with root package name */
        TextView f9427g;

        /* renamed from: h, reason: collision with root package name */
        TextView f9428h;

        /* renamed from: i, reason: collision with root package name */
        TextView f9429i;

        /* renamed from: j, reason: collision with root package name */
        ListView f9430j;

        /* renamed from: k, reason: collision with root package name */
        View f9431k;

        /* renamed from: l, reason: collision with root package name */
        View f9432l;

        /* renamed from: m, reason: collision with root package name */
        View f9433m;

        /* renamed from: n, reason: collision with root package name */
        View f9434n;

        /* renamed from: o, reason: collision with root package name */
        View f9435o;

        /* renamed from: p, reason: collision with root package name */
        View f9436p;

        /* renamed from: q, reason: collision with root package name */
        Button f9437q;

        /* renamed from: r, reason: collision with root package name */
        Button f9438r;

        /* renamed from: s, reason: collision with root package name */
        Button f9439s;

        /* renamed from: t, reason: collision with root package name */
        Button f9440t;

        /* renamed from: u, reason: collision with root package name */
        Button f9441u;

        /* renamed from: v, reason: collision with root package name */
        Button f9442v;

        /* renamed from: w, reason: collision with root package name */
        GridView f9443w;

        /* renamed from: x, reason: collision with root package name */
        EditText f9444x;

        /* renamed from: y, reason: collision with root package name */
        c6.j f9445y;

        /* renamed from: z, reason: collision with root package name */
        TextWatcher f9446z = new c();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.X2(((Object) ((Button) view).getText()) + "");
            }
        }

        /* loaded from: classes.dex */
        class b implements f.a {
            b() {
            }

            @Override // com.groboot.mdaemergency.ui.views.f.a
            public void a() {
            }

            @Override // com.groboot.mdaemergency.ui.views.f.a
            public void b(String str) {
                if (w6.l0.l0(str)) {
                    return;
                }
                d.this.X2(str);
            }

            @Override // com.groboot.mdaemergency.ui.views.f.a
            public void c() {
            }
        }

        /* loaded from: classes.dex */
        class c implements TextWatcher {
            c() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c6.j jVar = i.this.f9445y;
                if (jVar == null) {
                    return;
                }
                jVar.b(editable.toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        }

        i() {
        }

        public void a() {
            this.f9426f = (TextView) ((a6.a) d.this).f306w0.findViewById(R.id.tv_1);
            this.f9427g = (TextView) ((a6.a) d.this).f306w0.findViewById(R.id.tv_2);
            this.f9428h = (TextView) ((a6.a) d.this).f306w0.findViewById(R.id.tv_barcodes);
            this.f9430j = (ListView) ((a6.a) d.this).f306w0.findViewById(R.id.lv_action_list);
            this.f9436p = ((a6.a) d.this).f306w0.findViewById(R.id.ll_action_list);
            this.f9444x = (EditText) ((a6.a) d.this).f306w0.findViewById(R.id.etSearch);
            this.f9431k = ((a6.a) d.this).f306w0.findViewById(R.id.ll_buttons_action);
            this.f9432l = ((a6.a) d.this).f306w0.findViewById(R.id.rl_progress);
            this.f9434n = ((a6.a) d.this).f306w0.findViewById(R.id.iv_focus);
            this.f9435o = ((a6.a) d.this).f306w0.findViewById(R.id.rl_scanner);
            this.f9429i = (TextView) ((a6.a) d.this).f306w0.findViewById(R.id.tv_ask);
            this.f9433m = ((a6.a) d.this).f306w0.findViewById(R.id.ll_barcodes);
            this.f9437q = (Button) ((a6.a) d.this).f306w0.findViewById(R.id.btn_action1);
            this.f9438r = (Button) ((a6.a) d.this).f306w0.findViewById(R.id.btn_action2);
            this.f9439s = (Button) ((a6.a) d.this).f306w0.findViewById(R.id.btn_action3);
            this.f9440t = (Button) ((a6.a) d.this).f306w0.findViewById(R.id.btn_action);
            this.f9441u = (Button) ((a6.a) d.this).f306w0.findViewById(R.id.btn_action_ok);
            this.f9443w = (GridView) ((a6.a) d.this).f306w0.findViewById(R.id.rl_barcodes);
            this.f9442v = (Button) ((a6.a) d.this).f306w0.findViewById(R.id.btn_typeBarcode);
            this.f9434n.setOnClickListener(this);
            this.f9437q.setOnClickListener(this);
            this.f9438r.setOnClickListener(this);
            this.f9439s.setOnClickListener(this);
            this.f9440t.setOnClickListener(this);
            this.f9441u.setOnClickListener(this);
            this.f9442v.setOnClickListener(this);
            this.f9444x.addTextChangedListener(this.f9446z);
            new a();
        }

        public void b() {
            TextView textView;
            String str;
            try {
                this.f9440t.setEnabled(true);
                this.f9440t.setText("");
                this.f9426f.setText("");
                this.f9441u.setVisibility(8);
                this.f9429i.setVisibility(8);
                this.f9432l.setVisibility(8);
                this.f9433m.setVisibility(8);
                this.f9427g.setVisibility(8);
                this.f9436p.setVisibility(8);
                this.f9431k.setVisibility(8);
                d dVar = d.this;
                if (dVar.E0 == null) {
                    this.f9426f.setText("טעינת נתונים");
                    if (d.this.G0) {
                        this.f9432l.setVisibility(0);
                        this.f9427g.setVisibility(0);
                        this.f9427g.setText("פונה לשרת לקבלת נתונים. אנא המתן");
                        this.f9440t.setText("");
                        this.f9440t.setEnabled(false);
                    } else {
                        this.f9440t.setText("חזרה");
                        if (w6.l0.l0(d.this.F0)) {
                            d.this.F0 = "שגיאה לא צפוייה";
                        }
                        this.f9441u.setVisibility(0);
                        this.f9441u.setText("נסה שנית");
                        this.f9429i.setText(Html.fromHtml(d.this.F0));
                        this.f9429i.setVisibility(0);
                    }
                    return;
                }
                if (dVar.C0.actionType == 0) {
                    this.f9431k.setVisibility(0);
                    this.f9437q.setText("איסוף");
                    this.f9438r.setText("מסירה");
                    this.f9439s.setText("אתר");
                    this.f9440t.setText("סגור");
                    this.f9426f.setText("בחר פעולה לדיווח");
                    this.f9439s.setVisibility(0);
                    d dVar2 = d.this;
                    if (dVar2.A0) {
                        dVar2.g3();
                        this.f9435o.setVisibility(8);
                        d.this.A0 = false;
                    }
                    this.f9435o.setVisibility(8);
                    return;
                }
                this.f9439s.setVisibility(8);
                CoronaBarcodesAction coronaBarcodesAction = d.this.C0;
                String str2 = coronaBarcodesAction.actionType == 1 ? "איסוף" : "מסירה";
                int i10 = coronaBarcodesAction.sourceType;
                if (i10 == 0) {
                    this.f9431k.setVisibility(0);
                    this.f9437q.setText("מקרר תחנה");
                    this.f9438r.setText("מעבדה");
                    this.f9440t.setText("חזרה");
                    this.f9426f.setText(d.this.V2());
                    d dVar3 = d.this;
                    if (dVar3.A0) {
                        dVar3.g3();
                        this.f9435o.setVisibility(8);
                        d.this.A0 = false;
                    }
                    this.f9435o.setVisibility(8);
                    return;
                }
                String str3 = i10 != 1 ? "מקרר" : "מעבדה";
                if (coronaBarcodesAction.evacuationSite == null) {
                    this.f9436p.setVisibility(0);
                    this.f9444x.setText("");
                    c6.j W2 = d.this.W2();
                    this.f9445y = W2;
                    this.f9430j.setAdapter((ListAdapter) W2);
                    this.f9440t.setText("חזרה");
                    if (d.this.C0.actionType == 1) {
                        textView = this.f9426f;
                        str = "בחר " + str3 + " לדיווח " + str2;
                    } else {
                        textView = this.f9426f;
                        str = "בחר " + str3 + " לדיווח " + str2;
                    }
                    textView.setText(str);
                    d dVar4 = d.this;
                    if (dVar4.A0) {
                        dVar4.g3();
                        this.f9435o.setVisibility(8);
                        d.this.A0 = false;
                    }
                    this.f9435o.setVisibility(8);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(" ");
                sb2.append(d.this.C0.actionType == 1 ? "מ" : "ל");
                sb2.append(d.this.C0.evacuationSite.Name);
                String sb3 = sb2.toString();
                this.f9426f.setText("דיווח דגימות ל" + sb3);
                this.f9427g.setText("סך הכל נסרקו " + d.this.C0.barcodes.size() + " דגימות");
                this.f9427g.setVisibility(0);
                if (d.this.C0.barcodes.size() > 0) {
                    CoronaBarcodesAction coronaBarcodesAction2 = d.this.C0;
                    if (coronaBarcodesAction2.askToCancel) {
                        this.f9429i.setText(Html.fromHtml("דווחו " + d.this.C0.barcodes.size() + " ברקודים ל" + sb3 + w6.l0.K() + "האם למחוק נתונים?"));
                        this.f9429i.setVisibility(0);
                        this.f9441u.setVisibility(0);
                        this.f9440t.setText("ביטול");
                        this.f9441u.setText("אישור");
                        d dVar5 = d.this;
                        if (dVar5.A0) {
                            dVar5.g3();
                            this.f9435o.setVisibility(8);
                            d.this.A0 = false;
                        }
                        this.f9435o.setVisibility(8);
                        return;
                    }
                    if (coronaBarcodesAction2.askToSending) {
                        this.f9429i.setText(Html.fromHtml("דווחו " + d.this.C0.barcodes.size() + " ברקודים ל" + sb3 + w6.l0.K() + "האם לדווח?"));
                        this.f9429i.setVisibility(0);
                        this.f9441u.setVisibility(0);
                        this.f9440t.setText("ביטול");
                        this.f9441u.setText("אישור");
                        d dVar6 = d.this;
                        if (dVar6.A0) {
                            dVar6.g3();
                            this.f9435o.setVisibility(8);
                            d.this.A0 = false;
                        }
                        this.f9435o.setVisibility(8);
                        return;
                    }
                    if (coronaBarcodesAction2.sending) {
                        this.f9432l.setVisibility(0);
                        this.f9426f.setText("שולח נתונים לשרת");
                        this.f9427g.setVisibility(0);
                        this.f9427g.setText("אנא המתן");
                        this.f9440t.setText("");
                        this.f9440t.setEnabled(false);
                        d dVar7 = d.this;
                        if (dVar7.A0) {
                            dVar7.g3();
                            this.f9435o.setVisibility(8);
                            d.this.A0 = false;
                        }
                        this.f9435o.setVisibility(8);
                        return;
                    }
                }
                this.f9433m.setVisibility(0);
                this.f9442v.setVisibility(d.this.E0.EnabledTyping.booleanValue() ? 0 : 8);
                if (d.this.C0.barcodes.size() > 0) {
                    this.f9441u.setVisibility(0);
                    this.f9441u.setText("בצע דיווח");
                }
                this.f9440t.setText("חזרה");
                d.this.H0 = new c6.d(d.this.A(), d.this.C0.barcodes);
                this.f9443w.setAdapter((ListAdapter) d.this.H0);
                d.this.H0.notifyDataSetChanged();
                d dVar8 = d.this;
                if (true != dVar8.A0) {
                    if (dVar8.Y2()) {
                        d.this.f3();
                    } else {
                        d.this.g3();
                    }
                    this.f9435o.setVisibility(0);
                    d.this.A0 = true;
                }
            } finally {
                d dVar9 = d.this;
                if (dVar9.A0) {
                    dVar9.g3();
                    this.f9435o.setVisibility(8);
                    d.this.A0 = false;
                }
                this.f9435o.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.btn_typeBarcode) {
                com.groboot.mdaemergency.ui.views.f.j2(d.this.t(), "", "הקלד ברקוד", new b());
                return;
            }
            if (id == R.id.iv_focus) {
                d.this.Y2();
                d.this.f3();
                return;
            }
            switch (id) {
                case R.id.btn_action /* 2131296395 */:
                    d dVar = d.this;
                    CoronaBarcodesAction coronaBarcodesAction = dVar.C0;
                    if (coronaBarcodesAction.actionType == 0) {
                        dVar.t().onBackPressed();
                        return;
                    }
                    if (coronaBarcodesAction.sourceType == 0) {
                        coronaBarcodesAction.actionType = 0;
                        dVar.D0.b();
                        return;
                    }
                    if (coronaBarcodesAction.evacuationSite == null) {
                        coronaBarcodesAction.sourceType = 0;
                        dVar.D0.b();
                        return;
                    }
                    if (coronaBarcodesAction.askToCancel) {
                        coronaBarcodesAction.askToCancel = false;
                        dVar.D0.b();
                        return;
                    }
                    if (coronaBarcodesAction.askToSending) {
                        coronaBarcodesAction.askToSending = false;
                        dVar.D0.b();
                        return;
                    } else {
                        if (coronaBarcodesAction.sending) {
                            return;
                        }
                        if (coronaBarcodesAction.barcodes.size() == 0) {
                            d.this.C0.cancel();
                            d.this.D0.b();
                            return;
                        } else {
                            d dVar2 = d.this;
                            dVar2.C0.askToCancel = true;
                            dVar2.D0.b();
                            return;
                        }
                    }
                case R.id.btn_action1 /* 2131296396 */:
                    d dVar3 = d.this;
                    CoronaBarcodesAction coronaBarcodesAction2 = dVar3.C0;
                    if (coronaBarcodesAction2.actionType == 0) {
                        coronaBarcodesAction2.actionType = 1;
                        dVar3.D0.b();
                        return;
                    } else {
                        if (coronaBarcodesAction2.sourceType == 0) {
                            coronaBarcodesAction2.sourceType = 2;
                            dVar3.D0.b();
                            return;
                        }
                        return;
                    }
                case R.id.btn_action2 /* 2131296397 */:
                    d dVar4 = d.this;
                    CoronaBarcodesAction coronaBarcodesAction3 = dVar4.C0;
                    if (coronaBarcodesAction3.actionType == 0) {
                        coronaBarcodesAction3.actionType = 2;
                        dVar4.D0.b();
                        return;
                    } else {
                        if (coronaBarcodesAction3.sourceType == 0) {
                            coronaBarcodesAction3.sourceType = 1;
                            dVar4.D0.b();
                            return;
                        }
                        return;
                    }
                case R.id.btn_action3 /* 2131296398 */:
                    d dVar5 = d.this;
                    dVar5.C0.actionType = 3;
                    dVar5.o(new f6.b(d.this.E0), true);
                    return;
                case R.id.btn_action_ok /* 2131296399 */:
                    d dVar6 = d.this;
                    if (dVar6.E0 == null) {
                        if (dVar6.G0) {
                            return;
                        }
                        dVar6.b3();
                        d.this.D0.b();
                        return;
                    }
                    CoronaBarcodesAction coronaBarcodesAction4 = dVar6.C0;
                    if (coronaBarcodesAction4.askToCancel) {
                        coronaBarcodesAction4.askToCancel = false;
                        coronaBarcodesAction4.cancel();
                        d.this.D0.b();
                        return;
                    } else if (coronaBarcodesAction4.askToSending) {
                        dVar6.e3();
                        d.this.D0.b();
                        return;
                    } else {
                        if (coronaBarcodesAction4.barcodes.size() > 0) {
                            d dVar7 = d.this;
                            dVar7.C0.askToSending = true;
                            dVar7.D0.b();
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @SuppressLint({"ValidFragment"})
    public d() {
    }

    private boolean S2() {
        if (com.groboot.mdaemergency.a.l(t())) {
            return true;
        }
        androidx.core.app.b.n(t(), new String[]{"android.permission.CAMERA"}, 1);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        this.C0 = new CoronaBarcodesAction();
        w6.l0.N0("הפעולה נשמרה", true);
        this.D0.b();
    }

    private void U2() {
        w6.l0.J0(A(), "נתונים חסרים:", V2(), "מקרר", "מעבדה", new c(), new DialogInterfaceOnClickListenerC0160d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String V2() {
        StringBuilder sb2;
        String str;
        int i10 = this.C0.actionType;
        String str2 = i10 == 1 ? "איסוף" : "מסירה";
        if (i10 == 1) {
            sb2 = new StringBuilder();
            str = "בחר סוג מקור ל";
        } else {
            sb2 = new StringBuilder();
            str = "בחר סוג יעד ל";
        }
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c6.j W2() {
        ArrayList arrayList = new ArrayList();
        Hashtable<Integer, String> listBySourceType = this.E0.getListBySourceType(this.C0.sourceType);
        Iterator<Integer> it = listBySourceType.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            arrayList.add(new Ksv(intValue + "", listBySourceType.get(Integer.valueOf(intValue))));
        }
        Collections.sort(arrayList, new Comparator() { // from class: f6.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int Z2;
                Z2 = d.Z2((Ksv) obj, (Ksv) obj2);
                return Z2;
            }
        });
        return new c6.j(t(), arrayList, false, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X2(String str) {
        if (w6.l0.l0(str)) {
            w6.l0.L0(t(), "תקלה בסריקה", true);
            return;
        }
        CoronaBarcode coronaBarcode = null;
        Iterator<CoronaBarcode> it = this.C0.barcodes.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CoronaBarcode next = it.next();
            if (w6.l0.l(next.barcode, str)) {
                coronaBarcode = next;
                break;
            }
        }
        if (coronaBarcode != null) {
            w6.m0.c(t(), m0.d.error);
            return;
        }
        CoronaBarcode coronaBarcode2 = new CoronaBarcode(str, w6.l0.w());
        if (this.C0.actionType != 2 || this.E0.Deliveries.contains(coronaBarcode2.barcode)) {
            w6.m0.c(t(), m0.d.bip);
            w6.l0.X0(t(), 200);
            this.C0.barcodes.add(0, coronaBarcode2);
            a3(coronaBarcode2);
            this.D0.b();
            c3(coronaBarcode2);
            return;
        }
        w6.l0.L0(w6.l0.v(), "הברקוד " + coronaBarcode2.barcode + " לא נאסף", false);
        w6.m0.c(t(), m0.d.error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y2() {
        if (!S2()) {
            return false;
        }
        if (this.B0 != null) {
            ((LinearLayout) k2(R.id.ll_scanner)).removeAllViews();
            this.B0.h();
            this.B0 = null;
        }
        this.B0 = new v6.a(A());
        ArrayList arrayList = new ArrayList();
        arrayList.add(rb.a.f13843r);
        this.B0.setFormats(arrayList);
        ((LinearLayout) k2(R.id.ll_scanner)).addView(this.B0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Z2(Ksv ksv, Ksv ksv2) {
        return ksv.value.compareToIgnoreCase(ksv2.value);
    }

    private void a3(CoronaBarcode coronaBarcode) {
        com.groboot.mdaemergency.async.d.v().p(coronaBarcode, new b(coronaBarcode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3() {
        if (this.G0) {
            return;
        }
        this.G0 = true;
        this.F0 = "";
        com.groboot.mdaemergency.async.d.v().q(new a());
    }

    private void c3(CoronaBarcode coronaBarcode) {
        ArrayList<CoronaBarcode> arrayList = new ArrayList<>();
        arrayList.add(coronaBarcode);
        d3(arrayList, false);
    }

    private void d3(ArrayList<CoronaBarcode> arrayList, boolean z10) {
        if (arrayList.size() == 0) {
            if (z10) {
                T2();
                return;
            }
            return;
        }
        if (z10) {
            this.C0.sending = true;
        }
        CoronaBarcodesAction coronaBarcodesAction = this.C0;
        coronaBarcodesAction.askToSending = false;
        if (coronaBarcodesAction.sourceType == 0) {
            coronaBarcodesAction.askToSending = true;
            U2();
            return;
        }
        ArrayList<DeliveryObject> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator<CoronaBarcode> it = arrayList.iterator();
        while (it.hasNext()) {
            CoronaBarcode next = it.next();
            String str = next.barcode;
            int U = w6.l0.U(this.C0.evacuationSite.Id);
            CoronaBarcodesAction coronaBarcodesAction2 = this.C0;
            arrayList2.add(new DeliveryObject(str, U, coronaBarcodesAction2.sourceType, coronaBarcodesAction2.PackageUID));
            arrayList3.add(next.barcode);
        }
        com.groboot.mdaemergency.async.d.v().o0(arrayList2, this.C0.actionType == 1, new e(arrayList, arrayList3, z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3() {
        ArrayList<CoronaBarcode> arrayList = new ArrayList<>();
        Iterator<CoronaBarcode> it = this.C0.barcodes.iterator();
        while (it.hasNext()) {
            CoronaBarcode next = it.next();
            if (!next.isSaved) {
                arrayList.add(next);
            }
        }
        d3(arrayList, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        if (this.B0 != null || Y2()) {
            this.B0.setResultHandler(this);
            this.B0.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3() {
        v6.a aVar = this.B0;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        v6.a aVar = this.B0;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        if (this.A0) {
            Y2();
            f3();
        }
        if (this.E0 == null) {
            b3();
        }
        S2();
        this.D0.b();
    }

    @Override // rb.c.b
    public void d(rb.b bVar) {
        if (t() == null) {
            return;
        }
        this.B0.l(this);
        X2(bVar.b());
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.corona_barcode_fragment);
        a("העברת דגימות קורונה");
        this.C0 = new CoronaBarcodesAction();
        i iVar = new i();
        this.D0 = iVar;
        iVar.a();
    }

    @Override // a6.a
    public void o2() {
    }
}
