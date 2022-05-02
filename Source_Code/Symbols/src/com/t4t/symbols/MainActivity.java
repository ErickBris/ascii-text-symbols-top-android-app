package com.t4t.symbols;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.t4t.helpers.AdsHelper;

public class MainActivity extends Activity {

	private GridView grids;
	private EditText edttxt;
	private Button btnCopy;
	private Button btnShare;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		AdsHelper.initializeAds(this, savedInstanceState);
		setContentView(R.layout.activity_main);

		grids=(GridView) findViewById(R.id.gridView1);
		 edttxt=(EditText)findViewById(R.id.editText1);
		 btnCopy=(Button)findViewById(R.id.button1);
		 btnShare=(Button)findViewById(R.id.button2);
		 btnCopy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				buttonCopy();
				
			}

			
		});
		 
		 btnShare.setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v) 
			{
		         buttonShare();		
				
			}
		});
		 
		 
		 
		 grids.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
			String text=getSymbols().get(position);
			edttxt.append(text);
			}
		});
		 
		 grids.setAdapter(new GridAdapter(getBaseContext(),getSymbols()));
	}
	
	

	private static ArrayList<String> getSymbols()
	  {
  	 String symbols = "❤ ❥ ❣ ❢ ❡  ヅ ツ ッ シ ☁ ☀ ✆ ℡ © ® ™ ✫ ✪ ✩ ✬ ✮ ✭ ✯ ✰ ✹ ✸ ✷ ✶ ✵ ✳ ✱ ❧ ❦ ❊ ❉ ❈ ❇ ❅ ❄ ❃ ❂ ❁ ✿ ✾ ✽ ✼ ✻ ✛ ✜ ✝ ✞ ✟ ✠ ✖ ✘ ♀ ☆ ★ ♭ ♬ ♪ ♩ ♨ ♧ ♦ ♥ ♤ ♣ ♢ ♡ ♟ ♞ ♝ ♜ ♛ ♚ ♙ ♘ ♗ ♖ ♕ ♔ ▲ ▼ ✈ 《 》 « » 『 』 【 】  ﹂ ﹃ ﹄ ✌ ✉ ✈ ✁ ✃ ✂ 웃 ℃ ℉ ✔ ◎ † ‡ ♭ ¶ » ¦ Δ Ω ½ ⅓ ⅔ ¼ № ⇨ ⇒ ⇔ ⇚ ⇶ ⇵ ⇴ ⇳ ⇰ ⇯ ⇮ ⇭ ⇬ ⇫ ⇩ ⇨ ⇧ ⇦ ↻ ↺ ↰ ↯ ↮ ↭ ↬ ↫ ↪ ↩ ↨ ↧ ↦ ↥ ↤ ↣ ↢  ↡ ↠ ↟ ↞ ↝ ↜ ↛ ↚ ↙ ↘ ↗ ↖ ← ↑ → ↓ ↔ ↕ ↖ ↗ ↘ ↙ ↤ ↥ ↦ ↧ ↨ ↸ ↹ ↮ ⇤ ⇥ ⇱ ⇲ ⇞ ⇟ ↩ ↪ ↫ ↬ ↭ ⇝ ↰ ↱ ↲ ↳ ↴ ↵ ↯ ↷ ↺ ↻ ⇜ ↶ ↼ ↽ ↾ ↿ ⇀ ⇁ ⇂ ⇃ ⇄ ⇅ ⇆ ⇇ ⇈ ⇉ ⇊ ⇍ ⇎ ⇏ ⇐ ⇑ ⇒ ⇓ ⇔ ⇕ ⇖ ⇗ ⇘ ⇙ ⇦ ⇧ ⇪ ⇫ ➔ ➙ ➘ ➚ ➛ ➜ ➞ ➟ ➠ ➡ ➢ ➣ ➤ ➥ ➦ ➶ ➵ ➳ ➴ ➲ ➱ ➯ ➾ ➽ ➭ ➬ ➼ ➻ ➫ ➪ ➺ ➹ ➩ ➨ ➸ ➷ ➧ ∂ ∆ ∏ ∑ √ ∞ ∟ ∩ ∫ ≈ ≠ ≡ ≤ ≥ ÷ ‰ π │ ┌ ┐ └ ┘ ├ ┤ ┬ ┴ ┼ ║ ╒ ╓ ╔ ╕ ╖ ╗ ╘ ╙ ╚ ╛ ╜ ╝ ╞ ╟ ╠ ╡ ╢ ╣ ╤ ╥ ╦ ╧ ╨ ╩ ╪ ╫ ╬ ① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩ ⑪ ⑫ ⑬ ⑭ ⑮ ⑯ ⑰ ⑱ ⑲ ⑳ ㉠ ㉡ ㉢ ㉣ ㉤ ㉥ ㉦ ㉧ ㉨ ㉩ ㉪ ㉫ ㉬ ㉭ ㉮ ㉯ ㉰ ㉱ ㉲ ㉳ ㉴ ㉵ ㉷ ㉶ ㉸ ㉹ ㉺ ㉻ ⅰ ⅱ ⅲ ⅳ ⅴ ⅵ ⅶ ⅷ ⅸ ⅹ ⅹ Ⅰ Ⅱ Ⅲ  Ⅳ Ⅴ Ⅵ Ⅶ Ⅷ Ⅸ Ⅹ Ⅺ Ⅻ Ώ ΐ Γ Θ Λ Ξ Π Φ Ψ Ϊ Ϋ έ ή ί ΰ α β γ δ ζ η θ ι κ λ μ ξ ρ ς σ τ φ χ ψ ω ϊ £ ¤ ¥ § Љ Њ Ћ Ќ Ѝ Ў Џ Б Г Д Ж И Й К Л љ њ ѽ Ѽ ₡ ₢ ₣ ₤ ₥ ₦ ₧ ₨ ₫ ₭ ₮ ₯ ₰ ₱ ₲ ₳ ₴ ₵ ℅ ￥ ￦ ฿ ﾑ 乃 乇 ｷ ん ﾉ ﾌ ズ ﾚ 刀 ｱ ｲ 尺 Ц Щ ﾒ ﾘ 乙";

		  String[] sym = symbols.split(" ");
		  ArrayList<String> list = new ArrayList<String>();
		  for(int i=0;i<sym.length;i++)
		  {
			  if(sym[i]!=null && !sym[i].trim().equals(""))
				  list.add(sym[i]);
		  }
			  
		  return list;		  
	  }
	protected void buttonCopy() 
	{
		String copy=edttxt.getText().toString();
		android.text.ClipboardManager clip=(android.text.ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
		clip.setText(copy);
		Toast.makeText(getApplicationContext(), "Copied to clipboard!",Toast.LENGTH_SHORT).show();
	}
	protected void buttonShare() 
	{
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT,edttxt.getText().toString());
		sendIntent.setType("text/plain");
		startActivityForResult(sendIntent,111);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		AdsHelper.showInterstitialAds(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_rate :
			AdsHelper.onRateAppClick(this);
			return true;
		case R.id.action_share :
			AdsHelper.onShareAppClick(this);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void keyBoardClick(View v)
	{
		InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	    inputMethodManager.toggleSoftInputFromWindow(edttxt.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		AdsHelper.showAdsOnExit(this);
	}
}
