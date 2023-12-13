package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * カテゴリ管理
 */
@RestController
@RequestMapping("/admin/category")
@Api(tags = "カテゴリに関連するAPI")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * カテゴリを追加します
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("カテゴリを追加します")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO){
        log.info("カテゴリを追加します：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * カテゴリのページネーション検索
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("カテゴリのページネーション検索")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("ページネーション検索：{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * カテゴリを削除します
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("カテゴリを削除します")
    public Result<String> deleteById(Long id){
        log.info("カテゴリを削除します：{}", id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * カテゴリを変更します
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("カテゴリを変更します")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * カテゴリの有効化また無効化
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("カテゴリの有効化また無効化")
    public Result<String> startOrStop(@PathVariable("status") Integer status, Long id){
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    /**
     * タイプに基づいてカテゴリを検索します
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("タイプに基づいてカテゴリを検索します")
    public Result<List<Category>> list(Integer type){
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
  
}
