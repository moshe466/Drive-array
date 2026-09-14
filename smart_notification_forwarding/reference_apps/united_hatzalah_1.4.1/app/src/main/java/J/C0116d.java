package J;

import F0.AbstractC0008a;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* renamed from: J.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0116d implements InterfaceC0115c, InterfaceC0117e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f976a = 0;

    /* renamed from: b, reason: collision with root package name */
    public ClipData f977b;

    /* renamed from: c, reason: collision with root package name */
    public int f978c;

    /* renamed from: d, reason: collision with root package name */
    public int f979d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f980e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f981f;

    public /* synthetic */ C0116d() {
    }

    @Override // J.InterfaceC0117e
    public ClipData a() {
        return this.f977b;
    }

    @Override // J.InterfaceC0115c
    public void b(Uri uri) {
        this.f980e = uri;
    }

    @Override // J.InterfaceC0115c
    public C0118f build() {
        return new C0118f(new C0116d(this));
    }

    @Override // J.InterfaceC0115c
    public void c(int i) {
        this.f979d = i;
    }

    @Override // J.InterfaceC0117e
    public int getSource() {
        return this.f978c;
    }

    @Override // J.InterfaceC0117e
    public int l() {
        return this.f979d;
    }

    @Override // J.InterfaceC0117e
    public ContentInfo n() {
        return null;
    }

    @Override // J.InterfaceC0115c
    public void setExtras(Bundle bundle) {
        this.f981f = bundle;
    }

    public String toString() {
        String str;
        String valueOf;
        String str2;
        switch (this.f976a) {
            case 1:
                Uri uri = this.f980e;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f977b.getDescription());
                sb.append(", source=");
                int i = this.f978c;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    if (i != 5) {
                                        str = String.valueOf(i);
                                    } else {
                                        str = "SOURCE_PROCESS_TEXT";
                                    }
                                } else {
                                    str = "SOURCE_AUTOFILL";
                                }
                            } else {
                                str = "SOURCE_DRAG_AND_DROP";
                            }
                        } else {
                            str = "SOURCE_INPUT_METHOD";
                        }
                    } else {
                        str = "SOURCE_CLIPBOARD";
                    }
                } else {
                    str = "SOURCE_APP";
                }
                sb.append(str);
                sb.append(", flags=");
                int i3 = this.f979d;
                if ((i3 & 1) != 0) {
                    valueOf = "FLAG_CONVERT_TO_PLAIN_TEXT";
                } else {
                    valueOf = String.valueOf(i3);
                }
                sb.append(valueOf);
                String str3 = "";
                if (uri == null) {
                    str2 = "";
                } else {
                    str2 = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str2);
                if (this.f981f != null) {
                    str3 = ", hasExtras";
                }
                return AbstractC0008a.u(sb, str3, "}");
            default:
                return super.toString();
        }
    }

    public C0116d(C0116d c0116d) {
        ClipData clipData = c0116d.f977b;
        clipData.getClass();
        this.f977b = clipData;
        int i = c0116d.f978c;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i <= 5) {
            this.f978c = i;
            int i3 = c0116d.f979d;
            if ((i3 & 1) == i3) {
                this.f979d = i3;
                this.f980e = c0116d.f980e;
                this.f981f = c0116d.f981f;
                return;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i3) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
    }
}
