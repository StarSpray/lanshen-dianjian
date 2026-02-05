package com.lanshen.inspection.dianjian.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * dichannelDt0404972Result
 *
 * @author inspection
 * @date 2026-02-04 16:21:49
 */
@Data
@TableName("dichannel_dt_04_04_9_72_result")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "dichannelDt0404972Result")
public class DichannelDt0404972ResultEntity extends Model<DichannelDt0404972ResultEntity> {

 
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
	* activeTrueValue
	*/
    @Schema(description="activeTrueValue")
    private String activeTrueValue;
 
	/**
	* activeFalseValue
	*/
    @Schema(description="activeFalseValue")
    private String activeFalseValue;
}
