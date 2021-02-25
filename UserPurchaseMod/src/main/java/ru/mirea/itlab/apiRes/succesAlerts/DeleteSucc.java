package ru.mirea.itlab.apiRes.succesAlerts;

public class DeleteSucc {
    String message="Delleted";
    String name;
    public DeleteSucc(String name){
        this.name=name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
