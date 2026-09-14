package c6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groboot.mdaemergency.models.CoronaBarcode;
import com.groboot.mdaemergency.models.Kv;
import il.org.mda.health.R;
import java.util.ArrayList;
import w6.l0;

/* loaded from: classes.dex */
public class d extends ArrayAdapter<CoronaBarcode> {

    /* renamed from: f, reason: collision with root package name */
    Context f4410f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<CoronaBarcode> f4411g;

    public d(Context context, ArrayList<CoronaBarcode> arrayList) {
        super(context, R.layout.item_barcode, arrayList);
        this.f4410f = context;
        this.f4411g = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        CoronaBarcode coronaBarcode = this.f4411g.get(i10);
        LayoutInflater from = LayoutInflater.from(this.f4410f);
        if (view == null) {
            view = from.inflate(R.layout.item_barcode, viewGroup, false);
        }
        if (view != null) {
            ((TextView) view.findViewById(R.id.tv_barcodes)).setText(coronaBarcode.barcode);
            ((TextView) view.findViewById(R.id.tv_date)).setText(l0.J(coronaBarcode.date));
            view.findViewById(R.id.iv_saved).setVisibility(coronaBarcode.isSaved ? 0 : 8);
            Kv kv = coronaBarcode.HMO;
            if (kv != null) {
                int i11 = R.color.ptt_play_gray_light;
                int i12 = kv.key;
                if (i12 == 1) {
                    i11 = R.color.ptt_play_green_light;
                } else if (i12 == 2) {
                    i11 = R.color.ptt_play_red_light;
                } else if (i12 == 3) {
                    i11 = R.color.ptt_play_yellow_light;
                } else if (i12 == 4) {
                    i11 = R.color.ptt_play_blue_light;
                }
                view.findViewById(R.id.v_background).setBackgroundColor(l0.u(this.f4410f, i11));
            }
        }
        return view;
    }
}
