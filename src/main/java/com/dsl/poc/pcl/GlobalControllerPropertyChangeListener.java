package com.dsl.poc.pcl;

import com.dsl.poc.AttackChanged;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class GlobalControllerPropertyChangeListener implements PropertyChangeListener
{
    private Map<String, AttackChanged> attackChangedMap = new HashMap<>();

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        setRunnableMap(evt.getPropertyName(), (AttackChanged)evt.getNewValue());
    }

    private void setRunnableMap(String key, AttackChanged biConsumer)
    {
        attackChangedMap.put(key, biConsumer);
    }

    Map<String, AttackChanged> getAttackMap()
    {
        return attackChangedMap;
    }
}
