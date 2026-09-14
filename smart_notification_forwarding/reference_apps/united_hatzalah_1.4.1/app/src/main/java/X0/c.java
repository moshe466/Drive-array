package X0;

import F0.AbstractC0008a;
import F0.C0047j2;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.DataFormatException;

/* loaded from: classes.dex */
public abstract class c {
    static {
        ByteBuffer.allocate(0);
    }

    public static byte[] a(Y0.b bVar, a aVar, long j2) {
        long j3 = aVar.f2579e;
        String str = aVar.f2581g;
        if (j3 <= 2147483647L) {
            try {
                byte[] bArr = new byte[(int) j3];
                b(bVar, aVar, j2, new C0047j2(ByteBuffer.wrap(bArr), 8));
                return bArr;
            } catch (OutOfMemoryError e4) {
                throw new IOException(str + " too large: " + j3, e4);
            }
        }
        throw new IOException(str + " too large: " + j3);
    }

    public static void b(Y0.b bVar, a aVar, long j2, Y0.a aVar2) {
        boolean z3;
        boolean z4;
        String str;
        boolean z5;
        long j3;
        String str2;
        b bVar2;
        String str3 = aVar.f2581g;
        int i = aVar.f2582h;
        int i3 = i + 30;
        long j4 = aVar.f2580f;
        long j5 = i3 + j4;
        if (j5 <= j2) {
            try {
                ByteBuffer c4 = bVar.c(i3, j4);
                c4.order(ByteOrder.LITTLE_ENDIAN);
                int i4 = c4.getInt();
                if (i4 == 67324752) {
                    if ((c4.getShort(6) & 8) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((aVar.f2575a & 8) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z3 == z4) {
                        long j6 = aVar.f2577c;
                        long j7 = aVar.f2578d;
                        long j8 = aVar.f2579e;
                        if (!z3) {
                            str = ", CD start: ";
                            long j9 = c4.getInt(14) & KeyboardMap.kValueMask;
                            if (j9 == j6) {
                                long j10 = c4.getInt(18) & KeyboardMap.kValueMask;
                                if (j10 == j7) {
                                    long j11 = c4.getInt(22) & KeyboardMap.kValueMask;
                                    if (j11 != j8) {
                                        throw new Exception("Uncompressed size mismatch between Local File Header and Central Directory for entry " + str3 + ". LFH: " + j11 + ", CD: " + j8);
                                    }
                                } else {
                                    throw new Exception("Compressed size mismatch between Local File Header and Central Directory for entry " + str3 + ". LFH: " + j10 + ", CD: " + j7);
                                }
                            } else {
                                throw new Exception("CRC-32 mismatch between Local File Header and Central Directory for entry " + str3 + ". LFH: " + j9 + ", CD: " + j6);
                            }
                        } else {
                            str = ", CD start: ";
                        }
                        int i5 = c4.getShort(26) & 65535;
                        if (i5 <= i) {
                            String a2 = a.a(30, c4, i5);
                            if (str3.equals(a2)) {
                                long j12 = j4 + 30 + i5 + (c4.getShort(28) & 65535);
                                if (aVar.f2576b != 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    j3 = j7;
                                } else {
                                    j3 = j8;
                                }
                                long j13 = j12 + j3;
                                if (j13 <= j2) {
                                    long j14 = j4 + i5 + 30 + r5;
                                    try {
                                        if (z5) {
                                            try {
                                                b bVar3 = new b(aVar2);
                                                try {
                                                    bVar.a(j14, j3, bVar3);
                                                    bVar2 = bVar3;
                                                    try {
                                                        long j15 = bVar2.f2587e;
                                                        if (j15 == j8) {
                                                            bVar2.close();
                                                            return;
                                                        }
                                                        throw new Exception("Unexpected size of uncompressed data of " + str3 + ". Expected: " + j8 + " bytes, actual: " + j15 + " bytes");
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        Throwable th2 = th;
                                                        try {
                                                            bVar2.close();
                                                            throw th2;
                                                        } catch (Throwable th3) {
                                                            th2.addSuppressed(th3);
                                                            throw th2;
                                                        }
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    bVar2 = bVar3;
                                                }
                                            } catch (IOException e4) {
                                                if (e4.getCause() instanceof DataFormatException) {
                                                    throw new Exception("Data of entry " + str3 + " malformed", e4);
                                                }
                                                throw e4;
                                            }
                                        } else {
                                            bVar.a(j14, j3, aVar2);
                                        }
                                    } catch (IOException e5) {
                                        StringBuilder sb = new StringBuilder("Failed to read data of ");
                                        if (z5) {
                                            str2 = "compressed";
                                        } else {
                                            str2 = "uncompressed";
                                        }
                                        throw new IOException(AbstractC0008a.v(sb, str2, " entry ", str3), e5);
                                    }
                                } else {
                                    throw new Exception("Local File Header data of " + str3 + " overlaps with Central Directory. LFH data start: " + j12 + ", LFH data end: " + j13 + str + j2);
                                }
                            } else {
                                throw new Exception(AbstractC0008a.p("Name mismatch between Local File Header and Central Directory. LFH: \"", a2, "\", CD: \"", str3, "\""));
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder("Name mismatch between Local File Header and Central Directory for entry");
                            sb2.append(str3);
                            sb2.append(". LFH: ");
                            sb2.append(i5);
                            sb2.append(" bytes, CD: ");
                            throw new Exception(AbstractC0008a.r(sb2, i, " bytes"));
                        }
                    } else {
                        throw new Exception("Data Descriptor presence mismatch between Local File Header and Central Directory for entry " + str3 + ". LFH: " + z3 + ", CD: " + z4);
                    }
                } else {
                    throw new Exception("Not a Local File Header record for entry " + str3 + ". Signature: 0x" + Long.toHexString(i4 & KeyboardMap.kValueMask));
                }
            } catch (IOException e6) {
                throw new IOException("Failed to read Local File Header of ".concat(str3), e6);
            }
        } else {
            throw new Exception("Local File Header of " + str3 + " extends beyond start of Central Directory. LFH end: " + j5 + ", CD start: " + j2);
        }
    }
}
