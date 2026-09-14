package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/* loaded from: classes.dex */
class ClassLoaderResource implements ForkResource {
    private final ClassLoader loader;

    public ClassLoaderResource(ClassLoader classLoader) {
        this.loader = classLoader;
    }

    private void writeAndCloseStream(DataOutputStream dataOutputStream, InputStream inputStream) {
        try {
            byte[] bArr = new byte[65535];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    dataOutputStream.writeShort(read);
                    dataOutputStream.write(bArr, 0, read);
                } else {
                    dataOutputStream.writeShort(0);
                    inputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    @Override // org.apache.tika.fork.ForkResource
    public Throwable process(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        byte readByte = dataInputStream.readByte();
        String readUTF = dataInputStream.readUTF();
        if (readByte == 1) {
            InputStream resourceAsStream = this.loader.getResourceAsStream(readUTF);
            if (resourceAsStream != null) {
                dataOutputStream.writeBoolean(true);
                writeAndCloseStream(dataOutputStream, resourceAsStream);
            } else {
                dataOutputStream.writeBoolean(false);
            }
        } else if (readByte == 2) {
            Enumeration<URL> resources = this.loader.getResources(readUTF);
            while (resources.hasMoreElements()) {
                dataOutputStream.writeBoolean(true);
                writeAndCloseStream(dataOutputStream, resources.nextElement().openStream());
            }
            dataOutputStream.writeBoolean(false);
        }
        dataOutputStream.flush();
        return null;
    }
}
