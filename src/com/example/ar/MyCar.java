package com.example.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class MyCar extends View {
	int carX, carY, v, s;
	Bitmap myCar, carTurnLeft, carTurnRight;
	boolean isTurnLeft, isTurnRight;

	public MyCar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		myCar = BitmapFactory.decodeResource(getResources(),
				R.drawable.cartextureup);

		carTurnRight = BitmapFactory.decodeResource(getResources(),
				R.drawable.carturnright);

		carTurnLeft = BitmapFactory.decodeResource(getResources(),
				R.drawable.carturnleft);
		carX = 100;
		carY = 550;
		v = 5;

	}
	
	

}
