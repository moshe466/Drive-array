package u7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f extends a {
    @Override // u7.a
    public void b(com.google.gson.n nVar) {
        try {
            int c10 = nVar.B("returnCode").c();
            if (c10 != 0) {
                a(c10, nVar.B("errorMsg").s());
                return;
            }
            ArrayList arrayList = new ArrayList();
            com.google.gson.h C = nVar.C("users");
            if (C != null) {
                Iterator<com.google.gson.k> it = C.iterator();
                while (it.hasNext()) {
                    com.google.gson.n g10 = it.next().g();
                    arrayList.add(new v7.d(g10.B("userId").s(), j7.a.valueOf(g10.B("status").s()), g10.B("lastSeen").l()));
                }
            }
            d(arrayList);
        } catch (Exception e10) {
            a(1, e10.getMessage());
        }
    }

    public abstract void d(List<v7.d> list);
}
