package com.example.ar;

import android.graphics.Bitmap;

public class SmallObstacle {
	ObstacleCar oc = new ObstacleCar(null);
	
	public  SmallObstacle (int x, int y, Bitmap smallObstacle){
		oc.x = x;
		oc.y = y;
		oc.smallObstacle = smallObstacle;
	}
}
