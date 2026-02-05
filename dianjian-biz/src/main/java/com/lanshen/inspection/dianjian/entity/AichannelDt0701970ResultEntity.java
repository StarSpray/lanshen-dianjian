package com.lanshen.inspection.dianjian.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * aichannelDt0701970Result
 *
 * @author inspection
 * @date 2026-02-04 15:16:02
 */
@Data
@TableName("aichannel_dt_07_01_9_70_result")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "aichannelDt0701970Result")
public class AichannelDt0701970ResultEntity extends Model<AichannelDt0701970ResultEntity> {

 
	/**
	* id
	*/
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description="id")
    private Long id;
 
	/**
	* number
	*/
    @Schema(description="number")
    private Integer number;
 
	/**
	* step1
	*/
    @Schema(description="step_1")
    @TableField(value = "step_1")
    private String step1;
 
	/**
	* step2
	*/
    @Schema(description="step_2")
    @TableField(value = "step_2")
    private String step2;
 
	/**
	* step3
	*/
    @Schema(description="step_3")
    @TableField(value = "step_3")
    private String step3;
 
	/**
	* step4
	*/
    @Schema(description="step_4")
    @TableField(value = "step_4")
    private String step4;
 
	/**
	* step5
	*/
    @Schema(description="step_5")
    @TableField(value = "step_5")
    private String step5;
 
	/**
	* activeError
	*/
    @Schema(description="activeError")
    private String activeError;
}
