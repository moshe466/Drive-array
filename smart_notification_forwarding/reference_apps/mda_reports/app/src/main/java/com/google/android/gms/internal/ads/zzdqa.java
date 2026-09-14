package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpz;
import com.google.android.gms.internal.ads.zzdqa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzdqa<MessageType extends zzdqa<MessageType, BuilderType>, BuilderType extends zzdpz<MessageType, BuilderType>> implements zzdte {
    protected int zzhhk = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void a(Iterable<T> iterable, List<? super T> list) {
        zzdrv.a(iterable);
        if (iterable instanceof zzdsl) {
            List<?> zzbav = ((zzdsl) iterable).zzbav();
            zzdsl zzdslVar = (zzdsl) list;
            int size = list.size();
            for (Object obj : zzbav) {
                if (obj == null) {
                    int size2 = zzdslVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size3 = zzdslVar.size() - 1; size3 >= size; size3--) {
                        zzdslVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof zzdqk) {
                    zzdslVar.zzbg((zzdqk) obj);
                } else {
                    zzdslVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzdtq) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("Element at index ");
                sb3.append(size5);
                sb3.append(" is null.");
                String sb4 = sb3.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb4);
            }
            list.add(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzazu()];
            zzdrb zzw = zzdrb.zzw(bArr);
            zzb(zzw);
            zzw.zzazd();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final zzdqk zzaxk() {
        try {
            zzdqs b = zzdqk.b(zzazu());
            zzb(b.zzayb());
            return b.zzaya();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }
}
