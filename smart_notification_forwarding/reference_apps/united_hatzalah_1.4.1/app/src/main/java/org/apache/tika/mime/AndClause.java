package org.apache.tika.mime;

import e0.a;
import java.util.Arrays;

/* loaded from: classes.dex */
class AndClause implements Clause {
    private final Clause[] clauses;

    public AndClause(Clause... clauseArr) {
        this.clauses = clauseArr;
    }

    @Override // org.apache.tika.mime.Clause
    public boolean eval(byte[] bArr) {
        for (Clause clause : this.clauses) {
            if (!clause.eval(bArr)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.tika.mime.Clause
    public int size() {
        int i = 0;
        for (Clause clause : this.clauses) {
            i += clause.size();
        }
        return i;
    }

    public String toString() {
        return a.d("and", Arrays.toString(this.clauses));
    }
}
