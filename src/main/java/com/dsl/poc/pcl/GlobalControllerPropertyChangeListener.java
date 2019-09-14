package com.dsl.poc.pcl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class GlobalControllerPropertyChangeListener implements PropertyChangeListener
{
    private Map<String, BiConsumer<String, String>> biConsumerMap = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public void propertyChange(PropertyChangeEvent evt)
    {
        setRunnableMap(evt.getPropertyName(), (BiConsumer<String, String>)evt.getNewValue());
    }

    private void setRunnableMap(String key, BiConsumer<String, String> biConsumer)
    {
        biConsumerMap.put(key, biConsumer);
    }

    Map<String, BiConsumer<String, String>> getBiConsumerMap()
    {
        return biConsumerMap;
    }
}
