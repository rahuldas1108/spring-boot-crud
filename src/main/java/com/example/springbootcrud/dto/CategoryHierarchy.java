package com.example.springbootcrud.dto;

import java.util.Objects;

public class CategoryHierarchy {

    private CategoryHierarchyId id;
    private String itemTypeDesc;
    private String categoryCode;
    private String categoryDesc;
    private String subCategoryCode;
    private String subCategoryDesc;
    private String itemTypeCode;

    public CategoryHierarchy() {}

    public CategoryHierarchy(CategoryHierarchyId id, String itemTypeDesc, String categoryCode, String categoryDesc, String subCategoryCode, String subCategoryDesc, String itemTypeCode) {
        this.id = id;
        this.itemTypeDesc = itemTypeDesc;
        this.categoryCode = categoryCode;
        this.categoryDesc = categoryDesc;
        this.subCategoryCode = subCategoryCode;
        this.subCategoryDesc = subCategoryDesc;
        this.itemTypeCode = itemTypeCode;
    }

    public CategoryHierarchyId getId() {
        return id;
    }

    public String getItemTypeDesc() {
        return itemTypeDesc;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public String getSubCategoryDesc() {
        return subCategoryDesc;
    }

    public String getItemTypeCode() {
        return itemTypeCode;
    }

    public void setId(CategoryHierarchyId id) {
        this.id = id;
    }

    public void setItemTypeDesc(String itemTypeDesc) {
        this.itemTypeDesc = itemTypeDesc;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    public void setSubCategoryDesc(String subCategoryDesc) {
        this.subCategoryDesc = subCategoryDesc;
    }

    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryHierarchy that = (CategoryHierarchy) o;
        return Objects.equals(id, that.id) && Objects.equals(itemTypeDesc, that.itemTypeDesc) && Objects.equals(categoryCode, that.categoryCode) && Objects.equals(categoryDesc, that.categoryDesc) && Objects.equals(subCategoryCode, that.subCategoryCode) && Objects.equals(subCategoryDesc, that.subCategoryDesc) && Objects.equals(itemTypeCode, that.itemTypeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemTypeDesc, categoryCode, categoryDesc, subCategoryCode, subCategoryDesc, itemTypeCode);
    }

    @Override
    public String toString() {
        return "CatagoryHierarchy{" +
                "id=" + id +
                ", itemTypeDesc='" + itemTypeDesc + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryDesc='" + categoryDesc + '\'' +
                ", subCategoryCode='" + subCategoryCode + '\'' +
                ", subCategoryDesc='" + subCategoryDesc + '\'' +
                ", itemTypeCode='" + itemTypeCode + '\'' +
                '}';
    }
}
