public class DSU {
  private final int[] parent;
  private final int[] size;

  public DSU(int size) {
    this.parent = new int[size];
    this.size = new int[size];
  }

  public void makeSet(int v) {
    parent[v] = v;
    size[v] = 1;
  }

  public int findSet(int v) {
    if (parent[v] == v) {
      return v;
    }
    return parent[v] = findSet(parent[v]);
  }

  public void unionSets(int a, int b) {
    a = findSet(a);
    b = findSet(b);
    if (a != b) {
      // we attach the smaller tree to the bigger one
      if (size[a] < size[b]) {
        int temp = a;
        a = b;
        b = temp;
      }
      parent[b] = a;
      size[a] += size[b];
    }
  }
}
