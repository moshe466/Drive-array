package c6;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groboot.mdaemergency.models.Ksv;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class j extends ArrayAdapter<Ksv> implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    boolean f4427f;

    /* renamed from: g, reason: collision with root package name */
    a f4428g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Ksv> f4429h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<Ksv> f4430i;

    /* loaded from: classes.dex */
    public interface a {
        void a(Ksv ksv);
    }

    public j(Context context, ArrayList<Ksv> arrayList, boolean z10, a aVar) {
        super(context, R.layout.ksv_item, arrayList);
        this.f4430i = null;
        this.f4429h = arrayList;
        this.f4428g = aVar;
        this.f4427f = z10;
        ArrayList<Ksv> arrayList2 = new ArrayList<>();
        this.f4430i = arrayList2;
        arrayList2.addAll(this.f4429h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(Ksv ksv, Ksv ksv2) {
        return ksv.value.compareToIgnoreCase(ksv2.value);
    }

    public void b(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.f4429h.clear();
        if (lowerCase.length() == 0) {
            this.f4429h.addAll(this.f4430i);
        } else {
            Iterator<Ksv> it = this.f4430i.iterator();
            while (it.hasNext()) {
                Ksv next = it.next();
                if (next.value.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.f4429h.add(next);
                }
            }
        }
        Collections.sort(this.f4429h, new Comparator() { // from class: c6.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c10;
                c10 = j.c((Ksv) obj, (Ksv) obj2);
                return c10;
            }
        });
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        Ksv item = getItem(i10);
        boolean equals = item.key.equals("0");
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.ksv_item, (ViewGroup) null);
        }
        view.setTag(item);
        ((TextView) view.findViewById(R.id.ksv_item_value)).setText(Html.fromHtml(item.value));
        if (equals) {
            ((TextView) view.findViewById(R.id.ksv_item_value)).setGravity(17);
            ((TextView) view.findViewById(R.id.ksv_item_key)).setText("");
            view.setOnClickListener(null);
        } else {
            view.setOnClickListener(this);
            ((TextView) view.findViewById(R.id.ksv_item_value)).setGravity(5);
            if (this.f4427f) {
                ((TextView) view.findViewById(R.id.ksv_item_key)).setText(item.key);
            } else {
                ((TextView) view.findViewById(R.id.ksv_item_key)).setText("");
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4428g.a((Ksv) view.getTag());
    }
}
