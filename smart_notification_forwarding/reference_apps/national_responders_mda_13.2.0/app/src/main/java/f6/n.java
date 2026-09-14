package f6;

import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.EligibilityCheck;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.ui.views.SpinnerEditText;
import il.org.mda.health.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rb.c;
import w6.m0;

/* loaded from: classes.dex */
public final class n extends a6.a implements c.b {
    public v6.a B0;
    private EligibilityCheck C0;
    private boolean E0;
    public Map<Integer, View> A0 = new LinkedHashMap();
    private final String D0 = "EligibilityCheckFragmen";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(n nVar) {
        y8.k.e(nVar, "this$0");
        if (nVar.E0) {
            return;
        }
        nVar.P2("", R.color.red_buttons);
        nVar.D2().f();
    }

    private final boolean B2() {
        if (com.groboot.mdaemergency.a.l(t())) {
            return true;
        }
        androidx.fragment.app.j t10 = t();
        y8.k.b(t10);
        androidx.core.app.b.n(t10, new String[]{"android.permission.CAMERA"}, 1);
        return false;
    }

    private final void C2(boolean z10) {
        Button button;
        int i10;
        if (z10) {
            button = (Button) this.f306w0.findViewById(g5.h.f9825g);
            i10 = 0;
        } else {
            button = (Button) this.f306w0.findViewById(g5.h.f9825g);
            i10 = 4;
        }
        button.setVisibility(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(View view, n nVar, View view2) {
        y8.k.e(nVar, "this$0");
        ((RelativeLayout) view.findViewById(g5.h.L)).setVisibility(0);
        ((LinearLayout) view.findViewById(g5.h.C)).setVisibility(4);
        if (nVar.B2()) {
            nVar.D2().f();
        }
        nVar.L2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(View view, n nVar, View view2) {
        y8.k.e(nVar, "this$0");
        ((RelativeLayout) view.findViewById(g5.h.L)).setVisibility(4);
        ((LinearLayout) view.findViewById(g5.h.C)).setVisibility(0);
        ((Button) view.findViewById(g5.h.f9825g)).setVisibility(0);
        nVar.D2().h();
        nVar.L2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(View view, n nVar, View view2) {
        y8.k.e(nVar, "this$0");
        w6.l0.h0(view2);
        int i10 = g5.h.f9844z;
        Editable text = ((AppCompatEditText) view.findViewById(i10)).getText();
        if (!(text == null || text.length() == 0)) {
            int i11 = g5.h.O;
            if (((SpinnerEditText) view.findViewById(i11)).e()) {
                int i12 = g5.h.A;
                Editable text2 = ((AppCompatEditText) view.findViewById(i12)).getText();
                if (!(text2 == null || text2.length() == 0)) {
                    nVar.y2(new EligibilityCheck(String.valueOf(((AppCompatEditText) view.findViewById(i10)).getText()), ((SpinnerEditText) view.findViewById(i11)).getSelectedValue().key, String.valueOf(((AppCompatEditText) view.findViewById(i12)).getText())));
                    return;
                }
            }
        }
        w6.l0.M0("השלם את כל השדות");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(final n nVar, final View view, View view2) {
        y8.k.e(nVar, "this$0");
        nVar.P2("", R.color.red_buttons);
        EligibilityCheck eligibilityCheck = nVar.C0;
        if (eligibilityCheck == null) {
            return;
        }
        com.groboot.mdaemergency.async.d.v().r(eligibilityCheck, new b.InterfaceC0098b() { // from class: f6.l
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                n.J2(n.this, view, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(n nVar, View view, b.a aVar) {
        y8.k.e(nVar, "this$0");
        if (aVar.f7614b) {
            nVar.P2("נופק בהצלחה", R.color.green_buttons);
        } else {
            nVar.P2("שגיאה בניפוק, נסה שנית", R.color.red_buttons);
            ((Button) view.getRootView().findViewById(g5.h.f9826h)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(n nVar, View view) {
        y8.k.e(nVar, "this$0");
        nVar.L2();
        nVar.C2(true);
    }

    private final void L2() {
        this.E0 = true;
        View view = this.f306w0;
        ((Button) view.findViewById(g5.h.f9826h)).setVisibility(4);
        ((TextView) view.findViewById(g5.h.Y)).setVisibility(4);
        ((AppCompatEditText) view.findViewById(g5.h.f9844z)).setText("");
        ((SpinnerEditText) view.findViewById(g5.h.O)).setEmptyValue(false);
        ((AppCompatEditText) view.findViewById(g5.h.A)).setText("");
        if (((RelativeLayout) view.findViewById(g5.h.L)).getVisibility() == 0) {
            D2().f();
        }
    }

    private final void M2(String str, boolean z10) {
        Button button = (Button) this.f306w0.findViewById(g5.h.f9826h);
        button.setText(str);
        button.setBackgroundColor(androidx.core.content.a.d(button.getContext(), z10 ? R.color.green_buttons : R.color.red_buttons));
        button.setEnabled(z10);
        button.setVisibility(0);
        ((TextView) this.f306w0.findViewById(g5.h.Y)).setVisibility(4);
    }

    private final void P2(String str, int i10) {
        TextView textView = (TextView) this.f306w0.findViewById(g5.h.Y);
        textView.setText(str);
        textView.setTextColor(androidx.core.content.a.d(textView.getContext(), i10));
        textView.setVisibility(0);
        ((Button) this.f306w0.findViewById(g5.h.f9826h)).setVisibility(4);
    }

    private final void y2(EligibilityCheck eligibilityCheck) {
        this.C0 = eligibilityCheck;
        P2("בודק זכאות...", R.color.blue_1);
        y8.k.j("qrCode:", eligibilityCheck.getQrCode());
        com.groboot.mdaemergency.async.d.v().j(this.C0, new b.InterfaceC0098b() { // from class: f6.k
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                n.z2(n.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(final n nVar, b.a aVar) {
        y8.k.e(nVar, "this$0");
        String str = nVar.D0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("success: ");
        sb2.append(aVar.f7614b);
        sb2.append("ErrorMsg: ");
        sb2.append((Object) aVar.f7617e);
        if (!aVar.f7614b) {
            String str2 = aVar.f7617e;
            String str3 = (str2 == null || str2.equals("null")) ? "בעיה בבדיקת זכאות, נסה שנית" : aVar.f7617e;
            y8.k.d(str3, "error");
            nVar.P2(str3, R.color.red_buttons);
            nVar.E0 = false;
            new Handler().postDelayed(new Runnable() { // from class: f6.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.A2(n.this);
                }
            }, TimeUnit.SECONDS.toMillis(2L));
            return;
        }
        EligibilityCheck eligibilityCheck = (EligibilityCheck) new com.google.gson.e().i(aVar.e("Result"), EligibilityCheck.class);
        if (eligibilityCheck == null) {
            return;
        }
        nVar.E2();
        y8.k.j("answer: ", aVar.e("Result"));
        nVar.N2(eligibilityCheck);
        nVar.M2("ניתן לנפק", true);
        nVar.C2(false);
    }

    public final v6.a D2() {
        v6.a aVar = this.B0;
        if (aVar != null) {
            return aVar;
        }
        y8.k.o("mScannerView");
        return null;
    }

    public final String E2() {
        return this.D0;
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public /* synthetic */ void I0() {
        super.I0();
        x2();
    }

    public final void N2(EligibilityCheck eligibilityCheck) {
        this.C0 = eligibilityCheck;
    }

    public final void O2(v6.a aVar) {
        y8.k.e(aVar, "<set-?>");
        this.B0 = aVar;
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        if (D2() != null) {
            D2().h();
        }
    }

    @Override // rb.c.b
    public void d(rb.b bVar) {
        if (t() == null) {
            return;
        }
        D2().l(this);
        if (bVar == null) {
            return;
        }
        E2();
        y8.k.j("handleResult: ", bVar.b());
        w6.m0.c(t(), m0.d.bip);
        w6.l0.X0(t(), 200);
        String b10 = bVar.b();
        y8.k.d(b10, "it.contents");
        y2(new EligibilityCheck(b10));
        D2().h();
    }

    @Override // a6.a
    protected void n2() {
        List<rb.a> b10;
        l2(R.layout.fragment_eligibility_check);
        final View view = this.f306w0;
        O2(new v6.a(view.getContext()));
        ((RelativeLayout) view.findViewById(g5.h.L)).addView(D2());
        v6.a D2 = D2();
        D2.setResultHandler(this);
        b10 = m8.p.b(rb.a.f13841p);
        D2.setFormats(b10);
        D2.f();
        SpinnerEditText spinnerEditText = (SpinnerEditText) view.findViewById(g5.h.O);
        KvTable kvTable = new KvTable();
        for (int i10 = 2009; i10 < 2019; i10++) {
            kvTable.add((KvTable) new Kv(i10, String.valueOf(i10)));
        }
        spinnerEditText.setKVTableDataSource(kvTable);
        ((Button) view.findViewById(g5.h.E)).setOnClickListener(new View.OnClickListener() { // from class: f6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.F2(view, this, view2);
            }
        });
        ((Button) view.findViewById(g5.h.F)).setOnClickListener(new View.OnClickListener() { // from class: f6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.G2(view, this, view2);
            }
        });
        ((Button) view.findViewById(g5.h.f9825g)).setOnClickListener(new View.OnClickListener() { // from class: f6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.H2(view, this, view2);
            }
        });
        ((Button) view.findViewById(g5.h.f9826h)).setOnClickListener(new View.OnClickListener() { // from class: f6.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.I2(n.this, view, view2);
            }
        });
        ((Button) view.findViewById(g5.h.f9823e)).setOnClickListener(new View.OnClickListener() { // from class: f6.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.K2(n.this, view2);
            }
        });
    }

    @Override // a6.a
    public void o2() {
    }

    public void x2() {
        this.A0.clear();
    }
}
