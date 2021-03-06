package com.loction.choose.flowchooselayout;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loction.choose.flowchooselibrary.weight.FlowAdapter;

import java.util.List;

/**
 * 项目名称: MvpRoute
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/6/28 0028 23:39
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class MyAdapter extends FlowAdapter<DataBean> {


	public MyAdapter(List<DataBean> data) {
		super(data);
	}

	@Override
	public View getView(ViewGroup parent, View view, int position) {
		View contentView = null;
		if (view != null) {
			contentView = view;
		} else {
			contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_flow, parent, false);
		}
		TextView textView = contentView.findViewById(R.id.view_content);
		textView.setText(data.get(position).getName());
		return contentView;
	}


	@Override
	public void onChangeState(View view, int position, boolean state) {
		TextView textView = view.findViewById(R.id.view_content);
		if (state) {
			view.setBackgroundColor(Color.RED);
		} else {
			view.setBackgroundColor(Color.BLUE);
		}

	}
}
