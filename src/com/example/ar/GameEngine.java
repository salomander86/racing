package com.example.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class GameEngine extends View {

	int offset = 30;
	MyCar mc = new MyCar(getContext());
	Road r = new Road(getContext());
	Button bLeft, bRight;
	Paint p = new Paint();
	Message msg;
	MotionEvent event;
	// Button leftButton, rightButton;

	ObstacleTank tank = new ObstacleTank(getContext());
	Thread tankFactory = new Thread(tank);

	ObstacleCar car = new ObstacleCar(getContext());
	Thread carFactory = new Thread(car);

	public GameEngine(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		tankFactory.start();

		carFactory.start();
		// leftButton.setHeight(800);
		// leftButton.setWidth(240);
		// leftButton.setSystemUiVisibility(0);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Message msg = Message.obtain();
			msg.what = R.id.move_car;
			msg.obj = event;
			sHandler.sendMessage(msg);
			break;
		}

		// case MotionEvent.ACTION_MOVE:
		// if (mc.carX < (event.getX() - offset))
		// mc.isTurnRight = true;
		// if (mc.carX > (event.getX() - offset))
		// mc.isTurnLeft = true;
		// if (mc.carX == (event.getX() - offset)) {
		// mc.isTurnRight = false;
		// mc.isTurnLeft = false;
		// }
		// mc.carX = (int) event.getX() - offset;
		// invalidate();
		// break;
		//
		// case MotionEvent.ACTION_UP:
		// mc.isTurnRight = false;
		// mc.isTurnLeft = false;
		// break;

		return true;
	}

	private Handler sHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case R.id.move_car:
				MotionEvent event = (MotionEvent) msg.obj;
				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					if (mc.carX < (event.getX() - offset)) {
						mc.isTurnRight = true;
						// while (mc.carX < (event.getX() - offset)) {
						mc.carX += 1;
						// invalidate();
						// break;
						// }
					} else if (mc.carX > (event.getX() - offset)) {
						mc.isTurnLeft = true;
						// while (mc.carX > (event.getX() - offset)) {
						mc.carX -= 1;
						// invalidate();
						// break;
						// }
					} else {
						mc.isTurnRight = false;
						mc.isTurnLeft = false;
					}
					// mc.carX = (int) ev.getX() - 30;
					invalidate();

					Message msg2 = Message.obtain();
					msg2.what = msg.what;
					msg2.obj = msg.obj;
					sHandler.sendMessageDelayed(msg2, 1000);
					break;

				}

			}

		}

	};

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		car.move();
		tank.move();
		r.move();

		canvas.drawBitmap(r.road, r.road1X, r.road1Y, p);
		canvas.drawBitmap(r.road, r.road2X, r.road2Y, p);
		canvas.drawBitmap(tank.bigObstacle, tank.x, tank.y, p);
		canvas.drawBitmap(car.smallObstacle, car.x, car.y, p);

		if (mc.isTurnRight) {
			canvas.drawBitmap(mc.carTurnRight, mc.carX, mc.carY, p);
		} else if (mc.isTurnLeft) {
			canvas.drawBitmap(mc.carTurnLeft, mc.carX, mc.carY, p);
		} else {
			canvas.drawBitmap(mc.myCar, mc.carX, mc.carY, p);
		}

		mc.s += mc.v;
		invalidate();
	}

}
