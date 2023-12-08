package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.enumeration.OperationType;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * データを挿入します
     * @param category
     */
    @Insert("insert into category(type, name, sort, status, create_time, update_time, create_user, update_user)" +
            " VALUES" +
            " (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Category category);

    /**
     * ページネーション検索
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * IDに基づいてカテゴリを削除します。
     * @param id
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    /**
     * 根IDに基づいてカテゴリを変更します。
     * @param category
     */
    void update(Category category);

    /**
     * タイプに基づいてカテゴリを検索します。
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
