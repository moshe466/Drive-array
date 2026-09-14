package c6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import g5.e;
import il.org.mda.health.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends ArrayAdapter<e.a> {

    /* renamed from: f, reason: collision with root package name */
    Context f4435f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<e.a> f4436g;

    public l(Context context, ArrayList<e.a> arrayList) {
        super(context, R.layout.log_text_view, arrayList);
        this.f4435f = context;
        this.f4436g = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        e.a aVar = this.f4436g.get(i10);
        LayoutInflater from = LayoutInflater.from(this.f4435f);
        if (view == null) {
            view = from.inflate(R.layout.log_text_view, viewGroup, false);
        }
        if (aVar != null) {
            ((TextView) view.findViewById(R.id.tv_text)).setText(aVar.f9809a + "\t" + aVar.f9810b);
            ((TextView) view.findViewById(R.id.tv_timeTitle)).setText(aVar.f9811c);
            view.findViewById(R.id.v_error).setVisibility(aVar.f9812d ? 0 : 8);
        }
        return view;
    }
}
