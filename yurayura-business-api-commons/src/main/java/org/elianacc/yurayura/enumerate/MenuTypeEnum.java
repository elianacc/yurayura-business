package org.elianacc.yurayura.enumerate;

import lombok.Getter;

/**
 * 系统菜单类型 enum
 *
 * @author ELiaNaCc
 * @since 2021-03-25
 */
@Getter
public enum MenuTypeEnum {

    /**
     * 一级菜单
     */
    FIRSTLEVEL(1),
    /**
     * 二级菜单
     */
    SECONDLEVEL(2);

    private Integer typeId;

    MenuTypeEnum(int typeId) {
        this.typeId = typeId;
    }

}
