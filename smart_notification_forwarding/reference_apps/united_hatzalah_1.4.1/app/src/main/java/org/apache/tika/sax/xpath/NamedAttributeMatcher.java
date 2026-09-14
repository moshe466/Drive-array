package org.apache.tika.sax.xpath;

import java.util.Objects;

/* loaded from: classes.dex */
public class NamedAttributeMatcher extends Matcher {
    private final String name;
    private final String namespace;

    public NamedAttributeMatcher(String str, String str2) {
        this.namespace = str;
        this.name = str2;
    }

    @Override // org.apache.tika.sax.xpath.Matcher
    public boolean matchesAttribute(String str, String str2) {
        if (Objects.equals(str, this.namespace) && str2.equals(this.name)) {
            return true;
        }
        return false;
    }
}
