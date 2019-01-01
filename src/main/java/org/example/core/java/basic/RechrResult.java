package org.example.core.java.basic;

public enum RechrResult {

    /**
     * 未操作
     */
    UN_OPER(-1),
    /**
     * 等待充值
     */
    RECHR_WAIT(0),
    /**
     * 平台充值中
     */
    PLAT_RECHR_ING(10),
    /**
     * 第三方渠道充值中
     */
    THIRD_RECHR_ING(11),
    /**
     * 充值失败
     */
    RECHR_FAIL(20),
    /**
     * 充值成功
     */
    RECHR_OK(21);

    int result;

    private RechrResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public static RechrResult valueOf(int result) {
        for (RechrResult r : RechrResult.values()) {
            if (r.result == result) {
                return r;
            }
        }
        throw new IllegalArgumentException("no value for result : " + result);
    }
}
