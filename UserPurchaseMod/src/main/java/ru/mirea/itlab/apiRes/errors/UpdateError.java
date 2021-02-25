package ru.mirea.itlab.apiRes.errors;

public class UpdateError {
    private String message="UpdateObjectError";
    private String success="error";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
