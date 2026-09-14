package com.samsung.android.sbrowser.ext.clientservice;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class WavFileUtil {
    private static final int FILE_SIZE_MINUS_44_OFFSET = 40;
    private static final int FILE_SIZE_MINUS_8_OFFSET = 4;
    private static final int FILE_SPLIT_TIMEOUT_MS = 5000;
    private static final int HEADER_LENGTH = 44;
    private static final String TAG = "WaveFileUtil";
    private int bytesWritten;
    private int channelCount;
    private int counter;
    private int encoding;
    private final Handler mHandler;
    private Runnable mTask;
    private final String outputFileNamePrefix;
    private RandomAccessFile randomAccessFile;
    private int sampleRateHz;
    private final byte[] scratchBuffer;
    private final ByteBuffer scratchByteBuffer;

    public WavFileUtil(String str) {
        this.outputFileNamePrefix = str;
        File file = new File(str);
        if (!file.exists()) {
            Log.i(TAG, str + " is created");
            file.mkdirs();
        }
        byte[] bArr = new byte[1024];
        this.scratchBuffer = bArr;
        this.scratchByteBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        this.mHandler = new Handler(Looper.myLooper());
    }

    public void flush(int i, int i2, int i3) {
        try {
            reset();
        } catch (Exception e) {
            Log.e(TAG, "Error resetting", e);
        }
        this.sampleRateHz = i;
        this.channelCount = i2;
        this.encoding = i3;
    }

    public void handleBuffer(ByteBuffer byteBuffer) {
        try {
            maybePrepareFile();
            writeBuffer(byteBuffer);
            Runnable runnable = this.mTask;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.WavFileUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.d(WavFileUtil.TAG, "Split timeout : split current file");
                    try {
                        WavFileUtil.this.reset();
                    } catch (Exception e) {
                        Log.e(WavFileUtil.TAG, "Error resetting", e);
                    }
                }
            };
            this.mTask = runnable2;
            this.mHandler.postDelayed(runnable2, 5000L);
        } catch (Exception e) {
            Log.e(TAG, "Error writing data", e);
        }
    }

    private void maybePrepareFile() throws Exception {
        if (this.randomAccessFile != null) {
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(getNextOutputFileName(), "rw");
        writeFileHeader(randomAccessFile);
        this.randomAccessFile = randomAccessFile;
        this.bytesWritten = 44;
        Log.d(TAG, "file created ");
    }

    private void writeFileHeader(RandomAccessFile randomAccessFile) throws Exception {
        randomAccessFile.writeInt(WavUtil.RIFF_FOURCC);
        randomAccessFile.writeInt(-1);
        randomAccessFile.writeInt(WavUtil.WAVE_FOURCC);
        randomAccessFile.writeInt(WavUtil.FMT_FOURCC);
        this.scratchByteBuffer.clear();
        this.scratchByteBuffer.putInt(16);
        this.scratchByteBuffer.putShort((short) 1);
        this.scratchByteBuffer.putShort((short) this.channelCount);
        this.scratchByteBuffer.putInt(this.sampleRateHz);
        int i = this.channelCount * this.encoding;
        this.scratchByteBuffer.putInt(this.sampleRateHz * i);
        this.scratchByteBuffer.putShort((short) i);
        this.scratchByteBuffer.putShort((short) ((i * 8) / this.channelCount));
        randomAccessFile.write(this.scratchBuffer, 0, this.scratchByteBuffer.position());
        randomAccessFile.writeInt(WavUtil.DATA_FOURCC);
        randomAccessFile.writeInt(-1);
    }

    private void writeBuffer(ByteBuffer byteBuffer) throws Exception {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(byteBuffer.remaining(), this.scratchBuffer.length);
            byteBuffer.get(this.scratchBuffer, 0, min);
            randomAccessFile.write(this.scratchBuffer, 0, min);
            this.bytesWritten += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() throws Exception {
        Log.d(TAG, "reset " + this.randomAccessFile);
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile == null) {
            return;
        }
        try {
            this.scratchByteBuffer.clear();
            this.scratchByteBuffer.putInt(this.bytesWritten - 8);
            randomAccessFile.seek(4L);
            randomAccessFile.write(this.scratchBuffer, 0, 4);
            this.scratchByteBuffer.clear();
            this.scratchByteBuffer.putInt(this.bytesWritten - 44);
            randomAccessFile.seek(40L);
            randomAccessFile.write(this.scratchBuffer, 0, 4);
        } catch (IOException e) {
            Log.w(TAG, "Error updating file size", e);
        }
        try {
            randomAccessFile.close();
            Log.d(TAG, "file close");
        } finally {
            this.randomAccessFile = null;
        }
    }

    public String formatInvariant(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private String getNextOutputFileName() {
        int i = this.counter;
        this.counter = i + 1;
        String formatInvariant = formatInvariant("%s/%04d.wav", this.outputFileNamePrefix, Integer.valueOf(i));
        Log.d(TAG, "filename " + formatInvariant);
        return formatInvariant;
    }
}
