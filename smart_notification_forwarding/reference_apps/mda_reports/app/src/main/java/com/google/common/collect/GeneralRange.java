package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @NullableDecl
    private final T lowerEndpoint;

    @MonotonicNonNullDecl
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;

    @NullableDecl
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator<? super T> comparator, boolean z, @NullableDecl T t, BoundType boundType, boolean z2, @NullableDecl T t2, BoundType boundType2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                Preconditions.checkArgument((boundType != BoundType.OPEN) | (boundType2 != BoundType.OPEN));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> a(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange<>(comparator, false, null, boundType, false, null, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> a(Comparator<? super T> comparator, @NullableDecl T t, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> b(Comparator<? super T> comparator, @NullableDecl T t, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r11.d() == com.google.common.collect.BoundType.OPEN) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0047, code lost:
    
        if (r11.b() == com.google.common.collect.BoundType.OPEN) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x008b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.common.collect.GeneralRange<T> a(com.google.common.collect.GeneralRange<T> r11) {
        /*
            r10 = this;
            com.google.common.base.Preconditions.checkNotNull(r11)
            java.util.Comparator<? super T> r0 = r10.comparator
            java.util.Comparator<? super T> r1 = r11.comparator
            boolean r0 = r0.equals(r1)
            com.google.common.base.Preconditions.checkArgument(r0)
            boolean r0 = r10.hasLowerBound
            java.lang.Object r1 = r10.c()
            com.google.common.collect.BoundType r2 = r10.b()
            boolean r3 = r10.f()
            if (r3 != 0) goto L29
            boolean r0 = r11.hasLowerBound
        L20:
            java.lang.Object r1 = r11.c()
            com.google.common.collect.BoundType r2 = r11.b()
            goto L4a
        L29:
            boolean r3 = r11.f()
            if (r3 == 0) goto L4a
            java.util.Comparator<? super T> r3 = r10.comparator
            java.lang.Object r4 = r10.c()
            java.lang.Object r5 = r11.c()
            int r3 = r3.compare(r4, r5)
            if (r3 < 0) goto L20
            if (r3 != 0) goto L4a
            com.google.common.collect.BoundType r3 = r11.b()
            com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
            if (r3 != r4) goto L4a
            goto L20
        L4a:
            r4 = r0
            boolean r0 = r10.hasUpperBound
            java.lang.Object r3 = r10.e()
            com.google.common.collect.BoundType r5 = r10.d()
            boolean r6 = r10.g()
            if (r6 != 0) goto L66
            boolean r0 = r11.hasUpperBound
        L5d:
            java.lang.Object r3 = r11.e()
            com.google.common.collect.BoundType r5 = r11.d()
            goto L87
        L66:
            boolean r6 = r11.g()
            if (r6 == 0) goto L87
            java.util.Comparator<? super T> r6 = r10.comparator
            java.lang.Object r7 = r10.e()
            java.lang.Object r8 = r11.e()
            int r6 = r6.compare(r7, r8)
            if (r6 > 0) goto L5d
            if (r6 != 0) goto L87
            com.google.common.collect.BoundType r6 = r11.d()
            com.google.common.collect.BoundType r7 = com.google.common.collect.BoundType.OPEN
            if (r6 != r7) goto L87
            goto L5d
        L87:
            r7 = r0
            r8 = r3
            if (r4 == 0) goto La5
            if (r7 == 0) goto La5
            java.util.Comparator<? super T> r11 = r10.comparator
            int r11 = r11.compare(r1, r8)
            if (r11 > 0) goto L9d
            if (r11 != 0) goto La5
            com.google.common.collect.BoundType r11 = com.google.common.collect.BoundType.OPEN
            if (r2 != r11) goto La5
            if (r5 != r11) goto La5
        L9d:
            com.google.common.collect.BoundType r11 = com.google.common.collect.BoundType.OPEN
            com.google.common.collect.BoundType r0 = com.google.common.collect.BoundType.CLOSED
            r6 = r11
            r9 = r0
            r5 = r8
            goto La8
        La5:
            r6 = r2
            r9 = r5
            r5 = r1
        La8:
            com.google.common.collect.GeneralRange r11 = new com.google.common.collect.GeneralRange
            java.util.Comparator<? super T> r3 = r10.comparator
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.GeneralRange.a(com.google.common.collect.GeneralRange):com.google.common.collect.GeneralRange");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Comparator<? super T> a() {
        return this.comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(@NullableDecl T t) {
        return (c(t) || b(t)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType b() {
        return this.lowerBoundType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(@NullableDecl T t) {
        if (!g()) {
            return false;
        }
        int compare = this.comparator.compare(t, e());
        return ((compare == 0) & (d() == BoundType.OPEN)) | (compare > 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T c() {
        return this.lowerEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(@NullableDecl T t) {
        if (!f()) {
            return false;
        }
        int compare = this.comparator.compare(t, c());
        return ((compare == 0) & (b() == BoundType.OPEN)) | (compare < 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType d() {
        return this.upperBoundType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T e() {
        return this.upperEndpoint;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && b().equals(generalRange.b()) && d().equals(generalRange.d()) && Objects.equal(c(), generalRange.c()) && Objects.equal(e(), generalRange.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.hasLowerBound;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, c(), b(), e(), d());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        sb.append(this.lowerBoundType == BoundType.CLOSED ? '[' : '(');
        sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb.append(',');
        sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb.append(this.upperBoundType == BoundType.CLOSED ? ']' : ')');
        return sb.toString();
    }
}
