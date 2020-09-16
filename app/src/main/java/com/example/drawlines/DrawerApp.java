package com.example.drawlines;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DrawerApp extends View {


    public int startX = 20;
    public int startY = 520;
    public int enderX = 20;
    public int enderY = 520;
    public static ImageButton upp;
    public static ImageButton rightt;
    public static ImageButton downn;
    public static ImageButton leftt;
    public static RadioButton redd;
    public static RadioButton yelloww;
    public static RadioButton cyann;
    public int height;
    public int width;
    public Canvas cana;
    Paint paint;
    Path linePath = new Path();

    List<Coordinates> coords = new ArrayList<Coordinates>();

    Coordinates startCoords = new Coordinates(startX, startY, enderX, enderY);


    public DrawerApp(final Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        coords.add(startCoords);

        //setBackgroundColor(Color.BLUE);

        MainActivity.clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String str = "FRAME CLEARED";
                Toast.makeText(context.getApplicationContext(),str, Toast.LENGTH_SHORT).show();
                coords.removeAll(coords);

                startX = 20;
                startY = 520;
                enderX = 20;
                enderY = 520;
                Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                coords.add(nextCoords);
                setBackgroundColor(0xFFFFFFFF);
            }
        });

        MainActivity.lineThickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                if(selectedItemText == "10")
                {
                    paint.setStrokeWidth(10);
                }
                if(selectedItemText == "20")
                {
                    paint.setStrokeWidth(20);
                }
                if(selectedItemText == "30")
                {
                    paint.setStrokeWidth(30);
                }
                if(selectedItemText == "40")
                {
                    paint.setStrokeWidth(40);
                }
                if(selectedItemText == "50")
                {
                    paint.setStrokeWidth(50);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        redd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                paint.setColor(Color.RED);

            }

        });
        yelloww.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                paint.setColor(Color.YELLOW);

            }

        });
        cyann.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                paint.setColor(Color.CYAN);

            }

        });
        //setOrientation(HORIZONTAL);
        //Button clear = new Button(context);
        upp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {


                String str = "Up Clicked";
                Toast.makeText(context.getApplicationContext(),str, Toast.LENGTH_SHORT).show();

                startX = enderX;
                startY = enderY;
                enderX = enderX;
                if((enderY - 0) <= 120)
                {
                    String str1 = "Sorry cant go further";
                    Toast.makeText(context.getApplicationContext(),str1, Toast.LENGTH_SHORT).show();
                    enderY = 20;
                    Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                    coords.add(nextCoords);
                    setBackgroundColor(0xFFFFFFFF);
                }
                else
                    {
                        enderY -= 120;

                        Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                        coords.add(nextCoords);
                        setBackgroundColor(0xFFFFFFFF);
                    }


                //invalidate();
                //cana.drawLine(120,120,20,420, paint);
                //startX = enderX;
                //startY = enderY;


            }
        });

        rightt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String str = "Right Clicked";
                Toast.makeText(context.getApplicationContext(),str, Toast.LENGTH_SHORT).show();

                startX = enderX;
                startY = enderY;
                if((width - 120) <= enderX)
                {
                    String str1 = "Sorry cant go further";
                    Toast.makeText(context.getApplicationContext(),str1, Toast.LENGTH_SHORT).show();
                    enderX = width - 20;
                    Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                    coords.add(nextCoords);
                    setBackgroundColor(0xFFFFFFFF);
                }
                else
                    {
                        enderX += 120;
                        enderY = enderY;
                        Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                        coords.add(nextCoords);
                        setBackgroundColor(0xFFFFFFFF);
                    }


                //invalidate();
                //cana.drawLine(120,120,20,420, paint);
                //startX = enderX;
                //startY = enderY;


            }
        });

        downn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String str = "Down Clicked";
                Toast.makeText(context.getApplicationContext(),str, Toast.LENGTH_SHORT).show();

                startX = enderX;
                startY = enderY;
                enderX = enderX;
                if((height - 120) <= enderY)
                {
                    String str1 = "Sorry cant go further";
                    Toast.makeText(context.getApplicationContext(),str1, Toast.LENGTH_SHORT).show();
                    enderY = height - 20;
                    Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                    coords.add(nextCoords);
                    setBackgroundColor(0xFFFFFFFF);
                }else
                    {
                        enderY += 120;
                        Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                        coords.add(nextCoords);
                        setBackgroundColor(0xFFFFFFFF);
                    }

                //invalidate();
                //drawLine(enderX, enderY);

            }
        });

        leftt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String str = "Left Clicked";
                Toast.makeText(context.getApplicationContext(),str, Toast.LENGTH_SHORT).show();

                startX = enderX;
                startY = enderY;
                enderX = enderX;
                if((enderX - 0) <= 120)
                {
                    String str1 = "Sorry cant go further";
                    Toast.makeText(context.getApplicationContext(),str1, Toast.LENGTH_SHORT).show();
                    enderX = 20;
                    Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                    coords.add(nextCoords);
                    setBackgroundColor(0xFFFFFFFF);
                }else
                    {
                        enderX -= 120;
                        Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
                        coords.add(nextCoords);
                        setBackgroundColor(0xFFFFFFFF);
                    }
                //invalidate();
                //drawLine(enderX, enderY);

            }
        });

    }

    public void goRight()
    {
        String str = "Right Clicked";
        //Toast.makeText(context.getApplicationContext(),str, Toast.LENGTH_SHORT).show();

        startX = enderX;
        startY = enderY;
        if((width - 120) <= enderX)
        {
            String str1 = "Sorry cant go further";
            //Toast.makeText(context.getApplicationContext(),str1, Toast.LENGTH_SHORT).show();
            enderX = width - 20;
            Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
            coords.add(nextCoords);
            setBackgroundColor(0xFFFFFFFF);
        }
        else
        {
            enderX += 120;
            enderY = enderY;
            Coordinates nextCoords = new Coordinates(startX, startY, enderX, enderY);
            coords.add(nextCoords);
            setBackgroundColor(0xFFFFFFFF);
        }
    }
    public void draw()
    {
        //can.drawLine(10,30,120,400, paint);
    }



    @Override
    protected void onDraw(Canvas canvas) {

        width = MainActivity.device.getChildAt(2).getWidth();
        height = MainActivity.device.getChildAt(2).getHeight();

        setBackgroundColor(0xFFFCFCFC);

        for(int i = 0; i<coords.size(); i++)
        {
            canvas.drawLine(coords.get(i).startX,coords.get(i).startY,coords.get(i).endX,coords.get(i).endY, paint);
        }
        canvas.drawLine(startX,startY,enderX,enderY, paint);
        //linePath.reset();
        //linePath.moveTo(0,0);
        //linePath.lineTo(120, 200);
        //canvas.drawPath(linePath, paint);
        //canvas.drawLine(0,0,120,120, paint);
        //invalidate();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_D:
                goRight();
                return true;

            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_F:
                goRight();
                return true;

            default:
                return super.onKeyUp(keyCode, event);
        }
    }
}
