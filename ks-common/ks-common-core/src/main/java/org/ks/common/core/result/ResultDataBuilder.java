package org.ks.common.core.result;

/**
 * @ClassName: ResultDataBuilder
 * @Description:统一返回体构造器
 * @Author: yuzhipeng
 * @Date: 2019/9/5
 */

public class ResultDataBuilder<T> {

    private Integer code;

    private String message;

    private  T data;


    public ResultDataBuilder code(Integer code){
        this.code = code;
        return this;
    }

    public ResultDataBuilder message(String message){
        this.message = message;
        return this;
    }

    public ResultDataBuilder data(T data){
        this.data = data;
        return this;
    }

    public ResultData build(){
        return new ResultData(this.code,this.message,this.data);
    }

}
