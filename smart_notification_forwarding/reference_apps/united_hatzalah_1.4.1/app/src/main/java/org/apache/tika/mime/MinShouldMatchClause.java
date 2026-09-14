package org.apache.tika.mime;

import e0.a;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class MinShouldMatchClause implements Clause {
    private final List<Clause> clauses;
    private final int min;

    public MinShouldMatchClause(int i, List<Clause> list) {
        if (list != null && list.size() != 0) {
            if (i <= list.size()) {
                if (i > 0) {
                    this.min = i;
                    this.clauses = list;
                    return;
                }
                throw new IllegalArgumentException(a.c(i, "min cannot be <= 0: "));
            }
            throw new IllegalArgumentException("min (" + i + ") cannot be > clauses.size (" + list.size() + ")");
        }
        throw new IllegalArgumentException("clauses must be not null with size > 0");
    }

    @Override // org.apache.tika.mime.Clause
    public boolean eval(byte[] bArr) {
        Iterator<Clause> it = this.clauses.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().eval(bArr) && (i = i + 1) >= this.min) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.tika.mime.Clause
    public int size() {
        Iterator<Clause> it = this.clauses.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = Math.max(i, it.next().size());
        }
        return i;
    }

    public String toString() {
        return "minShouldMatch (min: " + this.min + ") " + this.clauses;
    }
}
