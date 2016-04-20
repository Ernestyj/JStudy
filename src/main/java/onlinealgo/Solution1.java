package onlinealgo;

import java.util.ArrayList;

/**
 * Created by eugene on 16/4/8.
 */
public class Solution1 {

    public static void main(String[] args) {

    }

    //商品
    class Item{
        double price;
        int count;
        Item(int price, int mount){
            this.price = price;
            this.count = mount;
        }
        double totalPrice(){
            return price*count;
        }
    }
    //红包或满包邮优惠券
    class Coupon{
        double least;
        double ret;
        Coupon(){}
        Coupon(double least, double ret){
            this.least = least;
            this.ret = ret;
        }
    }
    //输入:cart, 按商家排列的商品列表; coupons, 按商家排列的优惠券列表
    //输出:couponCombinition, 优惠券组合
    public ArrayList<Coupon> comput(ArrayList<ArrayList<Item>> cart, ArrayList<ArrayList<Coupon>> coupons){
        //1. 按不同店铺组织商品，计算每个商铺的购买商品总价；
        double[] totals = new double[cart.size()];
        for (int i=0; i<cart.size(); i++){
            for (Item item: cart.get(i)){
                totals[i] += item.totalPrice();
            }
        }
        //2. 在每个商铺的购买总价基础上，根据每个商铺的优惠券类型，计算优惠价格
        ArrayList<Coupon> couponCombinition = new ArrayList<>();
        for (int i=0; i<coupons.size(); i++){
            Coupon maxCoupon = new Coupon();
            for (Coupon coupon: coupons.get(i)){
                if (totals[i]>coupon.least){
                    //3. 每个商铺选取满包邮、红包优惠方式中优惠价格最多的，作为推荐优惠券。
                    if (coupon.ret>maxCoupon.ret) maxCoupon = coupon;
                }
            }
            couponCombinition.add(maxCoupon);
        }
        return couponCombinition;
    }


//    public static void writeToHDFS(){
//        Configuration configuration = new Configuration();
//        FileSystem hdfs = FileSystem.get(new URI( "hdfs://localhost:80" ), configuration);
//        Path file = new Path("hdfs://localhost:80/user/test");
//        if (hdfs.exists(file)) {
//            hdfs.delete( file, true );
//        }
//        OutputStream os = hdfs.create(file,
//                new Progressable() {
//                    public void progress() {
//                        out.println("...bytes written: [ "+bytesWritten+" ]");
//                    }
//                }
//        );
//        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//        br.write("Hello World");
//        br.close();
//        hdfs.close();
//    }

    public static boolean solution(String S, String T) {
        return true;
    }

}
