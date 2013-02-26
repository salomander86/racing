package com.example.ar;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.View;

public class ObstacleTank extends View implements Runnable  {

	int x, y;
	Bitmap bigObstacle;
	int sleep = 7500;
	
	MyCar mc = new MyCar(getContext());
	
	public ObstacleTank(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		Rect rectOT = new Rect();
		rectOT.contains(x, y, 150, 314);
	}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true){
				Random random = new Random();
				try {

					
						bigObstacle = BitmapFactory.decodeResource(getResources(), R.drawable.tank);
						x = random.nextInt(380);
						y = -320;

					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void move(){
			y +=mc.v;
		}	
}
