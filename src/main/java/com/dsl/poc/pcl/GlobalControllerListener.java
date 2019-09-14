package com.dsl.poc.pcl;

import com.dsl.poc.AttackChanged;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeSupport;
import java.util.function.BiConsumer;

@Component
public class GlobalControllerListener
{
    private PropertyChangeSupport support;
    private GlobalControllerPropertyChangeListener globalControllerPCL;

    private GlobalControllerListener()
    {
        support = new PropertyChangeSupport(this);
        globalControllerPCL = new GlobalControllerPropertyChangeListener();
    }

    public void addPropertyChangeListener()
    {
        support.addPropertyChangeListener(globalControllerPCL);
    }

    public void removePropertyChangeListener()
    {
        support.removePropertyChangeListener(globalControllerPCL);
    }

    public void setFirePropertyChange(String propertyName, BiConsumer<String, String> biConsumer)
    {
        support.firePropertyChange(propertyName, null, biConsumer);
    }

    public AttackChanged fireProperty(String propertyName)
    {
        return globalControllerPCL.getAttackMap().get(propertyName);
    }
}
