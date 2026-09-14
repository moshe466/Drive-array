package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Alphabet {
        final int a;
        final int b;
        final int c;
        private final char[] chars;
        final int d;
        private final byte[] decodabet;
        private final String name;
        private final boolean[] validPadding;

        Alphabet(String str, char[] cArr) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                this.b = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                int min = Math.min(8, Integer.lowestOneBit(this.b));
                try {
                    this.c = 8 / min;
                    this.d = this.b / min;
                    this.a = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c = cArr[i];
                        Preconditions.checkArgument(c < bArr.length, "Non-ASCII character: %s", c);
                        Preconditions.checkArgument(bArr[c] == -1, "Duplicate character: %s", c);
                        bArr[c] = (byte) i;
                    }
                    this.decodabet = bArr;
                    boolean[] zArr = new boolean[this.c];
                    for (int i2 = 0; i2 < this.d; i2++) {
                        zArr[IntMath.divide(i2 * 8, this.b, RoundingMode.CEILING)] = true;
                    }
                    this.validPadding = zArr;
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e);
                }
            } catch (ArithmeticException e2) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e2);
            }
        }

        private boolean hasLowerCase() {
            for (char c : this.chars) {
                if (Ascii.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char c : this.chars) {
                if (Ascii.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        char a(int i) {
            return this.chars[i];
        }

        Alphabet a() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i >= cArr2.length) {
                    return new Alphabet(this.name + ".lowerCase()", cArr);
                }
                cArr[i] = Ascii.toLowerCase(cArr2[i]);
                i++;
            }
        }

        boolean a(char c) {
            return c <= 127 && this.decodabet[c] != -1;
        }

        int b(char c) {
            if (c > 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c));
            }
            byte b = this.decodabet[c];
            if (b != -1) {
                return b;
            }
            if (c <= ' ' || c == 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c));
            }
            throw new DecodingException("Unrecognized character: " + c);
        }

        Alphabet b() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i >= cArr2.length) {
                    return new Alphabet(this.name + ".upperCase()", cArr);
                }
                cArr[i] = Ascii.toUpperCase(cArr2[i]);
                i++;
            }
        }

        boolean b(int i) {
            return this.validPadding[i % this.c];
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Alphabet) {
                return Arrays.equals(this.chars, ((Alphabet) obj).chars);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }

        public boolean matches(char c) {
            byte[] bArr = this.decodabet;
            return c < bArr.length && bArr[c] != -1;
        }

        public String toString() {
            return this.name;
        }
    }

    /* loaded from: classes2.dex */
    static final class Base16Encoding extends StandardBaseEncoding {
        final char[] c;

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.c = new char[512];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i = 0; i < 256; i++) {
                this.c[i] = alphabet.a(i >>> 4);
                this.c[i | 256] = alphabet.a(i & 15);
            }
        }

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new DecodingException("Invalid input length " + charSequence.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                bArr[i2] = (byte) ((this.a.b(charSequence.charAt(i)) << 4) | this.a.b(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding a(Alphabet alphabet, @NullableDecl Character ch) {
            return new Base16Encoding(alphabet);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.c[i4]);
                appendable.append(this.c[i4 | 256]);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class Base64Encoding extends StandardBaseEncoding {
        private Base64Encoding(Alphabet alphabet, @NullableDecl Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }

        Base64Encoding(String str, String str2, @NullableDecl Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) {
            Preconditions.checkNotNull(bArr);
            CharSequence b = b(charSequence);
            if (!this.a.b(b.length())) {
                throw new DecodingException("Invalid input length " + b.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < b.length()) {
                int i3 = i + 1;
                int i4 = i3 + 1;
                int b2 = (this.a.b(b.charAt(i)) << 18) | (this.a.b(b.charAt(i3)) << 12);
                int i5 = i2 + 1;
                bArr[i2] = (byte) (b2 >>> 16);
                if (i4 < b.length()) {
                    int i6 = i4 + 1;
                    int b3 = b2 | (this.a.b(b.charAt(i4)) << 6);
                    i2 = i5 + 1;
                    bArr[i5] = (byte) ((b3 >>> 8) & 255);
                    if (i6 < b.length()) {
                        i4 = i6 + 1;
                        i5 = i2 + 1;
                        bArr[i2] = (byte) ((b3 | this.a.b(b.charAt(i6))) & 255);
                    } else {
                        i = i6;
                    }
                }
                i2 = i5;
                i = i4;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding a(Alphabet alphabet, @NullableDecl Character ch) {
            return new Base64Encoding(alphabet, ch);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(appendable);
            int i3 = i + i2;
            Preconditions.checkPositionIndexes(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                appendable.append(this.a.a(i6 >>> 18));
                appendable.append(this.a.a((i6 >>> 12) & 63));
                appendable.append(this.a.a((i6 >>> 6) & 63));
                appendable.append(this.a.a(i6 & 63));
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                b(appendable, bArr, i, i3 - i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i;
            Preconditions.checkArgument(i > 0, "Cannot add a separator after every %s chars", i);
        }

        @Override // com.google.common.io.BaseEncoding
        int a(int i) {
            return this.delegate.a(i);
        }

        @Override // com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.a(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) {
            this.delegate.a(BaseEncoding.a(appendable, this.separator, this.afterEveryChars), bArr, i, i2);
        }

        @Override // com.google.common.io.BaseEncoding
        int b(int i) {
            int b = this.delegate.b(i);
            return b + (this.separator.length() * IntMath.divide(Math.max(0, b - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence b(CharSequence charSequence) {
            return this.delegate.b(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(BaseEncoding.a(reader, this.separator));
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(BaseEncoding.a(writer, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    /* loaded from: classes2.dex */
    static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet a;

        @NullableDecl
        final Character b;

        @MonotonicNonNullDecl
        private transient BaseEncoding lowerCase;

        @MonotonicNonNullDecl
        private transient BaseEncoding upperCase;

        StandardBaseEncoding(Alphabet alphabet, @NullableDecl Character ch) {
            this.a = (Alphabet) Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(ch == null || !alphabet.matches(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.b = ch;
        }

        StandardBaseEncoding(String str, String str2, @NullableDecl Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        int a(int i) {
            return (int) (((this.a.b * i) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) {
            Alphabet alphabet;
            Preconditions.checkNotNull(bArr);
            CharSequence b = b(charSequence);
            if (!this.a.b(b.length())) {
                throw new DecodingException("Invalid input length " + b.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < b.length()) {
                long j = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    alphabet = this.a;
                    if (i3 >= alphabet.c) {
                        break;
                    }
                    j <<= alphabet.b;
                    if (i + i3 < b.length()) {
                        j |= this.a.b(b.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = alphabet.d;
                int i6 = (i5 * 8) - (i4 * alphabet.b);
                int i7 = (i5 - 1) * 8;
                while (i7 >= i6) {
                    bArr[i2] = (byte) ((j >>> i7) & 255);
                    i7 -= 8;
                    i2++;
                }
                i += this.a.c;
            }
            return i2;
        }

        BaseEncoding a(Alphabet alphabet, @NullableDecl Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        @Override // com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                b(appendable, bArr, i + i3, Math.min(this.a.d, i2 - i3));
                i3 += this.a.d;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        int b(int i) {
            Alphabet alphabet = this.a;
            return alphabet.c * IntMath.divide(i, alphabet.d, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence b(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.b;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        void b(Appendable appendable, byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            Preconditions.checkArgument(i2 <= this.a.d);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | (bArr[i + i4] & 255)) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.a.b;
            while (i3 < i2 * 8) {
                Alphabet alphabet = this.a;
                appendable.append(alphabet.a(((int) (j >>> (i5 - i3))) & alphabet.a));
                i3 += this.a.b;
            }
            if (this.b != null) {
                while (i3 < this.a.d * 8) {
                    appendable.append(this.b.charValue());
                    i3 += this.a.b;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence b = b(charSequence);
            if (!this.a.b(b.length())) {
                return false;
            }
            for (int i = 0; i < b.length(); i++) {
                if (!this.a.a(b.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2
                int a = 0;
                int b = 0;
                int c = 0;
                boolean d = false;

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    reader.close();
                }

                /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
                
                    throw new com.google.common.io.BaseEncoding.DecodingException("Padding cannot start at index " + r4.c);
                 */
                @Override // java.io.InputStream
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public int read() {
                    /*
                        r4 = this;
                    L0:
                        java.io.Reader r0 = r2
                        int r0 = r0.read()
                        r1 = -1
                        if (r0 != r1) goto L34
                        boolean r0 = r4.d
                        if (r0 != 0) goto L33
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.a
                        int r2 = r4.c
                        boolean r0 = r0.b(r2)
                        if (r0 == 0) goto L1a
                        goto L33
                    L1a:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Invalid input length "
                        r1.append(r2)
                        int r2 = r4.c
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L33:
                        return r1
                    L34:
                        int r1 = r4.c
                        r2 = 1
                        int r1 = r1 + r2
                        r4.c = r1
                        char r0 = (char) r0
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        java.lang.Character r1 = r1.b
                        if (r1 == 0) goto L78
                        char r1 = r1.charValue()
                        if (r1 != r0) goto L78
                        boolean r0 = r4.d
                        if (r0 != 0) goto L75
                        int r0 = r4.c
                        if (r0 == r2) goto L5c
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.a
                        int r0 = r0 + (-1)
                        boolean r0 = r1.b(r0)
                        if (r0 == 0) goto L5c
                        goto L75
                    L5c:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Padding cannot start at index "
                        r1.append(r2)
                        int r2 = r4.c
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L75:
                        r4.d = r2
                        goto L0
                    L78:
                        boolean r1 = r4.d
                        if (r1 != 0) goto Lac
                        int r1 = r4.a
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.a
                        int r3 = r2.b
                        int r1 = r1 << r3
                        r4.a = r1
                        int r1 = r4.a
                        int r0 = r2.b(r0)
                        r0 = r0 | r1
                        r4.a = r0
                        int r0 = r4.b
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.a
                        int r1 = r1.b
                        int r0 = r0 + r1
                        r4.b = r0
                        int r0 = r4.b
                        r1 = 8
                        if (r0 < r1) goto L0
                        int r0 = r0 - r1
                        r4.b = r0
                        int r0 = r4.a
                        int r1 = r4.b
                        int r0 = r0 >> r1
                        r0 = r0 & 255(0xff, float:3.57E-43)
                        return r0
                    Lac:
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Expected padding character but found '"
                        r2.append(r3)
                        r2.append(r0)
                        java.lang.String r0 = "' at index "
                        r2.append(r0)
                        int r0 = r4.c
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        r1.<init>(r0)
                        goto Lce
                    Lcd:
                        throw r1
                    Lce:
                        goto Lcd
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2.read():int");
                }
            };
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.1
                int a = 0;
                int b = 0;
                int c = 0;

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    int i = this.b;
                    if (i > 0) {
                        int i2 = this.a;
                        Alphabet alphabet = StandardBaseEncoding.this.a;
                        writer.write(alphabet.a((i2 << (alphabet.b - i)) & alphabet.a));
                        this.c++;
                        if (StandardBaseEncoding.this.b != null) {
                            while (true) {
                                int i3 = this.c;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i3 % standardBaseEncoding.a.c == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.b.charValue());
                                this.c++;
                            }
                        }
                    }
                    writer.close();
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() {
                    writer.flush();
                }

                @Override // java.io.OutputStream
                public void write(int i) {
                    this.a <<= 8;
                    this.a = (i & 255) | this.a;
                    int i2 = this.b + 8;
                    while (true) {
                        this.b = i2;
                        int i3 = this.b;
                        Alphabet alphabet = StandardBaseEncoding.this.a;
                        int i4 = alphabet.b;
                        if (i3 < i4) {
                            return;
                        }
                        writer.write(alphabet.a((this.a >> (i3 - i4)) & alphabet.a));
                        this.c++;
                        i2 = this.b - StandardBaseEncoding.this.a.b;
                    }
                }
            };
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            return this.a.equals(standardBaseEncoding.a) && Objects.equal(this.b, standardBaseEncoding.b);
        }

        public int hashCode() {
            return this.a.hashCode() ^ Objects.hashCode(this.b);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet a = this.a.a();
                baseEncoding = a == this.a ? this : a(a, this.b);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.b == null ? this : a(this.a, (Character) null);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.a.toString());
            if (8 % this.a.b != 0) {
                if (this.b == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.b);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet b = this.a.b();
                baseEncoding = b == this.a ? this : a(b, this.b);
                this.upperCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            Character ch;
            return (8 % this.a.b == 0 || ((ch = this.b) != null && ch.charValue() == c)) ? this : a(this.a, Character.valueOf(c));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                Preconditions.checkArgument(!this.a.matches(str.charAt(i2)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.b;
            if (ch != null) {
                Preconditions.checkArgument(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i);
        }
    }

    BaseEncoding() {
    }

    @GwtIncompatible
    static Reader a(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                reader.close();
            }

            @Override // java.io.Reader
            public int read() {
                int read;
                do {
                    read = reader.read();
                    if (read == -1) {
                        break;
                    }
                } while (str.indexOf((char) read) >= 0);
                return read;
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i, int i2) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @GwtIncompatible
    static Writer a(final Writer writer, String str, int i) {
        final Appendable a = a((Appendable) writer, str, i);
        return new Writer() { // from class: com.google.common.io.BaseEncoding.5
            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                writer.close();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() {
                writer.flush();
            }

            @Override // java.io.Writer
            public void write(int i2) {
                a.append((char) i2);
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i2, int i3) {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Appendable a(final Appendable appendable, final String str, final int i) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i > 0);
        return new Appendable() { // from class: com.google.common.io.BaseEncoding.4
            int a;

            {
                this.a = i;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c) {
                if (this.a == 0) {
                    appendable.append(str);
                    this.a = i;
                }
                appendable.append(c);
                this.a--;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(@NullableDecl CharSequence charSequence) {
                throw new UnsupportedOperationException();
            }

            @Override // java.lang.Appendable
            public Appendable append(@NullableDecl CharSequence charSequence, int i2, int i3) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    private static byte[] extract(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    abstract int a(int i);

    abstract int a(byte[] bArr, CharSequence charSequence);

    abstract void a(Appendable appendable, byte[] bArr, int i, int i2);

    final byte[] a(CharSequence charSequence) {
        CharSequence b = b(charSequence);
        byte[] bArr = new byte[a(b.length())];
        return extract(bArr, a(bArr, b));
    }

    abstract int b(int i);

    CharSequence b(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public abstract boolean canDecode(CharSequence charSequence);

    public final byte[] decode(CharSequence charSequence) {
        try {
            return a(charSequence);
        } catch (DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @GwtIncompatible
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() { // from class: com.google.common.io.BaseEncoding.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public final String encode(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(b(i2));
        try {
            a(sb, bArr, i, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @GwtIncompatible
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() { // from class: com.google.common.io.BaseEncoding.1
            @Override // com.google.common.io.ByteSink
            public OutputStream openStream() {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c);

    public abstract BaseEncoding withSeparator(String str, int i);
}
