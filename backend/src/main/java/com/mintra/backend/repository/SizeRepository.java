package com.mintra.backend.repository;

import com.mintra.backend.entities.Size;

import java.util.List;

public interface SizeRepository {

    Size getSizeById(long id);

    List<Size> getSizeByProductId(long productId);

    List<Size> saveSizes(List<Size> sizeList);

    Size saveSize(Size size);
}
