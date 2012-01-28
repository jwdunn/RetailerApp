package com.BeerDropper.www;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ScanId extends Activity implements OnClickListener {


	ImageView imageCaptured;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scanid);

		//Camera Button
		Button buttonImageFront = (Button)findViewById(R.id.FrontID);
		buttonImageFront.setOnClickListener(this);
		
		//Camera Button Back
		Button buttonImageBack = (Button)findViewById(R.id.BackID);
		buttonImageBack.setOnClickListener(this);
		
		imageCaptured = (ImageView)findViewById(R.id.imagefront);
	}
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.FrontID:
			Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, 0);
			break;
		case R.id.BackID:
			Intent j = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(j, 0);
			break;
	
}
};
//This method saves the picture on the screen
@Override
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

}