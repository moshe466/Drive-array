package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class Path implements Iterable<ChildKey>, Comparable<Path> {
    private static final Path EMPTY_PATH = new Path("");
    private final int end;
    private final ChildKey[] pieces;
    private final int start;

    public Path(ChildKey... childKeyArr) {
        this.pieces = (ChildKey[]) Arrays.copyOf(childKeyArr, childKeyArr.length);
        this.start = 0;
        this.end = childKeyArr.length;
        for (ChildKey childKey : childKeyArr) {
            Utilities.hardAssert(childKey != null, "Can't construct a path with a null value!");
        }
    }

    public static Path getEmptyPath() {
        return EMPTY_PATH;
    }

    public static Path getRelative(Path path, Path path2) {
        ChildKey front = path.getFront();
        ChildKey front2 = path2.getFront();
        if (front == null) {
            return path2;
        }
        if (front.equals(front2)) {
            return getRelative(path.popFront(), path2.popFront());
        }
        throw new DatabaseException("INTERNAL ERROR: " + path2 + " is not contained in " + path);
    }

    public List<String> asList() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<ChildKey> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().asString());
        }
        return arrayList;
    }

    public Path child(Path path) {
        int size = path.size() + size();
        ChildKey[] childKeyArr = new ChildKey[size];
        System.arraycopy(this.pieces, this.start, childKeyArr, 0, size());
        System.arraycopy(path.pieces, path.start, childKeyArr, size(), path.size());
        return new Path(childKeyArr, 0, size);
    }

    public boolean contains(Path path) {
        if (size() > path.size()) {
            return false;
        }
        int i = this.start;
        int i3 = path.start;
        while (i < this.end) {
            if (!this.pieces[i].equals(path.pieces[i3])) {
                return false;
            }
            i++;
            i3++;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Path)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Path path = (Path) obj;
        if (size() != path.size()) {
            return false;
        }
        int i = this.start;
        for (int i3 = path.start; i < this.end && i3 < path.end; i3++) {
            if (!this.pieces[i].equals(path.pieces[i3])) {
                return false;
            }
            i++;
        }
        return true;
    }

    public ChildKey getBack() {
        if (!isEmpty()) {
            return this.pieces[this.end - 1];
        }
        return null;
    }

    public ChildKey getFront() {
        if (isEmpty()) {
            return null;
        }
        return this.pieces[this.start];
    }

    public Path getParent() {
        if (isEmpty()) {
            return null;
        }
        return new Path(this.pieces, this.start, this.end - 1);
    }

    public int hashCode() {
        int i = 0;
        for (int i3 = this.start; i3 < this.end; i3++) {
            i = (i * 37) + this.pieces[i3].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        if (this.start >= this.end) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<ChildKey> iterator() {
        return new Iterator<ChildKey>() { // from class: com.google.firebase.database.core.Path.1
            int offset;

            {
                this.offset = Path.this.start;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.offset < Path.this.end) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Can't remove component from immutable Path!");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public ChildKey next() {
                if (hasNext()) {
                    ChildKey[] childKeyArr = Path.this.pieces;
                    int i = this.offset;
                    ChildKey childKey = childKeyArr[i];
                    this.offset = i + 1;
                    return childKey;
                }
                throw new NoSuchElementException("No more elements.");
            }
        };
    }

    public Path popFront() {
        int i = this.start;
        if (!isEmpty()) {
            i++;
        }
        return new Path(this.pieces, i, this.end);
    }

    public int size() {
        return this.end - this.start;
    }

    public String toString() {
        if (isEmpty()) {
            return RemoteSettings.FORWARD_SLASH_STRING;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(this.pieces[i].asString());
        }
        return sb.toString();
    }

    public String wireFormat() {
        if (isEmpty()) {
            return RemoteSettings.FORWARD_SLASH_STRING;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            if (i > this.start) {
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            }
            sb.append(this.pieces[i].asString());
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Path path) {
        int i;
        int i3 = this.start;
        int i4 = path.start;
        while (true) {
            i = this.end;
            if (i3 >= i || i4 >= path.end) {
                break;
            }
            int compareTo = this.pieces[i3].compareTo(path.pieces[i4]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
            i4++;
        }
        if (i3 == i && i4 == path.end) {
            return 0;
        }
        return i3 == i ? -1 : 1;
    }

    public Path child(ChildKey childKey) {
        int size = size();
        int i = size + 1;
        ChildKey[] childKeyArr = new ChildKey[i];
        System.arraycopy(this.pieces, this.start, childKeyArr, 0, size);
        childKeyArr[size] = childKey;
        return new Path(childKeyArr, 0, i);
    }

    public Path(List<String> list) {
        this.pieces = new ChildKey[list.size()];
        Iterator<String> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.pieces[i] = ChildKey.fromString(it.next());
            i++;
        }
        this.start = 0;
        this.end = list.size();
    }

    public Path(String str) {
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        int i = 0;
        for (String str2 : split) {
            if (str2.length() > 0) {
                i++;
            }
        }
        this.pieces = new ChildKey[i];
        int i3 = 0;
        for (String str3 : split) {
            if (str3.length() > 0) {
                this.pieces[i3] = ChildKey.fromString(str3);
                i3++;
            }
        }
        this.start = 0;
        this.end = this.pieces.length;
    }

    private Path(ChildKey[] childKeyArr, int i, int i3) {
        this.pieces = childKeyArr;
        this.start = i;
        this.end = i3;
    }
}
