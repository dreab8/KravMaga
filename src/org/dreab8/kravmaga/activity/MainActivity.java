package org.dreab8.kravmaga.activity;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.dreab8.kravmaga.R;
import org.dreab8.kravmaga.activity.adapter.DayOfTheWeekPageAdapter;
import org.dreab8.kravmaga.model.KravMagaClass.DayOfTheWeek;
import org.dreab8.kravmaga.model.KravMagaClass.Level;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		ViewPager pager = (ViewPager) findViewById( R.id.pager );
		pager.setAdapter( new DayOfTheWeekPageAdapter( this, getSupportFragmentManager() ) );

		if ( savedInstanceState == null ) {
			pager.setCurrentItem( getToday().ordinal() );
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater( this ).inflate( R.menu.activity_main, menu );
		return super.onCreateOptionsMenu( menu );
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch ( item.getItemId() ) {
		case R.id.menu_settings:
			Log.i( "kravMaga", "settings" );
			return true;
		case android.R.id.home:
			Log.i( "kravMaga", "home" );
			return true;
		}
		return super.onOptionsItemSelected( item );
	}

	public List<Level> getLevelsToHighLight() {
		return Arrays.asList( Level.P1_P2 );
	}

	private DayOfTheWeek getToday() {
		Calendar c = Calendar.getInstance();
		return DayOfTheWeek.getFromCalendarDay( c.get( Calendar.DAY_OF_WEEK ) );
	}
}
