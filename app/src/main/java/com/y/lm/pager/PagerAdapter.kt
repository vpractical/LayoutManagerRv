package com.y.lm.pager

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.y.lm.R
import kotlinx.android.synthetic.main.item_pager.view.*

class PagerAdapter(context: Context, data: List<Video>) :
    RecyclerView.Adapter<PagerAdapter.ViewHolder>() {
    private val mContext: Context = context
    private val mData: List<Video> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_pager, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = mData[position]
        holder.itemView.ivCover.setImageResource(video.coverId)
        holder.itemView.vv.setVideoURI(Uri.parse("android.resource://" + mContext.packageName + "/" + video.videoId))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val vv: VideoView = view.findViewById(R.id.vv)
        private val ivCover: ImageView = view.findViewById(R.id.ivCover)
        private val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        private val ivPlay: ImageView = view.findViewById(R.id.ivPlay)
    }

    fun releaseItem(view: View){
        val vv: VideoView = view.findViewById(R.id.vv)
        val ivCover: ImageView = view.findViewById(R.id.ivCover)
        val ivPlay: ImageView = view.findViewById(R.id.ivPlay)
        vv.stopPlayback()
        ivCover.animate().alpha(1f).start()
        ivPlay.animate().alpha(0f).start()
    }

    /**
     * 播放时，资源加载和渲染耗时导致开头有黑屏
     * OnInfoListener监听播放器状态，由第二个参数what表示
     * 当what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START表示已渲染了第一帧
     */
    fun selectItem(view: View){
        val vv: VideoView = view.findViewById(R.id.vv)
        val ivCover: ImageView = view.findViewById(R.id.ivCover)
        val ivPlay: ImageView = view.findViewById(R.id.ivPlay)
        vv.setOnInfoListener{ mediaPlayer, what, _ ->
            mediaPlayer.isLooping = true
            if(what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START){
                ivCover.animate().alpha(0f).setDuration(200).start()
            }
            false
        }
        ivPlay.setOnClickListener{
            if(vv.isPlaying){
                vv.pause()
                ivPlay.animate().alpha(1f).start()
            }else{
                vv.start()
                ivPlay.animate().alpha(0f).start()
            }
        }
        vv.start()
    }
}