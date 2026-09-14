package org.apache.tika.sax;

import java.io.StringWriter;
import java.io.Writer;
import org.apache.tika.exception.WriteLimitReachedException;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.ParseRecord;
import org.xml.sax.ContentHandler;

/* loaded from: classes.dex */
public class WriteOutContentHandler extends ContentHandlerDecorator {
    private ParseContext parseContext;
    private boolean throwOnWriteLimitReached;
    private int writeCount;
    private final int writeLimit;
    private boolean writeLimitReached;

    public WriteOutContentHandler(ContentHandler contentHandler, int i) {
        super(contentHandler);
        this.writeCount = 0;
        this.throwOnWriteLimitReached = true;
        this.parseContext = null;
        this.writeLimit = i;
    }

    private void handleWriteLimitReached() {
        this.writeLimitReached = true;
        this.writeCount = this.writeLimit;
        if (!this.throwOnWriteLimitReached) {
            ParseRecord parseRecord = (ParseRecord) this.parseContext.get(ParseRecord.class);
            if (parseRecord != null) {
                parseRecord.setWriteLimitReached(true);
                return;
            }
            return;
        }
        throw new WriteLimitReachedException(this.writeLimit);
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        if (this.writeLimitReached) {
            return;
        }
        int i4 = this.writeLimit;
        if (i4 != -1) {
            int i5 = this.writeCount;
            if (i5 + i3 > i4) {
                super.characters(cArr, i, i4 - i5);
                handleWriteLimitReached();
                return;
            }
        }
        super.characters(cArr, i, i3);
        this.writeCount += i3;
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i3) {
        if (this.writeLimitReached) {
            return;
        }
        int i4 = this.writeLimit;
        if (i4 != -1) {
            int i5 = this.writeCount;
            if (i5 + i3 > i4) {
                super.ignorableWhitespace(cArr, i, i4 - i5);
                handleWriteLimitReached();
                return;
            }
        }
        super.ignorableWhitespace(cArr, i, i3);
        this.writeCount += i3;
    }

    public WriteOutContentHandler(Writer writer, int i) {
        this(new ToTextContentHandler(writer), i);
    }

    public WriteOutContentHandler(Writer writer) {
        this(writer, -1);
    }

    public WriteOutContentHandler(int i) {
        this(new StringWriter(), i);
    }

    public WriteOutContentHandler() {
        this(100000);
    }

    public WriteOutContentHandler(ContentHandler contentHandler, int i, boolean z3, ParseContext parseContext) {
        super(contentHandler);
        this.writeCount = 0;
        this.writeLimit = i;
        this.throwOnWriteLimitReached = z3;
        this.parseContext = parseContext;
    }
}
