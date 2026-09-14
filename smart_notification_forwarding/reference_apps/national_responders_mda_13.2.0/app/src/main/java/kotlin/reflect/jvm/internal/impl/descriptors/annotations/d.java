package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import bb.b0;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import n9.v0;

/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f11353a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<la.e, pa.g<?>> f11354b;

    /* renamed from: c, reason: collision with root package name */
    private final v0 f11355c;

    public d(b0 b0Var, Map<la.e, pa.g<?>> map, v0 v0Var) {
        if (b0Var == null) {
            c(0);
        }
        if (map == null) {
            c(1);
        }
        if (v0Var == null) {
            c(2);
        }
        this.f11353a = b0Var;
        this.f11354b = map;
        this.f11355c = v0Var;
    }

    private static /* synthetic */ void c(int i10) {
        String str = (i10 == 3 || i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 3 || i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "valueArguments";
        } else if (i10 == 2) {
            objArr[0] = "source";
        } else if (i10 == 3 || i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i10 == 3) {
            objArr[1] = "getType";
        } else if (i10 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<la.e, pa.g<?>> a() {
        Map<la.e, pa.g<?>> map = this.f11354b;
        if (map == null) {
            c(4);
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public b0 b() {
        b0 b0Var = this.f11353a;
        if (b0Var == null) {
            c(3);
        }
        return b0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public la.b f() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public v0 k() {
        v0 v0Var = this.f11355c;
        if (v0Var == null) {
            c(5);
        }
        return v0Var;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.c.f11499b.s(this, null);
    }
}
