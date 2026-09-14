package org.apache.tika.sax.xpath;

/* loaded from: classes.dex */
public class Matcher {
    public static final Matcher FAIL = new Matcher();

    public Matcher descend(String str, String str2) {
        return FAIL;
    }

    public boolean matchesAttribute(String str, String str2) {
        return false;
    }

    public boolean matchesElement() {
        return false;
    }

    public boolean matchesText() {
        return false;
    }
}
