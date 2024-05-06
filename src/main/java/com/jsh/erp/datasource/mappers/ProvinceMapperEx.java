package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.dto.ProvinceDTO;
import java.util.List;

public interface ProvinceMapperEx {

    List<ProvinceDTO> selectAllCountiesInTree();
}