package com.william.exception;

/**
 * @Auther:xuxitan
 * @Date: 2018/12/3 15:26
 * @Description:
 */
public class CustomException extends Exception {

    private String code;

    private String errorMessage;

    public CustomException(String code,String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
