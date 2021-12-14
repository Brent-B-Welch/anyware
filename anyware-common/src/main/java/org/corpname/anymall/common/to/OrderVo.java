package org.corpname.anymall.common.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderVo {
    private Long id;
    @JsonProperty("order_sn")
    private String orderSn;
    @JsonProperty("order_status")
    private String orderStatus;
}
