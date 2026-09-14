package com.groboot.mdaemergency.ui.fragments;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import com.groboot.mdaemergency.models.PDFFile;
import d1.e;
import il.org.mda.health.R;
import java.io.File;
import w6.h;

/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: b, reason: collision with root package name */
    PDFFile f8127b;

    /* renamed from: c, reason: collision with root package name */
    h f8128c;

    /* renamed from: g, reason: collision with root package name */
    Button f8132g;

    /* renamed from: j, reason: collision with root package name */
    Activity f8135j;

    /* renamed from: k, reason: collision with root package name */
    View f8136k;

    /* renamed from: l, reason: collision with root package name */
    c f8137l;

    /* renamed from: m, reason: collision with root package name */
    String f8138m = "";

    /* renamed from: a, reason: collision with root package name */
    PDFView f8126a = (PDFView) g(R.id.pdfView);

    /* renamed from: d, reason: collision with root package name */
    TextView f8129d = (TextView) g(R.id.tv_download);

    /* renamed from: e, reason: collision with root package name */
    TextView f8130e = (TextView) g(R.id.tv_download_error);

    /* renamed from: f, reason: collision with root package name */
    RelativeLayout f8131f = (RelativeLayout) g(R.id.rl_download);

    /* renamed from: h, reason: collision with root package name */
    LinearLayout f8133h = (LinearLayout) g(R.id.ll_percent);

    /* renamed from: i, reason: collision with root package name */
    ProgressBar f8134i = (ProgressBar) g(R.id.pb_download);

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.groboot.mdaemergency.ui.fragments.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0125b implements h.a {

        /* renamed from: com.groboot.mdaemergency.ui.fragments.b$b$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.h();
                b.this.l();
                b.this.f8138m = "";
            }
        }

        /* renamed from: com.groboot.mdaemergency.ui.fragments.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0126b implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8142f;

            RunnableC0126b(String str) {
                this.f8142f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.k(this.f8142f);
                b.this.f8138m = "";
            }
        }

        /* renamed from: com.groboot.mdaemergency.ui.fragments.b$b$c */
        /* loaded from: classes.dex */
        class c implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f8144f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f8145g;

            c(int i10, int i11) {
                this.f8144f = i10;
                this.f8145g = i11;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f8129d.setText(this.f8144f + "/" + this.f8145g);
            }
        }

        C0125b() {
        }

        @Override // w6.h.a
        public void a(h hVar, int i10, int i11) {
            b.this.f8135j.runOnUiThread(new c(i10, i11));
        }

        @Override // w6.h.a
        public void b(h hVar, String str) {
            b.this.f8135j.runOnUiThread(new RunnableC0126b(str));
        }

        @Override // w6.h.a
        public void c(h hVar) {
            b.this.f8135j.runOnUiThread(new a());
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void k(String str);
    }

    public b(Activity activity, View view, c cVar) {
        this.f8136k = view;
        this.f8135j = activity;
        this.f8137l = cVar;
        Button button = (Button) g(R.id.btn_try_again);
        this.f8132g = button;
        button.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f8138m = this.f8127b.url;
        m();
        this.f8129d.setText("0/100");
        h hVar = new h(this.f8127b.getLocalPath(), this.f8127b.url, true, f());
        this.f8128c = hVar;
        hVar.g();
    }

    private h.a f() {
        return new C0125b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f8131f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        this.f8131f.setVisibility(0);
        this.f8134i.setVisibility(8);
        this.f8133h.setVisibility(8);
        this.f8132g.setVisibility(0);
        this.f8130e.setText(str);
        this.f8129d.setText("");
    }

    private void m() {
        this.f8131f.setVisibility(0);
        this.f8134i.setVisibility(0);
        this.f8133h.setVisibility(0);
        this.f8132g.setVisibility(8);
        this.f8130e.setText("");
        this.f8129d.setText("");
    }

    @Override // d1.e
    public void a(int i10, int i11) {
        PDFFile pDFFile = this.f8127b;
        if (pDFFile == null) {
            return;
        }
        pDFFile.page = i10;
        c cVar = this.f8137l;
        Object[] objArr = new Object[3];
        String str = pDFFile.name;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i10);
        objArr[2] = Integer.valueOf(i11);
        cVar.k(String.format("%s %s / %s", objArr));
    }

    protected View g(int i10) {
        return this.f8136k.findViewById(i10);
    }

    public void i() {
        this.f8126a.I();
    }

    public void j(PDFFile pDFFile) {
        this.f8127b = pDFFile;
    }

    public void l() {
        PDFFile pDFFile = this.f8127b;
        if (pDFFile == null) {
            return;
        }
        this.f8137l.k(pDFFile.name);
        if (!this.f8127b.exist()) {
            m();
            e();
            return;
        }
        File file = new File(this.f8127b.getLocalPath());
        if (file.exists()) {
            h();
            this.f8126a.o(file).d(this.f8127b.page).f(this).e();
        } else {
            if (this.f8138m.equals(this.f8127b.url)) {
                return;
            }
            h();
            k("file not found!!\n\n" + this.f8127b.getLocalPath());
        }
    }
}
