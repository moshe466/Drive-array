package R1;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final A.n f2008a = new A.n(8);

    public static void a(K1.m mVar) {
        Integer num;
        K1.f fVar;
        ArrayList arrayList = new ArrayList();
        U1.a aVar = U1.a.f2331b;
        Iterator it = ((ConcurrentMap) mVar.f1102a).values().iterator();
        while (it.hasNext()) {
            for (K1.k kVar : (List) it.next()) {
                int ordinal = kVar.f1096d.ordinal();
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            fVar = K1.f.f1087e;
                        } else {
                            throw new IllegalStateException("Unknown key status");
                        }
                    } else {
                        fVar = K1.f.f1086d;
                    }
                } else {
                    fVar = K1.f.f1085c;
                }
                int i = kVar.f1098f;
                String str = kVar.f1099g;
                if (str.startsWith("type.googleapis.com/google.crypto.")) {
                    str = str.substring(34);
                }
                arrayList.add(new U1.b(fVar, i, str, kVar.f1097e.name()));
            }
        }
        K1.k kVar2 = (K1.k) mVar.f1104c;
        if (kVar2 != null) {
            num = Integer.valueOf(kVar2.f1098f);
        } else {
            num = null;
        }
        if (num != null) {
            try {
                int intValue = num.intValue();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    if (((U1.b) obj).f2334b == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            } catch (GeneralSecurityException e4) {
                throw new IllegalStateException(e4);
            }
        }
        Collections.unmodifiableList(arrayList);
    }
}
