package org.corpname.anymall.common.to.constant;

public enum OrderItemStatus implements BaseCodeEnum {
    INIT(1),
    IN_PROCESS(2),
    COMPLETED(3),
    CANCELLED(4);

    private int code;
    OrderItemStatus(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
