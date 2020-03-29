package com.saillen.study.data.structure.graph;

/**
 * @author : saillen
 * @date: 2020/3/25
 **/
public class EdgeNode {
    // 达到点
    private VertexNode ver;
    private int verIdx;
    // 权重
    private int weight;
    // 下一条边
    private EdgeNode next;

    public EdgeNode(VertexNode ver) {
        this(ver, null);
    }

    public EdgeNode(VertexNode ver, EdgeNode next) {
        this.ver = ver;
        this.weight = 1;
        this.next = next;
        this.verIdx = ver.getIdx();
    }

    public VertexNode getVer() {
        return ver;
    }

    public void setVer(VertexNode ver) {
        this.ver = ver;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }

    public int getVerIdx() {
        return verIdx;
    }

    public void setVerIdx(int verIdx) {
        this.verIdx = verIdx;
    }
}
