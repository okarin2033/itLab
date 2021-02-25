package ru.mirea.itlab.apiRes.errors;

public class AddError {
    private String type="addRequest";
    private String success="error";
    private String message="no field specification";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
