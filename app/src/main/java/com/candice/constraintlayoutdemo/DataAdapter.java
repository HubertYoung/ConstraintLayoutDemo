package com.candice.constraintlayoutdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 * function:
 * <p>
 *
 * @author:Lyt
 * @date:2018/11/14 上午10:02
 * @since:V$VERSION
 * @desc:com.candice.constraintlayoutdemo
 */
public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_TITLE = 0;
    public static final int TYPE_CONTENT = 1;
    private final Context context;
    private List<DataBean> list;
    private List<String> menuList;
    private final LayoutInflater layoutInflater;

    public DataAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
//        if(menuList != null) {
//            menuList.clear();
//        }else {
            menuList = new ArrayList<>();
//        }
    }


    public int getMenuSize() {
        if (list == null || list.size() == 0) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            DataBean dataBean = list.get(i);
            if (dataBean == null || dataBean.getMenus() == null || dataBean.getMenus().size() == 0) {
                return 0;
            }
            menuList.addAll(dataBean.getMenus());
        }

        return menuList == null ? 0 : menuList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TYPE_CONTENT) {
            View view = layoutInflater.inflate(R.layout.item_layout_content, viewGroup, false);
            return new ContentViewHolder(view);
        } else if (i == TYPE_TITLE) {
            View view = layoutInflater.inflate(R.layout.item_layout_title, viewGroup, false);
            return new TitleViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_CONTENT:
                if (viewHolder instanceof ContentViewHolder) {
                    ((ContentViewHolder) viewHolder).tvContent.setText(menuList.get(position-1));
                }
                break;
            case TYPE_TITLE:
                if (viewHolder instanceof TitleViewHolder) {
                    ((TitleViewHolder) viewHolder).tvTitle.setText("安全工具设置");
                }
                break;
        }


    }

    @Override
    public int getItemCount() {
        return (list == null ? 0 : list.size()) + getMenuSize();
    }

    public void setList(@Nullable List<DataBean> list) {
        this.list = list;
    }

    int outPosition;

    @Override
    public int getItemViewType(int position) {
        Log.e("TAG", "position>>>>" + position);

        DataBean dataBean = list.get(outPosition);
        List<String> menus = dataBean.getMenus();
        if (menus != null && menus.size() > 0 && position < menus.size()) {
            String s = menus.get(position);
            Log.e("TAG", "s>>>>>" + s);
        }

        if (position == 0) {
            outPosition = position;
            return TYPE_TITLE;
        } else if (position > menus.size() && position - menus.size() == 1) {
            outPosition = position - menus.size();
            return TYPE_TITLE;
        } else {
            return TYPE_CONTENT;
        }


    }

    private class ContentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvContent;

        public ContentViewHolder(View view) {
            super(view);
            tvContent = view.findViewById(R.id.tv_content);
        }
    }

    private class TitleViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private View vBg;

        public TitleViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            vBg = view.findViewById(R.id.v_b);
        }
    }
}
