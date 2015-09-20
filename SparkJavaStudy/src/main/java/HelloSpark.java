import spark.Spark;

/**
 * Created by Jian on 2015/9/20.
 */
public class HelloSpark {
    public static void main(String args[]){
        Spark.get("/hello", (req, res) -> "Hello world!");
    }
}
