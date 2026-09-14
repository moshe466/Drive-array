package c6;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.groboot.mdaemergency.ui.fragments.a;
import il.org.mda.health.R;
import java.util.List;

/* loaded from: classes.dex */
public class g extends ArrayAdapter<a.c> {

    /* renamed from: f, reason: collision with root package name */
    private Context f4418f;

    /* renamed from: g, reason: collision with root package name */
    private int f4419g;

    /* renamed from: h, reason: collision with root package name */
    private List<a.c> f4420h;

    /* renamed from: i, reason: collision with root package name */
    d f4421i;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f4421i.c((a.c) view.getTag());
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.c cVar = (a.c) view.getTag();
            if (g.this.f4421i.a(cVar)) {
                g.this.f4420h.remove(cVar);
                g.this.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.f4421i.b((a.c) view.getTag());
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(a.c cVar);

        void b(a.c cVar);

        void c(a.c cVar);
    }

    public g(Context context, int i10, List<a.c> list, d dVar) {
        super(context, i10, list);
        this.f4418f = context;
        this.f4419g = i10;
        this.f4420h = list;
        this.f4421i = dVar;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a.c getItem(int i10) {
        return this.f4420h.get(i10);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f4418f.getSystemService("layout_inflater")).inflate(this.f4419g, (ViewGroup) null);
        }
        a.c cVar = this.f4420h.get(i10);
        if (cVar != null) {
            TextView textView = (TextView) view.findViewById(R.id.TextView01);
            TextView textView2 = (TextView) view.findViewById(R.id.TextView02);
            TextView textView3 = (TextView) view.findViewById(R.id.TextViewDate);
            ImageView imageView = (ImageView) view.findViewById(R.id.fd_Icon1);
            Bitmap u10 = cVar.u();
            if (u10 != null) {
                imageView.setImageBitmap(u10);
            } else {
                imageView.setImageResource(cVar.v().intValue());
            }
            view.findViewById(R.id.fd_share).setTag(cVar);
            view.findViewById(R.id.fd_share).setOnClickListener(new a());
            view.findViewById(R.id.fd_delete).setTag(cVar);
            view.findViewById(R.id.fd_delete).setOnClickListener(new b());
            if (textView != null) {
                textView.setText(cVar.s());
            }
            if (textView2 != null) {
                textView2.setText(cVar.l());
            }
            if (textView3 != null) {
                textView3.setText(cVar.n());
            }
            view.setTag(cVar);
            view.setOnClickListener(new c());
        }
        return view;
    }
}
