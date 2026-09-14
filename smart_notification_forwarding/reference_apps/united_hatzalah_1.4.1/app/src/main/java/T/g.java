package T;

import androidx.datastore.preferences.protobuf.AbstractC0251s;
import androidx.datastore.preferences.protobuf.AbstractC0253u;
import androidx.datastore.preferences.protobuf.C0242i;
import androidx.datastore.preferences.protobuf.C0243j;
import androidx.datastore.preferences.protobuf.C0246m;
import androidx.datastore.preferences.protobuf.E;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.N;
import androidx.datastore.preferences.protobuf.O;
import androidx.datastore.preferences.protobuf.Q;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.UninitializedMessageException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class g extends AbstractC0253u {
    private static final g DEFAULT_INSTANCE;
    private static volatile N PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private E preferences_ = E.f3095b;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC0253u.j(g.class, gVar);
    }

    public static E l(g gVar) {
        E e4 = gVar.preferences_;
        if (!e4.f3096a) {
            gVar.preferences_ = e4.b();
        }
        return gVar.preferences_;
    }

    public static e n() {
        return (e) ((AbstractC0251s) DEFAULT_INSTANCE.c(5));
    }

    public static g o(FileInputStream fileInputStream) {
        g gVar = DEFAULT_INSTANCE;
        C0242i c0242i = new C0242i(fileInputStream);
        C0246m a2 = C0246m.a();
        AbstractC0253u i = gVar.i();
        try {
            O o2 = O.f3120c;
            o2.getClass();
            S a4 = o2.a(i.getClass());
            C0243j c0243j = (C0243j) c0242i.f1403b;
            if (c0243j == null) {
                c0243j = new C0243j(c0242i);
            }
            a4.h(i, c0243j, a2);
            a4.b(i);
            if (AbstractC0253u.f(i, true)) {
                return (g) i;
            }
            throw new IOException(new UninitializedMessageException().getMessage());
        } catch (InvalidProtocolBufferException e4) {
            if (e4.f3100a) {
                throw new IOException(e4.getMessage(), e4);
            }
            throw e4;
        } catch (UninitializedMessageException e5) {
            throw new IOException(e5.getMessage());
        } catch (IOException e6) {
            if (e6.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e6.getCause());
            }
            throw new IOException(e6.getMessage(), e6);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e7.getCause());
            }
            throw e7;
        }
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
                return new Q(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", f.f2265a});
            case 3:
                return new g();
            case 4:
                return new AbstractC0251s(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                N n5 = PARSER;
                if (n5 == null) {
                    synchronized (g.class) {
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

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
