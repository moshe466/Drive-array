package com.shockwave.pdfium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.a;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PdfiumCore {

    /* renamed from: b, reason: collision with root package name */
    private static final Class f8607b = FileDescriptor.class;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f8608c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f8609d;

    /* renamed from: a, reason: collision with root package name */
    private int f8610a;

    static {
        try {
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Native libraries failed to load - ");
            sb2.append(e10);
        }
        f8608c = new Object();
        f8609d = null;
    }

    public PdfiumCore(Context context) {
        this.f8610a = context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int c(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (f8609d == null) {
                Field declaredField = f8607b.getDeclaredField("descriptor");
                f8609d = declaredField;
                declaredField.setAccessible(true);
            }
            return f8609d.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return -1;
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    private void l(List<a.C0138a> list, a aVar, long j10) {
        a.C0138a c0138a = new a.C0138a();
        nativeGetBookmarkTitle(j10);
        nativeGetBookmarkDestIndex(aVar.f8611a, j10);
        list.add(c0138a);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(aVar.f8611a, Long.valueOf(j10));
        if (nativeGetFirstChildBookmark != null) {
            l(c0138a.a(), aVar, nativeGetFirstChildBookmark.longValue());
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(aVar.f8611a, j10);
        if (nativeGetSiblingBookmark != null) {
            l(list, aVar, nativeGetSiblingBookmark.longValue());
        }
    }

    private native void nativeCloseDocument(long j10);

    private native void nativeClosePage(long j10);

    private native long nativeGetBookmarkDestIndex(long j10, long j11);

    private native String nativeGetBookmarkTitle(long j10);

    private native Integer nativeGetDestPageIndex(long j10, long j11);

    private native String nativeGetDocumentMetaText(long j10, String str);

    private native Long nativeGetFirstChildBookmark(long j10, Long l10);

    private native RectF nativeGetLinkRect(long j10);

    private native String nativeGetLinkURI(long j10, long j11);

    private native int nativeGetPageCount(long j10);

    private native long[] nativeGetPageLinks(long j10);

    private native Size nativeGetPageSizeByIndex(long j10, int i10, int i11);

    private native Long nativeGetSiblingBookmark(long j10, long j11);

    private native long nativeLoadPage(long j10, int i10);

    private native long nativeOpenDocument(int i10, String str);

    private native Point nativePageCoordsToDevice(long j10, int i10, int i11, int i12, int i13, int i14, double d10, double d11);

    private native void nativeRenderPageBitmap(long j10, Bitmap bitmap, int i10, int i11, int i12, int i13, int i14, boolean z10);

    public void a(a aVar) {
        synchronized (f8608c) {
            Iterator<Integer> it = aVar.f8613c.keySet().iterator();
            while (it.hasNext()) {
                nativeClosePage(aVar.f8613c.get(it.next()).longValue());
            }
            aVar.f8613c.clear();
            nativeCloseDocument(aVar.f8611a);
            ParcelFileDescriptor parcelFileDescriptor = aVar.f8612b;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException unused) {
                }
                aVar.f8612b = null;
            }
        }
    }

    public a.c b(a aVar) {
        a.c cVar;
        synchronized (f8608c) {
            cVar = new a.c();
            nativeGetDocumentMetaText(aVar.f8611a, "Title");
            nativeGetDocumentMetaText(aVar.f8611a, "Author");
            nativeGetDocumentMetaText(aVar.f8611a, "Subject");
            nativeGetDocumentMetaText(aVar.f8611a, "Keywords");
            nativeGetDocumentMetaText(aVar.f8611a, "Creator");
            nativeGetDocumentMetaText(aVar.f8611a, "Producer");
            nativeGetDocumentMetaText(aVar.f8611a, "CreationDate");
            nativeGetDocumentMetaText(aVar.f8611a, "ModDate");
        }
        return cVar;
    }

    public int d(a aVar) {
        int nativeGetPageCount;
        synchronized (f8608c) {
            nativeGetPageCount = nativeGetPageCount(aVar.f8611a);
        }
        return nativeGetPageCount;
    }

    public List<a.b> e(a aVar, int i10) {
        ArrayList arrayList;
        synchronized (f8608c) {
            arrayList = new ArrayList();
            for (long j10 : nativeGetPageLinks(aVar.f8613c.get(Integer.valueOf(i10)).longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(aVar.f8611a, j10);
                String nativeGetLinkURI = nativeGetLinkURI(aVar.f8611a, j10);
                RectF nativeGetLinkRect = nativeGetLinkRect(j10);
                if (nativeGetLinkRect != null && (nativeGetDestPageIndex != null || nativeGetLinkURI != null)) {
                    arrayList.add(new a.b(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
        }
        return arrayList;
    }

    public Size f(a aVar, int i10) {
        Size nativeGetPageSizeByIndex;
        synchronized (f8608c) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(aVar.f8611a, i10, this.f8610a);
        }
        return nativeGetPageSizeByIndex;
    }

    public List<a.C0138a> g(a aVar) {
        ArrayList arrayList;
        synchronized (f8608c) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(aVar.f8611a, null);
            if (nativeGetFirstChildBookmark != null) {
                l(arrayList, aVar, nativeGetFirstChildBookmark.longValue());
            }
        }
        return arrayList;
    }

    public Point h(a aVar, int i10, int i11, int i12, int i13, int i14, int i15, double d10, double d11) {
        return nativePageCoordsToDevice(aVar.f8613c.get(Integer.valueOf(i10)).longValue(), i11, i12, i13, i14, i15, d10, d11);
    }

    public RectF i(a aVar, int i10, int i11, int i12, int i13, int i14, int i15, RectF rectF) {
        Point h10 = h(aVar, i10, i11, i12, i13, i14, i15, rectF.left, rectF.top);
        Point h11 = h(aVar, i10, i11, i12, i13, i14, i15, rectF.right, rectF.bottom);
        return new RectF(h10.x, h10.y, h11.x, h11.y);
    }

    public a j(ParcelFileDescriptor parcelFileDescriptor, String str) {
        a aVar = new a();
        aVar.f8612b = parcelFileDescriptor;
        synchronized (f8608c) {
            aVar.f8611a = nativeOpenDocument(c(parcelFileDescriptor), str);
        }
        return aVar;
    }

    public long k(a aVar, int i10) {
        long nativeLoadPage;
        synchronized (f8608c) {
            nativeLoadPage = nativeLoadPage(aVar.f8611a, i10);
            aVar.f8613c.put(Integer.valueOf(i10), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    public void m(a aVar, Bitmap bitmap, int i10, int i11, int i12, int i13, int i14, boolean z10) {
        synchronized (f8608c) {
            try {
                try {
                    try {
                        nativeRenderPageBitmap(aVar.f8613c.get(Integer.valueOf(i10)).longValue(), bitmap, this.f8610a, i11, i12, i13, i14, z10);
                    } catch (NullPointerException e10) {
                        e = e10;
                        e.printStackTrace();
                    } catch (Exception e11) {
                        e = e11;
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (NullPointerException e12) {
                e = e12;
            } catch (Exception e13) {
                e = e13;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }
}
