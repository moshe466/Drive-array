package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
/* loaded from: classes2.dex */
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] a;

        BytesHashCode(byte[] bArr) {
            this.a = (byte[]) Preconditions.checkNotNull(bArr);
        }

        @Override // com.google.common.hash.HashCode
        void a(byte[] bArr, int i, int i2) {
            System.arraycopy(this.a, 0, bArr, i, i2);
        }

        @Override // com.google.common.hash.HashCode
        boolean a(HashCode hashCode) {
            if (this.a.length != hashCode.a().length) {
                return false;
            }
            int i = 0;
            boolean z = true;
            while (true) {
                byte[] bArr = this.a;
                if (i >= bArr.length) {
                    return z;
                }
                z &= bArr[i] == hashCode.a()[i];
                i++;
            }
        }

        @Override // com.google.common.hash.HashCode
        byte[] a() {
            return this.a;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.a.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            Preconditions.checkState(this.a.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.a.length);
            byte[] bArr = this.a;
            return ((bArr[3] & 255) << 24) | ((bArr[1] & 255) << 8) | (bArr[0] & 255) | ((bArr[2] & 255) << 16);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            Preconditions.checkState(this.a.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.a.length);
            return padToLong();
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.a.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long j = this.a[0] & 255;
            for (int i = 1; i < Math.min(this.a.length, 8); i++) {
                j |= (this.a[i] & 255) << (i * 8);
            }
            return j;
        }
    }

    /* loaded from: classes2.dex */
    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int a;

        IntHashCode(int i) {
            this.a = i;
        }

        @Override // com.google.common.hash.HashCode
        void a(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i + i3] = (byte) (this.a >> (i3 * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        boolean a(HashCode hashCode) {
            return this.a == hashCode.asInt();
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int i = this.a;
            return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.a;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.a);
        }
    }

    /* loaded from: classes2.dex */
    private static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long a;

        LongHashCode(long j) {
            this.a = j;
        }

        @Override // com.google.common.hash.HashCode
        void a(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i + i3] = (byte) (this.a >> (i3 * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        boolean a(HashCode hashCode) {
            return this.a == hashCode.asLong();
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return new byte[]{(byte) this.a, (byte) (r2 >> 8), (byte) (r2 >> 16), (byte) (r2 >> 24), (byte) (r2 >> 32), (byte) (r2 >> 40), (byte) (r2 >> 48), (byte) (r2 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.a;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.a;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.a;
        }
    }

    HashCode() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashCode a(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    private static int decode(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c);
    }

    public static HashCode fromBytes(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 1, "A HashCode must contain at least 1 byte.");
        return a((byte[]) bArr.clone());
    }

    public static HashCode fromInt(int i) {
        return new IntHashCode(i);
    }

    public static HashCode fromLong(long j) {
        return new LongHashCode(j);
    }

    public static HashCode fromString(String str) {
        Preconditions.checkArgument(str.length() >= 2, "input string (%s) must have at least 2 characters", str);
        Preconditions.checkArgument(str.length() % 2 == 0, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((decode(str.charAt(i)) << 4) + decode(str.charAt(i + 1)));
        }
        return a(bArr);
    }

    abstract void a(byte[] bArr, int i, int i2);

    abstract boolean a(HashCode hashCode);

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return asBytes();
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        return bits() == hashCode.bits() && a(hashCode);
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] a = a();
        int i = a[0] & 255;
        for (int i2 = 1; i2 < a.length; i2++) {
            i |= (a[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] a = a();
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a) {
            sb.append(hexDigits[(b >> 4) & 15]);
            sb.append(hexDigits[b & Ascii.SI]);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i, int i2) {
        int min = Ints.min(i2, bits() / 8);
        Preconditions.checkPositionIndexes(i, i + min, bArr.length);
        a(bArr, i, min);
        return min;
    }
}
