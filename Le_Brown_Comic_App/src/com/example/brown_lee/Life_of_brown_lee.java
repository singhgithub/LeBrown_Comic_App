package com.example.brown_lee;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Life_of_brown_lee extends Activity {

	int[] life_of_lee_image_array_obj;
	ViewPager life_of_lee_viewpager_obj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lee_brown_life_layout);

		intialize_every_thing_here();
		
		System.out.println("veiwpager_Class_obj is called ");
		viewpager_class viewpager_Class_obj = new viewpager_class(this);

		System.out.println("Pageradapter is set on viewPager_class");
		life_of_lee_viewpager_obj.setAdapter(viewpager_Class_obj);
	}

	public void intialize_every_thing_here() {
		life_of_lee_image_array_obj = new int[] {R.drawable.image1, R.drawable.image2,R.drawable.image3,
				R.drawable.image4, R.drawable.image5,R.drawable.image6, R.drawable.image7,
				R.drawable.image10,R.drawable.image11, R.drawable.image12,R.drawable.image13,
				R.drawable.image14, R.drawable.image15,R.drawable.image16,R.drawable.image17, R.drawable.image18,R.drawable.image19,
				R.drawable.image20, R.drawable.image21};
	
		life_of_lee_viewpager_obj = (ViewPager) findViewById(R.id.lee_brown_life_viewpager_id);
	}

	class viewpager_class extends PagerAdapter{
		
		Context context;
		
		public viewpager_class(Context x) {
			System.out.println("viewpager_class constructor is called");
			
			this.context = x;
		
		}
		
		//This method determine how many pages will be created
		@Override
		public int getCount() {
			
			return life_of_lee_image_array_obj.length;
		}

		//???????????????
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			
			return arg0 == ((ImageView) arg1);
			
		}

		
		//this method pretty much return the imageview back to the pager or add it to the pager
		/**
		 * 
		 * @param container
		 *            the view where the page will be shown
		 * @param position
		 *            the page postion
		 * @return Returns an Object representing the new page
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			ImageView dynamic_image_view = new ImageView(context);
			dynamic_image_view.setImageResource(life_of_lee_image_array_obj[position]);
			
			((ViewPager)container).addView(dynamic_image_view, 0);
			
			return dynamic_image_view;
		}


		/*
		 * @param		seems like container is the viewpager view
		 * @param		is int value of the page of the viewpager
		 * @param		its the dynamic_image_view object
		 * */
		@Override
		public void destroyItem(View container, int position, Object object) {
			
			((ViewPager)container).removeView((ImageView)object);

			
		}

		
		
		
		
		
	}
}
