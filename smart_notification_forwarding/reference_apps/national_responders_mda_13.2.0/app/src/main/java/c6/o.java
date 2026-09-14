package c6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import il.org.mda.health.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class o extends ArrayAdapter<String> {

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f4444f;

    /* renamed from: g, reason: collision with root package name */
    Context f4445g;

    /* renamed from: h, reason: collision with root package name */
    o5.j f4446h;

    /* renamed from: i, reason: collision with root package name */
    public b f4447i;

    /* loaded from: classes.dex */
    class a extends Filter {
        a() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence != null) {
                o oVar = o.this;
                oVar.f4444f = oVar.f4446h.a(charSequence.toString());
                ArrayList<String> arrayList = o.this.f4444f;
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            o.this.f4447i.a(filterResults.count);
            if (filterResults.count > 0) {
                o.this.notifyDataSetChanged();
            } else {
                o.this.notifyDataSetInvalidated();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i10);
    }

    public o(Context context, int i10) {
        super(context, i10);
        this.f4446h = new o5.j();
        this.f4445g = context;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i10) {
        return this.f4444f.get(i10);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f4444f.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return new a();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f4445g.getSystemService("layout_inflater")).inflate(R.layout.autocomplete_list_item, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.autocompleteText);
        if (this.f4444f.size() >= i10) {
            textView.setText(this.f4444f.get(i10));
        }
        return view;
    }
}
