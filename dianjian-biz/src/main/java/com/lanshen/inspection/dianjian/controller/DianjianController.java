package com.lanshen.inspection.dianjian.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanshen.inspection.common.core.util.R;
import com.lanshen.inspection.common.log.annotation.SysLog;
import com.lanshen.inspection.common.excel.annotation.ResponseExcel;
import com.lanshen.inspection.common.excel.annotation.RequestExcel;
import com.lanshen.inspection.dianjian.entity.DianjianEntity;
import com.lanshen.inspection.dianjian.service.DianjianService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import com.lanshen.inspection.common.security.annotation.HasPermission;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpHeaders;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * dianjian 表
 *
 * @author inspection
 * @date 2026-01-14 10:20:47
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dianjian" )
@Tag(description = "dianjian" , name = "dianjian 表管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class DianjianController {

    private final  DianjianService dianjianService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param dianjian dianjian 表
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @HasPermission("dianjian_dianjian_view")
    public R getDianjianPage(@ParameterObject Page page, @ParameterObject DianjianEntity dianjian) {
        LambdaQueryWrapper<DianjianEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(dianjianService.page(page, wrapper));
    }


    /**
     * 通过条件查询dianjian 表
     * @param dianjian 查询条件
     * @return R  对象列表
     */
    @Operation(summary = "通过条件查询" , description = "通过条件查询对象" )
    @GetMapping("/details" )
    @HasPermission("dianjian_dianjian_view")
    public R getDetails(@ParameterObject DianjianEntity dianjian) {
        return R.ok(dianjianService.list(Wrappers.query(dianjian)));
    }

    /**
     * 新增dianjian 表
     * @param dianjian dianjian 表
     * @return R
     */
    @Operation(summary = "新增dianjian 表" , description = "新增dianjian 表" )
    @SysLog("新增dianjian 表" )
    @PostMapping
    @HasPermission("dianjian_dianjian_add")
    public R save(@RequestBody DianjianEntity dianjian) {
        return R.ok(dianjianService.save(dianjian));
    }

    /**
     * 修改dianjian 表
     * @param dianjian dianjian 表
     * @return R
     */
    @Operation(summary = "修改dianjian 表" , description = "修改dianjian 表" )
    @SysLog("修改dianjian 表" )
    @PutMapping
    @HasPermission("dianjian_dianjian_edit")
    public R updateById(@RequestBody DianjianEntity dianjian) {
        return R.ok(dianjianService.updateById(dianjian));
    }

    /**
     * 通过id删除dianjian 表
     * @param ids id列表
     * @return R
     */
    @Operation(summary = "通过id删除dianjian 表" , description = "通过id删除dianjian 表" )
    @SysLog("通过id删除dianjian 表" )
    @DeleteMapping
    @HasPermission("dianjian_dianjian_del")
    public R removeById(@RequestBody Long[] ids) {
        return R.ok(dianjianService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param dianjian 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @HasPermission("dianjian_dianjian_export")
    public List<DianjianEntity> exportExcel(DianjianEntity dianjian,Long[] ids) {
        return dianjianService.list(Wrappers.lambdaQuery(dianjian).in(ArrayUtil.isNotEmpty(ids), DianjianEntity::getId, ids));
    }

    /**
     * 导入excel 表
     * @param dianjianList 对象实体列表
     * @param bindingResult 错误信息列表
     * @return ok fail
     */
    @PostMapping("/import")
    @HasPermission("dianjian_dianjian_export")
    public R importExcel(@RequestExcel List<DianjianEntity> dianjianList, BindingResult bindingResult) {
        return R.ok(dianjianService.saveBatch(dianjianList));
    }
}
