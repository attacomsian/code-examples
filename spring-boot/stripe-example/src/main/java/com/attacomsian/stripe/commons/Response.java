package com.attacomsian.stripe.commons;

public class Response {

    private boolean status;
    private String details;

    public Response() {
        this.status = true; //default to true
    }

    public Response(boolean status) {
        this.status = status;
    }

    public Response(boolean status, String details) {
        this.status = status;
        this.details = details;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", details='" + details + '\'' +
                '}';
    }
}
