package dev.leonwong.youtubenoteserver.errorhandler;

public class ErrorResponse {
    private int status;

    private String message;

    private String timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String msg, String timeStamp) {
        this.status = status;
        this.message = msg;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
