package y2;

import F0.b3;
import a.AbstractC0228a;
import com.google.firebase.messaging.Constants;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.j;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* renamed from: y2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0785a implements InterfaceC0763d, InterfaceC0788d, Serializable {
    private final InterfaceC0763d completion;

    public AbstractC0785a(InterfaceC0763d interfaceC0763d) {
        this.completion = interfaceC0763d;
    }

    public InterfaceC0763d create(InterfaceC0763d completion) {
        j.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public InterfaceC0788d getCallerFrame() {
        InterfaceC0763d interfaceC0763d = this.completion;
        if (interfaceC0763d instanceof InterfaceC0788d) {
            return (InterfaceC0788d) interfaceC0763d;
        }
        return null;
    }

    public final InterfaceC0763d getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int i;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Object obj;
        Integer num;
        int i3;
        InterfaceC0789e interfaceC0789e = (InterfaceC0789e) getClass().getAnnotation(InterfaceC0789e.class);
        String str2 = null;
        if (interfaceC0789e == null || interfaceC0789e.v() < 1) {
            return null;
        }
        int i4 = -1;
        try {
            Field declaredField = getClass().getDeclaredField(Constants.ScionAnalytics.PARAM_LABEL);
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(this);
            if (obj2 instanceof Integer) {
                num = (Integer) obj2;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            i = i3 - 1;
        } catch (Exception unused) {
            i = -1;
        }
        if (i >= 0) {
            i4 = interfaceC0789e.l()[i];
        }
        b3 b3Var = AbstractC0790f.f6763b;
        b3 b3Var2 = AbstractC0790f.f6762a;
        if (b3Var == null) {
            try {
                b3 b3Var3 = new b3(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null), 13);
                AbstractC0790f.f6763b = b3Var3;
                b3Var = b3Var3;
            } catch (Exception unused2) {
                AbstractC0790f.f6763b = b3Var2;
                b3Var = b3Var2;
            }
        }
        if (b3Var != b3Var2 && (method = (Method) b3Var.f469b) != null && (invoke = method.invoke(getClass(), null)) != null && (method2 = (Method) b3Var.f470c) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
            Method method3 = (Method) b3Var.f471d;
            if (method3 != null) {
                obj = method3.invoke(invoke2, null);
            } else {
                obj = null;
            }
            if (obj instanceof String) {
                str2 = (String) obj;
            }
        }
        if (str2 == null) {
            str = interfaceC0789e.c();
        } else {
            str = str2 + '/' + interfaceC0789e.c();
        }
        return new StackTraceElement(str, interfaceC0789e.m(), interfaceC0789e.f(), i4);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        InterfaceC0763d interfaceC0763d = this;
        while (true) {
            AbstractC0785a abstractC0785a = (AbstractC0785a) interfaceC0763d;
            InterfaceC0763d interfaceC0763d2 = abstractC0785a.completion;
            j.b(interfaceC0763d2);
            try {
                obj = abstractC0785a.invokeSuspend(obj);
                if (obj == EnumC0779a.f6740a) {
                    return;
                }
            } catch (Throwable th) {
                obj = AbstractC0228a.g(th);
            }
            abstractC0785a.releaseIntercepted();
            if (interfaceC0763d2 instanceof AbstractC0785a) {
                interfaceC0763d = interfaceC0763d2;
            } else {
                interfaceC0763d2.resumeWith(obj);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public InterfaceC0763d create(Object obj, InterfaceC0763d completion) {
        j.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
