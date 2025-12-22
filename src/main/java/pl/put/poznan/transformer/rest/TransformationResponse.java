package pl.put.poznan.transformer.rest;

public class TransformationResponse {
    private String result;

    public TransformationResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}