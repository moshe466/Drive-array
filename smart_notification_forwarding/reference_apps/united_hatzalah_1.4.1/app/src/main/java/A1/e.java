package A1;

import android.content.Context;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class e implements v1.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f36a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0645a f37b;

    public /* synthetic */ e(InterfaceC0645a interfaceC0645a, int i) {
        this.f36a = i;
        this.f37b = interfaceC0645a;
    }

    @Override // r2.InterfaceC0645a
    public final Object get() {
        switch (this.f36a) {
            case 0:
                String packageName = ((Context) this.f37b.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            default:
                return new o((Context) this.f37b.get(), Integer.valueOf(o.f63d).intValue(), "com.google.android.datatransport.events");
        }
    }
}
