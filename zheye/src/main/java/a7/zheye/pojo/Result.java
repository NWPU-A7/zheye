package a7.zheye.pojo;

/**
 * VO,视图对象，用来向前端传递消息
 */
public class Result {
    private Integer status;   //状态码
    private String result;       //返回信息
    private Object obj;       //数据

    private Result() {
    }

    public static Result build() {
        return new Result();
    }

    public static Result ok(String msg, Object obj) {
        return new Result(0, msg, obj);
    }

    public static Result ok(String msg) {
        return new Result(0, msg, null);
    }

    public static Result error(String msg, Object obj) {
        return new Result(-1, msg, obj);
    }

    public static Result error(String msg) {
        return new Result(-1, msg, null);
    }

    private Result(Integer status, String result, Object obj) {
        this.status = status;
        this.result = result;
        this.obj = obj;
    }

    public Integer getStatus() {

        return status;
    }

    public Result setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getResult() {
        return result;
    }

    public Result setResult(String result) {
        this.result = result;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public Result setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}