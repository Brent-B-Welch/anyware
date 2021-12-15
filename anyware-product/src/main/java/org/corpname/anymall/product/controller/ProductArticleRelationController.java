/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductArticleRelationController
 * @packageName: org.corpname.anymall.product.controller
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:56
 **/
package org.corpname.anymall.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.product.entity.ProductArticleRelationEntity;
import org.corpname.anymall.product.service.ProductArticleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/product/productarticlerelation")
@Slf4j
public class ProductArticleRelationController {
    @Autowired
    private ProductArticleRelationService productArticleRelationService;

    @GetMapping("/")
    /**
     * @methodName: list
     * @description: list all ProductArticleRelation
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:56
     */
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = productArticleRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: save
     * @description: create ProductArticleRelationEntity
     * @param: [productArticleRelationEntity]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:56
     */
    public R save(@RequestBody ProductArticleRelationEntity productArticleRelationEntity) {
        productArticleRelationService.save(productArticleRelationEntity);

        return R.ok();
    }

    @PutMapping("/{id}")
    @ResponseBody
    /**
     * @methodName: update
     * @description: update ProductArticleRelationEntity
     * @param: [productArticleRelationEntity]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:57
     */
    public R update(@RequestBody ProductArticleRelationEntity productArticleRelationEntity) {
        productArticleRelationService.updateById(productArticleRelationEntity);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    /**
     * @methodName: delete
     * @description: remove ProductArticleRelationEntity by give a set of ids
     * @param: [ids]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:57
     */
    public R delete(@PathVariable("id") Long[] ids) {
        productArticleRelationService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
