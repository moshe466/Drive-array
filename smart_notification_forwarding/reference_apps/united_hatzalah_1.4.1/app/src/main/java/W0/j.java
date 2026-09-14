package W0;

import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.Asn1EncodingException;
import com.android.apksig.internal.x509.Certificate;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static volatile CertificateFactory f2469a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2470b = "-----BEGIN CERTIFICATE-----".getBytes();

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f2471c = "-----END CERTIFICATE-----".getBytes();

    public static X509Certificate a(byte[] bArr) {
        if (f2469a == null) {
            synchronized (j.class) {
                if (f2469a == null) {
                    try {
                        f2469a = CertificateFactory.getInstance("X.509");
                    } catch (CertificateException e4) {
                        throw new RuntimeException("Failed to create X.509 CertificateFactory", e4);
                    }
                }
            }
        }
        return b(bArr, f2469a);
    }

    public static X509Certificate b(byte[] bArr, CertificateFactory certificateFactory) {
        try {
            try {
                return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
            } catch (Asn1DecodingException | Asn1EncodingException | CertificateException e4) {
                throw new CertificateException("Failed to parse certificate", e4);
            }
        } catch (CertificateException unused) {
            ByteBuffer c4 = c(ByteBuffer.wrap(bArr));
            int position = c4.position();
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(S0.f.b((Certificate) S0.c.g(c4, Certificate.class))));
            byte[] bArr2 = new byte[c4.position() - position];
            c4.position(position);
            c4.get(bArr2);
            return new e(x509Certificate, bArr2);
        }
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        Base64.Decoder decoder;
        byte[] decode;
        char c4;
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = f2470b;
            if (remaining < bArr.length) {
                return byteBuffer;
            }
            byteBuffer.mark();
            for (byte b4 : bArr) {
                if (byteBuffer.get() != b4) {
                    byteBuffer.reset();
                    return byteBuffer;
                }
            }
            StringBuilder sb = new StringBuilder();
            while (byteBuffer.hasRemaining() && (c4 = (char) byteBuffer.get()) != '-') {
                if (!Character.isWhitespace(c4)) {
                    sb.append(c4);
                }
            }
            int i = 1;
            while (true) {
                byte[] bArr2 = f2471c;
                if (i >= bArr2.length) {
                    decoder = Base64.getDecoder();
                    decode = decoder.decode(sb.toString());
                    int position = byteBuffer.position();
                    while (byteBuffer.hasRemaining() && Character.isWhitespace((char) byteBuffer.get())) {
                        position++;
                    }
                    byteBuffer.position(position);
                    return ByteBuffer.wrap(decode);
                }
                if (byteBuffer.hasRemaining()) {
                    if (byteBuffer.get() == bArr2[i]) {
                        i++;
                    } else {
                        throw new CertificateException("The provided input contains the PEM certificate header without a valid certificate footer");
                    }
                } else {
                    throw new CertificateException("The provided input contains the PEM certificate header but does not contain sufficient data for the footer");
                }
            }
        } else {
            throw new NullPointerException("The certificateBuffer cannot be null");
        }
    }
}
