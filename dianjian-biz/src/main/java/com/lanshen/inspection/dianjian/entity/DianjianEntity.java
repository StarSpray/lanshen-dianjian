package com.lanshen.inspection.dianjian.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * dianjian 表
 *
 * @author inspection
 * @date 2026-01-14 10:20:47
 */
@Data
@TableName("dianjian")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "dianjian 表")
public class DianjianEntity extends Model<DianjianEntity> {


	/**
	* 编号
	*/
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description="编号")
    private Long id;

	/**
	* 用户名
	*/
    @Schema(description="用户名")
    private String username;

	/**
	* 密码
	*/
    @Schema(description="密码")
    private String password;

	/**
	* 删除标记
	*/
    @TableLogic
	@TableField(fill = FieldFill.INSERT)
    @Schema(description="删除标记")
    private String delFlag;
}
