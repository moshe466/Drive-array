package org.apache.tika.sax.xpath;

/* loaded from: classes.dex */
public class ElementMatcher extends Matcher {
    public static final Matcher INSTANCE = new ElementMatcher();

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesElement() {
        return true;
    }
}
