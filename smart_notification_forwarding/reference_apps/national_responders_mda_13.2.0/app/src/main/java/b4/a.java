package b4;

import b4.b;
import c4.c;
import c4.d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final b.c f4111a;

    public a(b.c cVar) {
        this.f4111a = cVar;
    }

    public boolean a() {
        File[] b10 = this.f4111a.b();
        File[] a10 = this.f4111a.a();
        if (b10 == null || b10.length <= 0) {
            return a10 != null && a10.length > 0;
        }
        return true;
    }

    public void b(c cVar) {
        cVar.remove();
    }

    public void c(List<c> list) {
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public List<c> d() {
        s3.b.f().b("Checking for crash reports...");
        File[] b10 = this.f4111a.b();
        File[] a10 = this.f4111a.a();
        LinkedList linkedList = new LinkedList();
        if (b10 != null) {
            for (File file : b10) {
                s3.b.f().b("Found crash report " + file.getPath());
                linkedList.add(new d(file));
            }
        }
        if (a10 != null) {
            for (File file2 : a10) {
                linkedList.add(new c4.b(file2));
            }
        }
        if (linkedList.isEmpty()) {
            s3.b.f().b("No reports found.");
        }
        return linkedList;
    }
}
