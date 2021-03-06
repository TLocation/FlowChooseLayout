package com.loction.choose.flowchooselayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.loction.choose.flowchooselibrary.weight.FlowChooseLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private MyAdapter myAdapter;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = findViewById(R.id.id_content);
		final FlowChooseLayout flowChooseLayout = findViewById(R.id.id_attr);
		final List<DataBean> list = new ArrayList<>();
		String[] stringArray = getResources().getStringArray(R.array.flow_demo);
		for (int i = 0; i < stringArray.length; i++) {
			DataBean dataBean = new DataBean();
dataBean.setName(stringArray[i]);
			list.add(dataBean);
		}
		myAdapter = new MyAdapter(list);
		flowChooseLayout.setDefaultCheckd(0);
		flowChooseLayout.setAdapter(myAdapter);
		findViewById(R.id.id_btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				DataBean dataBean = new DataBean();
				dataBean.setName("增加选中项");
				list.add(dataBean);
				myAdapter.notifyDataSetChanged();
			}
		});


		findViewById(R.id.id_clear).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				List<Integer> allCheckedIndex = flowChooseLayout.getAllCheckedIndex();
				textView.setText("已经选中的索引\n");
				textView.append(allCheckedIndex.toString());
			}
		});


	}
}
