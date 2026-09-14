package w6;

import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class r extends ArrayList<p> implements Filterable {

    /* renamed from: g, reason: collision with root package name */
    static int f15251g = 1;

    /* renamed from: f, reason: collision with root package name */
    c f15252f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Filter.FilterListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f15253f;

        a(b bVar) {
            this.f15253f = bVar;
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i10) {
            this.f15253f.a(r.this.f15252f.f15255a);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(r rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends Filter {

        /* renamed from: a, reason: collision with root package name */
        r f15255a;

        private c() {
        }

        /* synthetic */ c(r rVar, a aVar) {
            this();
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            int size;
            int i10;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                r rVar = r.this;
                filterResults.values = rVar;
                size = rVar.size();
            } else {
                int U = l0.U(charSequence.toString());
                int size2 = r.this.size();
                r rVar2 = new r();
                while (i10 < size2) {
                    p pVar = r.this.get(i10);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("step:");
                    int i11 = r.f15251g;
                    r.f15251g = i11 + 1;
                    sb2.append(i11);
                    if (U == 12) {
                        i10 = pVar.f15240f ? 0 : i10 + 1;
                        rVar2.add(pVar);
                    } else if (U == 11) {
                        if (pVar.f15239e == 2) {
                        }
                        rVar2.add(pVar);
                    } else {
                        if (pVar.f15239e != U) {
                        }
                        rVar2.add(pVar);
                    }
                }
                filterResults.values = rVar2;
                size = rVar2.size();
            }
            filterResults.count = size;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            this.f15255a = (r) filterResults.values;
        }
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f15252f == null) {
            this.f15252f = new c(this, null);
        }
        return this.f15252f;
    }

    public void l(b bVar) {
        s(12, bVar);
    }

    public void s(int i10, b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("type:");
        sb2.append(i10);
        getFilter().filter(i10 + "", new a(bVar));
    }

    public p t(String str) {
        Iterator<p> it = iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (l0.l(next.f15235a, str)) {
                return next;
            }
        }
        return null;
    }

    public String[] u() {
        ArrayList<String> w10 = w();
        return (String[]) w10.toArray(new String[w10.size()]);
    }

    public ArrayList<String> w() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<p> it = iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null) {
                arrayList.add(next.f15235a);
            }
        }
        return arrayList;
    }

    public void x(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (l0.l(pVar.f15235a, str)) {
                remove(pVar);
                return;
            }
        }
    }
}
