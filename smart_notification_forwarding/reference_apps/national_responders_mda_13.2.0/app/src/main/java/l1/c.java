package l1;

import android.content.Context;

/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11768a;

    /* renamed from: b, reason: collision with root package name */
    private final t1.a f11769b;

    /* renamed from: c, reason: collision with root package name */
    private final t1.a f11770c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, t1.a aVar, t1.a aVar2) {
        this.f11768a = context;
        this.f11769b = aVar;
        this.f11770c = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.datatransport.runtime.backends.f a(String str) {
        return com.google.android.datatransport.runtime.backends.f.a(this.f11768a, this.f11769b, this.f11770c, str);
    }
}
