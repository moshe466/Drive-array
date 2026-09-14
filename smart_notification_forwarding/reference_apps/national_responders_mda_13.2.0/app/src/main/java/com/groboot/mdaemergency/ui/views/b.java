package com.groboot.mdaemergency.ui.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.Message;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.groboot.mdaemergency.alwaysOn.b {

    /* renamed from: g, reason: collision with root package name */
    WebViewMDA f8426g;

    /* renamed from: h, reason: collision with root package name */
    ProgressBar f8427h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<String> f8428i;

    /* renamed from: j, reason: collision with root package name */
    Context f8429j;

    /* renamed from: k, reason: collision with root package name */
    View f8430k;

    /* renamed from: l, reason: collision with root package name */
    TextView f8431l;

    /* renamed from: m, reason: collision with root package name */
    ConstraintLayout f8432m;

    /* renamed from: n, reason: collision with root package name */
    int f8433n;

    /* renamed from: o, reason: collision with root package name */
    ImageView f8434o;

    /* renamed from: p, reason: collision with root package name */
    ImageView f8435p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements WebViewMDA.i {
        a() {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void a(String str) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void b() {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.i
        public void c() {
            if (b.this.f8428i.size() == 1) {
                b.this.a();
                return;
            }
            b bVar = b.this;
            bVar.f8428i.remove(bVar.f8433n);
            b bVar2 = b.this;
            int i10 = bVar2.f8433n;
            if (i10 > 0) {
                i10--;
            }
            bVar2.f8433n = i10;
            bVar2.l(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.groboot.mdaemergency.ui.views.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0134b implements d.w {
        C0134b() {
        }

        @Override // com.groboot.mdaemergency.async.d.w
        public void a(String str) {
            b.this.f8427h.setVisibility(8);
            Toast.makeText(b.this.getContext(), str, 0).show();
        }

        @Override // com.groboot.mdaemergency.async.d.w
        public void b(Message message) {
            b.this.f8427h.setVisibility(8);
            if (message != null) {
                b.this.f8426g.setMessage(message);
            }
        }
    }

    public b(Context context, com.groboot.mdaemergency.alwaysOn.d dVar) {
        super(context, R.layout.external_message, dVar);
        this.f8428i = new ArrayList<>();
        this.f8429j = context;
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        int i10 = this.f8433n + 1;
        this.f8433n = i10;
        l(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        int i10 = this.f8433n - 1;
        this.f8433n = i10;
        l(i10);
    }

    private void k() {
        this.f8431l.setText((this.f8433n + 1) + "/" + this.f8428i.size());
    }

    private void m(String str) {
        this.f8427h.setVisibility(0);
        com.groboot.mdaemergency.async.d.v().B(getContext(), str, new C0134b());
    }

    public void e(List list) {
        this.f8428i.addAll(list);
        int size = list.size() - 1;
        this.f8433n = size;
        l(size);
    }

    public void f(String str) {
        this.f8428i.add(str);
        int size = this.f8428i.size() - 1;
        this.f8433n = size;
        l(size);
    }

    public void g() {
        View inflate = LinearLayout.inflate(this.f8429j, R.layout.external_message, null);
        this.f8430k = inflate;
        inflate.setLayoutParams(new ConstraintLayout.b(-2, -2));
        addView(this.f8430k);
        this.f8426g = (WebViewMDA) this.f8430k.findViewById(R.id.webview);
        this.f8427h = (ProgressBar) this.f8430k.findViewById(R.id.progress_bar);
        this.f8431l = (TextView) this.f8430k.findViewById(R.id.tv_numOfMessage);
        this.f8432m = (ConstraintLayout) this.f8430k.findViewById(R.id.ll_stackUtils);
        this.f8434o = (ImageView) this.f8430k.findViewById(R.id.img_next);
        this.f8435p = (ImageView) this.f8430k.findViewById(R.id.img_back);
        this.f8430k.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: v6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.groboot.mdaemergency.ui.views.b.this.h(view);
            }
        });
        this.f8434o.setOnClickListener(new View.OnClickListener() { // from class: v6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.groboot.mdaemergency.ui.views.b.this.i(view);
            }
        });
        this.f8435p.setOnClickListener(new View.OnClickListener() { // from class: v6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.groboot.mdaemergency.ui.views.b.this.j(view);
            }
        });
        this.f8426g.setActionHandler(new a());
    }

    public void l(int i10) {
        String str = this.f8428i.get(i10);
        this.f8432m.setVisibility(this.f8428i.size() > 1 ? 0 : 8);
        this.f8434o.setVisibility(i10 < this.f8428i.size() - 1 ? 0 : 4);
        this.f8435p.setVisibility(i10 <= 0 ? 4 : 0);
        k();
        m(str);
    }

    public void setMessage(String str) {
        m(str);
        this.f8432m.setVisibility(8);
    }
}
