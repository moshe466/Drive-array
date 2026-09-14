package N0;

import F0.AbstractC0008a;
import F0.C0019c2;
import com.android.apksig.apk.ApkSigningBlockNotFoundException;
import com.google.android.gms.common.api.Api;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1482a = "0123456789abcdef".toCharArray();

    public static u a(W0.d dVar, M0.c cVar, int i) {
        try {
            M0.d a2 = M0.b.a(dVar, cVar);
            long j2 = a2.f1395b;
            Y0.b bVar = (Y0.b) a2.f1396c;
            ByteBuffer c4 = bVar.c((int) bVar.size(), 0L);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            c4.order(byteOrder);
            if (c4.order() == byteOrder) {
                int capacity = c4.capacity() - 24;
                if (capacity >= 8) {
                    int capacity2 = c4.capacity();
                    if (capacity <= c4.capacity()) {
                        int limit = c4.limit();
                        int position = c4.position();
                        int i3 = 0;
                        try {
                            c4.position(0);
                            c4.limit(capacity);
                            c4.position(8);
                            ByteBuffer slice = c4.slice();
                            slice.order(c4.order());
                            while (slice.hasRemaining()) {
                                i3++;
                                if (slice.remaining() >= 8) {
                                    long j3 = slice.getLong();
                                    if (j3 >= 4 && j3 <= 2147483647L) {
                                        int i4 = (int) j3;
                                        int position2 = slice.position() + i4;
                                        if (i4 <= slice.remaining()) {
                                            if (slice.getInt() == i) {
                                                return new u(b(slice, i4 - 4), j2, cVar.f1389a, cVar.f1392d, cVar.f1393e);
                                            }
                                            slice.position(position2);
                                        } else {
                                            throw new Exception("APK Signing Block entry #" + i3 + " size out of range: " + i4 + ", available: " + slice.remaining());
                                        }
                                    } else {
                                        throw new Exception("APK Signing Block entry #" + i3 + " size out of range: " + j3);
                                    }
                                } else {
                                    throw new Exception(e0.a.c(i3, "Insufficient data to read size of APK Signing Block entry #"));
                                }
                            }
                            throw new Exception(e0.a.c(i, "No APK Signature Scheme block in APK Signing Block with ID: "));
                        } finally {
                            c4.position(0);
                            c4.limit(limit);
                            c4.position(position);
                        }
                    }
                    throw new IllegalArgumentException(AbstractC0008a.k("end > capacity: ", capacity, capacity2, " > "));
                }
                throw new IllegalArgumentException(AbstractC0008a.j(capacity, "end < start: ", " < 8"));
            }
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        } catch (ApkSigningBlockNotFoundException e4) {
            throw new Exception(e4.getMessage(), e4);
        }
    }

    public static ByteBuffer b(ByteBuffer byteBuffer, int i) {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i3 = i + position;
            if (i3 >= position && i3 <= limit) {
                byteBuffer.limit(i3);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i3);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException(e0.a.c(i, "size: "));
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return b(byteBuffer, i);
                }
                StringBuilder w3 = AbstractC0008a.w(i, "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: ");
                w3.append(byteBuffer.remaining());
                throw new Exception(w3.toString());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new Exception("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static ArrayList d(ArrayList arrayList, int i, int i3, boolean z3) {
        int i4;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            r rVar = (r) obj;
            t tVar = rVar.f1483a;
            if (z3) {
                i4 = tVar.f1499f;
            } else {
                i4 = tVar.f1498e;
            }
            if (i4 <= i3) {
                if (i4 < i5) {
                    i5 = i4;
                }
                r rVar2 = (r) hashMap.get(Integer.valueOf(i4));
                if (rVar2 != null) {
                    t tVar2 = rVar2.f1483a;
                    s sVar = tVar.f1496c;
                    s sVar2 = tVar2.f1496c;
                    int ordinal = sVar.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                int ordinal2 = sVar2.ordinal();
                                if (ordinal2 != 0) {
                                    if (ordinal2 != 1 && ordinal2 != 2) {
                                        throw new IllegalArgumentException("Unknown alg2: " + sVar2);
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("Unknown alg1: " + sVar);
                            }
                        } else {
                            int ordinal3 = sVar2.ordinal();
                            if (ordinal3 != 0) {
                                if (ordinal3 == 1) {
                                    continue;
                                } else if (ordinal3 != 2) {
                                    throw new IllegalArgumentException("Unknown alg2: " + sVar2);
                                }
                            }
                        }
                    } else {
                        int ordinal4 = sVar2.ordinal();
                        if (ordinal4 != 0 && ordinal4 != 1 && ordinal4 != 2) {
                            throw new IllegalArgumentException("Unknown alg2: " + sVar2);
                        }
                    }
                }
                hashMap.put(Integer.valueOf(i4), rVar);
            }
        }
        if (i >= i5) {
            if (!hashMap.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(hashMap.values());
                Collections.sort(arrayList2, new C0019c2(2));
                return arrayList2;
            }
            throw new Exception("No supported signature");
        }
        throw new Exception(AbstractC0008a.k("Minimum provided signature version ", i5, i, " > minSdkVersion "));
    }

    public static byte[] e(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            StringBuilder w3 = AbstractC0008a.w(i, "Underflow while reading length-prefixed value. Length: ", ", available: ");
            w3.append(byteBuffer.remaining());
            throw new Exception(w3.toString());
        }
        throw new Exception("Negative length");
    }

    public static String f(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            int i = (b4 & ForkServer.ERROR) >>> 4;
            char[] cArr = f1482a;
            sb.append(cArr[i]);
            sb.append(cArr[b4 & 15]);
        }
        return sb.toString();
    }
}
