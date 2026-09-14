package c6;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import il.org.mda.health.R;
import java.util.ArrayList;
import w6.t;

/* loaded from: classes.dex */
public class n extends ArrayAdapter<w6.t> {

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<w6.t> f4439f;

    /* renamed from: g, reason: collision with root package name */
    Activity f4440g;

    /* renamed from: h, reason: collision with root package name */
    b f4441h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<t.a> f4442i;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((w6.t) view.getTag()).b(n.this.f4440g)) {
                return;
            }
            n.this.f4441h.a((w6.t) view.getTag());
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(w6.t tVar);
    }

    public n(Activity activity, ArrayList<w6.t> arrayList, b bVar) {
        super(activity, R.layout.permission_item, arrayList);
        this.f4439f = arrayList;
        this.f4440g = activity;
        this.f4441h = bVar;
    }

    public void a(ArrayList<t.a> arrayList) {
        this.f4442i = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ArrayList<t.a> arrayList;
        w6.t tVar = this.f4439f.get(i10);
        LayoutInflater layoutInflater = this.f4440g.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.permission_item, viewGroup, false);
            view.findViewById(R.id.btn_get_permission).setOnClickListener(new a());
        }
        ((TextView) view.findViewById(R.id.tv_caption)).setText(Html.fromHtml(tVar.f15258b));
        ((TextView) view.findViewById(R.id.tv_text)).setText(Html.fromHtml(tVar.f15257a));
        boolean b10 = tVar.b(this.f4440g);
        view.findViewById(R.id.iv_done).setVisibility(b10 ? 0 : 8);
        view.findViewById(R.id.btn_get_permission).setVisibility(b10 ? 8 : 0);
        view.findViewById(R.id.btn_get_permission).setTag(tVar);
        if (!b10 && (arrayList = this.f4442i) != null && arrayList.contains(tVar.f15261e)) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_get_permission);
            imageView.setBackgroundResource(R.drawable.red_btn_anim2);
            ((AnimationDrawable) imageView.getBackground()).start();
        }
        return view;
    }
}
