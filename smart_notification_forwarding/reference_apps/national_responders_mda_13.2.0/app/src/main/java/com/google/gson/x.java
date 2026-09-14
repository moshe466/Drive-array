package com.google.gson;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class x<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x<T> {
        a() {
        }

        @Override // com.google.gson.x
        public T b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return (T) x.this.b(aVar);
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        public void d(f5.c cVar, T t10) {
            if (t10 == null) {
                cVar.b0();
            } else {
                x.this.d(cVar, t10);
            }
        }
    }

    public final x<T> a() {
        return new a();
    }

    public abstract T b(f5.a aVar);

    public final k c(T t10) {
        try {
            a5.g gVar = new a5.g();
            d(gVar, t10);
            return gVar.r0();
        } catch (IOException e10) {
            throw new l(e10);
        }
    }

    public abstract void d(f5.c cVar, T t10);
}
