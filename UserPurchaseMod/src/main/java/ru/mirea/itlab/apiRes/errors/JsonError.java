package ru.mirea.itlab.apiRes.errors;

public class JsonError {
    private String type="JsonConvert";
    private String success="error";

    public JsonError(String input) {
        this.error = input;
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

    public String getInput() {
        return error;
    }

    public void setInput(String input) {
        this.error = input;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String error;
    private String message="provided wrong data";
}
