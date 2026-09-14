package com.google.android.recaptcha.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.j;
import s2.C0684i;

/* loaded from: classes.dex */
public abstract class zzfx implements InvocationHandler {
    private final Object zza;

    public zzfx(Object obj) {
        this.zza = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        int i;
        if (j.a(method.getName(), "toString") && method.getParameterTypes().length == 0) {
            return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
        }
        if (j.a(method.getName(), "hashCode") && method.getParameterTypes().length == 0) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if (j.a(method.getName(), "equals") && method.getParameterTypes().length != 0) {
            boolean z3 = false;
            if (objArr != null && objArr.length != 0) {
                Object obj3 = objArr[0];
                if (obj3 != null) {
                    i = obj3.hashCode();
                } else {
                    i = 0;
                }
                if (i == obj.hashCode()) {
                    z3 = true;
                }
            }
            return Boolean.valueOf(z3);
        }
        boolean zza = zza(obj, method, objArr);
        C0684i c0684i = C0684i.f6340a;
        if (!zza) {
            return c0684i;
        }
        if ((this.zza == null && j.a(method.getReturnType(), Void.TYPE)) || ((obj2 = this.zza) != null && j.a(zzkm.zza(obj2.getClass()), zzkm.zza(method.getReturnType())))) {
            Object obj4 = this.zza;
            if (obj4 == null) {
                return c0684i;
            }
            return obj4;
        }
        throw new IllegalArgumentException(this.zza + " cannot be returned from method with return type " + method.getReturnType());
    }

    public abstract boolean zza(Object obj, Method method, Object[] objArr);
}
