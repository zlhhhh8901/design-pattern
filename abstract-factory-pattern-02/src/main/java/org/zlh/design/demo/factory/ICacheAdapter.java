package org.zlh.design.demo.factory;

import java.util.concurrent.TimeUnit;

/**
 * 定义适配接口，用于统一两集群的方法名
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
