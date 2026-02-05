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
import com.lanshen.inspection.dianjian.entity.AichannelDt0701970ResultEntity;
import com.lanshen.inspection.dianjian.service.AichannelDt0701970ResultService;

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
 * aichannelDt0701970Result
 *
 * @author inspection
 * @date 2026-02-04 15:16:02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/aichannelDt0701970Result" )
@Tag(description = "aichannelDt0701970Result" , name = "aichannelDt0701970Result管理" )
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AichannelDt0701970ResultController {

    private final  AichannelDt0701970ResultService aichannelDt0701970ResultService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param aichannelDt0701970Result aichannelDt0701970Result
     * @return
     */
    @Operation(summary = "分页查询" , description = "分页查询" )
    @GetMapping("/page" )
    @HasPermission("dianjian_aichannelDt0701970Result_view")
    public R getAichannelDt0701970ResultPage(@ParameterObject Page page, @ParameterObject AichannelDt0701970ResultEntity aichannelDt0701970Result) {
        LambdaQueryWrapper<AichannelDt0701970ResultEntity> wrapper = Wrappers.lambdaQuery();
        return R.ok(aichannelDt0701970ResultService.page(page, wrapper));
    }


    /**
     * 通过条件查询aichannelDt0701970Result
     * @param aichannelDt0701970Result 查询条件
     * @return R  对象列表
     */
    @Operation(summary = "通过条件查询" , description = "通过条件查询对象" )
    @GetMapping("/details" )
    @HasPermission("dianjian_aichannelDt0701970Result_view")
    public R getDetails(@ParameterObject AichannelDt0701970ResultEntity aichannelDt0701970Result) {
        return R.ok(aichannelDt0701970ResultService.list(Wrappers.query(aichannelDt0701970Result)));
    }

    /**
     * 新增aichannelDt0701970Result
     * @param aichannelDt0701970Result aichannelDt0701970Result
     * @return R
     */
    @Operation(summary = "新增aichannelDt0701970Result" , description = "新增aichannelDt0701970Result" )
    @SysLog("新增aichannelDt0701970Result" )
    @PostMapping
    @HasPermission("dianjian_aichannelDt0701970Result_add")
    public R save(@RequestBody AichannelDt0701970ResultEntity aichannelDt0701970Result) {
        return R.ok(aichannelDt0701970ResultService.save(aichannelDt0701970Result));
    }

    /**
     * 修改aichannelDt0701970Result
     * @param aichannelDt0701970Result aichannelDt0701970Result
     * @return R
     */
    @Operation(summary = "修改aichannelDt0701970Result" , description = "修改aichannelDt0701970Result" )
    @SysLog("修改aichannelDt0701970Result" )
    @PutMapping
    @HasPermission("dianjian_aichannelDt0701970Result_edit")
    public R updateById(@RequestBody AichannelDt0701970ResultEntity aichannelDt0701970Result) {
        return R.ok(aichannelDt0701970ResultService.updateById(aichannelDt0701970Result));
    }

    /**
     * 通过id删除aichannelDt0701970Result
     * @param ids id列表
     * @return R
     */
    @Operation(summary = "通过id删除aichannelDt0701970Result" , description = "通过id删除aichannelDt0701970Result" )
    @SysLog("通过id删除aichannelDt0701970Result" )
    @DeleteMapping
    @HasPermission("dianjian_aichannelDt0701970Result_del")
    public R removeById(@RequestBody Long[] ids) {
        return R.ok(aichannelDt0701970ResultService.removeBatchByIds(CollUtil.toList(ids)));
    }


    /**
     * 导出excel 表格
     * @param aichannelDt0701970Result 查询条件
   	 * @param ids 导出指定ID
     * @return excel 文件流
     */
    @ResponseExcel
    @GetMapping("/export")
    @HasPermission("dianjian_aichannelDt0701970Result_export")
    public List<AichannelDt0701970ResultEntity> exportExcel(AichannelDt0701970ResultEntity aichannelDt0701970Result,Long[] ids) {
        return aichannelDt0701970ResultService.list(Wrappers.lambdaQuery(aichannelDt0701970Result).in(ArrayUtil.isNotEmpty(ids), AichannelDt0701970ResultEntity::getId, ids));
    }

    /**
     * 导入excel 表
     * @param aichannelDt0701970ResultList 对象实体列表
     * @param bindingResult 错误信息列表
     * @return ok fail
     */
    @PostMapping("/import")
    @HasPermission("dianjian_aichannelDt0701970Result_export")
    public R importExcel(@RequestExcel List<AichannelDt0701970ResultEntity> aichannelDt0701970ResultList, BindingResult bindingResult) {
        return R.ok(aichannelDt0701970ResultService.saveBatch(aichannelDt0701970ResultList));
    }
}
