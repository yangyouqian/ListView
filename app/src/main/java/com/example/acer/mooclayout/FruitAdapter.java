package com.example.acer.mooclayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by acer on 2016/4/3.
 */
public class FruitAdapter extends ArrayAdapter<Fruit>{
    private int resourceID;
    public FruitAdapter(Context context, int textViewResourseID, List<Fruit> objects){
        super(context, textViewResourseID, objects);
        resourceID = textViewResourseID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getView()在每个子类滚动到屏幕内时都会被调用
        Fruit fruit = getItem(position);

        //优化
        View view;
        ViewHolder viewHolder;

        if (convertView == null){//缓存为null 就加载布局
            view = LayoutInflater.from(getContext()).inflate(resourceID,null);
            viewHolder = new ViewHolder();

            //把findViewByID()方法也放在if语句中
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
            //将ViewHolder存储在View中,Tags can also be used to store data within a view
            // without resorting to another data structure.
        }else {//不为空则重用
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取ViewHolder

        }


        //加载传入的布局  public View inflate (int resource, ViewGroup root)
        //Inflate a new view hierarchy from the specified（指定） xml resource. Throws InflateException if there is an error.
        //View view = LayoutInflater.from(getContext()).inflate(resourceID,null);
        //通过资源id查找组件，注意调用的是View对象的findViewById

        //ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        //TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        viewHolder.fruitImage.setImageResource(fruit.getImageID());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
    //内部类
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
