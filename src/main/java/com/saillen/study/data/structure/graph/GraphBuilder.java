package com.saillen.study.data.structure.graph;


/**
 * 图的构建：邻接矩阵和邻接表，都是输出如下图
 *
 * <pre>
 * A ------ D
 * | \    / |
 * |  \ /   |
 * |   E    |
 * |        |
 * B ------ C
 * </pre>
 *
 * DFS : ABCED
 *
 *
 * @author : saillen
 * @date: 2020/3/25
 **/
public class GraphBuilder {


    /**
     * 邻接矩阵存储法:<br>
     * 二维数组存储：二维下标表示顶点编号，这个时候顶点和下标的关系需要自己单独建立
     *
     * @return
     */
    public GraphMatrixInfo buildAdjacencyMatrix() {
        // A:0,B:1,C:2,D:3,E:4
        String[] map = new String[]{"A", "B", "C", "D", "E"};

        int[][] graph = new int[5][5];
        // A -> B, A-> D, A -> E
        graph[0][1] = 1;
        graph[0][3] = 1;
        graph[0][4] = 1;
        // B -> A , B -> C
        graph[1][0] = 1;
        graph[1][2] = 1;
        // C -> D,C -> B
        graph[2][1] = 1;
        graph[2][3] = 1;
        // D -> A ,D -> C , D -> E
        graph[3][0] = 1;
        graph[3][2] = 1;
        graph[3][4] = 1;
        // E -> A, E -> D
        graph[4][0] = 1;
        graph[4][3] = 1;

        return new GraphMatrixInfo(map, graph);
    }

    /**
     * 邻接表存储法：<br>
     * 顶点构成的表，顶点内部拥有一个存储了该顶点到其他顶点的链表
     *
     * @return
     */
    private VertexNode[] buildAdjacencyTable() {
        VertexNode a = new VertexNode(0, "A");
        VertexNode b = new VertexNode(1, "B");
        VertexNode c = new VertexNode(2, "C");
        VertexNode d = new VertexNode(3, "D");
        VertexNode e = new VertexNode(4, "E");

        // A -> B, A-> D, A -> E
        EdgeNode a2e = new EdgeNode(e);
        EdgeNode a2d = new EdgeNode(d, a2e);
        EdgeNode a2b = new EdgeNode(b, a2d);
        a.setFirst(a2b);

        // B -> A , B -> C
        EdgeNode b2c = new EdgeNode(c);
        EdgeNode b2a = new EdgeNode(a, b2c);
        b.setFirst(b2a);

        // C -> D,C -> B
        EdgeNode c2d = new EdgeNode(d);
        EdgeNode c2b = new EdgeNode(b, c2d);
        c.setFirst(c2b);

        // D -> A ,D -> C , D -> E
        EdgeNode d2e = new EdgeNode(e);
        EdgeNode d2c = new EdgeNode(c, d2e);
        EdgeNode d2a = new EdgeNode(a, d2c);
        d.setFirst(d2a);

        // E -> A, E -> D
        EdgeNode e2d = new EdgeNode(d);
        EdgeNode e2a = new EdgeNode(a, e2d);
        e.setFirst(e2a);

        // 返回图
        VertexNode[] graph = new VertexNode[]{a, b, c, d, e};
        return graph;
    }


}
