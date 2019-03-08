package basic.enumlass;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/27 上午10:51
 * @Description
 *
 * 枚举类，内部都适合实例
 *
 */
public enum SeasonEnum {

    SPRING("春天"),SUMMER("夏天"),FALL("秋天"),WINTER("冬天");

    private final String name;

    private SeasonEnum(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
