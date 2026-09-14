package com.groboot.mdaemergency.ptt;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.groboot.mdaemergency.async.FloatViewService;
import com.groboot.mdaemergency.ptt.b;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.views.ViewPager;
import il.org.mda.health.R;
import w6.l0;

/* loaded from: classes.dex */
public class j extends a6.a implements View.OnClickListener {
    private ViewPager A0;
    TextView B0;
    private d C0;
    private TextView[] D0;
    private View[] E0;
    a6.f G0;
    int F0 = 0;
    boolean H0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ViewPager.a {
        a() {
        }

        @Override // com.groboot.mdaemergency.ui.views.ViewPager.a
        public void a(int i10) {
            j.this.F0 = i10;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("base onPageSelected. position:");
            sb2.append(i10);
            j.this.r2();
        }
    }

    /* loaded from: classes.dex */
    class b implements p.b0 {
        b() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(p pVar) {
            j.this.B0.setText("User: " + pVar.f7913m);
            if (j.this.H0) {
                pVar.c1(pVar.f7909i);
                j.this.H0 = false;
            }
            com.groboot.mdaemergency.ptt.d dVar = pVar.f7903c;
            if (dVar != null) {
                dVar.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.g {
        c(j jVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.b.g
        public void a(w6.p pVar) {
            p.c0().d1(pVar);
        }

        @Override // com.groboot.mdaemergency.ptt.b.g
        public void b(String str) {
        }
    }

    /* loaded from: classes.dex */
    public class d extends c6.h {
        public d(w wVar) {
            super(wVar);
        }

        @Override // c6.h
        public Fragment a(int i10) {
            b.h hVar;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("base getItem. position:");
            sb2.append(i10);
            l lVar = new l(j.this.G0);
            lVar.b2(j.this.t2());
            if (i10 == 0) {
                hVar = b.h.AllContacts;
            } else if (i10 == 1) {
                hVar = b.h.Groups;
            } else {
                if (i10 != 2) {
                    if (i10 == 3) {
                        hVar = b.h.Favorites;
                    }
                    return lVar;
                }
                hVar = b.h.LastUsers;
            }
            lVar.c2(hVar);
            return lVar;
        }
    }

    public j() {
    }

    @SuppressLint({"ValidFragment"})
    public j(a6.f fVar) {
        this.G0 = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2() {
        for (TextView textView : this.D0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(textView.getTag());
            sb2.append("");
            int i10 = this.F0 == l0.U(sb2.toString()) ? 1 : 0;
            textView.setBackground(i10 != 0 ? androidx.core.content.a.f(A(), w6.m.m() == com.groboot.mdaemergency.enums.a.POC ? R.drawable.tab_select_poc : R.drawable.tab_select) : null);
            textView.setTypeface(Typeface.defaultFromStyle(i10));
        }
    }

    private ViewPager.a s2() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.g t2() {
        return new c(this);
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        l(false);
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        l(true);
        FloatViewService.l(t());
        p.d0(A(), new b());
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_ptt);
        this.C0 = new d(t().d0());
        ViewPager viewPager = (ViewPager) k2(R.id.container);
        this.A0 = viewPager;
        viewPager.setAdapter(this.C0);
        this.A0.a(s2());
        this.D0 = new TextView[]{(TextView) k2(R.id.tv_tab1), (TextView) k2(R.id.tv_tab2), (TextView) k2(R.id.tv_tab3), (TextView) k2(R.id.tv_tab4)};
        this.E0 = new View[]{k2(R.id.v_separator1), k2(R.id.v_separator2), k2(R.id.v_separator3)};
        for (TextView textView : this.D0) {
            textView.setOnClickListener(this);
        }
        this.B0 = (TextView) k2(R.id.tv_description);
        this.A0.setCurrentItem(0);
        this.F0 = 0;
        g(false);
        q(false);
        J(false);
        l(true);
        r2();
        a("PTT");
    }

    @Override // a6.a
    public void o2() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int U = l0.U(view.getTag() + "");
        this.F0 = U;
        this.A0.setCurrentItem(U);
    }

    public void u2() {
        this.H0 = true;
    }
}
