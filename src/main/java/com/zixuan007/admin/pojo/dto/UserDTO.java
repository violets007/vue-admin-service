package com.zixuan007.admin.pojo.dto;

import com.zixuan007.admin.pojo.entity.RoleEntity;
import lombok.Data;

import java.util.List;

/**
 * User传输对象
 *
 * @author zixuan007
 * @date 2020/10/18
 */
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String headPortrait;
    private List<RoleEntity> roleEntity;
}
