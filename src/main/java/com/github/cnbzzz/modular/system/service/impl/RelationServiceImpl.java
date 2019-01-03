package com.github.cnbzzz.modular.system.service.impl;

import com.github.cnbzzz.modular.system.dao.RelationMapper;
import com.github.cnbzzz.modular.system.model.Relation;
import com.github.cnbzzz.modular.system.service.IRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author bzzz123
 * @since 2018-02-22
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {

}
