package w6;

import android.content.Context;
import com.groboot.mdaemergency.models.CoronaBarcodePatient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class n0 {

    /* renamed from: b, reason: collision with root package name */
    public static n0 f15227b;

    /* renamed from: a, reason: collision with root package name */
    Context f15228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15229f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f15230g;

        a(String str, d dVar) {
            this.f15229f = str;
            this.f15230g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            String message;
            try {
                try {
                    b7.a aVar = new b7.a(n0.this.h());
                    aVar.c();
                    f7.d a10 = f7.e.a(aVar);
                    File fileStreamPath = n0.this.f15228a.getFileStreamPath("TEST.LBL");
                    n0 n0Var = n0.this;
                    n0Var.c(n0Var.f15228a, "TEST.LBL", this.f15229f);
                    a10.b(fileStreamPath.getAbsolutePath());
                    aVar.close();
                    this.f15230g.b();
                } catch (f7.f e10) {
                    dVar = this.f15230g;
                    message = e10.getMessage();
                    dVar.a(message);
                }
            } catch (b7.e e11) {
                dVar = this.f15230g;
                message = e11.getMessage();
                dVar.a(message);
            } catch (IOException e12) {
                dVar = this.f15230g;
                message = e12.getMessage();
                dVar.a(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f15232f;

        b(String str) {
            this.f15232f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b7.a aVar = new b7.a(n0.this.h());
            try {
                aVar.c();
                f7.e.a(aVar).a(this.f15232f);
                aVar.close();
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b7.a aVar = new b7.a(n0.this.h());
            try {
                aVar.c();
                f7.d a10 = f7.e.a(aVar);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(n0.this.f15228a.getAssets().open("tt0003m_.ZPL")));
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("send: ");
                        sb3.append(sb2.toString());
                        a10.a(sb2.toString());
                        aVar.close();
                        return;
                    }
                    sb2.append(readLine);
                    sb2.append('\n');
                }
            } catch (b7.e | f7.f | IOException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(String str);

        void b();
    }

    private n0(Context context) {
        this.f15228a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, String str2) {
        FileOutputStream openFileOutput = context.openFileOutput(str, 0);
        openFileOutput.write(str2.getBytes());
        openFileOutput.flush();
        openFileOutput.close();
    }

    private static String d(Date date, String str) {
        return date == null ? "" : new SimpleDateFormat(str, Locale.ENGLISH).format(date);
    }

    public static n0 e() {
        return f15227b;
    }

    public static n0 f(Context context) {
        if (f15227b == null) {
            f15227b = new n0(context);
        }
        return f15227b;
    }

    private StringBuilder g(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("^FO");
        int i12 = i10 + 6;
        sb3.append(i12);
        sb3.append(",");
        sb3.append(i11 + 22);
        sb3.append("^A7N,26,26 ^FB290,0,0,R,0^FDדוד ןגמ^FS");
        sb2.append(sb3.toString());
        sb2.append("^FO" + i12 + "," + (i11 + 48) + "^A7N,26,26 ^FB290,0,0,R,0^FDםודא^FS");
        sb2.append("^FO" + i12 + "," + (i11 + 75) + "^A7N,26,26 ^FB290,0,0,R,0^FDלארשיב^FS");
        sb2.append("^FO" + i12 + "," + (i11 + 24) + "^A7N,18,18 ^FDMAGEN^FS");
        sb2.append("^FO" + i12 + "," + (i11 + 42) + "^A7N,18,18 ^FDDAVID^FS");
        sb2.append("^FO" + i12 + "," + (i11 + 60) + "^A7N,18,18 ^FDADOM^FS");
        sb2.append("^FO" + i12 + "," + (i11 + 78) + "^A7N,18,18 ^FDIN ISRAEL^FS");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("^FO");
        int i13 = i10 + 150;
        sb4.append(i13);
        sb4.append(",");
        int i14 = i11 + 26;
        sb4.append(i14);
        sb4.append("^GD50,94,6,B,R^FS");
        sb2.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("^FO");
        int i15 = i10 + 100;
        sb5.append(i15);
        sb5.append(",");
        sb5.append(i14);
        sb5.append("^GD50,94,6,B,L^FS");
        sb2.append(sb5.toString());
        sb2.append("^FO" + i13 + "," + i11 + "^GD50,94,6,B,L^FS");
        sb2.append("^FO" + i15 + "," + i11 + "^GD50,94,6,B,R^FS");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("^FO");
        int i16 = i10 + 102;
        sb6.append(i16);
        sb6.append(",");
        sb6.append(i14);
        sb6.append("^GB97,6,6^FS");
        sb2.append(sb6.toString());
        sb2.append("^FO" + i16 + "," + (i11 + 88) + "^GB97,6,6^FS");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        return g5.b.i(this.f15228a).h();
    }

    private String k(CoronaBarcodePatient coronaBarcodePatient, int i10, int i11, int i12, boolean z10) {
        StringBuilder sb2;
        String str;
        String str2 = coronaBarcodePatient.sex.equals("נ") ? "נקבה" : coronaBarcodePatient.sex.equals("ז") ? "זכר" : "לא מוגדר";
        int i13 = i11 * 400;
        int i14 = i12 + ((i10 - 1) * 190);
        StringBuilder sb3 = new StringBuilder();
        if (z10) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("^FO");
            int i15 = i13 + 10;
            sb4.append(i15);
            sb4.append(",");
            int i16 = i14 + 10;
            sb4.append(i16);
            sb4.append(" ^A7N,26,26 ^FB395,0,0,R,0^FD:ןימ^FS");
            sb3.append(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("^FO");
            sb5.append(i15);
            sb5.append(",");
            int i17 = i14 + 14;
            sb5.append(i17);
            sb5.append(" ^A7N,20,20 ^FB330,0,0,R,0^FD");
            sb5.append(t(str2));
            sb5.append("^FS");
            sb3.append(sb5.toString());
            sb3.append("^FO" + i15 + "," + i16 + " ^A7N,26,26 ^FB235,0,0,R,0^FD:ח''פוק^FS");
            sb2 = new StringBuilder();
            sb2.append("^FO");
            sb2.append(i15);
            sb2.append(",");
            sb2.append(i17);
            sb2.append(" ^A7N,20,20 ^FB165,0,0,R,0^FD");
            str = coronaBarcodePatient.hmoName;
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("^FO");
            int i18 = i13 + 10;
            sb6.append(i18);
            sb6.append(",");
            int i19 = i14 + 10;
            sb6.append(i19);
            sb6.append(" ^A7N,26,26 ^FB395,0,0,R,0^FD:תוהז .ת^FS");
            sb3.append(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("^FO");
            sb7.append(i18);
            sb7.append(",");
            int i20 = i14 + 14;
            sb7.append(i20);
            sb7.append(" ^A7N,20,20 ^FB300,0,0,R,0^FD");
            sb7.append(coronaBarcodePatient.IdNum);
            sb7.append("^FS");
            sb3.append(sb7.toString());
            sb3.append("^FO" + i18 + "," + i19 + " ^A7N,26,26 ^FB160,0,0,R,0^FD:ל.ת^FS");
            sb3.append("^FO" + i18 + "," + i20 + " ^A7N,20,20 ^FB105,0,0,R,0^FD" + coronaBarcodePatient.BirthDate + "^FS");
            StringBuilder sb8 = new StringBuilder();
            sb8.append("^FO");
            sb8.append(i18);
            sb8.append(",");
            int i21 = i14 + 40;
            sb8.append(i21);
            sb8.append(" ^A7N,26,26 ^FB395,0,0,R,0^FD:ח''פוק^FS");
            sb3.append(sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("^FO");
            sb9.append(i18);
            sb9.append(",");
            int i22 = i14 + 44;
            sb9.append(i22);
            sb9.append(" ^A7N,20,20 ^FB300,0,0,R,0^FD");
            sb9.append(t(coronaBarcodePatient.hmoName));
            sb9.append("^FS");
            sb3.append(sb9.toString());
            sb3.append("^FO" + i18 + "," + i21 + " ^A7N,26,26 ^FB160,0,0,R,0^FD:ןימ^FS");
            sb3.append("^FO" + i18 + "," + i22 + " ^A7N,20,20 ^FB80,0,0,R,0^FD" + t(str2) + "^FS");
            StringBuilder sb10 = new StringBuilder();
            sb10.append("^FO");
            sb10.append(i18);
            sb10.append(",");
            sb10.append(i14 + 70);
            sb10.append(" ^A7N,26,26 ^FB395,0,0,R,0^FD:אלמ םש^FS");
            sb3.append(sb10.toString());
            sb2 = new StringBuilder();
            sb2.append("^FO");
            sb2.append(i18);
            sb2.append(",");
            sb2.append(i14 + 72);
            sb2.append(" ^A7N,24,24 ^FB300,0,0,R,0^FD");
            str = coronaBarcodePatient.getFullName();
        }
        sb2.append(t(str));
        sb2.append("^FS");
        sb3.append(sb2.toString());
        int i23 = i13 + 5;
        StringBuilder sb11 = new StringBuilder();
        sb11.append("^FO");
        int i24 = i23 + 10;
        sb11.append(i24);
        sb11.append(",");
        sb11.append(i14 + 145);
        sb11.append(" ^A7N,12,12 ^FB370,0,0,R,0^FDםודא דוד ןגמ^FS");
        sb3.append(sb11.toString());
        sb3.append("^FO" + i24 + "," + (i14 + 157) + " ^A7N,12,12 ^FB360,0,0,R,0^FDלארשיב^FS");
        StringBuilder sb12 = new StringBuilder();
        sb12.append("^FO");
        int i25 = i23 + 346;
        sb12.append(i25);
        sb12.append(",");
        int i26 = i14 + 115;
        sb12.append(i26);
        sb12.append("^GD16,30,2,B,R^FS");
        sb3.append(sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append("^FO");
        int i27 = i23 + 330;
        sb13.append(i27);
        sb13.append(",");
        sb13.append(i26);
        sb13.append("^GD16,30,2,B,L^FS");
        sb3.append(sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append("^FO");
        sb14.append(i25);
        sb14.append(",");
        int i28 = i14 + 105;
        sb14.append(i28);
        sb14.append("^GD16,30,2,B,L^FS");
        sb3.append(sb14.toString());
        sb3.append("^FO" + i27 + "," + i28 + "^GD16,30,2,B,R^FS");
        sb3.append("^FO" + i27 + "," + i26 + "^GB32,2,2^FS");
        sb3.append("^FO" + i27 + "," + (i14 + 135) + "^GB32,2,2^FS");
        sb3.append("^BY2,1,50");
        sb3.append("^FO" + (i23 + 30) + "," + (i14 + 100) + "^BC^FD" + coronaBarcodePatient.barcode + "^FS");
        return sb3.toString();
    }

    private boolean l(String str) {
        if (o(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = charArray[i10];
            if (c10 >= 1488 && c10 <= 1514) {
                return true;
            }
        }
        return false;
    }

    private boolean n(char c10) {
        return c10 >= 1488 && c10 <= 1514;
    }

    private boolean o(String str) {
        return str == null || str.length() == 0;
    }

    private void p(StringBuilder sb2, String str) {
        String[] split = sb2.toString().split("FS");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("--------------------------------------------");
        sb3.append(str);
        sb3.append("--------------------------------------------");
        int i10 = 0;
        while (i10 < split.length) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(split[i10]);
            i10++;
            sb4.append(i10 < split.length ? "FS" : "");
        }
    }

    private String t(String str) {
        StringBuilder sb2;
        StringBuilder sb3;
        if (o(str) || !l(str)) {
            return str;
        }
        try {
            String str2 = "";
            for (String str3 : str.split(" ")) {
                if (o(str3)) {
                    sb3 = new StringBuilder();
                    sb3.append(" ");
                } else {
                    if (n(str3.toCharArray()[0])) {
                        sb2 = new StringBuilder();
                        sb2.append(u(str3));
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(str3);
                    }
                    sb2.append(str2);
                    str2 = sb2.toString();
                    sb3 = new StringBuilder();
                    sb3.append(" ");
                }
                sb3.append(str2);
                str2 = sb3.toString();
            }
            return str2;
        } catch (Exception unused) {
            return u(str);
        }
    }

    private String u(String str) {
        if (o(str)) {
            return str;
        }
        String str2 = "";
        for (char c10 : str.toCharArray()) {
            str2 = c10 + str2;
        }
        return z(str2);
    }

    private String z(String str) {
        return o(str) ? str : str.replace(")", "@@)@@").replace("(", ")").replace("@@)@@", "(");
    }

    public String i(CoronaBarcodePatient coronaBarcodePatient, int i10) {
        String str = coronaBarcodePatient.sex.equals("נ") ? "נקבה" : coronaBarcodePatient.sex.equals("ז") ? "זכר" : "לא מוגדר";
        String c02 = l0.c0(new Date(), l0.f15194g);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("^XA^MD16");
        sb2.append("^CI28");
        sb2.append("^CW7,E:TT0003M_.TTF^FS");
        sb2.append("^FO10," + (i10 + 40) + " ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:ךיראתב קפוה^FS");
        sb2.append("^FO10," + (i10 + 44) + " ^A7N, 28, 28 ^FB600, 0, 0,R, 0^FD" + c02 + "^FS");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("^FO10,");
        sb3.append(i10 + 75);
        sb3.append(" ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:רתא^FS");
        sb2.append(sb3.toString());
        sb2.append("^FO10," + (i10 + 79) + " ^A7N, 28, 28 ^FB710, 0, 0,R, 0^FD" + t(coronaBarcodePatient.siteDescription) + "^FS");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("^FO0,");
        sb4.append(i10 + 122);
        sb4.append("^GB820, 4, 4^FS");
        sb2.append(sb4.toString());
        sb2.append("^BY3, 3, 90");
        sb2.append("^FO40," + (i10 + 280) + " ^BC^FD" + coronaBarcodePatient.barcode + "^FS");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("^FO10,");
        sb5.append(i10 + 162);
        sb5.append(" ^A7N, 26, 26 ^FB366, 0, 0,R, 0^FDדוד ןגמ^FS");
        sb2.append(sb5.toString());
        sb2.append("^FO10," + (i10 + 188) + " ^A7N, 26, 26 ^FB366, 0, 0,R, 0^FDםודא^FS");
        sb2.append("^FO10," + (i10 + 215) + " ^A7N, 26, 26 ^FB366, 0, 0,R, 0^FDלארשיב^FS");
        sb2.append("^FO96," + (i10 + 164) + " ^A7N, 18, 18 ^FDMAGEN^FS");
        sb2.append("^FO96," + (i10 + 182) + " ^A7N, 18, 18 ^FDDAVID^FS");
        sb2.append("^FO96," + (i10 + 200) + " ^A7N, 18, 18 ^FDADOM^FS");
        sb2.append("^FO96," + (i10 + 218) + " ^A7N, 18, 18 ^FDIN ISRAEL^FS");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("^FO238,");
        int i11 = i10 + 166;
        sb6.append(i11);
        sb6.append(" ^GD50, 94, 6, B,R^FS");
        sb2.append(sb6.toString());
        sb2.append("^FO188," + i11 + " ^GD50, 94, 6, B,L^FS");
        StringBuilder sb7 = new StringBuilder();
        sb7.append("^FO238,");
        int i12 = i10 + 140;
        sb7.append(i12);
        sb7.append(" ^GD50, 94, 6, B,L^FS");
        sb2.append(sb7.toString());
        sb2.append("^FO188," + i12 + " ^GD50, 94, 6, B,R^FS");
        sb2.append("^FO190," + i11 + " ^GB97, 6, 6^FS");
        sb2.append("^FO190," + (i10 + 228) + " ^GB97, 6, 6^FS");
        sb2.append("^FO10," + (i10 + 150) + " ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:תוהז .ת^FS");
        sb2.append("^FO10," + (i10 + 154) + " ^A7N, 28, 28 ^FB620, 0, 0,R, 0^FD" + coronaBarcodePatient.IdNum + "^FS");
        StringBuilder sb8 = new StringBuilder();
        sb8.append("^FO10,");
        sb8.append(i10 + 185);
        sb8.append(" ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:הדיל .ת^FS");
        sb2.append(sb8.toString());
        sb2.append("^FO10," + (i10 + 189) + " ^A7N, 28, 28 ^FB620, 0, 0,R, 0^FD" + coronaBarcodePatient.BirthDate + "^FS");
        StringBuilder sb9 = new StringBuilder();
        sb9.append("^FO10,");
        sb9.append(i10 + 220);
        sb9.append(" ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:יטרפ םש^FS");
        sb2.append(sb9.toString());
        sb2.append("^FO10," + (i10 + 224) + " ^A7N, 28, 28 ^FB620, 0, 0,R, 0^FD" + t(coronaBarcodePatient.PatientFirstName) + "^FS");
        StringBuilder sb10 = new StringBuilder();
        sb10.append("^FO10,");
        sb10.append(i10 + 255);
        sb10.append(" ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:החפשמ םש^FS");
        sb2.append(sb10.toString());
        sb2.append("^FO10," + (i10 + 259) + " ^A7N, 28, 28 ^FB620, 0, 0,R, 0^FD" + t(coronaBarcodePatient.PatientLastName) + "^FS");
        StringBuilder sb11 = new StringBuilder();
        sb11.append("^FO10,");
        sb11.append(i10 + 290);
        sb11.append(" ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:ןופלט^FS");
        sb2.append(sb11.toString());
        sb2.append("^FO10," + (i10 + 294) + " ^A7N, 28, 28 ^FB620, 0, 0,R, 0^FD" + coronaBarcodePatient.phoneNumber + "^FS");
        StringBuilder sb12 = new StringBuilder();
        sb12.append("^FO10,");
        sb12.append(i10 + 325);
        sb12.append(" ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:םילוח תפוק^FS");
        sb2.append(sb12.toString());
        sb2.append("^FO10," + (i10 + 329) + " ^A7N, 28, 28 ^FB620, 0, 0,R, 0^FD" + t(coronaBarcodePatient.hmoName) + "^FS");
        StringBuilder sb13 = new StringBuilder();
        sb13.append("^FO10,");
        sb13.append(i10 + 360);
        sb13.append(" ^A7N, 32, 32 ^FB788, 0, 0,R, 0^FD:ןימ^FS");
        sb2.append(sb13.toString());
        sb2.append("^FO10," + (i10 + 364) + " ^A7N, 28, 28 ^FB620, 0, 0,R, 0^FD" + t(str) + "^FS");
        sb2.append("^XZ");
        return sb2.toString();
    }

    public String j(CoronaBarcodePatient coronaBarcodePatient) {
        String c02 = l0.c0(new Date(), l0.f15194g);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("^XA^LRN");
        sb2.append("^CI28");
        sb2.append("^CW7,E:TT0003M_.TTF^FS");
        sb2.append("^FO10,40 ^A7N,32,32 ^FB788,0,0,R,0^FD:ךיראתב קפוה^FS");
        sb2.append("^FO10,44 ^A7N,28,28 ^FB600,0,0,R,0^FD" + c02 + "^FS");
        sb2.append("^FO10,75 ^A7N,32,32 ^FB788,0,0,R,0^FD:רתא^FS");
        sb2.append("^FO10,79 ^A7N,28,28 ^FB710,0,0,R,0^FD" + t(coronaBarcodePatient.siteDescription) + "^FS");
        sb2.append("^FO10,40 ^A7N,32,32 ^FB260,0,0,R,0^FD:םילוח תפוק^FS");
        sb2.append("^FO10,44 ^A7N,28,28 ^FB100,0,0,R,0^FD" + t(coronaBarcodePatient.hmoName) + "^FS");
        sb2.append("^FO0,122^GB820,4,4^FS");
        sb2.append("^BY3,3,90");
        sb2.append("^FO215,280^BC^FD" + coronaBarcodePatient.barcode + "^FS");
        sb2.append("^FO10,162 ^A7N,26,26 ^FB536,0,0,R,0^FDדוד ןגמ^FS");
        sb2.append("^FO10,188 ^A7N,26,26 ^FB536,0,0,R,0^FDםודא^FS");
        sb2.append("^FO10,215 ^A7N,26,26 ^FB536,0,0,R,0^FDלארשיב^FS");
        sb2.append("^FO266,164 ^A7N,18,18 ^FDMAGEN^FS");
        sb2.append("^FO266,182 ^A7N,18,18 ^FDDAVID^FS");
        sb2.append("^FO266,200 ^A7N,18,18 ^FDADOM^FS");
        sb2.append("^FO266,218 ^A7N,18,18 ^FDIN ISRAEL^FS");
        sb2.append("^FO408,166^GD50,94,6,B,R^FS");
        sb2.append("^FO358,166^GD50,94,6,B,L^FS");
        sb2.append("^FO408,140^GD50,94,6,B,L^FS");
        sb2.append("^FO358,140^GD50,94,6,B,R^FS");
        sb2.append("^FO360,166^GB97,6,6^FS");
        sb2.append("^FO360,228^GB97,6,6^FS");
        sb2.append("^XZ");
        return sb2.toString();
    }

    public boolean m() {
        return !l0.l0(h());
    }

    public void q(CoronaBarcodePatient coronaBarcodePatient, boolean z10, d dVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l0.u0(i(coronaBarcodePatient, z10 ? 0 : 750), "^XZ"));
        int i10 = 0;
        while (i10 < 8) {
            sb2.append(k(coronaBarcodePatient, (i10 / 2) + 1, i10 % 2, z10 ? 430 : 40, i10 == 7));
            i10++;
        }
        sb2.append("^XZ");
        x(sb2.toString(), dVar);
    }

    public void r(CoronaBarcodePatient coronaBarcodePatient, d dVar) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 7; i10++) {
            sb2.append(i(coronaBarcodePatient, 0));
        }
        sb2.append(j(coronaBarcodePatient));
        x(sb2.toString(), dVar);
    }

    public void s(int i10, d dVar) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String d10 = d(new Date(), "dd/MM/yyyy HH:mm:ss");
        sb2.append("^XA^MD16");
        sb2.append("^CI28");
        sb2.append("^CW7,E:TT0003M_.TTF^FS");
        if (i10 != 0) {
            str = "^FO40,40^GB750,360,4^FS";
            if (i10 != 1) {
                int i11 = 0;
                if (i10 == 2) {
                    sb2.append((CharSequence) g(250, 160));
                    sb2.append("^FO40,40^GB750,360,4^FS");
                    while (i11 < 8) {
                        sb2.append((CharSequence) g(((i11 % 2) * 400) + 60, ((((i11 / 2) + 1) - 1) * 190) + 470));
                        i11++;
                    }
                } else if (i10 == 3) {
                    while (i11 < 8) {
                        sb2.append((CharSequence) g(((i11 % 2) * 400) + 60, ((((i11 / 2) + 1) - 1) * 190) + 60));
                        i11++;
                    }
                    sb2.append((CharSequence) g(250, 940));
                    str = "^FO40,820^GB750,360,4^FS";
                }
                sb2.append("^XZ");
                p(sb2, "printerType=" + i10);
                x(sb2.toString(), dVar);
            }
            sb2.append((CharSequence) g(250, 160));
        } else {
            sb2.append("^FO10,10^GB820,400,40^FS");
            sb2.append("^FO50,50 ^A7N,30,30 ^FD" + d10 + "^FS");
            sb2.append("^FO50,150 ^A7N,80,80 ^FDTEST PRINTER^FS");
            str = "^FO50,220 ^A7N,80,80 ^FD" + t("בדיקת מדפסת") + "^FS";
        }
        sb2.append(str);
        sb2.append("^XZ");
        p(sb2, "printerType=" + i10);
        x(sb2.toString(), dVar);
    }

    public void v(String str) {
        new Thread(new b(str)).start();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    public void w(int i10) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        switch (i10) {
            case 1:
                str = "~PH";
                sb2.append(str);
                sb2.append("\n");
                break;
            case 2:
                str = "! U1 setvar \"device.languages\" \"zpl\"";
                sb2.append(str);
                sb2.append("\n");
                break;
            case 3:
                sb2.append("! U1 SPEED 5");
                sb2.append("\n");
                sb2.append("! U1 setvar \"print.tone\" \"0\"");
                sb2.append("\n");
                sb2.append("! U1 setvar \"media.type\" \"label\"");
                sb2.append("\n");
                str2 = "! U1 setvar \"media.sense_mode\" \"gap\"";
                sb2.append(str2);
                sb2.append("\n");
                sb2.append("! U1 setvar \"media.draft_mode\" \"off\"");
                sb2.append("\n");
                break;
            case 4:
                sb2.append("! U1 SPEED 5");
                sb2.append("\n");
                sb2.append("! U1 setvar \"print.tone\" \"0\"");
                sb2.append("\n");
                sb2.append("! U1 setvar \"media.type\" \"label\"");
                sb2.append("\n");
                str2 = "! U1 setvar \"media.sense_mode\" \"bar\"";
                sb2.append(str2);
                sb2.append("\n");
                sb2.append("! U1 setvar \"media.draft_mode\" \"off\"");
                sb2.append("\n");
                break;
            case 5:
                sb2.append("! U1 SPEED 5");
                sb2.append("\n");
                sb2.append("! U1 setvar \"print.tone\" \"0\"");
                sb2.append("\n");
                sb2.append("! U1 setvar \"media.type\" \"label\"");
                sb2.append("\n");
                str2 = "! U1 setvar \"media.sense_mode\" \"journal\"";
                sb2.append(str2);
                sb2.append("\n");
                sb2.append("! U1 setvar \"media.draft_mode\" \"off\"");
                sb2.append("\n");
                break;
            case 6:
                str = "~JC";
                sb2.append(str);
                sb2.append("\n");
                break;
            case 7:
                str = "!U1 do \"device.reset\" \"\"";
                sb2.append(str);
                sb2.append("\n");
                break;
        }
        v(sb2.toString());
    }

    public void x(String str, d dVar) {
        if (o(h())) {
            dVar.a("לא מוגדרת מדפסת");
        } else {
            new Thread(new a(str, dVar)).start();
        }
    }

    public void y() {
        new Thread(new c()).start();
    }
}
