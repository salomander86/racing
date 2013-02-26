package com.example.ar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.View;

public class ObstacleCar extends View implements Runnable {
	int x, y, onCase;
	int sleep = 3500;
	Bitmap smallObstacle;
	List<SmallObstacle> smallObstacles;
	Rect rectOC;

	MyCar mc = new MyCar(getContext());

	public ObstacleCar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		rectOC = new Rect();
		rectOC.contains(x, y, 60, 155);
//		Random random = new Random();
//		smallObstacles = new ArrayList<SmallObstacle>();
//		smallObstacles.add(new SmallObstacle(random.nextInt(410), -130,
//				smallObstacle = BitmapFactory.decodeResource(getResources(),
//						R.drawable.bug)));
//		smallObstacles.add(new SmallObstacle(random.nextInt(410), -130,
//				smallObstacle = BitmapFactory.decodeResource(getResources(),
//						R.drawable.blackcar)));
//		smallObstacles.add(new SmallObstacle(random.nextInt(410), -130,
//				smallObstacle = BitmapFactory.decodeResource(getResources(),
//						R.drawable.whitecar)));
//		smallObstacles.add(new SmallObstacle(random.nextInt(410), -130,
//				smallObstacle = BitmapFactory.decodeResource(getResources(),
//						R.drawable.redcar)));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Random random = new Random();
				// Iterator<SmallObstacle> i = smallObstacles.iterator();
				// while (i.hasNext()) {
				// SmallObstacle so = i.next();
				// if (y > 800) {
				// i.remove();
				// } else {
				// }
				// }
				onCase = (int) (Math.random()*4) + 1;
				switch (onCase){
				case 1:
					smallObstacle = BitmapFactory.decodeResource(getResources(),R.drawable.bug);
					break;
				case 2:
					smallObstacle = BitmapFactory.decodeResource(getResources(),R.drawable.blackcar);
					break;
				case 3:
					smallObstacle = BitmapFactory.decodeResource(getResources(),R.drawable.whitecar);
					break;
				case 4:
					smallObstacle = BitmapFactory.decodeResource(getResources(),R.drawable.redcar);
					break;
					
				}
				x = random.nextInt(410);
				y = -130;

				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void move() {
		y += mc.v;
	}

}
