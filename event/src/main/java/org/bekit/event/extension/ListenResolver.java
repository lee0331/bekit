/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-09-29 11:35 创建
 */
package org.bekit.event.extension;

import java.lang.reflect.Method;

/**
 * 监听解决器
 */
public interface ListenResolver {

    /**
     * 初始化（每个实例仅调用一次）
     *
     * @param listenMethod 监听方法
     */
    void init(Method listenMethod);

    /**
     * 获取监听的事件类型
     */
    Object getEventType();

    /**
     * 解决调用监听方法的入参
     *
     * @param event 事件
     * @return 调用监听方法的入参
     */
    Object[] resolveArgs(Object event);
}
