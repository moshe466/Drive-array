package r;

import android.content.ComponentName;
import android.os.Bundle;
import b.C0317b;
import b.InterfaceC0319d;

/* renamed from: r.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0640o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6200a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0319d f6201b;

    /* renamed from: c, reason: collision with root package name */
    public final BinderC0632g f6202c;

    /* renamed from: d, reason: collision with root package name */
    public final ComponentName f6203d;

    public C0640o(InterfaceC0319d interfaceC0319d, BinderC0632g binderC0632g, ComponentName componentName) {
        this.f6201b = interfaceC0319d;
        this.f6202c = binderC0632g;
        this.f6203d = componentName;
    }

    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return bundle2;
    }

    public final boolean b(Bundle bundle) {
        Bundle a2 = a(bundle);
        try {
            return ((C0317b) this.f6201b).c(this.f6202c, a2);
        } catch (SecurityException e4) {
            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e4);
        }
    }
}
