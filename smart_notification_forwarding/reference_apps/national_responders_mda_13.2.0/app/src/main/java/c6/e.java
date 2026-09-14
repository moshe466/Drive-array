package c6;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groboot.mdaemergency.models.Feature;
import il.org.mda.health.R;
import java.util.List;
import w6.l0;

/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    Context f4412f;

    /* renamed from: g, reason: collision with root package name */
    LayoutInflater f4413g;

    /* renamed from: h, reason: collision with root package name */
    List<Feature> f4414h;

    public e(Context context, List<Feature> list) {
        this.f4412f = context;
        this.f4413g = LayoutInflater.from(context);
        if (list.size() > w6.m.N()) {
            this.f4414h = list.subList(0, w6.m.N());
        } else {
            this.f4414h = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4414h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        Feature feature = this.f4414h.get(i10);
        if (view == null) {
            view = this.f4413g.inflate((feature == null || !feature.isAdded) ? R.layout.shortcut_item : R.layout.shortcut_item_descrption, (ViewGroup) null);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setLayoutParams(new LinearLayout.LayoutParams(l0.W0(this.f4412f, 80), l0.W0(this.f4412f, 60)));
        }
        if (feature == null) {
            view.setVisibility(4);
            return view;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        boolean z10 = feature.FeatureType == Feature.eFeatureType.Disabled.getId() || (feature.FeatureType == Feature.eFeatureType.Availability.getId() && feature.IconID == com.groboot.mdaemergency.enums.b.NOT_AVAILABLE.getNum());
        Context context = this.f4412f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(feature.FeatureType == Feature.eFeatureType.Availability.getId() ? "user_status_" : "icon_");
        sb2.append(feature.IconID);
        imageView.setImageDrawable(l0.G(context, sb2.toString()));
        imageView.setColorFilter(androidx.core.content.a.d(this.f4412f, z10 ? R.color.grey : R.color.red_text), PorterDuff.Mode.SRC_IN);
        TextView textView = (TextView) view.findViewById(R.id.tv_description);
        if (feature.isAdded) {
            textView.setText(feature.Description);
        } else {
            textView.setVisibility(8);
        }
        View findViewById = view.findViewById(R.id.view_status);
        if (findViewById != null) {
            if (feature.Badge > -1) {
                findViewById.setVisibility(0);
                findViewById.setBackgroundResource(feature.Badge > 0 ? R.drawable.oval_green : R.drawable.oval_red);
            } else {
                findViewById.setVisibility(8);
            }
        }
        return view;
    }
}
