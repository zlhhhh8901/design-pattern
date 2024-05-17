package org.zlh.design.demo.factory.impl;

import org.zlh.design.demo.factory.ICacheAdapter;
import org.zlh.design.demo.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * 在EGM外包装一层，本质就是统一方法名
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        egm.delete(key);
    }
}
