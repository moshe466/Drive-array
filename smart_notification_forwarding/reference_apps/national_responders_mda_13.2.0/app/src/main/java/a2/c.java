package a2;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c extends Exception {

    /* renamed from: f, reason: collision with root package name */
    private final l.a f55f;

    public c(l.a aVar) {
        this.f55f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        for (com.google.android.gms.common.api.internal.b bVar : this.f55f.keySet()) {
            com.google.android.gms.common.a aVar = (com.google.android.gms.common.a) b2.p.k((com.google.android.gms.common.a) this.f55f.get(bVar));
            z10 &= !aVar.t();
            arrayList.add(bVar.b() + ": " + String.valueOf(aVar));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z10 ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
