package com.candice.constraintlayoutdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
public class DataAdapter2 extends RecyclerView.Adapter< RecyclerView.ViewHolder > {
    public static final int TYPE_TITLE = 0;
    public static final int TYPE_CONTENT = 1;
    private final Context context;
    private List<DataBeanNew.MenusBean> data;
    private final LayoutInflater layoutInflater;

    public DataAdapter2(Context context ) {
        this.context = context;
        layoutInflater = LayoutInflater.from( context );
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( @NonNull ViewGroup viewGroup, int i ) {
        if ( i == TYPE_CONTENT ) {
            View view = layoutInflater.inflate( R.layout.item_layout_content, viewGroup, false );
            return new ContentViewHolder( view );
        } else if ( i == TYPE_TITLE ) {
            View view = layoutInflater.inflate( R.layout.item_layout_title, viewGroup, false );
            return new TitleViewHolder( view );
        }
        return null;
    }

    @Override
    public void onBindViewHolder( @NonNull RecyclerView.ViewHolder viewHolder, int position ) {
        int type = getItemViewType( position );
        switch ( type ) {
            case TYPE_CONTENT:
                if ( viewHolder instanceof ContentViewHolder ) {

                    ( ( ContentViewHolder ) viewHolder ).tvContent.setText( data.get( position ).menusTitle );
                }
                break;
            case TYPE_TITLE:
                if ( viewHolder instanceof TitleViewHolder ) {
                    TitleViewHolder titleViewHolder = ( TitleViewHolder ) viewHolder;

                    titleViewHolder.tvTitle.setText( data.get( position ).parentTitle );
                    if ( TextUtils.isEmpty( titleViewHolder.tvTitle.getText().toString() ) ){
                        titleViewHolder.tvTitle.setVisibility( View.GONE );
                    }else{
                        titleViewHolder.tvTitle.setVisibility( View.VISIBLE );
                    }
                }
                break;
        }


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(@Nullable List< DataBeanNew > data) {
        List<DataBeanNew.MenusBean> menus = new ArrayList<>();
        for (DataBeanNew dataBeanNew : data) {

            String title = dataBeanNew.title;
            DataBeanNew.MenusBean titleMenu = new DataBeanNew.MenusBean(null, null, title);
            menus.add(titleMenu);

            for (DataBeanNew.MenusBean menu : dataBeanNew.menus) {
                menus.add(menu);
            }

        }
        this.data = menus;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType( int position ) {
        DataBeanNew.MenusBean menu = data.get(position);
        if (TextUtils.isEmpty(((DataBeanNew.MenusBean) menu).menusTitle)){
            return TYPE_TITLE;
        }else{
            return TYPE_CONTENT;

        }
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvContent;

        public ContentViewHolder( View view ) {
            super( view );
            tvContent = view.findViewById( R.id.tv_content );
        }
    }

    private class TitleViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private View vBg;

        public TitleViewHolder( View view ) {
            super( view );
            tvTitle = view.findViewById( R.id.tv_title );
            vBg = view.findViewById( R.id.v_b );
        }
    }
}
