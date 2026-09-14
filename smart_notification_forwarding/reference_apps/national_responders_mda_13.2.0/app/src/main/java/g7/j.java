package g7;

/* loaded from: classes.dex */
public class j implements f7.c {

    /* renamed from: a, reason: collision with root package name */
    protected b7.b f9905a;

    public j(b7.b bVar) {
        this.f9905a = bVar;
    }

    @Override // f7.c
    public void a(String str) {
        if (str != null) {
            this.f9905a.h((str + "\r\n").getBytes());
        }
    }
}
