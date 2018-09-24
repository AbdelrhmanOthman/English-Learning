package com.abdelrhman.abdo.learn_english;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.abdelrhman.abdo.learn_english.R.layout.model_list;

public class ListWordsPUblic extends AppCompatActivity {
    ListView mListView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_words_public);


        mListView =(ListView)findViewById(R.id.list_words_public);
        ArrayList<List_item> ListWords = new ArrayList<List_item>();
        for (int i = 0; i<Public_WOrds.PUBLIC.length;i++){
            ListWords.add(new List_item(i,Public_WOrds.PUBLIC[i]));

            ListAdapter1 listAdapter = new ListAdapter1(ListWords);
            mListView.setAdapter(listAdapter);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView word = (TextView)view.findViewById(R.id.txtlistEnglis);
                    Public_WOrds.p = i;
                    Public_WOrds.a = i;
                    Public_WOrds.pub=i;
                    Public_WOrds.pub++;
                    finish();



                }
            });
        }
    }












    class ListAdapter1 extends BaseAdapter {

        ArrayList<List_item> itemList = new ArrayList<List_item>();
        ListAdapter1(ArrayList<List_item> listitem ){
            this.itemList = listitem;
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int i) {
            return itemList.get(i).word;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(model_list,null);
            TextView word = (TextView)view1.findViewById(R.id.txtlistEnglis);
            TextView ID = (TextView)view1.findViewById(R.id.txt_list_id);
            ID.setText(String.valueOf(itemList.get(i).id));
            word.setText(itemList.get(i).word);

            return view1;
        }
    }

}
