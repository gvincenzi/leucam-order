package org.leucam.order.entity.type;

public enum ColorType {
    GRAY_SCALE("Bianco e Nero"),COLOR("Colore");

    private String label;

    ColorType(String label){
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
