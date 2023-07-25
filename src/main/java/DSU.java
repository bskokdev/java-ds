public class DSU {
  private final int[] parent;
  private final int[] sizeRank;

  public DSU(int size) {
    this.parent = new int[size];
    this.sizeRank = new int[size];
  }

  public void makeSet(int v) {
    parent[v] = v;
    sizeRank[v] = 1;
  }

  public int findSet(int v) {
    // return representative node of the set
    if (parent[v] == v) {
      return v;
    }
    // Path compression -> we directly append nodes to the root
    return parent[v] = findSet(parent[v]);
  }

  public void unionSets(int a, int b) {
    a = findSet(a);
    b = findSet(b);
    if (a != b) {
      // we want to attach a smaller ranked tree to the bigger ranked one
      if (sizeRank[a] < sizeRank[b]) {
        int temp = a;
        a = b;
        b = temp;
      }
      // 'a' is guaranteed here to be a tree with bigger rank
      // set 'a' representative node to be the parent of 'b' representative
      // this will set 'b' tree to be a subtree of 'a' tree (set)
      // also add the 'b' rank to the 'a' rank as the sets merge
      parent[b] = a;
      sizeRank[a] += sizeRank[b];
    }
  }
}
