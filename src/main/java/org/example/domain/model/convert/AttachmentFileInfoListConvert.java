package org.example.domain.model.convert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.example.domain.model.AttachmentFileInfo;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Converter
public class AttachmentFileInfoListConvert implements AttributeConverter<List<AttachmentFileInfo>, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final TypeReference<List<AttachmentFileInfo>> REF = new TypeReference<>() {
    };

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(List<AttachmentFileInfo> attribute) {
        if (CollectionUtils.isEmpty(attribute)) {
            return "";
        }
        return objectMapper.writeValueAsString(attribute);
    }

    @Override
    @SneakyThrows
    public List<AttachmentFileInfo> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(dbData, REF);
    }
}
