package edu.calu.sai.studentmedia;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

public class Radio extends AppCompatActivity
{
	protected final String url = "http://184.154.90.186:8002/stream";

	MediaPlayer player = null;
	ImageView play;
	ImageView pause;
	AudioManager audio;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		initUI();
		initPlayer();
		audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode) {
			case KeyEvent.KEYCODE_VOLUME_UP:
				audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
				                         AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
				return true;
			case KeyEvent.KEYCODE_VOLUME_DOWN:
				audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
				                         AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
				return true;
			default:
				return false;
		}
	}
	private void initUI()
	{
		play = (ImageView) findViewById(R.id.play);
		play.setVisibility(View.VISIBLE);
		pause = (ImageView) findViewById(R.id.pause);
		pause.setVisibility(View.INVISIBLE);
	}
	private void initPlayer()
	{
		if(player == null)
		{
			player = new MediaPlayer();
			try
			{
				player.setDataSource(url);
				player.prepareAsync();
				player.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
				{
					@Override
					public void onPrepared(MediaPlayer mp)
					{
						Handler handler = new Handler();
						handler.postDelayed(new Runnable()
						{
							@Override
							public void run()
							{
								player.start();
								play.setVisibility(View.INVISIBLE);
								pause.setVisibility(View.VISIBLE);
							}
						}, 5000);/*
						player.start();
						play.setVisibility(View.INVISIBLE);
						pause.setVisibility(View.VISIBLE);*/
					}
				});
			} catch(Exception e)
			{
				System.out.println("Error here:" + e.getMessage());
			}
		}
	}
	public void back(View v)
	{
		Intent intent = new Intent(this, Home.class);
		startActivity(intent);
	}
	public void dial(View v)
	{
		try {
			Intent callIntent = new Intent(Intent.ACTION_DIAL);
			callIntent.setData(Uri.parse("tel:(724) 938-3000"));
			startActivity(callIntent);
		} catch (ActivityNotFoundException activityException)
		{}

	}
	public void stationControl(View v)
	{
		if(player.isPlaying())
		{
			player.pause();
			play.setVisibility(View.VISIBLE);
			pause.setVisibility(View.INVISIBLE);
		}
		else
		{
			player.start();
			play.setVisibility(View.INVISIBLE);
			pause.setVisibility(View.VISIBLE);
		}
	}
}