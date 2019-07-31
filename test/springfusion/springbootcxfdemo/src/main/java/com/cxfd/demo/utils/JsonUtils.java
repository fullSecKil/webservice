package com.cxfd.demo.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <b>Description:</b> json转换工具类 <br>
 * https://www.cnblogs.com/yuanmo396022993/p/9118308.html
 *
 * @author dusk
 * @since 2019/7/31 23:49
 */
public class JsonUtils {
    /**
     * 初始化变量
     */
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        // 解决实体未包含字段反序列化时抛出异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 对于空的对象转json的时候不抛出错误
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 允许属性名称没有引号
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    /**
     * 将object 转换为json，可以java的对象，可以是集合
     *
     * @param obj
     * @return
     */
    public static String objectToJson(Object obj) {
        String json = null;
        try {
            json = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T jsonToClass(String json, Class<T> type) {
        T t = null;
        try {
            t = mapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将json数据转换成Map
     *
     * @param json
     * @return
     */
    public static Map<String, Object> jsonToMap(String json) {
        Map<String, Object> map = null;
        try {
            map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将json数据转换成list
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String json, Class<T> type) {
        List<T> list = null;

        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, type);
            list = mapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取json对象数据的属性
     *
     * @param resData
     * @param resPro
     * @return
     */
    public static String findValue(String resData, String resPro) {
        String result = null;
        try {
            JsonNode node = mapper.readTree(resData);
            JsonNode resProNode = node.get(resPro);
            result = JsonUtils.objectToJson(resProNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
