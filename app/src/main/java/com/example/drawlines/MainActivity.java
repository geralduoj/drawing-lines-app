package com.example.drawlines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static LinearLayout device;
    LinearLayout UIControls;
    LinearLayout UIControls1;
    LinearLayout UIControls2;
    LinearLayout UIControls3;
    RelativeLayout UILast;

    TextView lineThick, lineColor, arrowKeys;
    static Spinner lineThickness;
    public static RadioGroup rgb_Group;
    RadioButton red, yellow, cyan;

    public static int startX;
    public static int startY;
    public static int endX = 0;
    public static int endY = 0;

    static Button clear, reset;
    ImageButton up, down, left, right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        device = new LinearLayout(this);
        LinearLayout.LayoutParams deviceParameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        device.setLayoutParams(deviceParameters);
        device.setOrientation(LinearLayout.VERTICAL);

        UIControls = new LinearLayout(this);
        LinearLayout.LayoutParams UIControlsParameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        UIControls.setLayoutParams(UIControlsParameters);
        UIControls.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams UIControls1ParametersAlign = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);


        /**clear = new Button(this);
        clear.setText("Clear");
        clear.setLayoutParams(UIControls1ParametersAlign);
        reset = new Button(this);
        reset.setText("Reset");
        reset.setLayoutParams(UIControls1ParametersAlign);**/







        UIControls1 = new LinearLayout(this);
        LinearLayout.LayoutParams UIControls1Parameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);

        UIControls1.setLayoutParams(UIControls1Parameters);
        UIControls1.setOrientation(LinearLayout.VERTICAL);
        lineThick = new TextView(this);
        lineThick.setText("Line Thickness");


        List<String> thicknessDigits = new ArrayList<String>();
        thicknessDigits.add("10");
        thicknessDigits.add("20");
        thicknessDigits.add("30");
        thicknessDigits.add("40");
        thicknessDigits.add("50");

        ArrayAdapter<String> thicknessAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_dropdown_item,thicknessDigits
        );
        lineThickness = new Spinner(this);
        //lineThickness.setScrollBarSize(6);
        lineThickness.setAdapter(thicknessAdapter);
        LinearLayout.LayoutParams spinnerSize = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        lineThickness.setLayoutParams(spinnerSize);
        lineThick.setLayoutParams(spinnerSize);
        UIControls1.addView(lineThick);
        UIControls1.addView(lineThickness);
        //UIControls1.setBackgroundColor(Color.RED);
        //UIControls1.addView(clear);
        //UIControls1.addView(reset);

        UIControls2 = new LinearLayout(this);
        LinearLayout.LayoutParams UIControls2Parameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);
        UIControls2.setLayoutParams(UIControls2Parameters);
        UIControls2.setOrientation(LinearLayout.VERTICAL);
        lineColor = new TextView(this);
        lineColor.setText("Line Color");
        lineColor.setLayoutParams(UIControls1ParametersAlign);
        rgb_Group = new RadioGroup(this);
        rgb_Group.setOrientation(LinearLayout.VERTICAL);
        DrawerApp.redd = new RadioButton(this);
        DrawerApp.redd.setText("Red");
        rgb_Group.addView(DrawerApp.redd);
        DrawerApp.yelloww= new RadioButton(this);
        DrawerApp.yelloww.setText("Yellow");
        rgb_Group.addView(DrawerApp.yelloww);
        DrawerApp.cyann = new RadioButton(this);
        DrawerApp.cyann.setText("Cyan");
        rgb_Group.addView(DrawerApp.cyann);
        rgb_Group.setLayoutParams(UIControls1ParametersAlign);
        UIControls2.addView(lineColor);
        UIControls2.addView(rgb_Group);
        //UIControls2.setBackgroundColor(Color.GREEN);



        UIControls3 = new LinearLayout(this);
        LinearLayout.LayoutParams UIControls3Parameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT,1.0f);
        UIControls3.setLayoutParams(UIControls3Parameters);
        UIControls3.setOrientation(LinearLayout.VERTICAL);
        arrowKeys = new TextView(this);
        arrowKeys.setText("Arrow Keys");
        UIControls3.addView(arrowKeys);
        //UIControls3.setBackgroundColor(Color.RED);

        UILast = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeAlign = new RelativeLayout.LayoutParams(350,ViewGroup.LayoutParams.MATCH_PARENT);
        RelativeLayout.LayoutParams arrowAlign = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams arrowAlignRight = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams arrowAlignLeft = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams arrowAlignDown = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        UILast.setLayoutParams(relativeAlign);
        //UILast.setBackgroundColor(Color.BLUE);

        /**arrowKeys = new TextView(this);
        arrowKeys.setText("Arrow Keys");
        arrowKeys.setLayoutParams(arrowAlign);
        UILast.addView(arrowKeys);
        clear = new Button(this);
        clear.setText("^");
        clear.setLayoutParams(arrowAlign);**/

        //arrowAlign.width = 50;
        arrowAlign.addRule(RelativeLayout.CENTER_HORIZONTAL);
        DrawerApp.upp = new ImageButton(this);
        DrawerApp.upp.setImageResource(R.drawable.up18);
        DrawerApp.upp.setBackgroundColor(Color.WHITE);
        DrawerApp.upp.setPadding(20,20,20,20);
        DrawerApp.upp.setLayoutParams(arrowAlign);
        UILast.addView(DrawerApp.upp);

        arrowAlignDown.addRule(RelativeLayout.CENTER_HORIZONTAL);
        arrowAlignDown.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        DrawerApp.downn = new ImageButton(this);
        DrawerApp.downn.setImageResource(R.drawable.down18);
        DrawerApp.downn.setBackgroundColor(Color.WHITE);
        DrawerApp.downn.setPadding(20,20,20,20);
        DrawerApp.downn.setLayoutParams(arrowAlignDown);
        UILast.addView(DrawerApp.downn);

        /**arrowAlignRight.addRule(RelativeLayout.CENTER_IN_PARENT);
        arrowAlignRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        right = new ImageButton(this);
        right.setImageResource(R.drawable.right18);
        right.setBackgroundColor(Color.WHITE);
        right.setPadding(20,20,20,20);
        right.setLayoutParams(arrowAlignRight);
        UILast.addView(right);**/

        arrowAlignRight.addRule(RelativeLayout.CENTER_IN_PARENT);
        arrowAlignRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        DrawerApp.rightt = new ImageButton(this);
        DrawerApp.rightt.setImageResource(R.drawable.right18);
        DrawerApp.rightt.setBackgroundColor(Color.WHITE);
        DrawerApp.rightt.setPadding(20,20,20,20);
        DrawerApp.rightt.setLayoutParams(arrowAlignRight);
        UILast.addView(DrawerApp.rightt);

        arrowAlignLeft.addRule(RelativeLayout.CENTER_IN_PARENT);
        arrowAlignLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        DrawerApp.leftt = new ImageButton(this);
        DrawerApp.leftt.setImageResource(R.drawable.left18);
        DrawerApp.leftt.setBackgroundColor(Color.WHITE);
        DrawerApp.leftt.setPadding(20,20,20,20);
        DrawerApp.leftt.setLayoutParams(arrowAlignLeft);
        UILast.addView(DrawerApp.leftt);

        /**
        arrowAlignRight.addRule(RelativeLayout.CENTER_IN_PARENT);
        arrowAlignRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        right = new ImageButton(this);
        right.setImageResource(R.drawable.right18);
        right.setBackgroundColor(Color.WHITE);
        right.setPadding(20,20,20,20);
        right.setLayoutParams(arrowAlignRight);
        UILast.addView(right);
         **/


        UIControls3.addView(UILast);


        clear = new Button(this);
        clear.setText("Clear Canvas");
        clear.setLayoutParams(spinnerSize);
        UIControls.addView(UIControls1);
        UIControls.addView(UIControls2);
        UIControls.addView(UIControls3);



        device.addView(UIControls);
        device.addView(clear);
        device.addView(new DrawerApp(this));

        setContentView(device);
    }
}
