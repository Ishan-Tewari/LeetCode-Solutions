class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);

        int[] ans = new int[1];
        for (int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];

            if (disjointSet.isCausesCycle(v1, v2)) ans = edge;
            else disjointSet.union(v1, v2);

        }

        return ans;
    }
}

class DisjointSet{
    int[] parent;

    DisjointSet(int v){
        parent = new int[v+1];
        Arrays.fill(parent,-1);
        parent[0] = -2;
    }

    public int find(int v1){
        if (parent[v1] == -1) return v1;

        return find(parent[v1]);
    }

    public void union(int v1, int v2){
        int v1AbsoluteParent = find(v1);
        int v2AbsoluteParent = find(v2);

        parent[v1AbsoluteParent] = v2AbsoluteParent;
    }

    public boolean isCausesCycle(int v1, int v2){

        int v1AbsoluteParent = find(v1);
        int v2AbsoluteParent = find(v2);

        if (v1AbsoluteParent == v2AbsoluteParent) return true;

        return false;
    }
}
