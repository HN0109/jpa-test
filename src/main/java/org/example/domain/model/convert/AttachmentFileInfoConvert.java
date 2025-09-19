package org.example.domain.model.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.example.domain.model.AttachmentFileInfo;
import org.jetbrains.annotations.Nullable;

@Converter
public class AttachmentFileInfoConvert implements AttributeConverter<AttachmentFileInfo, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Nullable
    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(@Nullable AttachmentFileInfo attribute) {
        if (attribute == null) {
            return "";
        }
        return objectMapper.writeValueAsString(attribute);
    }

    @Nullable
    @Override
    @SneakyThrows
    public AttachmentFileInfo convertToEntityAttribute(@Nullable String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return null;
        }
        return objectMapper.readValue(dbData, AttachmentFileInfo.class);
    }
}
