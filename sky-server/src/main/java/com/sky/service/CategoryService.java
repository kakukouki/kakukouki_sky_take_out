package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import java.util.List;

public interface CategoryService {

    /**
     * 新しいカテゴリを追加します。
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * ページネーション検索
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * IDに基づいてカテゴリを削除します
     * @param id
     */
    void deleteById(Long id);

    /**
     * カテゴリを変更します
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * カテゴリの有効化また無効化
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * タイプに基づいてカテゴリを検索します
     * @param type
     * @return
     */
    List<Category> list(Integer type);
    
}
