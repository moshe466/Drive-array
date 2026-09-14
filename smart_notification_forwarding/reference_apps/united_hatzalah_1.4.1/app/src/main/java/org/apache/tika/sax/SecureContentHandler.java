package org.apache.tika.sax;

import F0.AbstractC0008a;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class SecureContentHandler extends ContentHandlerDecorator {
    private long characterCount;
    private int currentDepth;
    private int maxDepth;
    private int maxPackageEntryDepth;
    private final LinkedList<Integer> packageEntryDepths;
    private long ratio;
    private final TikaInputStream stream;
    private long threshold;

    /* loaded from: classes.dex */
    public class SecureSAXException extends SAXException {
        private static final long serialVersionUID = 2285245380321771445L;

        public SecureSAXException(String str) {
            super(str);
        }

        public boolean isCausedBy(SecureContentHandler secureContentHandler) {
            if (SecureContentHandler.this == secureContentHandler) {
                return true;
            }
            return false;
        }
    }

    public SecureContentHandler(ContentHandler contentHandler, TikaInputStream tikaInputStream) {
        super(contentHandler);
        this.packageEntryDepths = new LinkedList<>();
        this.characterCount = 0L;
        this.currentDepth = 0;
        this.threshold = 1000000L;
        this.ratio = 100L;
        this.maxDepth = 100;
        this.maxPackageEntryDepth = 10;
        this.stream = tikaInputStream;
    }

    private long getByteCount() {
        try {
            if (this.stream.hasLength()) {
                return this.stream.getLength();
            }
            return this.stream.getPosition();
        } catch (IOException e4) {
            throw new SAXException("Unable to get stream length", e4);
        }
    }

    public void advance(int i) {
        this.characterCount += i;
        long byteCount = getByteCount();
        long j2 = this.characterCount;
        if (j2 > this.threshold && j2 > this.ratio * byteCount) {
            throw new SecureSAXException(e0.a.g(AbstractC0008a.x("Suspected zip bomb: ", " input bytes produced ", byteCount), this.characterCount, " output characters"));
        }
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i3) {
        advance(i3);
        super.characters(cArr, i, i3);
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        super.endElement(str, str2, str3);
        if (!this.packageEntryDepths.isEmpty() && this.packageEntryDepths.getLast().intValue() == this.currentDepth) {
            this.packageEntryDepths.removeLast();
        }
        this.currentDepth--;
    }

    public long getMaximumCompressionRatio() {
        return this.ratio;
    }

    public int getMaximumDepth() {
        return this.maxDepth;
    }

    public int getMaximumPackageEntryDepth() {
        return this.maxPackageEntryDepth;
    }

    public long getOutputThreshold() {
        return this.threshold;
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i3) {
        advance(i3);
        super.ignorableWhitespace(cArr, i, i3);
    }

    public void setMaximumCompressionRatio(long j2) {
        this.ratio = j2;
    }

    public void setMaximumDepth(int i) {
        this.maxDepth = i;
    }

    public void setMaximumPackageEntryDepth(int i) {
        this.maxPackageEntryDepth = i;
    }

    public void setOutputThreshold(long j2) {
        this.threshold = j2;
    }

    @Override // org.apache.tika.sax.ContentHandlerDecorator, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        int i = this.currentDepth + 1;
        this.currentDepth = i;
        if (i < this.maxDepth) {
            if ("div".equals(str3) && "package-entry".equals(attributes.getValue(Constants.CLASS))) {
                this.packageEntryDepths.addLast(Integer.valueOf(this.currentDepth));
                if (this.packageEntryDepths.size() >= this.maxPackageEntryDepth) {
                    throw new SecureSAXException(AbstractC0008a.j(this.packageEntryDepths.size(), "Suspected zip bomb: ", " levels of package entry nesting"));
                }
            }
            super.startElement(str, str2, str3, attributes);
            return;
        }
        throw new SecureSAXException(AbstractC0008a.j(this.currentDepth, "Suspected zip bomb: ", " levels of XML element nesting"));
    }

    public void throwIfCauseOf(SAXException sAXException) {
        if ((sAXException instanceof SecureSAXException) && ((SecureSAXException) sAXException).isCausedBy(this)) {
            throw new TikaException("Zip bomb detected!", sAXException);
        }
    }
}
