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
import com.lanshen.inspection.dianjian.entity.DichannelDt0404972ResultEntity;
import com.lanshen.inspection.dianjian.service.DichannelDt0404972ResultService;

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
 * dichannelDt0404972Result
 *
 * @author inspection
 * @date 2026-02-04 16:21:49
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dichannelDt0404972Result" )
@Tag(description = "dichannelDt0404972Result" , name = "dichannelDt0404972Result管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class DichannelDt0404972ResultController {

    private final  DichannelDt0404972ResultService dichannelDt0404972ResultService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param dichannelDt0404972Result dichannelDt0404972Result
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @HasPermission("dianjian_dichannelDt0404972Result_view")
    public R getDichannelDt0404972ResultPage(@ParameterObject Page page, @ParameterObject DichannelDt0404972ResultEntity dichannelDt0404972Result) {
        LambdaQueryWrapper<DichannelDt0404972ResultEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(dichannelDt0404972ResultService.page(page, wrapper));
    }


    /**
     * 通过条件查询dichannelDt0404972Result
     * @param dichannelDt0404972Result 查询条件
     * @return R  对象列表
     */
    @Operation(summary = "通过条件查询" , description = "通过条件查询对象" )
    @GetMapping("/details" )
    @HasPermission("dianjian_dichannelDt0404972Result_view")
    public R getDetails(@ParameterObject DichannelDt0404972ResultEntity dichannelDt0404972Result) {
        return R.ok(dichannelDt0404972ResultService.list(Wrappers.query(dichannelDt0404972Result)));
    }

    /**
     * 新增dichannelDt0404972Result
     * @param dichannelDt0404972Result dichannelDt0404972Result
     * @return R
     */
    @Operation(summary = "新增dichannelDt0404972Result" , description = "新增dichannelDt0404972Result" )
    @SysLog("新增dichannelDt0404972Result" )
    @PostMapping
    @HasPermission("dianjian_dichannelDt0404972Result_add")
    public R save(@RequestBody DichannelDt0404972ResultEntity dichannelDt0404972Result) {
        return R.ok(dichannelDt0404972ResultService.save(dichannelDt0404972Result));
    }

    /**
     * 修改dichannelDt0404972Result
     * @param dichannelDt0404972Result dichannelDt0404972Result
     * @return R
     */
    @Operation(summary = "修改dichannelDt0404972Result" , description = "修改dichannelDt0404972Result" )
    @SysLog("修改dichannelDt0404972Result" )
    @PutMapping
    @HasPermission("dianjian_dichannelDt0404972Result_edit")
    public R updateById(@RequestBody DichannelDt0404972ResultEntity dichannelDt0404972Result) {
        return R.ok(dichannelDt0404972ResultService.updateById(dichannelDt0404972Result));
    }

    /**
     * 通过id删除dichannelDt0404972Result
     * @param ids id列表
     * @return R
     */
    @Operation(summary = "通过id删除dichannelDt0404972Result" , description = "通过id删除dichannelDt0404972Result" )
    @SysLog("通过id删除dichannelDt0404972Result" )
    @DeleteMapping
    @HasPermission("dianjian_dichannelDt0404972Result_del")
    public R removeById(@RequestBody Long[] ids) {
        return R.ok(dichannelDt0404972ResultService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param dichannelDt0404972Result 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @HasPermission("dianjian_dichannelDt0404972Result_export")
    public List<DichannelDt0404972ResultEntity> exportExcel(DichannelDt0404972ResultEntity dichannelDt0404972Result,Long[] ids) {
        return dichannelDt0404972ResultService.list(Wrappers.lambdaQuery(dichannelDt0404972Result).in(ArrayUtil.isNotEmpty(ids), DichannelDt0404972ResultEntity::getId, ids));
    }

    /**
     * 导入excel 表
     * @param dichannelDt0404972ResultList 对象实体列表
     * @param bindingResult 错误信息列表
     * @return ok fail
     */
    @PostMapping("/import")
    @HasPermission("dianjian_dichannelDt0404972Result_export")
    public R importExcel(@RequestExcel List<DichannelDt0404972ResultEntity> dichannelDt0404972ResultList, BindingResult bindingResult) {
        return R.ok(dichannelDt0404972ResultService.saveBatch(dichannelDt0404972ResultList));
    }
}
