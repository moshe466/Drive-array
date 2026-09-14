package t1;

import F0.AbstractC0008a;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public String f6413a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f6414b;

    /* renamed from: c, reason: collision with root package name */
    public n f6415c;

    /* renamed from: d, reason: collision with root package name */
    public Long f6416d;

    /* renamed from: e, reason: collision with root package name */
    public Long f6417e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f6418f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f6419g;

    /* renamed from: h, reason: collision with root package name */
    public String f6420h;
    public byte[] i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f6421j;

    public final void a(String str, String str2) {
        HashMap hashMap = this.f6418f;
        if (hashMap != null) {
            hashMap.put(str, str2);
            return;
        }
        throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }

    public final j b() {
        String str;
        if (this.f6413a == null) {
            str = " transportName";
        } else {
            str = "";
        }
        if (this.f6415c == null) {
            str = str.concat(" encodedPayload");
        }
        if (this.f6416d == null) {
            str = AbstractC0008a.n(str, " eventMillis");
        }
        if (this.f6417e == null) {
            str = AbstractC0008a.n(str, " uptimeMillis");
        }
        if (this.f6418f == null) {
            str = AbstractC0008a.n(str, " autoMetadata");
        }
        if (str.isEmpty()) {
            return new j(this.f6413a, this.f6414b, this.f6415c, this.f6416d.longValue(), this.f6417e.longValue(), this.f6418f, this.f6419g, this.f6420h, this.i, this.f6421j);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }
}
