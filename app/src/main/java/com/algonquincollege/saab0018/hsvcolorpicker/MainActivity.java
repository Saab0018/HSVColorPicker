package com.algonquincollege.saab0018.hsvcolorpicker;

import android.app.DialogFragment;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Observable;
import java.util.Observer;

import HSVModel.HSVModel;


/**
 * The Controller for HSVModel.
 * <p>
 * As the Controller:
 * a) event handler for the View
 * b) observer of the Model (HSVModel)
 * <p>
 * Features the Update / React Strategy.
 *
 * @author Matt Saab (saab0018)
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener {

    private static final String ABOUT_DIALOG_TAG;
    private static final int HUE;
    private static final int SATURATION;
    private static final int VALUE;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";
        HUE = 0;
        SATURATION = 1;
        VALUE = 2;

    }
    private static final String LOG_TAG = "HSV";

    //private AboutDialogFragment mAboutDialog;
    private TextView mColorSwatch;
    private HSVModel mModel;
    private SeekBar mHueSB;
    private SeekBar mSaturationSB;
    private SeekBar mValueSB;
    private float[] mHSV = new float[]{0.f,0.f,0.f};
    private TextView mHuePrompt;
    private TextView mSaturationPrompt;
    private TextView mValuePrompt;



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mModel = new HSVModel();
        mModel.setHue(HSVModel.MIN_H);
        mModel.setSaturation(HSVModel.MIN_S);
        mModel.setValue(HSVModel.MIN_V);
        mModel.addObserver(this);

        // reference each View
        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        mHueSB = (SeekBar) findViewById(R.id.hueSB);
        mSaturationSB = (SeekBar) findViewById(R.id.saturationSB);
        mValueSB = (SeekBar) findViewById(R.id.lightnessSB);
        mHuePrompt = (TextView) findViewById(R.id.hueValue);
        mSaturationPrompt = (TextView) findViewById(R.id.saturationValue);
        mValuePrompt = (TextView) findViewById(R.id.valueValue);

        mHueSB.setMax((int) HSVModel.MAX_H);
        mSaturationSB.setMax((int) HSVModel.MAX_S);
        mValueSB.setMax((int) HSVModel.MAX_V);


        // set the domain (i.e. max) for each component

        mHueSB.setOnSeekBarChangeListener(this);
        mSaturationSB.setOnSeekBarChangeListener(this);
        mValueSB.setOnSeekBarChangeListener(this);


        this.updateView();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if (!fromUser) {
            return;
        }

        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mHSV[HUE] = (float) progress;
                mModel.setHue(mHSV[HUE]);
                mHuePrompt.setText(mModel.hueToString());

                break;

            case R.id.saturationSB:
                mHSV[SATURATION] = (float) progress;
                mModel.setSaturation(mHSV[SATURATION]);
                mSaturationPrompt.setText(mModel.saturationToString());
                break;

            case R.id.lightnessSB:
                mHSV[VALUE] = (float) progress;
                mModel.setValue(mHSV[VALUE]);
                mValuePrompt.setText(mModel.valueToString());
                break;
        }

    }


    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }


    public void onStopTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }


    @Override
    public void update(Observable observable, Object data) {

        this.updateView();
    }


    private void updateColorSwatch() {
        mColorSwatch.setBackgroundColor((int)mModel.getColor());
    }

    private void updateHueSB() {

        mHueSB.setProgress((int) mModel.getHue());
        //Log.d("Hue", "" + mModel.getHue());
    }

    private void updateSaturationSB() {

        mSaturationSB.setProgress((int) mModel.getSaturation());
        //Log.d("Saturation", "" + mModel.getSaturation());
    }

    private void updateValueSB() {

        mValueSB.setProgress((int) mModel.getValue());
        //Log.d("Value", "" + mModel.getValue());
    }

    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();

    }

    public void clearTextViews() {

        mValuePrompt.setText("");
        mSaturationPrompt.setText("");
        mHuePrompt.setText("");
    }

    public boolean colorButtonClick(View button) {

        switch (button.getId()) {


            case R.id.blackButton:
                mModel.asBlack();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.redButton:
                mModel.asRed();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.limeButton:
                mModel.asLime();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.blueButton:
                mModel.asBlue();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.yellowButton:
                mModel.asYellow();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_LONG).show();
                break;

            case R.id.cyanButton:
                mModel.asCyan();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.magentaButton:
                mModel.asMagenta();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.silverButton:
                mModel.asSilver();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.grayButton:
                mModel.asGray();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.maroonButton:
                mModel.asMaroon();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.oliveButton:
                mModel.asOlive();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.greenButton:
                mModel.asGreen();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.purpleButton:
                mModel.asPurple();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.tealButton:
                mModel.asTeal();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.navyButton:
                mModel.asNavy();
                clearTextViews();
                Toast.makeText(this, mModel.toString(), Toast.LENGTH_SHORT).show();
                break;


            default:

                return true;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
