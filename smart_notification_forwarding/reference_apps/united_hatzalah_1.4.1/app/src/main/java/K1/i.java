package K1;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f1092a = new CopyOnWriteArrayList();

    public static Q1.c a(String str) {
        boolean startsWith;
        Iterator it = f1092a.iterator();
        while (it.hasNext()) {
            Q1.c cVar = (Q1.c) it.next();
            synchronized (cVar) {
                startsWith = str.toLowerCase(Locale.US).startsWith("android-keystore://");
            }
            if (startsWith) {
                return cVar;
            }
        }
        throw new GeneralSecurityException(e0.a.d("No KMS client does support: ", str));
    }
}
