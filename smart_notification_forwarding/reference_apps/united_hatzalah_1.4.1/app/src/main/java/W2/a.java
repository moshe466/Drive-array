package W2;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.r;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2505l = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final n f2506a;

    /* renamed from: b, reason: collision with root package name */
    public final r f2507b;

    /* renamed from: c, reason: collision with root package name */
    public b f2508c;

    /* renamed from: d, reason: collision with root package name */
    public long f2509d;

    /* renamed from: e, reason: collision with root package name */
    public long f2510e;

    /* renamed from: f, reason: collision with root package name */
    public int f2511f;
    private volatile int indexInArray;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2512j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c f2513k;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.jvm.internal.r, java.lang.Object] */
    public a(c cVar, int i) {
        this.f2513k = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f2506a = new n();
        this.f2507b = new Object();
        this.f2508c = b.f2517d;
        this.nextParkedWorker = c.f2523n;
        int nanoTime = (int) System.nanoTime();
        this.f2511f = nanoTime == 0 ? 42 : nanoTime;
        f(i);
    }

    public final i a(boolean z3) {
        i e4;
        i e5;
        long j2;
        b bVar = this.f2508c;
        b bVar2 = b.f2514a;
        c cVar = this.f2513k;
        i iVar = null;
        boolean z4 = true;
        n nVar = this.f2506a;
        if (bVar != bVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c.f2521l;
            do {
                j2 = atomicLongFieldUpdater.get(cVar);
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    nVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n.f2549b;
                        i iVar2 = (i) atomicReferenceFieldUpdater.get(nVar);
                        if (iVar2 == null || iVar2.f2537b.f2538a != 1) {
                            break;
                        }
                        while (!atomicReferenceFieldUpdater.compareAndSet(nVar, iVar2, null)) {
                            if (atomicReferenceFieldUpdater.get(nVar) != iVar2) {
                                break;
                            }
                        }
                        iVar = iVar2;
                    }
                    int i = n.f2551d.get(nVar);
                    int i3 = n.f2550c.get(nVar);
                    while (true) {
                        if (i == i3 || n.f2552e.get(nVar) == 0) {
                            break;
                        }
                        i3--;
                        i b4 = nVar.b(i3, true);
                        if (b4 != null) {
                            iVar = b4;
                            break;
                        }
                    }
                    if (iVar == null) {
                        i iVar3 = (i) cVar.f2529f.d();
                        if (iVar3 == null) {
                            return i(1);
                        }
                        return iVar3;
                    }
                    return iVar;
                }
            } while (!c.f2521l.compareAndSet(cVar, j2, j2 - 4398046511104L));
            this.f2508c = b.f2514a;
        }
        if (z3) {
            if (d(cVar.f2524a * 2) != 0) {
                z4 = false;
            }
            if (z4 && (e5 = e()) != null) {
                return e5;
            }
            nVar.getClass();
            i iVar4 = (i) n.f2549b.getAndSet(nVar, null);
            if (iVar4 == null) {
                iVar4 = nVar.a();
            }
            if (iVar4 != null) {
                return iVar4;
            }
            if (!z4 && (e4 = e()) != null) {
                return e4;
            }
        } else {
            i e6 = e();
            if (e6 != null) {
                return e6;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i3 = this.f2511f;
        int i4 = i3 ^ (i3 << 13);
        int i5 = i4 ^ (i4 >> 17);
        int i6 = i5 ^ (i5 << 5);
        this.f2511f = i6;
        int i7 = i - 1;
        if ((i7 & i) == 0) {
            return i6 & i7;
        }
        return (i6 & Api.BaseClientBuilder.API_PRIORITY_OTHER) % i;
    }

    public final i e() {
        int d2 = d(2);
        c cVar = this.f2513k;
        if (d2 == 0) {
            i iVar = (i) cVar.f2528e.d();
            if (iVar != null) {
                return iVar;
            }
            return (i) cVar.f2529f.d();
        }
        i iVar2 = (i) cVar.f2529f.d();
        if (iVar2 != null) {
            return iVar2;
        }
        return (i) cVar.f2528e.d();
    }

    public final void f(int i) {
        String valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2513k.f2527d);
        sb.append("-worker-");
        if (i == 0) {
            valueOf = "TERMINATED";
        } else {
            valueOf = String.valueOf(i);
        }
        sb.append(valueOf);
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        boolean z3;
        b bVar2 = this.f2508c;
        if (bVar2 == b.f2514a) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            c.f2521l.addAndGet(this.f2513k, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f2508c = bVar;
        }
        return z3;
    }

    public final i i(int i) {
        boolean z3;
        long j2;
        i iVar;
        long j3;
        long j4;
        i iVar2;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f2521l;
        c cVar = this.f2513k;
        int i4 = (int) (atomicLongFieldUpdater.get(cVar) & 2097151);
        i iVar3 = null;
        if (i4 < 2) {
            return null;
        }
        int d2 = d(i4);
        int i5 = 0;
        long j5 = Long.MAX_VALUE;
        while (i5 < i4) {
            d2++;
            if (d2 > i4) {
                d2 = 1;
            }
            a aVar = (a) cVar.f2530j.b(d2);
            if (aVar != null && aVar != this) {
                n nVar = aVar.f2506a;
                if (i == 3) {
                    iVar = nVar.a();
                    j2 = 0;
                } else {
                    nVar.getClass();
                    int i6 = n.f2551d.get(nVar);
                    int i7 = n.f2550c.get(nVar);
                    if (i == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    while (true) {
                        if (i6 != i7) {
                            j2 = 0;
                            if (!z3 || n.f2552e.get(nVar) != 0) {
                                int i8 = i6 + 1;
                                iVar = nVar.b(i6, z3);
                                if (iVar != null) {
                                    break;
                                }
                                i6 = i8;
                            } else {
                                break;
                            }
                        } else {
                            j2 = 0;
                            break;
                        }
                    }
                    iVar = iVar3;
                }
                r rVar = this.f2507b;
                if (iVar != null) {
                    rVar.f5312a = iVar;
                    iVar2 = iVar3;
                    j4 = -1;
                    j3 = -1;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n.f2549b;
                        i iVar4 = (i) atomicReferenceFieldUpdater.get(nVar);
                        if (iVar4 == null) {
                            j3 = -1;
                            break;
                        }
                        j3 = -1;
                        if (iVar4.f2537b.f2538a == 1) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        if ((i3 & i) == 0) {
                            break;
                        }
                        l.f2545f.getClass();
                        n nVar2 = nVar;
                        long nanoTime = System.nanoTime() - iVar4.f2536a;
                        long j6 = l.f2541b;
                        if (nanoTime < j6) {
                            j4 = j6 - nanoTime;
                            iVar2 = null;
                            break;
                        }
                        do {
                            iVar2 = null;
                            if (atomicReferenceFieldUpdater.compareAndSet(nVar2, iVar4, null)) {
                                rVar.f5312a = iVar4;
                                j4 = -1;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(nVar2) == iVar4);
                        nVar = nVar2;
                        iVar3 = null;
                    }
                    j4 = -2;
                    iVar2 = iVar3;
                }
                if (j4 == j3) {
                    i iVar5 = (i) rVar.f5312a;
                    rVar.f5312a = iVar2;
                    return iVar5;
                }
                if (j4 > j2) {
                    j5 = Math.min(j5, j4);
                }
            }
            i5++;
            iVar3 = null;
        }
        if (j5 == Long.MAX_VALUE) {
            j5 = 0;
        }
        this.f2510e = j5;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.a.run():void");
    }
}
