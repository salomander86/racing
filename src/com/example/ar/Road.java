package com.example.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class Road extends View {
	
	Bitmap road;
	int road1X, road1Y, road2X, road2Y;
	
	MyCar mc = new MyCar(getContext());
	
	public Road(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		road = BitmapFactory.decodeResource(getResources(), R.drawable.road2white);
		road1X = 0;
		road1Y = 0;
		road2X = 0;
		road2Y = -800;
		
	}
	
	public void move (){
		road1Y +=mc.v;
		road2Y +=mc.v;

	if (road1Y < 800){
		road1Y +=mc.v;
	}else{
		road1Y = -790;
	}
	if (road2Y < 800){
		road2Y +=mc.v;
	}else{
		road2Y = -790;
	}
 }

}
