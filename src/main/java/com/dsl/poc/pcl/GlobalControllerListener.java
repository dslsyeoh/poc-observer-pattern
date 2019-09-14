package com.dsl.poc.pcl;

import com.dsl.poc.Attacker;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeSupport;

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

    public void setFirePropertyChange(String propertyName, Attacker attacker)
    {
        support.firePropertyChange(propertyName, null, attacker);
    }

    public Attacker fireProperty(String propertyName)
    {
        return globalControllerPCL.getAttackMap().get(propertyName);
    }
}
