package c1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.github.barteksc.pdfviewer.PDFView;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private PDFView f4373a;

    public a(PDFView pDFView) {
        this.f4373a = pDFView;
    }

    private void b(int i10) {
        this.f4373a.v(i10);
    }

    private void c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        Context context = this.f4373a.getContext();
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No activity found for URI: ");
        sb2.append(str);
    }

    @Override // c1.b
    public void a(e1.a aVar) {
        String c10 = aVar.a().c();
        Integer b10 = aVar.a().b();
        if (c10 != null && !c10.isEmpty()) {
            c(c10);
        } else if (b10 != null) {
            b(b10.intValue());
        }
    }
}
