package S;

import F2.l;
import R.InterfaceC0177b;
import androidx.datastore.core.CorruptionException;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class a implements InterfaceC0177b {

    /* renamed from: a, reason: collision with root package name */
    public final l f2071a;

    public a(l produceNewData) {
        j.e(produceNewData, "produceNewData");
        this.f2071a = produceNewData;
    }

    @Override // R.InterfaceC0177b
    public final Object a(CorruptionException corruptionException) {
        return this.f2071a.invoke(corruptionException);
    }
}
