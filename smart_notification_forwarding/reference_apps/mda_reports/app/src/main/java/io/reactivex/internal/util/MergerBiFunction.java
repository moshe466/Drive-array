package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> a;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        if (r7.hasNext() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r3 = r7.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r3 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        if (r5.a.compare(r0, r3) >= 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        r1.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        if (r7.hasNext() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        r1.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        if (r6.hasNext() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        r0 = r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
    
        r1.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0066, code lost:
    
        if (r6.hasNext() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0068, code lost:
    
        r1.add(r6.next());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
    
        r1.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
    
        if (r7.hasNext() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0079, code lost:
    
        r1.add(r7.next());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0037, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005a -> B:11:0x0031). Please report as a decompilation issue!!! */
    @Override // io.reactivex.functions.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<T> apply(java.util.List<T> r6, java.util.List<T> r7) {
        /*
            r5 = this;
            int r0 = r6.size()
            int r1 = r7.size()
            int r0 = r0 + r1
            if (r0 != 0) goto L11
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        L11:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
            boolean r0 = r6.hasNext()
            r2 = 0
            if (r0 == 0) goto L2a
            java.lang.Object r0 = r6.next()
            goto L2b
        L2a:
            r0 = r2
        L2b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L36
        L31:
            java.lang.Object r3 = r7.next()
            goto L37
        L36:
            r3 = r2
        L37:
            if (r0 == 0) goto L5d
            if (r3 == 0) goto L5d
            java.util.Comparator<? super T> r4 = r5.a
            int r4 = r4.compare(r0, r3)
            if (r4 >= 0) goto L53
            r1.add(r0)
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L51
            java.lang.Object r0 = r6.next()
            goto L37
        L51:
            r0 = r2
            goto L37
        L53:
            r1.add(r3)
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L36
            goto L31
        L5d:
            if (r0 == 0) goto L70
            r1.add(r0)
        L62:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L81
            java.lang.Object r7 = r6.next()
            r1.add(r7)
            goto L62
        L70:
            r1.add(r3)
        L73:
            boolean r6 = r7.hasNext()
            if (r6 == 0) goto L81
            java.lang.Object r6 = r7.next()
            r1.add(r6)
            goto L73
        L81:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.MergerBiFunction.apply(java.util.List, java.util.List):java.util.List");
    }
}
