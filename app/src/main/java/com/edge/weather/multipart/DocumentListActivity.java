package com.edge.weather.multipart;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocumentListActivity extends ListActivity {
    List<File> myList;
    ListView lv;
    String doc_path="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_list);
        Intent intent=getIntent();
        lv=(ListView)findViewById(android.R.id.list);
        myList=(List<File>) intent.getExtras().get("myList");

        CustomerAdapter customerAdapter=new CustomerAdapter();
        lv.setAdapter(customerAdapter);
    }

    class CustomerAdapter extends BaseAdapter{
        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.row_document_list,null);
            ((TextView)view.findViewById(R.id.row_document_name)).setText(myList.get(i).getName()+"");
            ((LinearLayout)view.findViewById(R.id.row_linear)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doc_path=myList.get(i).getAbsolutePath();
                    uploadFile(doc_path);
                }
            });
            return view;
        }
    }
    public void uploadFile(String filePath){
        String url = "http://117.17.142.133:8080/unithon/photo";
        try {
            UploadFile uploadFile = new UploadFile(DocumentListActivity.this, new AsyncResponse() {
                @Override
                public void processFinish(String result) {
                    Toast.makeText(getApplicationContext(),"문서 저장되었습니다.",Toast.LENGTH_SHORT).show();
                }
            });
            uploadFile.setPath(filePath);
            uploadFile.execute(url);
            uploadFile.getStatus();
        } catch (Exception e){

        }
    }


}
