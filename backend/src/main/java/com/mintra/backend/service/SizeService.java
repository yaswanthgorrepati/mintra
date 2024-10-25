package com.mintra.backend.service;

import com.mintra.backend.entities.Size;
import com.mintra.backend.json.SizeJson;

import java.util.List;

public interface SizeService {

    Size getSizeById(long id);

    List<Size> getSizeByProductId(long productId);

    List<Size> saveSizes(List<SizeJson> sizeJsonList, long productId);

    Size saveSize(SizeJson sizeJson, long productId);
}
