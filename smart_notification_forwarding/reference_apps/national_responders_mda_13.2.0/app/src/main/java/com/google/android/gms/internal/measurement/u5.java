package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.u5;
import com.google.android.gms.internal.measurement.w5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class u5<MessageType extends u5<MessageType, BuilderType>, BuilderType extends w5<MessageType, BuilderType>> implements y8 {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void c(Iterable<T> iterable, List<? super T> list) {
        o7.d(iterable);
        if (iterable instanceof e8) {
            List<?> a10 = ((e8) iterable).a();
            e8 e8Var = (e8) list;
            int size = list.size();
            for (Object obj : a10) {
                if (obj == null) {
                    int size2 = e8Var.size() - size;
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Element at index ");
                    sb2.append(size2);
                    sb2.append(" is null.");
                    String sb3 = sb2.toString();
                    for (int size3 = e8Var.size() - 1; size3 >= size; size3--) {
                        e8Var.remove(size3);
                    }
                    throw new NullPointerException(sb3);
                }
                if (obj instanceof d6) {
                    e8Var.i((d6) obj);
                } else {
                    e8Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof j9) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t10 : iterable) {
            if (t10 == null) {
                int size5 = list.size() - size4;
                StringBuilder sb4 = new StringBuilder(37);
                sb4.append("Element at index ");
                sb4.append(size5);
                sb4.append(" is null.");
                String sb5 = sb4.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb5);
            }
            list.add(t10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y8
    public final d6 a() {
        try {
            l6 A = d6.A(b());
            h(A.b());
            return A.a();
        } catch (IOException e10) {
            String name = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 62 + "ByteString".length());
            sb2.append("Serializing ");
            sb2.append(name);
            sb2.append(" to a ");
            sb2.append("ByteString");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e10);
        }
    }

    public final byte[] f() {
        try {
            byte[] bArr = new byte[b()];
            v6 f10 = v6.f(bArr);
            h(f10);
            f10.N();
            return bArr;
        } catch (IOException e10) {
            String name = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 62 + "byte array".length());
            sb2.append("Serializing ");
            sb2.append(name);
            sb2.append(" to a ");
            sb2.append("byte array");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i10) {
        throw new UnsupportedOperationException();
    }
}
