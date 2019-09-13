package com.dsl.poc.pcl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class GlobalControllerPropertyChangeListener implements PropertyChangeListener
{
    private Map<String, Runnable> runnableMap = new HashMap<>();

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        setRunnableMap(evt.getPropertyName(), (Runnable) evt.getNewValue());
    }

    private void setRunnableMap(String key, Runnable runnable)
    {
        runnableMap.put(key, runnable);
    }

    Map<String, Runnable> getRunnableMap()
    {
        return runnableMap;
    }

    Runnable get(String propertyName)
    {
        return getRunnableMap().get(propertyName);
    }
}
