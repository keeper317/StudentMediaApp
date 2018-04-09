package edu.calu.sai.studentmedia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import static com.google.android.youtube.player.YouTubeIntents.canResolvePlayPlaylistIntent;
import static com.google.android.youtube.player.YouTubeIntents.createPlayPlaylistIntent;

public class TV extends YouTubeBaseActivity
{
	String list = "PLmaXXPYLkvUKKndbZ_yvWtOnkj8qBnVoj";//gary
	String list2 = "PLD90D761AA773ACB8";//cutv2
	String list3 = "PLmaXXPYLkvULsZrnwjtJuJohelsM4BZ0Z";//cutv3
	YouTubeThumbnailView view, view2, view3;
	ImageButton back, menu;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tv);
		view = (YouTubeThumbnailView) findViewById(R.id.garyShow);
		view2 = (YouTubeThumbnailView) findViewById(R.id.cutv2);
		view3 = (YouTubeThumbnailView) findViewById(R.id.cutv3);
		view.initialize(Config.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener()
		{
			@Override
			public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader loader)
			{
				loader.setPlaylist(list);
			}
			@Override
			public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult)
			{

			}
		});
		view2.initialize(Config.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener()
		{

			@Override
			public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader loader)
			{
				loader.setPlaylist(list2);
			}

			@Override
			public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult)
			{

			}
		});
		view3.initialize(Config.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener()
		{

			@Override
			public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader loader)
			{
				loader.setPlaylist(list3);
			}

			@Override
			public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult)
			{

			}
		});

		back = (ImageButton) findViewById(R.id.back);
		back.setVisibility(View.VISIBLE);
		back.setColorFilter(Color.WHITE);
		menu = (ImageButton) findViewById(R.id.menu);
		menu.setVisibility(View.VISIBLE);
	}

	public void back(View v)
	{
		finish();
	}

	public void YT(View v)
	{
		if(canResolvePlayPlaylistIntent(this))
		{
			startActivity(createPlayPlaylistIntent(this, list));
		}
		else
			back(v);
	}
	public void YT2(View v)
	{
		if(canResolvePlayPlaylistIntent(this))
		{
			startActivity(createPlayPlaylistIntent(this, list2));
		}
		else
			back(v);
	}
	public void YT3(View v)
	{
		if(canResolvePlayPlaylistIntent(this))
			startActivity(createPlayPlaylistIntent(this, list3));
		else
			back(v);
	}
}
