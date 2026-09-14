package org.apache.tika.sax.xpath;

/* loaded from: classes.dex */
public class CompositeMatcher extends Matcher {

    /* renamed from: a, reason: collision with root package name */
    private final Matcher f5969a;

    /* renamed from: b, reason: collision with root package name */
    private final Matcher f5970b;

    public CompositeMatcher(Matcher matcher, Matcher matcher2) {
        this.f5969a = matcher;
        this.f5970b = matcher2;
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public Matcher descend(String str, String str2) {
        Matcher descend = this.f5969a.descend(str, str2);
        Matcher descend2 = this.f5970b.descend(str, str2);
        Matcher matcher = Matcher.FAIL;
        if (descend == matcher) {
            return descend2;
        }
        if (descend2 == matcher) {
            return descend;
        }
        if (this.f5969a == descend && this.f5970b == descend2) {
            return this;
        }
        return new CompositeMatcher(descend, descend2);
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesAttribute(String str, String str2) {
        if (!this.f5969a.matchesAttribute(str, str2) && !this.f5970b.matchesAttribute(str, str2)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesElement() {
        if (!this.f5969a.matchesElement() && !this.f5970b.matchesElement()) {
            return false;
        }
        return true;
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesText() {
        if (!this.f5969a.matchesText() && !this.f5970b.matchesText()) {
            return false;
        }
        return true;
    }
}
