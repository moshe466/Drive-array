package org.yaml.snakeyaml.reader;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.scanner.Constant;

/* loaded from: classes2.dex */
public class StreamReader {
    private static final int BUFFER_SIZE = 1025;
    private char[] buffer;
    private int column;
    private int dataLength;
    private int[] dataWindow;
    private boolean eof;
    private int index;
    private int line;
    private String name;
    private int pointer;
    private final Reader stream;

    public static boolean isPrintable(int i) {
        return (i >= 32 && i <= 126) || i == 9 || i == 10 || i == 13 || i == 133 || (i >= 160 && i <= 55295) || ((i >= 57344 && i <= 65533) || (i >= 65536 && i <= 1114111));
    }

    public StreamReader(String str) {
        this(new StringReader(str));
        this.name = "'string'";
    }

    public StreamReader(Reader reader) {
        this.pointer = 0;
        this.index = 0;
        this.line = 0;
        this.column = 0;
        this.name = "'reader'";
        this.dataWindow = new int[0];
        this.dataLength = 0;
        this.stream = reader;
        this.eof = false;
        this.buffer = new char[1025];
    }

    public static boolean isPrintable(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!isPrintable(codePointAt)) {
                return false;
            }
            i += Character.charCount(codePointAt);
        }
        return true;
    }

    public Mark getMark() {
        return new Mark(this.name, this.index, this.line, this.column, this.dataWindow, this.pointer);
    }

    public void forward() {
        forward(1);
    }

    public void forward(int i) {
        for (int i2 = 0; i2 < i && ensureEnoughData(); i2++) {
            int[] iArr = this.dataWindow;
            int i3 = this.pointer;
            this.pointer = i3 + 1;
            int i4 = iArr[i3];
            this.index++;
            if (Constant.LINEBR.has(i4) || (i4 == 13 && ensureEnoughData() && this.dataWindow[this.pointer] != 10)) {
                this.line++;
                this.column = 0;
            } else if (i4 != 65279) {
                this.column++;
            }
        }
    }

    public int peek() {
        if (ensureEnoughData()) {
            return this.dataWindow[this.pointer];
        }
        return 0;
    }

    public int peek(int i) {
        if (ensureEnoughData(i)) {
            return this.dataWindow[this.pointer + i];
        }
        return 0;
    }

    public String prefix(int i) {
        if (i == 0) {
            return JsonProperty.USE_DEFAULT_NAME;
        }
        if (ensureEnoughData(i)) {
            return new String(this.dataWindow, this.pointer, i);
        }
        int[] iArr = this.dataWindow;
        int i2 = this.pointer;
        return new String(iArr, i2, Math.min(i, this.dataLength - i2));
    }

    public String prefixForward(int i) {
        String prefix = prefix(i);
        this.pointer += i;
        this.index += i;
        this.column += i;
        return prefix;
    }

    private boolean ensureEnoughData() {
        return ensureEnoughData(0);
    }

    private boolean ensureEnoughData(int i) {
        if (!this.eof && this.pointer + i >= this.dataLength) {
            update();
        }
        return this.pointer + i < this.dataLength;
    }

    private void update() {
        try {
            int read = this.stream.read(this.buffer, 0, 1024);
            if (read > 0) {
                int i = this.dataLength;
                int i2 = this.pointer;
                int i3 = i - i2;
                this.dataWindow = Arrays.copyOfRange(this.dataWindow, i2, i + read);
                if (Character.isHighSurrogate(this.buffer[read - 1])) {
                    if (this.stream.read(this.buffer, read, 1) == -1) {
                        this.eof = true;
                    } else {
                        read++;
                    }
                }
                int i4 = 32;
                int i5 = 0;
                while (i5 < read) {
                    int codePointAt = Character.codePointAt(this.buffer, i5);
                    this.dataWindow[i3] = codePointAt;
                    if (isPrintable(codePointAt)) {
                        i5 += Character.charCount(codePointAt);
                    } else {
                        i5 = read;
                        i4 = codePointAt;
                    }
                    i3++;
                }
                this.dataLength = i3;
                this.pointer = 0;
                if (i4 != 32) {
                    throw new ReaderException(this.name, i3 - 1, i4, "special characters are not allowed");
                }
                return;
            }
            this.eof = true;
        } catch (IOException e) {
            throw new YAMLException(e);
        }
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLine() {
        return this.line;
    }
}
