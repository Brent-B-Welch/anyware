/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: ProductController
 * @packageName: org.corpname.anymall.product.controller
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:37
 **/
package org.corpname.anymall.product.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.corpname.anymall.common.utils.PageUtils;
import org.corpname.anymall.common.utils.R;
import org.corpname.anymall.product.entity.ProductArticleRelationEntity;
import org.corpname.anymall.product.entity.ProductEntity;
import org.corpname.anymall.product.service.ProductArticleRelationService;
import org.corpname.anymall.product.service.ProductService;
import org.corpname.anymall.product.vo.ProductVo;
import org.corpname.anymall.product.vo.batch.Product;
import org.corpname.anymall.common.to.ProductWithArticlesVo;
import org.corpname.anymall.product.vo.batch.Products;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product/product")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductArticleRelationService productArticleRelationService;
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/list")
    /**
     * @methodName: list
     * @description: list all Products
     * @param: [params]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:37
     */
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = productService.queryPage(params);
        return R.ok().put("page", page);
    }
    /**
     * @MethodName: listProductWithStock
     * @Description: Get all products and quantity of each that is available
     *               with the current inventory.
     * @Param: [params]
     * @Return: org.corpname.anymall.common.utils.R
     * @Author: Beiji Ma
     * @Date: 2021-12-14 8:54
    */
    @GetMapping("/stock")
    public R listProductWithStock(@RequestParam Map<String, Object> params) {
        PageUtils page = productService.getProductWithStock(params);
        return R.ok().put("page", page);
    }

    @GetMapping("/{productId}")
    /**
     * @methodName: getProductInfo
     * @description: inspect a Product by given id
     * @param: [productId]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:37
     */
    public R getProductInfo(@PathVariable("productId") Long productId) {
        ProductEntity productEntity = productService.getById(productId);
        ProductVo data = new ProductVo();
        BeanUtils.copyProperties(productEntity, data);
        return R.ok().put("data", data);
    }

    @GetMapping("/{productId}/withart")
    /**
     * @methodName: getProductWithArticle
     * @description: inspect a Product with Article information by given id
     * @param: [productId]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:38
     */
    public R getProductWithArticle(@PathVariable("productId") Long productId) {
        ProductWithArticlesVo data = productService.getProductWithArticlesByProductId(productId);
        return R.ok().put("data", data);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: addProductWithoutBindingResult
     * @description: add a product with json data
     * @param: [request]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-16 0:36
     */
    public R addProductWithoutBindingResult(@Valid @RequestBody ProductVo request) {
        ProductVo data = productService.save(request);
        return R.ok().put("data", data);
    }

    @PostMapping(path = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * @methodName: batchSaveOrUpdateProduct
     * @description: import products information form a json file
     * @param: [file]
     * @return: org.corpname.anymall.common.utils.R
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:38
     */
    public R batchSaveOrUpdateProduct(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(file.getInputStream()));

                Products products = mapper.readValue(reader, Products.class);
                log.info("inventory: {}", products);
                for (Product product : products.getProudcts()) {

                    QueryWrapper<ProductEntity> queryWrapper = new QueryWrapper<ProductEntity>().eq("name", product.getName());
                    ProductEntity productEntity = Optional.ofNullable(productService.getOne(queryWrapper))
                            .orElseGet(() -> {
                                ProductEntity entity = ProductEntity.builder()
                                        .name(product.getName())
                                        .build();
                                productService.save(entity);
                                return entity;
                            });

                    log.info("Product:{}, ID: {}", productEntity.getName(), productEntity.getId());

                    QueryWrapper<ProductArticleRelationEntity> productArticleRelationEntityQueryWrapper =new QueryWrapper<ProductArticleRelationEntity>().eq("product_id", productEntity.getId());
                    List<ProductArticleRelationEntity> relationEntities = productArticleRelationService.list(productArticleRelationEntityQueryWrapper);
                    log.info("Persisted Product before: {}", relationEntities);
                    List<ProductArticleRelationEntity> collect = product.getItems()
                            .stream()
                            .map(item -> {
                                        relationEntities.removeIf(relation -> relation.getProductId().equals(productEntity.getId()) && relation.getArtId().equals(item.getArtId()));
                                        return ProductArticleRelationEntity.builder()
                                                .artId(item.getArtId())
                                                .productId(productEntity.getId())
                                                .amountOf(item.getAmount())
                                                .build();
                                    }
                            ).collect(Collectors.toList());

                    log.info("Persisted Product: {}", relationEntities);
                    if (!relationEntities.isEmpty()) {
                        List<Long> rIds = relationEntities.stream().map(r -> r.getId()).collect(Collectors.toList());
                        productArticleRelationService.removeByIds(rIds);
                    }

                    log.info("To be Persisted Product: {}", collect);
                    productArticleRelationService.batchSaveOrUpdate(collect);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(reader);
            }
        }
        return R.ok();
    }
}
