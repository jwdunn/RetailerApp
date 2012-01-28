package com.BeerDropper.www;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class DropOff extends Activity implements OnClickListener {

//	ImageView imageCaptured;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dropoff);

		//Camera Button
		Button buttonImageCapture = (Button)findViewById(R.id.get_image);
		buttonImageCapture.setOnClickListener(this);


//		imageCaptured = (ImageView)findViewById(R.id.imagecaptured);

		//Signature Button
		Button sign = (Button)findViewById(R.id.get_signature);
		sign.setOnClickListener(this);

		/*	//Call Button
   	Button call = (Button)findViewById(R.id.get_call);
		call.setOnClickListener(phone);

		 */
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
