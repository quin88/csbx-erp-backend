package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ServeProject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ServeProjectMapperEx {

    List<ServeProject> searchServeProject(@Param("type") String type,
                                          @Param("active") String active,
                                          @Param("projectName") String projectName,
                                          @Param("offset") Integer offset,
                                          @Param("rows") Integer rows);

    Long countServeProject(@Param("type")String type,
                           @Param("active") String active,
                           @Param("projectName") String projectName);

}
