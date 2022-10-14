package com.reactor.demo;

public enum EnumDemo {

    OUT_OF_POLICY_REFUND_SUCCESS(200, "Refund Sucess"),
    OUT_OF_POLICY_REFUND_FAIL(200, "Refund Fail");

    private final int errorCode;
    private final String errorMessage;

    EnumDemo(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
