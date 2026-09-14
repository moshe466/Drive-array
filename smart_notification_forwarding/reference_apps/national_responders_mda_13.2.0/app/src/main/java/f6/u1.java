package f6;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import c6.k;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.Answer;
import com.groboot.mdaemergency.models.DeliveryObject;
import com.groboot.mdaemergency.models.Kv;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
public final class u1 extends a6.a {
    public Map<Integer, View> A0;
    private final Kv B0;
    public List<k.a> C0;
    public Hashtable<String, String> D0;
    private HashMap<String, Integer> E0;
    private boolean F0;
    public Kv G0;
    private final AdapterView.OnItemClickListener H0;
    private final b I0;

    /* loaded from: classes.dex */
    public static final class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (view == null) {
                return;
            }
            k.a aVar = u1.this.B2().get(i10);
            aVar.d(!aVar.a());
            View findViewById = view.findViewById(R.id.rl_content);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
            ((RelativeLayout) findViewById).setBackgroundResource(aVar.a() ? R.drawable.checked_oval : R.drawable.button_menu_background);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u1 u1Var = u1.this;
            if (u1Var.D0 == null) {
                u1Var.w2();
                return;
            }
            if (u1Var.y2()) {
                u1.this.J2();
                return;
            }
            List<k.a> B2 = u1.this.B2();
            ArrayList arrayList = new ArrayList();
            for (Object obj : B2) {
                if (((k.a) obj).a()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                i10 += ((k.a) it.next()).b();
            }
            u1 u1Var2 = u1.this;
            if (i10 == 0) {
                Toast.makeText(u1Var2.A(), "לא נבחרו בדיקות לשליחה", 0).show();
                return;
            }
            ((GridView) ((a6.a) u1Var2).f306w0.findViewById(g5.h.B)).setVisibility(8);
            TextView textView = (TextView) ((a6.a) u1.this).f306w0.findViewById(g5.h.P);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("דווחו ");
            sb2.append(i10);
            sb2.append(" ברקודים למסירה ");
            sb2.append((Object) w6.l0.K());
            u1 u1Var3 = u1.this;
            sb2.append(u1Var3.G0 != null ? y8.k.j("מ ", u1Var3.E2().value) : " אל " + ((Object) u1.this.A2().value) + ((Object) w6.l0.K()) + "האם לדווח?");
            textView.setText(Html.fromHtml(sb2.toString()));
            u1.this.L2(true);
        }
    }

    public u1(Kv kv) {
        y8.k.e(kv, "evacuationSite");
        this.A0 = new LinkedHashMap();
        this.B0 = kv;
        this.E0 = new HashMap<>();
        this.H0 = new a();
        this.I0 = new b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u1(Kv kv, Kv kv2) {
        this(kv2);
        y8.k.e(kv, "site");
        y8.k.e(kv2, "evacuationSite");
        O2(kv);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u1(Hashtable<String, String> hashtable, Kv kv) {
        this(kv);
        y8.k.e(hashtable, "barcodes");
        y8.k.e(kv, "evacuationSite");
        N2(hashtable);
    }

    private final void F2(List<k.a> list) {
        Context A = A();
        if (A == null) {
            return;
        }
        ((GridView) this.f306w0.findViewById(g5.h.B)).setAdapter((ListAdapter) new c6.k(A, B2()));
    }

    private final void G2() {
        com.groboot.mdaemergency.async.d.v().E(String.valueOf(E2().key), new b.InterfaceC0098b() { // from class: f6.t1
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                u1.H2(u1.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(u1 u1Var, b.a aVar) {
        TextView textView;
        String str;
        y8.k.e(u1Var, "this$0");
        if (aVar.f7614b) {
            Object i10 = new com.google.gson.e().i(aVar.f7616d, Answer.class);
            y8.k.d(i10, "Gson().fromJson(it.jsonData, Answer::class.java)");
            Answer answer = (Answer) i10;
            if (answer.getResult() != null) {
                if (!(answer.getResult().length() == 0) && !answer.getResult().equals("null") && !answer.getResult().equals("{}")) {
                    try {
                        Object j10 = new com.google.gson.e().j(answer.getResult(), Hashtable.class);
                        y8.k.d(j10, "Gson().fromJson<Hashtabl…t, Hashtable::class.java)");
                        u1Var.N2((Hashtable) j10);
                        u1Var.x2();
                        return;
                    } catch (Exception e10) {
                        e10.toString();
                        textView = (TextView) u1Var.f306w0.findViewById(g5.h.P);
                        str = "נתונים לא תקינים";
                    }
                }
            }
            textView = (TextView) u1Var.f306w0.findViewById(g5.h.P);
            str = "לא נמצאו בדיקות באתר";
            textView.setText(str);
            ((Button) u1Var.f306w0.findViewById(g5.h.f9825g)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(u1 u1Var, View view) {
        y8.k.e(u1Var, "this$0");
        u1Var.w2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J2() {
        ArrayList<DeliveryObject> arrayList = new ArrayList<>();
        List<k.a> B2 = B2();
        ArrayList<k.a> arrayList2 = new ArrayList();
        for (Object obj : B2) {
            if (((k.a) obj).a()) {
                arrayList2.add(obj);
            }
        }
        for (k.a aVar : arrayList2) {
            UUID randomUUID = UUID.randomUUID();
            Hashtable<String, String> D2 = D2();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : D2.entrySet()) {
                if (entry.getValue().equals(aVar.c())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList3 = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList3.add(new DeliveryObject((String) ((Map.Entry) it.next()).getKey(), A2().key, 1, randomUUID));
            }
            arrayList.addAll(arrayList3);
        }
        ((TextView) this.f306w0.findViewById(g5.h.P)).setText(Html.fromHtml("דווחו " + arrayList.size() + " ברקודים למסירה מ" + ((Object) w6.l0.K()) + ((Object) E2().value) + ((Object) w6.l0.K()) + " אל - " + ((Object) this.B0.value) + ((Object) w6.l0.K()) + "האם לדווח?"));
        com.groboot.mdaemergency.async.d.v().o0(arrayList, false, new b.InterfaceC0098b() { // from class: f6.s1
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar2) {
                u1.K2(u1.this, aVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(u1 u1Var, b.a aVar) {
        y8.k.e(u1Var, "this$0");
        Toast.makeText(u1Var.A(), aVar.f7614b ? "בוצע בהצלחה" : "נסה שנית", 0).show();
        if (aVar.f7614b) {
            u1Var.w2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2() {
        androidx.fragment.app.j t10 = t();
        y8.k.b(t10);
        t10.d0().Z0();
    }

    private final void x2() {
        for (Map.Entry<String, String> entry : D2().entrySet()) {
            HashMap<String, Integer> z22 = z2();
            String value = entry.getValue();
            Integer num = z2().get(entry.getValue());
            int i10 = 1;
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            z22.put(value, Integer.valueOf(i10));
        }
        HashMap<String, Integer> hashMap = this.E0;
        ArrayList arrayList = new ArrayList(hashMap.size());
        for (Map.Entry<String, Integer> entry2 : hashMap.entrySet()) {
            arrayList.add(new k.a(entry2.getKey(), entry2.getValue().intValue(), false, 4, null));
        }
        M2(arrayList);
        F2(B2());
    }

    public final Kv A2() {
        return this.B0;
    }

    public final List<k.a> B2() {
        List<k.a> list = this.C0;
        if (list != null) {
            return list;
        }
        y8.k.o("listObjects");
        return null;
    }

    public final AdapterView.OnItemClickListener C2() {
        return this.H0;
    }

    public final Hashtable<String, String> D2() {
        Hashtable<String, String> hashtable = this.D0;
        if (hashtable != null) {
            return hashtable;
        }
        y8.k.o("openBarcodes");
        return null;
    }

    public final Kv E2() {
        Kv kv = this.G0;
        if (kv != null) {
            return kv;
        }
        y8.k.o("site");
        return null;
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public /* synthetic */ void I0() {
        super.I0();
        s2();
    }

    public final void L2(boolean z10) {
        this.F0 = z10;
    }

    public final void M2(List<k.a> list) {
        y8.k.e(list, "<set-?>");
        this.C0 = list;
    }

    public final void N2(Hashtable<String, String> hashtable) {
        y8.k.e(hashtable, "<set-?>");
        this.D0 = hashtable;
    }

    public final void O2(Kv kv) {
        y8.k.e(kv, "<set-?>");
        this.G0 = kv;
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.send_barcode_to_site_fragment);
        View view = this.f306w0;
        ((GridView) view.findViewById(g5.h.B)).setOnItemClickListener(C2());
        ((Button) view.findViewById(g5.h.f9825g)).setOnClickListener(this.I0);
        ((Button) view.findViewById(g5.h.f9819a)).setOnClickListener(new View.OnClickListener() { // from class: f6.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                u1.I2(u1.this, view2);
            }
        });
        if (this.D0 == null) {
            G2();
        } else {
            x2();
        }
    }

    @Override // a6.a
    public void o2() {
    }

    public void s2() {
        this.A0.clear();
    }

    public final boolean y2() {
        return this.F0;
    }

    public final HashMap<String, Integer> z2() {
        return this.E0;
    }
}
