package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Size;
import com.mintra.backend.json.SizeJson;
import com.mintra.backend.repository.SizeRepository;
import com.mintra.backend.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Size getSizeById(long id) {
        return sizeRepository.getSizeById(id);
    }

    @Override
    public List<Size> getSizeByProductId(long productId) {
        return sizeRepository.getSizeByProductId(productId);
    }

    @Override
    public List<Size> saveSizes(List<SizeJson> sizeJsonList, long productId) {
        List<Size> sizeList = sizeJsonList.stream().map(sizeJson -> new Size(sizeJson.getSize(), productId)).toList();
        sizeRepository.saveSizes(sizeList);
        return sizeList;
    }

    @Override
    public Size saveSize(SizeJson sizeJson, long productId) {
        Size size = new Size(sizeJson.getSize(), productId);
        sizeRepository.saveSize(size);
        return size;
    }
}
