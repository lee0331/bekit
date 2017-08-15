/*
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-04-04 20:15 创建
 */
package org.bekit.flow.listener;

import org.bekit.flow.annotation.listener.FlowListener;
import org.bekit.flow.event.FlowExceptionEvent;
import org.bekit.flow.event.NodeDecidedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.bekit.event.annotation.listener.Listen;

/**
 * 默认的流程事件监听器
 * （流程引擎初始化时会初始化本监听器，其作用是监听所有流程发生的事件，然后将事件转发给对应流程的特定监听器（@TheFlowListener））
 */
@FlowListener
public class DefaultFlowEventListener {
    @Autowired
    private TheFlowListenerHolder theFlowListenerHolder;

    // 监听节点选择事件
    @Listen
    public void listenNodeDecidedEvent(NodeDecidedEvent event) throws Throwable {
        TheFlowListenerExecutor theFlowListenerExecutor = theFlowListenerHolder.getTheFlowListenerExecutor(event.getFlow());
        if (theFlowListenerExecutor != null) {
            theFlowListenerExecutor.listenNodeDecided(event.getNode(), event.getTargetContext());
        }
    }

    // 监听流程异常事件
    @Listen
    public void listenFlowExceptionEvent(FlowExceptionEvent event) throws Throwable {
        TheFlowListenerExecutor theFlowListenerExecutor = theFlowListenerHolder.getTheFlowListenerExecutor(event.getFlow());
        if (theFlowListenerExecutor != null) {
            theFlowListenerExecutor.listenFlowException(event.getThrowable(), event.getTargetContext());
        }
    }
}