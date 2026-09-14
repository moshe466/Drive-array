package T;

import androidx.datastore.preferences.protobuf.AbstractC0235b;
import androidx.datastore.preferences.protobuf.AbstractC0251s;
import androidx.datastore.preferences.protobuf.AbstractC0253u;
import androidx.datastore.preferences.protobuf.AbstractC0255w;
import androidx.datastore.preferences.protobuf.InterfaceC0254v;
import androidx.datastore.preferences.protobuf.N;
import androidx.datastore.preferences.protobuf.P;
import androidx.datastore.preferences.protobuf.Q;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes.dex */
public final class i extends AbstractC0253u {
    private static final i DEFAULT_INSTANCE;
    private static volatile N PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private InterfaceC0254v strings_ = P.f3123d;

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        AbstractC0253u.j(i.class, iVar);
    }

    public static void l(i iVar, Set set) {
        int i;
        InterfaceC0254v interfaceC0254v = iVar.strings_;
        if (!((AbstractC0235b) interfaceC0254v).f3154a) {
            P p = (P) interfaceC0254v;
            int i3 = p.f3125c;
            if (i3 == 0) {
                i = 10;
            } else {
                i = i3 * 2;
            }
            iVar.strings_ = p.h(i);
        }
        RandomAccess randomAccess = iVar.strings_;
        Charset charset = AbstractC0255w.f3236a;
        set.getClass();
        if (randomAccess instanceof ArrayList) {
            ((ArrayList) randomAccess).ensureCapacity(set.size() + ((P) randomAccess).f3125c);
        }
        P p2 = (P) randomAccess;
        int i4 = p2.f3125c;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (p2.f3125c - i4) + " is null.";
                for (int i5 = p2.f3125c - 1; i5 >= i4; i5--) {
                    p2.remove(i5);
                }
                throw new NullPointerException(str);
            }
            p2.add(obj);
        }
    }

    public static i m() {
        return DEFAULT_INSTANCE;
    }

    public static h o() {
        return (h) ((AbstractC0251s) DEFAULT_INSTANCE.c(5));
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [androidx.datastore.preferences.protobuf.N, java.lang.Object] */
    @Override // androidx.datastore.preferences.protobuf.AbstractC0253u
    public final Object c(int i) {
        N n4;
        switch (k.b(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new Q(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new i();
            case 4:
                return new AbstractC0251s(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                N n5 = PARSER;
                if (n5 == null) {
                    synchronized (i.class) {
                        try {
                            N n6 = PARSER;
                            n4 = n6;
                            if (n6 == null) {
                                ?? obj = new Object();
                                PARSER = obj;
                                n4 = obj;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return n4;
                }
                return n5;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final InterfaceC0254v n() {
        return this.strings_;
    }
}
