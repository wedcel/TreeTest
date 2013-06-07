package com.gao.tree;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GirdTreeView extends ListActivity {
	private ArrayList<GirdElement> mPdfOutlinesCount = new ArrayList<GirdElement>();
	private ArrayList<GirdElement> mPdfOutlines = new ArrayList<GirdElement>();
	private TreeViewAdapter treeViewAdapter = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girdtree);
        initialData();
        treeViewAdapter = new TreeViewAdapter(this, R.layout.item_girdtree,
				mPdfOutlinesCount);
		setListAdapter(treeViewAdapter);
		registerForContextMenu(getListView());
    }   
    
    private void initialData() {
    	//(String id, String outlineTitle, boolean mhasParent, boolean mhasChild, String parent, int level, boolean expanded)
		GirdElement pdfOutlineElement1=new GirdElement("01", "关键类", false	, false, "00", 0,false);
		GirdElement pdfOutlineElement2=new GirdElement("02", "应用程序组件", false	, true, "00", 0,false);
		GirdElement pdfOutlineElement3=new GirdElement("03", "Activity和任务", false	, true, "00", 0,false);
		GirdElement pdfOutlineElement4=new GirdElement("04", "激活组件：intent", true	, false, "02", 1,false);
		GirdElement pdfOutlineElement5=new GirdElement("05", "关闭组件", true	, false, "02", 1,false);
		GirdElement pdfOutlineElement6=new GirdElement("06", "manifest文件", true	, false, "02", 1,false);
		GirdElement pdfOutlineElement7=new GirdElement("07", "Intent过滤器", true	, false, "02", 1,false);
		GirdElement pdfOutlineElement8=new GirdElement("08", "Affinity（吸引力）和新任务", true	, false, "03", 1,false);
		GirdElement pdfOutlineElement9=new GirdElement("09", "加载模式", true	, true, "03", 1,false);
		GirdElement pdfOutlineElement10=new GirdElement("10", "加载模式孩子1", true	, true, "09", 2,false);
		GirdElement pdfOutlineElement11=new GirdElement("11", "加载模式孩子2", true	, true, "09", 2,false);
		GirdElement pdfOutlineElement12=new GirdElement("12", "加载模式孩子2的孩子1", true	, false, "11", 3,false);
		GirdElement pdfOutlineElement13=new GirdElement("13", "加载模式孩子2的孩子2", true	, false, "11", 3,false);
		GirdElement pdfOutlineElement14=new GirdElement("14", "加载模式孩子1的孩子1", true	, false, "10", 3,false);
		GirdElement pdfOutlineElement15=new GirdElement("15", "加载模式孩子1的孩子2", true	, false, "10", 3,false);
		GirdElement pdfOutlineElement16=new GirdElement("16", "加载模式孩子1的孩子3", true	, false, "10", 3,false);
		GirdElement pdfOutlineElement17=new GirdElement("17", "加载模式孩子1的孩子4", true	, false, "10", 3,false);
		GirdElement pdfOutlineElement18=new GirdElement("18", "加载模式孩子1的孩子5", true	, false, "10", 3,false);
		GirdElement pdfOutlineElement19=new GirdElement("19", "加载模式孩子1的孩子6", true	, false, "10", 3,false);
		mPdfOutlinesCount.add(pdfOutlineElement1);
		mPdfOutlinesCount.add(pdfOutlineElement2);
		mPdfOutlinesCount.add(pdfOutlineElement3);
	
		
		mPdfOutlines.add(pdfOutlineElement1);
		mPdfOutlines.add(pdfOutlineElement2);
		mPdfOutlines.add(pdfOutlineElement4);
		mPdfOutlines.add(pdfOutlineElement5);
		mPdfOutlines.add(pdfOutlineElement6);
		mPdfOutlines.add(pdfOutlineElement7);
		mPdfOutlines.add(pdfOutlineElement3);
		mPdfOutlines.add(pdfOutlineElement8);
		mPdfOutlines.add(pdfOutlineElement9);
		mPdfOutlines.add(pdfOutlineElement10);
		mPdfOutlines.add(pdfOutlineElement11);
		mPdfOutlines.add(pdfOutlineElement12);
		mPdfOutlines.add(pdfOutlineElement13);
		mPdfOutlines.add(pdfOutlineElement14);
		mPdfOutlines.add(pdfOutlineElement15);
		mPdfOutlines.add(pdfOutlineElement16);
		mPdfOutlines.add(pdfOutlineElement17);
		mPdfOutlines.add(pdfOutlineElement18);
		mPdfOutlines.add(pdfOutlineElement19);
		
		
		
	}

	private class TreeViewAdapter extends ArrayAdapter<GirdElement> {



		private LayoutInflater mInflater;
		private List<GirdElement> mfilelist;
		private Bitmap mIconCollapse;
		private Bitmap mIconExpand;

		public TreeViewAdapter(Context context, int textViewResourceId,
				List<GirdElement> objects) {
			super(context, textViewResourceId, objects);
			mInflater = LayoutInflater.from(context);
			mfilelist = objects;
			mIconCollapse = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.gird_item_collapse);
			mIconExpand = BitmapFactory.decodeResource(context.getResources(),
					R.drawable.gird_item_expand);

		}
		public int getCount() {
			return mfilelist.size();
		}

		public GirdElement getItem(int position) {
			return mfilelist.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, View convertView, ViewGroup parent) {

			ViewHolder holder;
			
				convertView = mInflater.inflate(R.layout.item_girdtree, null);
				holder = new ViewHolder();
				holder.text = (TextView) convertView.findViewById(R.id.text);
				holder.icon = (ImageView) convertView.findViewById(R.id.icon);
				convertView.setTag(holder);
			

			int level = mfilelist.get(position).getLevel();
 			holder.icon.setPadding(25 * (level + 1), holder.icon
					.getPaddingTop(), 0, holder.icon.getPaddingBottom());
			holder.text.setText(mfilelist.get(position).getGridName());
			if (mfilelist.get(position).isHasChild()
					&& (!mfilelist.get(position).isExpanded())) {
				holder.icon.setImageBitmap(mIconCollapse);
			} else if (mfilelist.get(position).isHasChild()
					&& (mfilelist.get(position).isExpanded())) {
				holder.icon.setImageBitmap(mIconExpand);
			} else if (!mfilelist.get(position).isHasChild()){
				holder.icon.setImageBitmap(mIconCollapse);
				holder.icon.setVisibility(View.INVISIBLE);
			}
			holder.icon.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (mPdfOutlinesCount.get(position).isExpanded()) {
						mPdfOutlinesCount.get(position).setExpanded(false);
						GirdElement pdfOutlineElement=mPdfOutlinesCount.get(position);
						ArrayList<GirdElement> temp=new ArrayList<GirdElement>();
						
						for (int i = position+1; i < mPdfOutlinesCount.size(); i++) {
							if (pdfOutlineElement.getLevel()>=mPdfOutlinesCount.get(i).getLevel()) {
								break;
							}
							temp.add(mPdfOutlinesCount.get(i));
						}
						
						mPdfOutlinesCount.removeAll(temp);
						
						treeViewAdapter.notifyDataSetChanged();
						/*fileExploreAdapter = new TreeViewAdapter(this, R.layout.outline,
								mPdfOutlinesCount);*/

						//setListAdapter(fileExploreAdapter);
						
					} else {
						mPdfOutlinesCount.get(position).setExpanded(true);
						int level = mPdfOutlinesCount.get(position).getLevel();
						int nextLevel = level + 1;
						

						for (GirdElement pdfOutlineElement : mPdfOutlines) {
							int j=1;
							if (pdfOutlineElement.getParent()==mPdfOutlinesCount.get(position).getGridId()) {
								pdfOutlineElement.setLevel(nextLevel);
								pdfOutlineElement.setExpanded(false);
								mPdfOutlinesCount.add(position+j, pdfOutlineElement);
								j++;
							}			
						}
						treeViewAdapter.notifyDataSetChanged();
					
					}
				}
			});
			holder.text.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(GirdTreeView.this, mfilelist.get(position).getGridName(), 2000).show();
				}
			});
			
			return convertView;
		}

		class ViewHolder {
			TextView text;
			ImageView icon;

		}
	}
/*	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (!mPdfOutlinesCount.get(position).isHasChild()) {
			Toast.makeText(this, mPdfOutlinesCount.get(position).getGridName()+ mPdfOutlinesCount.get(position).getGridId(), 2000).show();
			int pageNumber;
			Intent i = getIntent();
			PDFOutlineElement element = mPdfOutlinesCount
					.get(position);
			pageNumber = element.getOutlineElement().pageNumber;
			if (pageNumber <= 0) {
				String name = element.getOutlineElement().destName;
				pageNumber = idocviewer.getPageNumberForNameForOutline(name);
				element.getOutlineElement().pageNumber = pageNumber;
				element.getOutlineElement().destName = null;
			}
			i.putExtra("PageNumber", pageNumber);
			setResult(RESULT_OK, i);
			finish();

			return;
		}

	}*/

}