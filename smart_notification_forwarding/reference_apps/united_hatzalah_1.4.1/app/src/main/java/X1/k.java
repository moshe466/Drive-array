package X1;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class k extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f2615a;

    public k(l lVar) {
        this.f2615a = lVar;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        l lVar = this.f2615a;
        try {
            i iVar = i.f2613c;
            Mac mac = (Mac) iVar.f2614a.k(lVar.f2617b);
            mac.init(lVar.f2618c);
            return mac;
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
