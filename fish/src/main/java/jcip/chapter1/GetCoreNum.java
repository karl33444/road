package jcip.chapter1;

/**
 * 获取逻辑处理器
 *
 * @author yangf073
 * @date 2023/10/30 22:50
 */
public class GetCoreNum {

    /**
     * 插槽：存放cpu芯片
     * 内核：CPU芯片上的处理器
     * 逻辑处理器：利用超线程技术，共享计算单元，将处理器衍生为两个逻辑的cpu用
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("逻辑处理器" + Runtime.getRuntime().availableProcessors());
    }
}
