package P;

import android.database.Cursor;
import android.widget.Filter;
import m.f1;

/* loaded from: classes.dex */
public final class d extends Filter {

    /* renamed from: a, reason: collision with root package name */
    public c f1559a;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return ((f1) this.f1559a).c((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r5) {
        /*
            r4 = this;
            P.c r0 = r4.f1559a
            m.f1 r0 = (m.f1) r0
            androidx.appcompat.widget.SearchView r1 = r0.f5653n
            if (r5 != 0) goto Lb
            java.lang.String r5 = ""
            goto Lf
        Lb:
            java.lang.String r5 = r5.toString()
        Lf:
            int r2 = r1.getVisibility()
            r3 = 0
            if (r2 != 0) goto L29
            int r1 = r1.getWindowVisibility()
            if (r1 == 0) goto L1d
            goto L29
        L1d:
            android.app.SearchableInfo r1 = r0.f5654o     // Catch: java.lang.RuntimeException -> L29
            android.database.Cursor r5 = r0.g(r1, r5)     // Catch: java.lang.RuntimeException -> L29
            if (r5 == 0) goto L29
            r5.getCount()     // Catch: java.lang.RuntimeException -> L29
            goto L2a
        L29:
            r5 = r3
        L2a:
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            if (r5 == 0) goto L3a
            int r1 = r5.getCount()
            r0.count = r1
            r0.values = r5
            goto L3f
        L3a:
            r5 = 0
            r0.count = r5
            r0.values = r3
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: P.d.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        c cVar = this.f1559a;
        Cursor cursor = cVar.f1554c;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((f1) cVar).b((Cursor) obj);
        }
    }
}
