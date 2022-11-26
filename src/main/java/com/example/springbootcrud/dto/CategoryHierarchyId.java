package com.example.springbootcrud.dto;

import java.util.Objects;

public class CategoryHierarchyId {

    private String owner;
    private String code;

    public CategoryHierarchyId() {}

    public CategoryHierarchyId(String owner, String code) {
        this.owner = owner;
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public String getCode() {
        return code;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryHierarchyId that = (CategoryHierarchyId) o;
        return Objects.equals(owner, that.owner) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, code);
    }

    @Override
    public String toString() {
        return "CategoryHierarchyId{" +
                "owner='" + owner + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
