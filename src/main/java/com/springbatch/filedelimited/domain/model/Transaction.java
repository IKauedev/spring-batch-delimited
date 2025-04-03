package com.springbatch.filedelimited.domain.model;

public class Transaction {
    public String id;
    public String description;
    public String value;

    public String id() {
        return id;
    }

    public Transaction setId(String id) {
        this.id = id;
        return this;
    }

    public String description() {
        return description;
    }

    public Transaction setDescription(String description) {
        this.description = description;
        return this;
    }

    public String value() {
        return value;
    }

    public Transaction setValue(String value) {
        this.value = value;
        return this;
    }
}
