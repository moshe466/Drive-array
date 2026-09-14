package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
final class ParseRequest {
    final String a;
    final int b;

    private ParseRequest(String str, int i) {
        this.a = str;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParseRequest a(String str) {
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char charAt = str.charAt(0);
        int i = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (charAt == '#') {
            str = str.substring(1);
        } else if (charAt != '0' || str.length() <= 1) {
            i = 10;
        } else {
            str = str.substring(1);
            i = 8;
        }
        return new ParseRequest(str, i);
    }
}
