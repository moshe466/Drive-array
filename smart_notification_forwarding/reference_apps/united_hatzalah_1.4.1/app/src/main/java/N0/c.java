package N0;

import F0.AbstractC0008a;
import io.flutter.embedding.android.KeyboardMap;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f1430a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1431b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1432c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1433d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1434e;

    public c(int i) {
        this.f1432c = new ArrayList();
        this.f1433d = new ArrayList();
        this.f1434e = new ArrayList();
        this.f1430a = i;
    }

    public boolean a() {
        ArrayList arrayList = (ArrayList) this.f1432c;
        if (((ArrayList) this.f1434e).isEmpty()) {
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((e) obj).b()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public boolean b() {
        ArrayList arrayList = (ArrayList) this.f1432c;
        if (((ArrayList) this.f1433d).isEmpty()) {
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((e) obj).c()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public String c(long j2) {
        byte[] bArr;
        String str;
        byte[] bArr2;
        HashMap hashMap = (HashMap) this.f1434e;
        ByteBuffer byteBuffer = (ByteBuffer) this.f1433d;
        if (j2 >= 0) {
            int i = this.f1430a;
            if (j2 < i) {
                int i3 = (int) j2;
                String str2 = (String) hashMap.get(Integer.valueOf(i3));
                if (str2 != null) {
                    return str2;
                }
                long j3 = ((ByteBuffer) this.f1432c).getInt(i3 * 4) & KeyboardMap.kValueMask;
                if (j3 < byteBuffer.capacity()) {
                    byteBuffer.position((int) j3);
                    int i4 = 0;
                    if (this.f1431b) {
                        if ((byteBuffer.get() & 128) != 0) {
                            byteBuffer.get();
                        }
                        byte b4 = byteBuffer.get();
                        int i5 = b4 & ForkServer.ERROR;
                        if ((b4 & 128) != 0) {
                            i5 = (byteBuffer.get() & ForkServer.ERROR) | ((b4 & Byte.MAX_VALUE) << 8);
                        }
                        if (byteBuffer.hasArray()) {
                            bArr2 = byteBuffer.array();
                            i4 = byteBuffer.arrayOffset() + byteBuffer.position();
                            byteBuffer.position(byteBuffer.position() + i5);
                        } else {
                            bArr2 = new byte[i5];
                            byteBuffer.get(bArr2);
                        }
                        if (bArr2[i4 + i5] == 0) {
                            try {
                                str = new String(bArr2, i4, i5, "UTF-8");
                            } catch (UnsupportedEncodingException e4) {
                                throw new RuntimeException("UTF-8 character encoding not supported", e4);
                            }
                        } else {
                            throw new Exception("UTF-8 encoded form of string not NULL terminated");
                        }
                    } else {
                        short s3 = byteBuffer.getShort();
                        int i6 = s3 & 65535;
                        if ((32768 & s3) != 0) {
                            i6 = ((s3 & Short.MAX_VALUE) << 16) | (65535 & byteBuffer.getShort());
                        }
                        if (i6 <= 1073741823) {
                            int i7 = i6 * 2;
                            if (byteBuffer.hasArray()) {
                                bArr = byteBuffer.array();
                                i4 = byteBuffer.arrayOffset() + byteBuffer.position();
                                byteBuffer.position(byteBuffer.position() + i7);
                            } else {
                                bArr = new byte[i7];
                                byteBuffer.get(bArr);
                            }
                            int i8 = i4 + i7;
                            if (bArr[i8] == 0 && bArr[i8 + 1] == 0) {
                                try {
                                    str = new String(bArr, i4, i7, "UTF-16LE");
                                } catch (UnsupportedEncodingException e5) {
                                    throw new RuntimeException("UTF-16LE character encoding not supported", e5);
                                }
                            } else {
                                throw new Exception("UTF-16 encoded form of string not NULL terminated");
                            }
                        } else {
                            throw new Exception(AbstractC0008a.j(i6, "String too long: ", " uint16s"));
                        }
                    }
                    hashMap.put(Integer.valueOf(i3), str);
                    return str;
                }
                StringBuilder sb = new StringBuilder("Offset of string idx ");
                sb.append(i3);
                sb.append(" out of bounds: ");
                sb.append(j3);
                sb.append(", max: ");
                sb.append(byteBuffer.capacity() - 1);
                throw new Exception(sb.toString());
            }
            StringBuilder x3 = AbstractC0008a.x("Unsuported string index: ", ", max: ", j2);
            x3.append(i - 1);
            throw new Exception(x3.toString());
        }
        throw new Exception(AbstractC0008a.l("Unsuported string index: ", j2));
    }

    public c(b bVar) {
        boolean z3;
        long j2;
        int remaining;
        this.f1434e = new HashMap();
        ByteBuffer byteBuffer = (ByteBuffer) bVar.f1428b;
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        int remaining2 = slice.remaining();
        slice.position(8);
        if (slice.remaining() >= 20) {
            long j3 = slice.getInt() & KeyboardMap.kValueMask;
            if (j3 <= 2147483647L) {
                int i = (int) j3;
                this.f1430a = i;
                long j4 = slice.getInt() & KeyboardMap.kValueMask;
                if (j4 <= 2147483647L) {
                    long j5 = slice.getInt();
                    long j6 = slice.getInt() & KeyboardMap.kValueMask;
                    long j7 = slice.getInt() & KeyboardMap.kValueMask;
                    ByteBuffer c4 = bVar.c();
                    if (i > 0) {
                        z3 = false;
                        long j8 = remaining2;
                        j2 = 0;
                        int i3 = (int) (j6 - j8);
                        if (j4 <= 0) {
                            remaining = c4.remaining();
                        } else {
                            if (j7 < j6) {
                                throw new Exception(e0.a.g(AbstractC0008a.x("Styles offset (", ") < strings offset (", j7), j6, ")"));
                            }
                            remaining = (int) (j7 - j8);
                        }
                        this.f1433d = d.f(i3, c4, remaining);
                    } else {
                        z3 = false;
                        j2 = 0;
                        this.f1433d = ByteBuffer.allocate(0);
                    }
                    this.f1431b = (256 & j5) != j2 ? true : z3;
                    this.f1432c = c4;
                    return;
                }
                throw new Exception(AbstractC0008a.l("Too many styles: ", j4));
            }
            throw new Exception(AbstractC0008a.l("Too many strings: ", j3));
        }
        throw new Exception("XML chunk's header too short. Required at least 20 bytes. Available: " + slice.remaining() + " bytes");
    }
}
