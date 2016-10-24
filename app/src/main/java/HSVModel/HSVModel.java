package HSVModel;


import android.graphics.Color;

import java.util.Observable;

/**
 * Created by mattsaab on 2016-10-18.
 */

public class HSVModel extends Observable {

    //CLASS VARIABLES
    public static final Float MAX_H = 359.0f;
    public static final Float MAX_S = 100.0f;
    public static final Float MAX_V = 100.0f;
    public static final Float MIN_H = 0.0f;
    public static final Float MIN_S = 0.0f;
    public static final Float MIN_V = 0.0f;

    // CLASS VARIABLES



      //INSTANCE VARIABLES
    private Float hue;
    private Float saturation;
    private Float value;


    public HSVModel() {
        this(MAX_H, MAX_S, MAX_V);
    }

    public HSVModel(Float hue, Float saturation, Float value){
        super();

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;

    }

    public void asBlack() {
        this.setHSV(0f,0.0f,0.0f);
    }


    public void asRed() {
        this.setHSV(0f,100.0f,100.0f);
    }

    public void asLime() {
        this.setHSV(120f,100.0f,100.0f);
    }

    public void asBlue() {
        this.setHSV(240f,100.0f,100.0f);
    }

    public void asYellow() {
        this.setHSV(60f,100.0f,100.0f);
    }

    public void asCyan() {
        this.setHSV(180f,100.0f,100.0f);
    }

    public void asMagenta() {
        this.setHSV(300f,100.0f,100.0f);
    }

    public void asSilver() {
        this.setHSV(0f,0.0f,0.75f);
    }

    public void asGray() {
        this.setHSV(0f,0.0f,0.5f);
    }

    public void asMaroon() {
        this.setHSV(0f,1.0f,0.5f);
    }

    public void asOlive() {
        this.setHSV(60f,1.0f,0.5f);
    }

    public void asGreen() {
        this.setHSV(120f,1.0f,0.5f);
    }

    public void asPurple() {
        this.setHSV(300f,1.0f,0.5f);
    }

    public void asTeal() {
        this.setHSV(180f,1.0f,0.5f);
    }

    public void asNavy() {
        this.setHSV(240f,1.0f,0.5f);
    }



    // GETTERS


    public Float getHue() {return hue;}
    public Float getSaturation() {
        return saturation;
    }
    public Float getValue() {return value;}

    // SETTERS


    public void setHue(Float hue) {
        this.hue = hue;

        this.updateObservers();
    }

    public void setSaturation(Float saturation) {
        this.saturation = saturation;

        this.updateObservers();
    }

    public void setValue(Float value) {
        this.value = value;

        this.updateObservers();
    }

    // Convenient setter: set H, S, V
    public void setHSV(Float hue, Float saturation, Float value) {
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;


        this.updateObservers();
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }



    public String hueToString(){
        return "" + hue.intValue() + "\u00B0";
    }
    public String saturationToString(){
        return "" + saturation ;
    }
    public String valueToString(){
        return "" + value ;
    }

    @Override
    public String toString() {
        return "HSV [h=" + hue + "\u00B0" + " s=" + saturation + "\u0025" + " v=" + value + "\u0025"+  "]";
    }

    // Proof that my model is independent of any view.
    public static void main(String[] args) {
        HSVModel model = new HSVModel(0.f, 0.f, 0.f);

        System.out.println(model);
    }




}
