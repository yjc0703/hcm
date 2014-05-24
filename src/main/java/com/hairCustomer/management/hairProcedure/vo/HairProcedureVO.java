package com.hairCustomer.management.hairProcedure.vo;

public class HairProcedureVO {
    private Integer hairProcedureId;
    private String hairProcedureName;
    private String hairProcedureDate;
    private Integer customerId;
    private String note;

    public Integer getHairProcedureId() {
        return hairProcedureId;
    }

    public void setHairProcedureId(Integer hairProcedureId) {
        this.hairProcedureId = hairProcedureId;
    }

    public String getHairProcedureName() {
        return hairProcedureName;
    }

    public void setHairProcedureName(String hairProcedureName) {
        this.hairProcedureName = hairProcedureName;
    }

    public String getHairProcedureDate() {
        return hairProcedureDate;
    }

    public void setHairProcedureDate(String hairProcedureDate) {
        this.hairProcedureDate = hairProcedureDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
