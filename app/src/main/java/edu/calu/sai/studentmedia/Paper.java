package edu.calu.sai.studentmedia;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class Paper extends AppCompatActivity
{
	String[] issues = {"https://image.isu.pub/171109202353-7b5e6cd70cebf6fd5a43131f2303690e/jpg/page_1_thumb_large.jpg"};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.paper);
		issues();
	}

	public void back(View v)
	{
		Intent intent = new Intent(this, Home.class);
		startActivity(intent);
	}

	private void issues()
	{
	    Drawable[] papers = new Drawable[8];
        for(int i = 0; i < issues.length; i++)
            papers[i] = image(issues[i]);

        ImageView i = findViewById(R.id.i1);
        i.setImageDrawable(papers[0]);
	}

	public static Drawable image(String url)
	{
		try
		{
			InputStream is = (InputStream) new URL(url).getContent();
			Drawable d = Drawable.createFromStream(is, "src name");

			return d;
		}catch (Exception e)
		{
			return null;
		}
	}
}
