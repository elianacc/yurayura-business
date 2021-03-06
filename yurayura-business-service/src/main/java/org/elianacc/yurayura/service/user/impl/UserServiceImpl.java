package org.elianacc.yurayura.service.user.impl;

import com.baomidou.lock.annotation.Lock4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.elianacc.yurayura.dao.user.UserMapper;
import org.elianacc.yurayura.dto.IdDto;
import org.elianacc.yurayura.dto.UserSelectDto;
import org.elianacc.yurayura.dto.UserUpdateStatusDto;
import org.elianacc.yurayura.entity.user.User;
import org.elianacc.yurayura.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 用户 service impl
 *
 * @author ELiaNaCc
 * @since 2019-10-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${yurayura.default-upload.user-avatar}")
    private String defaultUplUserAvatar;

    @Override
    public PageInfo<User> getPage(UserSelectDto dto) {
        // 设置分页
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(queryWrapper
                .select(User.class, i -> !i.getColumn().equals("user_password"))
                .nested(!ObjectUtils.isEmpty(dto.getUserNameKeyword()), i -> i.like("user_name", dto.getUserNameKeyword())
                        .or()
                        .like("user_nickname", dto.getUserNameKeyword())
                )
                .eq(!ObjectUtils.isEmpty(dto.getUserSex()), "user_sex", dto.getUserSex())
                .eq(!ObjectUtils.isEmpty(dto.getUserStatus()), "user_status", dto.getUserStatus())
                .eq(!ObjectUtils.isEmpty(dto.getUserPhoneNumber()), "user_phone_number", dto.getUserPhoneNumber())
                .orderByDesc("id"));
        return new PageInfo<>(userList, 5);
    }

    @Transactional(rollbackFor = Exception.class)
    @Lock4j(keys = {"#dto.id"}, autoRelease = false)
    @Override
    public void updateStatus(UserUpdateStatusDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUserStatus(dto.getUserStatus());
        userMapper.updateById(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateAvatarDefault(IdDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUserAvatarUrl(defaultUplUserAvatar);
        userMapper.updateById(user);
    }

}
