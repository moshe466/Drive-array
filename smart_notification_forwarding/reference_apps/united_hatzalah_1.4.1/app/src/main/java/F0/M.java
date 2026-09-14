package F0;

import android.content.Context;
import java.util.Iterator;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class M extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Context f282a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f283b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f284c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Q f285d;

    /* renamed from: e, reason: collision with root package name */
    public int f286e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(Q q3, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f285d = q3;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f284c = obj;
        this.f286e |= Integer.MIN_VALUE;
        return this.f285d.a(null, this);
    }
}
