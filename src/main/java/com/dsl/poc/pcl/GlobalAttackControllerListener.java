package com.dsl.poc.pcl;

import com.dsl.poc.Attacker;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeSupport;

@Component
public class GlobalAttackControllerListener
{
    private PropertyChangeSupport support;
    private GlobalAttackControllerPCL globalAttackControllerPCL;

    private GlobalAttackControllerListener()
    {
        support = new PropertyChangeSupport(this);
        globalAttackControllerPCL = new GlobalAttackControllerPCL();
    }

    public void addPropertyChangeListener()
    {
        support.addPropertyChangeListener(globalAttackControllerPCL);
    }

    public void removePropertyChangeListener()
    {
        support.removePropertyChangeListener(globalAttackControllerPCL);
    }

    public void setFirePropertyChange(String propertyName, Attacker attacker)
    {
        support.firePropertyChange(propertyName, null, attacker);
    }

    public Attacker fireProperty(String propertyName)
    {
        return globalAttackControllerPCL.getAttackMap().get(propertyName);
    }
}
