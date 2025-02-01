package com.doc.genericarchitecturesecurity.domain;

public interface GenericModel<TYPE_PK> {
    TYPE_PK getId();
    void setId(TYPE_PK id);
}