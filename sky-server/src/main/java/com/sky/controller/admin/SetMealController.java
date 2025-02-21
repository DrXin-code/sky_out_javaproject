package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetMealService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/setmeal")
@ApiOperation("套餐相关接口")
public class SetMealController {
    @Autowired
    private SetMealService setMealService;
    @PostMapping
    @ApiOperation("新增套餐")
    public Result saveMeal(@RequestBody SetmealDTO setmealDTO) {

        setMealService.save(setmealDTO);

        return Result.success(setmealDTO);
    }

    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageResult pageResult=setMealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("删除套餐接口")
    public Result deleteMeal(@RequestParam List<Long> ids) {
        setMealService.deleteMealBatch(ids);

        return Result.success();

    }
}
