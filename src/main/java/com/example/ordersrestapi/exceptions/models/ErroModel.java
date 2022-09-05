package com.example.ordersrestapi.exceptions.models;

public class ErroModel {

    private String tittle;

    private String message;

    private Integer status;

    private String intance;

    private String detail;


    public ErroModel() {
    }

    private ErroModel(String tittle, String message, Integer status, String intance) {
        this.tittle = tittle;
        this.message = message;
        this.status = status;
        this.intance = intance;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntance() {
        return intance;
    }

    public void setIntance(String intance) {
        this.intance = intance;
    }

    public void setDetail(String detail){
        this.detail=detail;
    }

    public String getDetail() {
        return detail;
    }

    public static final class builder {
        private String tittle;
        private String message;
        private Integer status;
        private String intance;

        private String detail;
        private builder() {
        }

        public static builder anErroModel() {
            return new builder();
        }

        public builder tittle(String tittle) {
            this.tittle = tittle;
            return this;
        }

        public builder message(String message) {
            this.message = message;
            return this;
        }

        public builder status(Integer status) {
            this.status = status;
            return this;
        }

        public builder intance(String intance) {
            this.intance = intance;
            return this;
        }

        public builder detail(String detail){
            this.detail=detail;
            return this;
        }
        public ErroModel build() {
            ErroModel erroModel = new ErroModel();
            erroModel.setTittle(tittle);
            erroModel.setMessage(message);
            erroModel.setStatus(status);
            erroModel.setIntance(intance);
            erroModel.setDetail(detail);
            return erroModel;
        }
    }
}
