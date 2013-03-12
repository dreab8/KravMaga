package org.dreab8.kravmaga.activity.adapter;

import org.dreab8.kravmaga.activity.fragment.KravMagaClassesFragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DayOfTheWeekPageAdapter extends FragmentPagerAdapter {

	Context context=null;
	
	public DayOfTheWeekPageAdapter(Context context,FragmentManager fm) {
		super( fm );
		this.context = context;
	}

	@Override
	public Fragment getItem(int position) {
		return KravMagaClassesFragment.newInstance(position);
	}
	
	@Override
	  public String getPageTitle(int position) {
	    return(KravMagaClassesFragment.getTitle(context, position));
	  }

	@Override
	public int getCount() {
		return 7;
	}

}
