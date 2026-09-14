package g1;

import F0.b3;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.media.RingtoneManager;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4683a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b3 f4684b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(b3 b3Var, int i) {
        super(0);
        this.f4683a = i;
        this.f4684b = b3Var;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f4683a) {
            case 0:
                AssetManager assetManager = (AssetManager) this.f4684b.f470c;
                kotlin.jvm.internal.j.b(assetManager);
                String[] locales = assetManager.getLocales();
                kotlin.jvm.internal.j.b(locales);
                ArrayList arrayList = new ArrayList(locales.length);
                for (String str : locales) {
                    arrayList.add(String.valueOf(str));
                }
                return (String[]) arrayList.toArray(new String[0]);
            case 1:
                Configuration configuration = (Configuration) this.f4684b.f471d;
                kotlin.jvm.internal.j.b(configuration);
                Locale locale = configuration.locale;
                kotlin.jvm.internal.j.b(locale);
                String country = locale.getCountry();
                kotlin.jvm.internal.j.b(country);
                return country;
            default:
                RingtoneManager ringtoneManager = (RingtoneManager) this.f4684b.f469b;
                kotlin.jvm.internal.j.b(ringtoneManager);
                Uri ringtoneUri = ringtoneManager.getRingtoneUri(0);
                kotlin.jvm.internal.j.b(ringtoneUri);
                String uri = ringtoneUri.toString();
                kotlin.jvm.internal.j.b(uri);
                return uri;
        }
    }
}
