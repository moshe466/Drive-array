package org.apache.tika.sax.xpath;

/* loaded from: classes.dex */
public class SubtreeMatcher extends Matcher {
    private final Matcher then;

    public SubtreeMatcher(Matcher matcher) {
        this.then = matcher;
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public Matcher descend(String str, String str2) {
        Matcher descend = this.then.descend(str, str2);
        if (descend != Matcher.FAIL && descend != this.then) {
            return new CompositeMatcher(descend, this);
        }
        return this;
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesAttribute(String str, String str2) {
        return this.then.matchesAttribute(str, str2);
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesElement() {
        return this.then.matchesElement();
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesText() {
        return this.then.matchesText();
    }
}
