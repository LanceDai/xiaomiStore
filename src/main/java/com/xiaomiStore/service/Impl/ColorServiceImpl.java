package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.ColorDao;
import com.xiaomiStore.pojo.Color;
import com.xiaomiStore.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    private final ColorDao colorDao;

    @Autowired
    public ColorServiceImpl(ColorDao colorDao) {
        this.colorDao = colorDao;
    }

    @Override
    public int insert(Color record) {
        return colorDao.insert(record);
    }

    @Override
    public int delete(String colorId) {
        return colorDao.delete(colorId);
    }

    @Override
    public int update(Color record) {
        return colorDao.update(record);
    }

    @Override
    public List<Color> selectAll() {
        return colorDao.selectAll();
    }

    @Override
    public String getColorNameByColorId(String colorId) {
        return colorDao.getColorNameByColorId(colorId);
    }

    @Override
    public String getColorIdByColorName(String colorName) {
        return colorDao.getColorIdByColorName(colorName);
    }
}
