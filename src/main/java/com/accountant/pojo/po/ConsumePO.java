package com.accountant.pojo.po;

/**
 * Created by xy on 2017/11/10.
 */
public class ConsumePO {

    private Integer id;
    private String typeId;
    private String userId;
    private String item;
    private String number;
    private String price;
    private String amount;
    private String consumer;
    private String consumeDate;
    private String consumeAddress;
    private String remark;
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(String consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getConsumeAddress() {
        return consumeAddress;
    }

    public void setConsumeAddress(String consumeAddress) {
        this.consumeAddress = consumeAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConsumePO{" +
                "id=" + id +
                ", typeId='" + typeId + '\'' +
                ", userId='" + userId + '\'' +
                ", item='" + item + '\'' +
                ", number='" + number + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", consumer='" + consumer + '\'' +
                ", consumeDate='" + consumeDate + '\'' +
                ", consumeAddress='" + consumeAddress + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
