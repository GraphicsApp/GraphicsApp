package de.mi.ur.gpr.graphics;


public class Label extends GraphicsObject {

    private String text;

    public Label(float x, float y, String text) {
        super(x, y);
        this.text = text;
        this.type = GraphicsObjectType.LABEL;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
