package org.example.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentFileInfo {

    /**
     * 文件id
     */
    private Long id = -1L;
    /**
     * 存储的相对路径
     */
    private String storedPath = "";
    /**
     * 文件类型
     */
    private String contentType = "";
    /**
     * 原始文件名称
     */
    private String originalName = "";
    /**
     * 文件大小
     */
    private Long objectSize = 0L;
}
