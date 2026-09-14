package g1;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;

/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private File f9751a;

    public b(File file) {
        this.f9751a = file;
    }

    @Override // g1.a
    public com.shockwave.pdfium.a a(Context context, PdfiumCore pdfiumCore, String str) {
        return pdfiumCore.j(ParcelFileDescriptor.open(this.f9751a, 268435456), str);
    }
}
