package com.saillen.study.data.structure.graph;

/**
 * 图的抽象类，一个图应该具有的内容
 *
 * @author : saillen
 * @date: 2020/3/25
 **/
public class GraphInfo {

    public enum GraphTypeEnum {
        DG,
        NG,
        AG,
        AN
    }

    /**
     * 图的边的数量
     */
    private int edgeNum;
    /**
     * 图的顶点数量
     */
    private int vertexNum;
    /**
     * 图的类型
     */
    private GraphTypeEnum type;
    /**
     * 邻接矩阵存储
     */
    private GraphMatrixInfo matrixInfo;
    /**
     * 邻接表存储
     */
    private VertexNode[] tableInfo;

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public GraphTypeEnum getType() {
        return type;
    }

    public void setType(GraphTypeEnum type) {
        this.type = type;
    }

    public GraphMatrixInfo getMatrixInfo() {
        return matrixInfo;
    }

    public void setMatrixInfo(GraphMatrixInfo matrixInfo) {
        this.matrixInfo = matrixInfo;
    }

    public VertexNode[] getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(VertexNode[] tableInfo) {
        this.tableInfo = tableInfo;
    }
}
