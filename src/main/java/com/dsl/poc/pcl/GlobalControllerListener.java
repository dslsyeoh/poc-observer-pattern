package com.dsl.poc.pcl;

import org.springframework.stereotype.Component;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class GlobalControllerListener
{
    private Map<String, Runnable> runnableMap = new HashMap<>();
    private PropertyChangeSupport support;
    private GlobalControllerPropertyChangeListener globalControllerPCL;
    private boolean isDisableListener;

    private GlobalControllerListener()
    {
        support = new PropertyChangeSupport(this);
        globalControllerPCL = new GlobalControllerPropertyChangeListener();
    }

    public void addPropertyChangeListener()
    {
        isDisableListener = false;
        support.addPropertyChangeListener(globalControllerPCL);
    }

    public void enablePropertyChangeListener()
    {
        isDisableListener = false;
    }

    public void disablePropertyChangeListener()
    {
        isDisableListener = true;
    }

    public void setFirePropertyChange(String propertyName, Runnable runnable)
    {
        support.firePropertyChange(propertyName, this.runnableMap, runnable);
        runnableMap.put(propertyName, runnable);
    }

    public void fireProperty(String propertyName)
    {
        Runnable runnable = globalControllerPCL.getRunnableMap().get(propertyName);
        if(!isDisableListener && Objects.nonNull(runnable)) runnable.run();

    }
}
