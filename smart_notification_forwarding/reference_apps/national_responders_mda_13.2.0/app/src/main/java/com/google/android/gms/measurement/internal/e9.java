package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.d1;
import com.google.android.gms.internal.measurement.db;
import com.google.android.gms.internal.measurement.h1;
import com.google.android.gms.internal.measurement.md;
import com.google.android.gms.internal.measurement.nd;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class e9 implements s5 {
    private static volatile e9 A;

    /* renamed from: a, reason: collision with root package name */
    private p4 f6001a;

    /* renamed from: b, reason: collision with root package name */
    private y3 f6002b;

    /* renamed from: c, reason: collision with root package name */
    private f f6003c;

    /* renamed from: d, reason: collision with root package name */
    private c4 f6004d;

    /* renamed from: e, reason: collision with root package name */
    private a9 f6005e;

    /* renamed from: f, reason: collision with root package name */
    private z9 f6006f;

    /* renamed from: g, reason: collision with root package name */
    private final k9 f6007g;

    /* renamed from: h, reason: collision with root package name */
    private a7 f6008h;

    /* renamed from: i, reason: collision with root package name */
    private k8 f6009i;

    /* renamed from: j, reason: collision with root package name */
    private final t4 f6010j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6011k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6012l;

    /* renamed from: m, reason: collision with root package name */
    private long f6013m;

    /* renamed from: n, reason: collision with root package name */
    private List<Runnable> f6014n;

    /* renamed from: o, reason: collision with root package name */
    private int f6015o;

    /* renamed from: p, reason: collision with root package name */
    private int f6016p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6017q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6018r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6019s;

    /* renamed from: t, reason: collision with root package name */
    private FileLock f6020t;

    /* renamed from: u, reason: collision with root package name */
    private FileChannel f6021u;

    /* renamed from: v, reason: collision with root package name */
    private List<Long> f6022v;

    /* renamed from: w, reason: collision with root package name */
    private List<Long> f6023w;

    /* renamed from: x, reason: collision with root package name */
    private long f6024x;

    /* renamed from: y, reason: collision with root package name */
    private final Map<String, v2.a> f6025y;

    /* renamed from: z, reason: collision with root package name */
    private final r9 f6026z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements h {

        /* renamed from: a, reason: collision with root package name */
        com.google.android.gms.internal.measurement.h1 f6027a;

        /* renamed from: b, reason: collision with root package name */
        List<Long> f6028b;

        /* renamed from: c, reason: collision with root package name */
        List<com.google.android.gms.internal.measurement.d1> f6029c;

        /* renamed from: d, reason: collision with root package name */
        private long f6030d;

        private a(e9 e9Var) {
        }

        /* synthetic */ a(e9 e9Var, d9 d9Var) {
            this(e9Var);
        }

        private static long c(com.google.android.gms.internal.measurement.d1 d1Var) {
            return ((d1Var.X() / 1000) / 60) / 60;
        }

        @Override // com.google.android.gms.measurement.internal.h
        public final boolean a(long j10, com.google.android.gms.internal.measurement.d1 d1Var) {
            b2.p.k(d1Var);
            if (this.f6029c == null) {
                this.f6029c = new ArrayList();
            }
            if (this.f6028b == null) {
                this.f6028b = new ArrayList();
            }
            if (this.f6029c.size() > 0 && c(this.f6029c.get(0)) != c(d1Var)) {
                return false;
            }
            long b10 = this.f6030d + d1Var.b();
            if (b10 >= Math.max(0, s.f6408i.a(null).intValue())) {
                return false;
            }
            this.f6030d = b10;
            this.f6029c.add(d1Var);
            this.f6028b.add(Long.valueOf(j10));
            return this.f6029c.size() < Math.max(1, s.f6410j.a(null).intValue());
        }

        @Override // com.google.android.gms.measurement.internal.h
        public final void b(com.google.android.gms.internal.measurement.h1 h1Var) {
            b2.p.k(h1Var);
            this.f6027a = h1Var;
        }
    }

    private e9(l9 l9Var) {
        this(l9Var, null);
    }

    private e9(l9 l9Var, t4 t4Var) {
        this.f6011k = false;
        this.f6026z = new h9(this);
        b2.p.k(l9Var);
        t4 b10 = t4.b(l9Var.f6206a, null, null);
        this.f6010j = b10;
        this.f6024x = -1L;
        k9 k9Var = new k9(this);
        k9Var.v();
        this.f6007g = k9Var;
        y3 y3Var = new y3(this);
        y3Var.v();
        this.f6002b = y3Var;
        p4 p4Var = new p4(this);
        p4Var.v();
        this.f6001a = p4Var;
        this.f6025y = new HashMap();
        b10.e().z(new d9(this, l9Var));
    }

    private final boolean E(int i10, FileChannel fileChannel) {
        p0();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f6010j.h().F().a("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i10);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.f6010j.a().t(s.f6429s0) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.f6010j.h().F().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e10) {
            this.f6010j.h().F().b("Failed to write to channel", e10);
            return false;
        }
    }

    private final boolean F(d1.a aVar, d1.a aVar2) {
        b2.p.a("_e".equals(aVar.K()));
        e0();
        com.google.android.gms.internal.measurement.f1 B = k9.B((com.google.android.gms.internal.measurement.d1) ((com.google.android.gms.internal.measurement.l7) aVar.g()), "_sc");
        String U = B == null ? null : B.U();
        e0();
        com.google.android.gms.internal.measurement.f1 B2 = k9.B((com.google.android.gms.internal.measurement.d1) ((com.google.android.gms.internal.measurement.l7) aVar2.g()), "_pc");
        String U2 = B2 != null ? B2.U() : null;
        if (U2 == null || !U2.equals(U)) {
            return false;
        }
        O(aVar, aVar2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:581:0x0258, code lost:
    
        if (r6 != null) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x063d A[Catch: all -> 0x0ff0, TryCatch #9 {all -> 0x0ff0, blocks: (B:3:0x000f, B:20:0x00da, B:22:0x025b, B:24:0x025f, B:29:0x026b, B:30:0x0292, B:33:0x02aa, B:36:0x02d0, B:38:0x0307, B:43:0x031d, B:45:0x0327, B:48:0x0920, B:50:0x0351, B:52:0x0357, B:54:0x036d, B:56:0x037b, B:59:0x039b, B:61:0x03a1, B:63:0x03b1, B:65:0x03bf, B:67:0x03cf, B:69:0x03de, B:74:0x03e3, B:77:0x03f9, B:94:0x045d, B:97:0x0467, B:99:0x0475, B:101:0x04c3, B:102:0x0494, B:104:0x04a2, B:112:0x04d0, B:114:0x0505, B:115:0x0533, B:117:0x0567, B:118:0x056d, B:122:0x063d, B:123:0x0649, B:126:0x0653, B:130:0x0676, B:131:0x0665, B:139:0x067c, B:141:0x0688, B:143:0x0694, B:148:0x06e3, B:149:0x0700, B:151:0x0714, B:153:0x071e, B:156:0x0731, B:158:0x0745, B:160:0x0753, B:163:0x08aa, B:165:0x08b4, B:167:0x08ba, B:168:0x08d0, B:169:0x08d4, B:171:0x08e7, B:172:0x08fe, B:173:0x0906, B:178:0x0771, B:180:0x077f, B:183:0x0794, B:185:0x07a8, B:187:0x07b6, B:190:0x07c8, B:192:0x07e0, B:194:0x07ec, B:197:0x07ff, B:199:0x0813, B:201:0x085e, B:202:0x0865, B:204:0x086b, B:206:0x0875, B:207:0x087c, B:209:0x0882, B:211:0x088c, B:212:0x089c, B:216:0x06b5, B:220:0x06c9, B:222:0x06cf, B:224:0x06da, B:232:0x0579, B:234:0x05ae, B:235:0x05cb, B:237:0x05d1, B:239:0x05df, B:241:0x05f3, B:242:0x05e8, B:250:0x05fa, B:252:0x0601, B:253:0x0620, B:258:0x041b, B:261:0x0425, B:264:0x042f, B:274:0x093c, B:276:0x094a, B:278:0x0953, B:280:0x0985, B:281:0x095b, B:283:0x0964, B:285:0x096a, B:287:0x0976, B:289:0x0980, B:297:0x098c, B:298:0x0998, B:300:0x099e, B:306:0x09b7, B:307:0x09c2, B:311:0x09cf, B:312:0x09f6, B:314:0x0a15, B:316:0x0a23, B:318:0x0a29, B:320:0x0a33, B:321:0x0a65, B:323:0x0a6b, B:327:0x0a79, B:329:0x0a84, B:325:0x0a7e, B:332:0x0a87, B:333:0x0a96, B:335:0x0a9c, B:337:0x0aac, B:338:0x0ab3, B:340:0x0abf, B:342:0x0ac6, B:345:0x0ac9, B:347:0x0acf, B:349:0x0ae1, B:350:0x0ae4, B:424:0x0b54, B:426:0x0b6f, B:427:0x0b80, B:429:0x0b84, B:431:0x0b90, B:432:0x0b98, B:434:0x0b9c, B:436:0x0ba2, B:437:0x0bb0, B:438:0x0bbb, B:446:0x0bfc, B:447:0x0c04, B:449:0x0c0a, B:453:0x0c1c, B:455:0x0c2a, B:457:0x0c2e, B:459:0x0c38, B:461:0x0c3c, B:465:0x0c52, B:467:0x0c68, B:524:0x09d4, B:526:0x09da, B:560:0x01ba, B:582:0x022a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0714 A[Catch: all -> 0x0ff0, TryCatch #9 {all -> 0x0ff0, blocks: (B:3:0x000f, B:20:0x00da, B:22:0x025b, B:24:0x025f, B:29:0x026b, B:30:0x0292, B:33:0x02aa, B:36:0x02d0, B:38:0x0307, B:43:0x031d, B:45:0x0327, B:48:0x0920, B:50:0x0351, B:52:0x0357, B:54:0x036d, B:56:0x037b, B:59:0x039b, B:61:0x03a1, B:63:0x03b1, B:65:0x03bf, B:67:0x03cf, B:69:0x03de, B:74:0x03e3, B:77:0x03f9, B:94:0x045d, B:97:0x0467, B:99:0x0475, B:101:0x04c3, B:102:0x0494, B:104:0x04a2, B:112:0x04d0, B:114:0x0505, B:115:0x0533, B:117:0x0567, B:118:0x056d, B:122:0x063d, B:123:0x0649, B:126:0x0653, B:130:0x0676, B:131:0x0665, B:139:0x067c, B:141:0x0688, B:143:0x0694, B:148:0x06e3, B:149:0x0700, B:151:0x0714, B:153:0x071e, B:156:0x0731, B:158:0x0745, B:160:0x0753, B:163:0x08aa, B:165:0x08b4, B:167:0x08ba, B:168:0x08d0, B:169:0x08d4, B:171:0x08e7, B:172:0x08fe, B:173:0x0906, B:178:0x0771, B:180:0x077f, B:183:0x0794, B:185:0x07a8, B:187:0x07b6, B:190:0x07c8, B:192:0x07e0, B:194:0x07ec, B:197:0x07ff, B:199:0x0813, B:201:0x085e, B:202:0x0865, B:204:0x086b, B:206:0x0875, B:207:0x087c, B:209:0x0882, B:211:0x088c, B:212:0x089c, B:216:0x06b5, B:220:0x06c9, B:222:0x06cf, B:224:0x06da, B:232:0x0579, B:234:0x05ae, B:235:0x05cb, B:237:0x05d1, B:239:0x05df, B:241:0x05f3, B:242:0x05e8, B:250:0x05fa, B:252:0x0601, B:253:0x0620, B:258:0x041b, B:261:0x0425, B:264:0x042f, B:274:0x093c, B:276:0x094a, B:278:0x0953, B:280:0x0985, B:281:0x095b, B:283:0x0964, B:285:0x096a, B:287:0x0976, B:289:0x0980, B:297:0x098c, B:298:0x0998, B:300:0x099e, B:306:0x09b7, B:307:0x09c2, B:311:0x09cf, B:312:0x09f6, B:314:0x0a15, B:316:0x0a23, B:318:0x0a29, B:320:0x0a33, B:321:0x0a65, B:323:0x0a6b, B:327:0x0a79, B:329:0x0a84, B:325:0x0a7e, B:332:0x0a87, B:333:0x0a96, B:335:0x0a9c, B:337:0x0aac, B:338:0x0ab3, B:340:0x0abf, B:342:0x0ac6, B:345:0x0ac9, B:347:0x0acf, B:349:0x0ae1, B:350:0x0ae4, B:424:0x0b54, B:426:0x0b6f, B:427:0x0b80, B:429:0x0b84, B:431:0x0b90, B:432:0x0b98, B:434:0x0b9c, B:436:0x0ba2, B:437:0x0bb0, B:438:0x0bbb, B:446:0x0bfc, B:447:0x0c04, B:449:0x0c0a, B:453:0x0c1c, B:455:0x0c2a, B:457:0x0c2e, B:459:0x0c38, B:461:0x0c3c, B:465:0x0c52, B:467:0x0c68, B:524:0x09d4, B:526:0x09da, B:560:0x01ba, B:582:0x022a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x08aa A[Catch: all -> 0x0ff0, TryCatch #9 {all -> 0x0ff0, blocks: (B:3:0x000f, B:20:0x00da, B:22:0x025b, B:24:0x025f, B:29:0x026b, B:30:0x0292, B:33:0x02aa, B:36:0x02d0, B:38:0x0307, B:43:0x031d, B:45:0x0327, B:48:0x0920, B:50:0x0351, B:52:0x0357, B:54:0x036d, B:56:0x037b, B:59:0x039b, B:61:0x03a1, B:63:0x03b1, B:65:0x03bf, B:67:0x03cf, B:69:0x03de, B:74:0x03e3, B:77:0x03f9, B:94:0x045d, B:97:0x0467, B:99:0x0475, B:101:0x04c3, B:102:0x0494, B:104:0x04a2, B:112:0x04d0, B:114:0x0505, B:115:0x0533, B:117:0x0567, B:118:0x056d, B:122:0x063d, B:123:0x0649, B:126:0x0653, B:130:0x0676, B:131:0x0665, B:139:0x067c, B:141:0x0688, B:143:0x0694, B:148:0x06e3, B:149:0x0700, B:151:0x0714, B:153:0x071e, B:156:0x0731, B:158:0x0745, B:160:0x0753, B:163:0x08aa, B:165:0x08b4, B:167:0x08ba, B:168:0x08d0, B:169:0x08d4, B:171:0x08e7, B:172:0x08fe, B:173:0x0906, B:178:0x0771, B:180:0x077f, B:183:0x0794, B:185:0x07a8, B:187:0x07b6, B:190:0x07c8, B:192:0x07e0, B:194:0x07ec, B:197:0x07ff, B:199:0x0813, B:201:0x085e, B:202:0x0865, B:204:0x086b, B:206:0x0875, B:207:0x087c, B:209:0x0882, B:211:0x088c, B:212:0x089c, B:216:0x06b5, B:220:0x06c9, B:222:0x06cf, B:224:0x06da, B:232:0x0579, B:234:0x05ae, B:235:0x05cb, B:237:0x05d1, B:239:0x05df, B:241:0x05f3, B:242:0x05e8, B:250:0x05fa, B:252:0x0601, B:253:0x0620, B:258:0x041b, B:261:0x0425, B:264:0x042f, B:274:0x093c, B:276:0x094a, B:278:0x0953, B:280:0x0985, B:281:0x095b, B:283:0x0964, B:285:0x096a, B:287:0x0976, B:289:0x0980, B:297:0x098c, B:298:0x0998, B:300:0x099e, B:306:0x09b7, B:307:0x09c2, B:311:0x09cf, B:312:0x09f6, B:314:0x0a15, B:316:0x0a23, B:318:0x0a29, B:320:0x0a33, B:321:0x0a65, B:323:0x0a6b, B:327:0x0a79, B:329:0x0a84, B:325:0x0a7e, B:332:0x0a87, B:333:0x0a96, B:335:0x0a9c, B:337:0x0aac, B:338:0x0ab3, B:340:0x0abf, B:342:0x0ac6, B:345:0x0ac9, B:347:0x0acf, B:349:0x0ae1, B:350:0x0ae4, B:424:0x0b54, B:426:0x0b6f, B:427:0x0b80, B:429:0x0b84, B:431:0x0b90, B:432:0x0b98, B:434:0x0b9c, B:436:0x0ba2, B:437:0x0bb0, B:438:0x0bbb, B:446:0x0bfc, B:447:0x0c04, B:449:0x0c0a, B:453:0x0c1c, B:455:0x0c2a, B:457:0x0c2e, B:459:0x0c38, B:461:0x0c3c, B:465:0x0c52, B:467:0x0c68, B:524:0x09d4, B:526:0x09da, B:560:0x01ba, B:582:0x022a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x08ba A[Catch: all -> 0x0ff0, TryCatch #9 {all -> 0x0ff0, blocks: (B:3:0x000f, B:20:0x00da, B:22:0x025b, B:24:0x025f, B:29:0x026b, B:30:0x0292, B:33:0x02aa, B:36:0x02d0, B:38:0x0307, B:43:0x031d, B:45:0x0327, B:48:0x0920, B:50:0x0351, B:52:0x0357, B:54:0x036d, B:56:0x037b, B:59:0x039b, B:61:0x03a1, B:63:0x03b1, B:65:0x03bf, B:67:0x03cf, B:69:0x03de, B:74:0x03e3, B:77:0x03f9, B:94:0x045d, B:97:0x0467, B:99:0x0475, B:101:0x04c3, B:102:0x0494, B:104:0x04a2, B:112:0x04d0, B:114:0x0505, B:115:0x0533, B:117:0x0567, B:118:0x056d, B:122:0x063d, B:123:0x0649, B:126:0x0653, B:130:0x0676, B:131:0x0665, B:139:0x067c, B:141:0x0688, B:143:0x0694, B:148:0x06e3, B:149:0x0700, B:151:0x0714, B:153:0x071e, B:156:0x0731, B:158:0x0745, B:160:0x0753, B:163:0x08aa, B:165:0x08b4, B:167:0x08ba, B:168:0x08d0, B:169:0x08d4, B:171:0x08e7, B:172:0x08fe, B:173:0x0906, B:178:0x0771, B:180:0x077f, B:183:0x0794, B:185:0x07a8, B:187:0x07b6, B:190:0x07c8, B:192:0x07e0, B:194:0x07ec, B:197:0x07ff, B:199:0x0813, B:201:0x085e, B:202:0x0865, B:204:0x086b, B:206:0x0875, B:207:0x087c, B:209:0x0882, B:211:0x088c, B:212:0x089c, B:216:0x06b5, B:220:0x06c9, B:222:0x06cf, B:224:0x06da, B:232:0x0579, B:234:0x05ae, B:235:0x05cb, B:237:0x05d1, B:239:0x05df, B:241:0x05f3, B:242:0x05e8, B:250:0x05fa, B:252:0x0601, B:253:0x0620, B:258:0x041b, B:261:0x0425, B:264:0x042f, B:274:0x093c, B:276:0x094a, B:278:0x0953, B:280:0x0985, B:281:0x095b, B:283:0x0964, B:285:0x096a, B:287:0x0976, B:289:0x0980, B:297:0x098c, B:298:0x0998, B:300:0x099e, B:306:0x09b7, B:307:0x09c2, B:311:0x09cf, B:312:0x09f6, B:314:0x0a15, B:316:0x0a23, B:318:0x0a29, B:320:0x0a33, B:321:0x0a65, B:323:0x0a6b, B:327:0x0a79, B:329:0x0a84, B:325:0x0a7e, B:332:0x0a87, B:333:0x0a96, B:335:0x0a9c, B:337:0x0aac, B:338:0x0ab3, B:340:0x0abf, B:342:0x0ac6, B:345:0x0ac9, B:347:0x0acf, B:349:0x0ae1, B:350:0x0ae4, B:424:0x0b54, B:426:0x0b6f, B:427:0x0b80, B:429:0x0b84, B:431:0x0b90, B:432:0x0b98, B:434:0x0b9c, B:436:0x0ba2, B:437:0x0bb0, B:438:0x0bbb, B:446:0x0bfc, B:447:0x0c04, B:449:0x0c0a, B:453:0x0c1c, B:455:0x0c2a, B:457:0x0c2e, B:459:0x0c38, B:461:0x0c3c, B:465:0x0c52, B:467:0x0c68, B:524:0x09d4, B:526:0x09da, B:560:0x01ba, B:582:0x022a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x08d4 A[Catch: all -> 0x0ff0, TryCatch #9 {all -> 0x0ff0, blocks: (B:3:0x000f, B:20:0x00da, B:22:0x025b, B:24:0x025f, B:29:0x026b, B:30:0x0292, B:33:0x02aa, B:36:0x02d0, B:38:0x0307, B:43:0x031d, B:45:0x0327, B:48:0x0920, B:50:0x0351, B:52:0x0357, B:54:0x036d, B:56:0x037b, B:59:0x039b, B:61:0x03a1, B:63:0x03b1, B:65:0x03bf, B:67:0x03cf, B:69:0x03de, B:74:0x03e3, B:77:0x03f9, B:94:0x045d, B:97:0x0467, B:99:0x0475, B:101:0x04c3, B:102:0x0494, B:104:0x04a2, B:112:0x04d0, B:114:0x0505, B:115:0x0533, B:117:0x0567, B:118:0x056d, B:122:0x063d, B:123:0x0649, B:126:0x0653, B:130:0x0676, B:131:0x0665, B:139:0x067c, B:141:0x0688, B:143:0x0694, B:148:0x06e3, B:149:0x0700, B:151:0x0714, B:153:0x071e, B:156:0x0731, B:158:0x0745, B:160:0x0753, B:163:0x08aa, B:165:0x08b4, B:167:0x08ba, B:168:0x08d0, B:169:0x08d4, B:171:0x08e7, B:172:0x08fe, B:173:0x0906, B:178:0x0771, B:180:0x077f, B:183:0x0794, B:185:0x07a8, B:187:0x07b6, B:190:0x07c8, B:192:0x07e0, B:194:0x07ec, B:197:0x07ff, B:199:0x0813, B:201:0x085e, B:202:0x0865, B:204:0x086b, B:206:0x0875, B:207:0x087c, B:209:0x0882, B:211:0x088c, B:212:0x089c, B:216:0x06b5, B:220:0x06c9, B:222:0x06cf, B:224:0x06da, B:232:0x0579, B:234:0x05ae, B:235:0x05cb, B:237:0x05d1, B:239:0x05df, B:241:0x05f3, B:242:0x05e8, B:250:0x05fa, B:252:0x0601, B:253:0x0620, B:258:0x041b, B:261:0x0425, B:264:0x042f, B:274:0x093c, B:276:0x094a, B:278:0x0953, B:280:0x0985, B:281:0x095b, B:283:0x0964, B:285:0x096a, B:287:0x0976, B:289:0x0980, B:297:0x098c, B:298:0x0998, B:300:0x099e, B:306:0x09b7, B:307:0x09c2, B:311:0x09cf, B:312:0x09f6, B:314:0x0a15, B:316:0x0a23, B:318:0x0a29, B:320:0x0a33, B:321:0x0a65, B:323:0x0a6b, B:327:0x0a79, B:329:0x0a84, B:325:0x0a7e, B:332:0x0a87, B:333:0x0a96, B:335:0x0a9c, B:337:0x0aac, B:338:0x0ab3, B:340:0x0abf, B:342:0x0ac6, B:345:0x0ac9, B:347:0x0acf, B:349:0x0ae1, B:350:0x0ae4, B:424:0x0b54, B:426:0x0b6f, B:427:0x0b80, B:429:0x0b84, B:431:0x0b90, B:432:0x0b98, B:434:0x0b9c, B:436:0x0ba2, B:437:0x0bb0, B:438:0x0bbb, B:446:0x0bfc, B:447:0x0c04, B:449:0x0c0a, B:453:0x0c1c, B:455:0x0c2a, B:457:0x0c2e, B:459:0x0c38, B:461:0x0c3c, B:465:0x0c52, B:467:0x0c68, B:524:0x09d4, B:526:0x09da, B:560:0x01ba, B:582:0x022a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x08a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x025f A[Catch: all -> 0x0ff0, TryCatch #9 {all -> 0x0ff0, blocks: (B:3:0x000f, B:20:0x00da, B:22:0x025b, B:24:0x025f, B:29:0x026b, B:30:0x0292, B:33:0x02aa, B:36:0x02d0, B:38:0x0307, B:43:0x031d, B:45:0x0327, B:48:0x0920, B:50:0x0351, B:52:0x0357, B:54:0x036d, B:56:0x037b, B:59:0x039b, B:61:0x03a1, B:63:0x03b1, B:65:0x03bf, B:67:0x03cf, B:69:0x03de, B:74:0x03e3, B:77:0x03f9, B:94:0x045d, B:97:0x0467, B:99:0x0475, B:101:0x04c3, B:102:0x0494, B:104:0x04a2, B:112:0x04d0, B:114:0x0505, B:115:0x0533, B:117:0x0567, B:118:0x056d, B:122:0x063d, B:123:0x0649, B:126:0x0653, B:130:0x0676, B:131:0x0665, B:139:0x067c, B:141:0x0688, B:143:0x0694, B:148:0x06e3, B:149:0x0700, B:151:0x0714, B:153:0x071e, B:156:0x0731, B:158:0x0745, B:160:0x0753, B:163:0x08aa, B:165:0x08b4, B:167:0x08ba, B:168:0x08d0, B:169:0x08d4, B:171:0x08e7, B:172:0x08fe, B:173:0x0906, B:178:0x0771, B:180:0x077f, B:183:0x0794, B:185:0x07a8, B:187:0x07b6, B:190:0x07c8, B:192:0x07e0, B:194:0x07ec, B:197:0x07ff, B:199:0x0813, B:201:0x085e, B:202:0x0865, B:204:0x086b, B:206:0x0875, B:207:0x087c, B:209:0x0882, B:211:0x088c, B:212:0x089c, B:216:0x06b5, B:220:0x06c9, B:222:0x06cf, B:224:0x06da, B:232:0x0579, B:234:0x05ae, B:235:0x05cb, B:237:0x05d1, B:239:0x05df, B:241:0x05f3, B:242:0x05e8, B:250:0x05fa, B:252:0x0601, B:253:0x0620, B:258:0x041b, B:261:0x0425, B:264:0x042f, B:274:0x093c, B:276:0x094a, B:278:0x0953, B:280:0x0985, B:281:0x095b, B:283:0x0964, B:285:0x096a, B:287:0x0976, B:289:0x0980, B:297:0x098c, B:298:0x0998, B:300:0x099e, B:306:0x09b7, B:307:0x09c2, B:311:0x09cf, B:312:0x09f6, B:314:0x0a15, B:316:0x0a23, B:318:0x0a29, B:320:0x0a33, B:321:0x0a65, B:323:0x0a6b, B:327:0x0a79, B:329:0x0a84, B:325:0x0a7e, B:332:0x0a87, B:333:0x0a96, B:335:0x0a9c, B:337:0x0aac, B:338:0x0ab3, B:340:0x0abf, B:342:0x0ac6, B:345:0x0ac9, B:347:0x0acf, B:349:0x0ae1, B:350:0x0ae4, B:424:0x0b54, B:426:0x0b6f, B:427:0x0b80, B:429:0x0b84, B:431:0x0b90, B:432:0x0b98, B:434:0x0b9c, B:436:0x0ba2, B:437:0x0bb0, B:438:0x0bbb, B:446:0x0bfc, B:447:0x0c04, B:449:0x0c0a, B:453:0x0c1c, B:455:0x0c2a, B:457:0x0c2e, B:459:0x0c38, B:461:0x0c3c, B:465:0x0c52, B:467:0x0c68, B:524:0x09d4, B:526:0x09da, B:560:0x01ba, B:582:0x022a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x026b A[Catch: all -> 0x0ff0, TryCatch #9 {all -> 0x0ff0, blocks: (B:3:0x000f, B:20:0x00da, B:22:0x025b, B:24:0x025f, B:29:0x026b, B:30:0x0292, B:33:0x02aa, B:36:0x02d0, B:38:0x0307, B:43:0x031d, B:45:0x0327, B:48:0x0920, B:50:0x0351, B:52:0x0357, B:54:0x036d, B:56:0x037b, B:59:0x039b, B:61:0x03a1, B:63:0x03b1, B:65:0x03bf, B:67:0x03cf, B:69:0x03de, B:74:0x03e3, B:77:0x03f9, B:94:0x045d, B:97:0x0467, B:99:0x0475, B:101:0x04c3, B:102:0x0494, B:104:0x04a2, B:112:0x04d0, B:114:0x0505, B:115:0x0533, B:117:0x0567, B:118:0x056d, B:122:0x063d, B:123:0x0649, B:126:0x0653, B:130:0x0676, B:131:0x0665, B:139:0x067c, B:141:0x0688, B:143:0x0694, B:148:0x06e3, B:149:0x0700, B:151:0x0714, B:153:0x071e, B:156:0x0731, B:158:0x0745, B:160:0x0753, B:163:0x08aa, B:165:0x08b4, B:167:0x08ba, B:168:0x08d0, B:169:0x08d4, B:171:0x08e7, B:172:0x08fe, B:173:0x0906, B:178:0x0771, B:180:0x077f, B:183:0x0794, B:185:0x07a8, B:187:0x07b6, B:190:0x07c8, B:192:0x07e0, B:194:0x07ec, B:197:0x07ff, B:199:0x0813, B:201:0x085e, B:202:0x0865, B:204:0x086b, B:206:0x0875, B:207:0x087c, B:209:0x0882, B:211:0x088c, B:212:0x089c, B:216:0x06b5, B:220:0x06c9, B:222:0x06cf, B:224:0x06da, B:232:0x0579, B:234:0x05ae, B:235:0x05cb, B:237:0x05d1, B:239:0x05df, B:241:0x05f3, B:242:0x05e8, B:250:0x05fa, B:252:0x0601, B:253:0x0620, B:258:0x041b, B:261:0x0425, B:264:0x042f, B:274:0x093c, B:276:0x094a, B:278:0x0953, B:280:0x0985, B:281:0x095b, B:283:0x0964, B:285:0x096a, B:287:0x0976, B:289:0x0980, B:297:0x098c, B:298:0x0998, B:300:0x099e, B:306:0x09b7, B:307:0x09c2, B:311:0x09cf, B:312:0x09f6, B:314:0x0a15, B:316:0x0a23, B:318:0x0a29, B:320:0x0a33, B:321:0x0a65, B:323:0x0a6b, B:327:0x0a79, B:329:0x0a84, B:325:0x0a7e, B:332:0x0a87, B:333:0x0a96, B:335:0x0a9c, B:337:0x0aac, B:338:0x0ab3, B:340:0x0abf, B:342:0x0ac6, B:345:0x0ac9, B:347:0x0acf, B:349:0x0ae1, B:350:0x0ae4, B:424:0x0b54, B:426:0x0b6f, B:427:0x0b80, B:429:0x0b84, B:431:0x0b90, B:432:0x0b98, B:434:0x0b9c, B:436:0x0ba2, B:437:0x0bb0, B:438:0x0bbb, B:446:0x0bfc, B:447:0x0c04, B:449:0x0c0a, B:453:0x0c1c, B:455:0x0c2a, B:457:0x0c2e, B:459:0x0c38, B:461:0x0c3c, B:465:0x0c52, B:467:0x0c68, B:524:0x09d4, B:526:0x09da, B:560:0x01ba, B:582:0x022a), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0fd3  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0111 A[Catch: SQLiteException -> 0x0231, all -> 0x0fe4, TryCatch #1 {all -> 0x0fe4, blocks: (B:17:0x0079, B:537:0x0080, B:539:0x0084, B:540:0x00e9, B:542:0x0111, B:544:0x0123, B:546:0x0127, B:547:0x0139, B:549:0x013f, B:551:0x014b, B:552:0x0155, B:554:0x0161, B:555:0x0187, B:580:0x0247, B:590:0x0178, B:595:0x0219, B:613:0x00d4, B:615:0x00e1), top: B:6:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:543:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0447  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean G(java.lang.String r43, long r44) {
        /*
            Method dump skipped, instructions count: 4091
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.G(java.lang.String, long):boolean");
    }

    private final boolean H() {
        p0();
        i0();
        return a0().J0() || !TextUtils.isEmpty(a0().z());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void I() {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.I():void");
    }

    private final void J() {
        p0();
        if (this.f6017q || this.f6018r || this.f6019s) {
            this.f6010j.h().N().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f6017q), Boolean.valueOf(this.f6018r), Boolean.valueOf(this.f6019s));
            return;
        }
        this.f6010j.h().N().a("Stopping uploading service(s)");
        List<Runnable> list = this.f6014n;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f6014n.clear();
    }

    private final boolean K() {
        t3 I;
        String str;
        FileLock fileLock;
        p0();
        if (this.f6010j.a().t(s.f6409i0) && (fileLock = this.f6020t) != null && fileLock.isValid()) {
            this.f6010j.h().N().a("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.f6010j.i().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f6021u = channel;
            FileLock tryLock = channel.tryLock();
            this.f6020t = tryLock;
            if (tryLock != null) {
                this.f6010j.h().N().a("Storage concurrent access okay");
                return true;
            }
            this.f6010j.h().F().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e10) {
            e = e10;
            I = this.f6010j.h().F();
            str = "Failed to acquire storage lock";
            I.b(str, e);
            return false;
        } catch (IOException e11) {
            e = e11;
            I = this.f6010j.h().F();
            str = "Failed to access storage lock file";
            I.b(str, e);
            return false;
        } catch (OverlappingFileLockException e12) {
            e = e12;
            I = this.f6010j.h().I();
            str = "Storage lock already acquired";
            I.b(str, e);
            return false;
        }
    }

    private final v9 M(String str) {
        b4 m02 = a0().m0(str);
        if (m02 == null || TextUtils.isEmpty(m02.T())) {
            this.f6010j.h().M().b("No app data available; dropping", str);
            return null;
        }
        Boolean N = N(m02);
        if (N != null && !N.booleanValue()) {
            this.f6010j.h().F().b("App version does not match; dropping. appId", r3.x(str));
            return null;
        }
        return new v9(str, m02.A(), m02.T(), m02.V(), m02.X(), m02.Z(), m02.b0(), (String) null, m02.e0(), false, m02.M(), m02.k(), 0L, 0, m02.l(), m02.m(), false, m02.D(), m02.n(), m02.d0(), m02.o(), (md.a() && this.f6010j.a().D(str, s.f6411j0)) ? m02.G() : null, (bc.a() && this.f6010j.a().t(s.J0)) ? j(str).d() : "");
    }

    private final Boolean N(b4 b4Var) {
        try {
            if (b4Var.V() != -2147483648L) {
                if (b4Var.V() == i2.c.a(this.f6010j.i()).e(b4Var.t(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = i2.c.a(this.f6010j.i()).e(b4Var.t(), 0).versionName;
                if (b4Var.T() != null && b4Var.T().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void O(d1.a aVar, d1.a aVar2) {
        b2.p.a("_e".equals(aVar.K()));
        e0();
        com.google.android.gms.internal.measurement.f1 B = k9.B((com.google.android.gms.internal.measurement.d1) ((com.google.android.gms.internal.measurement.l7) aVar.g()), "_et");
        if (!B.X() || B.Y() <= 0) {
            return;
        }
        long Y = B.Y();
        e0();
        com.google.android.gms.internal.measurement.f1 B2 = k9.B((com.google.android.gms.internal.measurement.d1) ((com.google.android.gms.internal.measurement.l7) aVar2.g()), "_et");
        if (B2 != null && B2.Y() > 0) {
            Y += B2.Y();
        }
        e0();
        k9.K(aVar2, "_et", Long.valueOf(Y));
        e0();
        k9.K(aVar, "_fr", 1L);
    }

    private final void P(q qVar, v9 v9Var) {
        if (nd.a() && this.f6010j.a().t(s.A0)) {
            v3 b10 = v3.b(qVar);
            this.f6010j.G().M(b10.f6547d, a0().E0(v9Var.f6560f));
            this.f6010j.G().V(b10, this.f6010j.a().o(v9Var.f6560f));
            qVar = b10.a();
        }
        if (this.f6010j.a().t(s.f6401e0) && "_cmp".equals(qVar.f6333f) && "referrer API v2".equals(qVar.f6334g.v("_cis"))) {
            String v10 = qVar.f6334g.v("gclid");
            if (!TextUtils.isEmpty(v10)) {
                w(new n9("_lgclid", qVar.f6336i, v10, "auto"), v9Var);
            }
        }
        q(qVar, v9Var);
    }

    private static void Q(b9 b9Var) {
        if (b9Var == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (b9Var.t()) {
            return;
        }
        String valueOf = String.valueOf(b9Var.getClass());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
        sb2.append("Component not initialized: ");
        sb2.append(valueOf);
        throw new IllegalStateException(sb2.toString());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:74|(1:76)(1:304)|77|(2:79|(1:81)(6:82|83|84|(1:86)|87|(0)))|296|297|298|299|83|84|(0)|87|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0916, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x027c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x027e, code lost:
    
        r7.h().F().c("Error pruning currencies. appId", com.google.android.gms.measurement.internal.r3.x(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0665 A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0677 A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0792 A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x079f A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x07cb A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x089f A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x08b7 A[Catch: all -> 0x09a7, TRY_LEAVE, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0900 A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0958 A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0710 A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x072a A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0172 A[Catch: all -> 0x09a7, TRY_LEAVE, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02b4 A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ed A[Catch: all -> 0x09a7, TRY_LEAVE, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x034c A[Catch: all -> 0x09a7, TryCatch #0 {all -> 0x09a7, blocks: (B:42:0x013b, B:45:0x014a, B:47:0x0154, B:51:0x0160, B:57:0x0172, B:60:0x017e, B:62:0x0195, B:67:0x01ae, B:70:0x01e3, B:72:0x01e9, B:74:0x01f7, B:76:0x01ff, B:77:0x0209, B:79:0x0214, B:82:0x021b, B:84:0x02aa, B:86:0x02b4, B:89:0x02ed, B:92:0x02ff, B:94:0x034c, B:96:0x0351, B:97:0x036a, B:101:0x037b, B:103:0x038f, B:105:0x0394, B:106:0x03ad, B:110:0x03d2, B:114:0x03f7, B:115:0x0410, B:118:0x041f, B:121:0x0442, B:122:0x045e, B:124:0x0468, B:126:0x0474, B:128:0x047a, B:129:0x0485, B:131:0x0491, B:132:0x04a8, B:134:0x04cf, B:137:0x04e8, B:140:0x052e, B:141:0x0556, B:143:0x0590, B:144:0x0595, B:146:0x059d, B:147:0x05a2, B:149:0x05aa, B:150:0x05af, B:152:0x05b8, B:153:0x05bc, B:155:0x05c9, B:156:0x05ce, B:158:0x05d4, B:160:0x05e2, B:161:0x05f9, B:163:0x05ff, B:165:0x060f, B:167:0x0619, B:169:0x0621, B:170:0x0626, B:172:0x0630, B:174:0x063a, B:176:0x0642, B:177:0x0644, B:178:0x065d, B:180:0x0665, B:181:0x0668, B:183:0x0677, B:184:0x067a, B:186:0x0690, B:188:0x069e, B:190:0x074a, B:192:0x0792, B:193:0x0797, B:195:0x079f, B:197:0x07a5, B:198:0x07b1, B:200:0x07ba, B:201:0x07bf, B:203:0x07cb, B:205:0x07da, B:207:0x07e8, B:208:0x07ec, B:209:0x07f5, B:211:0x0805, B:213:0x0813, B:215:0x0824, B:217:0x0859, B:218:0x085e, B:219:0x0819, B:220:0x07f0, B:221:0x086a, B:223:0x0870, B:225:0x087e, B:227:0x0895, B:229:0x089f, B:230:0x08a6, B:231:0x08b1, B:233:0x08b7, B:236:0x08e8, B:237:0x08f8, B:239:0x0900, B:240:0x0904, B:242:0x090a, B:246:0x0952, B:248:0x0958, B:249:0x0974, B:254:0x0918, B:256:0x093d, B:262:0x095c, B:263:0x0884, B:265:0x088e, B:266:0x06a4, B:268:0x06ae, B:270:0x06b8, B:272:0x06bc, B:274:0x06c7, B:275:0x06d2, B:277:0x06e4, B:279:0x06e8, B:281:0x06ee, B:283:0x06fe, B:285:0x0710, B:286:0x0747, B:287:0x072a, B:289:0x0730, B:290:0x0648, B:292:0x0652, B:294:0x065a, B:295:0x0548, B:296:0x0243, B:298:0x0261, B:299:0x028f, B:303:0x027e, B:304:0x0204, B:306:0x01bc, B:307:0x01d9), top: B:41:0x013b, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void X(com.google.android.gms.measurement.internal.q r27, com.google.android.gms.measurement.internal.v9 r28) {
        /*
            Method dump skipped, instructions count: 2481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.X(com.google.android.gms.measurement.internal.q, com.google.android.gms.measurement.internal.v9):void");
    }

    private final int a(FileChannel fileChannel) {
        p0();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f6010j.h().F().a("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            }
            if (read != -1) {
                this.f6010j.h().I().b("Unexpected data length. Bytes read", Integer.valueOf(read));
            }
            return 0;
        } catch (IOException e10) {
            this.f6010j.h().F().b("Failed to read from channel", e10);
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
    
        if (r0.o() != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.measurement.internal.b4 b(com.google.android.gms.measurement.internal.v9 r9, com.google.android.gms.measurement.internal.b4 r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.b(com.google.android.gms.measurement.internal.v9, com.google.android.gms.measurement.internal.b4, java.lang.String):com.google.android.gms.measurement.internal.b4");
    }

    private final boolean b0(v9 v9Var) {
        return (md.a() && this.f6010j.a().D(v9Var.f6560f, s.f6411j0)) ? (TextUtils.isEmpty(v9Var.f6561g) && TextUtils.isEmpty(v9Var.A) && TextUtils.isEmpty(v9Var.f6577w)) ? false : true : (TextUtils.isEmpty(v9Var.f6561g) && TextUtils.isEmpty(v9Var.f6577w)) ? false : true;
    }

    public static e9 d(Context context) {
        b2.p.k(context);
        b2.p.k(context.getApplicationContext());
        if (A == null) {
            synchronized (e9.class) {
                if (A == null) {
                    A = new e9(new l9(context));
                }
            }
        }
        return A;
    }

    private final String g(v2.a aVar) {
        if (bc.a() && this.f6010j.a().t(s.J0) && !aVar.q()) {
            return null;
        }
        return r0();
    }

    private static void m(d1.a aVar, int i10, String str) {
        List<com.google.android.gms.internal.measurement.f1> E = aVar.E();
        for (int i11 = 0; i11 < E.size(); i11++) {
            if ("_err".equals(E.get(i11).O())) {
                return;
            }
        }
        aVar.z((com.google.android.gms.internal.measurement.f1) ((com.google.android.gms.internal.measurement.l7) com.google.android.gms.internal.measurement.f1.f0().A("_err").x(Long.valueOf(i10).longValue()).g())).z((com.google.android.gms.internal.measurement.f1) ((com.google.android.gms.internal.measurement.l7) com.google.android.gms.internal.measurement.f1.f0().A("_ev").C(str).g()));
    }

    private final c4 n0() {
        c4 c4Var = this.f6004d;
        if (c4Var != null) {
            return c4Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private static void o(d1.a aVar, String str) {
        List<com.google.android.gms.internal.measurement.f1> E = aVar.E();
        for (int i10 = 0; i10 < E.size(); i10++) {
            if (str.equals(E.get(i10).O())) {
                aVar.G(i10);
                return;
            }
        }
    }

    private final a9 o0() {
        Q(this.f6005e);
        return this.f6005e;
    }

    private final void p(h1.a aVar, long j10, boolean z10) {
        String str = z10 ? "_se" : "_lte";
        p9 r02 = a0().r0(aVar.x0(), str);
        p9 p9Var = (r02 == null || r02.f6332e == null) ? new p9(aVar.x0(), "auto", str, this.f6010j.f().a(), Long.valueOf(j10)) : new p9(aVar.x0(), "auto", str, this.f6010j.f().a(), Long.valueOf(((Long) r02.f6332e).longValue() + j10));
        com.google.android.gms.internal.measurement.l1 l1Var = (com.google.android.gms.internal.measurement.l1) ((com.google.android.gms.internal.measurement.l7) com.google.android.gms.internal.measurement.l1.Z().y(str).x(this.f6010j.f().a()).A(((Long) p9Var.f6332e).longValue()).g());
        boolean z11 = false;
        int x10 = k9.x(aVar, str);
        if (x10 >= 0) {
            aVar.x(x10, l1Var);
            z11 = true;
        }
        if (!z11) {
            aVar.C(l1Var);
        }
        if (j10 > 0) {
            a0().W(p9Var);
            this.f6010j.h().N().c("Updated engagement user property. scope, value", z10 ? "session-scoped" : "lifetime", p9Var.f6332e);
        }
    }

    private final void p0() {
        this.f6010j.e().c();
    }

    private final long q0() {
        long a10 = this.f6010j.f().a();
        e4 x10 = this.f6010j.x();
        x10.q();
        x10.c();
        long a11 = x10.f5962i.a();
        if (a11 == 0) {
            a11 = 1 + x10.k().H0().nextInt(86400000);
            x10.f5962i.b(a11);
        }
        return ((((a10 + a11) / 1000) / 60) / 60) / 24;
    }

    @Deprecated
    private final String r0() {
        byte[] bArr = new byte[16];
        this.f6010j.G().H0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    private final void s(b4 b4Var) {
        l.a aVar;
        p0();
        if (md.a() && this.f6010j.a().D(b4Var.t(), s.f6411j0)) {
            if (TextUtils.isEmpty(b4Var.A()) && TextUtils.isEmpty(b4Var.G()) && TextUtils.isEmpty(b4Var.D())) {
                B(b4Var.t(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(b4Var.A()) && TextUtils.isEmpty(b4Var.D())) {
            B(b4Var.t(), 204, null, null, null);
            return;
        }
        String r10 = this.f6010j.a().r(b4Var);
        try {
            URL url = new URL(r10);
            this.f6010j.h().N().b("Fetching remote configuration", b4Var.t());
            com.google.android.gms.internal.measurement.x0 x10 = W().x(b4Var.t());
            String C = W().C(b4Var.t());
            if (x10 == null || TextUtils.isEmpty(C)) {
                aVar = null;
            } else {
                l.a aVar2 = new l.a();
                aVar2.put("If-Modified-Since", C);
                aVar = aVar2;
            }
            this.f6017q = true;
            y3 Y = Y();
            String t10 = b4Var.t();
            f9 f9Var = new f9(this);
            Y.c();
            Y.u();
            b2.p.k(url);
            b2.p.k(f9Var);
            Y.e().F(new d4(Y, t10, url, null, aVar, f9Var));
        } catch (MalformedURLException unused) {
            this.f6010j.h().F().c("Failed to parse config URL. Not fetching. appId", r3.x(b4Var.t()), r10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(l9 l9Var) {
        this.f6010j.e().c();
        f fVar = new f(this);
        fVar.v();
        this.f6003c = fVar;
        this.f6010j.a().s(this.f6001a);
        k8 k8Var = new k8(this);
        k8Var.v();
        this.f6009i = k8Var;
        z9 z9Var = new z9(this);
        z9Var.v();
        this.f6006f = z9Var;
        a7 a7Var = new a7(this);
        a7Var.v();
        this.f6008h = a7Var;
        a9 a9Var = new a9(this);
        a9Var.v();
        this.f6005e = a9Var;
        this.f6004d = new c4(this);
        if (this.f6015o != this.f6016p) {
            this.f6010j.h().F().c("Not all upload components initialized", Integer.valueOf(this.f6015o), Integer.valueOf(this.f6016p));
        }
        this.f6011k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void A(Runnable runnable) {
        p0();
        if (this.f6014n == null) {
            this.f6014n = new ArrayList();
        }
        this.f6014n.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
    
        r6.f6010j.x().f5960g.b(r6.f6010j.f().a());
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0132 A[Catch: all -> 0x0179, TryCatch #1 {all -> 0x0179, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x016d, B:24:0x0061, B:31:0x00b0, B:32:0x00c5, B:35:0x00cd, B:37:0x00d9, B:39:0x00df, B:43:0x00ec, B:46:0x011c, B:48:0x0132, B:49:0x015a, B:51:0x0164, B:53:0x016a, B:54:0x0142, B:55:0x0103, B:57:0x010d), top: B:4:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[Catch: all -> 0x0179, TryCatch #1 {all -> 0x0179, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x016d, B:24:0x0061, B:31:0x00b0, B:32:0x00c5, B:35:0x00cd, B:37:0x00d9, B:39:0x00df, B:43:0x00ec, B:46:0x011c, B:48:0x0132, B:49:0x015a, B:51:0x0164, B:53:0x016a, B:54:0x0142, B:55:0x0103, B:57:0x010d), top: B:4:0x0029, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.B(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(String str, v2.a aVar) {
        if (bc.a() && this.f6010j.a().t(s.J0)) {
            p0();
            i0();
            this.f6025y.put(str, aVar);
            f a02 = a0();
            if (bc.a() && a02.m().t(s.J0)) {
                b2.p.k(str);
                b2.p.k(aVar);
                a02.c();
                a02.u();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", aVar.d());
                try {
                    if (a02.y().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        a02.h().F().b("Failed to insert/update consent setting (got -1). appId", r3.x(str));
                    }
                } catch (SQLiteException e10) {
                    a02.h().F().c("Error storing consent setting. appId, error", r3.x(str), e10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(boolean z10) {
        I();
    }

    public final c L() {
        return this.f6010j.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void R(n9 n9Var, v9 v9Var) {
        p0();
        i0();
        if (b0(v9Var)) {
            if (!v9Var.f6567m) {
                V(v9Var);
                return;
            }
            if ("_npa".equals(n9Var.f6259g) && v9Var.f6578x != null) {
                this.f6010j.h().M().a("Falling back to manifest metadata value for ad personalization");
                w(new n9("_npa", this.f6010j.f().a(), Long.valueOf(v9Var.f6578x.booleanValue() ? 1L : 0L), "auto"), v9Var);
                return;
            }
            this.f6010j.h().M().b("Removing user property", this.f6010j.H().A(n9Var.f6259g));
            a0().w0();
            try {
                V(v9Var);
                a0().o0(v9Var.f6560f, n9Var.f6259g);
                a0().x();
                this.f6010j.h().M().b("User property removed", this.f6010j.H().A(n9Var.f6259g));
            } finally {
                a0().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:94|95|(2:97|(8:99|(4:101|(3:103|(1:105)|107)(1:125)|106|107)(1:126)|108|(1:110)(1:124)|111|112|113|(4:115|(1:117)|118|(1:120))))|127|112|113|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x038c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x038d, code lost:
    
        r21.f6010j.h().F().c("Application info is null, first open report might be inaccurate. appId", com.google.android.gms.measurement.internal.r3.x(r22.f6560f), r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03a5 A[Catch: all -> 0x04a3, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0479 A[Catch: all -> 0x04a3, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011b A[Catch: all -> 0x04a3, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d2 A[Catch: all -> 0x04a3, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x020c A[Catch: all -> 0x04a3, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0235 A[Catch: all -> 0x04a3, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0251 A[Catch: all -> 0x04a3, TRY_LEAVE, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0443 A[Catch: all -> 0x04a3, TryCatch #0 {all -> 0x04a3, blocks: (B:25:0x009f, B:27:0x00ad, B:31:0x010f, B:33:0x011b, B:35:0x0132, B:37:0x015a, B:39:0x01ab, B:43:0x01be, B:45:0x01d2, B:47:0x01dd, B:50:0x01ec, B:52:0x01f4, B:54:0x01fa, B:57:0x0209, B:59:0x020c, B:60:0x0230, B:62:0x0235, B:63:0x023d, B:65:0x0251, B:68:0x0265, B:70:0x02b9, B:71:0x02c1, B:73:0x02c5, B:74:0x02c8, B:76:0x02e9, B:80:0x03c1, B:81:0x03c4, B:82:0x03d5, B:83:0x0433, B:85:0x0443, B:87:0x045d, B:88:0x0464, B:89:0x0475, B:90:0x0494, B:95:0x0302, B:97:0x032d, B:99:0x0335, B:101:0x033d, B:106:0x0353, B:108:0x035d, B:111:0x0368, B:113:0x037a, B:123:0x038d, B:115:0x03a5, B:117:0x03ab, B:118:0x03b0, B:120:0x03b6, B:130:0x0315, B:134:0x03dc, B:136:0x0412, B:137:0x041a, B:139:0x041e, B:140:0x0421, B:142:0x0479, B:144:0x047d, B:147:0x0245, B:153:0x00bc, B:155:0x00c0, B:158:0x00d1, B:160:0x00eb, B:162:0x00f5, B:166:0x00ff), top: B:24:0x009f, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(com.google.android.gms.measurement.internal.v9 r22) {
        /*
            Method dump skipped, instructions count: 1196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.S(com.google.android.gms.measurement.internal.v9):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(ha haVar) {
        v9 M = M(haVar.f6091f);
        if (M != null) {
            U(haVar, M);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U(ha haVar, v9 v9Var) {
        b2.p.k(haVar);
        b2.p.g(haVar.f6091f);
        b2.p.k(haVar.f6093h);
        b2.p.g(haVar.f6093h.f6259g);
        p0();
        i0();
        if (b0(v9Var)) {
            if (!v9Var.f6567m) {
                V(v9Var);
                return;
            }
            a0().w0();
            try {
                V(v9Var);
                ha s02 = a0().s0(haVar.f6091f, haVar.f6093h.f6259g);
                if (s02 != null) {
                    this.f6010j.h().M().c("Removing conditional user property", haVar.f6091f, this.f6010j.H().A(haVar.f6093h.f6259g));
                    a0().u0(haVar.f6091f, haVar.f6093h.f6259g);
                    if (s02.f6095j) {
                        a0().o0(haVar.f6091f, haVar.f6093h.f6259g);
                    }
                    q qVar = haVar.f6101p;
                    if (qVar != null) {
                        p pVar = qVar.f6334g;
                        Bundle s10 = pVar != null ? pVar.s() : null;
                        o9 G = this.f6010j.G();
                        String str = haVar.f6091f;
                        q qVar2 = haVar.f6101p;
                        X(G.F(str, qVar2.f6333f, s10, s02.f6092g, qVar2.f6336i, true, false, db.a() && this.f6010j.a().t(s.M0)), v9Var);
                    }
                } else {
                    this.f6010j.h().I().c("Conditional user property doesn't exist", r3.x(haVar.f6091f), this.f6010j.H().A(haVar.f6093h.f6259g));
                }
                a0().x();
            } finally {
                a0().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a8, code lost:
    
        if (r1.o() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0121, code lost:
    
        if (r1.q() != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.b4 V(com.google.android.gms.measurement.internal.v9 r7) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.V(com.google.android.gms.measurement.internal.v9):com.google.android.gms.measurement.internal.b4");
    }

    public final p4 W() {
        Q(this.f6001a);
        return this.f6001a;
    }

    public final y3 Y() {
        Q(this.f6002b);
        return this.f6002b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String Z(v9 v9Var) {
        try {
            return (String) this.f6010j.e().w(new i9(this, v9Var)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            this.f6010j.h().F().c("Failed to get app instance id. appId", r3.x(v9Var.f6560f), e10);
            return null;
        }
    }

    public final f a0() {
        Q(this.f6003c);
        return this.f6003c;
    }

    public final z9 c0() {
        Q(this.f6006f);
        return this.f6006f;
    }

    public final a7 d0() {
        Q(this.f6008h);
        return this.f6008h;
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final q4 e() {
        return this.f6010j.e();
    }

    public final k9 e0() {
        Q(this.f6007g);
        return this.f6007g;
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final g2.e f() {
        return this.f6010j.f();
    }

    public final k8 f0() {
        return this.f6009i;
    }

    public final p3 g0() {
        return this.f6010j.H();
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final r3 h() {
        return this.f6010j.h();
    }

    public final o9 h0() {
        return this.f6010j.G();
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final Context i() {
        return this.f6010j.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i0() {
        if (!this.f6011k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final v2.a j(String str) {
        v2.a aVar = v2.a.f14619c;
        if (!bc.a() || !this.f6010j.a().t(s.J0)) {
            return aVar;
        }
        p0();
        i0();
        v2.a aVar2 = this.f6025y.get(str);
        if (aVar2 != null) {
            return aVar2;
        }
        v2.a F0 = a0().F0(str);
        if (F0 != null) {
            aVar = F0;
        }
        C(str, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02e4 A[Catch: MalformedURLException -> 0x0356, all -> 0x038f, TryCatch #0 {MalformedURLException -> 0x0356, blocks: (B:96:0x02cf, B:99:0x02dd, B:101:0x02e4, B:102:0x02fd, B:104:0x030c, B:105:0x0314, B:107:0x02f4), top: B:95:0x02cf, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x030c A[Catch: MalformedURLException -> 0x0356, all -> 0x038f, TryCatch #0 {MalformedURLException -> 0x0356, blocks: (B:96:0x02cf, B:99:0x02dd, B:101:0x02e4, B:102:0x02fd, B:104:0x030c, B:105:0x0314, B:107:0x02f4), top: B:95:0x02cf, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02f4 A[Catch: MalformedURLException -> 0x0356, all -> 0x038f, TryCatch #0 {MalformedURLException -> 0x0356, blocks: (B:96:0x02cf, B:99:0x02dd, B:101:0x02e4, B:102:0x02fd, B:104:0x030c, B:105:0x0314, B:107:0x02f4), top: B:95:0x02cf, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0211 A[Catch: all -> 0x038f, TryCatch #1 {all -> 0x038f, blocks: (B:3:0x000c, B:5:0x0018, B:6:0x0024, B:10:0x002d, B:12:0x0033, B:13:0x0040, B:15:0x0048, B:16:0x004c, B:20:0x0058, B:21:0x0065, B:23:0x006f, B:24:0x007f, B:26:0x009f, B:28:0x00a5, B:30:0x00a8, B:32:0x00b8, B:33:0x00d1, B:35:0x00e1, B:37:0x00e7, B:38:0x00f1, B:40:0x011b, B:42:0x0121, B:44:0x012f, B:46:0x018c, B:48:0x01a9, B:50:0x01af, B:52:0x01bd, B:55:0x01ca, B:57:0x01d0, B:59:0x01de, B:63:0x01ec, B:65:0x01f2, B:67:0x0200, B:73:0x0211, B:75:0x0242, B:76:0x0245, B:78:0x024b, B:81:0x025b, B:83:0x0263, B:84:0x0266, B:86:0x0274, B:88:0x028b, B:91:0x0296, B:93:0x02a5, B:94:0x02b7, B:96:0x02cf, B:99:0x02dd, B:101:0x02e4, B:102:0x02fd, B:104:0x030c, B:105:0x0314, B:107:0x02f4, B:109:0x0356, B:114:0x0139, B:115:0x013d, B:117:0x0143, B:120:0x0157, B:123:0x0160, B:125:0x0166, B:127:0x017a, B:130:0x0184, B:132:0x0189, B:138:0x036b, B:140:0x0380, B:142:0x038a), top: B:2:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a5 A[Catch: all -> 0x038f, TryCatch #1 {all -> 0x038f, blocks: (B:3:0x000c, B:5:0x0018, B:6:0x0024, B:10:0x002d, B:12:0x0033, B:13:0x0040, B:15:0x0048, B:16:0x004c, B:20:0x0058, B:21:0x0065, B:23:0x006f, B:24:0x007f, B:26:0x009f, B:28:0x00a5, B:30:0x00a8, B:32:0x00b8, B:33:0x00d1, B:35:0x00e1, B:37:0x00e7, B:38:0x00f1, B:40:0x011b, B:42:0x0121, B:44:0x012f, B:46:0x018c, B:48:0x01a9, B:50:0x01af, B:52:0x01bd, B:55:0x01ca, B:57:0x01d0, B:59:0x01de, B:63:0x01ec, B:65:0x01f2, B:67:0x0200, B:73:0x0211, B:75:0x0242, B:76:0x0245, B:78:0x024b, B:81:0x025b, B:83:0x0263, B:84:0x0266, B:86:0x0274, B:88:0x028b, B:91:0x0296, B:93:0x02a5, B:94:0x02b7, B:96:0x02cf, B:99:0x02dd, B:101:0x02e4, B:102:0x02fd, B:104:0x030c, B:105:0x0314, B:107:0x02f4, B:109:0x0356, B:114:0x0139, B:115:0x013d, B:117:0x0143, B:120:0x0157, B:123:0x0160, B:125:0x0166, B:127:0x017a, B:130:0x0184, B:132:0x0189, B:138:0x036b, B:140:0x0380, B:142:0x038a), top: B:2:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0() {
        /*
            Method dump skipped, instructions count: 918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.j0():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        this.f6010j.e().c();
        a0().G0();
        if (this.f6010j.x().f5958e.a() == 0) {
            this.f6010j.x().f5958e.b(this.f6010j.f().a());
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k0() {
        t3 F;
        Integer valueOf;
        Integer valueOf2;
        String str;
        p0();
        i0();
        if (this.f6012l) {
            return;
        }
        this.f6012l = true;
        if (K()) {
            int a10 = a(this.f6021u);
            int G = this.f6010j.R().G();
            p0();
            if (a10 > G) {
                F = this.f6010j.h().F();
                valueOf = Integer.valueOf(a10);
                valueOf2 = Integer.valueOf(G);
                str = "Panic: can't downgrade version. Previous, current version";
            } else {
                if (a10 >= G) {
                    return;
                }
                if (E(G, this.f6021u)) {
                    F = this.f6010j.h().N();
                    valueOf = Integer.valueOf(a10);
                    valueOf2 = Integer.valueOf(G);
                    str = "Storage version upgraded. Previous, current version";
                } else {
                    F = this.f6010j.h().F();
                    valueOf = Integer.valueOf(a10);
                    valueOf2 = Integer.valueOf(G);
                    str = "Storage version upgrade failed. Previous, current version";
                }
            }
            F.c(str, valueOf, valueOf2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0156, code lost:
    
        r8.f6010j.x().f5960g.b(r8.f6010j.f().a());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r9, java.lang.Throwable r10, byte[] r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e9.l(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l0() {
        this.f6016p++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final t4 m0() {
        return this.f6010j;
    }

    @Override // com.google.android.gms.measurement.internal.s5
    public final ea n() {
        return this.f6010j.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(q qVar, v9 v9Var) {
        List<ha> O;
        List<ha> O2;
        List<ha> O3;
        t3 F;
        String str;
        Object x10;
        String A2;
        Object obj;
        q qVar2 = qVar;
        b2.p.k(v9Var);
        b2.p.g(v9Var.f6560f);
        p0();
        i0();
        String str2 = v9Var.f6560f;
        long j10 = qVar2.f6336i;
        e0();
        if (k9.U(qVar, v9Var)) {
            if (!v9Var.f6567m) {
                V(v9Var);
                return;
            }
            List<String> list = v9Var.f6580z;
            if (list != null) {
                if (!list.contains(qVar2.f6333f)) {
                    this.f6010j.h().M().d("Dropping non-safelisted event. appId, event name, origin", str2, qVar2.f6333f, qVar2.f6335h);
                    return;
                } else {
                    Bundle s10 = qVar2.f6334g.s();
                    s10.putLong("ga_safelisted", 1L);
                    qVar2 = new q(qVar2.f6333f, new p(s10), qVar2.f6335h, qVar2.f6336i);
                }
            }
            a0().w0();
            try {
                f a02 = a0();
                b2.p.g(str2);
                a02.c();
                a02.u();
                if (j10 < 0) {
                    a02.h().I().c("Invalid time querying timed out conditional properties", r3.x(str2), Long.valueOf(j10));
                    O = Collections.emptyList();
                } else {
                    O = a02.O("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
                }
                for (ha haVar : O) {
                    if (haVar != null) {
                        this.f6010j.h().N().d("User property timed out", haVar.f6091f, this.f6010j.H().A(haVar.f6093h.f6259g), haVar.f6093h.g());
                        if (haVar.f6097l != null) {
                            X(new q(haVar.f6097l, j10), v9Var);
                        }
                        a0().u0(str2, haVar.f6093h.f6259g);
                    }
                }
                f a03 = a0();
                b2.p.g(str2);
                a03.c();
                a03.u();
                if (j10 < 0) {
                    a03.h().I().c("Invalid time querying expired conditional properties", r3.x(str2), Long.valueOf(j10));
                    O2 = Collections.emptyList();
                } else {
                    O2 = a03.O("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
                }
                ArrayList arrayList = new ArrayList(O2.size());
                for (ha haVar2 : O2) {
                    if (haVar2 != null) {
                        this.f6010j.h().N().d("User property expired", haVar2.f6091f, this.f6010j.H().A(haVar2.f6093h.f6259g), haVar2.f6093h.g());
                        a0().o0(str2, haVar2.f6093h.f6259g);
                        q qVar3 = haVar2.f6101p;
                        if (qVar3 != null) {
                            arrayList.add(qVar3);
                        }
                        a0().u0(str2, haVar2.f6093h.f6259g);
                    }
                }
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    X(new q((q) obj2, j10), v9Var);
                }
                f a04 = a0();
                String str3 = qVar2.f6333f;
                b2.p.g(str2);
                b2.p.g(str3);
                a04.c();
                a04.u();
                if (j10 < 0) {
                    a04.h().I().d("Invalid time querying triggered conditional properties", r3.x(str2), a04.j().w(str3), Long.valueOf(j10));
                    O3 = Collections.emptyList();
                } else {
                    O3 = a04.O("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j10)});
                }
                ArrayList arrayList2 = new ArrayList(O3.size());
                for (ha haVar3 : O3) {
                    if (haVar3 != null) {
                        n9 n9Var = haVar3.f6093h;
                        p9 p9Var = new p9(haVar3.f6091f, haVar3.f6092g, n9Var.f6259g, j10, n9Var.g());
                        if (a0().W(p9Var)) {
                            F = this.f6010j.h().N();
                            str = "User property triggered";
                            x10 = haVar3.f6091f;
                            A2 = this.f6010j.H().A(p9Var.f6330c);
                            obj = p9Var.f6332e;
                        } else {
                            F = this.f6010j.h().F();
                            str = "Too many active user properties, ignoring";
                            x10 = r3.x(haVar3.f6091f);
                            A2 = this.f6010j.H().A(p9Var.f6330c);
                            obj = p9Var.f6332e;
                        }
                        F.d(str, x10, A2, obj);
                        q qVar4 = haVar3.f6099n;
                        if (qVar4 != null) {
                            arrayList2.add(qVar4);
                        }
                        haVar3.f6093h = new n9(p9Var);
                        haVar3.f6095j = true;
                        a0().X(haVar3);
                    }
                }
                X(qVar2, v9Var);
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj3 = arrayList2.get(i11);
                    i11++;
                    X(new q((q) obj3, j10), v9Var);
                }
                a0().x();
            } finally {
                a0().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(q qVar, String str) {
        boolean z10;
        String str2;
        b4 m02 = a0().m0(str);
        if (m02 == null || TextUtils.isEmpty(m02.T())) {
            this.f6010j.h().M().b("No app data available; dropping event", str);
            return;
        }
        Boolean N = N(m02);
        if (N == null) {
            if (!"_ui".equals(qVar.f6333f)) {
                this.f6010j.h().I().b("Could not find package. appId", r3.x(str));
            }
        } else if (!N.booleanValue()) {
            this.f6010j.h().F().b("App version does not match; dropping event. appId", r3.x(str));
            return;
        }
        String A2 = m02.A();
        String T = m02.T();
        long V = m02.V();
        String X = m02.X();
        long Z = m02.Z();
        long b02 = m02.b0();
        boolean e02 = m02.e0();
        String M = m02.M();
        long k10 = m02.k();
        boolean l10 = m02.l();
        boolean m10 = m02.m();
        String D = m02.D();
        Boolean n10 = m02.n();
        long d02 = m02.d0();
        List<String> o10 = m02.o();
        if (md.a()) {
            z10 = e02;
            if (this.f6010j.a().D(m02.t(), s.f6411j0)) {
                str2 = m02.G();
                P(qVar, new v9(str, A2, T, V, X, Z, b02, (String) null, z10, false, M, k10, 0L, 0, l10, m10, false, D, n10, d02, o10, str2, (bc.a() || !this.f6010j.a().t(s.J0)) ? "" : j(str).d()));
            }
        } else {
            z10 = e02;
        }
        str2 = null;
        P(qVar, new v9(str, A2, T, V, X, Z, b02, (String) null, z10, false, M, k10, 0L, 0, l10, m10, false, D, n10, d02, o10, str2, (bc.a() || !this.f6010j.a().t(s.J0)) ? "" : j(str).d()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(b9 b9Var) {
        this.f6015o++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(n9 n9Var, v9 v9Var) {
        p0();
        i0();
        if (b0(v9Var)) {
            if (!v9Var.f6567m) {
                V(v9Var);
                return;
            }
            int q02 = this.f6010j.G().q0(n9Var.f6259g);
            t4 t4Var = this.f6010j;
            if (q02 != 0) {
                t4Var.G();
                String I = o9.I(n9Var.f6259g, 24, true);
                String str = n9Var.f6259g;
                this.f6010j.G().X(this.f6026z, v9Var.f6560f, q02, "_ev", I, str != null ? str.length() : 0);
                return;
            }
            int r02 = t4Var.G().r0(n9Var.f6259g, n9Var.g());
            if (r02 != 0) {
                this.f6010j.G();
                String I2 = o9.I(n9Var.f6259g, 24, true);
                Object g10 = n9Var.g();
                this.f6010j.G().X(this.f6026z, v9Var.f6560f, r02, "_ev", I2, (g10 == null || !((g10 instanceof String) || (g10 instanceof CharSequence))) ? 0 : String.valueOf(g10).length());
                return;
            }
            Object y02 = this.f6010j.G().y0(n9Var.f6259g, n9Var.g());
            if (y02 == null) {
                return;
            }
            if ("_sid".equals(n9Var.f6259g)) {
                long j10 = n9Var.f6260h;
                String str2 = n9Var.f6263k;
                long j11 = 0;
                p9 r03 = a0().r0(v9Var.f6560f, "_sno");
                if (r03 != null) {
                    Object obj = r03.f6332e;
                    if (obj instanceof Long) {
                        j11 = ((Long) obj).longValue();
                        w(new n9("_sno", j10, Long.valueOf(j11 + 1), str2), v9Var);
                    }
                }
                if (r03 != null) {
                    this.f6010j.h().I().b("Retrieved last session number from database does not contain a valid (long) value", r03.f6332e);
                }
                m G = a0().G(v9Var.f6560f, "_s");
                if (G != null) {
                    j11 = G.f6209c;
                    this.f6010j.h().N().b("Backfill the session number. Last used session number", Long.valueOf(j11));
                }
                w(new n9("_sno", j10, Long.valueOf(j11 + 1), str2), v9Var);
            }
            p9 p9Var = new p9(v9Var.f6560f, n9Var.f6263k, n9Var.f6259g, n9Var.f6260h, y02);
            this.f6010j.h().N().c("Setting user property", this.f6010j.H().A(p9Var.f6330c), y02);
            a0().w0();
            try {
                V(v9Var);
                boolean W = a0().W(p9Var);
                a0().x();
                if (!W) {
                    this.f6010j.h().F().c("Too many unique user properties are set. Ignoring user property", this.f6010j.H().A(p9Var.f6330c), p9Var.f6332e);
                    this.f6010j.G().X(this.f6026z, v9Var.f6560f, 9, null, null, 0);
                }
            } finally {
                a0().B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x(v9 v9Var) {
        if (this.f6022v != null) {
            ArrayList arrayList = new ArrayList();
            this.f6023w = arrayList;
            arrayList.addAll(this.f6022v);
        }
        f a02 = a0();
        String str = v9Var.f6560f;
        b2.p.g(str);
        a02.c();
        a02.u();
        try {
            SQLiteDatabase y10 = a02.y();
            String[] strArr = {str};
            int delete = y10.delete("apps", "app_id=?", strArr) + 0 + y10.delete("events", "app_id=?", strArr) + y10.delete("user_attributes", "app_id=?", strArr) + y10.delete("conditional_properties", "app_id=?", strArr) + y10.delete("raw_events", "app_id=?", strArr) + y10.delete("raw_events_metadata", "app_id=?", strArr) + y10.delete("queue", "app_id=?", strArr) + y10.delete("audience_filter_values", "app_id=?", strArr) + y10.delete("main_event_params", "app_id=?", strArr) + y10.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                a02.h().N().c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            a02.h().F().c("Error resetting analytics data. appId, error", r3.x(str), e10);
        }
        if (v9Var.f6567m) {
            S(v9Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y(ha haVar) {
        v9 M = M(haVar.f6091f);
        if (M != null) {
            z(haVar, M);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(ha haVar, v9 v9Var) {
        t3 F;
        String str;
        Object x10;
        String A2;
        Object g10;
        t3 F2;
        String str2;
        Object x11;
        String A3;
        Object obj;
        boolean z10;
        b2.p.k(haVar);
        b2.p.g(haVar.f6091f);
        b2.p.k(haVar.f6092g);
        b2.p.k(haVar.f6093h);
        b2.p.g(haVar.f6093h.f6259g);
        p0();
        i0();
        if (b0(v9Var)) {
            if (!v9Var.f6567m) {
                V(v9Var);
                return;
            }
            ha haVar2 = new ha(haVar);
            boolean z11 = false;
            haVar2.f6095j = false;
            a0().w0();
            try {
                ha s02 = a0().s0(haVar2.f6091f, haVar2.f6093h.f6259g);
                if (s02 != null && !s02.f6092g.equals(haVar2.f6092g)) {
                    this.f6010j.h().I().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f6010j.H().A(haVar2.f6093h.f6259g), haVar2.f6092g, s02.f6092g);
                }
                if (s02 != null && (z10 = s02.f6095j)) {
                    haVar2.f6092g = s02.f6092g;
                    haVar2.f6094i = s02.f6094i;
                    haVar2.f6098m = s02.f6098m;
                    haVar2.f6096k = s02.f6096k;
                    haVar2.f6099n = s02.f6099n;
                    haVar2.f6095j = z10;
                    n9 n9Var = haVar2.f6093h;
                    haVar2.f6093h = new n9(n9Var.f6259g, s02.f6093h.f6260h, n9Var.g(), s02.f6093h.f6263k);
                } else if (TextUtils.isEmpty(haVar2.f6096k)) {
                    n9 n9Var2 = haVar2.f6093h;
                    haVar2.f6093h = new n9(n9Var2.f6259g, haVar2.f6094i, n9Var2.g(), haVar2.f6093h.f6263k);
                    haVar2.f6095j = true;
                    z11 = true;
                }
                if (haVar2.f6095j) {
                    n9 n9Var3 = haVar2.f6093h;
                    p9 p9Var = new p9(haVar2.f6091f, haVar2.f6092g, n9Var3.f6259g, n9Var3.f6260h, n9Var3.g());
                    if (a0().W(p9Var)) {
                        F2 = this.f6010j.h().M();
                        str2 = "User property updated immediately";
                        x11 = haVar2.f6091f;
                        A3 = this.f6010j.H().A(p9Var.f6330c);
                        obj = p9Var.f6332e;
                    } else {
                        F2 = this.f6010j.h().F();
                        str2 = "(2)Too many active user properties, ignoring";
                        x11 = r3.x(haVar2.f6091f);
                        A3 = this.f6010j.H().A(p9Var.f6330c);
                        obj = p9Var.f6332e;
                    }
                    F2.d(str2, x11, A3, obj);
                    if (z11 && haVar2.f6099n != null) {
                        X(new q(haVar2.f6099n, haVar2.f6094i), v9Var);
                    }
                }
                if (a0().X(haVar2)) {
                    F = this.f6010j.h().M();
                    str = "Conditional property added";
                    x10 = haVar2.f6091f;
                    A2 = this.f6010j.H().A(haVar2.f6093h.f6259g);
                    g10 = haVar2.f6093h.g();
                } else {
                    F = this.f6010j.h().F();
                    str = "Too many conditional properties, ignoring";
                    x10 = r3.x(haVar2.f6091f);
                    A2 = this.f6010j.H().A(haVar2.f6093h.f6259g);
                    g10 = haVar2.f6093h.g();
                }
                F.d(str, x10, A2, g10);
                a0().x();
            } finally {
                a0().B0();
            }
        }
    }
}
