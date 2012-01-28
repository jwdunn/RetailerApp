package com.BeerDropper.www;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class OrderActivity extends Activity implements OnClickListener {

	ImageView imageCaptured;
	
	/* get data from previous activity*/
	String phoneNumber=null;
	String address=null;
	String userName=null;
	String userID=null;
	Boolean orderStatus;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		/** this Grabs datas from last intent
		 * 
		 */
	      Bundle extras = getIntent().getExtras();  
	      if(extras !=null) {
	          userID = extras.getString("userID");
	          userName = extras.getString("userName");
	          phoneNumber=extras.getString("phoneNumber");
	          address=extras.getString("address");
	          orderStatus = extras.getBoolean("orderStatus");
	      }

		/* This creates a yes no box to ask the user wheather they accept the order or not
		 */
		
		if (orderStatus == false){            
		AlertDialog.Builder alert_box=new AlertDialog.Builder(this);
		alert_box.setMessage("Accept Order?");
		alert_box.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
				   
				   @Override
				   public void onClick(DialogInterface dialog, int which) {
				    // TODO Auto-generated method stub
				    Toast.makeText(getApplicationContext(), "Order Accepted",Toast.LENGTH_LONG).show();
				    orderStatus = true;
				   }
				  });
				alert_box.setNegativeButton("No", new DialogInterface.OnClickListener() {
				   
				   @Override
				   public void onClick(DialogInterface dialog, int which) {
				    // TODO Auto-generated method stub
				    Toast.makeText(getApplicationContext(), "Order Cancelled it was moved to cancelled orders", Toast.LENGTH_LONG).show();
				   }
				  });
				alert_box.show();
   	}

		
		//Drop Off
		View dropoffbutton = findViewById(R.id.dropoff);
        dropoffbutton.setOnClickListener(this);

		//Navigation Button
		Button nav = (Button)findViewById(R.id.get_directions);
		nav.setOnClickListener(this);

		//Call Button
		Button call = (Button)findViewById(R.id.get_call);
		call.setOnClickListener(this);

	}

	//Executes when the camera button is clicked
		@Override
		public void onClick(View v) {

	    	switch (v.getId()) {
	    	case R.id.dropoff:
	    		Intent j = new Intent(this, DropOff.class);
	    		startActivity(j);
	    		break;
	    	case R.id.get_directions:
	    		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+address)); 
	    		startActivity(i);
	    		break;
	    	case R.id.get_call:
	    		Uri number = Uri.parse("tel:" + phoneNumber);
				Intent dial = new Intent(Intent.ACTION_DIAL, number);
				startActivity(dial);
				startActivity(Intent.createChooser(dial, "select dialer"));
    			//startActivity(new Intent(this,ManualSignActivity.class));
				break;	
	    	}

	};

}