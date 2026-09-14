package com.google.firebase.database.core;

/* loaded from: classes.dex */
public final class Tag {
    private final long tagNumber;

    public Tag(long j2) {
        this.tagNumber = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Tag.class == obj.getClass() && this.tagNumber == ((Tag) obj).tagNumber) {
            return true;
        }
        return false;
    }

    public long getTagNumber() {
        return this.tagNumber;
    }

    public int hashCode() {
        long j2 = this.tagNumber;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.tagNumber + '}';
    }
}
