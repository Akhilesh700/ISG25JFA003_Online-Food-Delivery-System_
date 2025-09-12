package com.cognizant.onlinefooddeliverysystem.util;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * This converter allows JPA to map a java.time.LocalDateTime object
 * to a database TIMESTAMP column.
 *
 * @Converter(autoApply = true) means this converter will be automatically
 * applied to all attributes of LocalDateTime type.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    // Converts LocalDateTime from your entity to a Timestamp for the database
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return (localDateTime == null ? null : Timestamp.valueOf(localDateTime));
    }

    // Converts Timestamp from the database to a LocalDateTime for your entity
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return (timestamp == null ? null : timestamp.toLocalDateTime());
    }
}