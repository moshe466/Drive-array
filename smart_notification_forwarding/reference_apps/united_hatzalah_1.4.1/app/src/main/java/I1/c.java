package I1;

/* loaded from: classes.dex */
public final class c extends z {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f903j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f904k;

    public /* synthetic */ c(Object obj, int i) {
        this.f903j = i;
        this.f904k = obj;
    }

    @Override // I1.z
    public final void b() {
        switch (this.f903j) {
            case 0:
                d dVar = (d) ((F1.p) this.f904k).f750b;
                dVar.f907b.b("unlinkToDeath", new Object[0]);
                dVar.f918n.asBinder().unlinkToDeath(dVar.f915k, 0);
                dVar.f918n = null;
                dVar.f912g = false;
                return;
            default:
                synchronized (((d) this.f904k).f911f) {
                    try {
                        if (((d) this.f904k).f916l.get() > 0 && ((d) this.f904k).f916l.decrementAndGet() > 0) {
                            ((d) this.f904k).f907b.b("Leaving the connection open for other ongoing calls.", new Object[0]);
                            return;
                        }
                        d dVar2 = (d) this.f904k;
                        if (dVar2.f918n != null) {
                            dVar2.f907b.b("Unbind from service.", new Object[0]);
                            d dVar3 = (d) this.f904k;
                            dVar3.f906a.unbindService(dVar3.f917m);
                            d dVar4 = (d) this.f904k;
                            dVar4.f912g = false;
                            dVar4.f918n = null;
                            dVar4.f917m = null;
                        }
                        ((d) this.f904k).e();
                        return;
                    } finally {
                    }
                }
        }
    }
}
