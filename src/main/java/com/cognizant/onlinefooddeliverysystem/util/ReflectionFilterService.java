package com.cognizant.onlinefooddeliverysystem.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReflectionFilterService {

    /**
     * Uses reflection to dynamically inspect an object and return a map of its non-null fields.
     *
     * @param object The object to inspect (e.g., your DTO).
     * @return A map where keys are field names and values are the non-null field values.
     */
    public Map<String, Object> getNonNullFields(Object object){
        Map<String, Object> nonNullFields = new HashMap<>();
        // Get all fields from the class, including private ones
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                // Make the field accessible, even if it's private
                field.setAccessible(true);
                // Get the value of the field for the given object instance
                Object value = field.get(object);

                // If the value is not null, add it to our map
                if (value != null) {
                    nonNullFields.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                // This should not happen if setAccessible(true) works, but it's good practice
                System.err.println("Could not access field: " + field.getName());
            }
        }
        return nonNullFields;
    }
}
