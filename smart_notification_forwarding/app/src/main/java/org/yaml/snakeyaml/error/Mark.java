package org.yaml.snakeyaml.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.yaml.snakeyaml.scanner.Constant;

/* loaded from: classes2.dex */
public final class Mark implements Serializable {
    private int[] buffer;
    private int column;
    private int index;
    private int line;
    private String name;
    private int pointer;

    private static int[] toCodePoints(char[] cArr) {
        int i = 0;
        int[] iArr = new int[Character.codePointCount(cArr, 0, cArr.length)];
        int i2 = 0;
        while (i < cArr.length) {
            int codePointAt = Character.codePointAt(cArr, i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return iArr;
    }

    public Mark(String str, int i, int i2, int i3, char[] cArr, int i4) {
        this(str, i, i2, i3, toCodePoints(cArr), i4);
    }

    @Deprecated
    public Mark(String str, int i, int i2, int i3, String str2, int i4) {
        this(str, i, i2, i3, str2.toCharArray(), i4);
    }

    public Mark(String str, int i, int i2, int i3, int[] iArr, int i4) {
        this.name = str;
        this.index = i;
        this.line = i2;
        this.column = i3;
        this.buffer = iArr;
        this.pointer = i4;
    }

    private boolean isLineBreak(int i) {
        return Constant.NULL_OR_LINEBR.has(i);
    }

    public String get_snippet(int i, int i2) {
        String str;
        String str2;
        float f = (i2 / 2.0f) - 1.0f;
        int i3 = this.pointer;
        do {
            str = " ... ";
            if (i3 <= 0 || isLineBreak(this.buffer[i3 - 1])) {
                str2 = JsonProperty.USE_DEFAULT_NAME;
                break;
            }
            i3--;
        } while (this.pointer - i3 <= f);
        i3 += 5;
        str2 = " ... ";
        int i4 = this.pointer;
        do {
            int[] iArr = this.buffer;
            if (i4 >= iArr.length || isLineBreak(iArr[i4])) {
                str = JsonProperty.USE_DEFAULT_NAME;
                break;
            }
            i4++;
        } while (i4 - this.pointer <= f);
        i4 -= 5;
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < i; i5++) {
            sb.append(" ");
        }
        sb.append(str2);
        for (int i6 = i3; i6 < i4; i6++) {
            sb.appendCodePoint(this.buffer[i6]);
        }
        sb.append(str);
        sb.append("\n");
        for (int i7 = 0; i7 < ((this.pointer + i) - i3) + str2.length(); i7++) {
            sb.append(" ");
        }
        sb.append("^");
        return sb.toString();
    }

    public String get_snippet() {
        return get_snippet(4, 75);
    }

    public String toString() {
        return " in " + this.name + ", line " + (this.line + 1) + ", column " + (this.column + 1) + ":\n" + get_snippet();
    }

    public String getName() {
        return this.name;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public int getPointer() {
        return this.pointer;
    }
}
