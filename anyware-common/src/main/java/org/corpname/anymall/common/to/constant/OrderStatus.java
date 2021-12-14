package org.corpname.anymall.common.to.constant;

public enum OrderStatus implements BaseCodeEnum {
    INIT(1),
    IN_PROGRESS(2),
    COMPLETED(3),
    FAILED(4);

    private int code;

    OrderStatus(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
