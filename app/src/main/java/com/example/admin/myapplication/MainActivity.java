package com.example.admin.myapplication;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    EditText edtexName,edtexNum;
    Button butAdd;
    RadioButton butMale,butFe;
    ListView lv;
    String name,num;
    ArrayList<contact> arr;
    cusAd cusAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find();
        arr = new ArrayList<>();
        cusAd= new cusAd(this,R.layout.phone,arr);
        lv.setAdapter(cusAd);
        checkAndRequestPermissions();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showDia(i);

            }
        });


    }

    private void find(){
        edtexName=this.findViewById(R.id.edtexName);
        edtexNum=this.findViewById(R.id.edtexNum);
        butMale=this.findViewById(R.id.butMale);
        butFe=this.findViewById(R.id.butFe);
        lv=this.findViewById(R.id.lv);

    }


    public void addContact(View view) {
        int id=R.drawable.fb;
        name=edtexName.getText().toString();
        num=edtexNum.getText().toString();
        if(TextUtils.isEmpty(num)){
            Toast.makeText(this,"Nhap sdt",Toast.LENGTH_SHORT).show();
        }
        else{
            if(butMale.isChecked()==false){
                id=R.drawable.images;
            }
            contact contact= new contact(id,name,num);
            arr.add(contact);
        }

        cusAd.notifyDataSetChanged();
    }

    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }

    public void showDia(final int i){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog);

        Button butcall =(Button) this.findViewById(R.id.butcall);
        Button butnt=(Button) this.findViewById(R.id.butnt);
        butnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intcall(i);
            }
        });

        dialog.show();

    }

    public void intcall(int i){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+arr.get(i).getTexNum()));
        startActivity(intent);

    }


}
