package c6;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.ui.views.DynamicGridView;
import il.org.mda.health.R;
import java.util.List;
import w6.l0;

/* loaded from: classes.dex */
public class v extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    private final DynamicGridView.c f4491f;

    /* renamed from: g, reason: collision with root package name */
    private Context f4492g;

    /* renamed from: h, reason: collision with root package name */
    private List<Feature> f4493h;

    /* renamed from: i, reason: collision with root package name */
    boolean f4494i;

    /* renamed from: j, reason: collision with root package name */
    LayoutInflater f4495j;

    /* renamed from: k, reason: collision with root package name */
    ConstraintLayout f4496k;

    /* renamed from: l, reason: collision with root package name */
    ImageView f4497l;

    public v(Context context, List<Feature> list, boolean z10, DynamicGridView.c cVar) {
        this.f4492g = context;
        this.f4493h = list;
        this.f4494i = z10;
        this.f4495j = LayoutInflater.from(context);
        this.f4491f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i10, int i11, Feature feature, View view) {
        if (i10 < i11) {
            if (i10 < 5 && this.f4493h.get(5) == null && this.f4493h.get(9) == null) {
                for (int i12 = 0; i12 < 5; i12++) {
                    this.f4493h.remove(5);
                }
            }
            this.f4493h.remove(i10);
            int i13 = i11 - 1;
            this.f4493h.add(i13, null);
            this.f4493h.add(feature);
            w6.m.W(this.f4493h.subList(0, i13));
        } else {
            if (!feature.isAdded) {
                return;
            }
            w6.m.M().removeFeature(feature);
            this.f4493h.remove(i10);
        }
        notifyDataSetInvalidated();
        this.f4491f.a(this.f4493h);
    }

    public List<Feature> b() {
        return this.f4493h;
    }

    public void c(boolean z10) {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4493h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f4493h.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(final int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f4495j.inflate(R.layout.shortcut_item, (ViewGroup) null);
        }
        this.f4496k = (ConstraintLayout) view.findViewById(R.id.rootView);
        this.f4497l = (ImageView) view.findViewById(R.id.img_emptyShortcut);
        this.f4496k.setVisibility(0);
        this.f4497l.setVisibility(8);
        final Feature feature = this.f4493h.get(i10);
        if (feature == null) {
            this.f4496k.setVisibility(4);
            this.f4497l.setVisibility(0);
            view.setTag(feature);
            return view;
        }
        List<String> L = w6.m.L();
        final int size = L == null ? 5 : L.size();
        view.setTag(feature);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        imageView.setColorFilter(androidx.core.content.a.d(this.f4492g, i10 < size ? R.color.red_text : R.color.grey), PorterDuff.Mode.SRC_IN);
        Context context = this.f4492g;
        StringBuilder sb2 = new StringBuilder();
        int i11 = feature.FeatureType;
        Feature.eFeatureType efeaturetype = Feature.eFeatureType.Availability;
        sb2.append(i11 == efeaturetype.getId() ? "user_status_" : "icon_");
        sb2.append(this.f4493h.get(i10).IconID);
        imageView.setImageDrawable(l0.G(context, sb2.toString()));
        TextView textView = (TextView) view.findViewById(R.id.tv_description);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_close);
        if ((i10 < size || feature.isLocally) && feature.FeatureType != efeaturetype.getId()) {
            relativeLayout.setVisibility(0);
            ((ImageView) view.findViewById(R.id.img_close)).setImageResource(i10 < size ? R.drawable.remove : R.drawable.close);
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: c6.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    v.this.d(i10, size, feature, view2);
                }
            });
        } else {
            relativeLayout.setVisibility(8);
        }
        if (this.f4494i) {
            textView.setVisibility(0);
            textView.setText(feature.FeatureType == efeaturetype.getId() ? this.f4492g.getString(R.string.status_availability) : feature.Description);
        } else {
            textView.setVisibility(8);
        }
        return view;
    }
}
