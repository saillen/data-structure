package com.saillen.study.data.structure.graph;

/**
 * DFS: depth first search ，深度优先搜索，从给定顶点开始，一直搜索到再无法到达的点，然后回退到上一个顶点<br>
 * <p>
 * DFS 算法为了能做到走入死胡同后还能再回到上一层分支需要用栈来一路保存已经访问过的引用<br>
 * </p>
 *
 *
 * <p>
 * BFS: breadth first search , 广度优先搜索，从给定顶点开始，访问某个顶点的所有联通点，然后再到下一层做访问<br>
 * <p>
 * BFS 算法类似 Tree 的层次遍历，拿到节点后，我们只需要访问这个节点，然后把这个节点能联通的节点全部放入到队列中。
 * </p>
 * <p>
 * <p>
 * <p>
 * 访问标志位：图是可能是无向图，如 A 能到 C ， B 也可以到 C ，为了防止 C 重复遍历（可能造成死循环），我们需要标记某个节点是否访问过
 *
 * <p>
 * 访问标志位可以重新建立一个 顶点 length 大小的 boolean[] 也可以在 顶点本身的结构上添加这个标记位
 * </p>
 * 192.168.199.1:53
 * @author : saillen
 * @date: 2020/3/25
 **/
public class GraphTraverseRecursion {

    public static void log(Object o) {
        System.out.print(o);
    }

    public void dfs(int verIdx, GraphInfo graph) {
        GraphMatrixInfo matrixInfo = graph.getMatrixInfo();
        int[][] edgeMatrix = matrixInfo.getGraph();
        String[] vertexMap = (String[]) matrixInfo.getVertexIdxMap();

        boolean[] vis = new boolean[edgeMatrix.length];
        // 表示这个点访问过了
        vis[verIdx] = true;
        // 访问这个数组中 > 0 的就是 verIdx 能到达的点
        int[] vertexRelation = edgeMatrix[verIdx];
    }

    private void dfs1(int verIdx, int[] vertex) {

    }

}
