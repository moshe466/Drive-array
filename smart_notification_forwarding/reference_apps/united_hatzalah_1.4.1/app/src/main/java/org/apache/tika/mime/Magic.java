package org.apache.tika.mime;

import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes.dex */
class Magic implements Clause, Comparable<Magic> {
    private final Clause clause;
    private final int priority;
    private final String string;
    private final MimeType type;

    public Magic(MimeType mimeType, int i, Clause clause) {
        this.type = mimeType;
        this.priority = i;
        this.clause = clause;
        this.string = "[" + i + RemoteSettings.FORWARD_SLASH_STRING + clause + "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Magic) {
            Magic magic = (Magic) obj;
            if (this.type.equals(magic.type) && this.string.equals(magic.string)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.tika.mime.Clause
    public boolean eval(byte[] bArr) {
        return this.clause.eval(bArr);
    }

    public int getPriority() {
        return this.priority;
    }

    public MimeType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() ^ this.string.hashCode();
    }

    @Override // org.apache.tika.mime.Clause
    public int size() {
        return this.clause.size();
    }

    public String toString() {
        return this.string;
    }

    @Override // java.lang.Comparable
    public int compareTo(Magic magic) {
        int i = magic.priority - this.priority;
        if (i == 0) {
            i = magic.size() - size();
        }
        if (i == 0) {
            i = magic.type.compareTo(this.type);
        }
        return i == 0 ? magic.string.compareTo(this.string) : i;
    }
}
