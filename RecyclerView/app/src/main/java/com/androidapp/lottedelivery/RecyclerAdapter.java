package com.androidapp.lottedelivery;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_HEADER = 0;
    private final int TYPE_FOOTER = 2;
    private final int TYPE_ITEM = 1;

    private ArrayList<RecyclerItem> mData = null;
    private ArrayList<RecyclerView.ViewHolder> mViewHolder = null;
    // item view를 저장하는 뷰홀더 클래스
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView count;
        private TextView name;
        private TextView addr;
        private TextView area;
        private TextView amount;
        private ImageView kakaomap;
        private Button finish;
        private TextView t_start;
        private TextView t_end;

        MyViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            count = itemView.findViewById(R.id.count);
            name = itemView.findViewById(R.id.name);
            addr = itemView.findViewById(R.id.address);
            area = itemView.findViewById(R.id.areaCode);
            amount = itemView.findViewById(R.id.amount);
            finish = itemView.findViewById(R.id.delivery_complete);
            t_start = itemView.findViewById(R.id.t_start);
            t_end = itemView.findViewById(R.id.t_end);
            kakaomap = itemView.findViewById(R.id.map);
            // addr.setPaintFlags(addr.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        RecyclerItem item = mData.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putInt("count", position);
                        bundle.putString("name", item.getNameStr());
                        bundle.putString("addr", item.getAddrStr());
                        bundle.putString("area", item.getAreaStr());
                        bundle.putInt("areacode", item.getAreaCode());
                        bundle.putString("amount", item.getAmount());

                        if (mListener != null) {
                            mListener.onItemClick(view, position, bundle);
                        }
                    }

                }
            });
        }

        void onBind(RecyclerItem item, int position) {
            count.setText(item.getPosition() + "");
            name.setText(item.getNameStr());
            addr.setText(item.getAddrStr());
            amount.setText(item.getAmount() + "PLT");
            area.setText(item.getAreaStr() + " | " + item.getAreaCode());
            t_start.setText("납기시작 : " + item.getT_start());
            t_end.setText("납기종료 : " + item.getT_end());
        }

        public Button getBtnFinish() {
            return this.finish;
        }

        public void setTimeStart(String time, int position) {
            mData.get(position).setT_start(time);
            t_start.setText("납기시작 : " + time);
        }

        public void setTimeEnd(String time, int position) {
            mData.get(position).setT_end(time);
            t_end.setText("납기종료 : " + time);
        }

        public void setTextColorGray(int position) {
            GradientDrawable draw = new GradientDrawable();
            draw.setShape(GradientDrawable.OVAL);
            draw.setColor(Color.GRAY);
            count.setBackground(draw);
            name.setTextColor(android.graphics.Color.GRAY);
            addr.setTextColor(android.graphics.Color.GRAY);
            amount.setTextColor(android.graphics.Color.GRAY);
            area.setTextColor(android.graphics.Color.GRAY);
            kakaomap.setImageResource(R.drawable.kakaomap_black);
            finish.setText("배송완료");
        }
    }

    public RecyclerAdapter(ArrayList<RecyclerItem> list, ArrayList<RecyclerView.ViewHolder> holder) {
        mData = list;
        mViewHolder = holder;
    }
    public void setPosition() {
        for (int i = 0; i < mData.size(); i++) {
            mData.get(i).setPosition(i+1);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RecyclerView.ViewHolder holder;
        View view;
        if (viewType == TYPE_HEADER) {
            view = inflater.from(parent.getContext()).inflate(R.layout.destination_list_header, parent, false);
            holder = new HeaderViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            view = inflater.from(parent.getContext()).inflate(R.layout.destination_list_footer, parent, false);
            holder = new FooterViewHolder(view);
        } else {
            view = inflater.from(parent.getContext()).inflate(R.layout.destination_list_item, parent, false);
            holder = new RecyclerAdapter.MyViewHolder(view);
            mViewHolder.add(holder);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
        } else if (holder instanceof MyViewHolder) {
            // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
            RecyclerItem item = mData.get(position - 1);
            final Button btn_finish = ((MyViewHolder) holder).getBtnFinish();
            btn_finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Date mDate = new Date(System.currentTimeMillis());
                    SimpleDateFormat simpleDate = new SimpleDateFormat("hh:mm");
                    String getTime = simpleDate.format(mDate);
                    if (mData.get(position-1).isComplete() == false) {

                        ((MyViewHolder) holder).setTimeStart(getTime, position -1 );
                        btn_finish.setText("배송완료");
                        mData.get(position-1).setComplete(true);
                        notifyDataSetChanged();
                    } else {
                        ((MyViewHolder) holder).setTimeEnd(getTime, position - 1);
                        ((MyViewHolder) mViewHolder.get(mData.size()-1)).setTextColorGray(mData.size()-1);
                        moveItem(position - 1);
                    }
                }
            });
            MyViewHolder mViewHolder = (MyViewHolder) holder;
            mViewHolder.onBind(item, position);
        }
    }

    /*  listener    */
    public interface OnItemClickListener {
        void onItemClick(View v, int position, Bundle bundle);
    }

    // 리스너 객체 참조를 저장하는 변수
    private OnItemClickListener mListener = null;

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        HeaderViewHolder(View headerView) {
            super(headerView);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View footerView) {
            super(footerView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        else if (position == getItemCount() - 1)
            return TYPE_FOOTER;
        else
            return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mData.size() + 2;
    }

    public void addItem(String title, String addr, String area, int code, String amount) {
        RecyclerItem item = new RecyclerItem();

        item.setNameStr(title);
        item.setAddrStr(addr);
        item.setAreaStr(area);
        item.setAreaCode(code);
        item.setAmount(amount);

        mData.add(item);
    }

    public void moveItem(int position) {
        RecyclerItem item = mData.remove(position);
        mData.add(item);
        notifyItemMoved(position, mData.size()+2);
        notifyDataSetChanged();
    }
}
