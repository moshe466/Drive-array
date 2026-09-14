package org.apache.tika.detect;

import F0.AbstractC0008a;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.CharArrayWriter;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

/* loaded from: classes.dex */
public class MagicDetector implements Detector {
    private final boolean isRegex;
    private final boolean isStringIgnoreCase;
    private final int length;
    private final byte[] mask;
    private final int offsetRangeBegin;
    private final int offsetRangeEnd;
    private final byte[] pattern;
    private final int patternLength;
    private final MediaType type;

    public MagicDetector(MediaType mediaType, byte[] bArr) {
        this(mediaType, bArr, 0);
    }

    private static byte[] decodeString(String str, String str2) {
        int i = 0;
        if (str.startsWith("0x")) {
            int length = (str.length() - 2) / 2;
            byte[] bArr = new byte[length];
            while (i < length) {
                int i3 = i * 2;
                bArr[i] = (byte) Integer.parseInt(str.substring(i3 + 2, i3 + 4), 16);
                i++;
            }
            return bArr;
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        int i4 = 0;
        while (i4 < str.length()) {
            if (str.charAt(i4) == '\\') {
                int i5 = i4 + 1;
                if (str.charAt(i5) == '\\') {
                    charArrayWriter.write(92);
                } else if (str.charAt(i5) == 'x') {
                    charArrayWriter.write(Integer.parseInt(str.substring(i4 + 2, i4 + 4), 16));
                    i4 += 3;
                } else if (str.charAt(i5) == 'r') {
                    charArrayWriter.write(13);
                } else if (str.charAt(i5) == 'n') {
                    charArrayWriter.write(10);
                } else {
                    int i6 = i5;
                    while (i6 < i4 + 4 && i6 < str.length() && Character.isDigit(str.charAt(i6))) {
                        i6++;
                    }
                    charArrayWriter.write(Short.decode("0" + str.substring(i5, i6)).byteValue());
                    i4 = i6 + (-1);
                }
                i4 = i5;
            } else {
                charArrayWriter.write(str.charAt(i4));
            }
            i4++;
        }
        char[] charArray = charArrayWriter.toCharArray();
        if ("unicodeLE".equals(str2)) {
            byte[] bArr2 = new byte[charArray.length * 2];
            while (i < charArray.length) {
                int i7 = i * 2;
                char c4 = charArray[i];
                bArr2[i7] = (byte) (c4 & 255);
                bArr2[i7 + 1] = (byte) (c4 >> '\b');
                i++;
            }
            return bArr2;
        }
        if ("unicodeBE".equals(str2)) {
            byte[] bArr3 = new byte[charArray.length * 2];
            while (i < charArray.length) {
                int i8 = i * 2;
                char c5 = charArray[i];
                bArr3[i8] = (byte) (c5 >> '\b');
                bArr3[i8 + 1] = (byte) (c5 & 255);
                i++;
            }
            return bArr3;
        }
        int length2 = charArray.length;
        byte[] bArr4 = new byte[length2];
        while (i < length2) {
            bArr4[i] = (byte) charArray[i];
            i++;
        }
        return bArr4;
    }

    private static byte[] decodeValue(String str, String str2) {
        String str3;
        int i;
        if (str == null || str2 == null) {
            return null;
        }
        if (str.startsWith("0x")) {
            str3 = str.substring(2);
            i = 16;
        } else {
            str3 = str;
            i = 8;
        }
        char c4 = 65535;
        switch (str2.hashCode()) {
            case -1211485747:
                if (str2.equals("host16")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1211485689:
                if (str2.equals("host32")) {
                    c4 = 1;
                    break;
                }
                break;
            case -944685088:
                if (str2.equals("unicodeBE")) {
                    c4 = 2;
                    break;
                }
                break;
            case -944684778:
                if (str2.equals("unicodeLE")) {
                    c4 = 3;
                    break;
                }
                break;
            case -891985903:
                if (str2.equals("string")) {
                    c4 = 4;
                    break;
                }
                break;
            case -548372781:
                if (str2.equals("stringignorecase")) {
                    c4 = 5;
                    break;
                }
                break;
            case 3039496:
                if (str2.equals("byte")) {
                    c4 = 6;
                    break;
                }
                break;
            case 93733669:
                if (str2.equals("big16")) {
                    c4 = 7;
                    break;
                }
                break;
            case 93733727:
                if (str2.equals("big32")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 108392519:
                if (str2.equals("regex")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1374987163:
                if (str2.equals("little16")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1374987221:
                if (str2.equals("little32")) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case '\n':
                int parseInt = Integer.parseInt(str3, i);
                return new byte[]{(byte) (parseInt & 255), (byte) (parseInt >> 8)};
            case 1:
            case 11:
                long parseLong = Long.parseLong(str3, i);
                return new byte[]{(byte) (parseLong & 255), (byte) ((parseLong & 65280) >> 8), (byte) ((parseLong & 16711680) >> 16), (byte) ((parseLong & (-16777216)) >> 24)};
            case 2:
            case 3:
            case 4:
            case '\t':
                return decodeString(str, str2);
            case 5:
                return decodeString(str.toLowerCase(Locale.ROOT), str2);
            case 6:
                return str3.getBytes(StandardCharsets.UTF_8);
            case 7:
                int parseInt2 = Integer.parseInt(str3, i);
                return new byte[]{(byte) (parseInt2 >> 8), (byte) (parseInt2 & 255)};
            case '\b':
                long parseLong2 = Long.parseLong(str3, i);
                return new byte[]{(byte) ((parseLong2 & (-16777216)) >> 24), (byte) ((parseLong2 & 16711680) >> 16), (byte) ((parseLong2 & 65280) >> 8), (byte) (parseLong2 & 255)};
            default:
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.apache.tika.detect.MagicDetector parse(org.apache.tika.mime.MediaType r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r0 = 0
            if (r11 == 0) goto L10
            r1 = 58
            int r1 = r11.indexOf(r1)
            r2 = -1
            if (r1 != r2) goto L13
            int r0 = java.lang.Integer.parseInt(r11)
        L10:
            r7 = r0
            r8 = r7
            goto L27
        L13:
            java.lang.String r0 = r11.substring(r0, r1)
            int r0 = java.lang.Integer.parseInt(r0)
            int r1 = r1 + 1
            java.lang.String r11 = r11.substring(r1)
            int r11 = java.lang.Integer.parseInt(r11)
            r8 = r11
            r7 = r0
        L27:
            byte[] r3 = decodeValue(r12, r10)
            if (r13 == 0) goto L33
            byte[] r11 = decodeValue(r13, r10)
        L31:
            r4 = r11
            goto L35
        L33:
            r11 = 0
            goto L31
        L35:
            org.apache.tika.detect.MagicDetector r1 = new org.apache.tika.detect.MagicDetector
            java.lang.String r11 = "regex"
            boolean r5 = r10.equals(r11)
            java.lang.String r11 = "stringignorecase"
            boolean r6 = r10.equals(r11)
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.detect.MagicDetector.parse(org.apache.tika.mime.MediaType, java.lang.String, java.lang.String, java.lang.String, java.lang.String):org.apache.tika.detect.MagicDetector");
    }

    @Override // org.apache.tika.detect.Detector
    public MediaType detect(InputStream inputStream, Metadata metadata) {
        int i;
        if (inputStream == null) {
            return MediaType.OCTET_STREAM;
        }
        inputStream.mark(this.offsetRangeEnd + this.length);
        int i3 = 0;
        while (true) {
            try {
                int i4 = this.offsetRangeBegin;
                if (i3 < i4) {
                    long skip = inputStream.skip(i4 - i3);
                    if (skip > 0) {
                        i3 = (int) (i3 + skip);
                    } else if (inputStream.read() != -1) {
                        i3++;
                    } else {
                        return MediaType.OCTET_STREAM;
                    }
                } else {
                    int i5 = (this.offsetRangeEnd - i4) + this.length;
                    byte[] bArr = new byte[i5];
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        i3 += read;
                    }
                    while (read != -1 && i3 < this.offsetRangeEnd + this.length) {
                        int i6 = i3 - this.offsetRangeBegin;
                        read = inputStream.read(bArr, i6, i5 - i6);
                        if (read > 0) {
                            i3 += read;
                        }
                    }
                    if (this.isRegex) {
                        if (this.isStringIgnoreCase) {
                            i = 2;
                        } else {
                            i = 0;
                        }
                        Matcher matcher = Pattern.compile(new String(this.pattern, StandardCharsets.UTF_8), i).matcher(StandardCharsets.ISO_8859_1.decode(ByteBuffer.wrap(bArr)));
                        for (int i7 = 0; i7 <= this.offsetRangeEnd - this.offsetRangeBegin; i7++) {
                            matcher.region(i7, this.length + i7);
                            if (matcher.lookingAt()) {
                                return this.type;
                            }
                        }
                    } else {
                        if (i3 < this.offsetRangeBegin + this.length) {
                            return MediaType.OCTET_STREAM;
                        }
                        for (int i8 = 0; i8 <= this.offsetRangeEnd - this.offsetRangeBegin; i8++) {
                            boolean z3 = true;
                            for (int i9 = 0; z3 && i9 < this.length; i9++) {
                                int i10 = bArr[i8 + i9] & this.mask[i9];
                                if (this.isStringIgnoreCase) {
                                    i10 = Character.toLowerCase(i10);
                                }
                                if (i10 == this.pattern[i9]) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            }
                            if (z3) {
                                return this.type;
                            }
                        }
                    }
                    return MediaType.OCTET_STREAM;
                }
            } finally {
                inputStream.reset();
            }
        }
    }

    public int getLength() {
        return this.patternLength;
    }

    public String toString() {
        MediaType mediaType = this.type;
        byte[] bArr = this.pattern;
        int length = bArr.length;
        String arrays = Arrays.toString(bArr);
        String arrays2 = Arrays.toString(this.mask);
        StringBuilder sb = new StringBuilder("Magic Detection for ");
        sb.append(mediaType);
        sb.append(" looking for ");
        sb.append(length);
        sb.append(" bytes = ");
        return AbstractC0008a.v(sb, arrays, " mask = ", arrays2);
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, int i) {
        this(mediaType, bArr, null, i, i);
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, byte[] bArr2, int i, int i3) {
        this(mediaType, bArr, bArr2, false, i, i3);
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, byte[] bArr2, boolean z3, int i, int i3) {
        this(mediaType, bArr, bArr2, z3, false, i, i3);
    }

    public MagicDetector(MediaType mediaType, byte[] bArr, byte[] bArr2, boolean z3, boolean z4, int i, int i3) {
        if (mediaType == null) {
            throw new IllegalArgumentException("Matching media type is null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("Magic match pattern is null");
        }
        if (i >= 0 && i3 >= i) {
            this.type = mediaType;
            this.isRegex = z3;
            this.isStringIgnoreCase = z4;
            int max = Math.max(bArr.length, bArr2 != null ? bArr2.length : 0);
            this.patternLength = max;
            if (z3) {
                this.length = UserMetadata.MAX_INTERNAL_KEY_SIZE;
            } else {
                this.length = max;
            }
            this.mask = new byte[max];
            this.pattern = new byte[max];
            for (int i4 = 0; i4 < this.patternLength; i4++) {
                if (bArr2 != null && i4 < bArr2.length) {
                    this.mask[i4] = bArr2[i4];
                } else {
                    this.mask[i4] = -1;
                }
                if (i4 < bArr.length) {
                    this.pattern[i4] = (byte) (bArr[i4] & this.mask[i4]);
                } else {
                    this.pattern[i4] = 0;
                }
            }
            this.offsetRangeBegin = i;
            this.offsetRangeEnd = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid offset range: [" + i + "," + i3 + "]");
    }
}
