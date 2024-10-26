package com.mintra.backend.json.error;

public class ProductErrorResponse {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ProductErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
