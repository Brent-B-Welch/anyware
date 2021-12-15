/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskItemArticleServiceImpl
 * @packageName: org.corpname.anymall.ware.service.impl
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:27
 **/
package org.corpname.anymall.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.ware.dao.WareOrderTaskItemArticleDao;
import org.corpname.anymall.ware.entity.WareOrderTaskItemArticleEntity;
import org.corpname.anymall.ware.service.WareOrderTaskItemArticleService;
import org.springframework.stereotype.Service;

@Slf4j
@Service("wareOrderTaskItemArticleService")
public class WareOrderTaskItemArticleServiceImpl extends ServiceImpl<WareOrderTaskItemArticleDao, WareOrderTaskItemArticleEntity> implements WareOrderTaskItemArticleService {
}
