package com.nested.flyingfishgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class FlyingFishView extends View {

    private Bitmap fish[]=new Bitmap[2];
    private Bitmap backgroundImage;
    private Paint scorePaint=new Paint();
    private Bitmap life[]=new Bitmap[2];

    private int fishX=10;
    private  int fishY;
    private  int fishSpeed;
    private int canvasWidth,canvasHight;
    private boolean touch=false ;

    public FlyingFishView(Context context) {
        super(context);
        fish[0]= BitmapFactory.decodeResource(getResources(),R.drawable.fish1);
        fish[1]=BitmapFactory.decodeResource(getResources(),R.drawable.fish2);
        backgroundImage=BitmapFactory.decodeResource(getResources(),R.drawable.background);

        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(60);
        scorePaint.setTypeface(Typeface.DEFAULT);
        scorePaint.setAntiAlias(true);
        life[0]=BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1]=BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);

        fishY=550;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWidth=canvas.getWidth();
        canvasHight=canvas.getHeight();

        canvas.drawBitmap(backgroundImage,0,0,null);

        int minFishY=fish[0].getHeight();
        int maxFishY=canvasHight-fish[0].getHeight()*2;
        fishY=fishY+fishSpeed;

        if(fishY<minFishY)
        {
            fishY=minFishY;
        }
        if(fishY>maxFishY)
        {
            fishY=maxFishY;
        }
        fishSpeed=fishSpeed+2;

        if(touch)
        {
            canvas.drawBitmap(fish[1],fishX,fishY,null);
            touch=false;
        }
        else {
            canvas.drawBitmap(fish[0],fishX,fishY,null);
        }


        canvas.drawText("Score",20,60,scorePaint);
        canvas.drawBitmap(life[0],680,10,null);
        canvas.drawBitmap(life[0],780,10,null);
        canvas.drawBitmap(life[0],880,10,null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {

            touch=true;
            fishSpeed=-22;
        }

        return  true;
    }
}
