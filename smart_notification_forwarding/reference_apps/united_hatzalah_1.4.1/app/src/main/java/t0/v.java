package t0;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6389a;

    public v(ArrayList arrayList) {
        this.f6389a = arrayList;
    }

    public final WebResourceResponse a(Uri uri) {
        WebResourceResponse webResourceResponse;
        ArrayList arrayList = this.f6389a;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            webResourceResponse = null;
            r3 = null;
            r3 = null;
            r3 = null;
            t tVar = null;
            if (i >= size) {
                break;
            }
            Object obj = arrayList.get(i);
            i++;
            u uVar = (u) obj;
            uVar.getClass();
            String str = uVar.f6387c;
            if ((!uri.getScheme().equals("http") || uVar.f6385a) && ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getAuthority().equals(uVar.f6386b) && uri.getPath().startsWith(str))) {
                tVar = uVar.f6388d;
            }
            if (tVar != null && (webResourceResponse = tVar.handle(uri.getPath().replaceFirst(str, ""))) != null) {
                break;
            }
        }
        return webResourceResponse;
    }
}
