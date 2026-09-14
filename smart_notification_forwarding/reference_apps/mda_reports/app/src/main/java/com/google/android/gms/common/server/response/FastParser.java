package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.JsonUtils;
import io.reactivex.internal.operators.observable.ObservableReplay;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import kotlin.text.Typography;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaqg = {'u', 'l', 'l'};
    private static final char[] zaqh = {'r', 'u', 'e'};
    private static final char[] zaqi = {'r', 'u', 'e', Typography.quote};
    private static final char[] zaqj = {'a', 'l', 's', 'e'};
    private static final char[] zaqk = {'a', 'l', 's', 'e', Typography.quote};
    private static final char[] zaql = {'\n'};
    private static final zaa<Integer> zaqn = new com.google.android.gms.common.server.response.zaa();
    private static final zaa<Long> zaqo = new zab();
    private static final zaa<Float> zaqp = new zac();
    private static final zaa<Double> zaqq = new zad();
    private static final zaa<Boolean> zaqr = new zae();
    private static final zaa<String> zaqs = new zaf();
    private static final zaa<BigInteger> zaqt = new zag();
    private static final zaa<BigDecimal> zaqu = new zah();
    private final char[] zaqb = new char[1];
    private final char[] zaqc = new char[32];
    private final char[] zaqd = new char[1024];
    private final StringBuilder zaqe = new StringBuilder(32);
    private final StringBuilder zaqf = new StringBuilder(1024);
    private final Stack<Integer> zaqm = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface zaa<O> {
        O zah(FastParser fastParser, BufferedReader bufferedReader);
    }

    private final int zaa(BufferedReader bufferedReader, char[] cArr) {
        int i;
        char zaj = zaj(bufferedReader);
        if (zaj == 0) {
            throw new ParseException("Unexpected EOF");
        }
        if (zaj == ',') {
            throw new ParseException("Missing value");
        }
        if (zaj == 'n') {
            zab(bufferedReader, zaqg);
            return 0;
        }
        bufferedReader.mark(1024);
        if (zaj == '\"') {
            i = 0;
            boolean z = false;
            while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                char c = cArr[i];
                if (Character.isISOControl(c)) {
                    throw new ParseException("Unexpected control character while reading string");
                }
                if (c == '\"' && !z) {
                    bufferedReader.reset();
                    bufferedReader.skip(i + 1);
                    return i;
                }
                z = c == '\\' ? !z : false;
                i++;
            }
        } else {
            cArr[0] = zaj;
            i = 1;
            while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                    bufferedReader.reset();
                    bufferedReader.skip(i - 1);
                    cArr[i] = 0;
                    return i;
                }
                i++;
            }
        }
        if (i == cArr.length) {
            throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
    }

    private final String zaa(BufferedReader bufferedReader) {
        this.zaqm.push(2);
        char zaj = zaj(bufferedReader);
        if (zaj == '\"') {
            this.zaqm.push(3);
            String zab = zab(bufferedReader, this.zaqc, this.zaqe, null);
            zak(3);
            if (zaj(bufferedReader) == ':') {
                return zab;
            }
            throw new ParseException("Expected key/value separator");
        }
        if (zaj == ']') {
            zak(2);
            zak(1);
            zak(5);
            return null;
        }
        if (zaj == '}') {
            zak(2);
            return null;
        }
        StringBuilder sb = new StringBuilder(19);
        sb.append("Unexpected token: ");
        sb.append(zaj);
        throw new ParseException(sb.toString());
    }

    private final String zaa(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        char zaj = zaj(bufferedReader);
        if (zaj == '\"') {
            return zab(bufferedReader, cArr, sb, cArr2);
        }
        if (zaj != 'n') {
            throw new ParseException("Expected string");
        }
        zab(bufferedReader, zaqg);
        return null;
    }

    private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) {
        ObservableReplay.UnboundedReplayBuffer unboundedReplayBuffer = (ArrayList<T>) new ArrayList();
        char zaj = zaj(bufferedReader);
        if (zaj == ']') {
            zak(5);
            return unboundedReplayBuffer;
        }
        if (zaj == 'n') {
            zab(bufferedReader, zaqg);
            zak(5);
            return null;
        }
        if (zaj != '{') {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(zaj);
            throw new ParseException(sb.toString());
        }
        Stack<Integer> stack = this.zaqm;
        while (true) {
            stack.push(1);
            try {
                FastJsonResponse zacp = field.zacp();
                if (!zaa(bufferedReader, zacp)) {
                    return unboundedReplayBuffer;
                }
                unboundedReplayBuffer.add(zacp);
                char zaj2 = zaj(bufferedReader);
                if (zaj2 != ',') {
                    if (zaj2 == ']') {
                        zak(5);
                        return unboundedReplayBuffer;
                    }
                    StringBuilder sb2 = new StringBuilder(19);
                    sb2.append("Unexpected token: ");
                    sb2.append(zaj2);
                    throw new ParseException(sb2.toString());
                }
                if (zaj(bufferedReader) != '{') {
                    throw new ParseException("Expected start of next object in array");
                }
                stack = this.zaqm;
            } catch (IllegalAccessException e) {
                throw new ParseException("Error instantiating inner object", e);
            } catch (InstantiationException e2) {
                throw new ParseException("Error instantiating inner object", e2);
            }
        }
    }

    private final <O> ArrayList<O> zaa(BufferedReader bufferedReader, zaa<O> zaaVar) {
        char zaj = zaj(bufferedReader);
        if (zaj == 'n') {
            zab(bufferedReader, zaqg);
            return null;
        }
        if (zaj != '[') {
            throw new ParseException("Expected start of array");
        }
        this.zaqm.push(5);
        ArrayList<O> arrayList = new ArrayList<>();
        while (true) {
            bufferedReader.mark(1024);
            char zaj2 = zaj(bufferedReader);
            if (zaj2 == 0) {
                throw new ParseException("Unexpected EOF");
            }
            if (zaj2 != ',') {
                if (zaj2 == ']') {
                    zak(5);
                    return arrayList;
                }
                bufferedReader.reset();
                arrayList.add(zaaVar.zah(this, bufferedReader));
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0040. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0297 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0279 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zaa(java.io.BufferedReader r17, com.google.android.gms.common.server.response.FastJsonResponse r18) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zaa(java.io.BufferedReader, com.google.android.gms.common.server.response.FastJsonResponse):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zaa(BufferedReader bufferedReader, boolean z) {
        while (true) {
            char zaj = zaj(bufferedReader);
            if (zaj != '\"') {
                if (zaj == 'f') {
                    zab(bufferedReader, z ? zaqk : zaqj);
                    return false;
                }
                if (zaj == 'n') {
                    zab(bufferedReader, zaqg);
                    return false;
                }
                if (zaj == 't') {
                    zab(bufferedReader, z ? zaqi : zaqh);
                    return true;
                }
                StringBuilder sb = new StringBuilder(19);
                sb.append("Unexpected token: ");
                sb.append(zaj);
                throw new ParseException(sb.toString());
            }
            if (z) {
                throw new ParseException("No boolean value found in string");
            }
            z = true;
        }
    }

    private final String zab(BufferedReader bufferedReader) {
        bufferedReader.mark(1024);
        char zaj = zaj(bufferedReader);
        if (zaj == '\"') {
            if (bufferedReader.read(this.zaqb) == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            char c = this.zaqb[0];
            boolean z = false;
            do {
                if (c != '\"' || z) {
                    z = c == '\\' ? !z : false;
                    if (bufferedReader.read(this.zaqb) == -1) {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                    c = this.zaqb[0];
                }
            } while (!Character.isISOControl(c));
            throw new ParseException("Unexpected control character while reading string");
        }
        if (zaj == ',') {
            throw new ParseException("Missing value");
        }
        int i = 1;
        if (zaj == '[') {
            this.zaqm.push(5);
            bufferedReader.mark(32);
            if (zaj(bufferedReader) != ']') {
                bufferedReader.reset();
                boolean z2 = false;
                boolean z3 = false;
                while (i > 0) {
                    char zaj2 = zaj(bufferedReader);
                    if (zaj2 == 0) {
                        throw new ParseException("Unexpected EOF while parsing array");
                    }
                    if (Character.isISOControl(zaj2)) {
                        throw new ParseException("Unexpected control character while reading array");
                    }
                    if (zaj2 == '\"' && !z2) {
                        z3 = !z3;
                    }
                    if (zaj2 == '[' && !z3) {
                        i++;
                    }
                    if (zaj2 == ']' && !z3) {
                        i--;
                    }
                    z2 = (zaj2 == '\\' && z3) ? !z2 : false;
                }
            }
            zak(5);
        } else if (zaj != '{') {
            bufferedReader.reset();
            zaa(bufferedReader, this.zaqd);
        } else {
            this.zaqm.push(1);
            bufferedReader.mark(32);
            char zaj3 = zaj(bufferedReader);
            if (zaj3 != '}') {
                if (zaj3 != '\"') {
                    StringBuilder sb = new StringBuilder(18);
                    sb.append("Unexpected token ");
                    sb.append(zaj3);
                    throw new ParseException(sb.toString());
                }
                bufferedReader.reset();
                zaa(bufferedReader);
                do {
                } while (zab(bufferedReader) != null);
            }
            zak(1);
        }
        char zaj4 = zaj(bufferedReader);
        if (zaj4 == ',') {
            zak(2);
            return zaa(bufferedReader);
        }
        if (zaj4 == '}') {
            zak(2);
            return null;
        }
        StringBuilder sb2 = new StringBuilder(18);
        sb2.append("Unexpected token ");
        sb2.append(zaj4);
        throw new ParseException(sb2.toString());
    }

    private static String zab(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        boolean z;
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            boolean z4 = z3;
            boolean z5 = z2;
            for (int i = 0; i < read; i++) {
                char c = cArr[i];
                if (Character.isISOControl(c)) {
                    if (cArr2 != null) {
                        for (char c2 : cArr2) {
                            if (c2 == c) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
                if (c == '\"' && !z5) {
                    sb.append(cArr, 0, i);
                    bufferedReader.reset();
                    bufferedReader.skip(i + 1);
                    String sb2 = sb.toString();
                    return z4 ? JsonUtils.unescapeString(sb2) : sb2;
                }
                if (c == '\\') {
                    z5 = !z5;
                    z4 = true;
                } else {
                    z5 = false;
                }
            }
            sb.append(cArr, 0, read);
            bufferedReader.mark(cArr.length);
            z2 = z5;
            z3 = z4;
        }
    }

    private final void zab(BufferedReader bufferedReader, char[] cArr) {
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.zaqc, 0, cArr.length - i);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != this.zaqc[i2]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zac(BufferedReader bufferedReader) {
        return zaa(bufferedReader, this.zaqc, this.zaqe, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zad(BufferedReader bufferedReader) {
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        int zaa2 = zaa(bufferedReader, this.zaqd);
        if (zaa2 == 0) {
            return 0;
        }
        char[] cArr = this.zaqd;
        if (zaa2 <= 0) {
            throw new ParseException("No number to parse");
        }
        if (cArr[0] == '-') {
            i = 1;
            z = true;
            i2 = Integer.MIN_VALUE;
        } else {
            i = 0;
            z = false;
            i2 = -2147483647;
        }
        if (i < zaa2) {
            i3 = i + 1;
            int digit = Character.digit(cArr[i], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i4 = -digit;
        } else {
            i3 = i;
            i4 = 0;
        }
        while (i3 < zaa2) {
            int i5 = i3 + 1;
            int digit2 = Character.digit(cArr[i3], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i4 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i6 = i4 * 10;
            if (i6 < i2 + digit2) {
                throw new ParseException("Number too large");
            }
            i4 = i6 - digit2;
            i3 = i5;
        }
        if (!z) {
            return -i4;
        }
        if (i3 > 1) {
            return i4;
        }
        throw new ParseException("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zae(BufferedReader bufferedReader) {
        long j;
        boolean z;
        long j2;
        int i;
        int zaa2 = zaa(bufferedReader, this.zaqd);
        if (zaa2 == 0) {
            return 0L;
        }
        char[] cArr = this.zaqd;
        if (zaa2 <= 0) {
            throw new ParseException("No number to parse");
        }
        int i2 = 0;
        if (cArr[0] == '-') {
            j = Long.MIN_VALUE;
            i2 = 1;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i2 < zaa2) {
            i = i2 + 1;
            int digit = Character.digit(cArr[i2], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j2 = -digit;
        } else {
            j2 = 0;
            i = i2;
        }
        while (i < zaa2) {
            int i3 = i + 1;
            int digit2 = Character.digit(cArr[i], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j2 < -922337203685477580L) {
                throw new ParseException("Number too large");
            }
            long j3 = j2 * 10;
            long j4 = digit2;
            if (j3 < j + j4) {
                throw new ParseException("Number too large");
            }
            j2 = j3 - j4;
            i = i3;
        }
        if (!z) {
            return -j2;
        }
        if (i > 1) {
            return j2;
        }
        throw new ParseException("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger zaf(BufferedReader bufferedReader) {
        int zaa2 = zaa(bufferedReader, this.zaqd);
        if (zaa2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaqd, 0, zaa2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zag(BufferedReader bufferedReader) {
        int zaa2 = zaa(bufferedReader, this.zaqd);
        if (zaa2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaqd, 0, zaa2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zah(BufferedReader bufferedReader) {
        int zaa2 = zaa(bufferedReader, this.zaqd);
        if (zaa2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaqd, 0, zaa2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal zai(BufferedReader bufferedReader) {
        int zaa2 = zaa(bufferedReader, this.zaqd);
        if (zaa2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaqd, 0, zaa2));
    }

    private final char zaj(BufferedReader bufferedReader) {
        if (bufferedReader.read(this.zaqb) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.zaqb[0])) {
            if (bufferedReader.read(this.zaqb) == -1) {
                return (char) 0;
            }
        }
        return this.zaqb[0];
    }

    private final void zak(int i) {
        if (this.zaqm.isEmpty()) {
            StringBuilder sb = new StringBuilder(46);
            sb.append("Expected state ");
            sb.append(i);
            sb.append(" but had empty stack");
            throw new ParseException(sb.toString());
        }
        int intValue = this.zaqm.pop().intValue();
        if (intValue == i) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i);
        sb2.append(" but had ");
        sb2.append(intValue);
        throw new ParseException(sb2.toString());
    }

    @KeepForSdk
    public void parse(InputStream inputStream, T t) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.zaqm.push(0);
                char zaj = zaj(bufferedReader);
                if (zaj == 0) {
                    throw new ParseException("No data to parse");
                }
                if (zaj == '[') {
                    this.zaqm.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() != 1) {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                    t.addConcreteTypeArrayInternal(value, value.e, zaa(bufferedReader, value));
                } else {
                    if (zaj != '{') {
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(zaj);
                        throw new ParseException(sb.toString());
                    }
                    this.zaqm.push(1);
                    zaa(bufferedReader, t);
                }
                zak(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } catch (IOException e) {
                throw new ParseException(e);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
