package v7;

import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements i {

    /* renamed from: f, reason: collision with root package name */
    protected String f14708f;

    /* renamed from: g, reason: collision with root package name */
    protected Date f14709g;

    /* renamed from: h, reason: collision with root package name */
    protected List<Object> f14710h;

    public a(String str, String str2, long j10, long j11, String str3, List<Object> list, int i10) {
        this.f14708f = str;
        this.f14709g = new Date(j10);
        new Date(j11);
        this.f14710h = list;
        if (i10 == 0) {
            l lVar = l.Unsent;
        } else if (i10 == 1) {
            l lVar2 = l.Delivered;
        } else if (i10 == 2) {
            l lVar3 = l.Read;
        }
        k kVar = k.NONE;
    }

    @Override // v7.i
    public Date h() {
        return this.f14709g;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f14709g.compareTo(iVar.h());
    }

    public String k() {
        return this.f14708f;
    }
}
