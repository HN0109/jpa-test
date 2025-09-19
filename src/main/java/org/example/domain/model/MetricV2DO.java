package org.example.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.model.convert.AttachmentFileInfoListConvert;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
@Entity
@Comment("指标V2")
@EntityListeners(AuditingEntityListener.class)
@Table(name = MetricV2DO.TABLE_NAME, indexes = {
})
public class MetricV2DO {
    public static final String TABLE_NAME = "metric_v2";

    /**
     * 主键
     */
    @Id
    @Comment("主键,")
    @Column(nullable = false, name = "id_")
    private Long id = null;

    @NotNull
    @Comment("名称")
    @Column(nullable = false, name = "name_")
    private String name = "";

    /**
     * 审核图片
     */
    @NotNull
    @Comment("审核图片")
    @JdbcType(LongVarcharJdbcType.class)
    @Convert(converter = AttachmentFileInfoListConvert.class)
    @Column(nullable = false, name = "audit_images_")
    private List<AttachmentFileInfo> auditImages = new ArrayList<>();

    @Version
    @Comment("乐观锁版本")
    @Column(nullable = false, name = "version_")
    private long version = 0;

    @CreatedDate
    @Comment("创建时间")
    @Column(nullable = false, name = "created_time_")
    private long createdTime = 0;

    @LastModifiedDate
    @Comment("更新时间")
    @Column(nullable = false, name = "updated_time_")
    private long updatedTime = 0;


    @NotNull
    public static MetricV2DO create(@NotNull Long id) {
        MetricV2DO metricV2DO = new MetricV2DO();
        metricV2DO.setId(id);
        metricV2DO.setName("");
        AttachmentFileInfo file1 = new AttachmentFileInfo();
        AttachmentFileInfo file2 = new AttachmentFileInfo();
        AttachmentFileInfo file3 = new AttachmentFileInfo();
        metricV2DO.setAuditImages(List.of(file1, file2, file3));
        return metricV2DO;
    }
}
