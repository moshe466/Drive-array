package rb;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;
import qb.f;

/* loaded from: classes.dex */
public class c extends qb.a {
    private List<rb.a> A;
    private b B;

    /* renamed from: z, reason: collision with root package name */
    private ImageScanner f13848z;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rb.b f13849f;

        a(rb.b bVar) {
            this.f13849f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = c.this.B;
            c.this.B = null;
            c.this.i();
            if (bVar != null) {
                bVar.d(this.f13849f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void d(rb.b bVar);
    }

    static {
        System.loadLibrary("iconv");
    }

    public c(Context context) {
        super(context);
        m();
    }

    public Collection<rb.a> getFormats() {
        List<rb.a> list = this.A;
        return list == null ? rb.a.f13844s : list;
    }

    public void l(b bVar) {
        this.B = bVar;
        super.e();
    }

    public void m() {
        ImageScanner imageScanner = new ImageScanner();
        this.f13848z = imageScanner;
        imageScanner.setConfig(0, 256, 3);
        this.f13848z.setConfig(0, 257, 3);
        this.f13848z.setConfig(0, 0, 0);
        Iterator<rb.a> it = getFormats().iterator();
        while (it.hasNext()) {
            this.f13848z.setConfig(it.next().b(), 0, 1);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.B == null) {
            return;
        }
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            int i10 = previewSize.width;
            int i11 = previewSize.height;
            if (f.a(getContext()) == 1) {
                int rotationCount = getRotationCount();
                if (rotationCount == 1 || rotationCount == 3) {
                    i10 = i11;
                    i11 = i10;
                }
                bArr = c(bArr, camera);
            }
            Rect b10 = b(i10, i11);
            Image image = new Image(i10, i11, "Y800");
            image.setData(bArr);
            image.setCrop(b10.left, b10.top, b10.width(), b10.height());
            if (this.f13848z.scanImage(image) == 0) {
                camera.setOneShotPreviewCallback(this);
                return;
            }
            SymbolSet b11 = this.f13848z.b();
            rb.b bVar = new rb.b();
            Iterator<Symbol> it = b11.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Symbol next = it.next();
                String str = Build.VERSION.SDK_INT >= 19 ? new String(next.getDataBytes(), StandardCharsets.UTF_8) : next.getData();
                if (!TextUtils.isEmpty(str)) {
                    bVar.d(str);
                    bVar.c(rb.a.a(next.b()));
                    break;
                }
            }
            new Handler(Looper.getMainLooper()).post(new a(bVar));
        } catch (RuntimeException e10) {
            e10.toString();
        }
    }

    public void setFormats(List<rb.a> list) {
        this.A = list;
        m();
    }

    public void setResultHandler(b bVar) {
        this.B = bVar;
    }
}
