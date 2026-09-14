package com.fasterxml.jackson.module.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: KotlinSerializers.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0002¨\u0006\u0003"}, d2 = {"getStaticJsonValueGetter", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "jackson-module-kotlin"}, k = 2, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KotlinSerializersKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        if (r4 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.reflect.Method getStaticJsonValueGetter(java.lang.Class<?> r9) {
        /*
            java.lang.reflect.Method[] r9 = r9.getDeclaredMethods()
            java.lang.String r0 = "this.declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            int r0 = r9.length
            r1 = 0
            r2 = r1
        Le:
            if (r2 >= r0) goto L47
            r3 = r9[r2]
            r4 = r3
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            int r5 = r4.getModifiers()
            boolean r5 = java.lang.reflect.Modifier.isStatic(r5)
            if (r5 == 0) goto L40
            java.lang.annotation.Annotation[] r4 = r4.getAnnotations()
            java.lang.String r5 = "method.annotations"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            int r5 = r4.length
            r6 = r1
        L2c:
            r7 = 1
            if (r6 >= r5) goto L3c
            r8 = r4[r6]
            java.lang.annotation.Annotation r8 = (java.lang.annotation.Annotation) r8
            boolean r8 = r8 instanceof com.fasterxml.jackson.annotation.JsonValue
            if (r8 == 0) goto L39
            r4 = r7
            goto L3d
        L39:
            int r6 = r6 + 1
            goto L2c
        L3c:
            r4 = r1
        L3d:
            if (r4 == 0) goto L40
            goto L41
        L40:
            r7 = r1
        L41:
            if (r7 == 0) goto L44
            goto L48
        L44:
            int r2 = r2 + 1
            goto Le
        L47:
            r3 = 0
        L48:
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.module.kotlin.KotlinSerializersKt.getStaticJsonValueGetter(java.lang.Class):java.lang.reflect.Method");
    }
}
