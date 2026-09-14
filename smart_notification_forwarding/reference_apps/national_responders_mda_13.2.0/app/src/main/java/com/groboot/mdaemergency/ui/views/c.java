package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class c extends ArrayAdapter<Kv> implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    boolean f8438f;

    /* renamed from: g, reason: collision with root package name */
    String f8439g;

    /* renamed from: h, reason: collision with root package name */
    a f8440h;

    /* renamed from: i, reason: collision with root package name */
    boolean f8441i;

    /* loaded from: classes.dex */
    public interface a {
        void h(Kv kv);
    }

    public c(Context context, KvTable kvTable, String str, boolean z10, a aVar) {
        super(context, R.layout.ksv_item, kvTable);
        this.f8438f = z10;
        this.f8439g = str;
        this.f8440h = aVar;
    }

    public void a(boolean z10) {
        this.f8441i = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            java.lang.Object r5 = r4.getItem(r5)
            com.groboot.mdaemergency.models.Kv r5 = (com.groboot.mdaemergency.models.Kv) r5
            boolean r7 = com.groboot.mdaemergency.ui.views.e.p2(r5)
            if (r6 != 0) goto L24
            android.content.Context r6 = r4.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            boolean r0 = r4.f8441i
            if (r0 == 0) goto L1c
            r0 = 2131492992(0x7f0c0080, float:1.8609452E38)
            goto L1f
        L1c:
            r0 = 2131492991(0x7f0c007f, float:1.860945E38)
        L1f:
            r1 = 0
            android.view.View r6 = r6.inflate(r0, r1)
        L24:
            int r0 = r5.key
            r1 = -999(0xfffffffffffffc19, float:NaN)
            r2 = 2131296781(0x7f09020d, float:1.8211488E38)
            if (r0 != r1) goto L55
            java.lang.String r0 = r5.value
            java.lang.String r1 = "אחר"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L55
            android.view.View r0 = r6.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "אחר: "
            java.lang.String r3 = w6.l0.N(r3)
            r1.append(r3)
            java.lang.String r3 = r5.value
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            goto L6b
        L55:
            java.lang.String r0 = r4.f8439g
            boolean r0 = w6.l0.l0(r0)
            if (r0 != 0) goto L70
            android.view.View r0 = r6.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r5.value
            java.lang.String r3 = r4.f8439g
            java.lang.String r1 = w6.l0.P(r1, r3)
        L6b:
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            goto L78
        L70:
            android.view.View r0 = r6.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r5.value
        L78:
            r0.setText(r1)
            java.lang.String r0 = ""
            r1 = 2131296779(0x7f09020b, float:1.8211484E38)
            if (r7 == 0) goto L97
            android.view.View r7 = r6.findViewById(r2)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r2 = 17
            r7.setGravity(r2)
        L8d:
            android.view.View r7 = r6.findViewById(r1)
            android.widget.TextView r7 = (android.widget.TextView) r7
        L93:
            r7.setText(r0)
            goto Lb3
        L97:
            boolean r7 = r4.f8438f
            if (r7 == 0) goto L8d
            android.view.View r7 = r6.findViewById(r1)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r5.key
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L93
        Lb3:
            com.groboot.mdaemergency.ui.views.c$a r7 = r4.f8440h
            if (r7 == 0) goto Lbd
            r6.setTag(r5)
            r6.setOnClickListener(r4)
        Lbd:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.groboot.mdaemergency.ui.views.c.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f8440h;
        if (aVar != null) {
            aVar.h((Kv) view.getTag());
        }
    }
}
