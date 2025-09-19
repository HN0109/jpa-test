package org.example.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Slf4j
@Getter
@Setter
@Entity
@Comment("指标")
@EntityListeners(AuditingEntityListener.class)
@Table(name = MetricDO.TABLE_NAME, indexes = {
})
public class MetricDO {
    public static final String TABLE_NAME = "metric";

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
    public static MetricDO create(@NotNull Long id) {
        MetricDO metricV2DO = new MetricDO();
        metricV2DO.setId(id);
        metricV2DO.setName("");
        return metricV2DO;
    }
}
