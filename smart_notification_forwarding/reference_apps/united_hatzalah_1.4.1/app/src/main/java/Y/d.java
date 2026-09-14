package Y;

import F0.AbstractC0008a;
import android.util.Log;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f2639a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2640b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2641c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2642d;

    public d(byte[] bArr, int i, int i3) {
        this(-1L, bArr, i, i3);
    }

    public static d a(String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new d(new byte[]{(byte) (str.charAt(0) - '0')}, 1, 1);
        }
        byte[] bytes = str.getBytes(h.f2676b0);
        return new d(bytes, 1, bytes.length);
    }

    public static d b(String str) {
        byte[] bytes = str.concat("\u0000").getBytes(h.f2676b0);
        return new d(bytes, 2, bytes.length);
    }

    public static d c(long j2, ByteOrder byteOrder) {
        return d(new long[]{j2}, byteOrder);
    }

    public static d d(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f2667S[4] * jArr.length]);
        wrap.order(byteOrder);
        for (long j2 : jArr) {
            wrap.putInt((int) j2);
        }
        return new d(wrap.array(), 4, jArr.length);
    }

    public static d e(f[] fVarArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f2667S[5] * fVarArr.length]);
        wrap.order(byteOrder);
        for (f fVar : fVarArr) {
            wrap.putInt((int) fVar.f2647a);
            wrap.putInt((int) fVar.f2648b);
        }
        return new d(wrap.array(), 5, fVarArr.length);
    }

    public static d f(int i, ByteOrder byteOrder) {
        return g(new int[]{i}, byteOrder);
    }

    public static d g(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[h.f2667S[3] * iArr.length]);
        wrap.order(byteOrder);
        for (int i : iArr) {
            wrap.putShort((short) i);
        }
        return new d(wrap.array(), 3, iArr.length);
    }

    public final double h(ByteOrder byteOrder) {
        Object k4 = k(byteOrder);
        if (k4 != null) {
            if (k4 instanceof String) {
                return Double.parseDouble((String) k4);
            }
            if (k4 instanceof long[]) {
                if (((long[]) k4).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k4 instanceof int[]) {
                if (((int[]) k4).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k4 instanceof double[]) {
                double[] dArr = (double[]) k4;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k4 instanceof f[]) {
                f[] fVarArr = (f[]) k4;
                if (fVarArr.length == 1) {
                    f fVar = fVarArr[0];
                    return fVar.f2647a / fVar.f2648b;
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a double value");
        }
        throw new NumberFormatException("NULL can't be converted to a double value");
    }

    public final int i(ByteOrder byteOrder) {
        Object k4 = k(byteOrder);
        if (k4 != null) {
            if (k4 instanceof String) {
                return Integer.parseInt((String) k4);
            }
            if (k4 instanceof long[]) {
                long[] jArr = (long[]) k4;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k4 instanceof int[]) {
                int[] iArr = (int[]) k4;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            throw new NumberFormatException("Couldn't find a integer value");
        }
        throw new NumberFormatException("NULL can't be converted to a integer value");
    }

    public final String j(ByteOrder byteOrder) {
        Object k4 = k(byteOrder);
        if (k4 != null) {
            if (k4 instanceof String) {
                return (String) k4;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (k4 instanceof long[]) {
                long[] jArr = (long[]) k4;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k4 instanceof int[]) {
                int[] iArr = (int[]) k4;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k4 instanceof double[]) {
                double[] dArr = (double[]) k4;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k4 instanceof f[]) {
                f[] fVarArr = (f[]) k4;
                while (i < fVarArr.length) {
                    sb.append(fVarArr[i].f2647a);
                    sb.append('/');
                    sb.append(fVarArr[i].f2648b);
                    i++;
                    if (i != fVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v20, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v21, types: [long[]] */
    /* JADX WARN: Type inference failed for: r14v22, types: [Y.f[]] */
    /* JADX WARN: Type inference failed for: r14v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v24, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v25, types: [Y.f[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [double[]] */
    /* JADX WARN: Type inference failed for: r14v27, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r14v28, types: [double[]] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.String] */
    public final Serializable k(ByteOrder byteOrder) {
        b bVar;
        ?? str;
        byte b4;
        byte[] bArr = this.f2642d;
        b bVar2 = null;
        try {
            bVar = new b(bArr);
            try {
                bVar.f2634c = byteOrder;
                int i = this.f2639a;
                int i3 = 0;
                int i4 = this.f2640b;
                switch (i) {
                    case 1:
                    case 6:
                        if (bArr.length == 1 && (b4 = bArr[0]) >= 0 && b4 <= 1) {
                            String str2 = new String(new char[]{(char) (b4 + 48)});
                            try {
                                bVar.close();
                                return str2;
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                                return str2;
                            }
                        }
                        str = new String(bArr, h.f2676b0);
                        break;
                    case 2:
                    case 7:
                        if (i4 >= h.f2668T.length) {
                            int i5 = 0;
                            while (true) {
                                byte[] bArr2 = h.f2668T;
                                if (i5 < bArr2.length) {
                                    if (bArr[i5] == bArr2[i5]) {
                                        i5++;
                                    }
                                } else {
                                    i3 = bArr2.length;
                                }
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        while (i3 < i4) {
                            byte b5 = bArr[i3];
                            if (b5 != 0) {
                                if (b5 >= 32) {
                                    sb.append((char) b5);
                                } else {
                                    sb.append('?');
                                }
                                i3++;
                            } else {
                                str = sb.toString();
                                break;
                            }
                        }
                        str = sb.toString();
                    case 3:
                        str = new int[i4];
                        while (i3 < i4) {
                            str[i3] = bVar.readUnsignedShort();
                            i3++;
                        }
                    case 4:
                        str = new long[i4];
                        while (i3 < i4) {
                            str[i3] = bVar.readInt() & KeyboardMap.kValueMask;
                            i3++;
                        }
                    case 5:
                        str = new f[i4];
                        while (i3 < i4) {
                            str[i3] = new f(bVar.readInt() & KeyboardMap.kValueMask, bVar.readInt() & KeyboardMap.kValueMask);
                            i3++;
                        }
                    case 8:
                        str = new int[i4];
                        while (i3 < i4) {
                            str[i3] = bVar.readShort();
                            i3++;
                        }
                    case 9:
                        str = new int[i4];
                        while (i3 < i4) {
                            str[i3] = bVar.readInt();
                            i3++;
                        }
                    case 10:
                        str = new f[i4];
                        while (i3 < i4) {
                            str[i3] = new f(bVar.readInt(), bVar.readInt());
                            i3++;
                        }
                    case 11:
                        str = new double[i4];
                        while (i3 < i4) {
                            str[i3] = bVar.readFloat();
                            i3++;
                        }
                    case Code.UNIMPLEMENTED /* 12 */:
                        str = new double[i4];
                        while (i3 < i4) {
                            str[i3] = bVar.readDouble();
                            i3++;
                        }
                    default:
                        try {
                            bVar.close();
                            return null;
                        } catch (IOException e5) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            return null;
                        }
                }
                try {
                    bVar.close();
                    return str;
                } catch (IOException e6) {
                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                    return str;
                }
            } catch (IOException unused) {
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (IOException e7) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bVar2 = bVar;
                if (bVar2 != null) {
                    try {
                        bVar2.close();
                    } catch (IOException e8) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bVar = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(h.f2666R[this.f2639a]);
        sb.append(", data length:");
        return AbstractC0008a.r(sb, this.f2642d.length, ")");
    }

    public d(long j2, byte[] bArr, int i, int i3) {
        this.f2639a = i;
        this.f2640b = i3;
        this.f2641c = j2;
        this.f2642d = bArr;
    }
}
