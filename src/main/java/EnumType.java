/**
 * @Author: mengchao
 * @Date: 2020/8/28 10:25
 */
public enum EnumType {
    /**
     * 测试枚举类型
     */
    EXAM("tbl_exam"),
    LAB("tbl_lab"),
    ADM("tbl_admission");

    private String table;
    EnumType(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }
}
