package org.dreab8.kravmaga.activity.fragment;

import java.util.ArrayList;
import java.util.List;

import org.dreab8.kravmaga.R;
import org.dreab8.kravmaga.activity.MainActivity;
import org.dreab8.kravmaga.model.KravMagaClass;
import org.dreab8.kravmaga.model.KravMagaClass.DayOfTheWeek;
import org.dreab8.kravmaga.model.KravMagaClass.Level;
import org.dreab8.kravmaga.model.KravMagaInstitute;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;

public class KravMagaClassesFragment extends SherlockListFragment {

	private static final String KEY_POSITION = "position";

	private List<Level> levelToHighLigh;
	private DayOfTheWeek dayOfTheWeek;
	private List<KravMagaClass> model;

	private KravMagaClassAdapter adapter;

	public static KravMagaClassesFragment newInstance(int position) {
		KravMagaClassesFragment fragment = new KravMagaClassesFragment();
		Bundle args = new Bundle();
		args.putInt( KEY_POSITION, position );
		fragment.setArguments( args );
		return fragment;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated( savedInstanceState );

		setRetainInstance( true );
		setHasOptionsMenu( true );

		dayOfTheWeek = DayOfTheWeek.getFromPosition( getArguments().getInt( KEY_POSITION ) );

		levelToHighLigh = ( (MainActivity) getActivity() ).getLevelsToHighLight();

		if ( model == null ) {
			model = new ArrayList<KravMagaClass>();
			new KravMagaClassesLoader().execute( dayOfTheWeek );
		}
		adapter = new KravMagaClassAdapter( model );
		setListAdapter( adapter );
	}

	public DayOfTheWeek getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	private class KravMagaClassAdapter extends ArrayAdapter<KravMagaClass> {

		private final List<KravMagaClass> kravMagaClasses;

		public KravMagaClassAdapter(List<KravMagaClass> kravMagaClasses) {

			super( getActivity(), R.layout.fragment_krav_maga_classes, kravMagaClasses );
			this.kravMagaClasses = kravMagaClasses;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if ( convertView == null ) {
				convertView = getActivity().getLayoutInflater().inflate( R.layout.fragment_krav_maga_classes, parent,
						false );
			}
			ViewHolder holder = (ViewHolder) convertView.getTag();
			if ( holder == null ) {
				holder = new ViewHolder( convertView );
				convertView.setTag( holder );
			}
			KravMagaClass kravMagaClass = kravMagaClasses.get( position );
			String level = kravMagaClass.getLevel().getLevel();
			if ( levelToHighLigh.contains( kravMagaClass.getLevel() ) ) {
				holder.row.setBackgroundColor( getResources().getColor( R.color.hlight ) );
			}
			else {
				holder.row.setBackgroundColor( getResources().getColor( android.R.color.black ) );
			}
			holder.level.setText( level );
			holder.gymName.setText( kravMagaClass.getVenue().getGymName() );
			holder.address.setText( kravMagaClass.getVenue().getAddress() );
			holder.venueName.setText( kravMagaClass.getVenue().getVenueName() );
			holder.time.setText( kravMagaClass.getTime() );
			holder.city.setText( kravMagaClass.getVenue().getCity() );
			holder.postalCode.setTag( kravMagaClass.getVenue().getPostalCode() );

			return convertView;
		}
	}

	class ViewHolder {

		LinearLayout row;
		TextView level;
		TextView venueName;
		TextView time;
		TextView gymName;
		TextView address;
		TextView city;
		TextView postalCode;

		public ViewHolder(View row) {
			level = (TextView) row.findViewById( R.id.level );
			venueName = (TextView) row.findViewById( R.id.venueName );
			time = (TextView) row.findViewById( R.id.time );
			gymName = (TextView) row.findViewById( R.id.gymName );
			address = (TextView) row.findViewById( R.id.address );
			city = (TextView) row.findViewById( R.id.city );
			postalCode = (TextView) row.findViewById( R.id.postalCode );
			this.row = (LinearLayout) row.findViewById( R.id.row );
		}
	}

	public class KravMagaClassesLoader extends AsyncTask<DayOfTheWeek, Void, List<KravMagaClass>> {
		private final KravMagaInstitute institute = new KravMagaInstitute();

		@Override
		protected List<KravMagaClass> doInBackground(DayOfTheWeek... params) {
			return institute.getKravMagaClasses( getDayOfTheWeek() );
		}

		@Override
		protected void onPostExecute(List<KravMagaClass> result) {
			super.onPostExecute( result );
			adapter.addAll( result );
		}
	}

	public static String getTitle(Context context, int position) {
		return DayOfTheWeek.getFromPosition( position ).getDay();
	}
}
