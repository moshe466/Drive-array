package g7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class m implements l {

    /* renamed from: a, reason: collision with root package name */
    private File f9907a;

    public m(String str) {
        this.f9907a = null;
        this.f9907a = new File(str);
    }

    @Override // g7.l
    public int a() {
        return (int) this.f9907a.length();
    }

    public InputStream b() {
        try {
            return new FileInputStream(this.f9907a);
        } catch (FileNotFoundException e10) {
            throw new IOException(e10.getMessage());
        }
    }
}
