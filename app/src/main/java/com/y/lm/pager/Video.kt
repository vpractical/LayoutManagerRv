package com.y.lm.pager

import com.y.lm.R

class Video {

    companion object{
        fun createData(): List<Video>{
            val list = ArrayList<Video>()
            list.add(Video(R.raw.video_1,R.mipmap.img_video_1))
            list.add(Video(R.raw.video_2,R.mipmap.img_video_2))
            list.add(Video(R.raw.video_1,R.mipmap.img_video_1))
            list.add(Video(R.raw.video_2,R.mipmap.img_video_2))
            list.add(Video(R.raw.video_1,R.mipmap.img_video_1))
            list.add(Video(R.raw.video_2,R.mipmap.img_video_2))
            list.add(Video(R.raw.video_1,R.mipmap.img_video_1))
            list.add(Video(R.raw.video_2,R.mipmap.img_video_2))
            list.add(Video(R.raw.video_1,R.mipmap.img_video_1))
            list.add(Video(R.raw.video_2,R.mipmap.img_video_2))
            list.add(Video(R.raw.video_1,R.mipmap.img_video_1))
            list.add(Video(R.raw.video_2,R.mipmap.img_video_2))
            list.add(Video(R.raw.video_1,R.mipmap.img_video_1))
            list.add(Video(R.raw.video_2,R.mipmap.img_video_2))
            return list
        }
    }

    var videoId: Int
    var coverId: Int

    constructor(videoId: Int, coverId: Int) {
        this.videoId = videoId
        this.coverId = coverId
    }
}