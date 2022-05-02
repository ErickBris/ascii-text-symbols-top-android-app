package com.t4t.helpers;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

public class AdsHelper {
	
	private static String packageName;
	private static InterstitialAd admobInterstitial;
	private static StartAppAd startAppAd;
	
	
	public static void initializeAds(final Context context, Bundle savedInstanceState)
	{
		
		packageName = context.getPackageName();
		
		if(ApplicationConstants.isAmazonStore)
			ApplicationConstants.RATE_APP_URL = "http://www.amazon.com/gp/mas/dl/android?p="+packageName;
		else if(ApplicationConstants.isGooglePlayStore)
			ApplicationConstants.RATE_APP_URL = "https://play.google.com/store/apps/details?id="+packageName;
		else if(ApplicationConstants.isSamsungStore)
			ApplicationConstants.RATE_APP_URL = "samsungapps://ProductDetail/"+packageName;
	
		if(ApplicationConstants.isAdsEnabled)
		{			
			//Initialize Admob Ads
	       if(ApplicationConstants.isAdmobInterstitialAdsEnabled)
	       {
	    	   ((Activity) context).runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					initializeAdmob(context);	
				}
			});
	    	   }
	       
	       //Initialize Startapp
	       if(ApplicationConstants.isStartAppInterEnabled)
	       {
		       StartAppSDK.init(context, ApplicationConstants.STARTAPP_DEVELOPER_ID, ApplicationConstants.STARTAPP_APP_ID, true);
		       startAppAd = new StartAppAd(context);
		       StartAppAd.showSplash((Activity) context, savedInstanceState);
		       startAppAd.loadAd();
	       }
	       
		}
	}
	public static void addStartAppSlider(Activity context) {
		// TODO Auto-generated method stub
		if(ApplicationConstants.isStartAppInterEnabled)
			StartAppAd.showSlider(context);
	}
	
	public static void showInterstitialAds(final Context context)
	{
		if(ApplicationConstants.isAdsEnabled)
		{
			//if((int)(Math.random()*10000) % 2 ==0 )
			{
				 if(ApplicationConstants.isAdmobInterstitialAdsEnabled && admobInterstitial.isLoaded())
				 {
					 admobInterstitial.show();
				 }
			}
			
		}
			
	}
	
	public static void showBannerAds(final Context context,View v)
	{
		if(ApplicationConstants.isAdsEnabled)
		{
			 final LinearLayout layout=(LinearLayout)v;
			 layout.removeAllViews();
			  if(ApplicationConstants.isAdmobBannerAdsEnabled)
				 showAdmobBannerAds(context, layout);
				
		}else
			v.setVisibility(View.GONE);
		 
	}
	
	public static void showAdmobBannerAds(final Context context,final LinearLayout view)
	{
		 if(ApplicationConstants.isAdmobBannerAdsEnabled && ApplicationConstants.isAdsEnabled)
		 {
				AdView admobBannerAds = new AdView((Activity) context);
				admobBannerAds.setAdListener(new AdListener() {
					
					@Override
					public void onAdClosed() {
						super.onAdClosed();
						
					}
		
					@Override
					public void onAdFailedToLoad(int errorCode) {
						// TODO Auto-generated method stub
						view.setVisibility(View.GONE);
						super.onAdFailedToLoad(errorCode);
						
					}
		
					@Override
					public void onAdLeftApplication() {
						// TODO Auto-generated method stub
						super.onAdLeftApplication();
					}
		
					@Override
					public void onAdLoaded() {
						// TODO Auto-generated method stub
						view.setVisibility(View.VISIBLE);
						super.onAdLoaded();
					}
		
					@Override
					public void onAdOpened() {
						// TODO Auto-generated method stub
						super.onAdOpened();
					}
					
					
		
		
				});
				 
				admobBannerAds.setAdUnitId(ApplicationConstants.Admob_BANNER_ADS_ID);
				admobBannerAds.setAdSize(AdSize.SMART_BANNER);
				
				 AdRequest adRequest=  new AdRequest.Builder().build();
				 
				 admobBannerAds.loadAd(adRequest);

				 view.addView(admobBannerAds);
		 }
	}
	
	private static void initializeAdmob(Context context) {
		admobInterstitial = new InterstitialAd( context);
		admobInterstitial.setAdUnitId(ApplicationConstants.Admob_FLLPAGE_ADS_ID);
		AdRequest adRequest = new AdRequest.Builder().build();
		admobInterstitial.setAdListener(new AdListener() {
				
				@Override
				public void onAdClosed() {
					// TODO Auto-generated method stub
					admobInterstitial.loadAd(new AdRequest.Builder().build());
					super.onAdClosed();
					
				}
	
				@Override
				public void onAdFailedToLoad(int errorCode) {
					// TODO Auto-generated method stub
					super.onAdFailedToLoad(errorCode);
					
				}
	
				@Override
				public void onAdLeftApplication() {
					// TODO Auto-generated method stub
					super.onAdLeftApplication();
				}
	
				@Override
				public void onAdLoaded() {
					// TODO Auto-generated method stub
					super.onAdLoaded();
				}
	
				@Override
				public void onAdOpened() {
					// TODO Auto-generated method stub
					super.onAdOpened();
				}
				
				
	
	
			});
		admobInterstitial.loadAd(adRequest);
	}

	public static void destroyAds(Activity m_context) {
		
	}

	public static void stopAds(Activity m_context) {
		
	}

	public static void onRateAppClick(Activity m_context) {
		Uri uri = Uri.parse(ApplicationConstants.RATE_APP_URL);
		Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
		m_context.startActivity(goToMarket);
	}

	public static void showAdsOnExit(final Activity m_context) {
		((Activity)m_context).runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
//				if(startAppAd!=null)
//					startAppAd.onBackPressed();
				showInterstitialAds(m_context);
				m_context.finish();
			}
		});
		
	}

	public static void openURL(Activity m_context, String url) {
		Uri uri = Uri.parse(url);
		Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
		m_context.startActivity(goToMarket);
	}


	public static void onShareAppClick(Activity m_context) {
		Intent shareIntent = new Intent();
	    shareIntent.setAction(Intent.ACTION_SEND);
	    String str = ApplicationConstants.SHARE_TEXT + ApplicationConstants.RATE_APP_URL;
	    shareIntent.putExtra(Intent.EXTRA_TEXT, str);
	    shareIntent.setType("text/plain");
	    m_context.startActivity(shareIntent);
		
	}
	
	public static void saveScore(Context context, int score)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putInt("SCORE",score);
		editor.commit();
	}
	
	public static int getScore(Context context)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getInt("SCORE", 0);
	}
	public static void shareScore(Activity gameActivity, View dialogView) {
		View view = gameActivity.getWindow().getDecorView();
		Bitmap bitmap1 = getScreenShot(gameActivity,view);
		Bitmap bitmap2 = getScreenShot(gameActivity, dialogView);
		
		Uri uri = getUri(gameActivity,bitmap1,bitmap2);
		
		Intent shareIntent = new Intent();
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		shareIntent.setType("image/*");
		gameActivity.startActivity(Intent.createChooser(shareIntent, "Share Using.."));

		
	}
	private static Uri getUri(Activity gameActivity, Bitmap bitmap1, Bitmap bitmap2) {
		Bitmap bmOverlay = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(),  bitmap1.getConfig());
		Canvas canvas = new Canvas(bmOverlay);
		canvas.drawBitmap(bitmap1, 0, 0, null);
		canvas.drawBitmap(bitmap2, 0, 0, null);
		File imageFile = null;
		try{
		    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		    imageFile = new File(path, "score.png");
		    FileOutputStream fileOutPutStream = new FileOutputStream(imageFile);
		    bmOverlay.compress(Bitmap.CompressFormat.PNG, 80, fileOutPutStream);

		    fileOutPutStream.flush();
		    fileOutPutStream.close();
	    }catch(Exception exception)
	    {
	    	
	    }
		return Uri.parse("file://" + imageFile.getAbsolutePath());
	}
	private static Bitmap getScreenShot(Activity gameActivity,View view) {
		// create bitmap screen capture
		Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
		            view.getHeight(), Config.ARGB_8888);
		    Canvas canvas = new Canvas(bitmap);
		    view.draw(canvas);
		    
		    return bitmap;//;
	}
	
	private static boolean appInstalledOrNot(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed ;
    }

}
