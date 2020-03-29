package com.saillen.study.data.structure.graph;

/**
 * 邻接表存储的时候表示图的顶点信息
 *
 * @author : saillen
 * @date: 2020/3/25
 **/
public class VertexNode<T> {

    /**
     * 真正的数据
     */
    private T data;
    /**
     * 一个冗余信息表示索引号
     */
    private int idx;
    /**
     * 边信息
     */
    private EdgeNode first;

    public VertexNode(int idx, T data) {
        this.data = data;
        this.idx = idx;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public EdgeNode getFirst() {
        return first;
    }

    public void setFirst(EdgeNode first) {
        this.first = first;
    }


}
