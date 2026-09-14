package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;

/* loaded from: classes.dex */
class c extends AsyncTask<Void, Void, Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4612a = false;

    /* renamed from: b, reason: collision with root package name */
    private PDFView f4613b;

    /* renamed from: c, reason: collision with root package name */
    private PdfiumCore f4614c;

    /* renamed from: d, reason: collision with root package name */
    private String f4615d;

    /* renamed from: e, reason: collision with root package name */
    private g1.a f4616e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f4617f;

    /* renamed from: g, reason: collision with root package name */
    private f f4618g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g1.a aVar, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.f4616e = aVar;
        this.f4617f = iArr;
        this.f4613b = pDFView;
        this.f4615d = str;
        this.f4614c = pdfiumCore;
    }

    private Size b() {
        return new Size(this.f4613b.getWidth(), this.f4613b.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Throwable doInBackground(Void... voidArr) {
        try {
            this.f4618g = new f(this.f4614c, this.f4616e.a(this.f4613b.getContext(), this.f4614c, this.f4615d), this.f4613b.getPageFitPolicy(), b(), this.f4617f, this.f4613b.t(), this.f4613b.getSpacingPx());
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Throwable th) {
        if (th != null) {
            this.f4613b.A(th);
        } else {
            if (this.f4612a) {
                return;
            }
            this.f4613b.z(this.f4618g);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.f4612a = true;
    }
}
