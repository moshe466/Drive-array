package g1;

import android.content.ContentResolver;
import android.provider.Settings;
import d1.C0358a;

/* loaded from: classes.dex */
public final class n extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4704a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0358a f4705b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4706c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(C0358a c0358a, String str, int i) {
        super(0);
        this.f4704a = i;
        this.f4705b = c0358a;
        this.f4706c = str;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f4704a) {
            case 0:
                ContentResolver contentResolver = this.f4705b.f4413a;
                kotlin.jvm.internal.j.b(contentResolver);
                String string = Settings.Global.getString(contentResolver, this.f4706c);
                kotlin.jvm.internal.j.b(string);
                return string;
            case 1:
                ContentResolver contentResolver2 = this.f4705b.f4413a;
                kotlin.jvm.internal.j.b(contentResolver2);
                String string2 = Settings.Secure.getString(contentResolver2, this.f4706c);
                kotlin.jvm.internal.j.b(string2);
                return string2;
            default:
                ContentResolver contentResolver3 = this.f4705b.f4413a;
                kotlin.jvm.internal.j.b(contentResolver3);
                String string3 = Settings.System.getString(contentResolver3, this.f4706c);
                kotlin.jvm.internal.j.b(string3);
                return string3;
        }
    }
}
