package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes.dex */
public class SafeContentHandler extends ContentHandlerDecorator {
    private static final char[] REPLACEMENT = {65533};
    private final Output charactersOutput;
    private final Output ignorableWhitespaceOutput;

    /* loaded from: classes.dex */
    public interface Output {
        void write(char[] cArr, int i, int i3);
    }

    /* loaded from: classes.dex */
    public static class StringOutput implements Output {
        private final StringBuilder builder;

        public /* synthetic */ StringOutput(int i) {
            this();
        }

        public String toString() {
            return this.builder.toString();
        }

        @Override // org.apache.tika.sax.SafeContentHandler.Output
        public void write(char[] cArr, int i, int i3) {
            this.builder.append(cArr, i, i3);
        }

        private StringOutput() {
            this.builder = new StringBuilder();
        }
    }

    public SafeContentHandler(ContentHandler contentHandler) {
        super(contentHandler);
        final int i = 0;
        this.charactersOutput = new Output(this) { // from class: org.apache.tika.sax.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SafeContentHandler f5968b;

            {
                this.f5968b = this;
            }

            @Override // org.apache.tika.sax.SafeContentHandler.Output
            public final void write(char[] cArr, int i3, int i4) {
                switch (i) {
                    case 0:
                        this.f5968b.lambda$new$0(cArr, i3, i4);
                        return;
                    default:
                        this.f5968b.lambda$new$1(cArr, i3, i4);
                        return;
                }
            }
        };
        final int i3 = 1;
        this.ignorableWhitespaceOutput = new Output(this) { // from class: org.apache.tika.sax.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SafeContentHandler f5968b;

            {
                this.f5968b = this;
            }

            @Override // org.apache.tika.sax.SafeContentHandler.Output
            public final void write(char[] cArr, int i32, int i4) {
                switch (i3) {
                    case 0:
                        this.f5968b.lambda$new$0(cArr, i32, i4);
                        return;
                    default:
                        this.f5968b.lambda$new$1(cArr, i32, i4);
                        return;
                }
            }
        };
    }

    private void filter(char[] cArr, int i, int i3, Output output) {
        int i4 = i3 + i;
        int i5 = i;
        while (i < i4) {
            int codePointAt = Character.codePointAt(cArr, i, i4);
            int charCount = Character.charCount(codePointAt) + i;
            if (isInvalid(codePointAt)) {
                if (i > i5) {
                    output.write(cArr, i5, i - i5);
                }
                writeReplacement(output);
                i5 = charCount;
            }
            i = charCount;
        }
        output.write(cArr, i5, i4 - i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(char[] cArr, int i, int i3) {
        super.characters(cArr, i, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(char[] cArr, int i, int i3) {
        super.ignorableWhitespace(cArr, i, i3);
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        filter(cArr, i, i3, this.charactersOutput);
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        super.endDocument();
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        super.endElement(str, str2, str3);
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i3) {
        filter(cArr, i, i3, this.ignorableWhitespaceOutput);
    }

    public boolean isInvalid(int i) {
        return i < 32 ? (i == 9 || i == 10 || i == 13) ? false : true : i < 57344 ? i > 55295 : i < 65536 ? i > 65533 : i > 1114111;
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        int i = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= attributes.getLength()) {
                break;
            }
            if (isInvalid(attributes.getValue(i3))) {
                AttributesImpl attributesImpl = new AttributesImpl();
                for (int i4 = 0; i4 < attributes.getLength(); i4++) {
                    String value = attributes.getValue(i4);
                    if (i4 >= i3 && isInvalid(value)) {
                        StringOutput stringOutput = new StringOutput(i);
                        filter(value.toCharArray(), 0, value.length(), stringOutput);
                        value = stringOutput.toString();
                    }
                    attributesImpl.addAttribute(attributes.getURI(i4), attributes.getLocalName(i4), attributes.getQName(i4), attributes.getType(i4), value);
                }
                attributes = attributesImpl;
            } else {
                i3++;
            }
        }
        super.startElement(str, str2, str3, attributes);
    }

    public void writeReplacement(Output output) {
        char[] cArr = REPLACEMENT;
        output.write(cArr, 0, cArr.length);
    }

    private boolean isInvalid(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            int codePointAt = Character.codePointAt(charArray, i);
            if (isInvalid(codePointAt)) {
                return true;
            }
            i += Character.charCount(codePointAt);
        }
        return false;
    }
}
