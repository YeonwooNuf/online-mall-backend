package com.learn.vo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class ProductVO {

    private long id;
    private String name;
    private Long price;
    private String createdId;
    private Timestamp createdAt;
    private String updatedId;
    private Timestamp updatedAt;
    private String useYn;

    public ProductVO() {
    }

    public ProductVO(long id, String name, Long price, String createdId, Timestamp createdAt, String updatedId, Timestamp updatedAt, String useYn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdId = createdId;
        this.createdAt = createdAt;
        this.updatedId = updatedId;
        this.updatedAt = updatedAt;
        this.useYn = useYn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedId() {
        return updatedId;
    }

    public void setUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createdId='" + createdId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedId='" + updatedId + '\'' +
                ", updatedAt=" + updatedAt +
                ", useYn='" + useYn + '\'' +
                '}';
    }
}
