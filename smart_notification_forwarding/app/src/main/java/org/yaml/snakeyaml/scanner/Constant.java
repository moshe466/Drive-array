package org.yaml.snakeyaml.scanner;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class Constant {
    private static final String FULL_LINEBR_S = "\r\n\u0085\u2028\u2029";
    boolean[] contains;
    private String content;
    boolean noASCII;
    private static final String LINEBR_S = "\n\u0085\u2028\u2029";
    public static final Constant LINEBR = new Constant(LINEBR_S);
    private static final String NULL_OR_LINEBR_S = "\u0000\r\n\u0085\u2028\u2029";
    public static final Constant NULL_OR_LINEBR = new Constant(NULL_OR_LINEBR_S);
    private static final String NULL_BL_LINEBR_S = " \u0000\r\n\u0085\u2028\u2029";
    public static final Constant NULL_BL_LINEBR = new Constant(NULL_BL_LINEBR_S);
    private static final String NULL_BL_T_LINEBR_S = "\t \u0000\r\n\u0085\u2028\u2029";
    public static final Constant NULL_BL_T_LINEBR = new Constant(NULL_BL_T_LINEBR_S);
    private static final String NULL_BL_T_S = "\u0000 \t";
    public static final Constant NULL_BL_T = new Constant(NULL_BL_T_S);
    private static final String URI_CHARS_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%";
    public static final Constant URI_CHARS = new Constant(URI_CHARS_S);
    private static final String ALPHA_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    public static final Constant ALPHA = new Constant(ALPHA_S);

    private Constant(String str) {
        boolean[] zArr = new boolean[128];
        this.contains = zArr;
        this.noASCII = false;
        Arrays.fill(zArr, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 128) {
                this.contains[codePointAt] = true;
            } else {
                sb.appendCodePoint(codePointAt);
            }
        }
        if (sb.length() > 0) {
            this.noASCII = true;
            this.content = sb.toString();
        }
    }

    public boolean has(int i) {
        if (i < 128) {
            return this.contains[i];
        }
        return this.noASCII && this.content.indexOf(i, 0) != -1;
    }

    public boolean hasNo(int i) {
        return !has(i);
    }

    public boolean has(int i, String str) {
        return has(i) || str.indexOf(i, 0) != -1;
    }

    public boolean hasNo(int i, String str) {
        return !has(i, str);
    }
}
