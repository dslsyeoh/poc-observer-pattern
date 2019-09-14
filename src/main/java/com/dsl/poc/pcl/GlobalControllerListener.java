package com.dsl.poc.pcl;

import org.springframework.stereotype.Component;

import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.function.BiConsumer;

@Component
public class GlobalControllerListener
{
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

    public void removePropertyChangeListener()
    {
        support.removePropertyChangeListener(globalControllerPCL);
    }

    public void enablePropertyChangeListener()
    {
        isDisableListener = false;
    }

    public void disablePropertyChangeListener()
    {
        isDisableListener = true;
    }

    public void setFirePropertyChange(String propertyName, BiConsumer<String, String> biConsumer)
    {
        support.firePropertyChange(propertyName, null, biConsumer);
    }


    public BiConsumer<String, String> fireProperty(String propertyName)
    {
        return globalControllerPCL.getBiConsumerMap().get(propertyName);
    }
}
