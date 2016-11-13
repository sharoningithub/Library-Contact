package com.sharon.lenovo_pc.librarycontact;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends Activity implements View.OnClickListener {

    private LinearLayout mTabNote;
    private LinearLayout mTabBookcontact;
    private LinearLayout mTabPerson;

    private ImageButton mTabNoteImg;
    private ImageButton mTabBookcontactImg;
    private ImageButton mTabPersonImg;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);//显示tab0
    }

    private void initEvent() {
        mTabNote.setOnClickListener(this);
        mTabBookcontact.setOnClickListener(this);
        mTabPerson.setOnClickListener(this);
    }

    private void initView() {
        mTabNote=(LinearLayout)findViewById(R.id.id_tab_note);
        mTabBookcontact=(LinearLayout)findViewById(R.id.id_tab_bookcontact);
        mTabPerson=(LinearLayout)findViewById(R.id.id_tab_person);

        mTabNoteImg=(ImageButton)findViewById(R.id.id_tab_note_img);
        mTabBookcontactImg=(ImageButton)findViewById(R.id.id_tab_bookcontact_img);
        mTabPersonImg=(ImageButton)findViewById(R.id.id_tab_person_img);

    }

    private void setSelect(int i){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        //把图片设置为亮色；设置内容区域
        switch (i){
            case 0:
                if(mTab01 == null)//没有初始化则初始化
                {
                    mTab01 = new NoteFragment();
                    transaction.add(R.id.id_content,mTab01);
                }
                else
                    transaction.show(mTab01);
                mTabNoteImg.setImageResource(R.drawable.note_orange);
                break;
            case 1:
                if(mTab02 == null)
                {
                    mTab02 = new BookContactFragment();
                    transaction.add(R.id.id_content,mTab02);
                }
                else
                    transaction.show(mTab02);
                mTabBookcontactImg.setImageResource(R.drawable.bookcontact_orange);
                break;
            case 2:
                if(mTab03 == null)
                {
                    mTab03 = new PersonFragment();
                    transaction.add(R.id.id_content,mTab03);
                }
                else
                    transaction.show(mTab03);
                mTabPersonImg.setImageResource(R.drawable.person_orange);
                break;

            default:
                break;
        }
        transaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction) {
        if(mTab01 != null)
            transaction.hide(mTab01);
        if(mTab02 != null)
            transaction.hide(mTab02);
        if(mTab03 != null)
            transaction.hide(mTab03);
    }

    @Override
    public void onClick(View v){
    //Actitity实现了OnClickListener接口,重写了onClick(view)方法；
    // 在为某些组件添加该事件监听对象时,直接setXxx.Listener(this)即可
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_note:
                setSelect(0);
                break;
            case R.id.id_tab_bookcontact:
                setSelect(1);
                break;
            case R.id.id_tab_person:
                setSelect(2);
                break;

            default:
                break;
        }

    }
//切换图片至暗色
    private void resetImgs() {
        mTabNoteImg.setImageResource(R.drawable.note);
        mTabBookcontactImg.setImageResource(R.drawable.bookcontact);
        mTabPersonImg.setImageResource(R.drawable.person);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
