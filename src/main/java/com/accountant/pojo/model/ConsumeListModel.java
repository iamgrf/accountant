package com.accountant.pojo.model;

import javafx.beans.property.SimpleStringProperty;

public class ConsumeListModel {

    private final SimpleStringProperty num = new SimpleStringProperty();
    private final SimpleStringProperty v = new SimpleStringProperty();
    private final SimpleStringProperty typeName = new SimpleStringProperty();
    private final SimpleStringProperty item = new SimpleStringProperty();
    private final SimpleStringProperty realName = new SimpleStringProperty();
    private final SimpleStringProperty number = new SimpleStringProperty();
    private final SimpleStringProperty price = new SimpleStringProperty();
    private final SimpleStringProperty amount = new SimpleStringProperty();
    private final SimpleStringProperty consumer = new SimpleStringProperty();
    private final SimpleStringProperty consumeDate = new SimpleStringProperty();
    private final SimpleStringProperty consumeAddress = new SimpleStringProperty();
    private final SimpleStringProperty remark = new SimpleStringProperty();
    private final SimpleStringProperty createDate = new SimpleStringProperty();

    public String getNum() {
        return num.get();
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getV() {
        return v.get();
    }

    public SimpleStringProperty vProperty() {
        return v;
    }

    public void setV(String v) {
        this.v.set(v);
    }

    public String getTypeName() {
        return typeName.get();
    }

    public SimpleStringProperty typeNameProperty() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName.set(typeName);
    }

    public String getItem() {
        return item.get();
    }

    public SimpleStringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }

    public String getRealName() {
        return realName.get();
    }

    public SimpleStringProperty realNameProperty() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName.set(realName);
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getConsumer() {
        return consumer.get();
    }

    public SimpleStringProperty consumerProperty() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer.set(consumer);
    }

    public String getConsumeDate() {
        return consumeDate.get();
    }

    public SimpleStringProperty consumeDateProperty() {
        return consumeDate;
    }

    public void setConsumeDate(String consumeDate) {
        this.consumeDate.set(consumeDate);
    }

    public String getConsumeAddress() {
        return consumeAddress.get();
    }

    public SimpleStringProperty consumeAddressProperty() {
        return consumeAddress;
    }

    public void setConsumeAddress(String consumeAddress) {
        this.consumeAddress.set(consumeAddress);
    }

    public String getRemark() {
        return remark.get();
    }

    public SimpleStringProperty remarkProperty() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark.set(remark);
    }

    public String getCreateDate() {
        return createDate.get();
    }

    public SimpleStringProperty createDateProperty() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate.set(createDate);
    }
}
