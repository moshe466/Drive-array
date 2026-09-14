package x4;

import android.content.Context;
import x4.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements r3.h {

    /* renamed from: a, reason: collision with root package name */
    private final String f15428a;

    /* renamed from: b, reason: collision with root package name */
    private final h.a f15429b;

    private g(String str, h.a aVar) {
        this.f15428a = str;
        this.f15429b = aVar;
    }

    public static r3.h b(String str, h.a aVar) {
        return new g(str, aVar);
    }

    @Override // r3.h
    public Object a(r3.e eVar) {
        f a10;
        a10 = f.a(this.f15428a, this.f15429b.a((Context) eVar.a(Context.class)));
        return a10;
    }
}
