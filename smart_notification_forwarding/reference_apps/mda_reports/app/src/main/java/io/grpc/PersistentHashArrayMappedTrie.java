package io.grpc;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class PersistentHashArrayMappedTrie<K, V> {
    private final Node<K, V> root;

    /* loaded from: classes2.dex */
    static final class CollisionLeaf<K, V> implements Node<K, V> {
        private final K[] keys;
        private final V[] values;

        CollisionLeaf(K k, V v, K k2, V v2) {
            this(new Object[]{k, k2}, new Object[]{v, v2});
        }

        private CollisionLeaf(K[] kArr, V[] vArr) {
            this.keys = kArr;
            this.values = vArr;
        }

        private int indexOfKey(K k) {
            int i = 0;
            while (true) {
                K[] kArr = this.keys;
                if (i >= kArr.length) {
                    return -1;
                }
                if (kArr[i] == k) {
                    return i;
                }
                i++;
            }
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public V get(K k, int i, int i2) {
            int i3 = 0;
            while (true) {
                K[] kArr = this.keys;
                if (i3 >= kArr.length) {
                    return null;
                }
                if (kArr[i3] == k) {
                    return this.values[i3];
                }
                i3++;
            }
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public Node<K, V> put(K k, V v, int i, int i2) {
            int hashCode = this.keys[0].hashCode();
            if (hashCode != i) {
                return CompressedIndex.a(new Leaf(k, v), i, this, hashCode, i2);
            }
            int indexOfKey = indexOfKey(k);
            if (indexOfKey != -1) {
                K[] kArr = this.keys;
                Object[] copyOf = Arrays.copyOf(kArr, kArr.length);
                Object[] copyOf2 = Arrays.copyOf(this.values, this.keys.length);
                copyOf[indexOfKey] = k;
                copyOf2[indexOfKey] = v;
                return new CollisionLeaf(copyOf, copyOf2);
            }
            K[] kArr2 = this.keys;
            Object[] copyOf3 = Arrays.copyOf(kArr2, kArr2.length + 1);
            Object[] copyOf4 = Arrays.copyOf(this.values, this.keys.length + 1);
            K[] kArr3 = this.keys;
            copyOf3[kArr3.length] = k;
            copyOf4[kArr3.length] = v;
            return new CollisionLeaf(copyOf3, copyOf4);
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public int size() {
            return this.values.length;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CollisionLeaf(");
            for (int i = 0; i < this.values.length; i++) {
                sb.append("(key=");
                sb.append(this.keys[i]);
                sb.append(" value=");
                sb.append(this.values[i]);
                sb.append(") ");
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    static final class CompressedIndex<K, V> implements Node<K, V> {
        private static final int BITS = 5;
        private static final int BITS_MASK = 31;
        final int a;
        final Node<K, V>[] b;
        private final int size;

        private CompressedIndex(int i, Node<K, V>[] nodeArr, int i2) {
            this.a = i;
            this.b = nodeArr;
            this.size = i2;
        }

        static <K, V> Node<K, V> a(Node<K, V> node, int i, Node<K, V> node2, int i2, int i3) {
            int indexBit = indexBit(i, i3);
            int indexBit2 = indexBit(i2, i3);
            if (indexBit == indexBit2) {
                Node a = a(node, i, node2, i2, i3 + 5);
                return new CompressedIndex(indexBit, new Node[]{a}, a.size());
            }
            if (uncompressedIndex(i, i3) > uncompressedIndex(i2, i3)) {
                node2 = node;
                node = node2;
            }
            return new CompressedIndex(indexBit | indexBit2, new Node[]{node, node2}, node.size() + node2.size());
        }

        private int compressedIndex(int i) {
            return Integer.bitCount((i - 1) & this.a);
        }

        private static int indexBit(int i, int i2) {
            return 1 << uncompressedIndex(i, i2);
        }

        private static int uncompressedIndex(int i, int i2) {
            return (i >>> i2) & 31;
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public V get(K k, int i, int i2) {
            int indexBit = indexBit(i, i2);
            if ((this.a & indexBit) == 0) {
                return null;
            }
            return this.b[compressedIndex(indexBit)].get(k, i, i2 + 5);
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public Node<K, V> put(K k, V v, int i, int i2) {
            int indexBit = indexBit(i, i2);
            int compressedIndex = compressedIndex(indexBit);
            int i3 = this.a;
            if ((i3 & indexBit) != 0) {
                Node<K, V>[] nodeArr = this.b;
                Node[] nodeArr2 = (Node[]) Arrays.copyOf(nodeArr, nodeArr.length);
                nodeArr2[compressedIndex] = this.b[compressedIndex].put(k, v, i, i2 + 5);
                return new CompressedIndex(this.a, nodeArr2, (size() + nodeArr2[compressedIndex].size()) - this.b[compressedIndex].size());
            }
            int i4 = i3 | indexBit;
            Node<K, V>[] nodeArr3 = this.b;
            Node[] nodeArr4 = new Node[nodeArr3.length + 1];
            System.arraycopy(nodeArr3, 0, nodeArr4, 0, compressedIndex);
            nodeArr4[compressedIndex] = new Leaf(k, v);
            Node<K, V>[] nodeArr5 = this.b;
            System.arraycopy(nodeArr5, compressedIndex, nodeArr4, compressedIndex + 1, nodeArr5.length - compressedIndex);
            return new CompressedIndex(i4, nodeArr4, size() + 1);
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public int size() {
            return this.size;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CompressedIndex(");
            sb.append(String.format("bitmap=%s ", Integer.toBinaryString(this.a)));
            for (Node<K, V> node : this.b) {
                sb.append(node);
                sb.append(" ");
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    static final class Leaf<K, V> implements Node<K, V> {
        private final K key;
        private final V value;

        public Leaf(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public V get(K k, int i, int i2) {
            if (this.key == k) {
                return this.value;
            }
            return null;
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public Node<K, V> put(K k, V v, int i, int i2) {
            int hashCode = this.key.hashCode();
            if (hashCode != i) {
                return CompressedIndex.a(new Leaf(k, v), i, this, hashCode, i2);
            }
            K k2 = this.key;
            return k2 == k ? new Leaf(k, v) : new CollisionLeaf(k2, this.value, k, v);
        }

        @Override // io.grpc.PersistentHashArrayMappedTrie.Node
        public int size() {
            return 1;
        }

        public String toString() {
            return String.format("Leaf(key=%s value=%s)", this.key, this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Node<K, V> {
        V get(K k, int i, int i2);

        Node<K, V> put(K k, V v, int i, int i2);

        int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PersistentHashArrayMappedTrie() {
        this(null);
    }

    private PersistentHashArrayMappedTrie(Node<K, V> node) {
        this.root = node;
    }

    public V get(K k) {
        Node<K, V> node = this.root;
        if (node == null) {
            return null;
        }
        return node.get(k, k.hashCode(), 0);
    }

    public PersistentHashArrayMappedTrie<K, V> put(K k, V v) {
        Node<K, V> node = this.root;
        return node == null ? new PersistentHashArrayMappedTrie<>(new Leaf(k, v)) : new PersistentHashArrayMappedTrie<>(node.put(k, v, k.hashCode(), 0));
    }

    public int size() {
        Node<K, V> node = this.root;
        if (node == null) {
            return 0;
        }
        return node.size();
    }
}
