package org.zlh.design.demo.factory.impl;

import org.zlh.design.demo.factory.ICacheAdapter;
import org.zlh.design.demo.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * 在IIR外包装一层，本质就是统一方法名
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    public String get(String key) {
        return iir.get(key);
    }

    public void set(String key, String value) {
        iir.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        iir.del(key);
    }

}
