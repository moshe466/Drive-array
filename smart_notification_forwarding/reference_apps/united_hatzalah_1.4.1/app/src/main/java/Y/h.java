package Y;

import F0.AbstractC0008a;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: U, reason: collision with root package name */
    public static final e f2669U;

    /* renamed from: V, reason: collision with root package name */
    public static final e[][] f2670V;

    /* renamed from: W, reason: collision with root package name */
    public static final e[] f2671W;

    /* renamed from: X, reason: collision with root package name */
    public static final HashMap[] f2672X;

    /* renamed from: Y, reason: collision with root package name */
    public static final HashMap[] f2673Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final Set f2674Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final HashMap f2675a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final Charset f2676b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final byte[] f2677c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final byte[] f2678d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final Pattern f2679e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final Pattern f2680f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final Pattern f2681g0;

    /* renamed from: a, reason: collision with root package name */
    public final String f2688a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDescriptor f2689b;

    /* renamed from: c, reason: collision with root package name */
    public int f2690c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap[] f2691d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f2692e;

    /* renamed from: f, reason: collision with root package name */
    public ByteOrder f2693f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2694g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2695h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f2696j;

    /* renamed from: k, reason: collision with root package name */
    public int f2697k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f2698l;

    /* renamed from: m, reason: collision with root package name */
    public int f2699m;

    /* renamed from: n, reason: collision with root package name */
    public int f2700n;

    /* renamed from: o, reason: collision with root package name */
    public int f2701o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f2702q;

    /* renamed from: r, reason: collision with root package name */
    public d f2703r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2704s;

    /* renamed from: t, reason: collision with root package name */
    public static final boolean f2682t = Log.isLoggable("ExifInterface", 3);

    /* renamed from: u, reason: collision with root package name */
    public static final List f2683u = Arrays.asList(1, 6, 3, 8);

    /* renamed from: v, reason: collision with root package name */
    public static final List f2684v = Arrays.asList(2, 7, 4, 5);

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f2685w = {8, 8, 8};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f2686x = {8};
    public static final byte[] y = {-1, -40, -1};

    /* renamed from: z, reason: collision with root package name */
    public static final byte[] f2687z = {102, 116, 121, 112};

    /* renamed from: A, reason: collision with root package name */
    public static final byte[] f2649A = {109, 105, 102, 49};

    /* renamed from: B, reason: collision with root package name */
    public static final byte[] f2650B = {104, 101, 105, 99};

    /* renamed from: C, reason: collision with root package name */
    public static final byte[] f2651C = {97, 118, 105, 102};

    /* renamed from: D, reason: collision with root package name */
    public static final byte[] f2652D = {97, 118, 105, 115};

    /* renamed from: E, reason: collision with root package name */
    public static final byte[] f2653E = {79, 76, 89, 77, 80, 0};

    /* renamed from: F, reason: collision with root package name */
    public static final byte[] f2654F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: G, reason: collision with root package name */
    public static final byte[] f2655G = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: H, reason: collision with root package name */
    public static final byte[] f2656H = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);

    /* renamed from: I, reason: collision with root package name */
    public static final byte[] f2657I = {82, 73, 70, 70};

    /* renamed from: J, reason: collision with root package name */
    public static final byte[] f2658J = {87, 69, 66, 80};

    /* renamed from: K, reason: collision with root package name */
    public static final byte[] f2659K = {69, 88, 73, 70};

    /* renamed from: L, reason: collision with root package name */
    public static final byte[] f2660L = {-99, 1, 42};

    /* renamed from: M, reason: collision with root package name */
    public static final byte[] f2661M = "VP8X".getBytes(Charset.defaultCharset());

    /* renamed from: N, reason: collision with root package name */
    public static final byte[] f2662N = "VP8L".getBytes(Charset.defaultCharset());

    /* renamed from: O, reason: collision with root package name */
    public static final byte[] f2663O = "VP8 ".getBytes(Charset.defaultCharset());

    /* renamed from: P, reason: collision with root package name */
    public static final byte[] f2664P = "ANIM".getBytes(Charset.defaultCharset());

    /* renamed from: Q, reason: collision with root package name */
    public static final byte[] f2665Q = "ANMF".getBytes(Charset.defaultCharset());

    /* renamed from: R, reason: collision with root package name */
    public static final String[] f2666R = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: S, reason: collision with root package name */
    public static final int[] f2667S = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: T, reason: collision with root package name */
    public static final byte[] f2668T = {65, 83, 67, 73, 73, 0, 0, 0};

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(UserVerificationMethods.USER_VERIFY_HANDPRINT, 3, 4, "ImageWidth"), new e(257, 3, 4, "ImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e(40962, 3, 4, "PixelXDimension"), new e(40963, 3, 4, "PixelYDimension"), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e(2, 5, 10, "GPSLatitude"), new e("GPSLongitudeRef", 3, 2), new e(4, 5, 10, "GPSLongitude"), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(UserVerificationMethods.USER_VERIFY_HANDPRINT, 3, 4, "ThumbnailImageWidth"), new e(257, 3, 4, "ThumbnailImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        f2669U = new e("StripOffsets", 273, 3);
        f2670V = new e[][]{eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, new e[]{new e("ThumbnailImage", UserVerificationMethods.USER_VERIFY_HANDPRINT, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)}, new e[]{new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)}, new e[]{new e("AspectFrame", 4371, 3)}, new e[]{new e("ColorSpace", 55, 3)}};
        f2671W = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f2672X = new HashMap[10];
        f2673Y = new HashMap[10];
        f2674Z = Collections.unmodifiableSet(new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance")));
        f2675a0 = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        f2676b0 = forName;
        f2677c0 = "Exif\u0000\u0000".getBytes(forName);
        f2678d0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            e[][] eVarArr6 = f2670V;
            if (i < eVarArr6.length) {
                f2672X[i] = new HashMap();
                f2673Y[i] = new HashMap();
                for (e eVar : eVarArr6[i]) {
                    f2672X[i].put(Integer.valueOf(eVar.f2643a), eVar);
                    f2673Y[i].put(eVar.f2644b, eVar);
                }
                i++;
            } else {
                HashMap hashMap = f2675a0;
                e[] eVarArr7 = f2671W;
                hashMap.put(Integer.valueOf(eVarArr7[0].f2643a), 5);
                hashMap.put(Integer.valueOf(eVarArr7[1].f2643a), 1);
                hashMap.put(Integer.valueOf(eVarArr7[2].f2643a), 2);
                hashMap.put(Integer.valueOf(eVarArr7[3].f2643a), 3);
                hashMap.put(Integer.valueOf(eVarArr7[4].f2643a), 7);
                hashMap.put(Integer.valueOf(eVarArr7[5].f2643a), 8);
                Pattern.compile(".*[1-9].*");
                f2679e0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f2680f0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f2681g0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public h(String str) {
        e[][] eVarArr = f2670V;
        this.f2691d = new HashMap[eVarArr.length];
        this.f2692e = new HashSet(eVarArr.length);
        this.f2693f = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            this.f2688a = str;
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        Os.lseek(fileInputStream2.getFD(), 0L, OsConstants.SEEK_CUR);
                        this.f2689b = fileInputStream2.getFD();
                    } catch (Exception unused) {
                        this.f2689b = null;
                    }
                    p(fileInputStream2);
                    m3.b.e(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    m3.b.e(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    public static Pair m(String str) {
        int intValue;
        int i;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair m4 = m(split[0]);
            if (((Integer) m4.first).intValue() == 2) {
                return m4;
            }
            for (int i3 = 1; i3 < split.length; i3++) {
                Pair m5 = m(split[i3]);
                if (!((Integer) m5.first).equals(m4.first) && !((Integer) m5.second).equals(m4.first)) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) m4.first).intValue();
                }
                if (((Integer) m4.second).intValue() != -1 && (((Integer) m5.first).equals(m4.second) || ((Integer) m5.second).equals(m4.second))) {
                    i = ((Integer) m4.second).intValue();
                } else {
                    i = -1;
                }
                if (intValue == -1 && i == -1) {
                    return new Pair(2, -1);
                }
                if (intValue == -1) {
                    m4 = new Pair(Integer.valueOf(i), -1);
                } else if (i == -1) {
                    m4 = new Pair(Integer.valueOf(intValue), -1);
                }
            }
            return m4;
        }
        if (str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            String[] split2 = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                            return new Pair(10, 5);
                        }
                        return new Pair(5, -1);
                    }
                    return new Pair(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair(2, -1);
        }
        try {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong >= 0 && parseLong <= 65535) {
                    return new Pair(3, 4);
                }
                if (parseLong < 0) {
                    return new Pair(9, -1);
                }
                return new Pair(4, -1);
            } catch (NumberFormatException unused2) {
                return new Pair(2, -1);
            }
        } catch (NumberFormatException unused3) {
            Double.parseDouble(str);
            return new Pair(12, -1);
        }
    }

    public static ByteOrder s(b bVar) {
        short readShort = bVar.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    public final void A(b bVar) {
        d dVar;
        HashMap hashMap = this.f2691d[4];
        d dVar2 = (d) hashMap.get("Compression");
        if (dVar2 != null) {
            int i = dVar2.i(this.f2693f);
            this.f2699m = i;
            if (i != 1) {
                if (i != 6) {
                    if (i != 7) {
                        return;
                    }
                } else {
                    n(bVar, hashMap);
                    return;
                }
            }
            d dVar3 = (d) hashMap.get("BitsPerSample");
            if (dVar3 != null) {
                int[] iArr = (int[]) dVar3.k(this.f2693f);
                int[] iArr2 = f2685w;
                if (!Arrays.equals(iArr2, iArr)) {
                    if (this.f2690c == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null) {
                        int i3 = dVar.i(this.f2693f);
                        if ((i3 != 1 || !Arrays.equals(iArr, f2686x)) && (i3 != 6 || !Arrays.equals(iArr, iArr2))) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                d dVar4 = (d) hashMap.get("StripOffsets");
                d dVar5 = (d) hashMap.get("StripByteCounts");
                if (dVar4 != null && dVar5 != null) {
                    long[] f4 = m3.b.f(dVar4.k(this.f2693f));
                    long[] f5 = m3.b.f(dVar5.k(this.f2693f));
                    if (f4 != null && f4.length != 0 && f5 != null && f5.length != 0 && f4.length == f5.length) {
                        long j2 = 0;
                        for (long j3 : f5) {
                            j2 += j3;
                        }
                        int i4 = (int) j2;
                        byte[] bArr = new byte[i4];
                        this.i = true;
                        this.f2695h = true;
                        this.f2694g = true;
                        int i5 = 0;
                        int i6 = 0;
                        for (int i7 = 0; i7 < f4.length; i7++) {
                            int i8 = (int) f4[i7];
                            int i9 = (int) f5[i7];
                            if (i7 < f4.length - 1 && i8 + i9 != f4[i7 + 1]) {
                                this.i = false;
                            }
                            int i10 = i8 - i5;
                            if (i10 >= 0) {
                                try {
                                    bVar.a(i10);
                                    int i11 = i5 + i10;
                                    byte[] bArr2 = new byte[i9];
                                    bVar.readFully(bArr2);
                                    i5 = i11 + i9;
                                    System.arraycopy(bArr2, 0, bArr, i6, i9);
                                    i6 += i9;
                                } catch (EOFException unused) {
                                    return;
                                }
                            }
                            return;
                        }
                        this.f2698l = bArr;
                        if (this.i) {
                            this.f2696j = (int) f4[0];
                            this.f2697k = i4;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.f2699m = 6;
        n(bVar, hashMap);
    }

    public final void B(int i, int i3) {
        HashMap[] hashMapArr = this.f2691d;
        if (!hashMapArr[i].isEmpty() && !hashMapArr[i3].isEmpty()) {
            d dVar = (d) hashMapArr[i].get("ImageLength");
            d dVar2 = (d) hashMapArr[i].get("ImageWidth");
            d dVar3 = (d) hashMapArr[i3].get("ImageLength");
            d dVar4 = (d) hashMapArr[i3].get("ImageWidth");
            if (dVar != null && dVar2 != null && dVar3 != null && dVar4 != null) {
                int i4 = dVar.i(this.f2693f);
                int i5 = dVar2.i(this.f2693f);
                int i6 = dVar3.i(this.f2693f);
                int i7 = dVar4.i(this.f2693f);
                if (i4 < i6 && i5 < i7) {
                    HashMap hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                }
            }
        }
    }

    public final void C(g gVar, int i) {
        d f4;
        d f5;
        HashMap[] hashMapArr = this.f2691d;
        d dVar = (d) hashMapArr[i].get("DefaultCropSize");
        d dVar2 = (d) hashMapArr[i].get("SensorTopBorder");
        d dVar3 = (d) hashMapArr[i].get("SensorLeftBorder");
        d dVar4 = (d) hashMapArr[i].get("SensorBottomBorder");
        d dVar5 = (d) hashMapArr[i].get("SensorRightBorder");
        if (dVar != null) {
            if (dVar.f2639a == 5) {
                f[] fVarArr = (f[]) dVar.k(this.f2693f);
                if (fVarArr != null && fVarArr.length == 2) {
                    f4 = d.e(new f[]{fVarArr[0]}, this.f2693f);
                    f5 = d.e(new f[]{fVarArr[1]}, this.f2693f);
                } else {
                    Arrays.toString(fVarArr);
                    return;
                }
            } else {
                int[] iArr = (int[]) dVar.k(this.f2693f);
                if (iArr != null && iArr.length == 2) {
                    f4 = d.f(iArr[0], this.f2693f);
                    f5 = d.f(iArr[1], this.f2693f);
                } else {
                    Arrays.toString(iArr);
                    return;
                }
            }
            hashMapArr[i].put("ImageWidth", f4);
            hashMapArr[i].put("ImageLength", f5);
            return;
        }
        if (dVar2 != null && dVar3 != null && dVar4 != null && dVar5 != null) {
            int i3 = dVar2.i(this.f2693f);
            int i4 = dVar4.i(this.f2693f);
            int i5 = dVar5.i(this.f2693f);
            int i6 = dVar3.i(this.f2693f);
            if (i4 > i3 && i5 > i6) {
                d f6 = d.f(i4 - i3, this.f2693f);
                d f7 = d.f(i5 - i6, this.f2693f);
                hashMapArr[i].put("ImageLength", f6);
                hashMapArr[i].put("ImageWidth", f7);
                return;
            }
            return;
        }
        d dVar6 = (d) hashMapArr[i].get("ImageLength");
        d dVar7 = (d) hashMapArr[i].get("ImageWidth");
        if (dVar6 == null || dVar7 == null) {
            d dVar8 = (d) hashMapArr[i].get("JPEGInterchangeFormat");
            d dVar9 = (d) hashMapArr[i].get("JPEGInterchangeFormatLength");
            if (dVar8 != null && dVar9 != null) {
                int i7 = dVar8.i(this.f2693f);
                int i8 = dVar8.i(this.f2693f);
                gVar.b(i7);
                byte[] bArr = new byte[i8];
                gVar.readFully(bArr);
                d(new b(bArr), i7, i);
            }
        }
    }

    public final void D() {
        B(0, 5);
        B(0, 4);
        B(5, 4);
        HashMap[] hashMapArr = this.f2691d;
        d dVar = (d) hashMapArr[1].get("PixelXDimension");
        d dVar2 = (d) hashMapArr[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            hashMapArr[0].put("ImageWidth", dVar);
            hashMapArr[0].put("ImageLength", dVar2);
        }
        if (hashMapArr[4].isEmpty() && o(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        o(hashMapArr[4]);
        w(0, "ThumbnailOrientation", "Orientation");
        w(0, "ThumbnailImageLength", "ImageLength");
        w(0, "ThumbnailImageWidth", "ImageWidth");
        w(5, "ThumbnailOrientation", "Orientation");
        w(5, "ThumbnailImageLength", "ImageLength");
        w(5, "ThumbnailImageWidth", "ImageWidth");
        w(4, "Orientation", "ThumbnailOrientation");
        w(4, "ImageLength", "ThumbnailImageLength");
        w(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final int E(c cVar) {
        HashMap[] hashMapArr;
        int i;
        int i3;
        char c4;
        char c5;
        int[] iArr;
        short s3;
        int i4;
        e[][] eVarArr = f2670V;
        int[] iArr2 = new int[eVarArr.length];
        int[] iArr3 = new int[eVarArr.length];
        e[] eVarArr2 = f2671W;
        for (e eVar : eVarArr2) {
            v(eVar.f2644b);
        }
        if (this.f2694g) {
            if (this.f2695h) {
                v("StripOffsets");
                v("StripByteCounts");
            } else {
                v("JPEGInterchangeFormat");
                v("JPEGInterchangeFormatLength");
            }
        }
        int i5 = 0;
        while (true) {
            int length = eVarArr.length;
            hashMapArr = this.f2691d;
            if (i5 >= length) {
                break;
            }
            Iterator it = hashMapArr[i5].entrySet().iterator();
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    it.remove();
                }
            }
            i5++;
        }
        if (!hashMapArr[1].isEmpty()) {
            i = 1;
            i3 = 0;
            hashMapArr[0].put(eVarArr2[1].f2644b, d.c(0L, this.f2693f));
        } else {
            i = 1;
            i3 = 0;
        }
        if (!hashMapArr[2].isEmpty()) {
            c4 = 2;
            hashMapArr[i3].put(eVarArr2[2].f2644b, d.c(0L, this.f2693f));
        } else {
            c4 = 2;
        }
        if (!hashMapArr[3].isEmpty()) {
            c5 = 3;
            hashMapArr[i].put(eVarArr2[3].f2644b, d.c(0L, this.f2693f));
        } else {
            c5 = 3;
        }
        int i6 = 4;
        if (this.f2694g) {
            if (this.f2695h) {
                hashMapArr[4].put("StripOffsets", d.f(i3, this.f2693f));
                hashMapArr[4].put("StripByteCounts", d.f(this.f2697k, this.f2693f));
            } else {
                hashMapArr[4].put("JPEGInterchangeFormat", d.c(0L, this.f2693f));
                hashMapArr[4].put("JPEGInterchangeFormatLength", d.c(this.f2697k, this.f2693f));
            }
        }
        int i7 = 0;
        while (true) {
            int length2 = eVarArr.length;
            iArr = f2667S;
            if (i7 >= length2) {
                break;
            }
            Iterator it2 = hashMapArr[i7].entrySet().iterator();
            int i8 = 0;
            while (it2.hasNext()) {
                d dVar = (d) ((Map.Entry) it2.next()).getValue();
                dVar.getClass();
                int i9 = iArr[dVar.f2639a] * dVar.f2640b;
                if (i9 > 4) {
                    i8 += i9;
                }
            }
            iArr3[i7] = iArr3[i7] + i8;
            i7++;
        }
        int i10 = 8;
        for (int i11 = 0; i11 < eVarArr.length; i11++) {
            if (!hashMapArr[i11].isEmpty()) {
                iArr2[i11] = i10;
                i10 = (hashMapArr[i11].size() * 12) + 6 + iArr3[i11] + i10;
            }
        }
        if (this.f2694g) {
            if (this.f2695h) {
                hashMapArr[4].put("StripOffsets", d.f(i10, this.f2693f));
            } else {
                hashMapArr[4].put("JPEGInterchangeFormat", d.c(i10, this.f2693f));
            }
            this.f2696j = i10;
            i10 += this.f2697k;
        }
        if (this.f2690c == 4) {
            i10 += 8;
        }
        if (f2682t) {
            for (int i12 = 0; i12 < eVarArr.length; i12++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i12), Integer.valueOf(iArr2[i12]), Integer.valueOf(hashMapArr[i12].size()), Integer.valueOf(iArr3[i12]), Integer.valueOf(i10));
            }
        }
        if (!hashMapArr[i].isEmpty()) {
            hashMapArr[0].put(eVarArr2[i].f2644b, d.c(iArr2[i], this.f2693f));
        }
        if (!hashMapArr[c4].isEmpty()) {
            hashMapArr[0].put(eVarArr2[c4].f2644b, d.c(iArr2[c4], this.f2693f));
        }
        if (!hashMapArr[c5].isEmpty()) {
            hashMapArr[i].put(eVarArr2[c5].f2644b, d.c(iArr2[c5], this.f2693f));
        }
        int i13 = this.f2690c;
        if (i13 != 4) {
            if (i13 != 13) {
                if (i13 == 14) {
                    cVar.write(f2659K);
                    cVar.b(i10);
                }
            } else {
                cVar.b(i10);
                cVar.b(1700284774);
            }
        } else if (i10 <= 65535) {
            cVar.e(i10);
            cVar.write(f2677c0);
        } else {
            throw new IllegalStateException(AbstractC0008a.j(i10, "Size of exif data (", " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)"));
        }
        int size = cVar.f2637a.size();
        if (this.f2693f == ByteOrder.BIG_ENDIAN) {
            s3 = 19789;
        } else {
            s3 = 18761;
        }
        cVar.c(s3);
        cVar.f2638b = this.f2693f;
        cVar.e(42);
        cVar.d(8L);
        int i14 = 0;
        while (i14 < eVarArr.length) {
            if (!hashMapArr[i14].isEmpty()) {
                cVar.e(hashMapArr[i14].size());
                int size2 = (hashMapArr[i14].size() * 12) + iArr2[i14] + 2 + i6;
                for (Map.Entry entry : hashMapArr[i14].entrySet()) {
                    int i15 = ((e) f2673Y[i14].get(entry.getKey())).f2643a;
                    d dVar2 = (d) entry.getValue();
                    dVar2.getClass();
                    int i16 = dVar2.f2640b;
                    int i17 = dVar2.f2639a;
                    int i18 = iArr[i17] * i16;
                    cVar.e(i15);
                    cVar.e(i17);
                    cVar.b(i16);
                    if (i18 > 4) {
                        cVar.d(size2);
                        size2 += i18;
                    } else {
                        cVar.write(dVar2.f2642d);
                        if (i18 < 4) {
                            while (i18 < 4) {
                                cVar.a(0);
                                i18++;
                            }
                        }
                    }
                    i6 = 4;
                }
                int i19 = i6;
                if (i14 == 0 && !hashMapArr[i19].isEmpty()) {
                    cVar.d(iArr2[i19]);
                } else {
                    cVar.d(0L);
                }
                Iterator it3 = hashMapArr[i14].entrySet().iterator();
                while (it3.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it3.next()).getValue()).f2642d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
                i4 = 4;
            } else {
                i4 = i6;
            }
            i14++;
            i6 = i4;
        }
        if (this.f2694g) {
            cVar.write(k());
        }
        if (this.f2690c == 14 && i10 % 2 == i) {
            cVar.a(0);
        }
        cVar.f2638b = ByteOrder.BIG_ENDIAN;
        return size;
    }

    public final void F(c cVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f2700n = cVar.f2637a.size() + E(new c(byteArrayOutputStream, ByteOrder.BIG_ENDIAN));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        cVar.write(byteArray);
        CRC32 crc32 = new CRC32();
        crc32.update(byteArray, 4, byteArray.length - 4);
        cVar.b((int) crc32.getValue());
    }

    public final void G(c cVar) {
        cVar.b(this.f2703r.f2642d.length + 22);
        CRC32 crc32 = new CRC32();
        cVar.b(1767135348);
        crc32.update(105);
        crc32.update(26964);
        crc32.update(6902872);
        crc32.update(1767135348);
        byte[] bArr = f2656H;
        cVar.write(bArr);
        crc32.update(bArr);
        cVar.write(this.f2703r.f2642d);
        crc32.update(this.f2703r.f2642d);
        cVar.b((int) crc32.getValue());
        this.f2704s = true;
    }

    public final void a() {
        String b4 = b("DateTimeOriginal");
        HashMap[] hashMapArr = this.f2691d;
        if (b4 != null && b("DateTime") == null) {
            hashMapArr[0].put("DateTime", d.b(b4));
        }
        if (b("ImageWidth") == null) {
            hashMapArr[0].put("ImageWidth", d.c(0L, this.f2693f));
        }
        if (b("ImageLength") == null) {
            hashMapArr[0].put("ImageLength", d.c(0L, this.f2693f));
        }
        if (b("Orientation") == null) {
            hashMapArr[0].put("Orientation", d.c(0L, this.f2693f));
        }
        if (b("LightSource") == null) {
            hashMapArr[1].put("LightSource", d.c(0L, this.f2693f));
        }
    }

    public final String b(String str) {
        String str2;
        d dVar;
        int i;
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                str2 = "PhotographicSensitivity";
            } else {
                str2 = str;
            }
            if (!"Xmp".equals(str2) || (i = this.f2690c) == 4 || ((i != 9 && i != 15 && i != 12 && i != 13) || (dVar = this.f2703r) == null)) {
                int i3 = 0;
                while (true) {
                    if (i3 < f2670V.length) {
                        d dVar2 = (d) this.f2691d[i3].get(str2);
                        if (dVar2 != null) {
                            dVar = dVar2;
                            break;
                        }
                        i3++;
                    } else if (!"Xmp".equals(str2) || (dVar = this.f2703r) == null) {
                        dVar = null;
                    }
                }
            }
            if (dVar != null) {
                if (str.equals("GPSTimeStamp")) {
                    int i4 = dVar.f2639a;
                    if (i4 == 5 || i4 == 10) {
                        f[] fVarArr = (f[]) dVar.k(this.f2693f);
                        if (fVarArr != null && fVarArr.length == 3) {
                            f fVar = fVarArr[0];
                            Integer valueOf = Integer.valueOf((int) (((float) fVar.f2647a) / ((float) fVar.f2648b)));
                            f fVar2 = fVarArr[1];
                            Integer valueOf2 = Integer.valueOf((int) (((float) fVar2.f2647a) / ((float) fVar2.f2648b)));
                            f fVar3 = fVarArr[2];
                            return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) fVar3.f2647a) / ((float) fVar3.f2648b))));
                        }
                        Arrays.toString(fVarArr);
                        return null;
                    }
                } else if (f2674Z.contains(str)) {
                    try {
                        return Double.toString(dVar.h(this.f2693f));
                    } catch (NumberFormatException unused) {
                    }
                } else {
                    return dVar.j(this.f2693f);
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void c(g gVar, int i) {
        String str;
        String str2;
        String str3;
        int i3;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            if (i == 15 && i4 < 31) {
                throw new UnsupportedOperationException("Reading EXIF from AVIF files is supported from SDK 31 and above");
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(new a(gVar));
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                    String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                    if ("yes".equals(extractMetadata3)) {
                        str = mediaMetadataRetriever.extractMetadata(29);
                        str3 = mediaMetadataRetriever.extractMetadata(30);
                        str2 = mediaMetadataRetriever.extractMetadata(31);
                    } else if ("yes".equals(extractMetadata4)) {
                        str = mediaMetadataRetriever.extractMetadata(18);
                        str3 = mediaMetadataRetriever.extractMetadata(19);
                        str2 = mediaMetadataRetriever.extractMetadata(24);
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    HashMap[] hashMapArr = this.f2691d;
                    if (str != null) {
                        hashMapArr[0].put("ImageWidth", d.f(Integer.parseInt(str), this.f2693f));
                    }
                    if (str3 != null) {
                        hashMapArr[0].put("ImageLength", d.f(Integer.parseInt(str3), this.f2693f));
                    }
                    if (str2 != null) {
                        int parseInt = Integer.parseInt(str2);
                        if (parseInt != 90) {
                            if (parseInt != 180) {
                                if (parseInt != 270) {
                                    i3 = 1;
                                } else {
                                    i3 = 8;
                                }
                            } else {
                                i3 = 3;
                            }
                        } else {
                            i3 = 6;
                        }
                        hashMapArr[0].put("Orientation", d.f(i3, this.f2693f));
                    }
                    if (extractMetadata != null && extractMetadata2 != null) {
                        int parseInt2 = Integer.parseInt(extractMetadata);
                        int parseInt3 = Integer.parseInt(extractMetadata2);
                        if (parseInt3 > 6) {
                            gVar.b(parseInt2);
                            byte[] bArr = new byte[6];
                            gVar.readFully(bArr);
                            int i5 = parseInt2 + 6;
                            int i6 = parseInt3 - 6;
                            if (Arrays.equals(bArr, f2677c0)) {
                                byte[] bArr2 = new byte[i6];
                                gVar.readFully(bArr2);
                                this.f2700n = i5;
                                t(bArr2, 0);
                            } else {
                                throw new IOException("Invalid identifier");
                            }
                        } else {
                            throw new IOException("Invalid exif length");
                        }
                    }
                    String extractMetadata5 = mediaMetadataRetriever.extractMetadata(41);
                    String extractMetadata6 = mediaMetadataRetriever.extractMetadata(42);
                    if (extractMetadata5 != null && extractMetadata6 != null) {
                        int parseInt4 = Integer.parseInt(extractMetadata5);
                        int parseInt5 = Integer.parseInt(extractMetadata6);
                        long j2 = parseInt4;
                        gVar.b(j2);
                        byte[] bArr3 = new byte[parseInt5];
                        gVar.readFully(bArr3);
                        this.f2703r = new d(j2, bArr3, 1, parseInt5);
                        this.f2704s = true;
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (IOException unused) {
                    }
                } finally {
                }
            } catch (RuntimeException e4) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", e4);
            }
        } else {
            throw new UnsupportedOperationException("Reading EXIF from HEIC files is supported from SDK 28 and above");
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0060. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0063. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0066. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c A[LOOP:0: B:9:0x0023->B:35:0x010c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(Y.b r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.d(Y.b, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x00e5, code lost:
    
        if (r6 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0185, code lost:
    
        r5 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(java.io.BufferedInputStream r19) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.e(java.io.BufferedInputStream):int");
    }

    public final void f(g gVar) {
        int i;
        int i3;
        i(gVar);
        HashMap[] hashMapArr = this.f2691d;
        d dVar = (d) hashMapArr[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f2642d);
            gVar2.f2634c = this.f2693f;
            byte[] bArr = f2653E;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.b(0L);
            byte[] bArr3 = f2654F;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.b(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.b(12L);
            }
            u(gVar2, 6);
            d dVar2 = (d) hashMapArr[7].get("PreviewImageStart");
            d dVar3 = (d) hashMapArr[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                hashMapArr[5].put("JPEGInterchangeFormat", dVar2);
                hashMapArr[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) hashMapArr[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.k(this.f2693f);
                if (iArr != null && iArr.length == 4) {
                    int i4 = iArr[2];
                    int i5 = iArr[0];
                    if (i4 > i5 && (i = iArr[3]) > (i3 = iArr[1])) {
                        int i6 = (i4 - i5) + 1;
                        int i7 = (i - i3) + 1;
                        if (i6 < i7) {
                            int i8 = i6 + i7;
                            i7 = i8 - i7;
                            i6 = i8 - i7;
                        }
                        d f4 = d.f(i6, this.f2693f);
                        d f5 = d.f(i7, this.f2693f);
                        hashMapArr[0].put("ImageWidth", f4);
                        hashMapArr[0].put("ImageLength", f5);
                        return;
                    }
                    return;
                }
                Arrays.toString(iArr);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0047, code lost:
    
        r18.f2704s = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0049, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(Y.b r19) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.g(Y.b):void");
    }

    public final void h(b bVar) {
        if (f2682t) {
            Objects.toString(bVar);
        }
        bVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        bVar.a(i - bVar.f2633b);
        bVar.readFully(bArr4);
        d(new b(bArr4), i, 5);
        bVar.a(i4 - bVar.f2633b);
        bVar.f2634c = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        for (int i5 = 0; i5 < readInt; i5++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f2669U.f2643a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d f4 = d.f(readShort, this.f2693f);
                d f5 = d.f(readShort2, this.f2693f);
                HashMap[] hashMapArr = this.f2691d;
                hashMapArr[0].put("ImageLength", f4);
                hashMapArr[0].put("ImageWidth", f5);
                return;
            }
            bVar.a(readUnsignedShort2);
        }
    }

    public final void i(g gVar) {
        q(gVar);
        u(gVar, 0);
        C(gVar, 0);
        C(gVar, 5);
        C(gVar, 4);
        D();
        if (this.f2690c == 8) {
            HashMap[] hashMapArr = this.f2691d;
            d dVar = (d) hashMapArr[1].get("MakerNote");
            if (dVar != null) {
                g gVar2 = new g(dVar.f2642d);
                gVar2.f2634c = this.f2693f;
                gVar2.a(6);
                u(gVar2, 9);
                d dVar2 = (d) hashMapArr[9].get("ColorSpace");
                if (dVar2 != null) {
                    hashMapArr[1].put("ColorSpace", dVar2);
                }
            }
        }
    }

    public final void j(g gVar) {
        if (f2682t) {
            Objects.toString(gVar);
        }
        i(gVar);
        HashMap[] hashMapArr = this.f2691d;
        d dVar = (d) hashMapArr[0].get("JpgFromRaw");
        if (dVar != null) {
            d(new b(dVar.f2642d), (int) dVar.f2641c, 5);
        }
        d dVar2 = (d) hashMapArr[0].get("ISO");
        d dVar3 = (d) hashMapArr[1].get("PhotographicSensitivity");
        if (dVar2 != null && dVar3 == null) {
            hashMapArr[1].put("PhotographicSensitivity", dVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] k() {
        /*
            r9 = this;
            java.lang.String r0 = "Error closing fd."
            java.lang.String r1 = "ExifInterfaceUtils"
            boolean r2 = r9.f2694g
            r3 = 0
            if (r2 != 0) goto Lb
            goto L83
        Lb:
            byte[] r2 = r9.f2698l
            if (r2 == 0) goto L10
            return r2
        L10:
            java.lang.String r2 = r9.f2688a     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            if (r2 == 0) goto L23
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            java.lang.String r4 = r9.f2688a     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            r4 = r3
            goto L38
        L1d:
            r2 = move-exception
            r4 = r3
            goto L68
        L20:
            r2 = r3
            r4 = r2
            goto L76
        L23:
            java.io.FileDescriptor r2 = r9.f2689b     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            java.io.FileDescriptor r2 = android.system.Os.dup(r2)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20
            int r4 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
            r5 = 0
            android.system.Os.lseek(r2, r5, r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L65
            r8 = r4
            r4 = r2
            r2 = r8
        L38:
            Y.b r5 = new Y.b     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            int r6 = r9.f2696j     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            int r7 = r9.f2700n     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            int r6 = r6 + r7
            r5.a(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            int r6 = r9.f2697k     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            r5.readFully(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            r9.f2698l = r6     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L76
            m3.b.e(r2)
            if (r4 == 0) goto L5b
            android.system.Os.close(r4)     // Catch: android.system.ErrnoException -> L57
            return r6
        L57:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L5b:
            return r6
        L5c:
            r3 = move-exception
            r8 = r3
            r3 = r2
        L5f:
            r2 = r8
            goto L68
        L61:
            r4 = move-exception
            r8 = r4
            r4 = r2
            goto L5f
        L65:
            r4 = r2
            r2 = r3
            goto L76
        L68:
            m3.b.e(r3)
            if (r4 == 0) goto L75
            android.system.Os.close(r4)     // Catch: android.system.ErrnoException -> L71
            goto L75
        L71:
            r3 = move-exception
            android.util.Log.e(r1, r0, r3)
        L75:
            throw r2
        L76:
            m3.b.e(r2)
            if (r4 == 0) goto L83
            android.system.Os.close(r4)     // Catch: android.system.ErrnoException -> L7f
            goto L83
        L7f:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.k():byte[]");
    }

    public final void l(b bVar) {
        if (f2682t) {
            Objects.toString(bVar);
        }
        bVar.f2634c = ByteOrder.LITTLE_ENDIAN;
        bVar.a(f2657I.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = f2658J;
        bVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int readInt2 = bVar.readInt();
                int i = length + 8;
                if (Arrays.equals(f2659K, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    bVar.readFully(bArr3);
                    byte[] bArr4 = f2677c0;
                    if (m3.b.Q(bArr3, bArr4)) {
                        bArr3 = Arrays.copyOfRange(bArr3, bArr4.length, readInt2);
                    }
                    this.f2700n = i;
                    t(bArr3, 0);
                    A(new b(bArr3));
                    return;
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length <= readInt) {
                    bVar.a(readInt2);
                } else {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
            } catch (EOFException e4) {
                throw new IOException("Encountered corrupt WebP file.", e4);
            }
        }
    }

    public final void n(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int i = dVar.i(this.f2693f);
            int i3 = dVar2.i(this.f2693f);
            if (this.f2690c == 7) {
                i += this.f2701o;
            }
            if (i > 0 && i3 > 0) {
                this.f2694g = true;
                if (this.f2688a == null && this.f2689b == null) {
                    byte[] bArr = new byte[i3];
                    bVar.a(i);
                    bVar.readFully(bArr);
                    this.f2698l = bArr;
                }
                this.f2696j = i;
                this.f2697k = i3;
            }
        }
    }

    public final boolean o(HashMap hashMap) {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar != null && dVar2 != null) {
            int i = dVar.i(this.f2693f);
            int i3 = dVar2.i(this.f2693f);
            if (i <= 512 && i3 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(java.io.FileInputStream r8) {
        /*
            r7 = this;
            boolean r0 = Y.h.f2682t
            r1 = 0
            r2 = r1
        L4:
            Y.e[][] r3 = Y.h.f2670V     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            int r3 = r3.length     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            if (r2 >= r3) goto L18
            java.util.HashMap[] r3 = r7.f2691d     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r4.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r3[r2] = r4     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            int r2 = r2 + 1
            goto L4
        L15:
            r8 = move-exception
            goto L8c
        L18:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r3 = 5000(0x1388, float:7.006E-42)
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            int r8 = r7.e(r2)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r7.f2690c = r8     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r3 = 14
            r4 = 13
            r5 = 9
            r6 = 4
            if (r8 == r6) goto L65
            if (r8 == r5) goto L65
            if (r8 == r4) goto L65
            if (r8 != r3) goto L35
            goto L65
        L35:
            Y.g r8 = new Y.g     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            int r1 = r7.f2690c     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r2 = 12
            if (r1 == r2) goto L58
            r2 = 15
            if (r1 != r2) goto L45
            goto L58
        L45:
            r2 = 7
            if (r1 != r2) goto L4c
            r7.f(r8)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            goto L5b
        L4c:
            r2 = 10
            if (r1 != r2) goto L54
            r7.j(r8)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            goto L5b
        L54:
            r7.i(r8)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            goto L5b
        L58:
            r7.c(r8, r1)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
        L5b:
            int r1 = r7.f2700n     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r8.b(r1)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r7.A(r8)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            goto L83
        L65:
            Y.b r8 = new Y.b     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            int r2 = r7.f2690c     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            if (r2 != r6) goto L72
            r7.d(r8, r1, r1)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            goto L83
        L72:
            if (r2 != r4) goto L78
            r7.g(r8)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            goto L83
        L78:
            if (r2 != r5) goto L7e
            r7.h(r8)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
            goto L83
        L7e:
            if (r2 != r3) goto L83
            r7.l(r8)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L95
        L83:
            r7.a()
            if (r0 == 0) goto L9d
            r7.r()
            return
        L8c:
            r7.a()
            if (r0 == 0) goto L94
            r7.r()
        L94:
            throw r8
        L95:
            r7.a()
            if (r0 == 0) goto L9d
            r7.r()
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.p(java.io.FileInputStream):void");
    }

    public final void q(g gVar) {
        ByteOrder s3 = s(gVar);
        this.f2693f = s3;
        gVar.f2634c = s3;
        int readUnsignedShort = gVar.readUnsignedShort();
        int i = this.f2690c;
        if (i != 7 && i != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = gVar.readInt();
        if (readInt >= 8) {
            int i3 = readInt - 8;
            if (i3 > 0) {
                gVar.a(i3);
                return;
            }
            return;
        }
        throw new IOException(e0.a.c(readInt, "Invalid first Ifd offset: "));
    }

    public final void r() {
        int i = 0;
        while (true) {
            HashMap[] hashMapArr = this.f2691d;
            if (i < hashMapArr.length) {
                hashMapArr[i].size();
                for (Map.Entry entry : hashMapArr[i].entrySet()) {
                    d dVar = (d) entry.getValue();
                    dVar.toString();
                    dVar.j(this.f2693f);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final void t(byte[] bArr, int i) {
        g gVar = new g(bArr);
        q(gVar);
        u(gVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(Y.g r27, int r28) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.u(Y.g, int):void");
    }

    public final void v(String str) {
        for (int i = 0; i < f2670V.length; i++) {
            this.f2691d[i].remove(str);
        }
    }

    public final void w(int i, String str, String str2) {
        HashMap[] hashMapArr = this.f2691d;
        if (!hashMapArr[i].isEmpty() && hashMapArr[i].get(str) != null) {
            HashMap hashMap = hashMapArr[i];
            hashMap.put(str2, (d) hashMap.get(str));
            hashMapArr[i].remove(str);
        }
    }

    public final void x(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        byte readByte;
        byte[] bArr;
        if (f2682t) {
            Objects.toString(bufferedInputStream);
            Objects.toString(bufferedOutputStream);
        }
        b bVar = new b(bufferedInputStream);
        c cVar = new c(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.a(-1);
            if (bVar.readByte() == -40) {
                cVar.a(-40);
                cVar.a(-1);
                cVar.a(-31);
                this.f2700n = E(cVar);
                d dVar = this.f2703r;
                byte[] bArr2 = f2678d0;
                if (dVar != null) {
                    cVar.write(-1);
                    cVar.a(-31);
                    cVar.e(bArr2.length + 2 + this.f2703r.f2642d.length);
                    cVar.write(bArr2);
                    cVar.write(this.f2703r.f2642d);
                    this.f2704s = true;
                }
                byte[] bArr3 = new byte[4096];
                while (bVar.readByte() == -1) {
                    do {
                        readByte = bVar.readByte();
                    } while (readByte == -1);
                    if (readByte != -39 && readByte != -38) {
                        if (readByte != -31) {
                            cVar.a(-1);
                            cVar.a(readByte);
                            int readUnsignedShort = bVar.readUnsignedShort();
                            cVar.e(readUnsignedShort);
                            int i = readUnsignedShort - 2;
                            if (i >= 0) {
                                while (i > 0) {
                                    int read = bVar.read(bArr3, 0, Math.min(i, 4096));
                                    if (read >= 0) {
                                        cVar.write(bArr3, 0, read);
                                        i -= read;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            int readUnsignedShort2 = bVar.readUnsignedShort();
                            int i3 = readUnsignedShort2 - 2;
                            if (i3 >= 0) {
                                int length = bArr2.length;
                                byte[] bArr4 = f2677c0;
                                if (i3 >= length) {
                                    bArr = new byte[bArr2.length];
                                } else if (i3 >= bArr4.length) {
                                    bArr = new byte[bArr4.length];
                                } else {
                                    bArr = null;
                                }
                                if (bArr != null) {
                                    bVar.readFully(bArr);
                                    if (m3.b.Q(bArr, bArr4) || m3.b.Q(bArr, bArr2)) {
                                        bVar.a(i3 - bArr.length);
                                    }
                                }
                                cVar.a(-1);
                                cVar.a(readByte);
                                cVar.e(readUnsignedShort2);
                                if (bArr != null) {
                                    i3 -= bArr.length;
                                    cVar.write(bArr);
                                }
                                while (i3 > 0) {
                                    int read2 = bVar.read(bArr3, 0, Math.min(i3, 4096));
                                    if (read2 >= 0) {
                                        cVar.write(bArr3, 0, read2);
                                        i3 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        cVar.a(-1);
                        cVar.a(readByte);
                        m3.b.h(bVar, cVar);
                        return;
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003d A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x005b -> B:9:0x0027). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.io.BufferedInputStream r9, java.io.BufferedOutputStream r10) {
        /*
            r8 = this;
            boolean r0 = Y.h.f2682t
            if (r0 == 0) goto La
            java.util.Objects.toString(r9)
            java.util.Objects.toString(r10)
        La:
            Y.b r0 = new Y.b
            r0.<init>(r9)
            Y.c r9 = new Y.c
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            r9.<init>(r10, r1)
            byte[] r10 = Y.h.f2655G
            int r10 = r10.length
            m3.b.g(r0, r9, r10)
            Y.d r10 = r8.f2703r
            r1 = 1
            r2 = 0
            if (r10 != 0) goto L26
            boolean r10 = r8.f2704s
            if (r10 == 0) goto L5b
        L26:
            r10 = r1
        L27:
            if (r1 != 0) goto L30
            if (r10 == 0) goto L2c
            goto L30
        L2c:
            m3.b.h(r0, r9)
            return
        L30:
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            r5 = 1229472850(0x49484452, float:820293.1)
            if (r4 != r5) goto L5d
            r9.b(r3)
            r9.b(r4)
            int r3 = r3 + 4
            m3.b.g(r0, r9, r3)
            int r3 = r8.f2700n
            if (r3 != 0) goto L50
            r8.F(r9)
            r1 = r2
        L50:
            Y.d r3 = r8.f2703r
            if (r3 == 0) goto L27
            boolean r3 = r8.f2704s
            if (r3 != 0) goto L27
            r8.G(r9)
        L5b:
            r10 = r2
            goto L27
        L5d:
            r5 = 1700284774(0x65584966, float:6.383657E22)
            if (r4 != r5) goto L6e
            if (r1 == 0) goto L6e
            r8.F(r9)
            int r3 = r3 + 4
            r0.a(r3)
            r1 = r2
            goto L27
        L6e:
            r5 = 1767135348(0x69545874, float:1.6044374E25)
            if (r4 != r5) goto La0
            byte[] r5 = Y.h.f2656H
            int r6 = r5.length
            if (r3 < r6) goto La0
            int r6 = r5.length
            byte[] r7 = new byte[r6]
            r0.readFully(r7)
            int r6 = r3 - r6
            int r6 = r6 + 4
            boolean r5 = java.util.Arrays.equals(r7, r5)
            if (r5 == 0) goto L93
            Y.d r10 = r8.f2703r
            if (r10 == 0) goto L8f
            r8.G(r9)
        L8f:
            r0.a(r6)
            goto L5b
        L93:
            r9.b(r3)
            r9.b(r4)
            r9.write(r7)
            m3.b.g(r0, r9, r6)
            goto L27
        La0:
            r9.b(r3)
            r9.b(r4)
            int r3 = r3 + 4
            m3.b.g(r0, r9, r3)
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.y(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0264 A[Catch: all -> 0x022c, Exception -> 0x0231, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x0231, all -> 0x022c, blocks: (B:22:0x0264, B:121:0x0222, B:126:0x023d), top: B:11:0x003c }] */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.io.OutputStream, java.lang.Object, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r24v13 */
    /* JADX WARN: Type inference failed for: r24v14 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(java.io.BufferedInputStream r23, java.io.BufferedOutputStream r24) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y.h.z(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
    }
}
