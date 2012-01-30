package com.BeerDropper.www;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DropOff extends Activity implements OnClickListener {

//	ImageView imageCaptured;

	int phoneNumber=0;
	String address=null;
	String userName=null;
	int userID=0;
	String OrderList;
	Boolean orderStatus;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dropoff);

		   Bundle extras = getIntent().getExtras();  
		      if(extras !=null) {
		          userID = extras.getInt("userID");
		          userName = extras.getString("userName");
		          phoneNumber=extras.getInt("phoneNumber");
		          address =extras.getString("address");
		          orderStatus = extras.getBoolean("orderStatus");
		          OrderList = extras.getString("OrderList");
		      }
		     
		      
		      TextView ordertext = (TextView) findViewById(R.id.order);
		      ordertext.setText("User ID: "+ userID+ " \n"  + "Name: "+ userName + " \n" + "Phone: " + phoneNumber + " \n" + "Address: " + address + " \n" + " \n" + OrderList);
		//Camera Button
		Button buttonImageCapture = (Button)findViewById(R.id.get_image);
		buttonImageCapture.setOnClickListener(this);


//		imageCaptured = (ImageView)findViewById(R.id.imagecaptured);

		//Signature Button
		Button sign = (Button)findViewById(R.id.get_signature);
		sign.setOnClickListener(this);

		//complete Button
   	Button complete = (Button)findViewById(R.id.complete_order);
		complete.setOnClickListener(this);
		//
 	Button cancel = (Button)findViewById(R.id.cancel_order);
		  cancel.setOnClickListener(this);
		 
	}

	//Executes when the camera button is clicked

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.get_image:
			Intent j = new Intent(this, ScanId.class);
    		startActivity(j);
    		break;
		case R.id.get_signature:
			Intent i = new Intent(this, ManualSignActivity.class);
			startActivity(i);
			startActivityForResult(i, 0);
			this.finish();
			break;
		case R.id.cancel_order:
			Intent k = new Intent(this, DisplayOrdersDemo.class);
			startActivity(k);
			Toast.makeText(getApplicationContext(), "Order Cancelled it was moved to cancelled orders", Toast.LENGTH_LONG).show();
			break;
		case R.id.complete_order:
		   Intent m = new Intent(this, DisplayOrdersDemo.class);
		   Toast.makeText(getApplicationContext(), "Order Completed It was moved to completed orders",Toast.LENGTH_LONG).show();
		   startActivity(m);
		   break;
		}
			
	};
	//This method saves the picture on the screen
/*	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK)
		{
			Bundle extras = data.getExtras();
			Bitmap bmp = (Bitmap) extras.get("data");
			imageCaptured.setImageBitmap(bmp);
		}

	}
	*/
}
