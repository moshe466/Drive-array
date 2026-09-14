package R;

import java.io.FileInputStream;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class Q extends AbstractC0787c {

    /* renamed from: a, reason: collision with root package name */
    public Object f1814a;

    /* renamed from: b, reason: collision with root package name */
    public FileInputStream f1815b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1816c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ S f1817d;

    /* renamed from: e, reason: collision with root package name */
    public int f1818e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(S s3, AbstractC0787c abstractC0787c) {
        super(abstractC0787c);
        this.f1817d = s3;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.f1816c = obj;
        this.f1818e |= Integer.MIN_VALUE;
        return S.a(this.f1817d, this);
    }
}
