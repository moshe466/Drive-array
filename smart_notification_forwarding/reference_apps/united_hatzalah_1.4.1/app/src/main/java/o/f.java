package o;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class f implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public c f5906a;

    /* renamed from: b, reason: collision with root package name */
    public c f5907b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap f5908c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f5909d = 0;

    public c d(Object obj) {
        c cVar = this.f5906a;
        while (cVar != null && !cVar.f5899a.equals(obj)) {
            cVar = cVar.f5901c;
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((o.b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof o.f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            o.f r7 = (o.f) r7
            int r1 = r6.f5909d
            int r3 = r7.f5909d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            o.b r3 = (o.b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            o.b r4 = (o.b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            o.b r7 = (o.b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.f.equals(java.lang.Object):boolean");
    }

    public Object g(Object obj) {
        c d2 = d(obj);
        if (d2 == null) {
            return null;
        }
        this.f5909d--;
        WeakHashMap weakHashMap = this.f5908c;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(d2);
            }
        }
        c cVar = d2.f5902d;
        if (cVar != null) {
            cVar.f5901c = d2.f5901c;
        } else {
            this.f5906a = d2.f5901c;
        }
        c cVar2 = d2.f5901c;
        if (cVar2 != null) {
            cVar2.f5902d = cVar;
        } else {
            this.f5907b = cVar;
        }
        d2.f5901c = null;
        d2.f5902d = null;
        return d2.f5900b;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (true) {
            b bVar = (b) it;
            if (bVar.hasNext()) {
                i += ((Map.Entry) bVar.next()).hashCode();
            } else {
                return i;
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f5906a, this.f5907b, 0);
        this.f5908c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            b bVar = (b) it;
            if (bVar.hasNext()) {
                sb.append(((Map.Entry) bVar.next()).toString());
                if (bVar.hasNext()) {
                    sb.append(", ");
                }
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
