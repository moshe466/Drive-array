package com.google.firebase.database.core.utilities;

/* loaded from: classes.dex */
public final class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T t3, U u3) {
        this.first = t3;
        this.second = u3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Pair.class != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        T t3 = this.first;
        if (t3 == null ? pair.first != null : !t3.equals(pair.first)) {
            return false;
        }
        U u3 = this.second;
        U u4 = pair.second;
        if (u3 == null ? u4 == null : u3.equals(u4)) {
            return true;
        }
        return false;
    }

    public T getFirst() {
        return this.first;
    }

    public U getSecond() {
        return this.second;
    }

    public int hashCode() {
        int i;
        T t3 = this.first;
        int i3 = 0;
        if (t3 != null) {
            i = t3.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        U u3 = this.second;
        if (u3 != null) {
            i3 = u3.hashCode();
        }
        return i4 + i3;
    }

    public String toString() {
        return "Pair(" + this.first + "," + this.second + ")";
    }
}
