package com.google.android.gms.internal.ads;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes.dex */
public final class zzdvo {
    private final ByteBuffer zzako;
    private zzdrb zzhtk;
    private int zzhtl;

    private zzdvo(ByteBuffer byteBuffer) {
        this.zzako = byteBuffer;
        this.zzako.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzdvo(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static zzdvo zzaa(byte[] bArr) {
        return zzq(bArr, 0, bArr.length);
    }

    public static int zzaf(int i, int i2) {
        return zzfz(i) + zzga(i2);
    }

    public static int zzb(int i, zzdvt zzdvtVar) {
        int zzfz = zzfz(i);
        int zzazu = zzdvtVar.zzazu();
        return zzfz + zzgh(zzazu) + zzazu;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v26 */
    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char charAt;
        int i3;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i4 = 0;
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i4 < length) {
                char charAt2 = charSequence.charAt(i4);
                char c = charAt2;
                if (charAt2 >= 128) {
                    if (charAt2 < 2048) {
                        i3 = (charAt2 >>> 6) | 960;
                    } else {
                        if (charAt2 >= 55296 && 57343 >= charAt2) {
                            int i5 = i4 + 1;
                            if (i5 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                    i4++;
                                } else {
                                    i4 = i5;
                                }
                            }
                            StringBuilder sb = new StringBuilder(39);
                            sb.append("Unpaired surrogate at index ");
                            sb.append(i4 - 1);
                            throw new IllegalArgumentException(sb.toString());
                        }
                        byteBuffer.put((byte) ((charAt2 >>> '\f') | 480));
                        i3 = ((charAt2 >>> 6) & 63) | 128;
                    }
                    byteBuffer.put((byte) i3);
                    c = (charAt2 & '?') | 128;
                }
                byteBuffer.put((byte) c);
                i4++;
            }
            return;
        }
        try {
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int remaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i6 = remaining + arrayOffset;
            while (i4 < length2) {
                int i7 = i4 + arrayOffset;
                if (i7 >= i6 || (charAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                array[i7] = (byte) charAt;
                i4++;
            }
            if (i4 == length2) {
                i = arrayOffset + length2;
            } else {
                i = arrayOffset + i4;
                while (i4 < length2) {
                    char charAt4 = charSequence.charAt(i4);
                    if (charAt4 >= 128 || i >= i6) {
                        if (charAt4 < 2048 && i <= i6 - 2) {
                            int i8 = i + 1;
                            array[i] = (byte) ((charAt4 >>> 6) | 960);
                            i = i8 + 1;
                            array[i8] = (byte) ((charAt4 & '?') | 128);
                        } else {
                            if ((charAt4 >= 55296 && 57343 >= charAt4) || i > i6 - 3) {
                                if (i > i6 - 4) {
                                    StringBuilder sb2 = new StringBuilder(37);
                                    sb2.append("Failed writing ");
                                    sb2.append(charAt4);
                                    sb2.append(" at index ");
                                    sb2.append(i);
                                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                }
                                int i9 = i4 + 1;
                                if (i9 != charSequence.length()) {
                                    char charAt5 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(charAt4, charAt5)) {
                                        int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                        int i10 = i + 1;
                                        array[i] = (byte) ((codePoint2 >>> 18) | 240);
                                        int i11 = i10 + 1;
                                        array[i10] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                        i = i12 + 1;
                                        array[i12] = (byte) ((codePoint2 & 63) | 128);
                                        i4 = i9;
                                    } else {
                                        i4 = i9;
                                    }
                                }
                                StringBuilder sb3 = new StringBuilder(39);
                                sb3.append("Unpaired surrogate at index ");
                                sb3.append(i4 - 1);
                                throw new IllegalArgumentException(sb3.toString());
                            }
                            int i13 = i + 1;
                            array[i] = (byte) ((charAt4 >>> '\f') | 480);
                            int i14 = i13 + 1;
                            array[i13] = (byte) (((charAt4 >>> 6) & 63) | 128);
                            i2 = i14 + 1;
                            array[i14] = (byte) ((charAt4 & '?') | 128);
                        }
                        i4++;
                    } else {
                        i2 = i + 1;
                        array[i] = (byte) charAt4;
                    }
                    i = i2;
                    i4++;
                }
            }
            byteBuffer.position(i - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int zzfz(int i) {
        return zzgh(i << 3);
    }

    public static int zzg(int i, String str) {
        return zzfz(i) + zzhh(str);
    }

    public static int zzga(int i) {
        if (i >= 0) {
            return zzgh(i);
        }
        return 10;
    }

    public static int zzgh(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    private final void zzha(int i) {
        byte b = (byte) i;
        if (!this.zzako.hasRemaining()) {
            throw new zzdvn(this.zzako.position(), this.zzako.limit());
        }
        this.zzako.put(b);
    }

    private final void zzhb(int i) {
        while ((i & (-128)) != 0) {
            zzha((i & 127) | 128);
            i >>>= 7;
        }
        zzha(i);
    }

    public static int zzhh(String str) {
        int zza = zza(str);
        return zzgh(zza) + zza;
    }

    public static zzdvo zzq(byte[] bArr, int i, int i2) {
        return new zzdvo(bArr, 0, i2);
    }

    public final void zza(int i, zzdvt zzdvtVar) {
        zzaa(i, 2);
        if (zzdvtVar.a < 0) {
            zzdvtVar.zzazu();
        }
        zzhb(zzdvtVar.a);
        zzdvtVar.zza(this);
    }

    public final void zza(int i, byte[] bArr) {
        zzaa(3, 2);
        zzhb(bArr.length);
        int length = bArr.length;
        if (this.zzako.remaining() < length) {
            throw new zzdvn(this.zzako.position(), this.zzako.limit());
        }
        this.zzako.put(bArr, 0, length);
    }

    public final void zzaa(int i, int i2) {
        zzhb((i << 3) | i2);
    }

    public final void zzab(int i, int i2) {
        zzaa(i, 0);
        if (i2 >= 0) {
            zzhb(i2);
        } else {
            zzfs(i2);
        }
    }

    public final void zzazd() {
        if (this.zzako.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzako.remaining())));
        }
    }

    public final void zze(int i, zzdte zzdteVar) {
        if (this.zzhtk != null) {
            if (this.zzhtl != this.zzako.position()) {
                this.zzhtk.write(this.zzako.array(), this.zzhtl, this.zzako.position() - this.zzhtl);
            }
            zzdrb zzdrbVar = this.zzhtk;
            zzdrbVar.zza(i, zzdteVar);
            zzdrbVar.flush();
            this.zzhtl = this.zzako.position();
        }
        this.zzhtk = zzdrb.zzm(this.zzako);
        this.zzhtl = this.zzako.position();
        zzdrb zzdrbVar2 = this.zzhtk;
        zzdrbVar2.zza(i, zzdteVar);
        zzdrbVar2.flush();
        this.zzhtl = this.zzako.position();
    }

    public final void zzf(int i, String str) {
        zzaa(i, 2);
        try {
            int zzgh = zzgh(str.length());
            if (zzgh != zzgh(str.length() * 3)) {
                zzhb(zza(str));
                zzd(str, this.zzako);
                return;
            }
            int position = this.zzako.position();
            if (this.zzako.remaining() < zzgh) {
                throw new zzdvn(position + zzgh, this.zzako.limit());
            }
            this.zzako.position(position + zzgh);
            zzd(str, this.zzako);
            int position2 = this.zzako.position();
            this.zzako.position(position);
            zzhb((position2 - position) - zzgh);
            this.zzako.position(position2);
        } catch (BufferOverflowException e) {
            zzdvn zzdvnVar = new zzdvn(this.zzako.position(), this.zzako.limit());
            zzdvnVar.initCause(e);
            throw zzdvnVar;
        }
    }

    public final void zzfs(long j) {
        while (((-128) & j) != 0) {
            zzha((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzha((int) j);
    }
}
