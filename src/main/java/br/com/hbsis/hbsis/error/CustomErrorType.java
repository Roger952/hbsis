package br.com.hbsis.hbsis.error;

@SuppressWarnings("ALL")
public class CustomErrorType {
    @SuppressWarnings("CanBeFinal")
    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}