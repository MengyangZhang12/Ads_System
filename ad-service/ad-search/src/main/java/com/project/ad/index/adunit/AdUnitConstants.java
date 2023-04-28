package com.project.ad.index.adunit;

public class AdUnitConstants {

    public static class POSITION_TYPE {
        //定义为二进制数字可以通过位与和位或运算加快检索速度

        /**
         * 开屏广告位
         */
        public static final int KAIPING = 1;

        /**
         * 贴片广告
         */
        public static final int TIEPIAN = 2;

        /**
         * 视频播放中显示的广告
         */
        public static final int TIEPIAN_MIDDLE = 4;

        /**
         * 视频播放暂停时广告
         */
        public static final int TIEPIAN_PAUSE = 8;

        /**
         * 视频播放后的广告位
         */
        public static final int TIEPIAN_POST = 16;
    }
}
