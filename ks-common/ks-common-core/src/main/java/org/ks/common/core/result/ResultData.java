package org.ks.common.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: ResultData
 * @Description:统一返回体
 * @Author: yuzhipeng
 * @Date: 2019/9/5
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultData<T> implements Serializable {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public static <T> ResultDataBuilder builder(){return new ResultDataBuilder<T>();}

    /**
     * 请求成功
     * @return
     */
    public static ResultData sucess (){
        return builder().code(ResultCodeConstant.SUCCESS).build();
    }

    /**
     * 请求成功
     * @param message 消息
     * @return
     */
    public static ResultData sucess (String message){
        return builder().code(ResultCodeConstant.SUCCESS).message(message).build();
    }

    /**
     * 请求成功
     * @param message 消息
     * @param data 数据
     * @param <T>
     * @return
     */
    public static <T> ResultData sucess (String message,T data){
        return builder().code(ResultCodeConstant.SUCCESS).message(message).data(data).build();
    }

    /**
     * 请求失败
     * @return
     */
    public static ResultData failed (){
        return builder().code(ResultCodeConstant.FAILED).build();
    }

    /**
     * 请求失败
     * @param message
     * @return
     */
    public static ResultData failed (String message){
        return builder().code(ResultCodeConstant.FAILED).message(message).build();
    }


}
