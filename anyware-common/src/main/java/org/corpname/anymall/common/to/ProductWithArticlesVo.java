package org.corpname.anymall.common.to;

import lombok.Data;
import java.util.List;

@Data
public class ProductWithArticlesVo {

    private Long id;

    private String name;

    private List<ProductArticleRelationVo> productArticleRelations;
}
