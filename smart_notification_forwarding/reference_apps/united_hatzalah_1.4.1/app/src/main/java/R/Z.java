package R;

import java.io.FileOutputStream;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class Z extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public FileOutputStream f1846a;

    /* renamed from: b, reason: collision with root package name */
    public FileOutputStream f1847b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1848c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f1849d;

    /* renamed from: e, reason: collision with root package name */
    public int f1850e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(a0 a0Var, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1849d = a0Var;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1848c = obj;
        this.f1850e |= Integer.MIN_VALUE;
        return this.f1849d.b(null, this);
    }
}
