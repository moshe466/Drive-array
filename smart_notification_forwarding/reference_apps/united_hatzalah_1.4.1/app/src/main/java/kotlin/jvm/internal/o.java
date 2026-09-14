package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class o extends c implements L2.i {
    private final boolean syntheticJavaProperty;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o(java.lang.Object r9, java.lang.Class r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
            r8 = this;
            r0 = 1
            r13 = r13 & r0
            r1 = 0
            if (r13 != r0) goto Lc
            r7 = r0
        L6:
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            goto Le
        Lc:
            r7 = r1
            goto L6
        Le:
            r2.<init>(r3, r4, r5, r6, r7)
            r2.syntheticJavaProperty = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.o.<init>(java.lang.Object, java.lang.Class, java.lang.String, java.lang.String, int):void");
    }

    @Override // kotlin.jvm.internal.c
    public L2.b compute() {
        if (this.syntheticJavaProperty) {
            return this;
        }
        return super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (getOwner().equals(oVar.getOwner()) && getName().equals(oVar.getName()) && getSignature().equals(oVar.getSignature()) && j.a(getBoundReceiver(), oVar.getBoundReceiver())) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof L2.i)) {
            return false;
        }
        return obj.equals(compute());
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // L2.i
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // L2.i
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        L2.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.c
    public L2.i getReflected() {
        if (!this.syntheticJavaProperty) {
            L2.b compute = compute();
            if (compute != this) {
                return (L2.i) compute;
            }
            throw new Error("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
    }
}
