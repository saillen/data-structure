package com.saillen.study.data.structure.graph;

import java.util.Map;

/**
 * 表的矩阵信息：用邻接矩阵存储的时候需要注意，要先构建顶点和下标的映射关系
 *
 * @author : saillen
 * @date: 2020/3/25
 **/
public class GraphMatrixInfo<T> {

    T[] vertexIdxMap;
    int[][] graph;

    public GraphMatrixInfo(T[] vertexIdxMap, int[][] graph) {
        this.vertexIdxMap = vertexIdxMap;
        this.graph = graph;
    }

    public T[] getVertexIdxMap() {
        return vertexIdxMap;
    }

    public void setVertexIdxMap(T[] vertexIdxMap) {
        this.vertexIdxMap = vertexIdxMap;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }
}
