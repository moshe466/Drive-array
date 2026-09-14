package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* loaded from: classes2.dex */
public class ChildKey implements Comparable<ChildKey> {
    private final String key;
    private static final ChildKey MIN_KEY = new ChildKey("[MIN_KEY]");
    private static final ChildKey MAX_KEY = new ChildKey("[MAX_KEY]");
    private static final ChildKey PRIORITY_CHILD_KEY = new ChildKey(".priority");
    private static final ChildKey INFO_CHILD_KEY = new ChildKey(".info");

    /* loaded from: classes2.dex */
    private static class IntegerChildKey extends ChildKey {
        private final int intValue;

        IntegerChildKey(String str, int i) {
            super(str);
            this.intValue = i;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        protected int a() {
            return this.intValue;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        protected boolean b() {
            return true;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ChildKey childKey) {
            return super.compareTo(childKey);
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public String toString() {
            return "IntegerChildName(\"" + ((ChildKey) this).key + "\")";
        }
    }

    private ChildKey(String str) {
        this.key = str;
    }

    public static ChildKey fromString(String str) {
        Integer tryParseInt = Utilities.tryParseInt(str);
        return tryParseInt != null ? new IntegerChildKey(str, tryParseInt.intValue()) : str.equals(".priority") ? PRIORITY_CHILD_KEY : new ChildKey(str);
    }

    public static ChildKey getInfoKey() {
        return INFO_CHILD_KEY;
    }

    public static ChildKey getMaxName() {
        return MAX_KEY;
    }

    public static ChildKey getMinName() {
        return MIN_KEY;
    }

    public static ChildKey getPriorityKey() {
        return PRIORITY_CHILD_KEY;
    }

    protected int a() {
        return 0;
    }

    public String asString() {
        return this.key;
    }

    protected boolean b() {
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChildKey childKey) {
        ChildKey childKey2;
        if (this == childKey) {
            return 0;
        }
        ChildKey childKey3 = MIN_KEY;
        if (this == childKey3 || childKey == (childKey2 = MAX_KEY)) {
            return -1;
        }
        if (childKey == childKey3 || this == childKey2) {
            return 1;
        }
        if (!b()) {
            if (childKey.b()) {
                return 1;
            }
            return this.key.compareTo(childKey.key);
        }
        if (!childKey.b()) {
            return -1;
        }
        int compareInts = Utilities.compareInts(a(), childKey.a());
        return compareInts == 0 ? Utilities.compareInts(this.key.length(), childKey.key.length()) : compareInts;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChildKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.key.equals(((ChildKey) obj).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public boolean isPriorityChildName() {
        return equals(PRIORITY_CHILD_KEY);
    }

    public String toString() {
        return "ChildKey(\"" + this.key + "\")";
    }
}
