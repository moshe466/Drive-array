package c6;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.groboot.mdaemergency.models.Feature;
import il.org.mda.health.R;
import java.util.ArrayList;
import w6.l0;

/* loaded from: classes.dex */
public class m extends ArrayAdapter<Feature> {

    /* renamed from: f, reason: collision with root package name */
    Context f4437f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<Feature> f4438g;

    public m(Context context, ArrayList<Feature> arrayList) {
        super(context, R.layout.menu_item, arrayList);
        this.f4437f = context;
        this.f4438g = arrayList;
    }

    private Drawable a(int i10, boolean z10) {
        if (z10) {
            return l0.G(this.f4437f, "icon_" + i10 + "_gray");
        }
        w6.m.m();
        Drawable G = l0.G(this.f4437f, "icon_" + i10);
        if (G == null) {
            G = l0.G(this.f4437f, "icon_0");
        }
        b(G);
        return G;
    }

    private void b(Drawable drawable) {
        int u10 = l0.u(this.f4437f, w6.m.m() == com.groboot.mdaemergency.enums.a.POC ? R.color.title_text_color : R.color.red_text);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        if (drawable != null) {
            drawable.setColorFilter(u10, mode);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        Feature feature = this.f4438g.get(i10);
        LayoutInflater layoutInflater = ((Activity) this.f4437f).getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.menu_item, viewGroup, false);
        }
        if (feature == null) {
            return view;
        }
        ((TextView) view.findViewById(R.id.tv_text)).setText(feature.Description);
        if (feature.FeatureType == Feature.eFeatureType.Availability.getId()) {
            Drawable G = l0.G(this.f4437f, "user_status_" + feature.IconID);
            ((ImageView) view.findViewById(R.id.iv_icon)).setImageDrawable(G);
            if (feature.IconID != com.groboot.mdaemergency.enums.b.NOT_AVAILABLE.getNum()) {
                b(G);
            }
            return view;
        }
        if (feature.FeatureType == 4 && !com.groboot.mdaemergency.ptt.p.n0()) {
            feature.FeatureType = 3;
        }
        ((ImageView) view.findViewById(R.id.iv_icon)).setImageDrawable(a(feature.IconID, feature.FeatureType == Feature.eFeatureType.Disabled.getId()));
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
