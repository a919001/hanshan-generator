package com.hanshan.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    private static volatile Meta meta;

    private MetaManager() {
        //私有化构造函数，防止外部实例化
    }

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }

        return meta;
    }

    private static Meta initMeta() {
        String meatJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(meatJson, Meta.class);
        Meta.FileConfig fileConfig = newMeta.getFileConfig();
        //todo 校验和处理默认值
        return newMeta;
    }
}
