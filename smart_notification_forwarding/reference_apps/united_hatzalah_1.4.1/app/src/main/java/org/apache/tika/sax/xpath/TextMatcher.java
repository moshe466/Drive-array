package org.apache.tika.sax.xpath;

/* loaded from: classes.dex */
public class TextMatcher extends Matcher {
    public static final Matcher INSTANCE = new TextMatcher();

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesText() {
        return true;
    }
}
