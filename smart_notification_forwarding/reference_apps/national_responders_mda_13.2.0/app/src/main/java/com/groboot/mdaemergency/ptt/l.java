package com.groboot.mdaemergency.ptt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.ptt.b;
import com.groboot.mdaemergency.ptt.l;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ptt.s;
import com.groboot.mdaemergency.ui.views.EditTextDrawables;
import g5.e;
import il.org.mda.health.R;
import w6.l0;
import w6.r;
import w6.y;

/* loaded from: classes.dex */
public class l extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    b.h f7848e0;

    /* renamed from: f0, reason: collision with root package name */
    View f7849f0;

    /* renamed from: g0, reason: collision with root package name */
    ListView f7850g0;

    /* renamed from: h0, reason: collision with root package name */
    EditTextDrawables f7851h0;

    /* renamed from: i0, reason: collision with root package name */
    View f7852i0;

    /* renamed from: j0, reason: collision with root package name */
    com.groboot.mdaemergency.ptt.b f7853j0;

    /* renamed from: k0, reason: collision with root package name */
    String f7854k0 = "";

    /* renamed from: l0, reason: collision with root package name */
    b.g f7855l0;

    /* renamed from: m0, reason: collision with root package name */
    a6.f f7856m0;

    /* renamed from: n0, reason: collision with root package name */
    boolean f7857n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements s {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j() {
            l lVar = l.this;
            com.groboot.mdaemergency.ptt.b bVar = lVar.f7853j0;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            } else {
                lVar.U1();
            }
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void a(String str) {
            l lVar = l.this;
            b.g gVar = lVar.f7855l0;
            if (gVar != null) {
                gVar.b(str);
            } else {
                Toast.makeText(lVar.t(), str, 1).show();
            }
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public boolean b(com.groboot.mdaemergency.ptt.a aVar) {
            return false;
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void c(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void d(p.a0 a0Var, p.a0 a0Var2) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void e(w6.p pVar) {
            l.this.f7849f0.post(new Runnable() { // from class: com.groboot.mdaemergency.ptt.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.a.this.j();
                }
            });
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void f(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void g(w6.r rVar) {
            com.groboot.mdaemergency.ptt.b bVar = l.this.f7853j0;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void h(e.a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements b.f {

        /* loaded from: classes.dex */
        class a implements d.t {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f7860a;

            /* renamed from: com.groboot.mdaemergency.ptt.l$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0113a implements Runnable {
                RunnableC0113a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(l.this.t(), R.string.no_data, 1).show();
                    l.this.f7853j0.notifyDataSetChanged();
                }
            }

            a(String str) {
                this.f7860a = str;
            }

            @Override // com.groboot.mdaemergency.async.d.t
            public void a(y.a aVar) {
                try {
                    if (l.this.t() != null) {
                        throw null;
                    }
                    l.this.t().runOnUiThread(new RunnableC0113a());
                } catch (Exception unused) {
                }
            }

            @Override // com.groboot.mdaemergency.async.d.t
            public void b() {
            }
        }

        b() {
        }

        @Override // com.groboot.mdaemergency.ptt.b.f
        public void a(String str) {
            com.groboot.mdaemergency.async.d.v().F(str, new a(str));
        }
    }

    /* loaded from: classes.dex */
    class c implements EditTextDrawables.a {
        c() {
        }

        @Override // com.groboot.mdaemergency.ui.views.EditTextDrawables.a
        public void a(EditTextDrawables.a.EnumC0133a enumC0133a) {
            if (e.f7865a[enumC0133a.ordinal()] == 1 && l.this.f7851h0.length() > 0) {
                l.this.f7851h0.setText("");
                l.this.U1();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.length() > 1 || l.this.f7851h0.getTag() != null) {
                l.this.f7851h0.setTag(((Object) charSequence) + "");
                System.out.println("Text [" + ((Object) charSequence) + "]");
                com.groboot.mdaemergency.ptt.b bVar = l.this.f7853j0;
                if (bVar != null) {
                    bVar.a(charSequence.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7865a;

        static {
            int[] iArr = new int[EditTextDrawables.a.EnumC0133a.values().length];
            f7865a = iArr;
            try {
                iArr[EditTextDrawables.a.EnumC0133a.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public l() {
    }

    @SuppressLint({"ValidFragment"})
    public l(a6.f fVar) {
        this.f7856m0 = fVar;
    }

    private void V1(w6.r rVar) {
        try {
            if (t() == null) {
                return;
            }
            com.groboot.mdaemergency.ptt.b bVar = this.f7853j0;
            if (bVar != null) {
                this.f7854k0 = bVar.f7800m;
            }
            com.groboot.mdaemergency.ptt.b bVar2 = new com.groboot.mdaemergency.ptt.b(t(), rVar, this.f7855l0, this.f7848e0, a2(), this.f7856m0);
            this.f7853j0 = bVar2;
            this.f7850g0.setAdapter((ListAdapter) bVar2);
            if (l0.l0(this.f7854k0)) {
                return;
            }
            this.f7853j0.a(this.f7854k0);
            this.f7854k0 = "";
        } catch (Exception unused) {
        }
    }

    private void W1(w6.s sVar) {
        this.f7850g0.setAdapter((ListAdapter) new com.groboot.mdaemergency.ptt.c(t(), sVar, this.f7855l0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(w6.r rVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onContactLoad type:");
        sb2.append(this.f7848e0);
        V1(rVar);
    }

    private r.b Y1() {
        return new r.b() { // from class: x5.e
            @Override // w6.r.b
            public final void a(r rVar) {
                com.groboot.mdaemergency.ptt.l.this.X1(rVar);
            }
        };
    }

    private s Z1() {
        return new a();
    }

    private b.f a2() {
        return new b();
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ptt_contacts, viewGroup, false);
        this.f7849f0 = inflate;
        this.f7850g0 = (ListView) inflate.findViewById(R.id.lv_contacts);
        this.f7851h0 = (EditTextDrawables) this.f7849f0.findViewById(R.id.et_search);
        View findViewById = this.f7849f0.findViewById(R.id.ll_search);
        this.f7852i0 = findViewById;
        b.h hVar = this.f7848e0;
        findViewById.setVisibility((hVar == b.h.AllContacts || hVar == b.h.Groups) ? 0 : 8);
        this.f7851h0.setDrawableClickListener(new c());
        this.f7851h0.addTextChangedListener(new d());
        if (this.f7857n0) {
            this.f7857n0 = false;
        }
        return this.f7849f0;
    }

    public void U1() {
        com.groboot.mdaemergency.ptt.d dVar;
        w6.r rVar;
        int i10;
        if (t() == null) {
            this.f7857n0 = true;
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initAdapter type:");
        sb2.append(this.f7848e0);
        p c02 = p.c0();
        if (c02 == null || (dVar = c02.f7903c) == null) {
            return;
        }
        b.h hVar = this.f7848e0;
        if (hVar == b.h.Groups) {
            rVar = dVar.f7826c;
            if (rVar == null) {
                return;
            } else {
                i10 = 2;
            }
        } else if (hVar == b.h.LastUsers) {
            W1(dVar.f7827d);
            return;
        } else {
            if (hVar == b.h.Favorites) {
                dVar.l(Y1());
                return;
            }
            rVar = dVar.f7826c;
            if (rVar == null) {
                return;
            } else {
                i10 = 11;
            }
        }
        rVar.s(i10, Y1());
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        p c02 = p.c0();
        if (c02 == null) {
            b.g gVar = this.f7855l0;
            if (gVar != null) {
                gVar.b("manager is null");
                return;
            }
            return;
        }
        c02.E(s.a.fragment, Z1());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PTTFragment_Contacts. onResume type:");
        sb2.append(this.f7848e0);
        View view = this.f7852i0;
        b.h hVar = this.f7848e0;
        view.setVisibility((hVar == b.h.AllContacts || hVar == b.h.Groups) ? 0 : 8);
        U1();
    }

    public void b2(b.g gVar) {
        this.f7855l0 = gVar;
    }

    public void c2(b.h hVar) {
        this.f7848e0 = hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return "PTTFragment type:" + this.f7848e0;
    }

    @Override // androidx.fragment.app.Fragment
    public void z0(Fragment fragment) {
        super.z0(fragment);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAttachFragment. type:");
        sb2.append(this.f7848e0);
    }
}
