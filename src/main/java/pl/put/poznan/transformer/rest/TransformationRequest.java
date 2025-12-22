package pl.put.poznan.transformer.rest;

public class TransformationRequest {
    private String text;
    private String[] transforms;

    public TransformationRequest() {}

    public TransformationRequest(String text, String[] transforms) {
        this.text = text;
        this.transforms = transforms;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTransforms() {
        return transforms;
    }

    public void setTransforms(String[] transforms) {
        this.transforms = transforms;
    }
}