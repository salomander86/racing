package com.example.ar;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class ObstacleCar extends View implements Runnable {
	int x, y;
	int sleep = 3500;
	Bitmap smallObstacle;
	
	MyCar mc = new MyCar(getContext());
	
	public ObstacleCar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true){
				Random random = new Random();
				try {

					
						smallObstacle = BitmapFactory.decodeResource(getResources(), R.drawable.bug);
						x = random.nextInt(410);
						y = -130;

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
