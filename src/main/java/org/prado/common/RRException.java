package org.prado.common;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午4:45
 * @email 437547058@qq.com
 * @Version 1.0
 * 自定义运行时异常类
 */
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public RRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
