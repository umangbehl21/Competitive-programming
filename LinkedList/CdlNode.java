package com.listts;

public class CdlNode<t> {
    CdlNode<t> prev;
    CdlNode<t> next;
    t data;
    public CdlNode(t data)
    {
        this.data = data;
        prev = null;
        next = null;
    }
}
