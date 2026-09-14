package com.groboot.mdaemergency.ui.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import c6.g;
import il.org.mda.health.R;
import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/* loaded from: classes.dex */
public class a extends a6.a {
    boolean A0;
    ListView B0;
    String C0;
    String D0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.groboot.mdaemergency.ui.fragments.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0123a implements g.d {
        C0123a() {
        }

        @Override // c6.g.d
        public boolean a(c cVar) {
            return a.this.p2(cVar.t());
        }

        @Override // c6.g.d
        public void b(c cVar) {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(cVar.t()), singleton.getMimeTypeFromExtension(cVar.o().toLowerCase()));
            intent.setFlags(268435456);
            try {
                a.this.P1(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(a.this.A(), R.string.no_supported_app_on_this_device, 1).show();
            }
        }

        @Override // c6.g.d
        public void c(c cVar) {
            a.this.q2(cVar.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8120a;

        static {
            int[] iArr = new int[c.EnumC0124a.values().length];
            f8120a = iArr;
            try {
                iArr[c.EnumC0124a.directory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8120a[c.EnumC0124a.directoryUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8120a[c.EnumC0124a.image.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8120a[c.EnumC0124a.pdf.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8120a[c.EnumC0124a.video.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {

        /* renamed from: f, reason: collision with root package name */
        private String f8121f;

        /* renamed from: g, reason: collision with root package name */
        private String f8122g;

        /* renamed from: h, reason: collision with root package name */
        private String f8123h;

        /* renamed from: i, reason: collision with root package name */
        private String f8124i;

        /* renamed from: j, reason: collision with root package name */
        private EnumC0124a f8125j;

        /* renamed from: com.groboot.mdaemergency.ui.fragments.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0124a {
            directory,
            file,
            image,
            pdf,
            video,
            directoryUp
        }

        public c(String str, String str2, String str3, String str4, EnumC0124a enumC0124a) {
            this.f8121f = str;
            this.f8122g = str2;
            this.f8123h = str3;
            this.f8124i = str4;
            this.f8125j = enumC0124a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String o() {
            String[] split = t().split("\\.");
            return split.length > 1 ? split[split.length - 1] : "";
        }

        @Override // java.lang.Comparable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            String str = this.f8121f;
            if (str != null) {
                return str.toLowerCase().compareTo(cVar.r().toLowerCase());
            }
            throw new IllegalArgumentException();
        }

        public String l() {
            return this.f8122g;
        }

        public String n() {
            return this.f8123h;
        }

        public String r() {
            return this.f8121f;
        }

        public String s() {
            String[] split = r().split("\\.");
            String str = "";
            for (int i10 = 0; i10 < split.length - 1; i10++) {
                str = str + split[i10];
            }
            return str;
        }

        public String t() {
            return this.f8124i;
        }

        public Bitmap u() {
            if (w() == EnumC0124a.image) {
                return ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(t()), 120, 80);
            }
            if (w() == EnumC0124a.video) {
                return ThumbnailUtils.createVideoThumbnail(t(), 1);
            }
            return null;
        }

        public Integer v() {
            int i10 = b.f8120a[w().ordinal()];
            return Integer.valueOf((i10 == 1 || i10 == 2) ? R.drawable.directory_up_icon : i10 != 3 ? i10 != 4 ? i10 != 5 ? R.drawable.file_icon : R.drawable.video_icon : R.drawable.pdf_icon : R.drawable.image_icon);
        }

        public EnumC0124a w() {
            String o10;
            if (this.f8125j == EnumC0124a.file && (o10 = o()) != null) {
                String lowerCase = o10.toLowerCase();
                if (lowerCase.equals("png") || lowerCase.equals("jpg") || lowerCase.equals("jpeg") || lowerCase.equals("gif")) {
                    return EnumC0124a.image;
                }
                if (lowerCase.equals("pdf")) {
                    return EnumC0124a.pdf;
                }
                if (lowerCase.equals("mp4")) {
                    return EnumC0124a.video;
                }
            }
            return this.f8125j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p2(String str) {
        try {
            boolean delete = new File(str).delete();
            if (!delete) {
                Toast.makeText(A(), A().getString(R.string.operation_failed), 1).show();
            }
            return delete;
        } catch (Exception e10) {
            Toast.makeText(A(), e10.getMessage(), 1).show();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{e0(R.string.shared_file)});
        intent.putExtra("android.intent.extra.SUBJECT", "File Name");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
        P1(Intent.createChooser(intent, "Share File"));
    }

    private void t2() {
        u2(new File(this.C0));
    }

    private void u2(File file) {
        File[] listFiles = file.listFiles();
        a("Current Dir: " + file.getName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (File file2 : listFiles) {
                String format = DateFormat.getDateTimeInstance().format(new Date(file2.lastModified()));
                if (!file2.isDirectory()) {
                    arrayList2.add(new c(file2.getName(), v2(file2.length()), format, file2.getAbsolutePath(), c.EnumC0124a.file));
                }
            }
        } catch (Exception unused) {
        }
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        arrayList.addAll(arrayList2);
        this.B0.setAdapter((ListAdapter) new g(A(), R.layout.file_view, arrayList, new C0123a()));
    }

    public static String v2(long j10) {
        if (j10 <= 0) {
            return "0";
        }
        try {
            double d10 = j10;
            int log10 = (int) (Math.log10(d10) / Math.log10(1024.0d));
            return new DecimalFormat("#,##0.#").format(d10 / Math.pow(1024.0d, log10)) + " " + new String[]{"B", "kB", "MB", "GB", "TB"}[log10];
        } catch (Exception unused) {
            return j10 + " byte";
        }
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        this.A0 = false;
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.A0 = true;
        if (this.C0 != null) {
            t2();
        }
        String str = this.D0;
        if (str != null) {
            a(str);
        }
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_file_explorer);
        this.B0 = (ListView) k2(R.id.lv_files);
    }

    @Override // a6.a
    public void o2() {
    }

    public void w2(String str, String str2) {
        this.C0 = str2;
        this.D0 = str;
        if (this.A0) {
            t2();
            a(str);
        }
    }
}
