package net.ddns.axlrock.bands.Music_Play;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import net.ddns.axlrock.bands.R;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Song> list;

    public MyAdapter(Music_Play mainActivity, List<Song> list) {
        this.context = mainActivity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            //導入布局
            view = View.inflate(context, R.layout.music_play_item, null);
            //實例化物件
            holder.song = view.findViewById(R.id.item_mymusic_song);
            holder.singer = view.findViewById(R.id.item_mymusic_singer);
            holder.duration =  view.findViewById(R.id.item_mymusic_duration);
            holder.position = view.findViewById(R.id.item_mymusic_postion);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给元件賦值
        holder.song.setText(list.get(position).song.toString());
        holder.singer.setText(list.get(position).singer.toString());
        //时间需要轉換
        int duration = list.get(position).duration;
        String time = MusicUtils.formatTime(duration);
        holder.duration.setText(time);
        holder.position.setText(position+1+"");

        return view;
    }

    class ViewHolder{
        TextView song;//歌曲
        TextView singer;//歌手
        TextView duration;//時間長度
        TextView position;//索引值

    }

}