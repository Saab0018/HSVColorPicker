package HSVModel;


import android.graphics.Color;

import java.util.Observable;

/**
 * Created by mattsaab on 2016-10-18.
 */

public class HSVModel extends Observable {

    //CLASS VARIABLES
    public static final float MAX_H = 359.0f;
    public static final float MAX_S = 100.0f;
    public static final float MAX_V = 100.0f;
    public static final float MIN_H = 0.0f;
    public static final float MIN_S = 0.0f;
    public static final float MIN_V = 0.0f;

    // CLASS VARIABLES



      //INSTANCE VARIABLES
    private float hue;
    private float saturation;
    private float value;


    public HSVModel() {
        this(MAX_H, MAX_S, MAX_V);
    }

    public HSVModel(float hue, float saturation, float value){
        super();

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;

    }

    public void asBlack() {
        this.setHSV(0f,0.0f,0.0f);
    }


    public void asRed() {
        this.setHSV(0f,1.0f,1.0f);
    }

    public void asLime() {
        this.setHSV(120f,1.0f,1.0f);
    }

    public void asBlue() {
        this.setHSV(240f,1.0f,1.0f);
    }

    public void asYellow() {
        this.setHSV(60f,1.0f,1.0f);
    }

    public void asCyan() {
        this.setHSV(180f,1.0f,1.0f);
    }

    public void asMagenta() {
        this.setHSV(300f,1.0f,1.0f);
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


    public float getHue() {return hue;}
    public float getSaturation() {
        return saturation;
    }
    public float getValue() {return value;}
    public float getColor() {return Color.HSVToColor((new float[]{getHue(), getSaturation()/ 100, getValue()/100}));}

    // SETTERS


    public void setHue(float hue) {
        this.hue = hue;

        this.updateObservers();
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;

        this.updateObservers();
    }

    public void setValue(float value) {
        this.value = value;

        this.updateObservers();
    }

    // Convenient setter: set H, S, V
    public void setHSV(float hue, float saturation, float value) {
        this.hue = hue;
        this.saturation = saturation * 100;
        this.value = value * 100;


        this.updateObservers();
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }



    public String hueToString(){
        return "" + (int)hue + "\u00B0";
    }
    public String saturationToString(){
        return "" + (int)saturation + "\u0025" ;
    }
    public String valueToString(){
        return "" + (int)value + "\u0025";
    }

    @Override
    public String toString() {
        return "H:" + (int)hue + "\u00B0" + "S: " + (int)saturation + "\u0025" + "V: "+ (int)value + "\u0025";
    }

    // Proof that my model is independent of any view.
    public static void main(String[] args) {
        HSVModel model = new HSVModel(0.f, 0.f, 0.f);

        System.out.println(model);
    }




}
