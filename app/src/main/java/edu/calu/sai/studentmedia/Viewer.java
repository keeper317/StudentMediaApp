
package edu.calu.sai.studentmedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;


class Viewer extends AppCompatActivity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewer);

		String s = getIntent().getStringExtra("Path");

		WebView wv = findViewById(R.id.viewer);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl("158.83.1.59/StudentMediaApp/Paper/" + s);
	}

	public void back(View v)
	{
		Intent intent = new Intent(this, Paper.class);
		startActivity(intent);
	}
}
