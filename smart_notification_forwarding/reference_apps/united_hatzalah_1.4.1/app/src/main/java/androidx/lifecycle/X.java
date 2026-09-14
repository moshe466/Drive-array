package androidx.lifecycle;

import a.AbstractC0228a;
import d0.C0357c;

/* loaded from: classes.dex */
public interface X {
    default V a(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    default V b(kotlin.jvm.internal.e eVar, C0357c c0357c) {
        return c(AbstractC0228a.s(eVar), c0357c);
    }

    default V c(Class cls, C0357c c0357c) {
        return a(cls);
    }
}
